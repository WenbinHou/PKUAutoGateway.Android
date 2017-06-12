package c;

public abstract class k implements x {
    private final x a;

    public k(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = xVar;
    }

    public long a(f fVar, long j) {
        return this.a.a(fVar, j);
    }

    public final y a() {
        return this.a.a();
    }

    public void close() {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
