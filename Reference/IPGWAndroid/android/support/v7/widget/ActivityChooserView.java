package android.support.v7.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.n;
import android.support.v7.b.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

public final class ActivityChooserView extends ViewGroup {
    n a;
    private final ad b;
    private final ae c;
    private final co d;
    private final FrameLayout e;
    private final ImageView f;
    private final FrameLayout g;
    private final int h;
    private final DataSetObserver i;
    private final OnGlobalLayoutListener j;
    private cu k;
    private OnDismissListener l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;

    public class InnerLayout extends co {
        private static final int[] a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ft ftVar = new ft(context, context.obtainStyledAttributes(attributeSet, a));
            setBackgroundDrawable(ftVar.a(0));
            ftVar.a.recycle();
        }
    }

    private void a(int i) {
        if (this.b.a == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        boolean z = this.g.getVisibility() == 0;
        int a = this.b.a.a();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || a <= i2 + i) {
            this.b.a(false);
            this.b.a(i);
        } else {
            this.b.a(true);
            this.b.a(i - 1);
        }
        cu listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.c.isShowing()) {
            if (this.m || !z) {
                this.b.a(true, z);
            } else {
                this.b.a(false, false);
            }
            listPopupWindow.a(Math.min(this.b.a(), this.h));
            listPopupWindow.b();
            if (this.a != null) {
                this.a.a(true);
            }
            listPopupWindow.d.setContentDescription(getContext().getString(j.abc_activitychooserview_choose_application));
        }
    }

    private boolean b() {
        return getListPopupWindow().c.isShowing();
    }

    private cu getListPopupWindow() {
        if (this.k == null) {
            this.k = new cu(getContext());
            this.k.a(this.b);
            this.k.l = this;
            this.k.c();
            this.k.m = this.c;
            this.k.a(this.c);
        }
        return this.k;
    }

    public final boolean a() {
        if (getListPopupWindow().c.isShowing()) {
            getListPopupWindow().d();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.j);
            }
        }
        return true;
    }

    public final x getDataModel() {
        return this.b.a;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        x xVar = this.b.a;
        if (xVar != null) {
            xVar.registerObserver(this.i);
        }
        this.o = true;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x xVar = this.b.a;
        if (xVar != null) {
            xVar.unregisterObserver(this.i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.j);
        }
        if (b()) {
            a();
        }
        this.o = false;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.d.layout(0, 0, i3 - i, i4 - i2);
        if (!b()) {
            a();
        }
    }

    protected final void onMeasure(int i, int i2) {
        View view = this.d;
        if (this.g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public final void setActivityChooserModel(x xVar) {
        ad adVar = this.b;
        x xVar2 = adVar.c.b.a;
        if (xVar2 != null && adVar.c.isShown()) {
            xVar2.unregisterObserver(adVar.c.i);
        }
        adVar.a = xVar;
        if (xVar != null && adVar.c.isShown()) {
            xVar.registerObserver(adVar.c.i);
        }
        adVar.notifyDataSetChanged();
        if (getListPopupWindow().c.isShowing()) {
            a();
            if (!getListPopupWindow().c.isShowing() && this.o) {
                this.m = false;
                a(this.n);
            }
        }
    }

    public final void setDefaultActionButtonContentDescription(int i) {
        this.p = i;
    }

    public final void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f.setContentDescription(getContext().getString(i));
    }

    public final void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f.setImageDrawable(drawable);
    }

    public final void setInitialActivityCount(int i) {
        this.n = i;
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public final void setProvider(n nVar) {
        this.a = nVar;
    }
}
