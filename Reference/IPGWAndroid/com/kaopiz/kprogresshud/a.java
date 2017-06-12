package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;

final class a extends View implements c {
    private Paint a = new Paint(1);
    private Paint b;
    private RectF c;
    private int d = 100;
    private int e = 0;

    public a(Context context) {
        super(context);
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeWidth((float) d.a(3.0f, getContext()));
        this.a.setColor(-1);
        this.b = new Paint(1);
        this.b.setStyle(Style.STROKE);
        this.b.setStrokeWidth((float) d.a(3.0f, getContext()));
        this.b.setColor(context.getResources().getColor(l.kprogresshud_grey_color));
        this.c = new RectF();
    }

    public final void a(int i) {
        this.d = i;
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (((float) this.e) * 360.0f) / ((float) this.d);
        canvas.drawArc(this.c, 270.0f, f, false, this.a);
        canvas.drawArc(this.c, 270.0f + f, 360.0f - f, false, this.b);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int a = d.a(40.0f, getContext());
        setMeasuredDimension(a, a);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int a = d.a(4.0f, getContext());
        this.c.set((float) a, (float) a, (float) (i - a), (float) (i2 - a));
    }
}
