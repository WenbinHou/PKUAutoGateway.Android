package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.g.a;
import android.support.v4.g.h;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class e extends ai implements Runnable {
    static final boolean a = (VERSION.SDK_INT >= 21);
    final y b;
    i c;
    i d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    boolean l;
    boolean m = true;
    String n;
    boolean o;
    int p = -1;
    int q;
    CharSequence r;
    int s;
    CharSequence t;
    ArrayList<String> u;
    ArrayList<String> v;

    public e(y yVar) {
        this.b = yVar;
    }

    private j a(SparseArray<n> sparseArray, SparseArray<n> sparseArray2, boolean z) {
        int i = 0;
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = (n) sparseArray2.valueAt(i2);
            if (nVar.b <= 0) {
                this.b.b(nVar);
                this.b.a(nVar, 1, 0, 0, false);
            }
        }
        j jVar = new j(this);
        jVar.d = new View(this.b.o.c);
        int i3 = 0;
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            if (a(sparseArray.keyAt(i4), jVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
        }
        while (i < sparseArray2.size()) {
            int keyAt = sparseArray2.keyAt(i);
            if (sparseArray.get(keyAt) == null && a(keyAt, jVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        return i3 == 0 ? null : jVar;
    }

    static /* synthetic */ a a(e eVar, j jVar, boolean z, n nVar) {
        a a;
        Map aVar = new a();
        View view = nVar.I;
        if (!(view == null || eVar.u == null)) {
            aj.a(aVar, view);
            if (z) {
                a = a(eVar.u, eVar.v, (a) aVar);
            } else {
                h.a(aVar, eVar.v);
            }
        }
        bc bcVar;
        if (z) {
            if (nVar.Y != null) {
                bcVar = nVar.Y;
            }
            eVar.a(jVar, a, true);
        } else {
            if (nVar.X != null) {
                bcVar = nVar.X;
            }
            b(jVar, a, true);
        }
        return a;
    }

    private a<String, View> a(j jVar, n nVar, boolean z) {
        a aVar = new a();
        if (this.u != null) {
            aj.a((Map) aVar, nVar.I);
            if (z) {
                h.a((Map) aVar, this.v);
            } else {
                aVar = a(this.u, this.v, aVar);
            }
        }
        bc bcVar;
        if (z) {
            if (nVar.X != null) {
                bcVar = nVar.X;
            }
            a(jVar, aVar, false);
        } else {
            if (nVar.Y != null) {
                bcVar = nVar.Y;
            }
            b(jVar, aVar, false);
        }
        return aVar;
    }

    private static a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        a<String, View> aVar2 = new a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private static Object a(Object obj, n nVar, ArrayList<View> arrayList, a<String, View> aVar, View view) {
        if (obj == null) {
            return obj;
        }
        View view2 = nVar.I;
        if (obj == null) {
            return obj;
        }
        aj.a((ArrayList) arrayList, view2);
        if (aVar != null) {
            arrayList.removeAll(aVar.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view);
        aj.b((Transition) obj, arrayList);
        return obj;
    }

    static /* synthetic */ void a(e eVar, a aVar, j jVar) {
        if (eVar.v != null && !aVar.isEmpty()) {
            View view = (View) aVar.get(eVar.v.get(0));
            if (view != null) {
                jVar.c.a = view;
            }
        }
    }

    private void a(j jVar, int i, Object obj) {
        if (this.b.g != null) {
            for (int i2 = 0; i2 < this.b.g.size(); i2++) {
                n nVar = (n) this.b.g.get(i2);
                if (!(nVar.I == null || nVar.H == null || nVar.x != i)) {
                    if (!nVar.z) {
                        aj.a(obj, nVar.I, false);
                        jVar.b.remove(nVar.I);
                    } else if (!jVar.b.contains(nVar.I)) {
                        aj.a(obj, nVar.I, true);
                        jVar.b.add(nVar.I);
                    }
                }
            }
        }
    }

    private void a(j jVar, a<String, View> aVar, boolean z) {
        int size = this.v == null ? 0 : this.v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.u.get(i);
            View view = (View) aVar.get((String) this.v.get(i));
            if (view != null) {
                String transitionName = view.getTransitionName();
                if (z) {
                    a(jVar.a, str, transitionName);
                } else {
                    a(jVar.a, transitionName, str);
                }
            }
        }
    }

    static /* synthetic */ void a(n nVar, n nVar2, boolean z, a aVar) {
        if ((z ? nVar2.X : nVar.X) != null) {
            ArrayList arrayList = new ArrayList(aVar.keySet());
            arrayList = new ArrayList(aVar.values());
        }
    }

    private static void a(a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.c(i))) {
                    aVar.a(i, (Object) str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(SparseArray<n> sparseArray, SparseArray<n> sparseArray2, n nVar) {
        if (nVar != null) {
            int i = nVar.x;
            if (i != 0 && !nVar.z) {
                if (nVar.d() && nVar.I != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, nVar);
                }
                if (sparseArray2.get(i) == nVar) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private boolean a(int i, j jVar, boolean z, SparseArray<n> sparseArray, SparseArray<n> sparseArray2) {
        View view = (ViewGroup) this.b.p.a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        Object obj2;
        Transition transition;
        Object obj3;
        a aVar;
        Object obj4;
        n nVar = (n) sparseArray2.get(i);
        n nVar2 = (n) sparseArray.get(i);
        if (nVar == null) {
            obj = null;
        } else {
            Object obj5 = z ? nVar.S == n.a ? nVar.R : nVar.S : nVar.P;
            obj = aj.a(obj5);
        }
        if (nVar == null || nVar2 == null) {
            obj2 = null;
        } else {
            obj5 = z ? nVar2.U == n.a ? nVar2.T : nVar2.U : nVar.T;
            if (obj5 == null) {
                obj2 = null;
            } else {
                transition = (Transition) obj5;
                if (transition == null) {
                    obj2 = null;
                } else {
                    obj2 = new TransitionSet();
                    obj2.addTransition(transition);
                }
            }
        }
        if (nVar2 == null) {
            obj3 = null;
        } else {
            obj5 = z ? nVar2.Q == n.a ? nVar2.P : nVar2.Q : nVar2.R;
            obj3 = aj.a(obj5);
        }
        ArrayList arrayList = new ArrayList();
        if (obj2 != null) {
            a a = a(jVar, nVar2, z);
            if (a.isEmpty()) {
                aVar = null;
                obj4 = null;
            } else {
                if ((z ? nVar2.X : nVar.X) != null) {
                    ArrayList arrayList2 = new ArrayList(a.keySet());
                    arrayList2 = new ArrayList(a.values());
                }
                view.getViewTreeObserver().addOnPreDrawListener(new g(this, view, obj2, arrayList, jVar, z, nVar, nVar2));
                aVar = a;
                obj4 = obj2;
            }
        } else {
            aVar = null;
            obj4 = obj2;
        }
        if (obj == null && obj4 == null && obj3 == null) {
            return false;
        }
        boolean z2;
        Object obj6;
        ArrayList arrayList3 = new ArrayList();
        obj2 = a(obj3, nVar2, arrayList3, aVar, jVar.d);
        if (!(this.v == null || aVar == null)) {
            View view2 = (View) aVar.get(this.v.get(0));
            if (view2 != null) {
                if (obj2 != null) {
                    aj.a(obj2, view2);
                }
                if (obj4 != null) {
                    aj.a(obj4, view2);
                }
            }
        }
        ap fVar = new f(this, nVar);
        ArrayList arrayList4 = new ArrayList();
        Map aVar2 = new a();
        if (nVar != null) {
            boolean booleanValue = z ? nVar.V == null ? true : nVar.V.booleanValue() : nVar.W == null ? true : nVar.W.booleanValue();
            z2 = booleanValue;
        } else {
            z2 = true;
        }
        transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj4;
        if (transition == null || transition2 == null) {
            z2 = true;
        }
        if (z2) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
            }
            obj6 = transitionSet;
        } else {
            if (transition2 != null && transition != null) {
                transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
            } else if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 != null) {
                obj6 = new TransitionSet();
                if (transition != null) {
                    obj6.addTransition(transition);
                }
                obj6.addTransition(transition3);
            } else {
                transition2 = transition;
            }
        }
        if (obj6 != null) {
            View view3 = jVar.d;
            ao aoVar = jVar.c;
            Map map = jVar.a;
            if (!(obj == null && obj4 == null)) {
                Transition transition4 = (Transition) obj;
                if (transition4 != null) {
                    transition4.addTarget(view3);
                }
                if (obj4 != null) {
                    aj.a(obj4, view3, aVar, arrayList);
                }
                view.getViewTreeObserver().addOnPreDrawListener(new al(view, transition4, view3, fVar, map, aVar2, arrayList4));
                if (transition4 != null) {
                    transition4.setEpicenterCallback(new am(aoVar));
                }
            }
            view.getViewTreeObserver().addOnPreDrawListener(new h(this, view, jVar, i, obj6));
            aj.a(obj6, jVar.d, true);
            a(jVar, i, obj6);
            TransitionManager.beginDelayedTransition(view, (Transition) obj6);
            View view4 = jVar.d;
            ArrayList arrayList5 = jVar.b;
            Transition transition5 = (Transition) obj;
            Transition transition6 = (Transition) obj2;
            Transition transition7 = (Transition) obj4;
            Transition transition8 = (Transition) obj6;
            if (transition8 != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new an(view, transition5, arrayList4, transition6, arrayList3, transition7, arrayList, aVar2, arrayList5, transition8, view4));
            }
        }
        return obj6 != null;
    }

    private static void b(j jVar, a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) aVar.b(i);
            String transitionName = ((View) aVar.c(i)).getTransitionName();
            if (z) {
                a(jVar.a, str, transitionName);
            } else {
                a(jVar.a, transitionName, str);
            }
        }
    }

    private void b(SparseArray<n> sparseArray, SparseArray<n> sparseArray2) {
        if (this.b.p.a()) {
            for (i iVar = this.c; iVar != null; iVar = iVar.a) {
                switch (iVar.c) {
                    case 1:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 2:
                        n nVar = iVar.d;
                        if (this.b.g != null) {
                            n nVar2 = nVar;
                            for (int i = 0; i < this.b.g.size(); i++) {
                                n nVar3 = (n) this.b.g.get(i);
                                if (nVar2 == null || nVar3.x == nVar2.x) {
                                    if (nVar3 == nVar2) {
                                        nVar2 = null;
                                        sparseArray2.remove(nVar3.x);
                                    } else {
                                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, nVar3);
                                    }
                                }
                            }
                        }
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 3:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 4:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 5:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 6:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 7:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void b(SparseArray<n> sparseArray, SparseArray<n> sparseArray2, n nVar) {
        if (nVar != null) {
            int i = nVar.x;
            if (i != 0) {
                if (!nVar.d()) {
                    sparseArray2.put(i, nVar);
                }
                if (sparseArray.get(i) == nVar) {
                    sparseArray.remove(i);
                }
            }
        }
    }

    public final int a() {
        if (this.o) {
            throw new IllegalStateException("commit already called");
        }
        if (y.a) {
            Log.v("FragmentManager", "Commit: " + this);
            a("  ", new PrintWriter(new android.support.v4.g.e("FragmentManager")));
        }
        this.o = true;
        if (this.l) {
            this.p = this.b.a(this);
        } else {
            this.p = -1;
        }
        y yVar = this.b;
        synchronized (yVar) {
            if (yVar.u || yVar.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (yVar.c == null) {
                yVar.c = new ArrayList();
            }
            yVar.c.add(this);
            if (yVar.c.size() == 1) {
                yVar.o.d.removeCallbacks(yVar.z);
                yVar.o.d.post(yVar.z);
            }
        }
        return this.p;
    }

    public final ai a(int i, n nVar, String str) {
        nVar.s = this.b;
        if (str != null) {
            if (nVar.y == null || str.equals(nVar.y)) {
                nVar.y = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + nVar + ": was " + nVar.y + " now " + str);
            }
        }
        if (i != 0) {
            if (nVar.w == 0 || nVar.w == i) {
                nVar.w = i;
                nVar.x = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + nVar + ": was " + nVar.w + " now " + i);
            }
        }
        i iVar = new i();
        iVar.c = 1;
        iVar.d = nVar;
        a(iVar);
        return this;
    }

    public final ai a(n nVar) {
        i iVar = new i();
        iVar.c = 6;
        iVar.d = nVar;
        a(iVar);
        return this;
    }

    public final j a(j jVar, SparseArray<n> sparseArray, SparseArray<n> sparseArray2) {
        if (y.a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            a("  ", new PrintWriter(new android.support.v4.g.e("FragmentManager")));
        }
        if (a && !(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
            jVar = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
        }
        a(-1);
        int i = jVar != null ? 0 : this.k;
        int i2 = jVar != null ? 0 : this.j;
        i iVar = this.d;
        while (iVar != null) {
            int i3 = jVar != null ? 0 : iVar.g;
            int i4 = jVar != null ? 0 : iVar.h;
            n nVar;
            n nVar2;
            switch (iVar.c) {
                case 1:
                    nVar = iVar.d;
                    nVar.G = i4;
                    this.b.a(nVar, y.b(i2), i);
                    break;
                case 2:
                    nVar = iVar.d;
                    if (nVar != null) {
                        nVar.G = i4;
                        this.b.a(nVar, y.b(i2), i);
                    }
                    if (iVar.i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < iVar.i.size(); i5++) {
                        nVar2 = (n) iVar.i.get(i5);
                        nVar2.G = i3;
                        this.b.a(nVar2, false);
                    }
                    break;
                case 3:
                    nVar2 = iVar.d;
                    nVar2.G = i3;
                    this.b.a(nVar2, false);
                    break;
                case 4:
                    nVar2 = iVar.d;
                    nVar2.G = i3;
                    this.b.c(nVar2, y.b(i2), i);
                    break;
                case 5:
                    nVar = iVar.d;
                    nVar.G = i4;
                    this.b.b(nVar, y.b(i2), i);
                    break;
                case 6:
                    nVar2 = iVar.d;
                    nVar2.G = i3;
                    this.b.e(nVar2, y.b(i2), i);
                    break;
                case 7:
                    nVar2 = iVar.d;
                    nVar2.G = i3;
                    this.b.d(nVar2, y.b(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + iVar.c);
            }
            iVar = iVar.b;
        }
        this.b.a(this.b.n, y.b(i2), i, true);
        if (this.p >= 0) {
            y yVar = this.b;
            i4 = this.p;
            synchronized (yVar) {
                yVar.k.set(i4, null);
                if (yVar.l == null) {
                    yVar.l = new ArrayList();
                }
                if (y.a) {
                    Log.v("FragmentManager", "Freeing back stack index " + i4);
                }
                yVar.l.add(Integer.valueOf(i4));
            }
            this.p = -1;
        }
        return null;
    }

    final void a(int i) {
        if (this.l) {
            if (y.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (i iVar = this.c; iVar != null; iVar = iVar.a) {
                n nVar;
                if (iVar.d != null) {
                    nVar = iVar.d;
                    nVar.r += i;
                    if (y.a) {
                        Log.v("FragmentManager", "Bump nesting of " + iVar.d + " to " + iVar.d.r);
                    }
                }
                if (iVar.i != null) {
                    for (int size = iVar.i.size() - 1; size >= 0; size--) {
                        nVar = (n) iVar.i.get(size);
                        nVar.r += i;
                        if (y.a) {
                            Log.v("FragmentManager", "Bump nesting of " + nVar + " to " + nVar.r);
                        }
                    }
                }
            }
        }
    }

    final void a(i iVar) {
        if (this.c == null) {
            this.d = iVar;
            this.c = iVar;
        } else {
            iVar.b = this.d;
            this.d.a = iVar;
            this.d = iVar;
        }
        iVar.e = this.f;
        iVar.f = this.g;
        iVar.g = this.h;
        iVar.h = this.i;
        this.e++;
    }

    public final void a(SparseArray<n> sparseArray, SparseArray<n> sparseArray2) {
        if (this.b.p.a()) {
            for (i iVar = this.d; iVar != null; iVar = iVar.b) {
                switch (iVar.c) {
                    case 1:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 2:
                        if (iVar.i != null) {
                            for (int size = iVar.i.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray, (SparseArray) sparseArray2, (n) iVar.i.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 3:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 4:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 5:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 6:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    case 7:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, iVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.n);
            printWriter.print(" mIndex=");
            printWriter.print(this.p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.o);
            if (this.j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.k));
            }
            if (!(this.f == 0 && this.g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (!(this.h == 0 && this.i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (!(this.q == 0 && this.r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.r);
            }
            if (!(this.s == 0 && this.t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.t);
            }
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            i iVar = this.c;
            while (iVar != null) {
                String str3;
                switch (iVar.c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + iVar.c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(iVar.d);
                if (z) {
                    if (!(iVar.e == 0 && iVar.f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(iVar.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(iVar.f));
                    }
                    if (!(iVar.g == 0 && iVar.h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(iVar.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(iVar.h));
                    }
                }
                if (iVar.i != null && iVar.i.size() > 0) {
                    for (int i2 = 0; i2 < iVar.i.size(); i2++) {
                        printWriter.print(str2);
                        if (iVar.i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(iVar.i.get(i2));
                    }
                }
                iVar = iVar.a;
                i++;
            }
        }
    }

    public final ai b(n nVar) {
        i iVar = new i();
        iVar.c = 7;
        iVar.d = nVar;
        a(iVar);
        return this;
    }

    public final void run() {
        if (y.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.l || this.p >= 0) {
            j a;
            a(1);
            if (a) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                b(sparseArray, sparseArray2);
                a = a(sparseArray, sparseArray2, false);
            } else {
                a = null;
            }
            int i = a != null ? 0 : this.k;
            int i2 = a != null ? 0 : this.j;
            i iVar = this.c;
            while (iVar != null) {
                int i3 = a != null ? 0 : iVar.e;
                int i4 = a != null ? 0 : iVar.f;
                n nVar;
                switch (iVar.c) {
                    case 1:
                        nVar = iVar.d;
                        nVar.G = i3;
                        this.b.a(nVar, false);
                        break;
                    case 2:
                        n nVar2 = iVar.d;
                        int i5 = nVar2.x;
                        if (this.b.g != null) {
                            int size = this.b.g.size() - 1;
                            while (size >= 0) {
                                nVar = (n) this.b.g.get(size);
                                if (y.a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + nVar2 + " old=" + nVar);
                                }
                                if (nVar.x == i5) {
                                    if (nVar == nVar2) {
                                        nVar = null;
                                        iVar.d = null;
                                        size--;
                                        nVar2 = nVar;
                                    } else {
                                        if (iVar.i == null) {
                                            iVar.i = new ArrayList();
                                        }
                                        iVar.i.add(nVar);
                                        nVar.G = i4;
                                        if (this.l) {
                                            nVar.r++;
                                            if (y.a) {
                                                Log.v("FragmentManager", "Bump nesting of " + nVar + " to " + nVar.r);
                                            }
                                        }
                                        this.b.a(nVar, i2, i);
                                    }
                                }
                                nVar = nVar2;
                                size--;
                                nVar2 = nVar;
                            }
                        }
                        if (nVar2 == null) {
                            break;
                        }
                        nVar2.G = i3;
                        this.b.a(nVar2, false);
                        break;
                    case 3:
                        nVar = iVar.d;
                        nVar.G = i4;
                        this.b.a(nVar, i2, i);
                        break;
                    case 4:
                        nVar = iVar.d;
                        nVar.G = i4;
                        this.b.b(nVar, i2, i);
                        break;
                    case 5:
                        nVar = iVar.d;
                        nVar.G = i3;
                        this.b.c(nVar, i2, i);
                        break;
                    case 6:
                        nVar = iVar.d;
                        nVar.G = i4;
                        this.b.d(nVar, i2, i);
                        break;
                    case 7:
                        nVar = iVar.d;
                        nVar.G = i3;
                        this.b.e(nVar, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + iVar.c);
                }
                iVar = iVar.a;
            }
            this.b.a(this.b.n, i2, i, true);
            if (this.l) {
                y yVar = this.b;
                if (yVar.i == null) {
                    yVar.i = new ArrayList();
                }
                yVar.i.add(this);
                yVar.e();
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.p);
        }
        if (this.n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
