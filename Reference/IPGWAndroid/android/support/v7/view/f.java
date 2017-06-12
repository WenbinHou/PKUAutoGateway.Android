package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class f extends b implements j {
    private Context a;
    private ActionBarContextView d;
    private c e;
    private WeakReference<View> f;
    private boolean g;
    private boolean h;
    private i i;

    public f(Context context, ActionBarContextView actionBarContextView, c cVar, boolean z) {
        this.a = context;
        this.d = actionBarContextView;
        this.e = cVar;
        i iVar = new i(actionBarContextView.getContext());
        this.i = iVar;
        this.i.a((j) this);
        this.h = z;
    }

    public final MenuInflater a() {
        return new MenuInflater(this.d.getContext());
    }

    public final void a(int i) {
        b(this.a.getString(i));
    }

    public final void a(i iVar) {
        d();
        this.d.a();
    }

    public final void a(View view) {
        this.d.setCustomView(view);
        this.f = view != null ? new WeakReference(view) : null;
    }

    public final void a(CharSequence charSequence) {
        this.d.setSubtitle(charSequence);
    }

    public final void a(boolean z) {
        super.a(z);
        this.d.setTitleOptional(z);
    }

    public final boolean a(i iVar, MenuItem menuItem) {
        return this.e.a((b) this, menuItem);
    }

    public final Menu b() {
        return this.i;
    }

    public final void b(int i) {
        a(this.a.getString(i));
    }

    public final void b(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    public final void c() {
        if (!this.g) {
            this.g = true;
            this.d.sendAccessibilityEvent(32);
            this.e.a(this);
        }
    }

    public final void d() {
        this.e.b(this, this.i);
    }

    public final CharSequence f() {
        return this.d.getTitle();
    }

    public final CharSequence g() {
        return this.d.getSubtitle();
    }

    public final boolean h() {
        return this.d.h;
    }

    public final View i() {
        return this.f != null ? (View) this.f.get() : null;
    }
}
