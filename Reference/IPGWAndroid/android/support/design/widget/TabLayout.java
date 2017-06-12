package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.design.d;
import android.support.design.g;
import android.support.design.h;
import android.support.v4.g.o;
import android.support.v4.g.p;
import android.support.v4.g.q;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bj;
import android.support.v4.view.bq;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView {
    private static final o<bu> a = new q();
    private final o<bw> A;
    private final ArrayList<bu> b;
    private bu c;
    private final br d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private float k;
    private float l;
    private final int m;
    private int n;
    private final int o;
    private final int p;
    private final int q;
    private int r;
    private int s;
    private int t;
    private bp u;
    private bz v;
    private ViewPager w;
    private bj x;
    private DataSetObserver y;
    private bv z;

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new ArrayList();
        this.n = Integer.MAX_VALUE;
        this.A = new p(12);
        by.a(context);
        setHorizontalScrollBarEnabled(false);
        this.d = new br(this, context);
        super.addView(this.d, 0, new LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.TabLayout, i, g.Widget_Design_TabLayout);
        this.d.b(obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabIndicatorHeight, 0));
        this.d.a(obtainStyledAttributes.getColor(h.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabPadding, 0);
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.e = dimensionPixelSize;
        this.e = obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabPaddingStart, this.e);
        this.f = obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabPaddingTop, this.f);
        this.g = obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabPaddingEnd, this.g);
        this.h = obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabPaddingBottom, this.h);
        this.i = obtainStyledAttributes.getResourceId(h.TabLayout_tabTextAppearance, g.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.i, h.TextAppearance);
        try {
            this.k = (float) obtainStyledAttributes2.getDimensionPixelSize(h.TextAppearance_android_textSize, 0);
            this.j = obtainStyledAttributes2.getColorStateList(h.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(h.TabLayout_tabTextColor)) {
                this.j = obtainStyledAttributes.getColorStateList(h.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(h.TabLayout_tabSelectedTextColor)) {
                dimensionPixelSize = obtainStyledAttributes.getColor(h.TabLayout_tabSelectedTextColor, 0);
                int defaultColor = this.j.getDefaultColor();
                r3 = new int[2][];
                int[] iArr = new int[]{SELECTED_STATE_SET, dimensionPixelSize};
                r3[1] = EMPTY_STATE_SET;
                iArr[1] = defaultColor;
                this.j = new ColorStateList(r3, iArr);
            }
            this.o = obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabMinWidth, -1);
            this.p = obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabMaxWidth, -1);
            this.m = obtainStyledAttributes.getResourceId(h.TabLayout_tabBackground, 0);
            this.r = obtainStyledAttributes.getDimensionPixelSize(h.TabLayout_tabContentStart, 0);
            this.t = obtainStyledAttributes.getInt(h.TabLayout_tabMode, 1);
            this.s = obtainStyledAttributes.getInt(h.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.l = (float) resources.getDimensionPixelSize(d.design_tab_text_size_2line);
            this.q = resources.getDimensionPixelSize(d.design_tab_scrollable_min_width);
            d();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private int a(int i, float f) {
        int i2 = 0;
        if (this.t != 0) {
            return 0;
        }
        View childAt = this.d.getChildAt(i);
        View childAt2 = i + 1 < this.d.getChildCount() ? this.d.getChildAt(i + 1) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.d.getChildCount()) {
            if (z2) {
                br brVar = this.d;
                if (brVar.c != null && brVar.c.a.b()) {
                    brVar.c.a.e();
                }
                brVar.a = i;
                brVar.b = f;
                brVar.a();
            }
            if (this.v != null && this.v.a.b()) {
                this.v.a.e();
            }
            scrollTo(a(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private void a(bu buVar, int i) {
        buVar.e = i;
        this.b.add(i, buVar);
        int size = this.b.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((bu) this.b.get(i2)).e = i2;
        }
    }

    private void a(bj bjVar, boolean z) {
        if (!(this.x == null || this.y == null)) {
            bj bjVar2 = this.x;
            bjVar2.a.unregisterObserver(this.y);
        }
        this.x = bjVar;
        if (z && bjVar != null) {
            if (this.y == null) {
                this.y = new bq();
            }
            bjVar.a.registerObserver(this.y);
        }
        c();
    }

    private void a(View view) {
        if (view instanceof bn) {
            bn bnVar = (bn) view;
            bu a = a();
            if (bnVar.a != null) {
                a.a(bnVar.a);
            }
            if (bnVar.b != null) {
                a.b = bnVar.b;
                a.b();
            }
            if (bnVar.c != 0) {
                a.a(LayoutInflater.from(a.h.getContext()).inflate(bnVar.c, a.h, false));
            }
            b(a, this.b.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.t == 1 && this.s == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private void a(boolean z) {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            View childAt = this.d.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private int b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    private void b() {
        for (int childCount = this.d.getChildCount() - 1; childCount >= 0; childCount--) {
            bw bwVar = (bw) this.d.getChildAt(childCount);
            this.d.removeViewAt(childCount);
            if (bwVar != null) {
                bw.a(bwVar);
                this.A.a(bwVar);
            }
            requestLayout();
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            bu buVar = (bu) it.next();
            it.remove();
            buVar.g = null;
            buVar.h = null;
            buVar.a = null;
            buVar.b = null;
            buVar.c = null;
            buVar.d = null;
            buVar.e = -1;
            buVar.f = null;
            a.a(buVar);
        }
        this.c = null;
    }

    private void b(bu buVar, boolean z) {
        if (buVar.g != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        View view = buVar.h;
        br brVar = this.d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        brVar.addView(view, layoutParams);
        if (z) {
            view.setSelected(true);
        }
        a(buVar, this.b.size());
        if (z) {
            buVar.a();
        }
    }

    private void c() {
        b();
        if (this.x != null) {
            int i;
            for (i = 0; i < 3; i++) {
                b(a().a(null), false);
            }
            if (this.w != null) {
                i = this.w.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    a(a(i), true);
                    return;
                }
                return;
            }
            return;
        }
        b();
    }

    private void c(int i) {
        Object obj = null;
        if (i != -1) {
            if (getWindowToken() != null && bq.F(this)) {
                int i2;
                br brVar = this.d;
                int childCount = brVar.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (brVar.getChildAt(i2).getWidth() <= 0) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    int scrollX = getScrollX();
                    i2 = a(i, 0.0f);
                    if (scrollX != i2) {
                        if (this.v == null) {
                            this.v = cv.a();
                            this.v.a(a.b);
                            this.v.a(300);
                            this.v.a(new bo(this));
                        }
                        this.v.a(scrollX, i2);
                        this.v.a.a();
                    }
                    this.d.a(i, 300);
                    return;
                }
            }
            setScrollPosition$4867b5c2(i);
        }
    }

    private void d() {
        bq.a(this.d, this.t == 0 ? Math.max(0, this.r - this.e) : 0, 0, 0, 0);
        switch (this.t) {
            case 0:
                this.d.setGravity(8388611);
                break;
            case 1:
                this.d.setGravity(1);
                break;
        }
        a(true);
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            bu buVar = (bu) this.b.get(i);
            if (buVar != null && buVar.b != null && !TextUtils.isEmpty(buVar.c)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        return obj != null ? 72 : 48;
    }

    private float getScrollPosition() {
        br brVar = this.d;
        return brVar.b + ((float) brVar.a);
    }

    private int getTabMaxWidth() {
        return this.n;
    }

    private int getTabMinWidth() {
        return this.o != -1 ? this.o : this.t == 0 ? this.q : 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setScrollPosition$4867b5c2(int i) {
        a(i, 0.0f, true, true);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.d.getChildCount();
        if (i < childCount && !this.d.getChildAt(i).isSelected()) {
            int i2 = 0;
            while (i2 < childCount) {
                this.d.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    public final bu a() {
        bu buVar = (bu) a.a();
        bu buVar2 = buVar == null ? new bu() : buVar;
        buVar2.g = this;
        bw bwVar = this.A != null ? (bw) this.A.a() : null;
        if (bwVar == null) {
            bwVar = new bw(this, getContext());
        }
        bwVar.a(buVar2);
        bwVar.setFocusable(true);
        bwVar.setMinimumWidth(getTabMinWidth());
        buVar2.h = bwVar;
        return buVar2;
    }

    public final bu a(int i) {
        return (bu) this.b.get(i);
    }

    final void a(bu buVar, boolean z) {
        if (this.c != buVar) {
            if (z) {
                int i = buVar != null ? buVar.e : -1;
                if (i != -1) {
                    setSelectedTabView(i);
                }
                if ((this.c == null || this.c.e == -1) && i != -1) {
                    setScrollPosition$4867b5c2(i);
                } else {
                    c(i);
                }
            }
            if (!(this.c == null || this.u == null)) {
                this.u.b(this.c);
            }
            this.c = buVar;
            if (this.c != null && this.u != null) {
                this.u.a(this.c);
            }
        } else if (this.c != null) {
            c(buVar.e);
        }
    }

    public void addView(View view) {
        a(view);
    }

    public void addView(View view, int i) {
        a(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        return this.c != null ? this.c.e : -1;
    }

    public int getTabCount() {
        return this.b.size();
    }

    public int getTabGravity() {
        return this.s;
    }

    public int getTabMode() {
        return this.t;
    }

    public ColorStateList getTabTextColors() {
        return this.j;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int b = (b(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(b, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(b, 1073741824);
                break;
        }
        b = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            this.n = this.p > 0 ? this.p : b - b(56);
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.t) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        b = 0;
                        break;
                    } else {
                        b = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    b = i3;
                    break;
                default:
                    b = 0;
                    break;
            }
            if (b != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void setOnTabSelectedListener(bp bpVar) {
        this.u = bpVar;
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.d.a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.d.b(i);
    }

    public void setTabGravity(int i) {
        if (this.s != i) {
            this.s = i;
            d();
        }
    }

    public void setTabMode(int i) {
        if (i != this.t) {
            this.t = i;
            d();
        }
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((bu) this.b.get(i)).b();
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(bj bjVar) {
        a(bjVar, false);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        bv bvVar;
        if (!(this.w == null || this.z == null)) {
            ViewPager viewPager2 = this.w;
            bvVar = this.z;
            if (viewPager2.a != null) {
                viewPager2.a.remove(bvVar);
            }
        }
        if (viewPager != null) {
            bj adapter = viewPager.getAdapter();
            if (adapter == null) {
                throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
            }
            this.w = viewPager;
            if (this.z == null) {
                this.z = new bv(this);
            }
            bvVar = this.z;
            bvVar.b = 0;
            bvVar.a = 0;
            viewPager.a(this.z);
            setOnTabSelectedListener(new bx(viewPager));
            a(adapter, true);
            return;
        }
        this.w = null;
        setOnTabSelectedListener(null);
        a(null, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
