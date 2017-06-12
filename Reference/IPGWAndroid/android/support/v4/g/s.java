package android.support.v4.g;

public final class s<E> implements Cloneable {
    private static final Object d = new Object();
    public boolean a;
    public int[] b;
    public int c;
    private Object[] e;

    public s() {
        this(10);
    }

    public s(int i) {
        this.a = false;
        if (i == 0) {
            this.b = c.a;
            this.e = c.c;
        } else {
            int a = c.a(i);
            this.b = new int[a];
            this.e = new Object[a];
        }
        this.c = 0;
    }

    private s<E> d() {
        try {
            s<E> sVar = (s) super.clone();
            try {
                sVar.b = (int[]) this.b.clone();
                sVar.e = (Object[]) this.e.clone();
                return sVar;
            } catch (CloneNotSupportedException e) {
                return sVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E a(int i) {
        int a = c.a(this.b, this.c, i);
        return (a < 0 || this.e[a] == d) ? null : this.e[a];
    }

    public final void a() {
        int i = this.c;
        int[] iArr = this.b;
        Object[] objArr = this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != d) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.a = false;
        this.c = i2;
    }

    public final void a(int i, E e) {
        int a = c.a(this.b, this.c, i);
        if (a >= 0) {
            this.e[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.c || this.e[a] != d) {
            if (this.a && this.c >= this.b.length) {
                a();
                a = c.a(this.b, this.c, i) ^ -1;
            }
            if (this.c >= this.b.length) {
                int a2 = c.a(this.c + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.b, 0, obj, 0, this.b.length);
                System.arraycopy(this.e, 0, obj2, 0, this.e.length);
                this.b = obj;
                this.e = obj2;
            }
            if (this.c - a != 0) {
                System.arraycopy(this.b, a, this.b, a + 1, this.c - a);
                System.arraycopy(this.e, a, this.e, a + 1, this.c - a);
            }
            this.b[a] = i;
            this.e[a] = e;
            this.c++;
            return;
        }
        this.b[a] = i;
        this.e[a] = e;
    }

    public final int b() {
        if (this.a) {
            a();
        }
        return this.c;
    }

    public final void b(int i) {
        int a = c.a(this.b, this.c, i);
        if (a >= 0 && this.e[a] != d) {
            this.e[a] = d;
            this.a = true;
        }
    }

    public final int c(int i) {
        if (this.a) {
            a();
        }
        return this.b[i];
    }

    public final void c() {
        int i = this.c;
        Object[] objArr = this.e;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.c = 0;
        this.a = false;
    }

    public final /* synthetic */ Object clone() {
        return d();
    }

    public final E d(int i) {
        if (this.a) {
            a();
        }
        return this.e[i];
    }

    public final String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.c * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(c(i));
            stringBuilder.append('=');
            s d = d(i);
            if (d != this) {
                stringBuilder.append(d);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
