package com.google.android.gms.b;

import android.view.View;
import com.google.android.gms.ads.internal.util.client.b;

final class n implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ m b;

    n(m mVar, View view) {
        this.b = mVar;
        this.a = view;
    }

    public final void run() {
        m mVar = this.b;
        View view = this.a;
        try {
            j jVar = new j(mVar.c, mVar.d, mVar.e, mVar.f);
            q a = mVar.a(view, jVar);
            jVar.c();
            if (a.a != 0 || a.b != 0) {
                if (a.b != 0 || jVar.b != 0) {
                    if (a.b != 0 || !mVar.a.a(jVar)) {
                        k kVar = mVar.a;
                        synchronized (kVar.a) {
                            if (kVar.c.size() >= 10) {
                                b.a("Queue is full, current size = " + kVar.c.size());
                                kVar.c.remove(0);
                            }
                            int i = kVar.b;
                            kVar.b = i + 1;
                            jVar.c = i;
                            kVar.c.add(jVar);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            b.b("Exception in fetchContentOnUIThread", e);
            mVar.b.a(e, true);
        }
    }
}
