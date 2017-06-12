package android.support.v7.widget;

import android.database.Observable;

public final class du extends Observable<dv> {
    du() {
    }

    public final void a() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((dv) this.mObservers.get(size)).a();
        }
    }

    public final void a(int i) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((dv) this.mObservers.get(size)).a(i);
        }
    }
}
