package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a;
import android.support.v4.view.bl;
import android.support.v7.b.b;
import android.support.v7.b.i;
import android.support.v7.b.l;
import android.support.v7.view.e;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public final class bf extends Spinner implements bl {
    private static final boolean a = (VERSION.SDK_INT >= 23);
    private static final boolean b = (VERSION.SDK_INT >= 16);
    private static final int[] c = new int[]{16843505};
    private ao d;
    private aj e;
    private Context f;
    private cy g;
    private SpinnerAdapter h;
    private boolean i;
    private bi j;
    private int k;
    private final Rect l;

    public bf(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.spinnerStyle);
    }

    public bf(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private bf(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i, -1);
    }

    private bf(Context context, AttributeSet attributeSet, int i, int i2) {
        Context eVar;
        bf bfVar;
        Throwable e;
        bi biVar;
        ft a;
        CharSequence[] textArray;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.l = new Rect();
        ft a2 = ft.a(context, attributeSet, l.Spinner, i);
        this.d = ao.a();
        this.e = new aj(this, this.d);
        int e2 = a2.e(l.Spinner_popupTheme, 0);
        if (e2 != 0) {
            eVar = new e(context, e2);
            bfVar = this;
        } else if (a) {
            eVar = null;
            bfVar = this;
        } else {
            eVar = context;
            bfVar = this;
        }
        bfVar.f = eVar;
        if (this.f != null) {
            if (VERSION.SDK_INT >= 11) {
                TypedArray obtainStyledAttributes;
                try {
                    obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c, i, 0);
                    try {
                        if (obtainStyledAttributes.hasValue(0)) {
                            i2 = obtainStyledAttributes.getInt(0, 0);
                        }
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                            if (i2 == 1) {
                                biVar = new bi(this, this.f, attributeSet, i);
                                a = ft.a(this.f, attributeSet, l.Spinner, i);
                                this.k = a.d(l.Spinner_android_dropDownWidth, -2);
                                biVar.a(a.a(l.Spinner_android_popupBackground));
                                biVar.a = a2.a.getString(l.Spinner_android_prompt);
                                a.a.recycle();
                                this.j = biVar;
                                this.g = new bg(this, this, biVar);
                            }
                            textArray = a2.a.getTextArray(l.Spinner_android_entries);
                            if (textArray != null) {
                                arrayAdapter = new ArrayAdapter(context, i.support_simple_spinner_dropdown_item, textArray);
                                arrayAdapter.setDropDownViewResource(i.support_simple_spinner_dropdown_item);
                                setAdapter(arrayAdapter);
                            }
                            a2.a.recycle();
                            this.i = true;
                            if (this.h != null) {
                                setAdapter(this.h);
                                this.h = null;
                            }
                            this.e.a(attributeSet, i);
                        } catch (Throwable th) {
                            e = th;
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                            throw e;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    obtainStyledAttributes = null;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    if (i2 == 1) {
                        biVar = new bi(this, this.f, attributeSet, i);
                        a = ft.a(this.f, attributeSet, l.Spinner, i);
                        this.k = a.d(l.Spinner_android_dropDownWidth, -2);
                        biVar.a(a.a(l.Spinner_android_popupBackground));
                        biVar.a = a2.a.getString(l.Spinner_android_prompt);
                        a.a.recycle();
                        this.j = biVar;
                        this.g = new bg(this, this, biVar);
                    }
                    textArray = a2.a.getTextArray(l.Spinner_android_entries);
                    if (textArray != null) {
                        arrayAdapter = new ArrayAdapter(context, i.support_simple_spinner_dropdown_item, textArray);
                        arrayAdapter.setDropDownViewResource(i.support_simple_spinner_dropdown_item);
                        setAdapter(arrayAdapter);
                    }
                    a2.a.recycle();
                    this.i = true;
                    if (this.h != null) {
                        setAdapter(this.h);
                        this.h = null;
                    }
                    this.e.a(attributeSet, i);
                } catch (Throwable th2) {
                    e = th2;
                    obtainStyledAttributes = null;
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    throw e;
                }
            }
            i2 = 1;
            if (i2 == 1) {
                biVar = new bi(this, this.f, attributeSet, i);
                a = ft.a(this.f, attributeSet, l.Spinner, i);
                this.k = a.d(l.Spinner_android_dropDownWidth, -2);
                biVar.a(a.a(l.Spinner_android_popupBackground));
                biVar.a = a2.a.getString(l.Spinner_android_prompt);
                a.a.recycle();
                this.j = biVar;
                this.g = new bg(this, this, biVar);
            }
        }
        textArray = a2.a.getTextArray(l.Spinner_android_entries);
        if (textArray != null) {
            arrayAdapter = new ArrayAdapter(context, i.support_simple_spinner_dropdown_item, textArray);
            arrayAdapter.setDropDownViewResource(i.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.a.recycle();
        this.i = true;
        if (this.h != null) {
            setAdapter(this.h);
            this.h = null;
        }
        this.e.a(attributeSet, i);
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.l);
        return (this.l.left + this.l.right) + i;
    }

    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e != null) {
            this.e.c();
        }
    }

    public final int getDropDownHorizontalOffset() {
        return this.j != null ? this.j.f : b ? super.getDropDownHorizontalOffset() : 0;
    }

    public final int getDropDownVerticalOffset() {
        if (this.j == null) {
            return b ? super.getDropDownVerticalOffset() : 0;
        } else {
            cu cuVar = this.j;
            return !cuVar.h ? 0 : cuVar.g;
        }
    }

    public final int getDropDownWidth() {
        return this.j != null ? this.k : b ? super.getDropDownWidth() : 0;
    }

    public final Drawable getPopupBackground() {
        return this.j != null ? this.j.c.getBackground() : b ? super.getPopupBackground() : null;
    }

    public final Context getPopupContext() {
        return this.j != null ? this.f : a ? super.getPopupContext() : null;
    }

    public final CharSequence getPrompt() {
        return this.j != null ? this.j.a : super.getPrompt();
    }

    public final ColorStateList getSupportBackgroundTintList() {
        return this.e != null ? this.e.a() : null;
    }

    public final Mode getSupportBackgroundTintMode() {
        return this.e != null ? this.e.b() : null;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null && this.j.c.isShowing()) {
            this.j.d();
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.j != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.g == null || !this.g.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public final boolean performClick() {
        if (this.j == null || this.j.c.isShowing()) {
            return super.performClick();
        }
        this.j.b();
        return true;
    }

    public final void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.i) {
            super.setAdapter(spinnerAdapter);
            if (this.j != null) {
                this.j.a(new bh(spinnerAdapter, (this.f == null ? getContext() : this.f).getTheme()));
                return;
            }
            return;
        }
        this.h = spinnerAdapter;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.e != null) {
            this.e.b(null);
        }
    }

    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public final void setDropDownHorizontalOffset(int i) {
        if (this.j != null) {
            this.j.f = i;
        } else if (b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public final void setDropDownVerticalOffset(int i) {
        if (this.j != null) {
            cu cuVar = this.j;
            cuVar.g = i;
            cuVar.h = true;
        } else if (b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public final void setDropDownWidth(int i) {
        if (this.j != null) {
            this.k = i;
        } else if (b) {
            super.setDropDownWidth(i);
        }
    }

    public final void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.j != null) {
            this.j.a(drawable);
        } else if (b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public final void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(a.a(getPopupContext(), i));
    }

    public final void setPrompt(CharSequence charSequence) {
        if (this.j != null) {
            this.j.a = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.e != null) {
            this.e.a(colorStateList);
        }
    }

    public final void setSupportBackgroundTintMode(Mode mode) {
        if (this.e != null) {
            this.e.a(mode);
        }
    }
}
