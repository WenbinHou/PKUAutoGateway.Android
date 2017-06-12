package b.a.a;

import c.f;
import c.i;
import java.util.List;

final class ab {
    private final f a;

    ab(f fVar) {
        this.a = fVar;
    }

    private void a(int i, int i2) {
        if (i < i2) {
            this.a.b(i | 0);
            return;
        }
        this.a.b(i2 | 0);
        int i3 = i - i2;
        while (i3 >= 128) {
            this.a.b((i3 & 127) | 128);
            i3 >>>= 7;
        }
        this.a.b(i3);
    }

    private void a(i iVar) {
        a(iVar.c.length, 127);
        this.a.a(iVar);
    }

    final void a(List<x> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            i c = ((x) list.get(i)).h.c();
            Integer num = (Integer) z.b.get(c);
            if (num != null) {
                a(num.intValue() + 1, 15);
                a(((x) list.get(i)).i);
            } else {
                this.a.b(0);
                a(c);
                a(((x) list.get(i)).i);
            }
        }
    }
}
