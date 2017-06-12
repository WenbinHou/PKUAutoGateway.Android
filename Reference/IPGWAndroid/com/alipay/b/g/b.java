package com.alipay.b.g;

import com.alipay.b.d.a;
import java.util.HashMap;
import java.util.Map;

public final class b implements Runnable {
    final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        e eVar;
        while (!this.a.b.isEmpty()) {
            try {
                eVar = (e) this.a.b.pollFirst();
                if (!(eVar == null || eVar.e.f)) {
                    eVar.e.f = true;
                    a.a(eVar.e.e);
                    Map hashMap = new HashMap();
                    hashMap.put("tid", eVar.b);
                    hashMap.put("utdid", eVar.a);
                    a.a(eVar.e.e);
                    hashMap.put("umid", a.a());
                    hashMap.put("userId", eVar.c);
                    g.a(eVar.e.e, hashMap);
                    if (eVar.d != null) {
                        f fVar = new f(eVar.e);
                        fVar.c = com.alipay.b.a.a.b(eVar.e.e);
                        fVar.b = com.alipay.b.a.a.a(eVar.e.e);
                        a.a(eVar.e.e);
                        fVar.a = a.a();
                        fVar.d = com.alipay.b.f.b.a(eVar.e.e);
                        new StringBuilder("[*]result.apdid     = ").append(fVar.c);
                        new StringBuilder("[*]result.token     = ").append(fVar.b);
                        new StringBuilder("[*]result.umid      = ").append(fVar.a);
                        new StringBuilder("[*]result.clientKey = ").append(fVar.d);
                    }
                    eVar.e.f = false;
                }
            } catch (Throwable th) {
                this.a.a = null;
            }
        }
        this.a.a = null;
    }
}
