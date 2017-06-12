package android.support.v7.widget;

import android.view.View;

public abstract class dk {
    protected final eb a;
    int b;

    private dk(eb ebVar) {
        this.b = Integer.MIN_VALUE;
        this.a = ebVar;
    }

    public static dk a(eb ebVar, int i) {
        switch (i) {
            case 0:
                return new dl(ebVar);
            case 1:
                return new dm(ebVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public final int a() {
        return Integer.MIN_VALUE == this.b ? 0 : e() - this.b;
    }

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();
}
