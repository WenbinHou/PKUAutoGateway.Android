package c;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class f implements g, h, Cloneable {
    private static final byte[] c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    u a;
    public long b;

    private String a(long j, Charset charset) {
        aa.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            u uVar = this.a;
            if (((long) uVar.b) + j > ((long) uVar.c)) {
                return new String(e(j), charset);
            }
            String str = new String(uVar.a, uVar.b, (int) j, charset);
            uVar.b = (int) (((long) uVar.b) + j);
            this.b -= j;
            if (uVar.b != uVar.c) {
                return str;
            }
            this.a = uVar.a();
            v.a(uVar);
            return str;
        }
    }

    private void c(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int i2;
            int length = bArr.length - i;
            aa.a((long) bArr.length, (long) i, (long) length);
            u uVar = this.a;
            if (uVar == null) {
                i2 = -1;
            } else {
                i2 = Math.min(length, uVar.c - uVar.b);
                System.arraycopy(uVar.a, uVar.b, bArr, i, i2);
                uVar.b += i2;
                this.b -= (long) i2;
                if (uVar.b == uVar.c) {
                    this.a = uVar.a();
                    v.a(uVar);
                }
            }
            if (i2 == -1) {
                throw new EOFException();
            }
            i = i2 + i;
        }
    }

    private String k(long j) {
        return a(j, aa.a);
    }

    private f q() {
        f fVar = new f();
        if (this.b == 0) {
            return fVar;
        }
        fVar.a = new u(this.a);
        u uVar = fVar.a;
        u uVar2 = fVar.a;
        u uVar3 = fVar.a;
        uVar2.g = uVar3;
        uVar.f = uVar3;
        for (uVar = this.a.f; uVar != this.a; uVar = uVar.f) {
            fVar.a.g.a(new u(uVar));
        }
        fVar.b = this.b;
        return fVar;
    }

    public final long a(byte b) {
        return a(b, 0);
    }

    public final long a(byte b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        u uVar = this.a;
        if (uVar == null) {
            return -1;
        }
        u uVar2 = uVar;
        long j2 = 0;
        do {
            int i = uVar2.c - uVar2.b;
            if (j >= ((long) i)) {
                j -= (long) i;
            } else {
                byte[] bArr = uVar2.a;
                int i2 = uVar2.c;
                for (int i3 = (int) (((long) uVar2.b) + j); i3 < i2; i3++) {
                    if (bArr[i3] == b) {
                        return (j2 + ((long) i3)) - ((long) uVar2.b);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            uVar2 = uVar2.f;
        } while (uVar2 != this.a);
        return -1;
    }

    public final long a(f fVar, long j) {
        if (fVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b == 0) {
            return -1;
        } else {
            if (j > this.b) {
                j = this.b;
            }
            fVar.a_(this, j);
            return j;
        }
    }

    public final long a(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = xVar.a(this, 2048);
            if (a == -1) {
                return j;
            }
            j += a;
        }
    }

    public final f a(int i) {
        if (i < 128) {
            b(i);
        } else if (i < 2048) {
            b((i >> 6) | 192);
            b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                b((i >> 12) | 224);
                b(((i >> 6) & 63) | 128);
                b((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            b((i >> 18) | 240);
            b(((i >> 12) & 63) | 128);
            b(((i >> 6) & 63) | 128);
            b((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public final f a(f fVar, long j, long j2) {
        if (fVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        aa.a(this.b, j, j2);
        if (j2 != 0) {
            fVar.b += j2;
            u uVar = this.a;
            while (j >= ((long) (uVar.c - uVar.b))) {
                j -= (long) (uVar.c - uVar.b);
                uVar = uVar.f;
            }
            while (j2 > 0) {
                u uVar2 = new u(uVar);
                uVar2.b = (int) (((long) uVar2.b) + j);
                uVar2.c = Math.min(uVar2.b + ((int) j2), uVar2.c);
                if (fVar.a == null) {
                    uVar2.g = uVar2;
                    uVar2.f = uVar2;
                    fVar.a = uVar2;
                } else {
                    fVar.a.g.a(uVar2);
                }
                j2 -= (long) (uVar2.c - uVar2.b);
                uVar = uVar.f;
                j = 0;
            }
        }
        return this;
    }

    public final f a(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        a(iVar.c, 0, iVar.c.length);
        return this;
    }

    public final f a(String str) {
        return a(str, 0, str.length());
    }

    public final f a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                char charAt = str.charAt(i);
                int i3;
                if (charAt < '') {
                    int i4;
                    u e = e(1);
                    byte[] bArr = e.a;
                    int i5 = e.c - i;
                    int min = Math.min(i2, 2048 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - e.c;
                    e.c += i4;
                    this.b += (long) i4;
                    i = i3;
                } else if (charAt < 'ࠀ') {
                    b((charAt >> 6) | 192);
                    b((charAt & 63) | 128);
                    i++;
                } else if (charAt < '?' || charAt > '?') {
                    b((charAt >> 12) | 224);
                    b(((charAt >> 6) & 63) | 128);
                    b((charAt & 63) | 128);
                    i++;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '?' || i3 < 56320 || i3 > 57343) {
                        b(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        b((i3 >> 18) | 240);
                        b(((i3 >> 12) & 63) | 128);
                        b(((i3 >> 6) & 63) | 128);
                        b((i3 & 63) | 128);
                        i += 2;
                    }
                }
            }
            return this;
        }
    }

    public final f a(byte[] bArr) {
        if (bArr != null) {
            return a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public final f a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        aa.a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            u e = e(1);
            int min = Math.min(i3 - i, 2048 - e.c);
            System.arraycopy(bArr, i, e.a, e.c, min);
            i += min;
            e.c = min + e.c;
        }
        this.b += (long) i2;
        return this;
    }

    public final y a() {
        return y.b;
    }

    public final void a(long j) {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public final void a_(f fVar, long j) {
        if (fVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (fVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            aa.a(fVar.b, 0, j);
            while (j > 0) {
                u uVar;
                u uVar2;
                if (j < ((long) (fVar.a.c - fVar.a.b))) {
                    uVar = this.a != null ? this.a.g : null;
                    if (uVar != null && uVar.e) {
                        if ((((long) uVar.c) + j) - ((long) (uVar.d ? 0 : uVar.b)) <= 2048) {
                            fVar.a.a(uVar, (int) j);
                            fVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    uVar2 = fVar.a;
                    int i = (int) j;
                    if (i <= 0 || i > uVar2.c - uVar2.b) {
                        throw new IllegalArgumentException();
                    }
                    u uVar3 = new u(uVar2);
                    uVar3.c = uVar3.b + i;
                    uVar2.b = i + uVar2.b;
                    uVar2.g.a(uVar3);
                    fVar.a = uVar3;
                }
                uVar2 = fVar.a;
                long j2 = (long) (uVar2.c - uVar2.b);
                fVar.a = uVar2.a();
                if (this.a == null) {
                    this.a = uVar2;
                    uVar2 = this.a;
                    uVar = this.a;
                    u uVar4 = this.a;
                    uVar.g = uVar4;
                    uVar2.f = uVar4;
                } else {
                    uVar = this.a.g.a(uVar2);
                    if (uVar.g == uVar) {
                        throw new IllegalStateException();
                    } else if (uVar.g.e) {
                        int i2 = uVar.c - uVar.b;
                        if (i2 <= (uVar.g.d ? 0 : uVar.g.b) + (2048 - uVar.g.c)) {
                            uVar.a(uVar.g, i2);
                            uVar.a();
                            v.a(uVar);
                        }
                    }
                }
                fVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        }
    }

    public final byte b(long j) {
        aa.a(this.b, j, 1);
        u uVar = this.a;
        while (true) {
            int i = uVar.c - uVar.b;
            if (j < ((long) i)) {
                return uVar.a[uVar.b + ((int) j)];
            }
            j -= (long) i;
            uVar = uVar.f;
        }
    }

    public final f b() {
        return this;
    }

    public final f b(int i) {
        u e = e(1);
        byte[] bArr = e.a;
        int i2 = e.c;
        e.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    public final /* synthetic */ g b(i iVar) {
        return a(iVar);
    }

    public final /* synthetic */ g b(String str) {
        return a(str);
    }

    public final /* synthetic */ g b(byte[] bArr) {
        return a(bArr);
    }

    public final /* synthetic */ g b(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2);
    }

    public final f c(int i) {
        u e = e(2);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.c = i2;
        this.b += 2;
        return this;
    }

    public final g c() {
        return this;
    }

    public final i c(long j) {
        return new i(e(j));
    }

    public final /* synthetic */ Object clone() {
        return q();
    }

    public final void close() {
    }

    public final f d(int i) {
        u e = e(4);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.c = i2;
        this.b += 4;
        return this;
    }

    final String d(long j) {
        if (j <= 0 || b(j - 1) != (byte) 13) {
            String k = k(j);
            f(1);
            return k;
        }
        k = k(j - 1);
        f(2);
        return k;
    }

    public final boolean d() {
        return this.b == 0;
    }

    public final byte e() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        u uVar = this.a;
        int i = uVar.b;
        int i2 = uVar.c;
        int i3 = i + 1;
        byte b = uVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = uVar.a();
            v.a(uVar);
        } else {
            uVar.b = i3;
        }
        return b;
    }

    final u e(int i) {
        if (i <= 0 || i > 2048) {
            throw new IllegalArgumentException();
        } else if (this.a == null) {
            this.a = v.a();
            u uVar = this.a;
            u uVar2 = this.a;
            r0 = this.a;
            uVar2.g = r0;
            uVar.f = r0;
            return r0;
        } else {
            r0 = this.a.g;
            return (r0.c + i > 2048 || !r0.e) ? r0.a(v.a()) : r0;
        }
    }

    public final byte[] e(long j) {
        aa.a(this.b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        c(bArr);
        return bArr;
    }

    public final boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.b != fVar.b) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        u uVar = this.a;
        u uVar2 = fVar.a;
        int i = uVar.b;
        int i2 = uVar2.b;
        while (j < this.b) {
            long min = (long) Math.min(uVar.c - i, uVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = uVar.a[i];
                i = i2 + 1;
                if (b != uVar2.a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == uVar.c) {
                uVar = uVar.f;
                i = uVar.b;
            }
            if (i2 == uVar2.c) {
                uVar2 = uVar2.f;
                i2 = uVar2.b;
            }
            j += min;
        }
        return true;
    }

    public final /* synthetic */ g f(int i) {
        return d(i);
    }

    public final short f() {
        if (this.b < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        u uVar = this.a;
        int i = uVar.b;
        int i2 = uVar.c;
        if (i2 - i < 2) {
            return (short) (((e() & 255) << 8) | (e() & 255));
        }
        byte[] bArr = uVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b -= 2;
        if (i4 == i2) {
            this.a = uVar.a();
            v.a(uVar);
        } else {
            uVar.b = i4;
        }
        return (short) i;
    }

    public final void f(long j) {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.a.c - this.a.b));
            this.b -= (long) min;
            j -= (long) min;
            u uVar = this.a;
            uVar.b = min + uVar.b;
            if (this.a.b == this.a.c) {
                u uVar2 = this.a;
                this.a = uVar2.a();
                v.a(uVar2);
            }
        }
    }

    public final void flush() {
    }

    public final int g() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        u uVar = this.a;
        int i = uVar.b;
        int i2 = uVar.c;
        if (i2 - i < 4) {
            return ((((e() & 255) << 24) | ((e() & 255) << 16)) | ((e() & 255) << 8)) | (e() & 255);
        }
        byte[] bArr = uVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.b -= 4;
        if (i4 == i2) {
            this.a = uVar.a();
            v.a(uVar);
            return i;
        }
        uVar.b = i4;
        return i;
    }

    public final f g(long j) {
        if (j == 0) {
            return b(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return a("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        u e = e(i);
        byte[] bArr = e.a;
        int i2 = e.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        e.c += i;
        this.b = ((long) i) + this.b;
        return this;
    }

    public final /* synthetic */ g g(int i) {
        return c(i);
    }

    public final f h(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        u e = e(numberOfTrailingZeros);
        byte[] bArr = e.a;
        int i = e.c;
        for (int i2 = (e.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        e.c += numberOfTrailingZeros;
        this.b = ((long) numberOfTrailingZeros) + this.b;
        return this;
    }

    public final /* synthetic */ g h(int i) {
        return b(i);
    }

    public final short h() {
        return aa.a(f());
    }

    public final int hashCode() {
        u uVar = this.a;
        if (uVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = uVar.b;
            while (i2 < uVar.c) {
                int i3 = uVar.a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            uVar = uVar.f;
        } while (uVar != this.a);
        return i;
    }

    public final int i() {
        return aa.a(g());
    }

    public final /* synthetic */ g i(long j) {
        return h(j);
    }

    public final long j() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        do {
            u uVar = this.a;
            byte[] bArr = uVar.a;
            int i2 = uVar.b;
            int i3 = uVar.c;
            int i4 = i2;
            while (i4 < i3) {
                byte b = bArr[i4];
                if (b >= (byte) 48 && b <= (byte) 57) {
                    i2 = b - 48;
                } else if (b >= (byte) 97 && b <= (byte) 102) {
                    i2 = (b - 97) + 10;
                } else if (b < (byte) 65 || b > (byte) 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.a = uVar.a();
                            v.a(uVar);
                        } else {
                            uVar.b = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                } else {
                    i2 = (b - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new f().h(j).b((int) b).l());
                }
                i++;
                i4++;
                j = ((long) i2) | (j << 4);
            }
            if (i4 != i3) {
                uVar.b = i4;
            } else {
                this.a = uVar.a();
                v.a(uVar);
            }
            if (obj == null) {
                break;
            }
        } while (this.a != null);
        this.b -= (long) i;
        return j;
    }

    public final /* synthetic */ g j(long j) {
        return g(j);
    }

    public final i k() {
        return new i(n());
    }

    public final String l() {
        try {
            return a(this.b, aa.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String m() {
        long a = a((byte) 10, 0);
        if (a != -1) {
            return d(a);
        }
        f fVar = new f();
        a(fVar, 0, Math.min(32, this.b));
        throw new EOFException("\\n not found: size=" + this.b + " content=" + fVar.k().b() + "...");
    }

    public final byte[] n() {
        try {
            return e(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void o() {
        try {
            f(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final /* bridge */ /* synthetic */ g p() {
        return this;
    }

    public final String toString() {
        if (this.b == 0) {
            return "Buffer[size=0]";
        }
        if (this.b <= 16) {
            i k = q().k();
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.b), k.b()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.a.a, this.a.b, this.a.c - this.a.b);
            for (u uVar = this.a.f; uVar != this.a; uVar = uVar.f) {
                instance.update(uVar.a, uVar.b, uVar.c - uVar.b);
            }
            return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.b), i.a(instance.digest()).b()});
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }
}
