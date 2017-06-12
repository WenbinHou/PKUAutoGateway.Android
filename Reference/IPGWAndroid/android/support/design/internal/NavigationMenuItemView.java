package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.c;
import android.support.design.d;
import android.support.design.e;
import android.support.design.f;
import android.support.v4.c.a.a;
import android.support.v4.widget.bd;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends a implements aa {
    private static final int[] c = new int[]{16842912};
    private final int d;
    private final CheckedTextView e;
    private FrameLayout f;
    private m g;
    private ColorStateList h;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(f.design_navigation_menu_item, this, true);
        this.d = context.getResources().getDimensionPixelSize(d.design_navigation_icon_size);
        this.e = (CheckedTextView) findViewById(e.design_menu_item_text);
        this.e.setDuplicateParentStateEnabled(true);
    }

    private void setActionView(View view) {
        if (this.f == null) {
            this.f = (FrameLayout) ((ViewStub) findViewById(e.design_menu_item_action_area_stub)).inflate();
        }
        this.f.removeAllViews();
        if (view != null) {
            this.f.addView(view);
        }
    }

    public final void a(m mVar) {
        this.g = mVar;
        setVisibility(mVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            Drawable stateListDrawable;
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(c.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(c, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackgroundDrawable(stateListDrawable);
        }
        setCheckable(mVar.isCheckable());
        setChecked(mVar.isChecked());
        setEnabled(mVar.isEnabled());
        setTitle(mVar.getTitle());
        setIcon(mVar.getIcon());
        setActionView(mVar.getActionView());
    }

    public final boolean a() {
        return false;
    }

    public m getItemData() {
        return this.g;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.g != null && this.g.isCheckable() && this.g.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, c);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.e.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = a.f(drawable).mutate();
            drawable.setBounds(0, 0, this.d, this.d);
            a.a(drawable, this.h);
        }
        bd.a(this.e, drawable);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        if (this.g != null) {
            setIcon(this.g.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.e.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.e.setText(charSequence);
    }
}
