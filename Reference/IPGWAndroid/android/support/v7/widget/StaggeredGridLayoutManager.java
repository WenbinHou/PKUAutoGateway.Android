package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.a;
import android.support.v4.view.a.ae;
import android.support.v4.view.a.f;
import android.support.v4.view.a.q;
import android.support.v4.view.bq;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends eb {
    private int A;
    private final Rect B = new Rect();
    private final fg C = new fg();
    private boolean D = false;
    private boolean E = true;
    private final Runnable F = new ff(this);
    dk a;
    dk b;
    boolean c = false;
    int d = -1;
    int e = Integer.MIN_VALUE;
    LazySpanLookup f = new LazySpanLookup();
    private int g = -1;
    private fk[] h;
    private int i;
    private int j;
    private cn k;
    private boolean l = false;
    private BitSet m;
    private int n = 2;
    private boolean o;
    private boolean y;
    private SavedState z;

    final class LazySpanLookup {
        int[] a;
        List<FullSpanItem> b;

        class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new fi();
            int a;
            int b;
            int[] c;
            boolean d;

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            final int a(int i) {
                return this.c == null ? 0 : this.c[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.c.length);
                parcel.writeIntArray(this.c);
            }
        }

        LazySpanLookup() {
        }

        final int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        public final FullSpanItem a(int i, int i2, int i3) {
            if (this.b == null) {
                return null;
            }
            int size = this.b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(i4);
                if (fullSpanItem.a >= i2) {
                    return null;
                }
                if (fullSpanItem.a >= i && (i3 == 0 || fullSpanItem.b == i3 || fullSpanItem.d)) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        final void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        final void a(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                c(i + i2);
                System.arraycopy(this.a, i + i2, this.a, i, (this.a.length - i) - i2);
                Arrays.fill(this.a, this.a.length - i2, this.a.length, -1);
                if (this.b != null) {
                    int i3 = i + i2;
                    for (int size = this.b.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                        if (fullSpanItem.a >= i) {
                            if (fullSpanItem.a < i3) {
                                this.b.remove(size);
                            } else {
                                fullSpanItem.a -= i2;
                            }
                        }
                    }
                }
            }
        }

        public final void a(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        final int b(int i) {
            if (this.a == null) {
                return -1;
            }
            if (i >= this.a.length) {
                return -1;
            }
            int i2;
            if (this.b != null) {
                FullSpanItem d = d(i);
                if (d != null) {
                    this.b.remove(d);
                }
                int size = this.b.size();
                int i3 = 0;
                while (i3 < size) {
                    if (((FullSpanItem) this.b.get(i3)).a >= i) {
                        break;
                    }
                    i3++;
                }
                i3 = -1;
                if (i3 != -1) {
                    d = (FullSpanItem) this.b.get(i3);
                    this.b.remove(i3);
                    i2 = d.a;
                    if (i2 != -1) {
                        Arrays.fill(this.a, i, this.a.length, -1);
                        return this.a.length;
                    }
                    Arrays.fill(this.a, i, i2 + 1, -1);
                    return i2 + 1;
                }
            }
            i2 = -1;
            if (i2 != -1) {
                Arrays.fill(this.a, i, i2 + 1, -1);
                return i2 + 1;
            }
            Arrays.fill(this.a, i, this.a.length, -1);
            return this.a.length;
        }

        final void b(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                c(i + i2);
                System.arraycopy(this.a, i, this.a, i + i2, (this.a.length - i) - i2);
                Arrays.fill(this.a, i, i + i2, -1);
                if (this.b != null) {
                    for (int size = this.b.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                        if (fullSpanItem.a >= i) {
                            fullSpanItem.a += i2;
                        }
                    }
                }
            }
        }

        final void c(int i) {
            if (this.a == null) {
                this.a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.a, -1);
            } else if (i >= this.a.length) {
                Object obj = this.a;
                int length = this.a.length;
                while (length <= i) {
                    length *= 2;
                }
                this.a = new int[length];
                System.arraycopy(obj, 0, this.a, 0, obj.length);
                Arrays.fill(this.a, obj.length, this.a.length, -1);
            }
        }

        public final FullSpanItem d(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                if (fullSpanItem.a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new fj();
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.j = z;
            this.g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            if (!this.j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.g);
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.i = i2;
        c(i);
        if (this.n == 0) {
            z = false;
        }
        this.u = z;
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        ec a = eb.a(context, attributeSet, i, i2);
        int i3 = a.a;
        if (i3 == 0 || i3 == 1) {
            a(null);
            if (i3 != this.i) {
                this.i = i3;
                if (!(this.a == null || this.b == null)) {
                    dk dkVar = this.a;
                    this.a = this.b;
                    this.b = dkVar;
                }
                j();
            }
            c(a.b);
            a(a.c);
            if (this.n == 0) {
                z = false;
            }
            this.u = z;
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    private int a(eh ehVar, cn cnVar, en enVar) {
        this.m.set(0, this.g, true);
        int i = this.k.i ? cnVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : cnVar.e == 1 ? cnVar.g + cnVar.b : cnVar.f - cnVar.b;
        i(cnVar.e, i);
        int c = this.c ? this.a.c() : this.a.b();
        Object obj = null;
        while (true) {
            Object obj2 = (cnVar.c < 0 || cnVar.c >= enVar.a()) ? null : 1;
            if (obj2 != null && (this.k.i || !this.m.isEmpty())) {
                fk fkVar;
                int i2;
                int i3;
                int b;
                View b2 = ehVar.b(cnVar.c);
                cnVar.c += cnVar.d;
                fh fhVar = (fh) b2.getLayoutParams();
                int c2 = fhVar.c.c();
                LazySpanLookup lazySpanLookup = this.f;
                int i4 = (lazySpanLookup.a == null || c2 >= lazySpanLookup.a.length) ? -1 : lazySpanLookup.a[c2];
                Object obj3 = i4 == -1 ? 1 : null;
                if (obj3 != null) {
                    if (fhVar.b) {
                        fkVar = this.h[0];
                    } else {
                        if (l(cnVar.e)) {
                            i4 = this.g - 1;
                            i2 = -1;
                            i3 = -1;
                        } else {
                            i4 = 0;
                            i2 = this.g;
                            i3 = 1;
                        }
                        int i5;
                        int b3;
                        int i6;
                        fk fkVar2;
                        int i7;
                        if (cnVar.e == 1) {
                            fkVar = null;
                            i5 = Integer.MAX_VALUE;
                            b3 = this.a.b();
                            i6 = i4;
                            while (i6 != i2) {
                                fkVar2 = this.h[i6];
                                b = fkVar2.b(b3);
                                if (b < i5) {
                                    i7 = b;
                                } else {
                                    fkVar2 = fkVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                fkVar = fkVar2;
                            }
                        } else {
                            fkVar = null;
                            i5 = Integer.MIN_VALUE;
                            b3 = this.a.c();
                            i6 = i4;
                            while (i6 != i2) {
                                fkVar2 = this.h[i6];
                                b = fkVar2.a(b3);
                                if (b > i5) {
                                    i7 = b;
                                } else {
                                    fkVar2 = fkVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                fkVar = fkVar2;
                            }
                        }
                    }
                    lazySpanLookup = this.f;
                    lazySpanLookup.c(c2);
                    lazySpanLookup.a[c2] = fkVar.e;
                } else {
                    fkVar = this.h[i4];
                }
                fhVar.a = fkVar;
                if (cnVar.e == 1) {
                    super.a(b2, -1, false);
                } else {
                    super.a(b2, 0, false);
                }
                if (fhVar.b) {
                    if (this.i == 1) {
                        a(b2, this.A, eb.a(MeasureSpec.getSize(this.x), MeasureSpec.getMode(this.x), 0, fhVar.height, true));
                    } else {
                        a(b2, eb.a(MeasureSpec.getSize(this.w), MeasureSpec.getMode(this.w), 0, fhVar.width, true), this.A);
                    }
                } else if (this.i == 1) {
                    a(b2, eb.a(this.j, MeasureSpec.getMode(this.w), 0, fhVar.width, false), eb.a(MeasureSpec.getSize(this.x), MeasureSpec.getMode(this.x), 0, fhVar.height, true));
                } else {
                    a(b2, eb.a(MeasureSpec.getSize(this.w), MeasureSpec.getMode(this.w), 0, fhVar.width, true), eb.a(this.j, MeasureSpec.getMode(this.x), 0, fhVar.height, false));
                }
                FullSpanItem fullSpanItem;
                if (cnVar.e == 1) {
                    i3 = fhVar.b ? k(c) : fkVar.b(c);
                    i2 = i3 + this.a.c(b2);
                    if (obj3 == null || !fhVar.b) {
                        i4 = i3;
                        i3 = i2;
                    } else {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.c = new int[this.g];
                        for (i4 = 0; i4 < this.g; i4++) {
                            fullSpanItem.c[i4] = i3 - this.h[i4].b(i3);
                        }
                        fullSpanItem.b = -1;
                        fullSpanItem.a = c2;
                        this.f.a(fullSpanItem);
                        i4 = i3;
                        i3 = i2;
                    }
                } else {
                    i3 = fhVar.b ? j(c) : fkVar.a(c);
                    i2 = i3 - this.a.c(b2);
                    if (obj3 != null && fhVar.b) {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.c = new int[this.g];
                        for (i4 = 0; i4 < this.g; i4++) {
                            fullSpanItem.c[i4] = this.h[i4].a(i3) - i3;
                        }
                        fullSpanItem.b = 1;
                        fullSpanItem.a = c2;
                        this.f.a(fullSpanItem);
                    }
                    i4 = i2;
                }
                if (fhVar.b && cnVar.d == -1) {
                    if (obj3 == null) {
                        Object obj4;
                        if (cnVar.e == 1) {
                            b = this.h[0].b(Integer.MIN_VALUE);
                            for (i2 = 1; i2 < this.g; i2++) {
                                if (this.h[i2].b(Integer.MIN_VALUE) != b) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        } else {
                            b = this.h[0].a(Integer.MIN_VALUE);
                            for (i2 = 1; i2 < this.g; i2++) {
                                if (this.h[i2].a(Integer.MIN_VALUE) != b) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        }
                        if (obj4 != null) {
                            FullSpanItem d = this.f.d(c2);
                            if (d != null) {
                                d.d = true;
                            }
                        }
                    }
                    this.D = true;
                }
                if (cnVar.e == 1) {
                    if (fhVar.b) {
                        for (i2 = this.g - 1; i2 >= 0; i2--) {
                            this.h[i2].b(b2);
                        }
                    } else {
                        fhVar.a.b(b2);
                    }
                } else if (fhVar.b) {
                    for (i2 = this.g - 1; i2 >= 0; i2--) {
                        this.h[i2].a(b2);
                    }
                } else {
                    fhVar.a.a(b2);
                }
                if (t() && this.i == 1) {
                    i2 = fhVar.b ? this.b.c() : this.b.c() - (((this.g - 1) - fkVar.e) * this.j);
                    b = i2;
                    i2 -= this.b.c(b2);
                } else {
                    i2 = fhVar.b ? this.b.b() : (fkVar.e * this.j) + this.b.b();
                    b = this.b.c(b2) + i2;
                }
                if (this.i == 1) {
                    b(b2, i2, i4, b, i3);
                } else {
                    b(b2, i4, i2, i3, b);
                }
                if (fhVar.b) {
                    i(this.k.e, i);
                } else {
                    a(fkVar, this.k.e, i);
                }
                a(ehVar, this.k);
                if (this.k.h && b2.isFocusable()) {
                    if (fhVar.b) {
                        this.m.clear();
                    } else {
                        this.m.set(fkVar.e, false);
                    }
                }
                obj = 1;
            } else if (obj == null) {
                a(ehVar, this.k);
            }
        }
        if (obj == null) {
            a(ehVar, this.k);
        }
        int b4 = this.k.e == -1 ? this.a.b() - j(this.a.b()) : k(this.a.c()) - this.a.c();
        return b4 > 0 ? Math.min(cnVar.b, b4) : 0;
    }

    private void a(int i, en enVar) {
        int i2;
        int i3;
        boolean z;
        cn cnVar;
        boolean z2 = false;
        this.k.b = 0;
        this.k.c = i;
        if (k()) {
            i2 = enVar.a;
            if (i2 != -1) {
                if (this.c == (i2 < i)) {
                    i2 = this.a.e();
                    i3 = 0;
                } else {
                    i3 = this.a.e();
                    i2 = 0;
                }
                z = this.q == null && this.q.v;
                if (z) {
                    this.k.g = i2 + this.a.d();
                    this.k.f = -i3;
                } else {
                    this.k.f = this.a.b() - i3;
                    this.k.g = i2 + this.a.c();
                }
                this.k.h = false;
                this.k.a = true;
                cnVar = this.k;
                if (this.a.g() == 0) {
                    z2 = true;
                }
                cnVar.i = z2;
            }
        }
        i2 = 0;
        i3 = 0;
        if (this.q == null) {
        }
        if (z) {
            this.k.g = i2 + this.a.d();
            this.k.f = -i3;
        } else {
            this.k.f = this.a.b() - i3;
            this.k.g = i2 + this.a.c();
        }
        this.k.h = false;
        this.k.a = true;
        cnVar = this.k;
        if (this.a.g() == 0) {
            z2 = true;
        }
        cnVar.i = z2;
    }

    private void a(eh ehVar, int i) {
        while (l() > 0) {
            View d = d(0);
            if (this.a.b(d) <= i) {
                fh fhVar = (fh) d.getLayoutParams();
                if (fhVar.b) {
                    int i2 = 0;
                    while (i2 < this.g) {
                        if (this.h[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.g; i2++) {
                        this.h[i2].e();
                    }
                } else if (fhVar.a.a.size() != 1) {
                    fhVar.a.e();
                } else {
                    return;
                }
                a(d, ehVar);
            } else {
                return;
            }
        }
    }

    private void a(eh ehVar, cn cnVar) {
        int i = 1;
        if (cnVar.a && !cnVar.i) {
            if (cnVar.b == 0) {
                if (cnVar.e == -1) {
                    b(ehVar, cnVar.g);
                } else {
                    a(ehVar, cnVar.f);
                }
            } else if (cnVar.e == -1) {
                r3 = cnVar.f;
                int i2 = cnVar.f;
                r1 = this.h[0].a(i2);
                while (i < this.g) {
                    r2 = this.h[i].a(i2);
                    if (r2 > r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r3 - r1;
                b(ehVar, i < 0 ? cnVar.g : cnVar.g - Math.min(i, cnVar.b));
            } else {
                r3 = cnVar.g;
                r1 = this.h[0].b(r3);
                while (i < this.g) {
                    r2 = this.h[i].b(r3);
                    if (r2 < r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r1 - cnVar.g;
                a(ehVar, i < 0 ? cnVar.f : Math.min(i, cnVar.b) + cnVar.f);
            }
        }
    }

    private void a(eh ehVar, en enVar, boolean z) {
        int k = k(Integer.MIN_VALUE);
        if (k != Integer.MIN_VALUE) {
            k = this.a.c() - k;
            if (k > 0) {
                k -= -c(-k, ehVar, enVar);
                if (z && k > 0) {
                    this.a.a(k);
                }
            }
        }
    }

    private void a(fk fkVar, int i, int i2) {
        int i3 = fkVar.d;
        if (i == -1) {
            if (i3 + fkVar.a() <= i2) {
                this.m.set(fkVar.e, false);
            }
        } else if (fkVar.b() - i3 >= i2) {
            this.m.set(fkVar.e, false);
        }
    }

    private void a(View view, int i, int i2) {
        a(view, this.B);
        fh fhVar = (fh) view.getLayoutParams();
        int c = c(i, fhVar.leftMargin + this.B.left, fhVar.rightMargin + this.B.right);
        int c2 = c(i2, fhVar.topMargin + this.B.top, fhVar.bottomMargin + this.B.bottom);
        if (a(view, c, c2, (ed) fhVar)) {
            view.measure(c, c2);
        }
    }

    private void a(boolean z) {
        a(null);
        if (!(this.z == null || this.z.h == z)) {
            this.z.h = z;
        }
        this.l = z;
        j();
    }

    private View b(boolean z) {
        r();
        int b = this.a.b();
        int c = this.a.c();
        int l = l();
        View view = null;
        int i = 0;
        while (i < l) {
            View d = d(i);
            int a = this.a.a(d);
            if (this.a.b(d) > b && a < c) {
                if (a >= b || !z) {
                    return d;
                }
                if (view == null) {
                    i++;
                    view = d;
                }
            }
            d = view;
            i++;
            view = d;
        }
        return view;
    }

    private void b(eh ehVar, int i) {
        int l = l() - 1;
        while (l >= 0) {
            View d = d(l);
            if (this.a.a(d) >= i) {
                fh fhVar = (fh) d.getLayoutParams();
                if (fhVar.b) {
                    int i2 = 0;
                    while (i2 < this.g) {
                        if (this.h[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.g; i2++) {
                        this.h[i2].d();
                    }
                } else if (fhVar.a.a.size() != 1) {
                    fhVar.a.d();
                } else {
                    return;
                }
                a(d, ehVar);
                l--;
            } else {
                return;
            }
        }
    }

    private void b(eh ehVar, en enVar, boolean z) {
        int j = j(Integer.MAX_VALUE);
        if (j != Integer.MAX_VALUE) {
            j -= this.a.b();
            if (j > 0) {
                j -= c(j, ehVar, enVar);
                if (z && j > 0) {
                    this.a.a(-j);
                }
            }
        }
    }

    private static void b(View view, int i, int i2, int i3, int i4) {
        fh fhVar = (fh) view.getLayoutParams();
        eb.a(view, fhVar.leftMargin + i, fhVar.topMargin + i2, i3 - fhVar.rightMargin, i4 - fhVar.bottomMargin);
    }

    private static int c(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int c(int i, eh ehVar, en enVar) {
        int u;
        int i2;
        r();
        if (i > 0) {
            u = u();
            i2 = 1;
        } else {
            i2 = -1;
            u = v();
        }
        this.k.a = true;
        a(u, enVar);
        i(i2);
        this.k.c = this.k.d + u;
        int abs = Math.abs(i);
        this.k.b = abs;
        i2 = a(ehVar, this.k, enVar);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.a.a(-i);
        this.o = this.c;
        return i;
    }

    private View c(boolean z) {
        r();
        int b = this.a.b();
        int c = this.a.c();
        View view = null;
        int l = l() - 1;
        while (l >= 0) {
            View d = d(l);
            int a = this.a.a(d);
            int b2 = this.a.b(d);
            if (b2 > b && a < c) {
                if (b2 <= c || !z) {
                    return d;
                }
                if (view == null) {
                    l--;
                    view = d;
                }
            }
            d = view;
            l--;
            view = d;
        }
        return view;
    }

    private void c(int i) {
        a(null);
        if (i != this.g) {
            this.f.a();
            j();
            this.g = i;
            this.m = new BitSet(this.g);
            this.h = new fk[this.g];
            for (int i2 = 0; i2 < this.g; i2++) {
                this.h[i2] = new fk(this, i2);
            }
            j();
        }
    }

    private void d(int i, int i2, int i3) {
        int i4;
        int i5;
        int u = this.c ? u() : v();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f.b(i5);
        switch (i3) {
            case 1:
                this.f.b(i, i2);
                break;
            case 2:
                this.f.a(i, i2);
                break;
            case 8:
                this.f.a(i, 1);
                this.f.b(i2, 1);
                break;
        }
        if (i4 > u) {
            if (i5 <= (this.c ? v() : u())) {
                j();
            }
        }
    }

    private int g(en enVar) {
        boolean z = true;
        if (l() == 0) {
            return 0;
        }
        r();
        dk dkVar = this.a;
        View b = b(!this.E);
        if (this.E) {
            z = false;
        }
        return eu.a(enVar, dkVar, b, c(z), this, this.E, this.c);
    }

    private boolean g() {
        if (l() == 0 || this.n == 0 || !this.t) {
            return false;
        }
        int u;
        int v;
        if (this.c) {
            u = u();
            v = v();
        } else {
            u = v();
            v = u();
        }
        if (u == 0 && h() != null) {
            this.f.a();
            this.s = true;
            j();
            return true;
        } else if (!this.D) {
            return false;
        } else {
            int i = this.c ? -1 : 1;
            FullSpanItem a = this.f.a(u, v + 1, i);
            if (a == null) {
                this.D = false;
                this.f.a(v + 1);
                return false;
            }
            FullSpanItem a2 = this.f.a(u, a.a, i * -1);
            if (a2 == null) {
                this.f.a(a.a);
            } else {
                this.f.a(a2.a + 1);
            }
            this.s = true;
            j();
            return true;
        }
    }

    private int h(en enVar) {
        boolean z = true;
        if (l() == 0) {
            return 0;
        }
        r();
        dk dkVar = this.a;
        View b = b(!this.E);
        if (this.E) {
            z = false;
        }
        return eu.a(enVar, dkVar, b, c(z), this, this.E);
    }

    private View h() {
        int i;
        int l = l() - 1;
        BitSet bitSet = new BitSet(this.g);
        bitSet.set(0, this.g, true);
        boolean z = (this.i == 1 && t()) ? true : true;
        if (this.c) {
            i = -1;
        } else {
            i = l + 1;
            l = 0;
        }
        int i2 = l < i ? 1 : -1;
        int i3 = l;
        while (i3 != i) {
            boolean z2;
            View d = d(i3);
            fh fhVar = (fh) d.getLayoutParams();
            if (bitSet.get(fhVar.a.e)) {
                fk fkVar = fhVar.a;
                if (this.c) {
                    if (fkVar.b() < this.a.c()) {
                        z2 = !((fh) ((View) fkVar.a.get(fkVar.a.size() + -1)).getLayoutParams()).b;
                    }
                    z2 = false;
                } else {
                    if (fkVar.a() > this.a.b()) {
                        z2 = !((fh) ((View) fkVar.a.get(0)).getLayoutParams()).b;
                    }
                    z2 = false;
                }
                if (z2) {
                    return d;
                }
                bitSet.clear(fhVar.a.e);
            }
            if (!(fhVar.b || i3 + i2 == i)) {
                View d2 = d(i3 + i2);
                int b;
                if (this.c) {
                    l = this.a.b(d);
                    b = this.a.b(d2);
                    if (l < b) {
                        return d;
                    }
                    if (l == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    l = this.a.a(d);
                    b = this.a.a(d2);
                    if (l > b) {
                        return d;
                    }
                    if (l == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if ((fhVar.a.e - ((fh) d2.getLayoutParams()).a.e < 0) != (z >= false)) {
                        return d;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private void h(int i) {
        this.j = i / this.g;
        this.A = MeasureSpec.makeMeasureSpec(i, this.b.g());
    }

    private int i(en enVar) {
        boolean z = true;
        if (l() == 0) {
            return 0;
        }
        r();
        dk dkVar = this.a;
        View b = b(!this.E);
        if (this.E) {
            z = false;
        }
        return eu.b(enVar, dkVar, b, c(z), this, this.E);
    }

    private void i(int i) {
        int i2 = 1;
        this.k.e = i;
        cn cnVar = this.k;
        if (this.c != (i == -1)) {
            i2 = -1;
        }
        cnVar.d = i2;
    }

    private void i(int i, int i2) {
        for (int i3 = 0; i3 < this.g; i3++) {
            if (!this.h[i3].a.isEmpty()) {
                a(this.h[i3], i, i2);
            }
        }
    }

    private int j(int i) {
        int a = this.h[0].a(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int a2 = this.h[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private int k(int i) {
        int b = this.h[0].b(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int b2 = this.h[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean l(int i) {
        if (this.i == 0) {
            return (i == -1) != this.c;
        } else {
            return ((i == -1) == this.c) == t();
        }
    }

    private void r() {
        if (this.a == null) {
            this.a = dk.a(this, this.i);
            this.b = dk.a(this, 1 - this.i);
            this.k = new cn();
        }
    }

    private void s() {
        boolean z = true;
        if (this.i == 1 || !t()) {
            z = this.l;
        } else if (this.l) {
            z = false;
        }
        this.c = z;
    }

    private boolean t() {
        return bq.h(this.q) == 1;
    }

    private int u() {
        int l = l();
        return l == 0 ? 0 : eb.a(d(l - 1));
    }

    private int v() {
        return l() == 0 ? 0 : eb.a(d(0));
    }

    public final int a(int i, eh ehVar, en enVar) {
        return c(i, ehVar, enVar);
    }

    public final int a(eh ehVar, en enVar) {
        return this.i == 0 ? this.g : super.a(ehVar, enVar);
    }

    public final int a(en enVar) {
        return g(enVar);
    }

    public final ed a(Context context, AttributeSet attributeSet) {
        return new fh(context, attributeSet);
    }

    public final ed a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new fh((MarginLayoutParams) layoutParams) : new fh(layoutParams);
    }

    public final View a(View view, int i, eh ehVar, en enVar) {
        int i2 = 0;
        if (l() == 0) {
            return null;
        }
        View b = b(view);
        if (b == null) {
            return null;
        }
        int i3;
        r();
        s();
        switch (i) {
            case 1:
                i3 = -1;
                break;
            case 2:
                i3 = 1;
                break;
            case 17:
                if (this.i != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 33:
                if (this.i != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 66:
                if (this.i != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            case 130:
                if (this.i != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            default:
                i3 = Integer.MIN_VALUE;
                break;
        }
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        View a;
        fh fhVar = (fh) b.getLayoutParams();
        boolean z = fhVar.b;
        fk fkVar = fhVar.a;
        int u = i3 == 1 ? u() : v();
        a(u, enVar);
        i(i3);
        this.k.c = this.k.d + u;
        this.k.b = (int) (0.33333334f * ((float) this.a.e()));
        this.k.h = true;
        this.k.a = false;
        a(ehVar, this.k, enVar);
        this.o = this.c;
        if (!z) {
            a = fkVar.a(u, i3);
            if (!(a == null || a == b)) {
                return a;
            }
        }
        if (l(i3)) {
            for (int i4 = this.g - 1; i4 >= 0; i4--) {
                View a2 = this.h[i4].a(u, i3);
                if (a2 != null && a2 != b) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.g) {
                a = this.h[i2].a(u, i3);
                if (a != null && a != b) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    public final void a() {
        this.f.a();
        j();
    }

    public final void a(int i, int i2) {
        d(i, i2, 1);
    }

    public final void a(Rect rect, int i, int i2) {
        int o = o() + m();
        int n = n() + p();
        if (this.i == 1) {
            n = eb.a(i2, n + rect.height(), bq.q(this.q));
            o = eb.a(i, o + (this.j * this.g), bq.p(this.q));
        } else {
            o = eb.a(i, o + rect.width(), bq.p(this.q));
            n = eb.a(i2, n + (this.j * this.g), bq.q(this.q));
        }
        h(o, n);
    }

    public final void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.z = (SavedState) parcelable;
            j();
        }
    }

    public final void a(RecyclerView recyclerView, eh ehVar) {
        a(this.F);
        for (int i = 0; i < this.g; i++) {
            this.h[i].c();
        }
    }

    public final void a(eh ehVar, en enVar, View view, f fVar) {
        int i = 1;
        int i2 = -1;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof fh) {
            int a;
            int i3;
            fh fhVar = (fh) layoutParams;
            if (this.i == 0) {
                a = fhVar.a();
                if (fhVar.b) {
                    i = this.g;
                }
                i3 = a;
                a = i;
                i = -1;
            } else {
                a = fhVar.a();
                if (fhVar.b) {
                    i = this.g;
                    i3 = -1;
                    i2 = a;
                    a = -1;
                } else {
                    i3 = -1;
                    i2 = a;
                    a = -1;
                }
            }
            fVar.a(q.a(i3, a, i2, i, fhVar.b));
            return;
        }
        super.a(view, fVar);
    }

    public final void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (l() > 0) {
            ae a = a.a(accessibilityEvent);
            View b = b(false);
            View c = c(false);
            if (b != null && c != null) {
                int a2 = eb.a(b);
                int a3 = eb.a(c);
                if (a2 < a3) {
                    a.b(a2);
                    a.c(a3);
                    return;
                }
                a.b(a3);
                a.c(a2);
            }
        }
    }

    public final void a(String str) {
        if (this.z == null) {
            super.a(str);
        }
    }

    public final boolean a(ed edVar) {
        return edVar instanceof fh;
    }

    public final int b(int i, eh ehVar, en enVar) {
        return c(i, ehVar, enVar);
    }

    public final int b(eh ehVar, en enVar) {
        return this.i == 1 ? this.g : super.b(ehVar, enVar);
    }

    public final int b(en enVar) {
        return g(enVar);
    }

    public final ed b() {
        return this.i == 0 ? new fh(-2, -1) : new fh(-1, -2);
    }

    public final void b(int i) {
        if (!(this.z == null || this.z.a == i)) {
            SavedState savedState = this.z;
            savedState.d = null;
            savedState.c = 0;
            savedState.a = -1;
            savedState.b = -1;
        }
        this.d = i;
        this.e = Integer.MIN_VALUE;
        j();
    }

    public final void b(int i, int i2) {
        d(i, i2, 2);
    }

    public final int c(en enVar) {
        return h(enVar);
    }

    public final void c(int i, int i2) {
        d(i, i2, 4);
    }

    public final void c(eh ehVar, en enVar) {
        Object obj = 1;
        while (true) {
            r();
            fg fgVar = this.C;
            fgVar.a = -1;
            fgVar.b = Integer.MIN_VALUE;
            fgVar.c = false;
            fgVar.d = false;
            if (!(this.z == null && this.d == -1) && enVar.a() == 0) {
                c(ehVar);
                return;
            }
            int i;
            int i2;
            Object obj2;
            int l;
            int i3;
            if (this.z != null) {
                if (this.z.c > 0) {
                    if (this.z.c == this.g) {
                        for (i = 0; i < this.g; i++) {
                            this.h[i].c();
                            i2 = this.z.d[i];
                            if (i2 != Integer.MIN_VALUE) {
                                i2 = this.z.i ? i2 + this.a.c() : i2 + this.a.b();
                            }
                            this.h[i].c(i2);
                        }
                    } else {
                        SavedState savedState = this.z;
                        savedState.d = null;
                        savedState.c = 0;
                        savedState.e = 0;
                        savedState.f = null;
                        savedState.g = null;
                        this.z.a = this.z.b;
                    }
                }
                this.y = this.z.j;
                a(this.z.h);
                s();
                if (this.z.a != -1) {
                    this.d = this.z.a;
                    fgVar.c = this.z.i;
                } else {
                    fgVar.c = this.c;
                }
                if (this.z.e > 1) {
                    this.f.a = this.z.f;
                    this.f.b = this.z.g;
                }
            } else {
                s();
                fgVar.c = this.c;
            }
            if (enVar.g || this.d == -1) {
                obj2 = null;
            } else if (this.d < 0 || this.d >= enVar.a()) {
                this.d = -1;
                this.e = Integer.MIN_VALUE;
                obj2 = null;
            } else {
                if (this.z == null || this.z.a == -1 || this.z.c <= 0) {
                    View a = a(this.d);
                    if (a != null) {
                        fgVar.a = this.c ? u() : v();
                        if (this.e != Integer.MIN_VALUE) {
                            if (fgVar.c) {
                                fgVar.b = (this.a.c() - this.e) - this.a.b(a);
                            } else {
                                fgVar.b = (this.a.b() + this.e) - this.a.a(a);
                            }
                            obj2 = 1;
                        } else if (this.a.c(a) > this.a.e()) {
                            fgVar.b = fgVar.c ? this.a.c() : this.a.b();
                        } else {
                            i = this.a.a(a) - this.a.b();
                            if (i < 0) {
                                fgVar.b = -i;
                            } else {
                                i = this.a.c() - this.a.b(a);
                                if (i < 0) {
                                    fgVar.b = i;
                                } else {
                                    fgVar.b = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        fgVar.a = this.d;
                        if (this.e == Integer.MIN_VALUE) {
                            i = fgVar.a;
                            if (l() == 0) {
                                if (!this.c) {
                                    i = -1;
                                }
                                i = 1;
                            } else {
                                if ((i < v()) != this.c) {
                                    i = -1;
                                }
                                i = 1;
                            }
                            fgVar.c = i == 1;
                            fgVar.b = fgVar.c ? fgVar.e.a.c() : fgVar.e.a.b();
                        } else {
                            i = this.e;
                            if (fgVar.c) {
                                fgVar.b = fgVar.e.a.c() - i;
                            } else {
                                fgVar.b = i + fgVar.e.a.b();
                            }
                        }
                        fgVar.d = true;
                    }
                } else {
                    fgVar.b = Integer.MIN_VALUE;
                    fgVar.a = this.d;
                }
                obj2 = 1;
            }
            if (obj2 == null) {
                int a2;
                if (this.o) {
                    a2 = enVar.a();
                    for (i2 = l() - 1; i2 >= 0; i2--) {
                        i = eb.a(d(i2));
                        if (i >= 0 && i < a2) {
                            break;
                        }
                    }
                    i = 0;
                } else {
                    a2 = enVar.a();
                    l = l();
                    for (i2 = 0; i2 < l; i2++) {
                        i = eb.a(d(i2));
                        if (i >= 0 && i < a2) {
                            break;
                        }
                    }
                    i = 0;
                }
                fgVar.a = i;
                fgVar.b = Integer.MIN_VALUE;
            }
            if (this.z == null && !(fgVar.c == this.o && t() == this.y)) {
                this.f.a();
                fgVar.d = true;
            }
            if (l() > 0 && (this.z == null || this.z.c <= 0)) {
                if (fgVar.d) {
                    for (i = 0; i < this.g; i++) {
                        this.h[i].c();
                        if (fgVar.b != Integer.MIN_VALUE) {
                            this.h[i].c(fgVar.b);
                        }
                    }
                } else {
                    for (i2 = 0; i2 < this.g; i2++) {
                        fk fkVar = this.h[i2];
                        boolean z = this.c;
                        i3 = fgVar.b;
                        i = z ? fkVar.b(Integer.MIN_VALUE) : fkVar.a(Integer.MIN_VALUE);
                        fkVar.c();
                        if (i != Integer.MIN_VALUE && ((!z || i >= fkVar.f.a.c()) && (z || i <= fkVar.f.a.b()))) {
                            if (i3 != Integer.MIN_VALUE) {
                                i += i3;
                            }
                            fkVar.c = i;
                            fkVar.b = i;
                        }
                    }
                }
            }
            a(ehVar);
            this.k.a = false;
            this.D = false;
            h(this.b.e());
            a(fgVar.a, enVar);
            if (fgVar.c) {
                i(-1);
                a(ehVar, this.k, enVar);
                i(1);
                this.k.c = fgVar.a + this.k.d;
                a(ehVar, this.k, enVar);
            } else {
                i(1);
                a(ehVar, this.k, enVar);
                i(-1);
                this.k.c = fgVar.a + this.k.d;
                a(ehVar, this.k, enVar);
            }
            if (this.b.g() != 1073741824) {
                float f = 0.0f;
                i3 = l();
                l = 0;
                while (l < i3) {
                    float max;
                    View d = d(l);
                    float c = (float) this.b.c(d);
                    if (c >= f) {
                        max = Math.max(f, ((fh) d.getLayoutParams()).b ? (1.0f * c) / ((float) this.g) : c);
                    } else {
                        max = f;
                    }
                    l++;
                    f = max;
                }
                l = this.j;
                i = Math.round(((float) this.g) * f);
                if (this.b.g() == Integer.MIN_VALUE) {
                    i = Math.min(i, this.b.e());
                }
                h(i);
                if (this.j != l) {
                    for (i2 = 0; i2 < i3; i2++) {
                        View d2 = d(i2);
                        fh fhVar = (fh) d2.getLayoutParams();
                        if (!fhVar.b) {
                            if (t() && this.i == 1) {
                                d2.offsetLeftAndRight(((-((this.g - 1) - fhVar.a.e)) * this.j) - ((-((this.g - 1) - fhVar.a.e)) * l));
                            } else {
                                int i4 = fhVar.a.e * this.j;
                                i = fhVar.a.e * l;
                                if (this.i == 1) {
                                    d2.offsetLeftAndRight(i4 - i);
                                } else {
                                    d2.offsetTopAndBottom(i4 - i);
                                }
                            }
                        }
                    }
                }
            }
            if (l() > 0) {
                if (this.c) {
                    a(ehVar, enVar, true);
                    b(ehVar, enVar, false);
                } else {
                    b(ehVar, enVar, true);
                    a(ehVar, enVar, false);
                }
            }
            obj2 = null;
            if (!(obj == null || enVar.g)) {
                obj = (this.n == 0 || l() <= 0 || (!this.D && h() == null)) ? null : 1;
                if (obj != null) {
                    a(this.F);
                    if (g()) {
                        obj2 = 1;
                    }
                }
                this.d = -1;
                this.e = Integer.MIN_VALUE;
            }
            this.o = fgVar.c;
            this.y = t();
            this.z = null;
            if (obj2 != null) {
                obj = null;
            } else {
                return;
            }
        }
    }

    public final boolean c() {
        return this.z == null;
    }

    public final int d(en enVar) {
        return h(enVar);
    }

    public final Parcelable d() {
        if (this.z != null) {
            return new SavedState(this.z);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.l;
        savedState.i = this.o;
        savedState.j = this.y;
        if (this.f == null || this.f.a == null) {
            savedState.e = 0;
        } else {
            savedState.f = this.f.a;
            savedState.e = savedState.f.length;
            savedState.g = this.f.b;
        }
        if (l() > 0) {
            r();
            savedState.a = this.o ? u() : v();
            View c = this.c ? c(true) : b(true);
            savedState.b = c == null ? -1 : eb.a(c);
            savedState.c = this.g;
            savedState.d = new int[this.g];
            for (int i = 0; i < this.g; i++) {
                int b;
                if (this.o) {
                    b = this.h[i].b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.a.c();
                    }
                } else {
                    b = this.h[i].a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.a.b();
                    }
                }
                savedState.d[i] = b;
            }
        } else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = 0;
        }
        return savedState;
    }

    public final void d(int i, int i2) {
        d(i, i2, 8);
    }

    public final int e(en enVar) {
        return i(enVar);
    }

    public final void e(int i) {
        super.e(i);
        for (int i2 = 0; i2 < this.g; i2++) {
            this.h[i2].d(i);
        }
    }

    public final boolean e() {
        return this.i == 0;
    }

    public final int f(en enVar) {
        return i(enVar);
    }

    public final void f(int i) {
        super.f(i);
        for (int i2 = 0; i2 < this.g; i2++) {
            this.h[i2].d(i);
        }
    }

    public final boolean f() {
        return this.i == 1;
    }

    public final void g(int i) {
        if (i == 0) {
            g();
        }
    }
}
