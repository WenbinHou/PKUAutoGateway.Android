package com.a.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

public final class c {
    private static final byte[] a = e();

    private c() {
    }

    public static void a() {
        if (VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 18) {
            try {
                Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[]{byte[].class}).invoke(null, new Object[]{c()});
                int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[]{String.class, Long.TYPE}).invoke(null, new Object[]{"/dev/urandom", Integer.valueOf(1024)})).intValue();
                if (intValue != 1024) {
                    throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
                }
            } catch (Throwable e) {
                throw new SecurityException("Failed to seed OpenSSL PRNG", e);
            }
        }
        if (VERSION.SDK_INT <= 18) {
            Provider[] providers = Security.getProviders("SecureRandom.SHA1PRNG");
            if (providers == null || providers.length <= 0 || !e.class.equals(providers[0].getClass())) {
                Security.insertProviderAt(new e(), 1);
            }
            SecureRandom secureRandom = new SecureRandom();
            if (e.class.equals(secureRandom.getProvider().getClass())) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    if (!e.class.equals(secureRandom.getProvider().getClass())) {
                        throw new SecurityException("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: " + secureRandom.getProvider().getClass());
                    }
                    return;
                } catch (Throwable e2) {
                    throw new SecurityException("SHA1PRNG not available", e2);
                }
            }
            throw new SecurityException("new SecureRandom() backed by wrong Provider: " + secureRandom.getProvider().getClass());
        }
    }

    private static byte[] c() {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.writeLong(System.nanoTime());
            dataOutputStream.writeInt(Process.myPid());
            dataOutputStream.writeInt(Process.myUid());
            dataOutputStream.write(a);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new SecurityException("Failed to generate seed", e);
        }
    }

    private static String d() {
        try {
            return (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] e() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = Build.FINGERPRINT;
        if (str != null) {
            stringBuilder.append(str);
        }
        str = d();
        if (str != null) {
            stringBuilder.append(str);
        }
        try {
            return stringBuilder.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }
}
