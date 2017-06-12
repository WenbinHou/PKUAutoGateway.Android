package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

final class dc implements Comparator<View> {
    dc() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        cv cvVar = (cv) ((View) obj).getLayoutParams();
        cv cvVar2 = (cv) ((View) obj2).getLayoutParams();
        return cvVar.a != cvVar2.a ? cvVar.a ? 1 : -1 : cvVar.e - cvVar2.e;
    }
}
