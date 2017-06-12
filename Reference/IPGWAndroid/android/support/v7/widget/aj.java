package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.bq;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.view.View;

final class aj {
    private final View a;
    private final ao b;
    private fr c;
    private fr d;
    private fr e;

    aj(View view, ao aoVar) {
        this.a = view;
        this.b = aoVar;
    }

    final ColorStateList a() {
        return this.d != null ? this.d.a : null;
    }

    final void a(int i) {
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
    }

    final void a(ColorStateList colorStateList) {
        if (this.d == null) {
            this.d = new fr();
        }
        this.d.a = colorStateList;
        this.d.d = true;
        c();
    }

    final void a(Mode mode) {
        if (this.d == null) {
            this.d = new fr();
        }
        this.d.b = mode;
        this.d.c = true;
        c();
    }

    final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, l.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(l.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.b.b(this.a.getContext(), obtainStyledAttributes.getResourceId(l.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    b(b);
                }
            }
            if (obtainStyledAttributes.hasValue(l.ViewBackgroundHelper_backgroundTint)) {
                bq.a(this.a, obtainStyledAttributes.getColorStateList(l.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(l.ViewBackgroundHelper_backgroundTintMode)) {
                bq.a(this.a, ch.a(obtainStyledAttributes.getInt(l.ViewBackgroundHelper_backgroundTintMode, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final Mode b() {
        return this.d != null ? this.d.b : null;
    }

    final void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.c == null) {
                this.c = new fr();
            }
            this.c.a = colorStateList;
            this.c.d = true;
        } else {
            this.c = null;
        }
        c();
    }

    final void c() {
        Drawable background = this.a.getBackground();
        if (background == null) {
            return;
        }
        if (this.d != null) {
            ao.a(background, this.d, this.a.getDrawableState());
        } else if (this.c != null) {
            ao.a(background, this.c, this.a.getDrawableState());
        } else {
            boolean z = VERSION.SDK_INT == 21 && (background instanceof GradientDrawable);
            if (z) {
                if (this.e == null) {
                    this.e = new fr();
                }
                fr frVar = this.e;
                frVar.a = null;
                frVar.d = false;
                frVar.b = null;
                frVar.c = false;
                ColorStateList B = bq.B(this.a);
                if (B != null) {
                    frVar.d = true;
                    frVar.a = B;
                }
                Mode C = bq.C(this.a);
                if (C != null) {
                    frVar.c = true;
                    frVar.b = C;
                }
                if (frVar.d || frVar.c) {
                    ao.a(background, frVar, this.a.getDrawableState());
                }
            }
        }
    }
}
