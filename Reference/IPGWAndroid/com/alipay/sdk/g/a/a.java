package com.alipay.sdk.g.a;

public final class a {
    private static char a = '=';
    private static byte[] b = new byte[128];
    private static char[] c = new char[64];

    static {
        int i;
        int i2 = 0;
        for (i = 0; i < 128; i++) {
            b[i] = (byte) -1;
        }
        for (i = 90; i >= 65; i--) {
            b[i] = (byte) (i - 65);
        }
        for (i = 122; i >= 97; i--) {
            b[i] = (byte) ((i - 97) + 26);
        }
        for (i = 57; i >= 48; i--) {
            b[i] = (byte) ((i - 48) + 52);
        }
        b[43] = (byte) 62;
        b[47] = (byte) 63;
        for (i = 0; i <= 25; i++) {
            c[i] = (char) (i + 65);
        }
        int i3 = 26;
        i = 0;
        while (i3 <= 51) {
            c[i3] = (char) (i + 97);
            i3++;
            i++;
        }
        i = 52;
        while (i <= 61) {
            c[i] = (char) (i2 + 48);
            i++;
            i2++;
        }
        c[62] = '+';
        c[63] = '/';
    }

    public static String a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[((i2 != 0 ? i3 + 1 : i3) * 4)];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            length = i + 1;
            byte b = bArr[i];
            int i6 = length + 1;
            byte b2 = bArr[length];
            int i7 = i6 + 1;
            byte b3 = bArr[i6];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            if ((b & -128) == 0) {
                i6 = (byte) (b >> 2);
            } else {
                byte b6 = (byte) ((b >> 2) ^ 192);
            }
            if ((b2 & -128) == 0) {
                i = (byte) (b2 >> 4);
            } else {
                b = (byte) ((b2 >> 4) ^ 240);
            }
            length = (b3 & -128) == 0 ? (byte) (b3 >> 6) : (byte) ((b3 >> 6) ^ 252);
            int i8 = i5 + 1;
            cArr[i5] = c[i6];
            i6 = i8 + 1;
            cArr[i8] = c[i | (b5 << 4)];
            i5 = i6 + 1;
            cArr[i6] = c[length | (b4 << 2)];
            i = i5 + 1;
            cArr[i5] = c[b3 & 63];
            i4++;
            i5 = i;
            i = i7;
        }
        byte b7;
        byte b8;
        if (i2 == 8) {
            b7 = bArr[i];
            b8 = (byte) (b7 & 3);
            i = i5 + 1;
            cArr[i5] = c[(b7 & -128) == 0 ? (byte) (b7 >> 2) : (byte) ((b7 >> 2) ^ 192)];
            length = i + 1;
            cArr[i] = c[b8 << 4];
            i3 = length + 1;
            cArr[length] = a;
            cArr[i3] = a;
        } else if (i2 == 16) {
            b7 = bArr[i];
            b = bArr[i + 1];
            b6 = (byte) (b & 15);
            byte b9 = (byte) (b7 & 3);
            if ((b7 & -128) == 0) {
                i3 = (byte) (b7 >> 2);
            } else {
                b8 = (byte) ((b7 >> 2) ^ 192);
            }
            length = (b & -128) == 0 ? (byte) (b >> 4) : (byte) ((b >> 4) ^ 240);
            i = i5 + 1;
            cArr[i5] = c[i3];
            i3 = i + 1;
            cArr[i] = c[length | (b9 << 4)];
            length = i3 + 1;
            cArr[i3] = c[b6 << 2];
            cArr[length] = a;
        }
        return new String(cArr);
    }

    private static boolean a(char c) {
        return c == a;
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        int i;
        int length;
        int i2;
        int i3;
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            i = 0;
        } else {
            length = toCharArray.length;
            i2 = 0;
            i = 0;
            while (i2 < length) {
                char c = toCharArray[i2];
                i3 = (c == ' ' || c == '\r' || c == '\n' || c == '\t') ? 1 : 0;
                if (i3 == 0) {
                    i3 = i + 1;
                    toCharArray[i] = toCharArray[i2];
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
        }
        if (i % 4 != 0) {
            return null;
        }
        int i4 = i / 4;
        if (i4 == 0) {
            return new byte[0];
        }
        char c2;
        Object obj = new byte[(i4 * 3)];
        i = 0;
        i2 = 0;
        length = 0;
        while (length < i4 - 1) {
            int i5 = i + 1;
            char c3 = toCharArray[i];
            if (b(c3)) {
                i = i5 + 1;
                c2 = toCharArray[i5];
                if (b(c2)) {
                    int i6 = i + 1;
                    char c4 = toCharArray[i];
                    if (b(c4)) {
                        i = i6 + 1;
                        char c5 = toCharArray[i6];
                        if (b(c5)) {
                            byte b = b[c3];
                            byte b2 = b[c2];
                            byte b3 = b[c4];
                            byte b4 = b[c5];
                            int i7 = i2 + 1;
                            obj[i2] = (byte) ((b << 2) | (b2 >> 4));
                            int i8 = i7 + 1;
                            obj[i7] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i2 = i8 + 1;
                            obj[i8] = (byte) ((b3 << 6) | b4);
                            length++;
                        }
                    }
                }
            }
            return null;
        }
        i4 = i + 1;
        char c6 = toCharArray[i];
        if (b(c6)) {
            i5 = i4 + 1;
            char c7 = toCharArray[i4];
            if (b(c7)) {
                b = b[c6];
                byte b5 = b[c7];
                i = i5 + 1;
                c2 = toCharArray[i5];
                c6 = toCharArray[i];
                if (b(c2) && b(c6)) {
                    byte b6 = b[c2];
                    byte b7 = b[c6];
                    int i9 = i2 + 1;
                    obj[i2] = (byte) ((b << 2) | (b5 >> 4));
                    i2 = i9 + 1;
                    obj[i9] = (byte) (((b5 & 15) << 4) | ((b6 >> 2) & 15));
                    obj[i2] = (byte) (b7 | (b6 << 6));
                    return obj;
                } else if (a(c2) && a(c6)) {
                    if ((b5 & 15) != 0) {
                        return null;
                    }
                    r1 = new byte[((length * 3) + 1)];
                    System.arraycopy(obj, 0, r1, 0, length * 3);
                    r1[i2] = (byte) ((b << 2) | (b5 >> 4));
                    return r1;
                } else if (a(c2) || !a(c6)) {
                    return null;
                } else {
                    byte b8 = b[c2];
                    if ((b8 & 3) != 0) {
                        return null;
                    }
                    r1 = new byte[((length * 3) + 2)];
                    System.arraycopy(obj, 0, r1, 0, length * 3);
                    i3 = i2 + 1;
                    r1[i2] = (byte) ((b << 2) | (b5 >> 4));
                    r1[i3] = (byte) (((b5 & 15) << 4) | ((b8 >> 2) & 15));
                    return r1;
                }
            }
        }
        return null;
    }

    private static boolean b(char c) {
        return c < '' && b[c] != (byte) -1;
    }
}
