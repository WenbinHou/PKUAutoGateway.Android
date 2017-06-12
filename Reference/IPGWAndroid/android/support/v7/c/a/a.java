package android.support.v7.c.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class a extends Drawable implements Callback {
    public Drawable l;

    public a(Drawable drawable) {
        if (this.l != null) {
            this.l.setCallback(null);
        }
        this.l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.l.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.l.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.l.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.l.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.l.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.l.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.l.getMinimumWidth();
    }

    public int getOpacity() {
        return this.l.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.l.getPadding(rect);
    }

    public int[] getState() {
        return this.l.getState();
    }

    public Region getTransparentRegion() {
        return this.l.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return android.support.v4.c.a.a.b(this.l);
    }

    public boolean isStateful() {
        return this.l.isStateful();
    }

    public void jumpToCurrentState() {
        android.support.v4.c.a.a.a(this.l);
    }

    public void onBoundsChange(Rect rect) {
        this.l.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.l.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.l.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        android.support.v4.c.a.a.a(this.l, z);
    }

    public void setChangingConfigurations(int i) {
        this.l.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.l.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.l.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.l.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        android.support.v4.c.a.a.a(this.l, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        android.support.v4.c.a.a.a(this.l, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.l.setState(iArr);
    }

    public void setTint(int i) {
        android.support.v4.c.a.a.a(this.l, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        android.support.v4.c.a.a.a(this.l, colorStateList);
    }

    public void setTintMode(Mode mode) {
        android.support.v4.c.a.a.a(this.l, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.l.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
