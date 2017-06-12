package com.google.android.gms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class dw implements OnClickListener {
    final /* synthetic */ du a;

    dw(du duVar) {
        this.a = duVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a("User canceled the download.");
    }
}
