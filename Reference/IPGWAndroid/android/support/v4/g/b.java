package android.support.v4.g;

import java.util.Map;

final class b extends h<K, V> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    protected final int a() {
        return this.a.h;
    }

    protected final int a(Object obj) {
        return this.a.a(obj);
    }

    protected final Object a(int i, int i2) {
        return this.a.g[(i << 1) + i2];
    }

    protected final V a(int i, V v) {
        return this.a.a(i, (Object) v);
    }

    protected final void a(int i) {
        this.a.d(i);
    }

    protected final void a(K k, V v) {
        this.a.put(k, v);
    }

    protected final int b(Object obj) {
        return this.a.b(obj);
    }

    protected final Map<K, V> b() {
        return this.a;
    }

    protected final void c() {
        this.a.clear();
    }
}
