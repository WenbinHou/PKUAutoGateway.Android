package android.support.v4.app;

import android.view.View;

final class o extends u {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final View a(int i) {
        if (this.a.I != null) {
            return this.a.I.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public final boolean a() {
        return this.a.I != null;
    }
}
