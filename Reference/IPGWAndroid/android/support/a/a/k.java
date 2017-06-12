package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.c.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public final class k extends j {
    static final Mode b = Mode.SRC_IN;
    q c;
    boolean d;
    private PorterDuffColorFilter e;
    private ColorFilter f;
    private boolean g;
    private ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    private k() {
        this.d = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new q();
    }

    private k(q qVar) {
        this.d = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = qVar;
        this.e = a(qVar.c, qVar.d);
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public static k a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            k kVar = new k();
            kVar.a = VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
            kVar.h = new r(kVar.a.getConstantState());
            return kVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static k a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        k kVar = new k();
        kVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return kVar;
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        q qVar = this.c;
        p pVar = qVar.b;
        Object obj = 1;
        Stack stack = new Stack();
        stack.push(pVar.p);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            Object obj2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                n nVar = (n) stack.peek();
                if ("path".equals(name)) {
                    o mVar = new m();
                    TypedArray a = j.a(resources, theme, attributeSet, a.c);
                    mVar.a(a, xmlPullParser);
                    a.recycle();
                    nVar.b.add(mVar);
                    if (mVar.n != null) {
                        pVar.g.put(mVar.n, mVar);
                    }
                    obj2 = null;
                    qVar.a = mVar.o | qVar.a;
                } else if ("clip-path".equals(name)) {
                    o lVar = new l();
                    if (i.a(xmlPullParser, "pathData")) {
                        r8 = j.a(resources, theme, attributeSet, a.d);
                        lVar.a(r8);
                        r8.recycle();
                    }
                    nVar.b.add(lVar);
                    if (lVar.n != null) {
                        pVar.g.put(lVar.n, lVar);
                    }
                    qVar.a |= lVar.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        n nVar2 = new n();
                        r8 = j.a(resources, theme, attributeSet, a.b);
                        nVar2.l = null;
                        nVar2.c = i.a(r8, xmlPullParser, "rotation", 5, nVar2.c);
                        nVar2.d = r8.getFloat(1, nVar2.d);
                        nVar2.e = r8.getFloat(2, nVar2.e);
                        nVar2.f = i.a(r8, xmlPullParser, "scaleX", 3, nVar2.f);
                        nVar2.g = i.a(r8, xmlPullParser, "scaleY", 4, nVar2.g);
                        nVar2.h = i.a(r8, xmlPullParser, "translateX", 6, nVar2.h);
                        nVar2.i = i.a(r8, xmlPullParser, "translateY", 7, nVar2.i);
                        String string = r8.getString(0);
                        if (string != null) {
                            nVar2.m = string;
                        }
                        nVar2.j.reset();
                        nVar2.j.postTranslate(-nVar2.d, -nVar2.e);
                        nVar2.j.postScale(nVar2.f, nVar2.g);
                        nVar2.j.postRotate(nVar2.c, 0.0f, 0.0f);
                        nVar2.j.postTranslate(nVar2.h + nVar2.d, nVar2.i + nVar2.e);
                        r8.recycle();
                        nVar.b.add(nVar2);
                        stack.push(nVar2);
                        if (nVar2.m != null) {
                            pVar.g.put(nVar2.m, nVar2);
                        }
                        qVar.a |= nVar2.k;
                    }
                    obj2 = obj;
                }
            } else {
                if (eventType == 3) {
                    if ("group".equals(xmlPullParser.getName())) {
                        stack.pop();
                    }
                }
                obj2 = obj;
            }
            obj = obj2;
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    public final /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public final boolean canApplyTheme() {
        if (this.a != null) {
            a.d(this.a);
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(Canvas canvas) {
        float f = 1.0f;
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.f == null ? this.e : this.f;
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float abs = Math.abs(this.i[0]);
            float abs2 = Math.abs(this.i[4]);
            float abs3 = Math.abs(this.i[1]);
            float abs4 = Math.abs(this.i[3]);
            if (abs3 == 0.0f && abs4 == 0.0f) {
                f = abs;
            } else {
                abs2 = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.k.height()));
            int min = Math.min(2048, (int) (f * ((float) this.k.width())));
            int min2 = Math.min(2048, height);
            if (min > 0 && min2 > 0) {
                boolean z;
                Paint paint;
                int save = canvas.save();
                canvas.translate((float) this.k.left, (float) this.k.top);
                this.k.offsetTo(0, 0);
                q qVar = this.c;
                if (qVar.f != null) {
                    z = min == qVar.f.getWidth() && min2 == qVar.f.getHeight();
                }
                qVar.f = Bitmap.createBitmap(min, min2, Config.ARGB_8888);
                qVar.k = true;
                if (this.d) {
                    q qVar2 = this.c;
                    z = !qVar2.k && qVar2.g == qVar2.c && qVar2.h == qVar2.d && qVar2.j == qVar2.e && qVar2.i == qVar2.b.e;
                    if (!z) {
                        this.c.a(min, min2);
                        qVar2 = this.c;
                        qVar2.g = qVar2.c;
                        qVar2.h = qVar2.d;
                        qVar2.i = qVar2.b.e;
                        qVar2.j = qVar2.e;
                        qVar2.k = false;
                    }
                } else {
                    this.c.a(min, min2);
                }
                q qVar3 = this.c;
                Rect rect = this.k;
                if ((qVar3.b.e < 255) || colorFilter != null) {
                    if (qVar3.l == null) {
                        qVar3.l = new Paint();
                        qVar3.l.setFilterBitmap(true);
                    }
                    qVar3.l.setAlpha(qVar3.b.e);
                    qVar3.l.setColorFilter(colorFilter);
                    paint = qVar3.l;
                } else {
                    paint = null;
                }
                canvas.drawBitmap(qVar3.f, null, rect, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    public final int getAlpha() {
        return this.a != null ? a.c(this.a) : this.c.b.e;
    }

    public final int getChangingConfigurations() {
        return this.a != null ? this.a.getChangingConfigurations() : super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final ConstantState getConstantState() {
        if (this.a != null) {
            return new r(this.a.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final int getIntrinsicHeight() {
        return this.a != null ? this.a.getIntrinsicHeight() : (int) this.c.b.b;
    }

    public final int getIntrinsicWidth() {
        return this.a != null ? this.a.getIntrinsicWidth() : (int) this.c.b.a;
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final int getOpacity() {
        return this.a != null ? this.a.getOpacity() : -3;
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            a.a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        q qVar = this.c;
        qVar.b = new p();
        TypedArray a = j.a(resources, theme, attributeSet, a.a);
        q qVar2 = this.c;
        p pVar = qVar2.b;
        int a2 = i.a(a, xmlPullParser, "tintMode", 6);
        Mode mode = Mode.SRC_IN;
        switch (a2) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            case 16:
                mode = Mode.ADD;
                break;
        }
        qVar2.d = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            qVar2.c = colorStateList;
        }
        boolean z = qVar2.e;
        if (i.a(xmlPullParser, "autoMirrored")) {
            z = a.getBoolean(5, z);
        }
        qVar2.e = z;
        pVar.c = i.a(a, xmlPullParser, "viewportWidth", 7, pVar.c);
        pVar.d = i.a(a, xmlPullParser, "viewportHeight", 8, pVar.d);
        if (pVar.c <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (pVar.d <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            pVar.a = a.getDimension(3, pVar.a);
            pVar.b = a.getDimension(2, pVar.b);
            if (pVar.a <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (pVar.b <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                pVar.e = (int) (i.a(a, xmlPullParser, "alpha", 4, ((float) pVar.e) / 255.0f) * 255.0f);
                String string = a.getString(0);
                if (string != null) {
                    pVar.f = string;
                    pVar.g.put(string, pVar);
                }
                a.recycle();
                qVar.a = getChangingConfigurations();
                qVar.k = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.e = a(qVar.c, qVar.d);
            }
        }
    }

    public final void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final boolean isStateful() {
        return this.a != null ? this.a.isStateful() : super.isStateful() || !(this.c == null || this.c.c == null || !this.c.c.isStateful());
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        } else if (!this.g && super.mutate() == this) {
            this.c = new q(this.c);
            this.g = true;
        }
        return this;
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        q qVar = this.c;
        if (qVar.c == null || qVar.d == null) {
            return false;
        }
        this.e = a(qVar.c, qVar.d);
        invalidateSelf();
        return true;
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else if (this.c.b.e != i) {
            this.c.b.e = i;
            invalidateSelf();
        }
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        if (this.a != null) {
            this.a.setBounds(i, i2, i3, i4);
        } else {
            super.setBounds(i, i2, i3, i4);
        }
    }

    public final void setBounds(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            super.setBounds(rect);
        }
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.f = colorFilter;
        invalidateSelf();
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public final void setTint(int i) {
        if (this.a != null) {
            a.a(this.a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            a.a(this.a, colorStateList);
            return;
        }
        q qVar = this.c;
        if (qVar.c != colorStateList) {
            qVar.c = colorStateList;
            this.e = a(colorStateList, qVar.d);
            invalidateSelf();
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.a != null) {
            a.a(this.a, mode);
            return;
        }
        q qVar = this.c;
        if (qVar.d != mode) {
            qVar.d = mode;
            this.e = a(qVar.c, mode);
            invalidateSelf();
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        return this.a != null ? this.a.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
