package b;

import b.a.o;
import c.f;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ab {
    String a;
    String b = "";
    String c = "";
    String d;
    int e = -1;
    final List<String> f = new ArrayList();
    List<String> g;
    String h;

    public ab() {
        this.f.add("");
    }

    static String a(String str, int i, int i2) {
        int i3 = 0;
        String a = aa.a(str, i, i2, false);
        if (!a.contains(":")) {
            return o.a(a);
        }
        InetAddress d = (a.startsWith("[") && a.endsWith("]")) ? d(a, 1, a.length() - 1) : d(a, 0, a.length());
        if (d == null) {
            return null;
        }
        byte[] address = d.getAddress();
        if (address.length == 16) {
            int i4 = 0;
            int i5 = -1;
            int i6 = 0;
            while (i6 < address.length) {
                int i7 = i6;
                while (i7 < 16 && address[i7] == (byte) 0 && address[i7 + 1] == (byte) 0) {
                    i7 += 2;
                }
                int i8 = i7 - i6;
                if (i8 > i4) {
                    i4 = i8;
                    i5 = i6;
                }
                i6 = i7 + 2;
            }
            f fVar = new f();
            while (i3 < address.length) {
                if (i3 == i5) {
                    fVar.b(58);
                    i3 += i4;
                    if (i3 == 16) {
                        fVar.b(58);
                    }
                } else {
                    if (i3 > 0) {
                        fVar.b(58);
                    }
                    fVar.h((long) (((address[i3] & 255) << 8) | (address[i3 + 1] & 255)));
                    i3 += 2;
                }
            }
            return fVar.l();
        }
        throw new AssertionError();
    }

    private void b(String str, int i, int i2) {
        if (i != i2) {
            int i3;
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i3 = i + 1;
            } else {
                this.f.set(this.f.size() - 1, "");
                i3 = i;
            }
            while (i3 < i2) {
                int a = o.a(str, i3, i2, "/\\");
                boolean z = a < i2;
                String a2 = aa.a(str, i3, a, " \"<>^`{}|/\\?#", true, false, false, true);
                boolean z2 = a2.equals(".") || a2.equalsIgnoreCase("%2e");
                if (!z2) {
                    z2 = a2.equals("..") || a2.equalsIgnoreCase("%2e.") || a2.equalsIgnoreCase(".%2e") || a2.equalsIgnoreCase("%2e%2e");
                    if (!z2) {
                        if (((String) this.f.get(this.f.size() - 1)).isEmpty()) {
                            this.f.set(this.f.size() - 1, a2);
                        } else {
                            this.f.add(a2);
                        }
                        if (z) {
                            this.f.add("");
                        }
                    } else if (!((String) this.f.remove(this.f.size() - 1)).isEmpty() || this.f.isEmpty()) {
                        this.f.add("");
                    } else {
                        this.f.set(this.f.size() - 1, "");
                    }
                }
                if (z) {
                    a++;
                }
                i3 = a;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int c(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            switch (str.charAt(i3)) {
                case ':':
                    return i3;
                case '[':
                    do {
                        i3++;
                        break;
                    } while (str.charAt(i3) != ']');
                    break;
                default:
                    break;
            }
            i3++;
        }
        return i2;
    }

    private static InetAddress d(String str, int i, int i2) {
        Object obj = new byte[16];
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = i;
        while (i6 < i2) {
            if (i3 == 16) {
                return null;
            }
            int i7;
            int i8;
            int i9;
            if (i6 + 2 > i2 || !str.regionMatches(i6, "::", 0, 2)) {
                if (i3 == 0) {
                    i7 = i4;
                    i4 = i3;
                    i3 = i6;
                    i6 = i7;
                } else if (str.regionMatches(i6, ":", 0, 1)) {
                    i7 = i4;
                    i4 = i3;
                    i3 = i6 + 1;
                    i6 = i7;
                } else if (!str.regionMatches(i6, ".", 0, 1)) {
                    return null;
                } else {
                    Object obj2;
                    int i10 = i3 - 2;
                    i8 = i10;
                    i6 = i5;
                    loop2:
                    while (i6 < i2) {
                        if (i8 == 16) {
                            obj2 = null;
                            break;
                        }
                        if (i8 != i10) {
                            if (str.charAt(i6) != '.') {
                                obj2 = null;
                                break;
                            }
                            i6++;
                        }
                        i9 = 0;
                        i5 = i6;
                        while (i5 < i2) {
                            char charAt = str.charAt(i5);
                            if (charAt >= '0' && charAt <= '9') {
                                if (i9 == 0 && i6 != i5) {
                                    obj2 = null;
                                    break loop2;
                                }
                                i9 = ((i9 * 10) + charAt) - 48;
                                if (i9 > 255) {
                                    obj2 = null;
                                    break loop2;
                                }
                                i5++;
                            } else {
                                break;
                            }
                        }
                        if (i5 - i6 == 0) {
                            obj2 = null;
                            break;
                        }
                        i6 = i8 + 1;
                        obj[i8] = (byte) i9;
                        i8 = i6;
                        i6 = i5;
                    }
                    obj2 = i8 != i10 + 4 ? null : 1;
                    if (obj2 == null) {
                        return null;
                    }
                    i6 = i3 + 2;
                }
            } else if (i4 != -1) {
                return null;
            } else {
                i4 = i6 + 2;
                i6 = i3 + 2;
                if (i4 == i2) {
                    i4 = i6;
                    break;
                }
                i3 = i4;
                i4 = i6;
            }
            i9 = 0;
            i5 = i3;
            while (i5 < i2) {
                i8 = aa.a(str.charAt(i5));
                if (i8 == -1) {
                    break;
                }
                i9 = (i9 << 4) + i8;
                i5++;
            }
            i8 = i5 - i3;
            if (i8 == 0 || i8 > 4) {
                return null;
            }
            i8 = i4 + 1;
            obj[i4] = (byte) ((i9 >>> 8) & 255);
            i4 = i8 + 1;
            obj[i8] = (byte) (i9 & 255);
            i7 = i3;
            i3 = i4;
            i4 = i6;
            i6 = i5;
            i5 = i7;
        }
        i6 = i3;
        if (i6 != 16) {
            if (i4 == -1) {
                return null;
            }
            System.arraycopy(obj, i4, obj, 16 - (i6 - i4), i6 - i4);
            Arrays.fill(obj, i4, (16 - i6) + i4, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(obj);
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    private static int e(String str, int i, int i2) {
        try {
            int parseInt = Integer.parseInt(aa.a(str, i, i2, "", false, false, false, true));
            return (parseInt <= 0 || parseInt > 65535) ? -1 : parseInt;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    final int a() {
        return this.e != -1 ? this.e : aa.a(this.a);
    }

    final int a(aa aaVar, String str) {
        int i;
        Object obj;
        Object obj2;
        int i2;
        char charAt;
        int a;
        String a2;
        Object obj3;
        Object obj4;
        int a3 = o.a(str, 0, str.length());
        int b = o.b(str, a3, str.length());
        if (b - a3 >= 2) {
            char charAt2 = str.charAt(a3);
            if ((charAt2 < 'a' || charAt2 > 'z') && (charAt2 < 'A' || charAt2 > 'Z')) {
                i = -1;
                if (i == -1) {
                    if (str.regionMatches(true, a3, "https:", 0, 6)) {
                        this.a = "https";
                        a3 += 6;
                    } else {
                        if (str.regionMatches(true, a3, "http:", 0, 5)) {
                            return ac.c;
                        }
                        this.a = "http";
                        a3 += 5;
                    }
                } else if (aaVar != null) {
                    return ac.b;
                } else {
                    this.a = aaVar.a;
                }
                obj = null;
                obj2 = null;
                i = 0;
                for (i2 = a3; i2 < b; i2++) {
                    charAt = str.charAt(i2);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i++;
                }
                if (i < 2 || aaVar == null || !aaVar.a.equals(this.a)) {
                    i2 = a3 + i;
                    while (true) {
                        a = o.a(str, i2, b, "@/\\?#");
                        switch (a != b ? str.charAt(a) : '￿') {
                            case '￿':
                            case '#':
                            case '/':
                            case '?':
                            case '\\':
                                i = c(str, i2, a);
                                if (i + 1 < a) {
                                    this.d = a(str, i2, i);
                                    this.e = e(str, i + 1, a);
                                    if (this.e == -1) {
                                        return ac.d;
                                    }
                                }
                                this.d = a(str, i2, i);
                                this.e = aa.a(this.a);
                                if (this.d == null) {
                                    a3 = a;
                                    break;
                                }
                                return ac.e;
                            case '@':
                                if (obj2 == null) {
                                    a3 = o.a(str, i2, a, ':');
                                    a2 = aa.a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    if (obj != null) {
                                        a2 = this.b + "%40" + a2;
                                    }
                                    this.b = a2;
                                    if (a3 != a) {
                                        obj2 = 1;
                                        this.c = aa.a(str, a3 + 1, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    }
                                    obj3 = obj2;
                                    obj4 = 1;
                                } else {
                                    this.c += "%40" + aa.a(str, i2, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    obj3 = obj2;
                                    obj4 = obj;
                                }
                                obj2 = obj3;
                                obj = obj4;
                                i2 = a + 1;
                                continue;
                                continue;
                                continue;
                            default:
                                continue;
                                continue;
                                continue;
                        }
                    }
                } else {
                    this.b = aaVar.b();
                    this.c = aaVar.c();
                    this.d = aaVar.b;
                    this.e = aaVar.c;
                    this.f.clear();
                    this.f.addAll(aaVar.e());
                    if (a3 == b || str.charAt(a3) == '#') {
                        a(aaVar.f());
                    }
                }
                i = o.a(str, a3, b, "?#");
                b(str, a3, i);
                if (i < b || str.charAt(i) != '?') {
                    a3 = i;
                } else {
                    a3 = o.a(str, i, b, '#');
                    this.g = aa.b(aa.a(str, i + 1, a3, " \"'<>#", true, false, true, true));
                }
                if (a3 < b && str.charAt(a3) == '#') {
                    this.h = aa.a(str, a3 + 1, b, "", true, false, false, false);
                }
                return ac.a;
            }
            i = a3 + 1;
            while (i < b) {
                char charAt3 = str.charAt(i);
                if ((charAt3 < 'a' || charAt3 > 'z') && ((charAt3 < 'A' || charAt3 > 'Z') && !((charAt3 >= '0' && charAt3 <= '9') || charAt3 == '+' || charAt3 == '-' || charAt3 == '.'))) {
                    if (charAt3 != ':') {
                        i = -1;
                    }
                    if (i == -1) {
                        if (str.regionMatches(true, a3, "https:", 0, 6)) {
                            if (str.regionMatches(true, a3, "http:", 0, 5)) {
                                return ac.c;
                            }
                            this.a = "http";
                            a3 += 5;
                        } else {
                            this.a = "https";
                            a3 += 6;
                        }
                    } else if (aaVar != null) {
                        return ac.b;
                    } else {
                        this.a = aaVar.a;
                    }
                    obj = null;
                    obj2 = null;
                    i = 0;
                    for (i2 = a3; i2 < b; i2++) {
                        charAt = str.charAt(i2);
                        if (charAt != '\\') {
                        }
                        i++;
                    }
                    if (i < 2) {
                    }
                    i2 = a3 + i;
                    while (true) {
                        a = o.a(str, i2, b, "@/\\?#");
                        if (a != b) {
                        }
                        switch (a != b ? str.charAt(a) : '￿') {
                            case '￿':
                            case '#':
                            case '/':
                            case '?':
                            case '\\':
                                i = c(str, i2, a);
                                if (i + 1 < a) {
                                    this.d = a(str, i2, i);
                                    this.e = aa.a(this.a);
                                } else {
                                    this.d = a(str, i2, i);
                                    this.e = e(str, i + 1, a);
                                    if (this.e == -1) {
                                        return ac.d;
                                    }
                                }
                                if (this.d == null) {
                                    a3 = a;
                                    break;
                                }
                                return ac.e;
                            case '@':
                                if (obj2 == null) {
                                    this.c += "%40" + aa.a(str, i2, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    obj3 = obj2;
                                    obj4 = obj;
                                } else {
                                    a3 = o.a(str, i2, a, ':');
                                    a2 = aa.a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    if (obj != null) {
                                        a2 = this.b + "%40" + a2;
                                    }
                                    this.b = a2;
                                    if (a3 != a) {
                                        obj2 = 1;
                                        this.c = aa.a(str, a3 + 1, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    }
                                    obj3 = obj2;
                                    obj4 = 1;
                                }
                                obj2 = obj3;
                                obj = obj4;
                                i2 = a + 1;
                                continue;
                                continue;
                                continue;
                            default:
                                continue;
                                continue;
                                continue;
                        }
                        i = o.a(str, a3, b, "?#");
                        b(str, a3, i);
                        if (i < b) {
                        }
                        a3 = i;
                        this.h = aa.a(str, a3 + 1, b, "", true, false, false, false);
                        return ac.a;
                    }
                }
                i++;
            }
        }
        i = -1;
        if (i == -1) {
            if (str.regionMatches(true, a3, "https:", 0, 6)) {
                this.a = "https";
                a3 += 6;
            } else {
                if (str.regionMatches(true, a3, "http:", 0, 5)) {
                    return ac.c;
                }
                this.a = "http";
                a3 += 5;
            }
        } else if (aaVar != null) {
            return ac.b;
        } else {
            this.a = aaVar.a;
        }
        obj = null;
        obj2 = null;
        i = 0;
        for (i2 = a3; i2 < b; i2++) {
            charAt = str.charAt(i2);
            if (charAt != '\\') {
            }
            i++;
        }
        if (i < 2) {
        }
        i2 = a3 + i;
        while (true) {
            a = o.a(str, i2, b, "@/\\?#");
            if (a != b) {
            }
            switch (a != b ? str.charAt(a) : '￿') {
                case '￿':
                case '#':
                case '/':
                case '?':
                case '\\':
                    i = c(str, i2, a);
                    if (i + 1 < a) {
                        this.d = a(str, i2, i);
                        this.e = e(str, i + 1, a);
                        if (this.e == -1) {
                            return ac.d;
                        }
                    }
                    this.d = a(str, i2, i);
                    this.e = aa.a(this.a);
                    if (this.d == null) {
                        a3 = a;
                        break;
                    }
                    return ac.e;
                case '@':
                    if (obj2 == null) {
                        a3 = o.a(str, i2, a, ':');
                        a2 = aa.a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        if (obj != null) {
                            a2 = this.b + "%40" + a2;
                        }
                        this.b = a2;
                        if (a3 != a) {
                            obj2 = 1;
                            this.c = aa.a(str, a3 + 1, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        }
                        obj3 = obj2;
                        obj4 = 1;
                    } else {
                        this.c += "%40" + aa.a(str, i2, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        obj3 = obj2;
                        obj4 = obj;
                    }
                    obj2 = obj3;
                    obj = obj4;
                    i2 = a + 1;
                    continue;
                    continue;
                    continue;
                default:
                    continue;
                    continue;
                    continue;
            }
            i = o.a(str, a3, b, "?#");
            b(str, a3, i);
            if (i < b) {
            }
            a3 = i;
            this.h = aa.a(str, a3 + 1, b, "", true, false, false, false);
            return ac.a;
        }
    }

    public final ab a(String str) {
        this.g = str != null ? aa.b(aa.a(str, " \"'<>#", false, true, true)) : null;
        return this;
    }

    public final aa b() {
        if (this.a == null) {
            throw new IllegalStateException("scheme == null");
        } else if (this.d != null) {
            return new aa();
        } else {
            throw new IllegalStateException("host == null");
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("://");
        if (!(this.b.isEmpty() && this.c.isEmpty())) {
            stringBuilder.append(this.b);
            if (!this.c.isEmpty()) {
                stringBuilder.append(':');
                stringBuilder.append(this.c);
            }
            stringBuilder.append('@');
        }
        if (this.d.indexOf(58) != -1) {
            stringBuilder.append('[');
            stringBuilder.append(this.d);
            stringBuilder.append(']');
        } else {
            stringBuilder.append(this.d);
        }
        int a = a();
        if (a != aa.a(this.a)) {
            stringBuilder.append(':');
            stringBuilder.append(a);
        }
        aa.a(stringBuilder, this.f);
        if (this.g != null) {
            stringBuilder.append('?');
            aa.b(stringBuilder, this.g);
        }
        if (this.h != null) {
            stringBuilder.append('#');
            stringBuilder.append(this.h);
        }
        return stringBuilder.toString();
    }
}
