package android.support.a.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class e extends ConstantState {
    private final ConstantState a;

    public e(ConstantState constantState) {
        this.a = constantState;
    }

    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public final int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public final Drawable newDrawable() {
        b bVar = new b();
        bVar.a = this.a.newDrawable();
        bVar.a.setCallback(bVar.e);
        return bVar;
    }

    public final Drawable newDrawable(Resources resources) {
        b bVar = new b();
        bVar.a = this.a.newDrawable(resources);
        bVar.a.setCallback(bVar.e);
        return bVar;
    }

    public final Drawable newDrawable(Resources resources, Theme theme) {
        b bVar = new b();
        bVar.a = this.a.newDrawable(resources, theme);
        bVar.a.setCallback(bVar.e);
        return bVar;
    }
}
