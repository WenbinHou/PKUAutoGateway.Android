package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bl;
import android.support.v7.b.b;
import android.util.AttributeSet;
import android.widget.ImageButton;

public final class au extends ImageButton implements bl {
    private aj a;
    private av b;

    public au(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.imageButtonStyle);
    }

    private au(Context context, AttributeSet attributeSet, int i) {
        super(fq.a(context), attributeSet, i);
        ao a = ao.a();
        this.a = new aj(this, a);
        this.a.a(attributeSet, i);
        this.b = new av(this, a);
        this.b.a(attributeSet, i);
    }

    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null) {
            this.a.c();
        }
    }

    public final ColorStateList getSupportBackgroundTintList() {
        return this.a != null ? this.a.a() : null;
    }

    public final Mode getSupportBackgroundTintMode() {
        return this.a != null ? this.a.b() : null;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.a != null) {
            this.a.b(null);
        }
    }

    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public final void setImageResource(int i) {
        this.b.a(i);
    }

    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    public final void setSupportBackgroundTintMode(Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }
}
