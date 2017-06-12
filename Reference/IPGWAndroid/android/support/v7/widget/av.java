package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.b.a;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class av {
    private final ImageView a;
    private final ao b;

    public av(ImageView imageView, ao aoVar) {
        this.a = imageView;
        this.b = aoVar;
    }

    public final void a(int i) {
        if (i != 0) {
            Drawable a = this.b != null ? this.b.a(this.a.getContext(), i, false) : a.a(this.a.getContext(), i);
            if (a != null) {
                ch.b(a);
            }
            this.a.setImageDrawable(a);
            return;
        }
        this.a.setImageDrawable(null);
    }

    public final void a(AttributeSet attributeSet, int i) {
        ft a = ft.a(this.a.getContext(), attributeSet, l.AppCompatImageView, i);
        try {
            Drawable b = a.b(l.AppCompatImageView_android_src);
            if (b != null) {
                this.a.setImageDrawable(b);
            }
            int e = a.e(l.AppCompatImageView_srcCompat, -1);
            if (e != -1) {
                b = this.b.a(this.a.getContext(), e, false);
                if (b != null) {
                    this.a.setImageDrawable(b);
                }
            }
            b = this.a.getDrawable();
            if (b != null) {
                ch.b(b);
            }
            a.a.recycle();
        } catch (Throwable th) {
            a.a.recycle();
        }
    }
}
