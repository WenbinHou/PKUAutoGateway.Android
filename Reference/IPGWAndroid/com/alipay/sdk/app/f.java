package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class f implements OnClickListener {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.b.c = true;
        this.a.a.proceed();
        dialogInterface.dismiss();
    }
}
