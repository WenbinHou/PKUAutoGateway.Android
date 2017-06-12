package com.google.android.gms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import com.google.android.gms.ads.internal.f;

final class dp implements OnClickListener {
    final /* synthetic */ do a;

    dp(do doVar) {
        this.a = doVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        do doVar = this.a;
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", doVar.b);
        data.putExtra("eventLocation", doVar.f);
        data.putExtra("description", doVar.e);
        if (doVar.c > -1) {
            data.putExtra("beginTime", doVar.c);
        }
        if (doVar.d > -1) {
            data.putExtra("endTime", doVar.d);
        }
        data.setFlags(268435456);
        f.c();
        fs.a(this.a.a, data);
    }
}
