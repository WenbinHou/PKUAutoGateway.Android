package android.support.v7.a;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.i;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

abstract class v extends u {
    final Context b;
    final Window c;
    final Callback d = this.c.getCallback();
    final Callback e;
    final t f;
    a g;
    MenuInflater h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    CharSequence n;
    boolean o;

    v(Context context, Window window, t tVar) {
        this.b = context;
        this.c = window;
        this.f = tVar;
        if (this.d instanceof w) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.e = a(this.d);
        this.c.setCallback(this.e);
    }

    public final a a() {
        j();
        return this.g;
    }

    Callback a(Callback callback) {
        return new w(this, callback);
    }

    public final void a(CharSequence charSequence) {
        this.n = charSequence;
        b(charSequence);
    }

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(KeyEvent keyEvent);

    public final MenuInflater b() {
        if (this.h == null) {
            j();
            this.h = new i(this.g != null ? this.g.f() : this.b);
        }
        return this.h;
    }

    public void b(Bundle bundle) {
    }

    abstract void b(CharSequence charSequence);

    abstract void d(int i);

    abstract boolean e(int i);

    public void g() {
        this.o = true;
    }

    public boolean i() {
        return false;
    }

    abstract void j();

    final Context k() {
        Context context = null;
        a a = a();
        if (a != null) {
            context = a.f();
        }
        return context == null ? this.b : context;
    }
}
