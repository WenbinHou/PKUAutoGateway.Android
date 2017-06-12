package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.f.h;
import android.support.v4.widget.af;
import android.support.v7.b.b;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class cu {
    private static Method a;
    private static Method b;
    private final db A;
    private Runnable B;
    private final Handler C;
    private Rect D;
    private boolean E;
    private int F;
    public PopupWindow c;
    public cx d;
    int e;
    int f;
    int g;
    boolean h;
    public int i;
    int j;
    int k;
    public View l;
    public OnItemClickListener m;
    private Context n;
    private ListAdapter o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private View t;
    private DataSetObserver u;
    private Drawable v;
    private OnItemSelectedListener w;
    private final df x;
    private final de y;
    private final dd z;

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public cu(Context context) {
        this(context, null, b.listPopupWindowStyle);
    }

    public cu(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public cu(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = -2;
        this.e = -2;
        this.q = 1002;
        this.i = 0;
        this.r = false;
        this.s = false;
        this.j = Integer.MAX_VALUE;
        this.k = 0;
        this.x = new df();
        this.y = new de();
        this.z = new dd();
        this.A = new db();
        this.D = new Rect();
        this.n = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ListPopupWindow, i, i2);
        this.f = obtainStyledAttributes.getDimensionPixelOffset(l.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.g = obtainStyledAttributes.getDimensionPixelOffset(l.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.g != 0) {
            this.h = true;
        }
        obtainStyledAttributes.recycle();
        this.c = new ay(context, attributeSet, i);
        this.c.setInputMethodMode(1);
        this.F = h.a(this.n.getResources().getConfiguration().locale);
    }

    private int a(View view, int i, boolean z) {
        if (b != null) {
            try {
                return ((Integer) b.invoke(this.c, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.c.getMaxAvailableHeight(view, i);
    }

    public final void a(int i) {
        Drawable background = this.c.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            this.e = (this.D.left + this.D.right) + i;
            return;
        }
        this.e = i;
    }

    public final void a(Drawable drawable) {
        this.c.setBackgroundDrawable(drawable);
    }

    public void a(ListAdapter listAdapter) {
        if (this.u == null) {
            this.u = new dc();
        } else if (this.o != null) {
            this.o.unregisterDataSetObserver(this.u);
        }
        this.o = listAdapter;
        if (this.o != null) {
            listAdapter.registerDataSetObserver(this.u);
        }
        if (this.d != null) {
            this.d.setAdapter(this.o);
        }
    }

    public final void a(OnDismissListener onDismissListener) {
        this.c.setOnDismissListener(onDismissListener);
    }

    public void b() {
        int i;
        int i2;
        int makeMeasureSpec;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.d == null) {
            Context context = this.n;
            this.B = new cv(this);
            this.d = new cx(context, !this.E);
            if (this.v != null) {
                this.d.setSelector(this.v);
            }
            this.d.setAdapter(this.o);
            this.d.setOnItemClickListener(this.m);
            this.d.setFocusable(true);
            this.d.setFocusableInTouchMode(true);
            this.d.setOnItemSelectedListener(new cw(this));
            this.d.setOnScrollListener(this.z);
            if (this.w != null) {
                this.d.setOnItemSelectedListener(this.w);
            }
            View view2 = this.d;
            View view3 = this.t;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.k) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.k);
                        break;
                }
                if (this.e >= 0) {
                    i = this.e;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.c.setContentView(view);
        } else {
            this.c.getContentView();
            view = this.t;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.c.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            i = this.D.top + this.D.bottom;
            if (!this.h) {
                this.g = -this.D.top;
            }
        } else {
            this.D.setEmpty();
            i = 0;
        }
        int a = a(this.l, this.g, this.c.getInputMethodMode() == 2);
        if (this.r || this.p == -1) {
            i2 = a + i;
        } else {
            switch (this.e) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.n.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.n.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.e, 1073741824);
                    break;
            }
            makeMeasureSpec = this.d.a(makeMeasureSpec, a - i2);
            if (makeMeasureSpec > 0) {
                i2 += i;
            }
            i2 += makeMeasureSpec;
        }
        boolean g = g();
        af.a(this.c, this.q);
        if (this.c.isShowing()) {
            i = this.e == -1 ? -1 : this.e == -2 ? this.l.getWidth() : this.e;
            if (this.p == -1) {
                makeMeasureSpec = g ? i2 : -1;
                if (g) {
                    this.c.setWidth(this.e == -1 ? -1 : 0);
                    this.c.setHeight(0);
                    a = makeMeasureSpec;
                } else {
                    this.c.setWidth(this.e == -1 ? -1 : 0);
                    this.c.setHeight(-1);
                    a = makeMeasureSpec;
                }
            } else {
                a = this.p != -2 ? this.p : i2;
            }
            PopupWindow popupWindow = this.c;
            if (this.s || this.r) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            popupWindow = this.c;
            View view4 = this.l;
            int i3 = this.f;
            makeMeasureSpec = this.g;
            if (i < 0) {
                i = -1;
            }
            if (a < 0) {
                a = -1;
            }
            popupWindow.update(view4, i3, makeMeasureSpec, i, a);
            return;
        }
        makeMeasureSpec = this.e == -1 ? -1 : this.e == -2 ? this.l.getWidth() : this.e;
        if (this.p == -1) {
            i2 = -1;
        } else if (this.p != -2) {
            i2 = this.p;
        }
        this.c.setWidth(makeMeasureSpec);
        this.c.setHeight(i2);
        if (a != null) {
            try {
                a.invoke(this.c, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
        popupWindow = this.c;
        if (this.s || this.r) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.c.setTouchInterceptor(this.y);
        af.a(this.c, this.l, this.f, this.g, this.i);
        this.d.setSelection(-1);
        if (!this.E || this.d.isInTouchMode()) {
            f();
        }
        if (!this.E) {
            this.C.post(this.A);
        }
    }

    public final void c() {
        this.E = true;
        this.c.setFocusable(true);
    }

    public final void d() {
        this.c.dismiss();
        if (this.t != null) {
            ViewParent parent = this.t.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
        this.c.setContentView(null);
        this.d = null;
        this.C.removeCallbacks(this.x);
    }

    public final void e() {
        this.c.setInputMethodMode(2);
    }

    public final void f() {
        cx cxVar = this.d;
        if (cxVar != null) {
            cxVar.h = true;
            cxVar.requestLayout();
        }
    }

    public final boolean g() {
        return this.c.getInputMethodMode() == 2;
    }
}
