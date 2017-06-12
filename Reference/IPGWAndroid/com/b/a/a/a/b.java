package com.b.a.a.a;

import java.io.UnsupportedEncodingException;

public class b {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());

    private b() {
    }

    public static String a(byte[] bArr, int i) {
        try {
            int i2;
            int length = bArr.length;
            e eVar = new e(i);
            int i3 = (length / 3) * 4;
            if (!eVar.f) {
                switch (length % 3) {
                    case 0:
                        break;
                    case 1:
                        i3 += 2;
                        break;
                    case 2:
                        i3 += 3;
                        break;
                    default:
                        break;
                }
            } else if (length % 3 > 0) {
                i3 += 4;
            }
            if (!eVar.g || length <= 0) {
                i2 = i3;
            } else {
                i2 = ((eVar.h ? 2 : 1) * (((length - 1) / 57) + 1)) + i3;
            }
            eVar.a = new byte[i2];
            eVar.a(bArr, length);
            if (a || eVar.b == i2) {
                return new String(eVar.a, "US-ASCII");
            }
            throw new AssertionError();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        d dVar = new d(new byte[((length * 3) / 4)]);
        if (dVar.c == 6) {
            length = 0;
        } else {
            int i = length + 0;
            length = dVar.c;
            int i2 = dVar.d;
            byte[] bArr = dVar.a;
            int[] iArr = dVar.e;
            int i3 = 0;
            int i4 = length;
            length = 0;
            while (i3 < i) {
                if (i4 == 0) {
                    while (i3 + 4 <= i) {
                        i2 = (((iArr[bytes[i3] & 255] << 18) | (iArr[bytes[i3 + 1] & 255] << 12)) | (iArr[bytes[i3 + 2] & 255] << 6)) | iArr[bytes[i3 + 3] & 255];
                        if (i2 >= 0) {
                            bArr[length + 2] = (byte) i2;
                            bArr[length + 1] = (byte) (i2 >> 8);
                            bArr[length] = (byte) (i2 >> 16);
                            length += 3;
                            i3 += 4;
                        } else if (i3 >= i) {
                            i3 = i2;
                            switch (i4) {
                                case 1:
                                    dVar.c = 6;
                                    length = 0;
                                    break;
                                case 2:
                                    i2 = length + 1;
                                    bArr[length] = (byte) (i3 >> 4);
                                    length = i2;
                                    break;
                                case 3:
                                    i2 = length + 1;
                                    bArr[length] = (byte) (i3 >> 10);
                                    length = i2 + 1;
                                    bArr[i2] = (byte) (i3 >> 2);
                                    break;
                                case 4:
                                    dVar.c = 6;
                                    length = 0;
                                    break;
                            }
                            dVar.c = i4;
                            dVar.b = length;
                            length = 1;
                        }
                    }
                    if (i3 >= i) {
                        i3 = i2;
                        switch (i4) {
                            case 1:
                                dVar.c = 6;
                                length = 0;
                                break;
                            case 2:
                                i2 = length + 1;
                                bArr[length] = (byte) (i3 >> 4);
                                length = i2;
                                break;
                            case 3:
                                i2 = length + 1;
                                bArr[length] = (byte) (i3 >> 10);
                                length = i2 + 1;
                                bArr[i2] = (byte) (i3 >> 2);
                                break;
                            case 4:
                                dVar.c = 6;
                                length = 0;
                                break;
                        }
                        dVar.c = i4;
                        dVar.b = length;
                        length = 1;
                    }
                }
                int i5 = i3 + 1;
                i3 = iArr[bytes[i3] & 255];
                switch (i4) {
                    case 0:
                        if (i3 < 0) {
                            if (i3 != -1) {
                                dVar.c = 6;
                                length = 0;
                                break;
                            }
                        }
                        i4++;
                        i2 = i3;
                        i3 = i5;
                        break;
                        break;
                    case 1:
                        if (i3 < 0) {
                            if (i3 != -1) {
                                dVar.c = 6;
                                length = 0;
                                break;
                            }
                        }
                        i2 = (i2 << 6) | i3;
                        i4++;
                        i3 = i5;
                        break;
                        break;
                    case 2:
                        if (i3 < 0) {
                            if (i3 != -2) {
                                if (i3 != -1) {
                                    dVar.c = 6;
                                    length = 0;
                                    break;
                                }
                            }
                            i3 = length + 1;
                            bArr[length] = (byte) (i2 >> 4);
                            i4 = 4;
                            length = i3;
                            i3 = i5;
                            break;
                        }
                        i2 = (i2 << 6) | i3;
                        i4++;
                        i3 = i5;
                        break;
                        break;
                    case 3:
                        if (i3 < 0) {
                            if (i3 != -2) {
                                if (i3 != -1) {
                                    dVar.c = 6;
                                    length = 0;
                                    break;
                                }
                            }
                            bArr[length + 1] = (byte) (i2 >> 2);
                            bArr[length] = (byte) (i2 >> 10);
                            length += 2;
                            i4 = 5;
                            i3 = i5;
                            break;
                        }
                        i2 = (i2 << 6) | i3;
                        bArr[length + 2] = (byte) i2;
                        bArr[length + 1] = (byte) (i2 >> 8);
                        bArr[length] = (byte) (i2 >> 16);
                        length += 3;
                        i3 = i5;
                        i4 = 0;
                        break;
                        break;
                    case 4:
                        if (i3 != -2) {
                            if (i3 != -1) {
                                dVar.c = 6;
                                length = 0;
                                break;
                            }
                        }
                        i4++;
                        i3 = i5;
                        break;
                        break;
                    case 5:
                        if (i3 != -1) {
                            dVar.c = 6;
                            length = 0;
                            break;
                        }
                        break;
                }
            }
            i3 = i2;
            switch (i4) {
                case 1:
                    dVar.c = 6;
                    length = 0;
                    break;
                case 2:
                    i2 = length + 1;
                    bArr[length] = (byte) (i3 >> 4);
                    length = i2;
                    break;
                case 3:
                    i2 = length + 1;
                    bArr[length] = (byte) (i3 >> 10);
                    length = i2 + 1;
                    bArr[i2] = (byte) (i3 >> 2);
                    break;
                case 4:
                    dVar.c = 6;
                    length = 0;
                    break;
            }
            dVar.c = i4;
            dVar.b = length;
            length = 1;
        }
        if (length == 0) {
            throw new IllegalArgumentException("bad base-64");
        } else if (dVar.b == dVar.a.length) {
            return dVar.a;
        } else {
            Object obj = new byte[dVar.b];
            System.arraycopy(dVar.a, 0, obj, 0, dVar.b);
            return obj;
        }
    }
}
