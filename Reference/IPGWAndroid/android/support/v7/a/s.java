package android.support.v7.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ax;
import android.support.v4.app.be;
import android.support.v4.app.bf;
import android.support.v4.app.q;
import android.support.v4.view.z;
import android.support.v7.widget.fs;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class s extends q implements bf, t {
    private u l;
    private int m = 0;
    private boolean n;
    private Resources o;

    private boolean d() {
        int i = 0;
        Intent a = ax.a(this);
        if (a == null) {
            return false;
        }
        if (ax.a((Activity) this, a)) {
            be a2 = be.a((Context) this);
            a = this instanceof bf ? a() : null;
            Intent a3 = a == null ? ax.a(this) : a;
            if (a3 != null) {
                ComponentName component = a3.getComponent();
                if (component == null) {
                    component = a3.resolveActivity(a2.b.getPackageManager());
                }
                a2.a(component);
                a2.a.add(a3);
            }
            if (a2.a.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) a2.a.toArray(new Intent[a2.a.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Context context = a2.b;
            int i2 = VERSION.SDK_INT;
            if (i2 >= 16) {
                context.startActivities(intentArr, null);
                i = 1;
            } else if (i2 >= 11) {
                context.startActivities(intentArr);
                i = 1;
            }
            if (i == 0) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                a2.b.startActivity(intent);
            }
            try {
                if (VERSION.SDK_INT >= 16) {
                    finishAffinity();
                } else {
                    finish();
                }
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            ax.b((Activity) this, a);
        }
        return true;
    }

    public final Intent a() {
        return ax.a(this);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        c().b(view, layoutParams);
    }

    public final void b() {
        c().f();
    }

    public final u c() {
        if (this.l == null) {
            this.l = u.a((Activity) this, (t) this);
        }
        return this.l;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 19) {
            int action = keyEvent.getAction();
            if (action == 0) {
                if (z.a(keyEvent, 2)) {
                    a a = c().a();
                    if (a != null && a.e() && a.i()) {
                        this.n = true;
                        return true;
                    }
                }
            } else if (action == 1 && this.n) {
                this.n = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public View findViewById(int i) {
        return c().a(i);
    }

    public MenuInflater getMenuInflater() {
        return c().b();
    }

    public Resources getResources() {
        if (this.o == null) {
            this.o = new fs(this, super.getResources());
        }
        return this.o;
    }

    public void invalidateOptionsMenu() {
        c().f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c().a(configuration);
        if (this.o != null) {
            this.o.updateConfiguration(configuration, null);
        }
    }

    public void onContentChanged() {
    }

    public void onCreate(Bundle bundle) {
        u c = c();
        c.h();
        c.a(bundle);
        if (c.i() && this.m != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.m, false);
            } else {
                setTheme(this.m);
            }
        }
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        c().g();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a a = c().a();
        return (menuItem.getItemId() != 16908332 || a == null || (a.d() & 4) == 0) ? false : d();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        c().c();
    }

    protected void onPostResume() {
        super.onPostResume();
        c().e();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        c().b(bundle);
    }

    public void onStop() {
        super.onStop();
        c().d();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        c().a(charSequence);
    }

    public void setContentView(int i) {
        c().b(i);
    }

    public void setContentView(View view) {
        c().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        c().a(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.m = i;
    }
}
