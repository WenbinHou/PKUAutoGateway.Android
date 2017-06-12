package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bl;
import android.support.v7.b.b;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public final class at extends EditText implements bl {
    private ao a;
    private aj b;
    private bm c;

    public at(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.editTextStyle);
    }

    private at(Context context, AttributeSet attributeSet, int i) {
        super(fq.a(context), attributeSet, i);
        this.a = ao.a();
        this.b = new aj(this, this.a);
        this.b.a(attributeSet, i);
        this.c = bm.a((TextView) this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    public final ColorStateList getSupportBackgroundTintList() {
        return this.b != null ? this.b.a() : null;
    }

    public final Mode getSupportBackgroundTintMode() {
        return this.b != null ? this.b.b() : null;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.b(null);
        }
    }

    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    public final void setSupportBackgroundTintMode(Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }
}
