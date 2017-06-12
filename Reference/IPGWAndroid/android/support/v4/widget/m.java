package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

final class m extends ContentObserver {
    final /* synthetic */ l a;

    public m(l lVar) {
        this.a = lVar;
        super(new Handler());
    }

    public final boolean deliverSelfNotifications() {
        return true;
    }

    public final void onChange(boolean z) {
        this.a.b();
    }
}
