package com.google.android.gms.b;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class iw extends HttpEntityEnclosingRequestBase {
    public iw(String str) {
        setURI(URI.create(str));
    }

    public final String getMethod() {
        return "PATCH";
    }
}
