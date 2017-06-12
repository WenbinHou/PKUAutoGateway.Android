package android.support.v7.view;

import android.support.v4.view.eb;
import android.view.View;

final class m extends eb {
    final /* synthetic */ l a;
    private boolean b = false;
    private int c = 0;

    m(l lVar) {
        this.a = lVar;
    }

    public final void a(View view) {
        if (!this.b) {
            this.b = true;
            if (this.a.b != null) {
                this.a.b.a(null);
            }
        }
    }

    public final void b(View view) {
        int i = this.c + 1;
        this.c = i;
        if (i == this.a.a.size()) {
            if (this.a.b != null) {
                this.a.b.b(null);
            }
            this.c = 0;
            this.b = false;
            this.a.c = false;
        }
    }
}
