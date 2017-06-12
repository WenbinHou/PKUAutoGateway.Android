package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.g.d;
import android.support.v4.g.e;
import android.support.v4.view.an;
import android.support.v4.view.bq;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class y extends x implements an {
    static final Interpolator A = new DecelerateInterpolator(2.5f);
    static final Interpolator B = new DecelerateInterpolator(1.5f);
    static final Interpolator C = new AccelerateInterpolator(2.5f);
    static final Interpolator D = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static final boolean b;
    static Field r = null;
    ArrayList<Runnable> c;
    Runnable[] d;
    boolean e;
    ArrayList<n> f;
    ArrayList<n> g;
    ArrayList<Integer> h;
    ArrayList<e> i;
    ArrayList<n> j;
    ArrayList<e> k;
    ArrayList<Integer> l;
    ArrayList<Object> m;
    int n = 0;
    w o;
    u p;
    n q;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    Bundle x = null;
    SparseArray<Parcelable> y = null;
    Runnable z = new z(this);

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        b = z;
    }

    y() {
    }

    private n a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        n nVar = (n) this.f.get(i);
        if (nVar != null) {
            return nVar;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return nVar;
    }

    private static Animation a(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    private static Animation a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private Animation a(n nVar, int i, boolean z, int i2) {
        int i3 = nVar.G;
        n.i();
        if (nVar.G != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.o.c, nVar.G);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        Object obj = -1;
        switch (i) {
            case 4097:
                if (!z) {
                    obj = 2;
                    break;
                }
                obj = 1;
                break;
            case 4099:
                if (!z) {
                    obj = 6;
                    break;
                }
                obj = 5;
                break;
            case 8194:
                if (!z) {
                    obj = 4;
                    break;
                }
                obj = 3;
                break;
        }
        if (obj < null) {
            return null;
        }
        switch (obj) {
            case 1:
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(0.0f, 1.0f);
            case 6:
                return a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.o.e()) {
                    i2 = this.o.f();
                }
                return i2 == 0 ? null : null;
        }
    }

    private void a(int i, e eVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int size = this.k.size();
            if (i < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + eVar);
                }
                this.k.set(i, eVar);
            } else {
                while (size < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.l.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + eVar);
                }
                this.k.add(eVar);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
        if (this.o != null) {
            try {
                this.o.a("  ", printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    static boolean a(View view, Animation animation) {
        if (VERSION.SDK_INT < 19 || bq.g(view) != 0 || !bq.z(view)) {
            return false;
        }
        boolean z;
        if (animation instanceof AlphaAnimation) {
            z = true;
        } else {
            if (animation instanceof AnimationSet) {
                List animations = ((AnimationSet) animation).getAnimations();
                for (int i = 0; i < animations.size(); i++) {
                    if (animations.get(i) instanceof AlphaAnimation) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    public static int b(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private static void b(View view, Animation animation) {
        if (view != null && animation != null && a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (r == null) {
                    Field declaredField = Animation.class.getDeclaredField("mListener");
                    r = declaredField;
                    declaredField.setAccessible(true);
                }
                animationListener = (AnimationListener) r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new ab(view, animation, animationListener));
        }
    }

    private n c(int i) {
        int size;
        n nVar;
        if (this.g != null) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                nVar = (n) this.g.get(size);
                if (nVar != null && nVar.w == i) {
                    return nVar;
                }
            }
        }
        if (this.f != null) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                nVar = (n) this.f.get(size);
                if (nVar != null && nVar.w == i) {
                    return nVar;
                }
            }
        }
        return null;
    }

    private void c(n nVar) {
        a(nVar, this.n, 0, 0, false);
    }

    private void d(n nVar) {
        if (nVar.J != null) {
            if (this.y == null) {
                this.y = new SparseArray();
            } else {
                this.y.clear();
            }
            nVar.J.saveHierarchyState(this.y);
            if (this.y.size() > 0) {
                nVar.f = this.y;
                this.y = null;
            }
        }
    }

    private void n() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                n nVar = (n) this.f.get(i);
                if (nVar != null) {
                    a(nVar);
                }
            }
        }
    }

    public final int a(e eVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                size = this.k.size();
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + eVar);
                }
                this.k.add(eVar);
            } else {
                size = ((Integer) this.l.remove(this.l.size() - 1)).intValue();
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + eVar);
                }
                this.k.set(size, eVar);
            }
        }
        return size;
    }

    public final ai a() {
        return new e(this);
    }

    public final n a(String str) {
        int size;
        n nVar;
        if (!(this.g == null || str == null)) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                nVar = (n) this.g.get(size);
                if (nVar != null && str.equals(nVar.y)) {
                    return nVar;
                }
            }
        }
        if (!(this.f == null || str == null)) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                nVar = (n) this.f.get(size);
                if (nVar != null && str.equals(nVar.y)) {
                    return nVar;
                }
            }
        }
        return null;
    }

    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ae.a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!n.b(this.o.c, string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        n nVar;
        n c = resourceId != -1 ? c(resourceId) : null;
        if (c == null && string2 != null) {
            c = a(string2);
        }
        if (c == null && id != -1) {
            c = c(id);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + c);
        }
        if (c == null) {
            n a = n.a(context, string);
            a.o = true;
            a.w = resourceId != 0 ? resourceId : id;
            a.x = id;
            a.y = string2;
            a.p = true;
            a.s = this;
            a.t = this.o;
            Bundle bundle = a.e;
            a.h();
            a(a, true);
            nVar = a;
        } else if (c.p) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            c.p = true;
            c.t = this.o;
            if (!c.C) {
                Bundle bundle2 = c.e;
                c.h();
            }
            nVar = c;
        }
        if (this.n > 0 || !nVar.o) {
            c(nVar);
        } else {
            a(nVar, 1, 0, 0, false);
        }
        if (nVar.I == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            nVar.I.setId(resourceId);
        }
        if (nVar.I.getTag() == null) {
            nVar.I.setTag(string2);
        }
        return nVar.I;
    }

    final void a(int i) {
        a(i, 0, 0, false);
    }

    final void a(int i, int i2, int i3, boolean z) {
        if (this.o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.n != i) {
            this.n = i;
            if (this.f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f.size()) {
                    int a;
                    n nVar = (n) this.f.get(i4);
                    if (nVar != null) {
                        a(nVar, i, i2, i3, false);
                        if (nVar.M != null) {
                            a = i5 | nVar.M.a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    n();
                }
                if (this.s && this.o != null && this.n == 5) {
                    this.o.d();
                    this.s = false;
                }
            }
        }
    }

    public final void a(Configuration configuration) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                n nVar = (n) this.g.get(i);
                if (nVar != null) {
                    nVar.onConfigurationChanged(configuration);
                    if (nVar.u != null) {
                        nVar.u.a(configuration);
                    }
                }
            }
        }
    }

    final void a(Parcelable parcelable, List<n> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                int i;
                n nVar;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        nVar = (n) list.get(i);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + nVar);
                        }
                        FragmentState fragmentState = fragmentManagerState.a[nVar.g];
                        fragmentState.k = nVar;
                        nVar.f = null;
                        nVar.r = 0;
                        nVar.p = false;
                        nVar.m = false;
                        nVar.j = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.o.c.getClassLoader());
                            nVar.f = fragmentState.j.getSparseParcelableArray("android:view_state");
                            nVar.e = fragmentState.j;
                        }
                    }
                }
                this.f = new ArrayList(fragmentManagerState.a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i2];
                    if (fragmentState2 != null) {
                        w wVar = this.o;
                        n nVar2 = this.q;
                        if (fragmentState2.k == null) {
                            Context context = wVar.c;
                            if (fragmentState2.i != null) {
                                fragmentState2.i.setClassLoader(context.getClassLoader());
                            }
                            fragmentState2.k = n.a(context, fragmentState2.a, fragmentState2.i);
                            if (fragmentState2.j != null) {
                                fragmentState2.j.setClassLoader(context.getClassLoader());
                                fragmentState2.k.e = fragmentState2.j;
                            }
                            fragmentState2.k.a(fragmentState2.b, nVar2);
                            fragmentState2.k.o = fragmentState2.c;
                            fragmentState2.k.q = true;
                            fragmentState2.k.w = fragmentState2.d;
                            fragmentState2.k.x = fragmentState2.e;
                            fragmentState2.k.y = fragmentState2.f;
                            fragmentState2.k.B = fragmentState2.g;
                            fragmentState2.k.A = fragmentState2.h;
                            fragmentState2.k.s = wVar.f;
                            if (a) {
                                Log.v("FragmentManager", "Instantiated fragment " + fragmentState2.k);
                            }
                        }
                        n nVar3 = fragmentState2.k;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + nVar3);
                        }
                        this.f.add(nVar3);
                        fragmentState2.k = null;
                    } else {
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        nVar = (n) list.get(i3);
                        if (nVar.k >= 0) {
                            if (nVar.k < this.f.size()) {
                                nVar.j = (n) this.f.get(nVar.k);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + nVar + " target no longer exists: " + nVar.k);
                                nVar.j = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList(fragmentManagerState.b.length);
                    for (i = 0; i < fragmentManagerState.b.length; i++) {
                        nVar = (n) this.f.get(fragmentManagerState.b[i]);
                        if (nVar == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i]));
                        }
                        nVar.m = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + nVar);
                        }
                        if (this.g.contains(nVar)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.g.add(nVar);
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.c != null) {
                    this.i = new ArrayList(fragmentManagerState.c.length);
                    for (i2 = 0; i2 < fragmentManagerState.c.length; i2++) {
                        e a = fragmentManagerState.c[i2].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a.p + "): " + a);
                            a.a("  ", new PrintWriter(new e("FragmentManager")), false);
                        }
                        this.i.add(a);
                        if (a.p >= 0) {
                            a(a.p, a);
                        }
                    }
                    return;
                }
                this.i = null;
            }
        }
    }

    public final void a(n nVar) {
        if (!nVar.K) {
            return;
        }
        if (this.e) {
            this.w = true;
            return;
        }
        nVar.K = false;
        a(nVar, this.n, 0, 0, false);
    }

    public final void a(n nVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "remove: " + nVar + " nesting=" + nVar.r);
        }
        boolean z = !(nVar.r > 0);
        if (!nVar.A || z) {
            if (this.g != null) {
                this.g.remove(nVar);
            }
            if (nVar.D && nVar.E) {
                this.s = true;
            }
            nVar.m = false;
            nVar.n = true;
            a(nVar, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(n nVar, int i, int i2, int i3, boolean z) {
        if ((!nVar.m || nVar.A) && i > 1) {
            i = 1;
        }
        if (nVar.n && r12 > nVar.b) {
            i = nVar.b;
        }
        if (nVar.K && nVar.b < 4 && r12 > 3) {
            i = 3;
        }
        if (nVar.b >= i) {
            if (nVar.b > i) {
                switch (nVar.b) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        if (i < 5) {
                            if (a) {
                                Log.v("FragmentManager", "movefrom RESUMED: " + nVar);
                            }
                            if (nVar.u != null) {
                                nVar.u.a(4);
                            }
                            nVar.b = 4;
                            nVar.F = false;
                            nVar.F = true;
                            if (!nVar.F) {
                                throw new bd("Fragment " + nVar + " did not call through to super.onPause()");
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        } else if (!nVar.o || nVar.p) {
            if (nVar.c != null) {
                nVar.c = null;
                a(nVar, nVar.d, 0, 0, true);
            }
            switch (nVar.b) {
                case 0:
                    if (a) {
                        Log.v("FragmentManager", "moveto CREATED: " + nVar);
                    }
                    if (nVar.e != null) {
                        nVar.e.setClassLoader(this.o.c.getClassLoader());
                        nVar.f = nVar.e.getSparseParcelableArray("android:view_state");
                        nVar.j = a(nVar.e, "android:target_state");
                        if (nVar.j != null) {
                            nVar.l = nVar.e.getInt("android:target_req_state", 0);
                        }
                        nVar.L = nVar.e.getBoolean("android:user_visible_hint", true);
                        if (!nVar.L) {
                            nVar.K = true;
                            if (i > 3) {
                                i = 3;
                            }
                        }
                    }
                    nVar.t = this.o;
                    nVar.v = this.q;
                    nVar.s = this.q != null ? this.q.u : this.o.f;
                    nVar.F = false;
                    nVar.F = true;
                    if ((nVar.t == null ? null : nVar.t.b) != null) {
                        nVar.F = false;
                        nVar.F = true;
                    }
                    if (nVar.F) {
                        Bundle bundle;
                        n nVar2 = nVar.v;
                        if (!nVar.C) {
                            bundle = nVar.e;
                            if (nVar.u != null) {
                                nVar.u.t = false;
                            }
                            nVar.b = 1;
                            nVar.F = false;
                            nVar.F = true;
                            if (!nVar.F) {
                                throw new bd("Fragment " + nVar + " did not call through to super.onCreate()");
                            } else if (bundle != null) {
                                Parcelable parcelable = bundle.getParcelable("android:support:fragments");
                                if (parcelable != null) {
                                    if (nVar.u == null) {
                                        nVar.n();
                                    }
                                    nVar.u.a(parcelable, null);
                                    nVar.u.g();
                                }
                            }
                        }
                        nVar.C = false;
                        if (nVar.o) {
                            bundle = nVar.e;
                            LayoutInflater g = nVar.g();
                            Bundle bundle2 = nVar.e;
                            nVar.I = nVar.b(g, null);
                            if (nVar.I == null) {
                                nVar.J = null;
                                break;
                            }
                            nVar.J = nVar.I;
                            if (VERSION.SDK_INT >= 11) {
                                bq.y(nVar.I);
                            } else {
                                nVar.I = bb.a(nVar.I);
                            }
                            if (nVar.z) {
                                nVar.I.setVisibility(8);
                            }
                            nVar.a(nVar.I, nVar.e);
                            break;
                        }
                    }
                    throw new bd("Fragment " + nVar + " did not call through to super.onAttach()");
                    break;
                case 1:
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    break;
            }
        } else {
            return;
        }
        if (nVar.b != i) {
            Log.w("FragmentManager", "moveToState: Fragment state for " + nVar + " not updated inline; expected state " + i + " found " + nVar.b);
            nVar.b = i;
        }
    }

    public final void a(n nVar, boolean z) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (a) {
            Log.v("FragmentManager", "add: " + nVar);
        }
        b(nVar);
        if (!nVar.A) {
            if (this.g.contains(nVar)) {
                throw new IllegalStateException("Fragment already added: " + nVar);
            }
            this.g.add(nVar);
            nVar.m = true;
            nVar.n = false;
            if (nVar.D && nVar.E) {
                this.s = true;
            }
            if (z) {
                c(nVar);
            }
        }
    }

    public final void a(w wVar, u uVar, n nVar) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = wVar;
        this.p = uVar;
        this.q = nVar;
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        n nVar;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f != null) {
            size = this.f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    nVar = (n) this.f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(nVar);
                    if (nVar != null) {
                        printWriter.print(str2);
                        printWriter.print("mFragmentId=#");
                        printWriter.print(Integer.toHexString(nVar.w));
                        printWriter.print(" mContainerId=#");
                        printWriter.print(Integer.toHexString(nVar.x));
                        printWriter.print(" mTag=");
                        printWriter.println(nVar.y);
                        printWriter.print(str2);
                        printWriter.print("mState=");
                        printWriter.print(nVar.b);
                        printWriter.print(" mIndex=");
                        printWriter.print(nVar.g);
                        printWriter.print(" mWho=");
                        printWriter.print(nVar.h);
                        printWriter.print(" mBackStackNesting=");
                        printWriter.println(nVar.r);
                        printWriter.print(str2);
                        printWriter.print("mAdded=");
                        printWriter.print(nVar.m);
                        printWriter.print(" mRemoving=");
                        printWriter.print(nVar.n);
                        printWriter.print(" mFromLayout=");
                        printWriter.print(nVar.o);
                        printWriter.print(" mInLayout=");
                        printWriter.println(nVar.p);
                        printWriter.print(str2);
                        printWriter.print("mHidden=");
                        printWriter.print(nVar.z);
                        printWriter.print(" mDetached=");
                        printWriter.print(nVar.A);
                        printWriter.print(" mMenuVisible=");
                        printWriter.print(nVar.E);
                        printWriter.print(" mHasMenu=");
                        printWriter.println(nVar.D);
                        printWriter.print(str2);
                        printWriter.print("mRetainInstance=");
                        printWriter.print(nVar.B);
                        printWriter.print(" mRetaining=");
                        printWriter.print(nVar.C);
                        printWriter.print(" mUserVisibleHint=");
                        printWriter.println(nVar.L);
                        if (nVar.s != null) {
                            printWriter.print(str2);
                            printWriter.print("mFragmentManager=");
                            printWriter.println(nVar.s);
                        }
                        if (nVar.t != null) {
                            printWriter.print(str2);
                            printWriter.print("mHost=");
                            printWriter.println(nVar.t);
                        }
                        if (nVar.v != null) {
                            printWriter.print(str2);
                            printWriter.print("mParentFragment=");
                            printWriter.println(nVar.v);
                        }
                        if (nVar.i != null) {
                            printWriter.print(str2);
                            printWriter.print("mArguments=");
                            printWriter.println(nVar.i);
                        }
                        if (nVar.e != null) {
                            printWriter.print(str2);
                            printWriter.print("mSavedFragmentState=");
                            printWriter.println(nVar.e);
                        }
                        if (nVar.f != null) {
                            printWriter.print(str2);
                            printWriter.print("mSavedViewState=");
                            printWriter.println(nVar.f);
                        }
                        if (nVar.j != null) {
                            printWriter.print(str2);
                            printWriter.print("mTarget=");
                            printWriter.print(nVar.j);
                            printWriter.print(" mTargetRequestCode=");
                            printWriter.println(nVar.l);
                        }
                        if (nVar.G != 0) {
                            printWriter.print(str2);
                            printWriter.print("mNextAnim=");
                            printWriter.println(nVar.G);
                        }
                        if (nVar.H != null) {
                            printWriter.print(str2);
                            printWriter.print("mContainer=");
                            printWriter.println(nVar.H);
                        }
                        if (nVar.I != null) {
                            printWriter.print(str2);
                            printWriter.print("mView=");
                            printWriter.println(nVar.I);
                        }
                        if (nVar.J != null) {
                            printWriter.print(str2);
                            printWriter.print("mInnerView=");
                            printWriter.println(nVar.I);
                        }
                        if (nVar.c != null) {
                            printWriter.print(str2);
                            printWriter.print("mAnimatingAway=");
                            printWriter.println(nVar.c);
                            printWriter.print(str2);
                            printWriter.print("mStateAfterAnimating=");
                            printWriter.println(nVar.d);
                        }
                        if (nVar.M != null) {
                            printWriter.print(str2);
                            printWriter.println("Loader Manager:");
                            nVar.M.a(str2 + "  ", printWriter);
                        }
                        if (nVar.u != null) {
                            printWriter.print(str2);
                            printWriter.println("Child " + nVar.u + ":");
                            nVar.u.a(str2 + "  ", fileDescriptor, printWriter, strArr);
                        }
                    }
                }
            }
        }
        if (this.g != null) {
            size = this.g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    nVar = (n) this.g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(nVar.toString());
                }
            }
        }
        if (this.j != null) {
            size = this.j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    nVar = (n) this.j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(nVar.toString());
                }
            }
        }
        if (this.i != null) {
            size = this.i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    e eVar = (e) this.i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(eVar.toString());
                    eVar.a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.k != null) {
                int size2 = this.k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        eVar = (e) this.k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(eVar);
                    }
                }
            }
            if (this.l != null && this.l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.l.toArray()));
            }
        }
        if (this.c != null) {
            i = this.c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.s);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
        if (this.h != null && this.h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.h.toArray()));
        }
    }

    public final boolean a(Menu menu) {
        if (this.g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.g.size(); i++) {
            n nVar = (n) this.g.get(i);
            if (nVar != null) {
                int i2;
                if (nVar.z) {
                    i2 = 0;
                } else {
                    i2 = (nVar.D && nVar.E) ? 1 : 0;
                    if (nVar.u != null) {
                        i2 |= nVar.u.a(menu);
                    }
                }
                if (i2 != 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        int i = 0;
        ArrayList arrayList = null;
        if (this.g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.g.size()) {
                boolean z2;
                n nVar = (n) this.g.get(i2);
                if (nVar != null) {
                    int i3;
                    if (nVar.z) {
                        i3 = 0;
                    } else {
                        i3 = (nVar.D && nVar.E) ? 1 : 0;
                        if (nVar.u != null) {
                            i3 |= nVar.u.a(menu, menuInflater);
                        }
                    }
                    if (i3 != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(nVar);
                        z2 = true;
                        i2++;
                        z = z2;
                    }
                }
                z2 = z;
                i2++;
                z = z2;
            }
        } else {
            z = false;
        }
        if (this.j != null) {
            while (i < this.j.size()) {
                nVar = (n) this.j.get(i);
                if (arrayList == null || !arrayList.contains(nVar)) {
                    n.m();
                }
                i++;
            }
        }
        this.j = arrayList;
        return z;
    }

    public final boolean a(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            n nVar = (n) this.g.get(i);
            if (nVar != null) {
                boolean z = (nVar.z || nVar.u == null || !nVar.u.a(menuItem)) ? false : true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final n b(String str) {
        if (!(this.f == null || str == null)) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                n nVar = (n) this.f.get(size);
                if (nVar != null) {
                    if (!str.equals(nVar.h)) {
                        nVar = nVar.u != null ? nVar.u.b(str) : null;
                    }
                    if (nVar != null) {
                        return nVar;
                    }
                }
            }
        }
        return null;
    }

    final void b(n nVar) {
        if (nVar.g < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                nVar.a(this.f.size(), this.q);
                this.f.add(nVar);
            } else {
                nVar.a(((Integer) this.h.remove(this.h.size() - 1)).intValue(), this.q);
                this.f.set(nVar.g, nVar);
            }
            if (a) {
                Log.v("FragmentManager", "Allocated fragment index " + nVar);
            }
        }
    }

    public final void b(n nVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "hide: " + nVar);
        }
        if (!nVar.z) {
            nVar.z = true;
            if (nVar.I != null) {
                Animation a = a(nVar, i, false, i2);
                if (a != null) {
                    b(nVar.I, a);
                    nVar.I.startAnimation(a);
                }
                nVar.I.setVisibility(8);
            }
            if (nVar.m && nVar.D && nVar.E) {
                this.s = true;
            }
            n.e();
        }
    }

    public final void b(Menu menu) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                n nVar = (n) this.g.get(i);
                if (!(nVar == null || nVar.z || nVar.u == null)) {
                    nVar.u.b(menu);
                }
            }
        }
    }

    public final boolean b() {
        return d();
    }

    public final boolean b(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            n nVar = (n) this.g.get(i);
            if (nVar != null) {
                boolean z = (nVar.z || nVar.u == null || !nVar.u.b(menuItem)) ? false : true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void c(n nVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "show: " + nVar);
        }
        if (nVar.z) {
            nVar.z = false;
            if (nVar.I != null) {
                Animation a = a(nVar, i, true, i2);
                if (a != null) {
                    b(nVar.I, a);
                    nVar.I.startAnimation(a);
                }
                nVar.I.setVisibility(0);
            }
            if (nVar.m && nVar.D && nVar.E) {
                this.s = true;
            }
            n.e();
        }
    }

    public final boolean c() {
        if (this.t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        } else {
            d();
            if (this.i == null) {
                return false;
            }
            int size = this.i.size() - 1;
            if (size < 0) {
                return false;
            }
            e eVar = (e) this.i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            eVar.a(sparseArray, sparseArray2);
            eVar.a(null, sparseArray, sparseArray2);
            e();
            return true;
        }
    }

    public final void d(n nVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "detach: " + nVar);
        }
        if (!nVar.A) {
            nVar.A = true;
            if (nVar.m) {
                if (this.g != null) {
                    if (a) {
                        Log.v("FragmentManager", "remove from detach: " + nVar);
                    }
                    this.g.remove(nVar);
                }
                if (nVar.D && nVar.E) {
                    this.s = true;
                }
                nVar.m = false;
                a(nVar, 1, i, i2, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d() {
        if (this.e) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        } else if (Looper.myLooper() != this.o.d.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        } else {
            int size;
            boolean z = false;
            while (true) {
                synchronized (this) {
                    if (this.c == null || this.c.size() == 0) {
                    } else {
                        size = this.c.size();
                        if (this.d == null || this.d.length < size) {
                            this.d = new Runnable[size];
                        }
                        this.c.toArray(this.d);
                        this.c.clear();
                        this.o.d.removeCallbacks(this.z);
                    }
                }
                this.e = false;
                z = true;
            }
            if (this.w) {
                int i = 0;
                for (size = 0; size < this.f.size(); size++) {
                    n nVar = (n) this.f.get(size);
                    if (!(nVar == null || nVar.M == null)) {
                        i |= nVar.M.a();
                    }
                }
                if (i == 0) {
                    this.w = false;
                    n();
                }
            }
            return z;
        }
    }

    final void e() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i++) {
                this.m.get(i);
            }
        }
    }

    public final void e(n nVar, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "attach: " + nVar);
        }
        if (nVar.A) {
            nVar.A = false;
            if (!nVar.m) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                if (this.g.contains(nVar)) {
                    throw new IllegalStateException("Fragment already added: " + nVar);
                }
                if (a) {
                    Log.v("FragmentManager", "add from attach: " + nVar);
                }
                this.g.add(nVar);
                nVar.m = true;
                if (nVar.D && nVar.E) {
                    this.s = true;
                }
                a(nVar, this.n, i, i2, false);
            }
        }
    }

    final Parcelable f() {
        BackStackState[] backStackStateArr = null;
        d();
        if (b) {
            this.t = true;
        }
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            n nVar = (n) this.f.get(i);
            if (nVar != null) {
                if (nVar.g < 0) {
                    a(new IllegalStateException("Failure saving state: active " + nVar + " has cleared index: " + nVar.g));
                }
                FragmentState fragmentState = new FragmentState(nVar);
                fragmentStateArr[i] = fragmentState;
                if (nVar.b <= 0 || fragmentState.j != null) {
                    fragmentState.j = nVar.e;
                } else {
                    Bundle bundle;
                    if (this.x == null) {
                        this.x = new Bundle();
                    }
                    nVar.b(this.x);
                    if (this.x.isEmpty()) {
                        bundle = null;
                    } else {
                        bundle = this.x;
                        this.x = null;
                    }
                    if (nVar.I != null) {
                        d(nVar);
                    }
                    if (nVar.f != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", nVar.f);
                    }
                    if (!nVar.L) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", nVar.L);
                    }
                    fragmentState.j = bundle;
                    if (nVar.j != null) {
                        if (nVar.j.g < 0) {
                            a(new IllegalStateException("Failure saving state: " + nVar + " has target not in fragment manager: " + nVar.j));
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        bundle = fragmentState.j;
                        String str = "android:target_state";
                        n nVar2 = nVar.j;
                        if (nVar2.g < 0) {
                            a(new IllegalStateException("Fragment " + nVar2 + " is not currently in the FragmentManager"));
                        }
                        bundle.putInt(str, nVar2.g);
                        if (nVar.l != 0) {
                            fragmentState.j.putInt("android:target_req_state", nVar.l);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + nVar + ": " + fragmentState.j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.g != null) {
                i = this.g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((n) this.g.get(i2)).g;
                        if (iArr[i2] < 0) {
                            a(new IllegalStateException("Failure saving state: active " + this.g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.g.get(i2));
                        }
                    }
                    if (this.i != null) {
                        i = this.i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((e) this.i.get(i2));
                                if (a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.a = fragmentStateArr;
                    fragmentManagerState.b = iArr;
                    fragmentManagerState.c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.i != null) {
                i = this.i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((e) this.i.get(i2));
                        if (a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = fragmentStateArr;
            fragmentManagerState.b = iArr;
            fragmentManagerState.c = backStackStateArr;
            return fragmentManagerState;
        } else if (!a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public final void g() {
        this.t = false;
        a(1);
    }

    public final void h() {
        this.t = false;
        a(2);
    }

    public final void i() {
        this.t = false;
        a(4);
    }

    public final void j() {
        this.t = false;
        a(5);
    }

    public final void k() {
        this.t = true;
        a(3);
    }

    public final void l() {
        this.u = true;
        d();
        a(0);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public final void m() {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                n nVar = (n) this.g.get(i);
                if (nVar != null) {
                    nVar.onLowMemory();
                    if (nVar.u != null) {
                        nVar.u.m();
                    }
                }
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.q != null) {
            d.a(this.q, stringBuilder);
        } else {
            d.a(this.o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
