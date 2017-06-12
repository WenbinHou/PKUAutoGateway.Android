package ccnet.pku.edu.cn.ipgw_android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bf implements OnClickListener {
    final /* synthetic */ be a;

    bf(be beVar) {
        this.a = beVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.b.c.finish();
    }
}
