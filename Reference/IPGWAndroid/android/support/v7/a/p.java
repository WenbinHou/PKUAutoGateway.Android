package android.support.v7.a;

import android.content.Context;
import android.widget.ArrayAdapter;

final class p extends ArrayAdapter<CharSequence> {
    public p(Context context, int i, CharSequence[] charSequenceArr) {
        super(context, i, 16908308, charSequenceArr);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean hasStableIds() {
        return true;
    }
}
