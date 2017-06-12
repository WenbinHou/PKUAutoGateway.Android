package b.a.a;

import c.h;
import c.i;
import c.n;
import c.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class aj {
    int a;
    final h b = o.a(this.c);
    private final n c;

    public aj(h hVar) {
        this.c = new n(new ak(this, hVar), new al(this));
    }

    private i a() {
        return this.b.c((long) this.b.g());
    }

    public final List<x> a(int i) {
        this.a += i;
        int g = this.b.g();
        if (g < 0) {
            throw new IOException("numberOfPairs < 0: " + g);
        } else if (g > 1024) {
            throw new IOException("numberOfPairs > 1024: " + g);
        } else {
            List<x> arrayList = new ArrayList(g);
            for (int i2 = 0; i2 < g; i2++) {
                i c = a().c();
                i a = a();
                if (c.c.length == 0) {
                    throw new IOException("name.size == 0");
                }
                arrayList.add(new x(c, a));
            }
            if (this.a > 0) {
                this.c.b();
                if (this.a != 0) {
                    throw new IOException("compressedLimit > 0: " + this.a);
                }
            }
            return arrayList;
        }
    }
}
