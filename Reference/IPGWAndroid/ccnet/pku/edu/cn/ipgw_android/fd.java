package ccnet.pku.edu.cn.ipgw_android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class fd implements OnClickListener {
    final /* synthetic */ fb a;

    fd(fb fbVar) {
        this.a = fbVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.b.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://its.pku.edu.cn/pku_gateway_apps/" + this.a.a)));
    }
}
