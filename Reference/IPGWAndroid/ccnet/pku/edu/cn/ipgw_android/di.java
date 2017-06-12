package ccnet.pku.edu.cn.ipgw_android;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;

final class di implements OnFocusChangeListener {
    final /* synthetic */ bz a;

    di(bz bzVar) {
        this.a = bzVar;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            ((InputMethodManager) this.a.b().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.b().getWindow().getDecorView().getRootView().getWindowToken(), 0);
        }
    }
}
