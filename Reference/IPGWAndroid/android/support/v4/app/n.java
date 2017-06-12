package android.support.v4.app;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.g.d;
import android.support.v4.g.r;
import android.support.v4.view.ae;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;

public class n implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final r<String, Class<?>> Z = new r();
    static final Object a = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E = true;
    boolean F;
    int G;
    ViewGroup H;
    public View I;
    View J;
    boolean K;
    boolean L = true;
    av M;
    boolean N;
    boolean O;
    Object P = null;
    Object Q = a;
    Object R = null;
    Object S = a;
    Object T = null;
    Object U = a;
    Boolean V;
    Boolean W;
    bc X = null;
    bc Y = null;
    int b = 0;
    View c;
    int d;
    Bundle e;
    SparseArray<Parcelable> f;
    int g = -1;
    String h;
    Bundle i;
    n j;
    int k = -1;
    int l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    y s;
    public w t;
    y u;
    n v;
    int w;
    int x;
    String y;
    boolean z;

    public static n a(Context context, String str) {
        return a(context, str, null);
    }

    public static n a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) Z.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                Z.put(str, cls);
            }
            n nVar = (n) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(nVar.getClass().getClassLoader());
                nVar.i = bundle;
            }
            return nVar;
        } catch (Exception e) {
            throw new p("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (Exception e2) {
            throw new p("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new p("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e22);
        }
    }

    static boolean b(Context context, String str) {
        try {
            Class cls = (Class) Z.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                Z.put(str, cls);
            }
            return n.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static void e() {
    }

    public static void f() {
    }

    public static Animation i() {
        return null;
    }

    public static void m() {
    }

    public final Context a() {
        return this.t == null ? null : this.t.c;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void a(int i, int i2, Intent intent) {
    }

    final void a(int i, n nVar) {
        this.g = i;
        if (nVar != null) {
            this.h = nVar.h + ":" + this.g;
        } else {
            this.h = "android:fragment:" + this.g;
        }
    }

    public final void a(Intent intent) {
        if (this.t == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.t.a(this, intent, -1);
    }

    public void a(Bundle bundle) {
        this.F = true;
    }

    public void a(View view, Bundle bundle) {
    }

    public final void a(boolean z) {
        if (this.E != z) {
            this.E = z;
            if (this.D && d() && !this.z) {
                this.t.d();
            }
        }
    }

    public final q b() {
        return this.t == null ? null : (q) this.t.b;
    }

    final View b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.u != null) {
            this.u.t = false;
        }
        return a(layoutInflater, viewGroup);
    }

    final void b(Bundle bundle) {
        if (this.u != null) {
            Parcelable f = this.u.f();
            if (f != null) {
                bundle.putParcelable("android:support:fragments", f);
            }
        }
    }

    public void b(boolean z) {
        if (!this.L && z && this.b < 4) {
            this.s.a(this);
        }
        this.L = z;
        this.K = !z;
    }

    public final Resources c() {
        if (this.t != null) {
            return this.t.c.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final boolean d() {
        return this.t != null && this.m;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final LayoutInflater g() {
        LayoutInflater c = this.t.c();
        if (this.u == null) {
            n();
            if (this.b >= 5) {
                this.u.j();
            } else if (this.b >= 4) {
                this.u.i();
            } else if (this.b >= 2) {
                this.u.h();
            } else if (this.b > 0) {
                this.u.g();
            }
        }
        ae.a(c, this.u);
        return c;
    }

    public final void h() {
        this.F = true;
        if ((this.t == null ? null : this.t.b) != null) {
            this.F = false;
            this.F = true;
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void j() {
        this.F = true;
        if (!this.N) {
            this.N = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.b(this.h);
            }
            if (this.M != null) {
                this.M.b();
            }
        }
    }

    public void k() {
        this.F = true;
    }

    public void l() {
        this.F = true;
    }

    final void n() {
        this.u = new y();
        this.u.a(this.t, new o(this), this);
    }

    final void o() {
        if (this.u != null) {
            this.u.a(2);
        }
        this.b = 2;
        if (this.N) {
            this.N = false;
            if (!this.O) {
                this.O = true;
                this.M = this.t.b(this.h);
            }
            if (this.M == null) {
                return;
            }
            if (this.t.h) {
                this.M.d();
            } else {
                this.M.c();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.F = true;
    }

    final void p() {
        if (this.u != null) {
            this.u.l();
        }
        this.b = 0;
        this.F = false;
        this.F = true;
        if (!this.O) {
            this.O = true;
            this.M = this.t.b(this.h);
        }
        if (this.M != null) {
            this.M.g();
        }
        if (!this.F) {
            throw new bd("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        d.a(this, stringBuilder);
        if (this.g >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.g);
        }
        if (this.w != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.y);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
