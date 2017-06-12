package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ao;
import android.support.v4.view.as;
import android.support.v4.view.ay;
import android.support.v4.view.bq;
import android.support.v4.view.v;
import android.support.v7.b.b;
import android.support.v7.b.l;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.y;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private CharSequence A;
    private CharSequence B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private final ArrayList<View> G;
    private final int[] H;
    private fz I;
    private final w J;
    private gb K;
    private boolean L;
    private final Runnable M;
    private final ao N;
    ActionMenuView a;
    TextView b;
    TextView c;
    View d;
    Context e;
    int f;
    int g;
    int h;
    final et i;
    final ArrayList<View> j;
    k k;
    fx l;
    y m;
    j n;
    private ImageButton o;
    private ImageView p;
    private Drawable q;
    private CharSequence r;
    private ImageButton s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ga();
        int a;
        boolean b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new et();
        this.z = 8388627;
        this.G = new ArrayList();
        this.j = new ArrayList();
        this.H = new int[2];
        this.J = new fu(this);
        this.M = new fv(this);
        ft a = ft.a(getContext(), attributeSet, l.Toolbar, i);
        this.g = a.e(l.Toolbar_titleTextAppearance, 0);
        this.h = a.e(l.Toolbar_subtitleTextAppearance, 0);
        this.z = a.a.getInteger(l.Toolbar_android_gravity, this.z);
        this.t = 48;
        int b = a.b(l.Toolbar_titleMargins, 0);
        this.y = b;
        this.x = b;
        this.w = b;
        this.v = b;
        b = a.b(l.Toolbar_titleMarginStart, -1);
        if (b >= 0) {
            this.v = b;
        }
        b = a.b(l.Toolbar_titleMarginEnd, -1);
        if (b >= 0) {
            this.w = b;
        }
        b = a.b(l.Toolbar_titleMarginTop, -1);
        if (b >= 0) {
            this.x = b;
        }
        b = a.b(l.Toolbar_titleMarginBottom, -1);
        if (b >= 0) {
            this.y = b;
        }
        this.u = a.c(l.Toolbar_maxButtonHeight, -1);
        b = a.b(l.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int b2 = a.b(l.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int c = a.c(l.Toolbar_contentInsetLeft, 0);
        int c2 = a.c(l.Toolbar_contentInsetRight, 0);
        et etVar = this.i;
        etVar.h = false;
        if (c != Integer.MIN_VALUE) {
            etVar.e = c;
            etVar.a = c;
        }
        if (c2 != Integer.MIN_VALUE) {
            etVar.f = c2;
            etVar.b = c2;
        }
        if (!(b == Integer.MIN_VALUE && b2 == Integer.MIN_VALUE)) {
            this.i.a(b, b2);
        }
        this.q = a.a(l.Toolbar_collapseIcon);
        this.r = a.c(l.Toolbar_collapseContentDescription);
        CharSequence c3 = a.c(l.Toolbar_title);
        if (!TextUtils.isEmpty(c3)) {
            setTitle(c3);
        }
        c3 = a.c(l.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.e = getContext();
        setPopupTheme(a.e(l.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(l.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c3 = a.c(l.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c3)) {
            setNavigationContentDescription(c3);
        }
        a2 = a.a(l.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c3 = a.c(l.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c3)) {
            setLogoDescription(c3);
        }
        if (a.e(l.Toolbar_titleTextColor)) {
            setTitleTextColor(a.d(l.Toolbar_titleTextColor));
        }
        if (a.e(l.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.d(l.Toolbar_subtitleTextColor));
        }
        a.a.recycle();
        this.N = ao.a();
    }

    private int a(int i) {
        int h = bq.h(this);
        int a = v.a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private int a(View view, int i) {
        fy fyVar = (fy) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = fyVar.a & 112;
        switch (i3) {
            case 16:
            case 48:
            case 80:
                break;
            default:
                i3 = this.z & 112;
                break;
        }
        switch (i3) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - fyVar.bottomMargin) - i2;
            default:
                int i4;
                i3 = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - i3) - paddingBottom) - measuredHeight) / 2;
                if (i2 < fyVar.topMargin) {
                    i4 = fyVar.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - i3;
                    i4 = measuredHeight < fyVar.bottomMargin ? Math.max(0, i2 - (fyVar.bottomMargin - measuredHeight)) : i2;
                }
                return i4 + i3;
        }
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        fy fyVar = (fy) view.getLayoutParams();
        int i3 = fyVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (fyVar.rightMargin + measuredWidth) + max;
    }

    private static fy a(LayoutParams layoutParams) {
        return layoutParams instanceof fy ? new fy((fy) layoutParams) : layoutParams instanceof android.support.v7.a.b ? new fy((android.support.v7.a.b) layoutParams) : layoutParams instanceof MarginLayoutParams ? new fy((MarginLayoutParams) layoutParams) : new fy(layoutParams);
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new fy();
        } else if (checkLayoutParams(layoutParams)) {
            fy fyVar = (fy) layoutParams;
        } else {
            layoutParams = a(layoutParams);
        }
        layoutParams.b = 1;
        if (!z || this.d == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.j.add(view);
    }

    private void a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (bq.h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = v.a(i, bq.h(this));
        list.clear();
        fy fyVar;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                fyVar = (fy) childAt.getLayoutParams();
                if (fyVar.b == 0 && a(childAt) && a(fyVar.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            fyVar = (fy) childAt2.getLayoutParams();
            if (fyVar.b == 0 && a(childAt2) && a(fyVar.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return ao.b(marginLayoutParams) + ao.a(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        fy fyVar = (fy) view.getLayoutParams();
        int i3 = fyVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (fyVar.leftMargin + measuredWidth);
    }

    static /* synthetic */ void b(Toolbar toolbar) {
        if (toolbar.s == null) {
            toolbar.s = new ImageButton(toolbar.getContext(), null, b.toolbarNavigationButtonStyle);
            toolbar.s.setImageDrawable(toolbar.q);
            toolbar.s.setContentDescription(toolbar.r);
            LayoutParams fyVar = new fy();
            fyVar.a = 8388611 | (toolbar.t & 112);
            fyVar.b = 2;
            toolbar.s.setLayoutParams(fyVar);
            toolbar.s.setOnClickListener(new fw(toolbar));
        }
    }

    private static int c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.j.contains(view);
    }

    protected static fy e() {
        return new fy();
    }

    private void f() {
        if (this.p == null) {
            this.p = new ImageView(getContext());
        }
    }

    private void g() {
        d();
        if (this.a.a == null) {
            i iVar = (i) this.a.getMenu();
            if (this.l == null) {
                this.l = new fx();
            }
            this.a.setExpandedActionViewsExclusive(true);
            iVar.a(this.l, this.e);
        }
    }

    private MenuInflater getMenuInflater() {
        return new android.support.v7.view.i(getContext());
    }

    private void h() {
        if (this.o == null) {
            this.o = new ImageButton(getContext(), null, b.toolbarNavigationButtonStyle);
            LayoutParams fyVar = new fy();
            fyVar.a = 8388611 | (this.t & 112);
            this.o.setLayoutParams(fyVar);
        }
    }

    public final boolean a() {
        if (this.a != null) {
            ActionMenuView actionMenuView = this.a;
            boolean z = actionMenuView.c != null && actionMenuView.c.g();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        if (this.a != null) {
            ActionMenuView actionMenuView = this.a;
            boolean z = actionMenuView.c != null && actionMenuView.c.c();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        m mVar = this.l == null ? null : this.l.b;
        if (mVar != null) {
            mVar.collapseActionView();
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof fy);
    }

    final void d() {
        if (this.a == null) {
            this.a = new ActionMenuView(getContext());
            this.a.setPopupTheme(this.f);
            this.a.setOnMenuItemClickListener(this.J);
            this.a.a(this.m, this.n);
            LayoutParams fyVar = new fy();
            fyVar.a = 8388613 | (this.t & 112);
            this.a.setLayoutParams(fyVar);
            a(this.a, false);
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new fy();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new fy(getContext(), attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public int getContentInsetEnd() {
        et etVar = this.i;
        return etVar.g ? etVar.a : etVar.b;
    }

    public int getContentInsetLeft() {
        return this.i.a;
    }

    public int getContentInsetRight() {
        return this.i.b;
    }

    public int getContentInsetStart() {
        et etVar = this.i;
        return etVar.g ? etVar.b : etVar.a;
    }

    public Drawable getLogo() {
        return this.p != null ? this.p.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.p != null ? this.p.getContentDescription() : null;
    }

    public Menu getMenu() {
        g();
        return this.a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.o != null ? this.o.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.o != null ? this.o.getDrawable() : null;
    }

    public Drawable getOverflowIcon() {
        g();
        return this.a.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f;
    }

    public CharSequence getSubtitle() {
        return this.B;
    }

    public CharSequence getTitle() {
        return this.A;
    }

    public bu getWrapper() {
        if (this.K == null) {
            this.K = new gb(this);
        }
        return this.K;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.M);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        if (a == 9) {
            this.F = false;
        }
        if (!this.F) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.F = true;
            }
        }
        if (a == 10 || a == 3) {
            this.F = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int paddingTop;
        int measuredWidth;
        Object obj = bq.h(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.H;
        iArr[1] = 0;
        iArr[0] = 0;
        int q = bq.q(this);
        if (!a(this.o)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = b(this.o, i8, iArr, q);
            i5 = paddingLeft;
        } else {
            i5 = a(this.o, paddingLeft, iArr, q);
        }
        if (a(this.s)) {
            if (obj != null) {
                i8 = b(this.s, i8, iArr, q);
            } else {
                i5 = a(this.s, i5, iArr, q);
            }
        }
        if (a(this.a)) {
            if (obj != null) {
                i5 = a(this.a, i5, iArr, q);
            } else {
                i8 = b(this.a, i8, iArr, q);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (a(this.d)) {
            if (obj != null) {
                i8 = b(this.d, i8, iArr, q);
            } else {
                i5 = a(this.d, i5, iArr, q);
            }
        }
        if (!a(this.p)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = b(this.p, i8, iArr, q);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = a(this.p, i5, iArr, q);
        }
        boolean a = a(this.b);
        boolean a2 = a(this.c);
        i5 = 0;
        if (a) {
            fy fyVar = (fy) this.b.getLayoutParams();
            i5 = (fyVar.bottomMargin + (fyVar.topMargin + this.b.getMeasuredHeight())) + 0;
        }
        if (a2) {
            fyVar = (fy) this.c.getLayoutParams();
            measuredHeight = (fyVar.bottomMargin + (fyVar.topMargin + this.c.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            fyVar = (fy) (a ? this.b : this.c).getLayoutParams();
            fy fyVar2 = (fy) (a2 ? this.c : this.b).getLayoutParams();
            Object obj2 = ((!a || this.b.getMeasuredWidth() <= 0) && (!a2 || this.c.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.z & 112) {
                case 48:
                    paddingTop = (fyVar.topMargin + getPaddingTop()) + this.x;
                    break;
                case 80:
                    paddingTop = (((height - paddingBottom) - fyVar2.bottomMargin) - this.y) - measuredHeight;
                    break;
                default:
                    paddingTop = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop < fyVar.topMargin + this.x) {
                        i8 = fyVar.topMargin + this.x;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop) - paddingTop2;
                        i8 = measuredHeight < fyVar.bottomMargin + this.y ? Math.max(0, paddingTop - ((fyVar2.bottomMargin + this.y) - measuredHeight)) : paddingTop;
                    }
                    paddingTop = paddingTop2 + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.v : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (a) {
                    fyVar = (fy) this.b.getLayoutParams();
                    measuredWidth = i5 - this.b.getMeasuredWidth();
                    i6 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(measuredWidth, paddingTop, i5, i6);
                    paddingTop = i6 + fyVar.bottomMargin;
                    i6 = measuredWidth - this.w;
                } else {
                    i6 = i5;
                }
                if (a2) {
                    fyVar = (fy) this.c.getLayoutParams();
                    measuredWidth = fyVar.topMargin + paddingTop;
                    this.c.layout(i5 - this.c.getMeasuredWidth(), measuredWidth, i5, this.c.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i5 - this.w;
                    i8 = fyVar.bottomMargin;
                    i8 = measuredWidth;
                } else {
                    i8 = i5;
                }
                i6 = obj2 != null ? Math.min(i6, i8) : i5;
            } else {
                i8 = (obj2 != null ? this.v : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (a) {
                    fyVar = (fy) this.b.getLayoutParams();
                    i5 = this.b.getMeasuredWidth() + i7;
                    measuredWidth = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(i7, paddingTop, i5, measuredWidth);
                    i8 = fyVar.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.w;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop;
                }
                if (a2) {
                    fyVar = (fy) this.c.getLayoutParams();
                    i5 += fyVar.topMargin;
                    paddingTop = this.c.getMeasuredWidth() + i7;
                    this.c.layout(i7, i5, paddingTop, this.c.getMeasuredHeight() + i5);
                    i5 = this.w + paddingTop;
                    i8 = fyVar.bottomMargin;
                    i8 = i5;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        a(this.G, 3);
        int size = this.G.size();
        measuredWidth = i7;
        for (i5 = 0; i5 < size; i5++) {
            measuredWidth = a((View) this.G.get(i5), measuredWidth, iArr, q);
        }
        a(this.G, 5);
        i7 = this.G.size();
        i5 = 0;
        measuredHeight = i6;
        while (i5 < i7) {
            i6 = b((View) this.G.get(i5), measuredHeight, iArr, q);
            i5++;
            measuredHeight = i6;
        }
        a(this.G, 1);
        List list = this.G;
        i6 = iArr[0];
        i7 = iArr[1];
        paddingTop2 = list.size();
        size = i6;
        paddingTop = i7;
        i6 = 0;
        i7 = 0;
        while (i6 < paddingTop2) {
            View view = (View) list.get(i6);
            fyVar = (fy) view.getLayoutParams();
            size = fyVar.leftMargin - size;
            i8 = fyVar.rightMargin - paddingTop;
            paddingBottom = Math.max(0, size);
            int max = Math.max(0, i8);
            size = Math.max(0, -size);
            paddingTop = Math.max(0, -i8);
            i6++;
            i7 += (view.getMeasuredWidth() + paddingBottom) + max;
        }
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i7 / 2);
        i5 = i8 + i7;
        if (i8 < measuredWidth) {
            i8 = measuredWidth;
        } else if (i5 > measuredHeight) {
            i8 -= i5 - measuredHeight;
        }
        paddingLeft = this.G.size();
        measuredWidth = 0;
        i5 = i8;
        while (measuredWidth < paddingLeft) {
            i8 = a((View) this.G.get(measuredWidth), i5, iArr, q);
            measuredWidth++;
            i5 = i8;
        }
        this.G.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int a;
        int i5;
        Object obj;
        int[] iArr = this.H;
        if (gi.a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (a(this.o)) {
            a(this.o, i, 0, i2, this.u);
            i6 = this.o.getMeasuredWidth() + b(this.o);
            max = Math.max(0, this.o.getMeasuredHeight() + c(this.o));
            a = gi.a(0, bq.j(this.o));
            i5 = max;
        } else {
            a = 0;
            i5 = 0;
        }
        if (a(this.s)) {
            a(this.s, i, 0, i2, this.u);
            i6 = this.s.getMeasuredWidth() + b(this.s);
            i5 = Math.max(i5, this.s.getMeasuredHeight() + c(this.s));
            a = gi.a(a, bq.j(this.s));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = Math.max(contentInsetStart, i6) + 0;
        iArr[i4] = Math.max(0, contentInsetStart - i6);
        i6 = 0;
        if (a(this.a)) {
            a(this.a, i, max2, i2, this.u);
            i6 = this.a.getMeasuredWidth() + b(this.a);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + c(this.a));
            a = gi.a(a, bq.j(this.a));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i6);
        iArr[i3] = Math.max(0, contentInsetStart - i6);
        if (a(this.d)) {
            max2 += a(this.d, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.d.getMeasuredHeight() + c(this.d));
            a = gi.a(a, bq.j(this.d));
        }
        if (a(this.p)) {
            max2 += a(this.p, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.p.getMeasuredHeight() + c(this.p));
            a = gi.a(a, bq.j(this.p));
        }
        i4 = getChildCount();
        i3 = 0;
        int i7 = a;
        int i8 = i5;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((fy) childAt.getLayoutParams()).b == 0 && a(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + c(childAt));
                i6 = gi.a(i7, bq.j(childAt));
                contentInsetStart = max;
            } else {
                i6 = i7;
                contentInsetStart = i8;
            }
            i3++;
            i7 = i6;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i6 = 0;
        int i9 = this.x + this.y;
        max = this.v + this.w;
        if (a(this.b)) {
            a(this.b, i, max2 + max, i2, i9, iArr);
            contentInsetStart = b(this.b) + this.b.getMeasuredWidth();
            i6 = this.b.getMeasuredHeight() + c(this.b);
            i7 = gi.a(i7, bq.j(this.b));
        }
        if (a(this.c)) {
            contentInsetStart = Math.max(contentInsetStart, a(this.c, i, max2 + max, i2, i9 + i6, iArr));
            i6 += this.c.getMeasuredHeight() + c(this.c);
            i7 = gi.a(i7, bq.j(this.c));
        }
        contentInsetStart += max2;
        i6 = Math.max(i8, i6) + (getPaddingTop() + getPaddingBottom());
        int i10 = i;
        max = bq.a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i10, -16777216 & i7);
        i6 = bq.a(Math.max(i6, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (this.L) {
            max2 = getChildCount();
            for (contentInsetStart = 0; contentInsetStart < max2; contentInsetStart++) {
                View childAt2 = getChildAt(contentInsetStart);
                if (a(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i6 = 0;
        }
        setMeasuredDimension(max, i6);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        Menu menu = this.a != null ? this.a.a : null;
        if (!(savedState.a == 0 || this.l == null || menu == null)) {
            MenuItem findItem = menu.findItem(savedState.a);
            if (findItem != null) {
                as.b(findItem);
            }
        }
        if (savedState.b) {
            removeCallbacks(this.M);
            post(this.M);
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        et etVar = this.i;
        if (i != 1) {
            z = false;
        }
        if (z != etVar.g) {
            etVar.g = z;
            if (!etVar.h) {
                etVar.a = etVar.e;
                etVar.b = etVar.f;
            } else if (z) {
                etVar.a = etVar.d != Integer.MIN_VALUE ? etVar.d : etVar.e;
                etVar.b = etVar.c != Integer.MIN_VALUE ? etVar.c : etVar.f;
            } else {
                etVar.a = etVar.c != Integer.MIN_VALUE ? etVar.c : etVar.e;
                etVar.b = etVar.d != Integer.MIN_VALUE ? etVar.d : etVar.f;
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.l == null || this.l.b == null)) {
            savedState.a = this.l.b.getItemId();
        }
        savedState.b = a();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        if (a == 0) {
            this.E = false;
        }
        if (!this.E) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.E = true;
            }
        }
        if (a == 1 || a == 3) {
            this.E = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.L = z;
        requestLayout();
    }

    public void setLogo(int i) {
        setLogo(this.N.a(getContext(), i, false));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!d(this.p)) {
                a(this.p, true);
            }
        } else if (this.p != null && d(this.p)) {
            removeView(this.p);
            this.j.remove(this.p);
        }
        if (this.p != null) {
            this.p.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        if (this.p != null) {
            this.p.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            h();
        }
        if (this.o != null) {
            this.o.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.N.a(getContext(), i, false));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            h();
            if (!d(this.o)) {
                a(this.o, true);
            }
        } else if (this.o != null && d(this.o)) {
            removeView(this.o);
            this.j.remove(this.o);
        }
        if (this.o != null) {
            this.o.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        h();
        this.o.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(fz fzVar) {
        this.I = fzVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        g();
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f != i) {
            this.f = i;
            if (i == 0) {
                this.e = getContext();
            } else {
                this.e = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                Context context = getContext();
                this.c = new TextView(context);
                this.c.setSingleLine();
                this.c.setEllipsize(TruncateAt.END);
                if (this.h != 0) {
                    this.c.setTextAppearance(context, this.h);
                }
                if (this.D != 0) {
                    this.c.setTextColor(this.D);
                }
            }
            if (!d(this.c)) {
                a(this.c, true);
            }
        } else if (this.c != null && d(this.c)) {
            removeView(this.c);
            this.j.remove(this.c);
        }
        if (this.c != null) {
            this.c.setText(charSequence);
        }
        this.B = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.D = i;
        if (this.c != null) {
            this.c.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.b == null) {
                Context context = getContext();
                this.b = new TextView(context);
                this.b.setSingleLine();
                this.b.setEllipsize(TruncateAt.END);
                if (this.g != 0) {
                    this.b.setTextAppearance(context, this.g);
                }
                if (this.C != 0) {
                    this.b.setTextColor(this.C);
                }
            }
            if (!d(this.b)) {
                a(this.b, true);
            }
        } else if (this.b != null && d(this.b)) {
            removeView(this.b);
            this.j.remove(this.b);
        }
        if (this.b != null) {
            this.b.setText(charSequence);
        }
        this.A = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.C = i;
        if (this.b != null) {
            this.b.setTextColor(i);
        }
    }
}
