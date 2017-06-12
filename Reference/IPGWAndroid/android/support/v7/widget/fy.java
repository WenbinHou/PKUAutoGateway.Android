package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.b;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class fy extends b {
    int b;

    public fy() {
        this.b = 0;
        this.a = 8388627;
    }

    public fy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
    }

    public fy(b bVar) {
        super(bVar);
        this.b = 0;
    }

    public fy(fy fyVar) {
        super((b) fyVar);
        this.b = 0;
        this.b = fyVar.b;
    }

    public fy(LayoutParams layoutParams) {
        super(layoutParams);
        this.b = 0;
    }

    public fy(MarginLayoutParams marginLayoutParams) {
        super((LayoutParams) marginLayoutParams);
        this.b = 0;
        this.leftMargin = marginLayoutParams.leftMargin;
        this.topMargin = marginLayoutParams.topMargin;
        this.rightMargin = marginLayoutParams.rightMargin;
        this.bottomMargin = marginLayoutParams.bottomMargin;
    }
}
