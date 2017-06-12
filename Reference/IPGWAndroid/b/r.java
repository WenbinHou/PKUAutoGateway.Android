package b;

import b.a.b.n;
import b.a.o;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class r {
    private static final Pattern c = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern d = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern e = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern f = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    public final String a;
    public final String b;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private r(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = str2;
        this.g = j;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    private static int a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            Object obj = ((charAt >= ' ' || charAt == '\t') && charAt < '' && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) ? null : 1;
            if (obj == (!z ? 1 : null)) {
                return i3;
            }
        }
        return i2;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong <= 0 ? Long.MIN_VALUE : parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return !str.startsWith("-") ? Long.MAX_VALUE : Long.MIN_VALUE;
            } else {
                throw e;
            }
        }
    }

    private static r a(long j, aa aaVar, String str) {
        int length = str.length();
        int a = o.a(str, 0, length, ';');
        int a2 = o.a(str, 0, a, '=');
        if (a2 == a) {
            return null;
        }
        String c = o.c(str, 0, a2);
        if (c.isEmpty()) {
            return null;
        }
        String c2;
        String c3 = o.c(str, a2 + 1, a);
        long j2 = 253402300799999L;
        long j3 = -1;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        a++;
        while (a < length) {
            String str4;
            int a3 = o.a(str, a, length, ';');
            int a4 = o.a(str, a, a3, '=');
            String c4 = o.c(str, a, a4);
            c2 = a4 < a3 ? o.c(str, a4 + 1, a3) : "";
            if (c4.equalsIgnoreCase("expires")) {
                try {
                    int length2 = c2.length();
                    int a5 = a(c2, 0, length2, false);
                    int i = -1;
                    int i2 = -1;
                    int i3 = -1;
                    int i4 = -1;
                    int i5 = -1;
                    a4 = -1;
                    Matcher matcher = f.matcher(c2);
                    while (a5 < length2) {
                        int a6 = a(c2, a5 + 1, length2, true);
                        matcher.region(a5, a6);
                        if (i == -1 && matcher.usePattern(f).matches()) {
                            i = Integer.parseInt(matcher.group(1));
                            i2 = Integer.parseInt(matcher.group(2));
                            i3 = Integer.parseInt(matcher.group(3));
                        } else {
                            if (i4 == -1) {
                                if (matcher.usePattern(e).matches()) {
                                    i4 = Integer.parseInt(matcher.group(1));
                                }
                            }
                            if (i5 == -1 && matcher.usePattern(d).matches()) {
                                i5 = d.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                            } else if (a4 == -1 && matcher.usePattern(c).matches()) {
                                a4 = Integer.parseInt(matcher.group(1));
                            }
                        }
                        a5 = a(c2, a6 + 1, length2, false);
                    }
                    a = (a4 < 70 || a4 > 99) ? a4 : a4 + 1900;
                    if (a >= 0 && a <= 69) {
                        a += 2000;
                    }
                    if (a < 1601) {
                        throw new IllegalArgumentException();
                    } else if (i5 == -1) {
                        throw new IllegalArgumentException();
                    } else if (i4 <= 0 || i4 > 31) {
                        throw new IllegalArgumentException();
                    } else if (i < 0 || i > 23) {
                        throw new IllegalArgumentException();
                    } else if (i2 < 0 || i2 > 59) {
                        throw new IllegalArgumentException();
                    } else if (i3 < 0 || i3 > 59) {
                        throw new IllegalArgumentException();
                    } else {
                        Calendar gregorianCalendar = new GregorianCalendar(o.d);
                        gregorianCalendar.setLenient(false);
                        gregorianCalendar.set(1, a);
                        gregorianCalendar.set(2, i5 - 1);
                        gregorianCalendar.set(5, i4);
                        gregorianCalendar.set(11, i);
                        gregorianCalendar.set(12, i2);
                        gregorianCalendar.set(13, i3);
                        gregorianCalendar.set(14, 0);
                        j2 = gregorianCalendar.getTimeInMillis();
                        z4 = true;
                        c2 = str3;
                        str3 = str2;
                    }
                } catch (IllegalArgumentException e) {
                    c2 = str3;
                    str3 = str2;
                }
            } else if (c4.equalsIgnoreCase("max-age")) {
                try {
                    j3 = a(c2);
                    z4 = true;
                    c2 = str3;
                    str3 = str2;
                } catch (NumberFormatException e2) {
                    c2 = str3;
                    str3 = str2;
                }
            } else if (c4.equalsIgnoreCase("domain")) {
                try {
                    if (c2.endsWith(".")) {
                        throw new IllegalArgumentException();
                    }
                    if (c2.startsWith(".")) {
                        c2 = c2.substring(1);
                    }
                    c2 = o.a(c2);
                    if (c2 == null) {
                        throw new IllegalArgumentException();
                    }
                    z3 = false;
                    str4 = str3;
                    str3 = c2;
                    c2 = str4;
                } catch (IllegalArgumentException e3) {
                    c2 = str3;
                    str3 = str2;
                }
            } else if (c4.equalsIgnoreCase("path")) {
                str3 = str2;
            } else {
                if (c4.equalsIgnoreCase("secure")) {
                    z = true;
                    c2 = str3;
                    str3 = str2;
                } else {
                    if (c4.equalsIgnoreCase("httponly")) {
                        z2 = true;
                        c2 = str3;
                        str3 = str2;
                    } else {
                        c2 = str3;
                        str3 = str2;
                    }
                }
            }
            str4 = c2;
            a = a3 + 1;
            str2 = str3;
            str3 = str4;
        }
        if (j3 == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (j3 != -1) {
            j2 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
            if (j2 < j || j2 > 253402300799999L) {
                j2 = 253402300799999L;
            }
        }
        if (str2 == null) {
            c2 = aaVar.b;
        } else {
            String str5 = aaVar.b;
            Object obj = str5.equals(str2) ? 1 : (str5.endsWith(str2) && str5.charAt((str5.length() - str2.length()) - 1) == '.' && !o.b(str5)) ? 1 : null;
            if (obj == null) {
                return null;
            }
            c2 = str2;
        }
        if (str3 == null || !str3.startsWith("/")) {
            str5 = aaVar.d();
            int lastIndexOf = str5.lastIndexOf(47);
            str3 = lastIndexOf != 0 ? str5.substring(0, lastIndexOf) : "/";
        }
        return new r(c, c3, j2, c2, str3, z, z2, z3, z4);
    }

    public static List<r> a(aa aaVar, y yVar) {
        String str = "Set-Cookie";
        int length = yVar.a.length / 2;
        List list = null;
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(yVar.a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(yVar.b(i));
            }
        }
        List unmodifiableList = list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
        int size = unmodifiableList.size();
        List list2 = null;
        int i2 = 0;
        while (i2 < size) {
            r a = a(System.currentTimeMillis(), aaVar, (String) unmodifiableList.get(i2));
            if (a != null) {
                list = list2 == null ? new ArrayList() : list2;
                list.add(a);
            } else {
                list = list2;
            }
            i2++;
            list2 = list;
        }
        return list2 != null ? Collections.unmodifiableList(list2) : Collections.emptyList();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return rVar.a.equals(this.a) && rVar.b.equals(this.b) && rVar.h.equals(this.h) && rVar.i.equals(this.i) && rVar.g == this.g && rVar.j == this.j && rVar.k == this.k && rVar.l == this.l && rVar.m == this.m;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.l ? 0 : 1) + (((this.k ? 0 : 1) + (((this.j ? 0 : 1) + ((((((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + ((int) (this.g ^ (this.g >>> 32)))) * 31)) * 31)) * 31)) * 31;
        if (!this.m) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append('=');
        stringBuilder.append(this.b);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(n.a(new Date(this.g)));
            }
        }
        if (!this.m) {
            stringBuilder.append("; domain=").append(this.h);
        }
        stringBuilder.append("; path=").append(this.i);
        if (this.j) {
            stringBuilder.append("; secure");
        }
        if (this.k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }
}
