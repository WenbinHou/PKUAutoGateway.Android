package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a;
import android.support.v4.widget.bl;
import android.support.v7.b.b;
import android.util.AttributeSet;
import android.widget.RadioButton;

public final class bb extends RadioButton implements bl {
    private ao a;
    private an b;

    public bb(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.radioButtonStyle);
    }

    private bb(Context context, AttributeSet attributeSet, int i) {
        super(fq.a(context), attributeSet, i);
        this.a = ao.a();
        this.b = new an(this, this.a);
        this.b.a(attributeSet, i);
    }

    public final int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.b != null ? this.b.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public final ColorStateList getSupportButtonTintList() {
        return this.b != null ? this.b.a : null;
    }

    public final Mode getSupportButtonTintMode() {
        return this.b != null ? this.b.b : null;
    }

    public final void setButtonDrawable(int i) {
        setButtonDrawable(this.a != null ? this.a.a(getContext(), i, false) : a.a(getContext(), i));
    }

    public final void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.b != null) {
            this.b.a();
        }
    }

    public final void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    public final void setSupportButtonTintMode(Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }
}
