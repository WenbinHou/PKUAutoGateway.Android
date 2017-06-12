package com.kaopiz.kprogresshud;

import android.content.Context;
import android.view.View;

public final class f {
    public h a;
    public float b = 0.0f;
    int c;
    float d;
    public int e;
    int f;
    private Context g;
    private boolean h;

    public f(Context context) {
        this.g = context;
        this.a = new h(this, context);
        this.c = context.getResources().getColor(l.kprogresshud_default_color);
        this.e = 1;
        this.d = 10.0f;
        this.h = true;
        a(i.a);
    }

    public final f a() {
        Object obj = (this.a == null || !this.a.isShowing()) ? null : 1;
        if (obj == null) {
            this.a.show();
        }
        return this;
    }

    public final f a(int i) {
        View view = null;
        switch (g.a[i - 1]) {
            case 1:
                view = new p(this.g);
                break;
            case 2:
                view = new j(this.g);
                break;
            case 3:
                view = new a(this.g);
                break;
            case 4:
                view = new b(this.g);
                break;
        }
        h hVar = this.a;
        if (view != null) {
            if (view instanceof c) {
                hVar.a = (c) view;
            }
            if (view instanceof e) {
                hVar.b = (e) view;
            }
            hVar.c = view;
            if (hVar.isShowing()) {
                hVar.d.removeAllViews();
                hVar.a(view);
            }
        }
        return this;
    }

    public final void b() {
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
