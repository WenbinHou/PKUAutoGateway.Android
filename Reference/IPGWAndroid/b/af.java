package b;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class af {
    private static final Pattern b = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern c = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    final String a;
    private final String d;
    private final String e;
    private final String f;

    private af(String str, String str2, String str3, String str4) {
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.a = str4;
    }

    public static af a(String str) {
        Matcher matcher = b.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = c.matcher(str);
        int end = matcher.end();
        String str2 = null;
        while (end < str.length()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group == null || !group.equalsIgnoreCase("charset")) {
                group = str2;
            } else {
                group = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (!(str2 == null || group.equalsIgnoreCase(str2))) {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
            String str3 = group;
            end = matcher2.end();
            str2 = str3;
        }
        return new af(str, toLowerCase, toLowerCase2, str2);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof af) && ((af) obj).d.equals(this.d);
    }

    public final int hashCode() {
        return this.d.hashCode();
    }

    public final String toString() {
        return this.d;
    }
}
