package com.alipay.android.a.a.a;

import java.io.IOException;
import java.net.SocketException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class h implements HttpRequestRetryHandler {
    static final String a = h.class.getSimpleName();

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        return i >= 3 ? false : iOException instanceof NoHttpResponseException ? true : ((iOException instanceof SocketException) || (iOException instanceof SSLException)) && iOException.getMessage() != null && iOException.getMessage().contains("Broken pipe");
    }
}
