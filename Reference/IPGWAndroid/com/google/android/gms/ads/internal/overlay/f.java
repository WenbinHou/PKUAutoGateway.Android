package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.gd;

@fd
final class f extends RelativeLayout {
    gd a;

    public f(Context context, String str) {
        super(context);
        this.a = new gd(context, str);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        gd gdVar = this.a;
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            gdVar.a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        gdVar.a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
        return false;
    }
}
