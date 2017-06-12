package com.a.a;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

final class a {
    private static final AtomicBoolean a = new AtomicBoolean(false);

    public static b a(byte[] bArr, f fVar) {
        byte[] a = a(16);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, fVar.a, new IvParameterSpec(a));
        a = instance.getIV();
        byte[] doFinal = instance.doFinal(bArr);
        return new b(doFinal, a, a(b.a(a, doFinal), fVar.b));
    }

    public static f a() {
        c();
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128);
        return new f(instance.generateKey(), new SecretKeySpec(a(32), "HmacSHA256"));
    }

    public static f a(String str) {
        String[] split = str.split(":");
        if (split.length != 2) {
            throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
        }
        byte[] decode = Base64.decode(split[0], 2);
        if (decode.length != 16) {
            throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        byte[] decode2 = Base64.decode(split[1], 2);
        if (decode2.length == 32) {
            return new f(new SecretKeySpec(decode, 0, decode.length, "AES"), new SecretKeySpec(decode2, "HmacSHA256"));
        }
        throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
    }

    public static f a(String str, String str2) {
        return a(str, Base64.decode(str2, 2));
    }

    private static f a(String str, byte[] bArr) {
        c();
        byte[] encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 10000, 384)).getEncoded();
        return new f(new SecretKeySpec(a(encoded, 0, 16), "AES"), new SecretKeySpec(a(encoded, 16, 48), "HmacSHA256"));
    }

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    private static byte[] a(int i) {
        c();
        byte[] bArr = new byte[i];
        SecureRandom.getInstance("SHA1PRNG", "Crypto").nextBytes(bArr);
        return bArr;
    }

    public static byte[] a(b bVar, f fVar) {
        Object obj = null;
        byte[] a = a(b.a(bVar.b, bVar.a), fVar.b);
        byte[] bArr = bVar.c;
        if (a.length == bArr.length) {
            int i = 0;
            for (int i2 = 0; i2 < a.length; i2++) {
                i |= a[i2] ^ bArr[i2];
            }
            if (i == 0) {
                obj = 1;
            }
        }
        if (obj != null) {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, fVar.a, new IvParameterSpec(bVar.b));
            return instance.doFinal(bVar.a);
        }
        throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        Object obj = new byte[i3];
        System.arraycopy(bArr, i, obj, 0, i3);
        return obj;
    }

    private static byte[] a(byte[] bArr, SecretKey secretKey) {
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKey);
        return instance.doFinal(bArr);
    }

    public static byte[] b() {
        return a(128);
    }

    private static void c() {
        if (!a.get()) {
            synchronized (c.class) {
                if (!a.get()) {
                    c.a();
                    a.set(true);
                }
            }
        }
    }
}
