package ccnet.pku.edu.cn.ipgw_android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ai implements OnClickListener {
    final /* synthetic */ ah a;

    ai(ah ahVar) {
        this.a = ahVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.a.finish();
    }
}
