package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class n {
    public o a;
    public p b;
    private final Context c;

    public n(Context context) {
        this.c = context;
    }

    public abstract View a();

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(p pVar) {
        if (this.b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.b = pVar;
    }

    public void a(SubMenu subMenu) {
    }

    public final void a(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }
}
