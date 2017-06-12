package android.support.v7.a;

import android.support.v4.view.ec;
import android.view.View;

final class bc implements ec {
    final /* synthetic */ az a;

    bc(az azVar) {
        this.a = azVar;
    }

    public final void a() {
        ((View) this.a.q.getParent()).invalidate();
    }
}
