package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class cw implements OnItemSelectedListener {
    final /* synthetic */ cu a;

    cw(cu cuVar) {
        this.a = cuVar;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != -1) {
            cx a = this.a.d;
            if (a != null) {
                a.h = false;
            }
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
