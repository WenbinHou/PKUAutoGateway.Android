package b.a;

public abstract class h implements Runnable {
    protected final String b;

    public h(String str, Object... objArr) {
        this.b = String.format(str, objArr);
    }

    public abstract void b();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
