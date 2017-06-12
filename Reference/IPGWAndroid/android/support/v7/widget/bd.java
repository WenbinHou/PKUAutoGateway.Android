package android.support.v7.widget;

import android.content.Context;
import android.support.v7.b.b;
import android.util.AttributeSet;
import android.widget.SeekBar;

public final class bd extends SeekBar {
    private be a;
    private ao b;

    public bd(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.seekBarStyle);
    }

    private bd(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = ao.a();
        this.a = new be(this, this.b);
        this.a.a(attributeSet, i);
    }
}
