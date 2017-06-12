package com.google.android.gms.b;

import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class iv implements iy {
    protected final HttpClient a;

    public iv(HttpClient httpClient) {
        this.a = httpClient;
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    public final HttpResponse a(hs<?> hsVar, Map<String, String> map) {
        HttpUriRequest httpGet;
        switch (hsVar.c) {
            case -1:
                httpGet = new HttpGet(hsVar.d);
                break;
            case 0:
                httpGet = new HttpGet(hsVar.d);
                break;
            case 1:
                httpGet = new HttpPost(hsVar.d);
                httpGet.addHeader("Content-Type", hs.b());
                break;
            case 2:
                httpGet = new HttpPut(hsVar.d);
                httpGet.addHeader("Content-Type", hs.b());
                break;
            case 3:
                httpGet = new HttpDelete(hsVar.d);
                break;
            case 4:
                httpGet = new HttpHead(hsVar.d);
                break;
            case 5:
                httpGet = new HttpOptions(hsVar.d);
                break;
            case 6:
                httpGet = new HttpTrace(hsVar.d);
                break;
            case 7:
                httpGet = new iw(hsVar.d);
                httpGet.addHeader("Content-Type", hs.b());
                break;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
        a(httpGet, (Map) map);
        a(httpGet, hsVar.a());
        HttpParams params = httpGet.getParams();
        int c = hsVar.c();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, c);
        return this.a.execute(httpGet);
    }
}
