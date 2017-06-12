package ccnet.pku.edu.cn.ipgw_android;

import android.support.v4.view.cy;
import android.widget.TextView;

final class fe implements cy {
    final /* synthetic */ MainActivity a;

    fe(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public final void a(int i) {
    }

    public final void a(int i, float f) {
    }

    public final void b(int i) {
        fn.b = i;
        if (i == 1) {
            TextView textView = (TextView) this.a.findViewById(R.id.badge_textView);
            textView.setText("");
            textView.setVisibility(4);
        }
    }
}
