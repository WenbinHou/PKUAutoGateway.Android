package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.d;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.bq;
import android.support.v7.widget.av;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@o(a = Behavior.class)
public final class FloatingActionButton extends da {
    private ColorStateList a;
    private Mode b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private final Rect g;
    private av h;
    private ah i;

    public class Behavior extends n<FloatingActionButton> {
        private static final boolean a = (VERSION.SDK_INT >= 11);
        private bz b;
        private float c;
        private Rect d;

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((q) floatingActionButton.getLayoutParams()).f != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.d == null) {
                this.d = new Rect();
            }
            Rect rect = this.d;
            co.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.getImpl().c();
            } else {
                floatingActionButton.getImpl().d();
            }
            return true;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            int i3 = 0;
            view = (FloatingActionButton) view;
            List a = coordinatorLayout.a(view);
            int size = a.size();
            for (i2 = 0; i2 < size; i2++) {
                View view2 = (View) a.get(i2);
                if ((view2 instanceof AppBarLayout) && a(coordinatorLayout, (AppBarLayout) view2, (FloatingActionButton) view)) {
                    break;
                }
            }
            coordinatorLayout.a(view, i);
            Rect c = view.g;
            if (c != null && c.centerX() > 0 && c.centerY() > 0) {
                q qVar = (q) view.getLayoutParams();
                i2 = view.getRight() >= coordinatorLayout.getWidth() - qVar.rightMargin ? c.right : view.getLeft() <= qVar.leftMargin ? -c.left : 0;
                if (view.getBottom() >= coordinatorLayout.getBottom() - qVar.bottomMargin) {
                    i3 = c.bottom;
                } else if (view.getTop() <= qVar.topMargin) {
                    i3 = -c.top;
                }
                view.offsetTopAndBottom(i3);
                view.offsetLeftAndRight(i2);
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ boolean a_(View view) {
            return a && (view instanceof SnackbarLayout);
        }

        public final /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof SnackbarLayout) {
                float min;
                float f = 0.0f;
                List a = coordinatorLayout.a((View) floatingActionButton);
                int size = a.size();
                int i = 0;
                while (i < size) {
                    View view3 = (View) a.get(i);
                    if (view3 instanceof SnackbarLayout) {
                        boolean z;
                        if (floatingActionButton.getVisibility() == 0 && view3.getVisibility() == 0) {
                            Rect rect = coordinatorLayout.h;
                            coordinatorLayout.a((View) floatingActionButton, floatingActionButton.getParent() != coordinatorLayout, rect);
                            Rect rect2 = coordinatorLayout.i;
                            coordinatorLayout.a(view3, view3.getParent() != coordinatorLayout, rect2);
                            z = rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
                        } else {
                            z = false;
                        }
                        if (z) {
                            min = Math.min(f, bq.o(view3) - ((float) view3.getHeight()));
                            i++;
                            f = min;
                        }
                    }
                    min = f;
                    i++;
                    f = min;
                }
                if (this.c != f) {
                    min = bq.o(floatingActionButton);
                    if (this.b != null && this.b.a.b()) {
                        this.b.a.e();
                    }
                    if (!floatingActionButton.isShown() || Math.abs(min - f) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                        bq.b((View) floatingActionButton, f);
                    } else {
                        if (this.b == null) {
                            this.b = cv.a();
                            this.b.a(a.b);
                            this.b.a(new w(this, floatingActionButton));
                        }
                        this.b.a(min, f);
                        this.b.a.a();
                    }
                    this.c = f;
                }
            } else if (view2 instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            }
            return false;
        }
    }

    private static int a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private ah getImpl() {
        if (this.i == null) {
            int i = VERSION.SDK_INT;
            ah akVar = i >= 21 ? new ak(this, new x()) : i >= 14 ? new ae(this, new x()) : new y(this, new x());
            this.i = akVar;
        }
        return this.i;
    }

    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public final ColorStateList getBackgroundTintList() {
        return this.a;
    }

    public final Mode getBackgroundTintMode() {
        return this.b;
    }

    public final float getCompatElevation() {
        return getImpl().a();
    }

    public final Drawable getContentBackground() {
        return getImpl().e;
    }

    final int getSizeDimension() {
        switch (this.d) {
            case 1:
                return getResources().getDimensionPixelSize(d.design_fab_size_mini);
            default:
                return getResources().getDimensionPixelSize(d.design_fab_size_normal);
        }
    }

    public final boolean getUseCompatPadding() {
        return this.f;
    }

    @TargetApi(11)
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().b();
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah impl = getImpl();
        if (impl.f()) {
            if (impl.m == null) {
                impl.m = new ai(impl);
            }
            impl.k.getViewTreeObserver().addOnPreDrawListener(impl.m);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah impl = getImpl();
        if (impl.m != null) {
            impl.k.getViewTreeObserver().removeOnPreDrawListener(impl.m);
            impl.m = null;
        }
    }

    protected final void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        sizeDimension = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        setMeasuredDimension((this.g.left + sizeDimension) + this.g.right, (sizeDimension + this.g.top) + this.g.bottom);
    }

    public final void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public final void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public final void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.a != colorStateList) {
            this.a = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    public final void setBackgroundTintMode(Mode mode) {
        if (this.b != mode) {
            this.b = mode;
            getImpl().a(mode);
        }
    }

    public final void setCompatElevation(float f) {
        ah impl = getImpl();
        if (impl.f != f) {
            impl.f = f;
            impl.a(f);
        }
    }

    public final void setImageResource(int i) {
        this.h.a(i);
    }

    public final void setRippleColor(int i) {
        if (this.c != i) {
            this.c = i;
            getImpl().a(i);
        }
    }

    public final void setUseCompatPadding(boolean z) {
        if (this.f != z) {
            this.f = z;
            getImpl().e();
        }
    }

    public final /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }
}
