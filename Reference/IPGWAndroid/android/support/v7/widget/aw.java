package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bl;
import android.util.AttributeSet;
import android.widget.ImageView;

public class aw extends ImageView implements bl {
    private aj a;
    private av b;

    public aw(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aw(Context context, AttributeSet attributeSet, int i) {
        super(fq.a(context), attributeSet, i);
        ao a = ao.a();
        this.a = new aj(this, a);
        this.a.a(attributeSet, i);
        this.b = new av(this, a);
        this.b.a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null) {
            this.a.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.a != null ? this.a.a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.a != null ? this.a.b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.a != null) {
            this.a.b(null);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void setImageResource(int i) {
        this.b.a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }
}
