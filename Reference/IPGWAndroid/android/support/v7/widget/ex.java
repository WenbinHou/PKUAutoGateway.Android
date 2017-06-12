package android.support.v7.widget;

import android.support.v7.a.c;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

final class ex extends BaseAdapter {
    final /* synthetic */ ev a;

    private ex(ev evVar) {
        this.a = evVar;
    }

    public final int getCount() {
        return this.a.d.getChildCount();
    }

    public final Object getItem(int i) {
        return ((ey) this.a.d.getChildAt(i)).a;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return ev.a(this.a, (c) getItem(i));
        }
        ey eyVar = (ey) view;
        eyVar.a = (c) getItem(i);
        eyVar.a();
        return view;
    }
}
