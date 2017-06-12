package com.alipay.sdk.d;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class b {
    public static String a(int i, String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher instance = Cipher.getInstance("DES");
            instance.init(i, secretKeySpec);
            byte[] doFinal = instance.doFinal(i == 2 ? a.a(str) : str.getBytes("UTF-8"));
            return i == 2 ? new String(doFinal) : a.a(doFinal);
        } catch (Exception e) {
            return null;
        }
    }
}
