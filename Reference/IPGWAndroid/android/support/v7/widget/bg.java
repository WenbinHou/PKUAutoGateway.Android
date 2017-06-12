package android.support.v7.widget;

import android.view.View;

final class bg extends cy {
    final /* synthetic */ bi a;
    final /* synthetic */ bf b;

    bg(bf bfVar, View view, bi biVar) {
        this.b = bfVar;
        this.a = biVar;
        super(view);
    }

    public final cu a() {
        return this.a;
    }

    public final boolean b() {
        if (!this.b.j.c.isShowing()) {
            this.b.j.b();
        }
        return true;
    }
}
