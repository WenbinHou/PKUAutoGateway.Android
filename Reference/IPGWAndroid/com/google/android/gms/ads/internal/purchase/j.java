package com.google.android.gms.ads.internal.purchase;

import android.util.Base64;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.fd;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

@fd
public final class j {
    public static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            b.b("Invalid key specification.");
            throw new IllegalArgumentException(e2);
        }
    }

    public static boolean a(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2, 0))) {
                return true;
            }
            b.b("Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            b.b("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            b.b("Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            b.b("Signature exception.");
            return false;
        }
    }
}
