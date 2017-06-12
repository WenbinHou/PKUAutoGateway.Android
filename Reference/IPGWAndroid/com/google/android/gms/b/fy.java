package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.WebChromeClient;

@TargetApi(14)
public class fy extends fw {
    public final WebChromeClient a(gv gvVar) {
        return new hr(gvVar);
    }

    public final String a(SslError sslError) {
        return sslError.getUrl();
    }
}
