package b.a.b;

public final class d {
    public static int a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong > 2147483647L ? Integer.MAX_VALUE : parseLong < 0 ? 0 : (int) parseLong;
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }
}
