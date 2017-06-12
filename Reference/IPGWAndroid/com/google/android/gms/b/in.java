package com.google.android.gms.b;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

final class in {
    public static final boolean a = im.b;
    private final List<io> b = new ArrayList();
    private boolean c = false;

    in() {
    }

    public final synchronized void a(String str) {
        long j;
        this.c = true;
        if (this.b.size() == 0) {
            j = 0;
        } else {
            j = ((io) this.b.get(this.b.size() - 1)).c - ((io) this.b.get(0)).c;
        }
        if (j > 0) {
            long j2 = ((io) this.b.get(0)).c;
            im.b("(%-4d ms) %s", Long.valueOf(j), str);
            j = j2;
            for (io ioVar : this.b) {
                im.b("(+%-4d) [%2d] %s", Long.valueOf(ioVar.c - j), Long.valueOf(ioVar.b), ioVar.a);
                j = ioVar.c;
            }
        }
    }

    public final synchronized void a(String str, long j) {
        if (this.c) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.b.add(new io(str, j, SystemClock.elapsedRealtime()));
    }

    protected final void finalize() {
        if (!this.c) {
            a("Request on the loose");
            im.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
