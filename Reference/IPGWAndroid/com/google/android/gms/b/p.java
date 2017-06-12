package com.google.android.gms.b;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.b;
import org.json.JSONException;
import org.json.JSONObject;

final class p implements ValueCallback<String> {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        m mVar = this.a.e;
        j jVar = this.a.b;
        WebView webView = this.a.c;
        boolean z = this.a.d;
        synchronized (jVar.a) {
            jVar.d--;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    jVar.a(optString, z);
                } else {
                    jVar.a(webView.getTitle() + "\n" + optString, z);
                }
            }
            if (jVar.a()) {
                mVar.a.b(jVar);
            }
        } catch (JSONException e) {
            b.a("Json string may be malformed.");
        } catch (Throwable th) {
            b.a("Failed to get webview content.", th);
            mVar.b.a(th, true);
        }
    }
}
