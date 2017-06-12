package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;

final class b extends View implements c {
    private Paint a = new Paint(1);
    private Paint b;
    private RectF c;
    private RectF d;
    private int e = 100;
    private int f = 0;
    private float g;
    private float h;

    public b(Context context) {
        super(context);
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeWidth((float) d.a(2.0f, getContext()));
        this.a.setColor(-1);
        this.b = new Paint(1);
        this.b.setStyle(Style.FILL);
        this.b.setColor(-1);
        this.h = (float) d.a(5.0f, getContext());
        this.d = new RectF(this.h, this.h, ((((float) getWidth()) - this.h) * ((float) this.f)) / ((float) this.e), ((float) getHeight()) - this.h);
        this.g = (float) d.a(10.0f, getContext());
        this.c = new RectF();
    }

    public final void a(int i) {
        this.e = i;
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(this.c, this.g, this.g, this.a);
        canvas.drawRoundRect(this.d, this.g, this.g, this.b);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(d.a(100.0f, getContext()), d.a(20.0f, getContext()));
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int a = d.a(2.0f, getContext());
        this.c.set((float) a, (float) a, (float) (i - a), (float) (i2 - a));
    }
}
