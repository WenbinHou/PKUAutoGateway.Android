package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class h extends g {
    h() {
    }

    public final void a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public final void a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public final void a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public final void a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public final void a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public final void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public final void a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public Drawable c(Drawable drawable) {
        return !(drawable instanceof u) ? new u(drawable) : drawable;
    }

    public final boolean f(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public final ColorFilter g(Drawable drawable) {
        return drawable.getColorFilter();
    }
}
