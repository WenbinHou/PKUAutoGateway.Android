package ccnet.pku.edu.cn.ipgw_android;

import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.ArrayList;

final class dt implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ dn b;

    dt(dn dnVar, String str) {
        this.b = dnVar;
        this.a = str;
    }

    public final void run() {
        String str = this.a;
        if (this.a.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }
        this.b.c.ah = new ArrayList();
        String[] split = str.split(";");
        if (split.length % 4 == 0) {
            int length = split.length / 4;
            for (int i = 0; i < length; i++) {
                this.b.c.ah.add(new fj(split[i * 4], split[(i * 4) + 1], split[(i * 4) + 2], split[(i * 4) + 3]));
            }
        }
        this.b.c.a(new SimpleAdapter(this.b.c.b(), dj.a(this.b.c.ah), R.layout.layout_msg_listitem, new String[]{"title", "subtitle"}, new int[]{R.id.msg_title, R.id.msg_subtitle}));
        TextView textView = (TextView) this.b.c.b().getWindow().getDecorView().findViewById(R.id.badge_textView);
        by.a.b(this.b.c.ah);
        textView.setText("");
        textView.setVisibility(4);
    }
}
