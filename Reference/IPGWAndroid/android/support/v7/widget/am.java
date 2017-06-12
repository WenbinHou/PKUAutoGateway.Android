package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

public final class am extends CheckedTextView {
    private static final int[] a = new int[]{16843016};
    private ao b;
    private bm c;

    public am(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private am(Context context, AttributeSet attributeSet, byte b) {
        super(fq.a(context), attributeSet, 16843720);
        this.c = bm.a((TextView) this);
        this.c.a(attributeSet, 16843720);
        this.c.a();
        this.b = ao.a();
        ft a = ft.a(getContext(), attributeSet, a, 16843720);
        setCheckMarkDrawable(a.a(0));
        a.a.recycle();
    }

    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.c != null) {
            this.c.a();
        }
    }

    public final void setCheckMarkDrawable(int i) {
        if (this.b != null) {
            setCheckMarkDrawable(this.b.a(getContext(), i, false));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }
}
