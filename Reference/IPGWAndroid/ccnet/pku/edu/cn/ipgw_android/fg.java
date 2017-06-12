package ccnet.pku.edu.cn.ipgw_android;

import android.widget.TextView;
import java.util.ArrayList;

final class fg implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ff b;

    fg(ff ffVar, String str) {
        this.b = ffVar;
        this.a = str;
    }

    public final void run() {
        int i;
        int i2 = 20;
        String str = this.a;
        if (this.a.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(";");
        if (split.length % 4 == 0) {
            int length = split.length / 4;
            for (i = 0; i < length; i++) {
                arrayList.add(new fj(split[i * 4], split[(i * 4) + 1], split[(i * 4) + 2], split[(i * 4) + 3]));
            }
        }
        i = by.a.a(arrayList);
        if (i <= 20) {
            i2 = i;
        }
        TextView textView = (TextView) this.b.b.findViewById(R.id.badge_textView);
        if (i2 > 0) {
            textView.setText(String.valueOf(i2));
            textView.setVisibility(0);
            return;
        }
        textView.setText("");
        textView.setVisibility(4);
    }
}
