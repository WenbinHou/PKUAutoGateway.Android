package ccnet.pku.edu.cn.ipgw_android;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class eb implements OnClickListener {
    final /* synthetic */ dw a;

    eb(dw dwVar) {
        this.a = dwVar;
    }

    public final void onClick(View view) {
        this.a.a(new Intent(this.a.b(), Activity_ResetPasswd.class));
    }
}
