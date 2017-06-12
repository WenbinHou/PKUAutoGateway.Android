package android.support.v7.a;

import android.content.Context;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class bd extends b implements j {
    final /* synthetic */ az a;
    private final Context d;
    private final i e;
    private c f;
    private WeakReference<View> g;

    public bd(az azVar, Context context, c cVar) {
        this.a = azVar;
        this.d = context;
        this.f = cVar;
        i iVar = new i(context);
        this.e = iVar;
        this.e.a((j) this);
    }

    public final MenuInflater a() {
        return new android.support.v7.view.i(this.d);
    }

    public final void a(int i) {
        b(this.a.l.getResources().getString(i));
    }

    public final void a(i iVar) {
        if (this.f != null) {
            d();
            this.a.s.a();
        }
    }

    public final void a(View view) {
        this.a.s.setCustomView(view);
        this.g = new WeakReference(view);
    }

    public final void a(CharSequence charSequence) {
        this.a.s.setSubtitle(charSequence);
    }

    public final void a(boolean z) {
        super.a(z);
        this.a.s.setTitleOptional(z);
    }

    public final boolean a(i iVar, MenuItem menuItem) {
        return this.f != null ? this.f.a((b) this, menuItem) : false;
    }

    public final Menu b() {
        return this.e;
    }

    public final void b(int i) {
        a(this.a.l.getResources().getString(i));
    }

    public final void b(CharSequence charSequence) {
        this.a.s.setTitle(charSequence);
    }

    public final void c() {
        if (this.a.a == this) {
            if (az.a(this.a.D, this.a.E, false)) {
                this.f.a(this);
            } else {
                this.a.b = this;
                this.a.c = this.f;
            }
            this.f = null;
            this.a.f(false);
            ActionBarContextView h = this.a.s;
            if (h.g == null) {
                h.b();
            }
            this.a.r.a().sendAccessibilityEvent(32);
            this.a.p.setHideOnContentScrollEnabled(this.a.d);
            this.a.a = null;
        }
    }

    public final void d() {
        if (this.a.a == this) {
            this.e.d();
            try {
                this.f.b(this, this.e);
            } finally {
                this.e.e();
            }
        }
    }

    public final boolean e() {
        this.e.d();
        try {
            boolean a = this.f.a((b) this, this.e);
            return a;
        } finally {
            this.e.e();
        }
    }

    public final CharSequence f() {
        return this.a.s.getTitle();
    }

    public final CharSequence g() {
        return this.a.s.getSubtitle();
    }

    public final boolean h() {
        return this.a.s.h;
    }

    public final View i() {
        return this.g != null ? (View) this.g.get() : null;
    }
}
