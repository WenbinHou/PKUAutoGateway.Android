package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@fd
@TargetApi(11)
public final class hq extends gw {
    public hq(gv gvVar, boolean z) {
        super(gvVar, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Exception e;
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (webView instanceof gv) {
                gv gvVar = (gv) webView;
                gw i = gvVar.i();
                synchronized (i.c) {
                    i.i = false;
                    i.k = true;
                    fs.a(new gx(i));
                }
                String str2 = gvVar.h().e ? (String) f.i().a(ak.F) : gvVar.m() ? (String) f.i().a(ak.E) : (String) f.i().a(ak.D);
                fk.e("shouldInterceptRequest(" + str2 + ")");
                Context context = gvVar.getContext();
                String str3 = this.a.l().b;
                Map hashMap = new HashMap();
                hashMap.put("User-Agent", f.c().a(context, str3));
                hashMap.put("Cache-Control", "max-stale=3600");
                gg ggVar = new gg(context);
                Object glVar = new gl(ggVar);
                gg.a.a(new gj(ggVar, str2, glVar, new gi(ggVar, str2, glVar), hashMap));
                String str4 = (String) glVar.get(60, TimeUnit.SECONDS);
                return str4 == null ? null : new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str4.getBytes("UTF-8")));
            } else {
                b.d("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, str);
            }
        } catch (IOException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        } catch (InterruptedException e4) {
            e = e4;
        } catch (TimeoutException e5) {
            e = e5;
        }
        b.d("Could not fetch MRAID JS. " + e.getMessage());
        return super.shouldInterceptRequest(webView, str);
    }
}
