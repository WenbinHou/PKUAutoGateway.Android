package com.alipay.android.a.a.a;

import android.util.Log;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

final class j implements HttpRequestInterceptor {
    final /* synthetic */ i a;

    private j(i iVar) {
        this.a = iVar;
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        k a = this.a.f;
        if (a != null && Log.isLoggable(a.a, a.b) && (httpRequest instanceof HttpUriRequest)) {
            Log.println(a.b, a.a, i.a((HttpUriRequest) httpRequest));
        }
    }
}
