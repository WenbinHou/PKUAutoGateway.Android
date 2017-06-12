package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.b;
import android.support.design.d;
import android.support.design.e;
import android.support.design.f;
import android.support.design.h;
import android.support.v4.view.bq;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    private static final Handler d = new Handler(Looper.getMainLooper(), new ar());
    final ViewGroup a;
    final SnackbarLayout b;
    final bf c;
    private final AccessibilityManager e;

    public class SnackbarLayout extends LinearLayout {
        TextView a;
        Button b;
        private int c;
        private int d;
        private bc e;
        private bb f;

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.SnackbarLayout);
            this.c = obtainStyledAttributes.getDimensionPixelSize(h.SnackbarLayout_android_maxWidth, -1);
            this.d = obtainStyledAttributes.getDimensionPixelSize(h.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(h.SnackbarLayout_elevation)) {
                bq.f((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(h.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(f.design_layout_snackbar_include, this);
            bq.k(this);
            bq.c((View) this, 1);
        }

        private boolean a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.a.getPaddingTop() == i2 && this.a.getPaddingBottom() == i3) {
                return z;
            }
            View view = this.a;
            if (bq.A(view)) {
                bq.a(view, bq.l(view), i2, bq.m(view), i3);
            } else {
                view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
            }
            return true;
        }

        Button getActionView() {
            return this.b;
        }

        TextView getMessageView() {
            return this.a;
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f != null) {
                this.f.a();
            }
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.a = (TextView) findViewById(e.snackbar_text);
            this.b = (Button) findViewById(e.snackbar_action);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.e != null) {
                this.e.a();
            }
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.c > 0 && getMeasuredWidth() > this.c) {
                i = MeasureSpec.makeMeasureSpec(this.c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
            int i3 = this.a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.d <= 0 || this.b.getMeasuredWidth() <= this.d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        void setOnAttachStateChangeListener(bb bbVar) {
            this.f = bbVar;
        }

        void setOnLayoutChangeListener(bc bcVar) {
            this.e = bcVar;
        }
    }

    static /* synthetic */ void a(Snackbar snackbar) {
        bd a = bd.a();
        bf bfVar = snackbar.c;
        synchronized (a.a) {
            if (a.d(bfVar)) {
                a.a(a.b);
            } else if (a.e(bfVar)) {
                a.a(a.c);
            }
        }
    }

    static /* synthetic */ void g(Snackbar snackbar) {
        bd a = bd.a();
        bf bfVar = snackbar.c;
        synchronized (a.a) {
            if (a.d(bfVar)) {
                a.b(a.b);
            }
        }
    }

    final void a() {
        if (VERSION.SDK_INT >= 14) {
            bq.b(this.b, (float) this.b.getHeight());
            bq.r(this.b).c(0.0f).a(a.b).a(250).a(new ax(this)).b();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), b.design_snackbar_in);
        loadAnimation.setInterpolator(a.b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new ay(this));
        this.b.startAnimation(loadAnimation);
    }

    final void b() {
        bd a = bd.a();
        bf bfVar = this.c;
        synchronized (a.a) {
            if (a.d(bfVar)) {
                a.b = null;
                if (!(a.c == null || a.c == null)) {
                    a.b = a.c;
                    a.c = null;
                    if (((bf) a.b.a.get()) == null) {
                        a.b = null;
                    }
                }
            }
        }
        ViewParent parent = this.b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.b);
        }
    }
}
