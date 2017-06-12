package com.alipay.b.g;

import android.content.Context;
import com.alipay.b.a.a;
import java.util.Map;

public final class g {
    public static synchronized String a(Context context, Map<String, String> map) {
        String a;
        synchronized (g.class) {
            a = new a(context).a((Map) map);
        }
        return a;
    }
}
