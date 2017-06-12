package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a;

final class k extends Drawable {
    final Paint a;
    final Rect b;
    final RectF c;
    float d;
    ColorStateList e;
    int f;
    boolean g;
    float h;
    private int i;
    private int j;
    private int k;
    private int l;

    public final void draw(Canvas canvas) {
        float height;
        if (this.g) {
            Paint paint = this.a;
            Rect rect = this.b;
            copyBounds(rect);
            height = this.d / ((float) rect.height());
            float f = 0.0f;
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, f, (float) rect.bottom, new int[]{a.a(this.i, this.f), a.a(this.j, this.f), a.a(a.b(this.j, 0), this.f), a.a(a.b(this.l, 0), this.f), a.a(this.l, this.f), a.a(this.k, this.f)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP));
            this.g = false;
        }
        height = this.a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        copyBounds(this.b);
        rectF.set(this.b);
        rectF.left += height;
        rectF.top += height;
        rectF.right -= height;
        rectF.bottom -= height;
        canvas.save();
        canvas.rotate(this.h, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.a);
        canvas.restore();
    }

    public final int getOpacity() {
        return this.d > 0.0f ? -3 : -2;
    }

    public final boolean getPadding(Rect rect) {
        int round = Math.round(this.d);
        rect.set(round, round, round, round);
        return true;
    }

    public final boolean isStateful() {
        return (this.e != null && this.e.isStateful()) || super.isStateful();
    }

    protected final void onBoundsChange(Rect rect) {
        this.g = true;
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.e != null) {
            int colorForState = this.e.getColorForState(iArr, this.f);
            if (colorForState != this.f) {
                this.g = true;
                this.f = colorForState;
            }
        }
        if (this.g) {
            invalidateSelf();
        }
        return this.g;
    }

    public final void setAlpha(int i) {
        this.a.setAlpha(i);
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
