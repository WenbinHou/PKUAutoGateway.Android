package android.support.v4.g;

public final class q<T> extends p<T> {
    private final Object a = new Object();

    public q() {
        super(16);
    }

    public final T a() {
        T a;
        synchronized (this.a) {
            a = super.a();
        }
        return a;
    }

    public final boolean a(T t) {
        boolean a;
        synchronized (this.a) {
            a = super.a(t);
        }
        return a;
    }
}
