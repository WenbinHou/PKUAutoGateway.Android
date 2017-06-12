package com.b.a.a.a;

final class e extends c {
    static final /* synthetic */ boolean j = (!b.class.desiredAssertionStatus());
    private static final byte[] k = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] l = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    final byte[] c;
    int d;
    int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    final byte[] i;

    public e(int i) {
        boolean z = true;
        this.a = null;
        this.f = (i & 1) == 0;
        this.g = (i & 2) == 0;
        if ((i & 4) == 0) {
            z = false;
        }
        this.h = z;
        this.i = (i & 8) == 0 ? k : l;
        this.c = new byte[2];
        this.d = 0;
        this.e = this.g ? 19 : -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        byte[] bArr2 = this.i;
        byte[] bArr3 = this.a;
        int i7 = this.e;
        int i8 = i + 0;
        switch (this.d) {
            case 0:
                i2 = -1;
                i3 = 0;
                break;
            case 1:
                if (2 <= i8) {
                    i3 = (((this.c[0] & 255) << 16) | ((bArr[0] & 255) << 8)) | (bArr[1] & 255);
                    this.d = 0;
                    i2 = i3;
                    i3 = 2;
                    break;
                }
            case 2:
                if (i8 > 0) {
                    i3 = (((this.c[0] & 255) << 16) | ((this.c[1] & 255) << 8)) | (bArr[0] & 255);
                    this.d = 0;
                    i2 = i3;
                    i3 = 1;
                    break;
                }
            default:
                i2 = -1;
                i3 = 0;
                break;
        }
        if (i2 != -1) {
            bArr3[0] = bArr2[(i2 >> 18) & 63];
            bArr3[1] = bArr2[(i2 >> 12) & 63];
            bArr3[2] = bArr2[(i2 >> 6) & 63];
            i4 = 4;
            bArr3[3] = bArr2[i2 & 63];
            i7--;
            if (i7 == 0) {
                if (this.h) {
                    i4 = 5;
                    bArr3[4] = (byte) 13;
                }
                i2 = i4 + 1;
                bArr3[i4] = (byte) 10;
                i5 = 19;
            } else {
                i5 = i7;
                i2 = 4;
            }
        } else {
            i5 = i7;
            i2 = 0;
        }
        while (i3 + 3 <= i8) {
            i4 = (((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8)) | (bArr[i3 + 2] & 255);
            bArr3[i2] = bArr2[(i4 >> 18) & 63];
            bArr3[i2 + 1] = bArr2[(i4 >> 12) & 63];
            bArr3[i2 + 2] = bArr2[(i4 >> 6) & 63];
            bArr3[i2 + 3] = bArr2[i4 & 63];
            i7 = i3 + 3;
            i3 = i2 + 4;
            i4 = i5 - 1;
            if (i4 == 0) {
                if (this.h) {
                    i4 = i3 + 1;
                    bArr3[i3] = (byte) 13;
                } else {
                    i4 = i3;
                }
                i2 = i4 + 1;
                bArr3[i4] = (byte) 10;
                i3 = i7;
                i5 = 19;
            } else {
                i5 = i4;
                i2 = i3;
                i3 = i7;
            }
        }
        if (i3 - this.d == i8 - 1) {
            if (this.d > 0) {
                i4 = this.c[0];
                i6 = i3;
                i3 = 1;
            } else {
                i7 = i3 + 1;
                i4 = bArr[i3];
                i3 = 0;
                i6 = i7;
            }
            i7 = (i4 & 255) << 4;
            this.d -= i3;
            i3 = i2 + 1;
            bArr3[i2] = bArr2[(i7 >> 6) & 63];
            i4 = i3 + 1;
            bArr3[i3] = bArr2[i7 & 63];
            if (this.f) {
                i3 = i4 + 1;
                bArr3[i4] = (byte) 61;
                i4 = i3 + 1;
                bArr3[i3] = (byte) 61;
            }
            if (this.g) {
                if (this.h) {
                    i3 = i4 + 1;
                    bArr3[i4] = (byte) 13;
                    i4 = i3;
                }
                i3 = i4 + 1;
                bArr3[i4] = (byte) 10;
                i4 = i3;
            }
            i3 = i6;
            i2 = i4;
        } else if (i3 - this.d == i8 - 2) {
            if (this.d > 1) {
                i4 = this.c[0];
                i6 = 1;
            } else {
                i7 = i3 + 1;
                i4 = bArr[i3];
                i3 = i7;
            }
            int i9 = (i4 & 255) << 10;
            if (this.d > 0) {
                i7 = i6 + 1;
                i4 = this.c[i6];
                i6 = i7;
            } else {
                i7 = i3 + 1;
                i4 = bArr[i3];
                i3 = i7;
            }
            i4 = ((i4 & 255) << 2) | i9;
            this.d -= i6;
            i6 = i2 + 1;
            bArr3[i2] = bArr2[(i4 >> 12) & 63];
            i7 = i6 + 1;
            bArr3[i6] = bArr2[(i4 >> 6) & 63];
            i6 = i7 + 1;
            bArr3[i7] = bArr2[i4 & 63];
            if (this.f) {
                i4 = i6 + 1;
                bArr3[i6] = (byte) 61;
            } else {
                i4 = i6;
            }
            if (this.g) {
                if (this.h) {
                    i6 = i4 + 1;
                    bArr3[i4] = (byte) 13;
                    i4 = i6;
                }
                i6 = i4 + 1;
                bArr3[i4] = (byte) 10;
                i4 = i6;
            }
            i2 = i4;
        } else if (this.g && i2 > 0 && i5 != 19) {
            if (this.h) {
                i4 = i2 + 1;
                bArr3[i2] = (byte) 13;
            } else {
                i4 = i2;
            }
            i2 = i4 + 1;
            bArr3[i4] = (byte) 10;
        }
        if (!j && this.d != 0) {
            throw new AssertionError();
        } else if (j || r1 == i8) {
            this.b = i2;
            this.e = i5;
            return true;
        } else {
            throw new AssertionError();
        }
    }
}
