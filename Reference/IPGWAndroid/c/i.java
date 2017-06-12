package c;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class i implements Serializable, Comparable<i> {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final i b = a(new byte[0]);
    public final byte[] c;
    transient int d;
    transient String e;

    i(byte[] bArr) {
        this.c = bArr;
    }

    public static i a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        i iVar = new i(str.getBytes(aa.a));
        iVar.e = str;
        return iVar;
    }

    public static i a(byte... bArr) {
        if (bArr != null) {
            return new i((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private i b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public final String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        str = new String(this.c, aa.a);
        this.e = str;
        return str;
    }

    public final String b() {
        int i = 0;
        char[] cArr = new char[(this.c.length * 2)];
        byte[] bArr = this.c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public final i c() {
        int i = 0;
        while (i < this.c.length) {
            byte b = this.c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.c.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b + 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i] = (byte) (b2 + 32);
                    }
                }
                return new i(bArr);
            }
        }
        return this;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int length = this.c.length;
        int length2 = iVar.c.length;
        int min = Math.min(length, length2);
        int i = 0;
        while (i < min) {
            int i2 = this.c[i] & 255;
            int i3 = iVar.c[i] & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            } else {
                i++;
            }
        }
        return length == length2 ? 0 : length >= length2 ? 1 : -1;
    }

    public final byte[] d() {
        return (byte[]) this.c.clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof i) && ((i) obj).c.length == this.c.length) {
            i iVar = (i) obj;
            byte[] bArr = this.c;
            int length = this.c.length;
            Object obj2 = (iVar.c.length - length < 0 || bArr.length - length < 0 || !aa.a(iVar.c, bArr, length)) ? null : 1;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.c);
        this.d = i;
        return i;
    }

    public final String toString() {
        if (this.c.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.c.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(this.c.length), b()});
        }
        return String.format("ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(this.c.length), b("MD5").b()});
    }
}
