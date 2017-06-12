package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class be extends ba {
    private static final int[] c = new int[]{16843074};
    private final SeekBar d;

    be(SeekBar seekBar, ao aoVar) {
        super(seekBar, aoVar);
        this.d = seekBar;
    }

    final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ft a = ft.a(this.d.getContext(), attributeSet, c, i);
        Drawable b = a.b(0);
        if (b != null) {
            this.d.setThumb(b);
        }
        a.a.recycle();
    }
}
