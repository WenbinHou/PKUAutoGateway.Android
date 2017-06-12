package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.v7.c.a.a;

final class ap extends a {
    static final double a = Math.cos(Math.toRadians(45.0d));
    final Paint b;
    final Paint c;
    final RectF d;
    float e;
    Path f;
    float g;
    float h;
    float i;
    float j;
    float k;
    private boolean m;
    private final int n;
    private final int o;
    private final int p;
    private boolean q;
    private boolean r;

    public static float a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - a) * ((double) f2))) : 1.5f * f;
    }

    private static int a(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public static float b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - a) * ((double) f2))) : f;
    }

    final void a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float a = (float) a(f);
        float a2 = (float) a(f2);
        if (a > a2) {
            if (!this.r) {
                this.r = true;
            }
            a = a2;
        }
        if (this.j != a || this.h != a2) {
            this.j = a;
            this.h = a2;
            this.i = (float) Math.round(a * 1.5f);
            this.g = a2;
            this.m = true;
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        float f;
        if (this.m) {
            Rect bounds = getBounds();
            float f2 = this.h * 1.5f;
            this.d.set(((float) bounds.left) + this.h, ((float) bounds.top) + f2, ((float) bounds.right) - this.h, ((float) bounds.bottom) - f2);
            this.l.setBounds((int) this.d.left, (int) this.d.top, (int) this.d.right, (int) this.d.bottom);
            RectF rectF = new RectF(-this.e, -this.e, this.e, this.e);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.i, -this.i);
            if (this.f == null) {
                this.f = new Path();
            } else {
                this.f.reset();
            }
            this.f.setFillType(FillType.EVEN_ODD);
            this.f.moveTo(-this.e, 0.0f);
            this.f.rLineTo(-this.i, 0.0f);
            this.f.arcTo(rectF2, 180.0f, 90.0f, false);
            this.f.arcTo(rectF, 270.0f, -90.0f, false);
            this.f.close();
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.e / f3;
                f = f4 + ((1.0f - f4) / 2.0f);
                this.b.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.n, this.o, this.p}, new float[]{0.0f, f4, f, 1.0f}, TileMode.CLAMP));
            }
            this.c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.n, this.o, this.p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.c.setAntiAlias(false);
            this.m = false;
        }
        int save = canvas.save();
        canvas.rotate(this.k, this.d.centerX(), this.d.centerY());
        float f5 = (-this.e) - this.i;
        f = this.e;
        Object obj = this.d.width() - (2.0f * f) > 0.0f ? 1 : null;
        Object obj2 = this.d.height() - (2.0f * f) > 0.0f ? 1 : null;
        float f6 = f / ((this.j - (this.j * 0.5f)) + f);
        float f7 = f / ((this.j - (this.j * 0.25f)) + f);
        float f8 = f / (f + (this.j - (this.j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.d.left + f, this.d.top + f);
        canvas.scale(f6, f7);
        canvas.drawPath(this.f, this.b);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.d.width() - (2.0f * f), -this.e, this.c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.d.right - f, this.d.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f, this.b);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.d.width() - (2.0f * f), this.i + (-this.e), this.c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.d.left + f, this.d.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f, this.b);
        if (obj2 != null) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.d.height() - (2.0f * f), -this.e, this.c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.d.right - f, this.d.top + f);
        canvas.scale(f6, f7);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f, this.b);
        if (obj2 != null) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f5, this.d.height() - (2.0f * f), -this.e, this.c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
        super.draw(canvas);
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.h, this.e, this.q));
        int ceil2 = (int) Math.ceil((double) b(this.h, this.e, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected final void onBoundsChange(Rect rect) {
        this.m = true;
    }

    public final void setAlpha(int i) {
        super.setAlpha(i);
        this.b.setAlpha(i);
        this.c.setAlpha(i);
    }
}
