package com.google.android.gms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class dq implements OnClickListener {
    final /* synthetic */ do a;

    dq(do doVar) {
        this.a = doVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a("Operation denied by user.");
    }
}
