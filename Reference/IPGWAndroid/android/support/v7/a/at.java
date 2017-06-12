package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bq;
import android.support.v7.widget.bu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import ccnet.pku.edu.cn.ipgw_android.R;
import java.util.ArrayList;

final class at extends a {
    bu a;
    Callback b;
    private boolean c;
    private boolean d;
    private ArrayList<Object> e;
    private final Runnable f;

    private void a(int i, int i2) {
        this.a.c((this.a.o() & (i2 ^ -1)) | (i & i2));
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.a.b()).inflate(R.layout.abs_layout, this.a.a(), false);
        LayoutParams bVar = new b();
        if (inflate != null) {
            inflate.setLayoutParams(bVar);
        }
        this.a.a(inflate);
    }

    public final void a(int i) {
        this.a.b(i != 0 ? this.a.b().getText(i) : null);
    }

    public final void a(Configuration configuration) {
        super.a(configuration);
    }

    public final void a(Drawable drawable) {
        this.a.b(drawable);
    }

    public final void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public final void a(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public final boolean a(int i, KeyEvent keyEvent) {
        if (!this.c) {
            this.a.a(new au(), new av());
            this.c = true;
        }
        Menu s = this.a.s();
        if (s != null) {
            s.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            s.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public final void b() {
        a(16, -1);
    }

    public final void b(boolean z) {
    }

    public final View c() {
        return this.a.q();
    }

    public final void c(boolean z) {
    }

    public final int d() {
        return this.a.o();
    }

    public final void d(boolean z) {
        if (z != this.d) {
            this.d = z;
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                this.e.get(i);
            }
        }
    }

    public final boolean e() {
        return this.a.r() == 0;
    }

    public final Context f() {
        return this.a.b();
    }

    public final boolean g() {
        this.a.a().removeCallbacks(this.f);
        bq.a(this.a.a(), this.f);
        return true;
    }

    public final boolean h() {
        if (!this.a.c()) {
            return false;
        }
        this.a.d();
        return true;
    }

    public final boolean i() {
        ViewGroup a = this.a.a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    final void j() {
        this.a.a().removeCallbacks(this.f);
    }
}
