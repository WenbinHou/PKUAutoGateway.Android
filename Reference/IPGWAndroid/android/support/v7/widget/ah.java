package android.support.v7.widget;

final class ah {
    int a;
    int b;
    Object c;
    int d;

    ah(int i, int i2, int i3, Object obj) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ah ahVar = (ah) obj;
        return this.a != ahVar.a ? false : (this.a == 8 && Math.abs(this.d - this.b) == 1 && this.d == ahVar.b && this.b == ahVar.d) ? true : this.d != ahVar.d ? false : this.b != ahVar.b ? false : this.c != null ? this.c.equals(ahVar.c) : ahVar.c == null;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.d;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
        switch (this.a) {
            case 1:
                str = "add";
                break;
            case 2:
                str = "rm";
                break;
            case 4:
                str = "up";
                break;
            case 8:
                str = "mv";
                break;
            default:
                str = "??";
                break;
        }
        return append.append(str).append(",s:").append(this.b).append("c:").append(this.d).append(",p:").append(this.c).append("]").toString();
    }
}
