package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.ImageView;

final class p extends ImageView implements e {
    private float a;
    private int b = 83;
    private boolean c;
    private Runnable d = new q(this);

    public p(Context context) {
        super(context);
        setImageResource(m.kprogresshud_spinner);
    }

    public final void a(float f) {
        this.b = (int) (83.0f / f);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = true;
        post(this.d);
    }

    protected final void onDetachedFromWindow() {
        this.c = false;
        super.onDetachedFromWindow();
    }

    protected final void onDraw(Canvas canvas) {
        canvas.rotate(this.a, (float) (getWidth() / 2), (float) (getHeight() / 2));
        super.onDraw(canvas);
    }
}
