package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class aa {
    public final ComponentName a;
    public final long b;
    public final float c;

    public aa(ComponentName componentName, long j, float f) {
        this.a = componentName;
        this.b = j;
        this.c = f;
    }

    public aa(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
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
        aa aaVar = (aa) obj;
        if (this.a == null) {
            if (aaVar.a != null) {
                return false;
            }
        } else if (!this.a.equals(aaVar.a)) {
            return false;
        }
        return this.b != aaVar.b ? false : Float.floatToIntBits(this.c) == Float.floatToIntBits(aaVar.c);
    }

    public final int hashCode() {
        return (((((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append(this.a);
        stringBuilder.append("; time:").append(this.b);
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
