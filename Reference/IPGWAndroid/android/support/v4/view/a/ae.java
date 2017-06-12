package android.support.v4.view.a;

import android.os.Build.VERSION;

public final class ae {
    public static final ah a;
    public final Object b;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new ai();
        } else if (VERSION.SDK_INT >= 15) {
            a = new ag();
        } else if (VERSION.SDK_INT >= 14) {
            a = new af();
        } else {
            a = new aj();
        }
    }

    public ae(Object obj) {
        this.b = obj;
    }

    public final void a(int i) {
        a.b(this.b, i);
    }

    public final void a(boolean z) {
        a.a(this.b, z);
    }

    public final void b(int i) {
        a.a(this.b, i);
    }

    public final void c(int i) {
        a.e(this.b, i);
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
        ae aeVar = (ae) obj;
        return this.b == null ? aeVar.b == null : this.b.equals(aeVar.b);
    }

    public final int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }
}
