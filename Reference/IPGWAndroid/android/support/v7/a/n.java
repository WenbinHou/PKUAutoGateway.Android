package android.support.v7.a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

final class n implements OnItemClickListener {
    final /* synthetic */ ListView a;
    final /* synthetic */ d b;
    final /* synthetic */ j c;

    n(j jVar, ListView listView, d dVar) {
        this.c = jVar;
        this.a = listView;
        this.b = dVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.c.C != null) {
            this.c.C[i] = this.a.isItemChecked(i);
        }
        this.c.G.onClick(this.b.b, i, this.a.isItemChecked(i));
    }
}
