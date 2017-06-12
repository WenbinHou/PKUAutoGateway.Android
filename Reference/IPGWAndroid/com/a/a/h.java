package com.a.a;

import android.util.Base64;

final class h implements m {
    h() {
    }

    private static String b(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 0);
        } catch (Exception e) {
            z.a(5, e.getMessage());
            return null;
        }
    }

    private static byte[] b(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (Exception e) {
            z.a(5, e.getMessage());
            return null;
        }
    }

    public final String a(byte[] bArr) {
        return b(bArr);
    }

    public final boolean a() {
        return true;
    }

    public final byte[] a(String str) {
        return b(str);
    }
}
