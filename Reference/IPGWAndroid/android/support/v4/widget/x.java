package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.b.b;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

final class x extends Drawable implements Animatable {
    private static final Interpolator c = new LinearInterpolator();
    private static final Interpolator d = new b();
    final ab a;
    boolean b;
    private final int[] e = new int[]{-16777216};
    private final ArrayList<Animation> f = new ArrayList();
    private float g;
    private Resources h;
    private View i;
    private Animation j;
    private float k;
    private double l;
    private double m;
    private final Callback n = new aa(this);

    public x(Context context, View view) {
        this.i = view;
        this.h = context.getResources();
        this.a = new ab(this.n);
        this.a.a(this.e);
        a(1);
        ab abVar = this.a;
        Animation yVar = new y(this, abVar);
        yVar.setRepeatCount(-1);
        yVar.setRepeatMode(1);
        yVar.setInterpolator(c);
        yVar.setAnimationListener(new z(this, abVar));
        this.j = yVar;
    }

    private void a(double d, double d2, double d3, double d4, float f, float f2) {
        ab abVar = this.a;
        float f3 = this.h.getDisplayMetrics().density;
        this.l = ((double) f3) * d;
        this.m = ((double) f3) * d2;
        float f4 = ((float) d4) * f3;
        abVar.g = f4;
        abVar.b.setStrokeWidth(f4);
        abVar.d();
        abVar.q = ((double) f3) * d3;
        abVar.a(0);
        f4 = f * f3;
        f3 *= f2;
        abVar.r = (int) f4;
        abVar.s = (int) f3;
        f3 = (float) Math.min((int) this.l, (int) this.m);
        f3 = (abVar.q <= 0.0d || f3 < 0.0f) ? (float) Math.ceil((double) (abVar.g / 2.0f)) : (float) (((double) (f3 / 2.0f)) - abVar.q);
        abVar.h = f3;
    }

    static /* synthetic */ void a(float f, ab abVar) {
        c(f, abVar);
        float floor = (float) (Math.floor((double) (abVar.m / 0.8f)) + 1.0d);
        float b = b(abVar);
        abVar.a((((abVar.l - b) - abVar.k) * f) + abVar.k);
        abVar.b(abVar.l);
        abVar.c(((floor - abVar.m) * f) + abVar.m);
    }

    private static float b(ab abVar) {
        return (float) Math.toRadians(((double) abVar.g) / (6.283185307179586d * abVar.q));
    }

    private static void c(float f, ab abVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int i = abVar.i[abVar.j];
            int i2 = abVar.i[abVar.a()];
            i = Integer.valueOf(i).intValue();
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            i &= 255;
            i2 = Integer.valueOf(i2).intValue();
            abVar.w = (((int) (f2 * ((float) ((i2 & 255) - i)))) + i) | ((((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f2))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f2))) << 16)) | ((((int) (((float) (((i2 >> 8) & 255) - i5)) * f2)) + i5) << 8));
        }
    }

    public final void a(float f) {
        ab abVar = this.a;
        if (f != abVar.p) {
            abVar.p = f;
            abVar.d();
        }
    }

    public final void a(int i) {
        if (i == 0) {
            a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public final void a(boolean z) {
        this.a.a(z);
    }

    public final void b(float f) {
        this.a.a(0.0f);
        this.a.b(f);
    }

    public final void b(int i) {
        this.a.v = i;
    }

    final void c(float f) {
        this.g = f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.g, bounds.exactCenterX(), bounds.exactCenterY());
        ab abVar = this.a;
        RectF rectF = abVar.a;
        rectF.set(bounds);
        rectF.inset(abVar.h, abVar.h);
        float f = 360.0f * (abVar.d + abVar.f);
        float f2 = ((abVar.e + abVar.f) * 360.0f) - f;
        abVar.b.setColor(abVar.w);
        canvas.drawArc(rectF, f, f2, false, abVar.b);
        if (abVar.n) {
            if (abVar.o == null) {
                abVar.o = new Path();
                abVar.o.setFillType(FillType.EVEN_ODD);
            } else {
                abVar.o.reset();
            }
            float f3 = ((float) (((int) abVar.h) / 2)) * abVar.p;
            float cos = (float) ((abVar.q * Math.cos(0.0d)) + ((double) bounds.exactCenterX()));
            float sin = (float) ((abVar.q * Math.sin(0.0d)) + ((double) bounds.exactCenterY()));
            abVar.o.moveTo(0.0f, 0.0f);
            abVar.o.lineTo(((float) abVar.r) * abVar.p, 0.0f);
            abVar.o.lineTo((((float) abVar.r) * abVar.p) / 2.0f, ((float) abVar.s) * abVar.p);
            abVar.o.offset(cos - f3, sin);
            abVar.o.close();
            abVar.c.setColor(abVar.w);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(abVar.o, abVar.c);
        }
        if (abVar.t < 255) {
            abVar.u.setColor(abVar.v);
            abVar.u.setAlpha(255 - abVar.t);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), abVar.u);
        }
        canvas.restoreToCount(save);
    }

    public final int getAlpha() {
        return this.a.t;
    }

    public final int getIntrinsicHeight() {
        return (int) this.m;
    }

    public final int getIntrinsicWidth() {
        return (int) this.l;
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public final void setAlpha(int i) {
        this.a.t = i;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        ab abVar = this.a;
        abVar.b.setColorFilter(colorFilter);
        abVar.d();
    }

    public final void start() {
        this.j.reset();
        this.a.b();
        if (this.a.e != this.a.d) {
            this.b = true;
            this.j.setDuration(666);
            this.i.startAnimation(this.j);
            return;
        }
        this.a.a(0);
        this.a.c();
        this.j.setDuration(1332);
        this.i.startAnimation(this.j);
    }

    public final void stop() {
        this.i.clearAnimation();
        c(0.0f);
        this.a.a(false);
        this.a.a(0);
        this.a.c();
    }
}
