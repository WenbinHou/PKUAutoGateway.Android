package b;

import b.a.b.n;
import java.util.Collections;
import java.util.Date;

public final class y {
    public final String[] a;

    private y(z zVar) {
        this.a = (String[]) zVar.a.toArray(new String[zVar.a.size()]);
    }

    public final z a() {
        z zVar = new z();
        Collections.addAll(zVar.a, this.a);
        return zVar;
    }

    public final String a(int i) {
        return this.a[i * 2];
    }

    public final String a(String str) {
        String[] strArr = this.a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final String b(int i) {
        return this.a[(i * 2) + 1];
    }

    public final Date b(String str) {
        String a = a(str);
        return a != null ? n.a(a) : null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = this.a.length / 2;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
        }
        return stringBuilder.toString();
    }
}
