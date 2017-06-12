package android.support.design.widget;

import android.support.v4.view.bq;
import android.view.View;
import java.util.Comparator;

final class t implements Comparator<View> {
    t() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        View view = (View) obj2;
        float G = bq.G((View) obj);
        float G2 = bq.G(view);
        return G > G2 ? -1 : G < G2 ? 1 : 0;
    }
}
