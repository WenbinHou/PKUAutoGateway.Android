package android.support.v4.g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends r<K, V> implements Map<K, V> {
    h<K, V> a;

    public a(int i) {
        super(i);
    }

    private h<K, V> a() {
        if (this.a == null) {
            this.a = new b(this);
        }
        return this.a;
    }

    public Set<Entry<K, V>> entrySet() {
        h a = a();
        if (a.b == null) {
            a.b = new j(a);
        }
        return a.b;
    }

    public Set<K> keySet() {
        h a = a();
        if (a.c == null) {
            a.c = new k(a);
        }
        return a.c;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        h a = a();
        if (a.d == null) {
            a.d = new m(a);
        }
        return a.d;
    }
}
