package com.google.android.gms.b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class r {
    private static MessageDigest b = null;
    protected Object a = new Object();

    protected final MessageDigest a() {
        MessageDigest messageDigest;
        synchronized (this.a) {
            if (b != null) {
                messageDigest = b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        b = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = b;
            }
        }
        return messageDigest;
    }

    abstract byte[] a(String str);
}
