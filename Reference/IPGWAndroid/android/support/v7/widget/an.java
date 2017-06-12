package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.a;
import android.support.v4.widget.f;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class an {
    ColorStateList a = null;
    Mode b = null;
    private final CompoundButton c;
    private final ao d;
    private boolean e = false;
    private boolean f = false;
    private boolean g;

    an(CompoundButton compoundButton, ao aoVar) {
        this.c = compoundButton;
        this.d = aoVar;
    }

    private void b() {
        Drawable a = f.a(this.c);
        if (a == null) {
            return;
        }
        if (this.e || this.f) {
            a = a.f(a).mutate();
            if (this.e) {
                a.a(a, this.a);
            }
            if (this.f) {
                a.a(a, this.b);
            }
            if (a.isStateful()) {
                a.setState(this.c.getDrawableState());
            }
            this.c.setButtonDrawable(a);
        }
    }

    final int a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = f.a(this.c);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }

    final void a() {
        if (this.g) {
            this.g = false;
            return;
        }
        this.g = true;
        b();
    }

    final void a(ColorStateList colorStateList) {
        this.a = colorStateList;
        this.e = true;
        b();
    }

    final void a(Mode mode) {
        this.b = mode;
        this.f = true;
        b();
    }

    final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.c.getContext().obtainStyledAttributes(attributeSet, l.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(l.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(l.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.c.setButtonDrawable(this.d.a(this.c.getContext(), resourceId, false));
                }
            }
            if (obtainStyledAttributes.hasValue(l.CompoundButton_buttonTint)) {
                f.a(this.c, obtainStyledAttributes.getColorStateList(l.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(l.CompoundButton_buttonTintMode)) {
                f.a(this.c, ch.a(obtainStyledAttributes.getInt(l.CompoundButton_buttonTintMode, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }
}
