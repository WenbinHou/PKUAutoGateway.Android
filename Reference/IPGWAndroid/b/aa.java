package b;

import b.a.o;
import c.f;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class aa {
    private static final char[] e = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final int c;
    public final List<String> d;
    private final String f;
    private final String g;
    private final List<String> h;
    private final String i;
    private final String j;

    private aa(ab abVar) {
        String str = null;
        this.a = abVar.a;
        this.f = a(abVar.b, false);
        this.g = a(abVar.c, false);
        this.b = abVar.d;
        this.c = abVar.a();
        this.h = a(abVar.f, false);
        this.d = abVar.g != null ? a(abVar.g, true) : null;
        if (abVar.h != null) {
            str = a(abVar.h, false);
        }
        this.i = str;
        this.j = abVar.toString();
    }

    static int a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    public static int a(String str) {
        return str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                f fVar = new f();
                fVar.a(str, i, i3);
                int i4 = i3;
                f fVar2 = null;
                while (i4 < i2) {
                    int codePointAt2 = str.codePointAt(i4);
                    if (!(z && (codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13))) {
                        if (codePointAt2 == 43 && z3) {
                            fVar.a(z ? "+" : "%2B");
                        } else if (codePointAt2 < 32 || codePointAt2 == 127 || ((codePointAt2 >= 128 && z4) || str2.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && (!z || (z2 && !a(str, i4, i2)))))) {
                            if (fVar2 == null) {
                                fVar2 = new f();
                            }
                            fVar2.a(codePointAt2);
                            while (!fVar2.d()) {
                                codePointAt = fVar2.e() & 255;
                                fVar.b(37);
                                fVar.b(e[(codePointAt >> 4) & 15]);
                                fVar.b(e[codePointAt & 15]);
                            }
                        } else {
                            fVar.a(codePointAt2);
                        }
                    }
                    i4 = Character.charCount(codePointAt2) + i4;
                }
                return fVar.l();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    static String a(String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                f fVar = new f();
                fVar.a(str, i, i3);
                while (i3 < i2) {
                    int codePointAt = str.codePointAt(i3);
                    if (codePointAt != 37 || i3 + 2 >= i2) {
                        if (codePointAt == 43 && z) {
                            fVar.b(32);
                        }
                        fVar.a(codePointAt);
                    } else {
                        int a = a(str.charAt(i3 + 1));
                        int a2 = a(str.charAt(i3 + 2));
                        if (!(a == -1 || a2 == -1)) {
                            fVar.b((a << 4) + a2);
                            i3 += 2;
                        }
                        fVar.a(codePointAt);
                    }
                    i3 += Character.charCount(codePointAt);
                }
                return fVar.l();
            }
            i3++;
        }
        return str.substring(i, i2);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3) {
        return a(str, 0, str.length(), str2, true, z, z2, z3);
    }

    private static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private static List<String> a(List<String> list, boolean z) {
        List arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    private static boolean a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && a(str.charAt(i + 1)) != -1 && a(str.charAt(i + 2)) != -1;
    }

    static List<String> b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public static void b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    public static aa d(String str) {
        ab abVar = new ab();
        return abVar.a(null, str) == ac.a ? abVar.b() : null;
    }

    public final URI a() {
        int i;
        ab abVar = new ab();
        abVar.a = this.a;
        abVar.b = b();
        abVar.c = c();
        abVar.d = this.b;
        abVar.e = this.c != a(this.a) ? this.c : -1;
        abVar.f.clear();
        abVar.f.addAll(e());
        abVar.a(f());
        abVar.h = this.i == null ? null : this.j.substring(this.j.indexOf(35) + 1);
        int size = abVar.f.size();
        for (i = 0; i < size; i++) {
            abVar.f.set(i, a((String) abVar.f.get(i), "[]", true, false, true));
        }
        if (abVar.g != null) {
            size = abVar.g.size();
            for (i = 0; i < size; i++) {
                String str = (String) abVar.g.get(i);
                if (str != null) {
                    abVar.g.set(i, a(str, "\\^`{|}", true, true, true));
                }
            }
        }
        if (abVar.h != null) {
            abVar.h = a(abVar.h, " \"#<>\\^`{|}", true, false, false);
        }
        String abVar2 = abVar.toString();
        try {
            return new URI(abVar2);
        } catch (Throwable e) {
            try {
                return URI.create(abVar2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String b() {
        if (this.f.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        return this.j.substring(length, o.a(this.j, length, this.j.length(), ":@"));
    }

    public final aa c(String str) {
        ab abVar = new ab();
        if (abVar.a(this, str) != ac.a) {
            abVar = null;
        }
        return abVar != null ? abVar.b() : null;
    }

    public final String c() {
        if (this.g.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.a.length() + 3) + 1, this.j.indexOf(64));
    }

    public final String d() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        return this.j.substring(indexOf, o.a(this.j, indexOf, this.j.length(), "?#"));
    }

    public final List<String> e() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        int a = o.a(this.j, indexOf, this.j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            indexOf = o.a(this.j, i, a, '/');
            arrayList.add(this.j.substring(i, indexOf));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof aa) && ((aa) obj).j.equals(this.j);
    }

    public final String f() {
        if (this.d == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        return this.j.substring(indexOf, o.a(this.j, indexOf + 1, this.j.length(), '#'));
    }

    public final int hashCode() {
        return this.j.hashCode();
    }

    public final String toString() {
        return this.j;
    }
}
