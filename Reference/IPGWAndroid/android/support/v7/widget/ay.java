package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.af;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public final class ay extends PopupWindow {
    private static final boolean a = (VERSION.SDK_INT < 21);
    private boolean b;

    public ay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ft a = ft.a(context, attributeSet, l.PopupWindow, i);
        if (a.e(l.PopupWindow_overlapAnchor)) {
            boolean a2 = a.a(l.PopupWindow_overlapAnchor, false);
            if (a) {
                this.b = a2;
            } else {
                af.a((PopupWindow) this, a2);
            }
        }
        setBackgroundDrawable(a.a(l.PopupWindow_android_popupBackground));
        a.a.recycle();
        if (VERSION.SDK_INT < 14) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
                declaredField.setAccessible(true);
                Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
                declaredField2.setAccessible(true);
                declaredField2.set(this, new az(declaredField, this, (OnScrollChangedListener) declaredField2.get(this)));
            } catch (Throwable e) {
                Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
            }
        }
    }

    public final void showAsDropDown(View view, int i, int i2) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public final void showAsDropDown(View view, int i, int i2, int i3) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public final void update(View view, int i, int i2, int i3, int i4) {
        int height = (a && this.b) ? i2 - view.getHeight() : i2;
        super.update(view, i, height, i3, i4);
    }
}
