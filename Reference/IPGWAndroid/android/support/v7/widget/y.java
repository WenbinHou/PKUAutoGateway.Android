package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class y implements Comparable<y> {
    public final ResolveInfo a;
    public float b;
    final /* synthetic */ x c;

    public y(x xVar, ResolveInfo resolveInfo) {
        this.c = xVar;
        this.a = resolveInfo;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return Float.floatToIntBits(((y) obj).b) - Float.floatToIntBits(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return Float.floatToIntBits(this.b) == Float.floatToIntBits(((y) obj).b);
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) + 31;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.a.toString());
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
