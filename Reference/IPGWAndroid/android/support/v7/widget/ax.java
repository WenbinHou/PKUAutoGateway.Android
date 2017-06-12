package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bl;
import android.support.v7.b.b;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public final class ax extends MultiAutoCompleteTextView implements bl {
    private static final int[] a = new int[]{16843126};
    private ao b;
    private aj c;
    private bm d;

    public ax(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.autoCompleteTextViewStyle);
    }

    private ax(Context context, AttributeSet attributeSet, int i) {
        super(fq.a(context), attributeSet, i);
        this.b = ao.a();
        ft a = ft.a(getContext(), attributeSet, a, i);
        if (a.e(0)) {
            setDropDownBackgroundDrawable(a.a(0));
        }
        a.a.recycle();
        this.c = new aj(this, this.b);
        this.c.a(attributeSet, i);
        this.d = bm.a((TextView) this);
        this.d.a(attributeSet, i);
        this.d.a();
    }

    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.c != null) {
            this.c.c();
        }
        if (this.d != null) {
            this.d.a();
        }
    }

    public final ColorStateList getSupportBackgroundTintList() {
        return this.c != null ? this.c.a() : null;
    }

    public final Mode getSupportBackgroundTintMode() {
        return this.c != null ? this.c.b() : null;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.c != null) {
            this.c.b(null);
        }
    }

    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.c != null) {
            this.c.a(i);
        }
    }

    public final void setDropDownBackgroundResource(int i) {
        if (this.b != null) {
            setDropDownBackgroundDrawable(this.b.a(getContext(), i, false));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.c != null) {
            this.c.a(colorStateList);
        }
    }

    public final void setSupportBackgroundTintMode(Mode mode) {
        if (this.c != null) {
            this.c.a(mode);
        }
    }

    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.d != null) {
            this.d.a(context, i);
        }
    }
}
