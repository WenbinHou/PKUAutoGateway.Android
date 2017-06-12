package com.alipay.android.a.a.a;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class o implements ConnectionKeepAliveStrategy {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000;
    }
}
