package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

class h implements i {
    h() {
    }

    public Drawable a(CompoundButton compoundButton) {
        return k.a(compoundButton);
    }

    public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof bl) {
            ((bl) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public void a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof bl) {
            ((bl) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
