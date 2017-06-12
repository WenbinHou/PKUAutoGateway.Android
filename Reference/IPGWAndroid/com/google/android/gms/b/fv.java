package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;

@TargetApi(9)
public class fv extends fu {
    public fv() {
        super();
    }

    public final int a() {
        return 6;
    }

    public boolean a(Request request) {
        request.setShowRunningNotification(true);
        return true;
    }

    public final int b() {
        return 7;
    }
}
