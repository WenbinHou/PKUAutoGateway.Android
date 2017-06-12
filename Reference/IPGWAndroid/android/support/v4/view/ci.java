package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ci implements OnApplyWindowInsetsListener {
    final /* synthetic */ bi a;

    ci(bi biVar) {
        this.a = biVar;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((ee) this.a.a(view, new ee(windowInsets))).a;
    }
}
