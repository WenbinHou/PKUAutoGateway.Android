package android.support.v7.widget;

import android.support.v4.view.bq;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class eq {
    private static final List<Object> m = Collections.EMPTY_LIST;
    public final View a;
    int b = -1;
    int c = -1;
    long d = -1;
    int e = -1;
    int f = -1;
    eq g = null;
    eq h = null;
    List<Object> i = null;
    List<Object> j = null;
    RecyclerView k;
    private int l;
    private int n = 0;
    private eh o = null;
    private boolean p = false;
    private int q = 0;

    public eq(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.a = view;
    }

    static /* synthetic */ void a(eq eqVar) {
        eqVar.q = bq.e(eqVar.a);
        bq.c(eqVar.a, 4);
    }

    static /* synthetic */ void b(eq eqVar) {
        bq.c(eqVar.a, eqVar.q);
        eqVar.q = 0;
    }

    static /* synthetic */ boolean c(eq eqVar) {
        return (eqVar.l & 16) == 0 && bq.c(eqVar.a);
    }

    static /* synthetic */ boolean g(eq eqVar) {
        return (eqVar.l & 16) != 0;
    }

    final void a() {
        this.c = -1;
        this.f = -1;
    }

    final void a(int i, int i2) {
        this.l = (this.l & (i2 ^ -1)) | (i & i2);
    }

    final void a(int i, boolean z) {
        if (this.c == -1) {
            this.c = this.b;
        }
        if (this.f == -1) {
            this.f = this.b;
        }
        if (z) {
            this.f += i;
        }
        this.b += i;
        if (this.a.getLayoutParams() != null) {
            ((ed) this.a.getLayoutParams()).e = true;
        }
    }

    final void a(eh ehVar, boolean z) {
        this.o = ehVar;
        this.p = z;
    }

    final void a(Object obj) {
        if (obj == null) {
            b(1024);
        } else if ((this.l & 1024) == 0) {
            if (this.i == null) {
                this.i = new ArrayList();
                this.j = Collections.unmodifiableList(this.i);
            }
            this.i.add(obj);
        }
    }

    public final void a(boolean z) {
        this.n = z ? this.n - 1 : this.n + 1;
        if (this.n < 0) {
            this.n = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && this.n == 1) {
            this.l |= 16;
        } else if (z && this.n == 0) {
            this.l &= -17;
        }
    }

    final boolean a(int i) {
        return (this.l & i) != 0;
    }

    final void b(int i) {
        this.l |= i;
    }

    final boolean b() {
        return (this.l & 128) != 0;
    }

    public final int c() {
        return this.f == -1 ? this.b : this.f;
    }

    public final int d() {
        return this.k == null ? -1 : RecyclerView.b(this.k, this);
    }

    final boolean e() {
        return this.o != null;
    }

    final void f() {
        this.o.b(this);
    }

    final boolean g() {
        return (this.l & 32) != 0;
    }

    final void h() {
        this.l &= -33;
    }

    final void i() {
        this.l &= -257;
    }

    final boolean j() {
        return (this.l & 4) != 0;
    }

    final boolean k() {
        return (this.l & 2) != 0;
    }

    final boolean l() {
        return (this.l & 1) != 0;
    }

    final boolean m() {
        return (this.l & 8) != 0;
    }

    final boolean n() {
        return (this.l & 256) != 0;
    }

    final void o() {
        if (this.i != null) {
            this.i.clear();
        }
        this.l &= -1025;
    }

    final List<Object> p() {
        return (this.l & 1024) == 0 ? (this.i == null || this.i.size() == 0) ? m : this.j : m;
    }

    final void q() {
        this.l = 0;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = -1;
        this.n = 0;
        this.g = null;
        this.h = null;
        o();
        this.q = 0;
    }

    public final boolean r() {
        return (this.l & 16) == 0 && !bq.c(this.a);
    }

    final boolean s() {
        return (this.l & 2) != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.b + " id=" + this.d + ", oldPos=" + this.c + ", pLpos:" + this.f);
        if (e()) {
            stringBuilder.append(" scrap ").append(this.p ? "[changeScrap]" : "[attachedScrap]");
        }
        if (j()) {
            stringBuilder.append(" invalid");
        }
        if (!l()) {
            stringBuilder.append(" unbound");
        }
        if (k()) {
            stringBuilder.append(" update");
        }
        if (m()) {
            stringBuilder.append(" removed");
        }
        if (b()) {
            stringBuilder.append(" ignored");
        }
        if (n()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!r()) {
            stringBuilder.append(" not recyclable(" + this.n + ")");
        }
        Object obj = ((this.l & 512) != 0 || j()) ? 1 : null;
        if (obj != null) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.a.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
