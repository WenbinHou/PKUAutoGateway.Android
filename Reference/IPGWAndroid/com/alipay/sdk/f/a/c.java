package com.alipay.sdk.f.a;

import android.content.Context;
import com.alipay.sdk.f.b;
import com.alipay.sdk.f.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

public final class c extends d {
    public final b a(Context context, String str) {
        return a(context, str, "http://mcgw.alipay.com/sdklog.do", true);
    }

    protected final String a(String str, JSONObject jSONObject) {
        return str;
    }

    protected final List<Header> a(boolean z, String str) {
        List<Header> arrayList = new ArrayList();
        arrayList.add(new BasicHeader("msp-gzip", String.valueOf(z)));
        arrayList.add(new BasicHeader("content-type", "application/octet-stream"));
        arrayList.add(new BasicHeader("des-mode", "CBC"));
        return arrayList;
    }

    protected final JSONObject a() {
        return null;
    }

    protected final String c() {
        HashMap hashMap = new HashMap();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put("api_version", "1.0.0");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_v", "1.0");
        return d.a(hashMap, hashMap2);
    }
}
