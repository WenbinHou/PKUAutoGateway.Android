package android.support.design.widget;

import android.graphics.drawable.Drawable;

final class x implements aq {
    final /* synthetic */ FloatingActionButton a;

    private x(FloatingActionButton floatingActionButton) {
        this.a = floatingActionButton;
    }

    public final float a() {
        return ((float) this.a.getSizeDimension()) / 2.0f;
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.a.g.set(i, i2, i3, i4);
        this.a.setPadding(this.a.e + i, this.a.e + i2, this.a.e + i3, this.a.e + i4);
    }

    public final void a(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public final boolean b() {
        return this.a.f;
    }
}
