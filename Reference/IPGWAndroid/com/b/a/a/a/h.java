package com.b.a.a.a;

public final class h {
    public static boolean a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int b(String str) {
        int i = 0;
        if (str.length() <= 0) {
            return 0;
        }
        char[] toCharArray = str.toCharArray();
        int i2 = 0;
        while (i < toCharArray.length) {
            i2 = (i2 * 31) + toCharArray[i];
            i++;
        }
        return i2;
    }
}
