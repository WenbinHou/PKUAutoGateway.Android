package android.support.v4.g;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class g<K, V> {
    private final LinkedHashMap<K, V> a = new LinkedHashMap(0, 0.75f, true);
    private int b;
    private int c = 6;
    private int d;
    private int e;
    private int f;
    private int g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.b >= 0 && (!this.a.isEmpty() || this.b == 0)) {
                    if (this.b <= i || this.a.isEmpty()) {
                    } else {
                        Entry entry = (Entry) this.a.entrySet().iterator().next();
                        Object key = entry.getKey();
                        entry.getValue();
                        this.a.remove(key);
                        this.b--;
                        this.e++;
                    }
                }
            }
        }
    }

    public final V a(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.a.get(k);
            if (v != null) {
                this.f++;
                return v;
            }
            this.g++;
            return null;
        }
    }

    public final V a(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.d++;
            this.b++;
            put = this.a.put(k, v);
            if (put != null) {
                this.b--;
            }
        }
        a(this.c);
        return put;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f + this.g;
            if (i2 != 0) {
                i = (this.f * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i)});
        }
        return format;
    }
}
