package android.support.v4.g;

import java.util.Iterator;

final class i<T> implements Iterator<T> {
    final int a;
    int b;
    int c;
    boolean d = false;
    final /* synthetic */ h e;

    i(h hVar, int i) {
        this.e = hVar;
        this.a = i;
        this.b = hVar.a();
    }

    public final boolean hasNext() {
        return this.c < this.b;
    }

    public final T next() {
        T a = this.e.a(this.c, this.a);
        this.c++;
        this.d = true;
        return a;
    }

    public final void remove() {
        if (this.d) {
            this.c--;
            this.b--;
            this.d = false;
            this.e.a(this.c);
            return;
        }
        throw new IllegalStateException();
    }
}
