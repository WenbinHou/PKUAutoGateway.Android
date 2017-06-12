package com.google.android.gms.b;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.f;

final class dv implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ du c;

    dv(du duVar, String str, String str2) {
        this.c = duVar;
        this.a = str;
        this.b = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.c.b.getSystemService("download");
        try {
            String str = this.a;
            String str2 = this.b;
            Request request = new Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            f.e().a(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException e) {
            this.c.a("Could not store picture.");
        }
    }
}
