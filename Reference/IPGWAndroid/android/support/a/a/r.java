package android.support.a.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;

final class r extends ConstantState {
    private final ConstantState a;

    public r(ConstantState constantState) {
        this.a = constantState;
    }

    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public final int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public final Drawable newDrawable() {
        Drawable kVar = new k();
        kVar.a = (VectorDrawable) this.a.newDrawable();
        return kVar;
    }

    public final Drawable newDrawable(Resources resources) {
        Drawable kVar = new k();
        kVar.a = (VectorDrawable) this.a.newDrawable(resources);
        return kVar;
    }

    public final Drawable newDrawable(Resources resources, Theme theme) {
        Drawable kVar = new k();
        kVar.a = (VectorDrawable) this.a.newDrawable(resources, theme);
        return kVar;
    }
}
