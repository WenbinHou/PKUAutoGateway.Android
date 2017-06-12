package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.dk;
import android.support.v7.b.b;
import android.support.v7.b.g;
import android.support.v7.b.i;
import android.support.v7.b.l;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a {
    public View g;
    public boolean h;
    private CharSequence i;
    private CharSequence j;
    private View k;
    private LinearLayout l;
    private TextView m;
    private TextView n;
    private int o;
    private int p;
    private int q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ft a = ft.a(context, attributeSet, l.ActionMode, i);
        setBackgroundDrawable(a.a(l.ActionMode_background));
        this.o = a.e(l.ActionMode_titleTextStyle, 0);
        this.p = a.e(l.ActionMode_subtitleTextStyle, 0);
        this.e = a.d(l.ActionMode_height, 0);
        this.q = a.e(l.ActionMode_closeItemLayout, i.abc_action_mode_close_item_material);
        a.a.recycle();
    }

    private void c() {
        int i = 8;
        Object obj = 1;
        if (this.l == null) {
            LayoutInflater.from(getContext()).inflate(i.abc_action_bar_title_item, this);
            this.l = (LinearLayout) getChildAt(getChildCount() - 1);
            this.m = (TextView) this.l.findViewById(g.action_bar_title);
            this.n = (TextView) this.l.findViewById(g.action_bar_subtitle);
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
            if (this.p != 0) {
                this.n.setTextAppearance(getContext(), this.p);
            }
        }
        this.m.setText(this.i);
        this.n.setText(this.j);
        Object obj2 = !TextUtils.isEmpty(this.i) ? 1 : null;
        if (TextUtils.isEmpty(this.j)) {
            obj = null;
        }
        this.n.setVisibility(obj != null ? 0 : 8);
        LinearLayout linearLayout = this.l;
        if (!(obj2 == null && obj == null)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.l.getParent() == null) {
            addView(this.l);
        }
    }

    public final /* bridge */ /* synthetic */ dk a(int i, long j) {
        return super.a(i, j);
    }

    public final void a(android.support.v7.view.b bVar) {
        if (this.g == null) {
            this.g = LayoutInflater.from(getContext()).inflate(this.q, this, false);
            addView(this.g);
        } else if (this.g.getParent() == null) {
            addView(this.g);
        }
        this.g.findViewById(g.action_mode_close_button).setOnClickListener(new e(this, bVar));
        android.support.v7.view.menu.i iVar = (android.support.v7.view.menu.i) bVar.b();
        if (this.d != null) {
            this.d.e();
        }
        this.d = new k(getContext());
        this.d.b();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        iVar.a(this.d, this.b);
        this.c = (ActionMenuView) this.d.a((ViewGroup) this);
        this.c.setBackgroundDrawable(null);
        addView(this.c, layoutParams);
    }

    public final boolean a() {
        return this.d != null ? this.d.c() : false;
    }

    public final void b() {
        removeAllViews();
        this.k = null;
        this.c = null;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.i;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.d();
            this.d.f();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = gi.a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.g == null || this.g.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.g.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = a.a(paddingRight, i6, a);
            paddingRight = a.a(paddingRight + a.a(this.g, paddingRight, paddingTop, paddingTop2, a), i5, a);
        }
        if (!(this.l == null || this.k != null || this.l.getVisibility() == 8)) {
            paddingRight += a.a(this.l, paddingRight, paddingTop, paddingTop2, a);
        }
        if (this.k != null) {
            a.a(this.k, paddingRight, paddingTop, paddingTop2, a);
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a.a(this.c, i5, paddingTop, paddingTop2, !a);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.g != null) {
                a = a.a(this.g, paddingLeft, makeMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.g.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = a.a(this.c, paddingLeft, makeMeasureSpec);
            }
            if (this.l != null && this.k == null) {
                if (this.h) {
                    this.l.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.l.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.l.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a.a(this.l, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.k != null) {
                LayoutParams layoutParams = this.k.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.k.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.k != null) {
            removeView(this.k);
        }
        this.k = view;
        if (!(view == null || this.l == null)) {
            removeView(this.l);
            this.l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.j = charSequence;
        c();
    }

    public void setTitle(CharSequence charSequence) {
        this.i = charSequence;
        c();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.h) {
            requestLayout();
        }
        this.h = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
