package android.support.v7.widget;

import android.support.v7.view.menu.a;
import android.view.View;
import android.view.View.OnClickListener;

final class gc implements OnClickListener {
    final a a = new a(this.b.a.getContext(), this.b.b);
    final /* synthetic */ gb b;

    gc(gb gbVar) {
        this.b = gbVar;
    }

    public final void onClick(View view) {
        if (this.b.c != null && this.b.d) {
            this.b.c.onMenuItemSelected(0, this.a);
        }
    }
}
