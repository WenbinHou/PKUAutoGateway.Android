package com.google.android.gms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.f;

final class ge implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ gd b;

    ge(gd gdVar, String str) {
        this.b = gdVar;
        this.a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.c();
        fs.a(this.b.a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.a), "Share via"));
    }
}
