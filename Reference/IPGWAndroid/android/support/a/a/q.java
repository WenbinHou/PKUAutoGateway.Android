package android.support.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class q extends ConstantState {
    int a;
    p b;
    ColorStateList c;
    Mode d;
    boolean e;
    Bitmap f;
    ColorStateList g;
    Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;

    public q() {
        this.c = null;
        this.d = k.b;
        this.b = new p();
    }

    public q(q qVar) {
        this.c = null;
        this.d = k.b;
        if (qVar != null) {
            this.a = qVar.a;
            this.b = new p(qVar.b);
            if (qVar.b.m != null) {
                this.b.m = new Paint(qVar.b.m);
            }
            if (qVar.b.l != null) {
                this.b.l = new Paint(qVar.b.l);
            }
            this.c = qVar.c;
            this.d = qVar.d;
            this.e = qVar.e;
        }
    }

    public final void a(int i, int i2) {
        this.f.eraseColor(0);
        this.b.a(new Canvas(this.f), i, i2);
    }

    public final int getChangingConfigurations() {
        return this.a;
    }

    public final Drawable newDrawable() {
        return new k();
    }

    public final Drawable newDrawable(Resources resources) {
        return new k();
    }
}
