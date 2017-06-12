package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ay;
import android.support.v4.view.bq;
import android.support.v7.b.b;
import android.support.v7.b.l;
import android.support.v7.e.a;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
    private static final int[] F = new int[]{16842912};
    private Layout A;
    private TransformationMethod B;
    private fo C;
    private final Rect D;
    private final ao E;
    private Drawable a;
    private Drawable b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private CharSequence g;
    private CharSequence h;
    private boolean i;
    private int j;
    private int k;
    private float l;
    private float m;
    private VelocityTracker n;
    private int o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private TextPaint x;
    private ColorStateList y;
    private Layout z;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = VelocityTracker.obtain();
        this.D = new Rect();
        this.x = new TextPaint(1);
        this.x.density = getResources().getDisplayMetrics().density;
        ft a = ft.a(context, attributeSet, l.SwitchCompat, i);
        this.a = a.a(l.SwitchCompat_android_thumb);
        if (this.a != null) {
            this.a.setCallback(this);
        }
        this.b = a.a(l.SwitchCompat_track);
        if (this.b != null) {
            this.b.setCallback(this);
        }
        this.g = a.c(l.SwitchCompat_android_textOn);
        this.h = a.c(l.SwitchCompat_android_textOff);
        this.i = a.a(l.SwitchCompat_showText, true);
        this.c = a.c(l.SwitchCompat_thumbTextPadding, 0);
        this.d = a.c(l.SwitchCompat_switchMinWidth, 0);
        this.e = a.c(l.SwitchCompat_switchPadding, 0);
        this.f = a.a(l.SwitchCompat_splitTrack, false);
        int e = a.e(l.SwitchCompat_switchTextAppearance, 0);
        if (e != 0) {
            Typeface typeface;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e, l.TextAppearance);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(l.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.y = colorStateList;
            } else {
                this.y = getTextColors();
            }
            e = obtainStyledAttributes.getDimensionPixelSize(l.TextAppearance_android_textSize, 0);
            if (!(e == 0 || ((float) e) == this.x.getTextSize())) {
                this.x.setTextSize((float) e);
                requestLayout();
            }
            e = obtainStyledAttributes.getInt(l.TextAppearance_android_typeface, -1);
            int i2 = obtainStyledAttributes.getInt(l.TextAppearance_android_textStyle, -1);
            switch (e) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    typeface = null;
                    break;
            }
            if (i2 > 0) {
                typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                setSwitchTypeface(typeface);
                i2 &= (typeface != null ? typeface.getStyle() : 0) ^ -1;
                this.x.setFakeBoldText((i2 & 1) != 0);
                this.x.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                this.x.setFakeBoldText(false);
                this.x.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false)) {
                this.B = new a(getContext());
            } else {
                this.B = null;
            }
            obtainStyledAttributes.recycle();
        }
        this.E = ao.a();
        a.a.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.k = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private Layout a(CharSequence charSequence) {
        CharSequence transformation = this.B != null ? this.B.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.x, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.x)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void a() {
        if (this.C != null) {
            clearAnimation();
            this.C = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.p > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((gi.a(this) ? 1.0f - this.p : this.p) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.b == null) {
            return 0;
        }
        Rect rect = this.D;
        this.b.getPadding(rect);
        Rect a = this.a != null ? ch.a(this.a) : ch.a;
        return ((((this.q - this.s) - rect.left) - rect.right) - a.left) - a.right;
    }

    private void setThumbPosition(float f) {
        this.p = f;
        invalidate();
    }

    public void draw(Canvas canvas) {
        int i;
        Rect rect = this.D;
        int i2 = this.t;
        int i3 = this.u;
        int i4 = this.v;
        int i5 = this.w;
        int thumbOffset = i2 + getThumbOffset();
        Rect a = this.a != null ? ch.a(this.a) : ch.a;
        if (this.b != null) {
            this.b.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (a != null) {
                if (a.left > rect.left) {
                    i2 += a.left - rect.left;
                }
                thumbOffset = a.top > rect.top ? (a.top - rect.top) + i3 : i3;
                if (a.right > rect.right) {
                    i4 -= a.right - rect.right;
                }
                i = a.bottom > rect.bottom ? i5 - (a.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.b.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.a != null) {
            this.a.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.s) + rect.right;
            this.a.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.c.a.a.a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.a != null) {
            android.support.v4.c.a.a.a(this.a, f, f2);
        }
        if (this.b != null) {
            android.support.v4.c.a.a.a(this.b, f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.a != null) {
            this.a.setState(drawableState);
        }
        if (this.b != null) {
            this.b.setState(drawableState);
        }
        invalidate();
    }

    public int getCompoundPaddingLeft() {
        if (!gi.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.e : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (gi.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.e : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.i;
    }

    public boolean getSplitTrack() {
        return this.f;
    }

    public int getSwitchMinWidth() {
        return this.d;
    }

    public int getSwitchPadding() {
        return this.e;
    }

    public CharSequence getTextOff() {
        return this.h;
    }

    public CharSequence getTextOn() {
        return this.g;
    }

    public Drawable getThumbDrawable() {
        return this.a;
    }

    public int getThumbTextPadding() {
        return this.c;
    }

    public Drawable getTrackDrawable() {
        return this.b;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.a != null) {
                this.a.jumpToCurrentState();
            }
            if (this.b != null) {
                this.b.jumpToCurrentState();
            }
            a();
            setThumbPosition(isChecked() ? 1.0f : 0.0f);
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, F);
        }
        return onCreateDrawableState;
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.D;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.u + rect.top;
        int i2 = this.w - rect.bottom;
        Drawable drawable2 = this.a;
        if (drawable != null) {
            if (!this.f || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = ch.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.z : this.A;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.y != null) {
                this.x.setColor(this.y.getColorForState(drawableState, 0));
            }
            this.x.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.g : this.h;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.a != null) {
            Rect rect = this.D;
            if (this.b != null) {
                this.b.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = ch.a(this.a);
            max = Math.max(0, a.left - rect.left);
            i5 = Math.max(0, a.right - rect.right);
        } else {
            max = 0;
        }
        if (gi.a(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.q + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.q);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.r / 2);
                paddingLeft = this.r + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.r;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.r + paddingTop;
                break;
        }
        this.t = i5;
        this.u = paddingTop;
        this.w = paddingLeft;
        this.v = max;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int i3 = 0;
        if (this.i) {
            if (this.z == null) {
                this.z = a(this.g);
            }
            if (this.A == null) {
                this.A = a(this.h);
            }
        }
        Rect rect = this.D;
        if (this.a != null) {
            this.a.getPadding(rect);
            intrinsicWidth = (this.a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.a.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        this.s = Math.max(this.i ? Math.max(this.z.getWidth(), this.A.getWidth()) + (this.c * 2) : 0, intrinsicWidth);
        if (this.b != null) {
            this.b.getPadding(rect);
            i3 = this.b.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        int i4 = rect.right;
        if (this.a != null) {
            rect = ch.a(this.a);
            intrinsicWidth = Math.max(intrinsicWidth, rect.left);
            i4 = Math.max(i4, rect.right);
        }
        intrinsicWidth = Math.max(this.d, (intrinsicWidth + (this.s * 2)) + i4);
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.q = intrinsicWidth;
        this.r = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(bq.i(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.g : this.h;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 1.0f;
        int i = 0;
        this.n.addMovement(motionEvent);
        float x;
        switch (ay.a(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                f = motionEvent.getY();
                if (isEnabled()) {
                    if (this.a != null) {
                        int thumbOffset = getThumbOffset();
                        this.a.getPadding(this.D);
                        int i2 = this.u - this.k;
                        thumbOffset = (thumbOffset + this.t) - this.k;
                        int i3 = (((this.s + thumbOffset) + this.D.left) + this.D.right) + this.k;
                        int i4 = this.w + this.k;
                        if (x > ((float) thumbOffset) && x < ((float) i3) && f > ((float) i2) && f < ((float) i4)) {
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        this.j = 1;
                        this.l = x;
                        this.m = f;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                if (this.j != 2) {
                    this.j = 0;
                    this.n.clear();
                    break;
                }
                this.j = 0;
                boolean z = motionEvent.getAction() == 1 && isEnabled();
                boolean isChecked = isChecked();
                if (z) {
                    this.n.computeCurrentVelocity(1000);
                    x = this.n.getXVelocity();
                    z = Math.abs(x) > ((float) this.o) ? gi.a(this) ? x < 0.0f : x > 0.0f : getTargetCheckedState();
                } else {
                    z = isChecked;
                }
                if (z != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.j) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        f = motionEvent.getY();
                        if (Math.abs(x - this.l) > ((float) this.k) || Math.abs(f - this.m) > ((float) this.k)) {
                            this.j = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.l = x;
                            this.m = f;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x2 - this.l;
                        x = thumbScrollRange != 0 ? f2 / ((float) thumbScrollRange) : f2 > 0.0f ? 1.0f : -1.0f;
                        if (gi.a(this)) {
                            x = -x;
                        }
                        x += this.p;
                        if (x < 0.0f) {
                            f = 0.0f;
                        } else if (x <= 1.0f) {
                            f = x;
                        }
                        if (f == this.p) {
                            return true;
                        }
                        this.l = x2;
                        setThumbPosition(f);
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z) {
        float f = 1.0f;
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && bq.F(this) && isShown()) {
            if (this.C != null) {
                a();
            }
            float f2 = this.p;
            if (!isChecked) {
                f = 0.0f;
            }
            this.C = new fo(this, f2, f);
            this.C.setDuration(250);
            this.C.setAnimationListener(new fn(this, isChecked));
            startAnimation(this.C);
            return;
        }
        a();
        if (!isChecked) {
            f = 0.0f;
        }
        setThumbPosition(f);
    }

    public void setShowText(boolean z) {
        if (this.i != z) {
            this.i = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.f = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.d = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.e = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.x.getTypeface() != typeface) {
            this.x.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.h = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.g = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        this.a = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.E.a(getContext(), i, false));
    }

    public void setThumbTextPadding(int i) {
        this.c = i;
        requestLayout();
    }

    public void setTrackDrawable(Drawable drawable) {
        this.b = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.E.a(getContext(), i, false));
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.a || drawable == this.b;
    }
}
