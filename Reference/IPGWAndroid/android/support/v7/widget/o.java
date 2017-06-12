package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.a;
import android.support.v7.b.b;

final class o extends aw implements s {
    final /* synthetic */ k a;
    private final float[] b = new float[2];

    public o(k kVar, Context context) {
        this.a = kVar;
        super(context, null, b.actionOverflowButtonStyle);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new p(this, this, kVar));
    }

    public final boolean c() {
        return false;
    }

    public final boolean d() {
        return false;
    }

    public final boolean performClick() {
        if (!super.performClick()) {
            playSoundEffect(0);
            this.a.c();
        }
        return true;
    }

    protected final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (!(drawable == null || background == null)) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            a.a(background, width - max, height - max, width + max, height + max);
        }
        return frame;
    }
}
