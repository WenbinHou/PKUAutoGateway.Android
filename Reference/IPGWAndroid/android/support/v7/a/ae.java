package android.support.v7.a;

import android.support.v4.view.bi;
import android.support.v4.view.bq;
import android.support.v4.view.ed;
import android.view.View;

final class ae implements bi {
    final /* synthetic */ ac a;

    ae(ac acVar) {
        this.a = acVar;
    }

    public final ed a(View view, ed edVar) {
        int b = edVar.b();
        int b2 = ac.b(this.a, b);
        if (b != b2) {
            edVar = edVar.a(edVar.a(), b2, edVar.c(), edVar.d());
        }
        return bq.a(view, edVar);
    }
}
