package c;

final class v {
    static u a;
    static long b;

    private v() {
    }

    static u a() {
        synchronized (v.class) {
            if (a != null) {
                u uVar = a;
                a = uVar.f;
                uVar.f = null;
                b -= 2048;
                return uVar;
            }
            return new u();
        }
    }

    static void a(u uVar) {
        if (uVar.f != null || uVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!uVar.d) {
            synchronized (v.class) {
                if (b + 2048 > 65536) {
                    return;
                }
                b += 2048;
                uVar.f = a;
                uVar.c = 0;
                uVar.b = 0;
                a = uVar;
            }
        }
    }
}
