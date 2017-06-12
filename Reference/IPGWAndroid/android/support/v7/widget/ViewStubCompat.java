package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int a;
    private int b;
    private WeakReference<View> c;
    private LayoutInflater d;
    private gh e;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ViewStubCompat, i, 0);
        this.b = obtainStyledAttributes.getResourceId(l.ViewStubCompat_android_inflatedId, -1);
        this.a = obtainStyledAttributes.getResourceId(l.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(l.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = (this.d != null ? this.d : LayoutInflater.from(getContext())).inflate(this.a, viewGroup, false);
            if (this.b != -1) {
                inflate.setId(this.b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.c = new WeakReference(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    protected final void dispatchDraw(Canvas canvas) {
    }

    public final void draw(Canvas canvas) {
    }

    public final int getInflatedId() {
        return this.b;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.d;
    }

    public final int getLayoutResource() {
        return this.a;
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final void setInflatedId(int i) {
        this.b = i;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        this.d = layoutInflater;
    }

    public final void setLayoutResource(int i) {
        this.a = i;
    }

    public final void setOnInflateListener(gh ghVar) {
        this.e = ghVar;
    }

    public final void setVisibility(int i) {
        if (this.c != null) {
            View view = (View) this.c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            a();
        }
    }
}
