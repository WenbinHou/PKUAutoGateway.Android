package android.support.a.a;

import java.util.ArrayList;

final class f {
    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    private static void a(ArrayList<h> arrayList, char c, float[] fArr) {
        arrayList.add(new h(c, fArr));
    }

    static float[] a(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = i + 0;
        length = Math.min(i2, length + 0);
        Object obj = new float[i2];
        System.arraycopy(fArr, 0, obj, 0, length);
        return obj;
    }

    public static h[] a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a = a(str, i);
            String trim = str.substring(i2, a).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), b(trim));
            }
            i = a + 1;
            i2 = a;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public static h[] a(h[] hVarArr) {
        if (hVarArr == null) {
            return null;
        }
        h[] hVarArr2 = new h[hVarArr.length];
        for (int i = 0; i < hVarArr.length; i++) {
            hVarArr2[i] = new h();
        }
        return hVarArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float[] b(String str) {
        if (((str.charAt(0) == 'z' ? 1 : 0) | (str.charAt(0) == 'Z' ? 1 : 0)) != 0) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            g gVar = new g();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                gVar.b = false;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = i;
                while (i6 < str.length()) {
                    switch (str.charAt(i6)) {
                        case ' ':
                        case ',':
                            i5 = i4;
                            i3 = 1;
                            i4 = 0;
                            break;
                        case '-':
                            if (i6 != i && r5 == 0) {
                                gVar.b = true;
                                i5 = i4;
                                i3 = 1;
                                i4 = 0;
                                break;
                            }
                        case '.':
                            if (i4 != 0) {
                                gVar.b = true;
                                i5 = i4;
                                i3 = 1;
                                i4 = 0;
                                break;
                            }
                            i4 = 0;
                            i3 = i5;
                            i5 = 1;
                            break;
                        case 'E':
                        case 'e':
                            i3 = i5;
                            i5 = i4;
                            i4 = 1;
                            break;
                        default:
                            i3 = i5;
                            i5 = i4;
                            i4 = 0;
                            break;
                    }
                    if (i3 == 0) {
                        i6++;
                        int i7 = i4;
                        i4 = i5;
                        i5 = i3;
                        i3 = i7;
                    } else {
                        gVar.a = i6;
                        i5 = gVar.a;
                        if (i >= i5) {
                            i4 = i2 + 1;
                            fArr[i2] = Float.parseFloat(str.substring(i, i5));
                        } else {
                            i4 = i2;
                        }
                        if (gVar.b) {
                            i = i5 + 1;
                            i2 = i4;
                        } else {
                            i = i5;
                            i2 = i4;
                        }
                    }
                }
                gVar.a = i6;
                i5 = gVar.a;
                if (i >= i5) {
                    i4 = i2;
                } else {
                    i4 = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i, i5));
                }
                if (gVar.b) {
                    i = i5 + 1;
                    i2 = i4;
                } else {
                    i = i5;
                    i2 = i4;
                }
            }
            return a(fArr, i2);
        } catch (Throwable e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }
}
