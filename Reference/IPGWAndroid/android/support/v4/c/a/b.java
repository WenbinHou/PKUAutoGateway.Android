package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class b implements c {
    b() {
    }

    public void a(Drawable drawable) {
    }

    public void a(Drawable drawable, float f, float f2) {
    }

    public void a(Drawable drawable, int i) {
        if (drawable instanceof k) {
            ((k) drawable).a(i);
        }
    }

    public void a(Drawable drawable, int i, int i2, int i3, int i4) {
    }

    public void a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof k) {
            ((k) drawable).a(colorStateList);
        }
    }

    public void a(Drawable drawable, Theme theme) {
    }

    public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    public void a(Drawable drawable, Mode mode) {
        if (drawable instanceof k) {
            ((k) drawable).a(mode);
        }
    }

    public void a(Drawable drawable, boolean z) {
    }

    public void b(Drawable drawable, int i) {
    }

    public boolean b(Drawable drawable) {
        return false;
    }

    public Drawable c(Drawable drawable) {
        return !(drawable instanceof l) ? new l(drawable) : drawable;
    }

    public int d(Drawable drawable) {
        return 0;
    }

    public int e(Drawable drawable) {
        return 0;
    }

    public boolean f(Drawable drawable) {
        return false;
    }

    public ColorFilter g(Drawable drawable) {
        return null;
    }
}
