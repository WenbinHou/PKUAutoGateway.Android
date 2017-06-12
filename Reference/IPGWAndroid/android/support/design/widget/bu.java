package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

public final class bu {
    Object a;
    Drawable b;
    CharSequence c;
    CharSequence d;
    public int e;
    public View f;
    TabLayout g;
    bw h;

    private bu() {
        this.e = -1;
    }

    public final bu a(View view) {
        this.f = view;
        b();
        return this;
    }

    public final bu a(CharSequence charSequence) {
        this.c = charSequence;
        b();
        return this;
    }

    public final void a() {
        if (this.g == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        this.g.a(this, true);
    }

    final void b() {
        if (this.h != null) {
            this.h.a();
        }
    }
}
