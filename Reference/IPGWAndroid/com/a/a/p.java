package com.a.a;

import android.content.Context;
import android.text.TextUtils;

public final class p {
    public int a;
    public int b;
    public ac c;
    l d;
    aa e;
    m f;
    private Context g;
    private String h;

    public p(Context context) {
        x.a("Context", (Object) context);
        this.g = context.getApplicationContext();
    }

    public static ac a(Context context) {
        return new ab(context, "HAWK");
    }

    private int c() {
        if (this.a == 0) {
            this.a = r.b;
        }
        return this.a;
    }

    private ac d() {
        return new ab(this.g, "324909sdfsd98098");
    }

    final ac a() {
        if (this.c == null) {
            this.c = new ab(this.g, "HAWK");
        }
        return this.c;
    }

    public final void b() {
        if (c() == r.a && TextUtils.isEmpty(this.h)) {
            throw new IllegalStateException("Password cannot be null if encryption mode is highest");
        }
        switch (q.a[c() - 1]) {
            case 1:
                this.f = new h();
                break;
            case 2:
                this.f = new g(a(), this.h);
                if (!this.f.a()) {
                    d().a("dfsklj2342nasdfoasdfcrpknasdf", Boolean.valueOf(true));
                    this.f = new h();
                    break;
                }
                break;
            case 3:
                this.f = new g(a(), null);
                if (!this.f.a()) {
                    d().a("dfsklj2342nasdfoasdfcrpknasdf", Boolean.valueOf(true));
                    this.f = new h();
                    break;
                }
                break;
            default:
                throw new IllegalStateException("encryption mode should be valid");
        }
        o.a = new o(this);
    }
}
