package com.a.a;

import android.util.Base64;
import java.util.Arrays;

public final class b {
    final byte[] a;
    final byte[] b;
    final byte[] c;

    public b(String str) {
        String[] split = str.split(":");
        if (split.length != 3) {
            throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        }
        this.b = Base64.decode(split[0], 2);
        this.c = Base64.decode(split[1], 2);
        this.a = Base64.decode(split[2], 2);
    }

    public b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = a.a(bArr, 0, bArr.length);
        this.b = a.a(bArr2, 0, bArr2.length);
        this.c = a.a(bArr3, 0, bArr3.length);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        Object obj = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
        return obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return !Arrays.equals(this.a, bVar.a) ? false : !Arrays.equals(this.b, bVar.b) ? false : Arrays.equals(this.c, bVar.c);
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.a) + 31) * 31) + Arrays.hashCode(this.b)) * 31) + Arrays.hashCode(this.c);
    }

    public final String toString() {
        String encodeToString = Base64.encodeToString(this.b, 2);
        return String.format(encodeToString + ":" + Base64.encodeToString(this.c, 2) + ":" + Base64.encodeToString(this.a, 2), new Object[0]);
    }
}
