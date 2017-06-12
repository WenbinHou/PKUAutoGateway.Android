package android.support.v7.a;

import android.content.Context;
import android.view.Window;
import android.view.Window.Callback;

final class aa extends y {
    aa(Context context, Window window, t tVar) {
        super(context, window, tVar);
    }

    final Callback a(Callback callback) {
        return new ab(this, callback);
    }
}
