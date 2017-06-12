package b;

import b.a.b.d;
import java.util.concurrent.TimeUnit;

public final class e {
    public static final e a;
    public static final e b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final boolean k;
    String l;
    private final int m;
    private final boolean n;

    static {
        f fVar = new f();
        fVar.a = true;
        a = fVar.a();
        f fVar2 = new f();
        fVar2.f = true;
        long toSeconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        fVar2.d = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
        b = fVar2.a();
    }

    private e(f fVar) {
        this.c = fVar.a;
        this.d = fVar.b;
        this.e = fVar.c;
        this.m = -1;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = fVar.d;
        this.j = fVar.e;
        this.k = fVar.f;
        this.n = fVar.g;
    }

    private e(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.c = z;
        this.d = z2;
        this.e = i;
        this.m = i2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = i3;
        this.j = i4;
        this.k = z6;
        this.n = z7;
        this.l = str;
    }

    public static e a(y yVar) {
        boolean z = false;
        int i = -1;
        int i2 = -1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z5 = false;
        boolean z6 = false;
        Object obj = 1;
        int length = yVar.a.length / 2;
        int i5 = 0;
        String str = null;
        boolean z7 = false;
        while (i5 < length) {
            boolean z8;
            String a = yVar.a(i5);
            String b = yVar.b(i5);
            if (a.equalsIgnoreCase("Cache-Control")) {
                if (str != null) {
                    obj = null;
                } else {
                    str = b;
                }
            } else if (a.equalsIgnoreCase("Pragma")) {
                obj = null;
            } else {
                z8 = z7;
                i5++;
                z7 = z8;
            }
            z8 = z7;
            int i6 = 0;
            while (i6 < b.length()) {
                String str2;
                int a2 = d.a(b, i6, "=,;");
                String trim = b.substring(i6, a2).trim();
                if (a2 == b.length() || b.charAt(a2) == ',' || b.charAt(a2) == ';') {
                    i6 = a2 + 1;
                    str2 = null;
                } else {
                    i6 = a2 + 1;
                    while (i6 < b.length()) {
                        char charAt = b.charAt(i6);
                        if (charAt != ' ' && charAt != '\t') {
                            break;
                        }
                        i6++;
                    }
                    String trim2;
                    if (i6 >= b.length() || b.charAt(i6) != '\"') {
                        a2 = d.a(b, i6, ",;");
                        trim2 = b.substring(i6, a2).trim();
                        i6 = a2;
                        str2 = trim2;
                    } else {
                        i6++;
                        a2 = d.a(b, i6, "\"");
                        trim2 = b.substring(i6, a2);
                        i6 = a2 + 1;
                        str2 = trim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i = d.a(str2, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i2 = d.a(str2, -1);
                } else if ("private".equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i3 = d.a(str2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i4 = d.a(str2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z6 = true;
                }
            }
            i5++;
            z7 = z8;
        }
        return new e(z7, z, i, i2, z2, z3, z4, i3, i4, z5, z6, obj == null ? null : str);
    }

    public final String toString() {
        String str = this.l;
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.c) {
                stringBuilder.append("no-cache, ");
            }
            if (this.d) {
                stringBuilder.append("no-store, ");
            }
            if (this.e != -1) {
                stringBuilder.append("max-age=").append(this.e).append(", ");
            }
            if (this.m != -1) {
                stringBuilder.append("s-maxage=").append(this.m).append(", ");
            }
            if (this.f) {
                stringBuilder.append("private, ");
            }
            if (this.g) {
                stringBuilder.append("public, ");
            }
            if (this.h) {
                stringBuilder.append("must-revalidate, ");
            }
            if (this.i != -1) {
                stringBuilder.append("max-stale=").append(this.i).append(", ");
            }
            if (this.j != -1) {
                stringBuilder.append("min-fresh=").append(this.j).append(", ");
            }
            if (this.k) {
                stringBuilder.append("only-if-cached, ");
            }
            if (this.n) {
                stringBuilder.append("no-transform, ");
            }
            if (stringBuilder.length() == 0) {
                str = "";
            } else {
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                str = stringBuilder.toString();
            }
            this.l = str;
        }
        return str;
    }
}
