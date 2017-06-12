package android.support.v7.widget;

import android.support.v7.view.b;
import android.view.View;
import android.view.View.OnClickListener;

final class e implements OnClickListener {
    final /* synthetic */ b a;
    final /* synthetic */ ActionBarContextView b;

    e(ActionBarContextView actionBarContextView, b bVar) {
        this.b = actionBarContextView;
        this.a = bVar;
    }

    public final void onClick(View view) {
        this.a.c();
    }
}
