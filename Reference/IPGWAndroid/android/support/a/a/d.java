package android.support.a.a;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.g.a;
import java.util.ArrayList;

final class d extends ConstantState {
    int a;
    k b;
    ArrayList<Animator> c;
    a<Animator, String> d;

    public final int getChangingConfigurations() {
        return this.a;
    }

    public final Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 21.");
    }

    public final Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 21.");
    }
}
