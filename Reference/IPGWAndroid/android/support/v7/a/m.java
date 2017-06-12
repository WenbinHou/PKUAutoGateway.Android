package android.support.v7.a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class m implements OnItemClickListener {
    final /* synthetic */ d a;
    final /* synthetic */ j b;

    m(j jVar, d dVar) {
        this.b = jVar;
        this.a = dVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.b.u.onClick(this.a.b, i);
        if (!this.b.E) {
            this.a.b.dismiss();
        }
    }
}
