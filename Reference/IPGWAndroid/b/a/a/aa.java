package b.a.a;

import c.h;
import c.i;
import c.o;
import c.x;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class aa {
    final List<x> a = new ArrayList();
    final h b;
    int c = 4096;
    int d = 4096;
    x[] e = new x[8];
    int f = (this.e.length - 1);
    int g = 0;
    int h = 0;

    aa(x xVar) {
        this.b = o.a(xVar);
    }

    private void c() {
        this.a.clear();
        Arrays.fill(this.e, null);
        this.f = this.e.length - 1;
        this.g = 0;
        this.h = 0;
    }

    static boolean c(int i) {
        return i >= 0 && i <= z.a.length - 1;
    }

    private int d() {
        return this.b.e() & 255;
    }

    private int d(int i) {
        int i2 = 0;
        if (i > 0) {
            for (int length = this.e.length - 1; length >= this.f && i > 0; length--) {
                i -= this.e[length].j;
                this.h -= this.e[length].j;
                this.g--;
                i2++;
            }
            System.arraycopy(this.e, this.f + 1, this.e, (this.f + 1) + i2, this.g);
            this.f += i2;
        }
        return i2;
    }

    final int a(int i) {
        return (this.f + 1) + i;
    }

    final int a(int i, int i2) {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        i3 = 0;
        while (true) {
            int d = d();
            if ((d & 128) == 0) {
                return (d << i3) + i2;
            }
            i2 += (d & 127) << i3;
            i3 += 7;
        }
    }

    final void a() {
        if (this.d >= this.h) {
            return;
        }
        if (this.d == 0) {
            c();
        } else {
            d(this.h - this.d);
        }
    }

    final void a(x xVar) {
        this.a.add(xVar);
        int i = xVar.j;
        if (i > this.d) {
            c();
            return;
        }
        d((this.h + i) - this.d);
        if (this.g + 1 > this.e.length) {
            Object obj = new x[(this.e.length * 2)];
            System.arraycopy(this.e, 0, obj, this.e.length, this.e.length);
            this.f = this.e.length - 1;
            this.e = obj;
        }
        int i2 = this.f;
        this.f = i2 - 1;
        this.e[i2] = xVar;
        this.g++;
        this.h = i + this.h;
    }

    final i b() {
        int i = 0;
        int d = d();
        int i2 = (d & 128) == 128 ? 1 : 0;
        d = a(d, 127);
        if (i2 == 0) {
            return this.b.c((long) d);
        }
        ah a = ah.a();
        byte[] e = this.b.e((long) d);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d = 0;
        ai aiVar = a.a;
        i2 = 0;
        while (i < e.length) {
            d = (d << 8) | (e[i] & 255);
            i2 += 8;
            while (i2 >= 8) {
                aiVar = aiVar.a[(d >>> (i2 - 8)) & 255];
                if (aiVar.a == null) {
                    byteArrayOutputStream.write(aiVar.b);
                    i2 -= aiVar.c;
                    aiVar = a.a;
                } else {
                    i2 -= 8;
                }
            }
            i++;
        }
        while (i2 > 0) {
            ai aiVar2 = aiVar.a[(d << (8 - i2)) & 255];
            if (aiVar2.a != null || aiVar2.c > i2) {
                break;
            }
            byteArrayOutputStream.write(aiVar2.b);
            i2 -= aiVar2.c;
            aiVar = a.a;
        }
        return i.a(byteArrayOutputStream.toByteArray());
    }

    final i b(int i) {
        return c(i) ? z.a[i].h : this.e[a(i - z.a.length)].h;
    }
}
