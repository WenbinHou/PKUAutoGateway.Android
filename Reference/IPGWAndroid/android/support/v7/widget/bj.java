package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class bj implements OnItemClickListener {
    final /* synthetic */ bf a;
    final /* synthetic */ bi b;

    bj(bi biVar, bf bfVar) {
        this.b = biVar;
        this.a = bfVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.b.b.setSelection(i);
        if (this.b.b.getOnItemClickListener() != null) {
            this.b.b.performItemClick(view, i, this.b.n.getItemId(i));
        }
        this.b.d();
    }
}
