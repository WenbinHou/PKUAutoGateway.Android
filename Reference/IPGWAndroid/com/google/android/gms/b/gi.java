package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;

final class gi implements hx {
    final /* synthetic */ String a;
    final /* synthetic */ gl b;
    final /* synthetic */ gg c;

    gi(gg ggVar, String str, gl glVar) {
        this.c = ggVar;
        this.a = str;
        this.b = glVar;
    }

    public final void a(il ilVar) {
        b.d("Failed to load URL: " + this.a + "\n" + ilVar.toString());
        this.b.a(null);
    }
}
