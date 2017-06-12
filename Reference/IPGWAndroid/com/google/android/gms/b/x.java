package com.google.android.gms.b;

import java.security.MessageDigest;

@fd
public final class x extends r {
    private MessageDigest b;

    public final byte[] a(String str) {
        byte[] bArr;
        String[] split = str.split(" ");
        byte[] bArr2 = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            int a = w.a(split[i]);
            bArr2[i] = (byte) (((a & -16777216) >> 24) ^ (((a & 255) ^ ((65280 & a) >> 8)) ^ ((16711680 & a) >> 16)));
        }
        this.b = a();
        synchronized (this.a) {
            if (this.b == null) {
                bArr = new byte[0];
            } else {
                this.b.reset();
                this.b.update(bArr2);
                Object digest = this.b.digest();
                bArr = new byte[(digest.length > 4 ? 4 : digest.length)];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }
}
