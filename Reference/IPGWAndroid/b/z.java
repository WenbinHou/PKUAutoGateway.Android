package b;

import java.util.ArrayList;
import java.util.List;

public final class z {
    final List<String> a = new ArrayList(20);

    private static void d(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("name == null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else {
            int i;
            char charAt;
            int length = str.length();
            for (i = 0; i < length; i++) {
                charAt = str.charAt(i);
                if (charAt <= '\u001f' || charAt >= '') {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i), str}));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            length = str2.length();
            for (i = 0; i < length; i++) {
                charAt = str2.charAt(i);
                if (charAt <= '\u001f' || charAt >= '') {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i), str, str2}));
                }
            }
        }
    }

    public final y a() {
        return new y();
    }

    public final z a(String str) {
        int i = 0;
        while (i < this.a.size()) {
            if (str.equalsIgnoreCase((String) this.a.get(i))) {
                this.a.remove(i);
                this.a.remove(i);
                i -= 2;
            }
            i += 2;
        }
        return this;
    }

    public final z a(String str, String str2) {
        d(str, str2);
        return b(str, str2);
    }

    final z b(String str, String str2) {
        this.a.add(str);
        this.a.add(str2.trim());
        return this;
    }

    public final z c(String str, String str2) {
        d(str, str2);
        a(str);
        b(str, str2);
        return this;
    }
}
