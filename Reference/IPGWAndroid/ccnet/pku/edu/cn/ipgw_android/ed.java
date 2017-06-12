package ccnet.pku.edu.cn.ipgw_android;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

final class ed implements OnClickListener {
    final /* synthetic */ dw a;

    ed(dw dwVar) {
        this.a = dwVar;
    }

    public final void onClick(View view) {
        this.a.a(new Intent("android.intent.action.VIEW", Uri.parse("https://its.pku.edu.cn")));
    }
}
