package com.alipay.b.f;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.alipay.e.a.a.b.a;
import com.alipay.e.a.a.d.c;
import java.util.UUID;

public final class b {
    private static String a = "";

    public static synchronized String a(Context context) {
        String a;
        synchronized (b.class) {
            if (a.a(a)) {
                a = c.a(context, "alipay_vkey_random", "random", "");
                a = a;
                if (a.a(a)) {
                    a = com.alipay.e.a.a.b.a.b.a(UUID.randomUUID().toString());
                    a = "alipay_vkey_random";
                    String str = "random";
                    String str2 = a;
                    if (str2 != null) {
                        Editor edit = context.getSharedPreferences(a, 0).edit();
                        if (edit != null) {
                            edit.clear();
                            edit.putString(str, str2);
                            edit.commit();
                        }
                    }
                }
            }
            a = a;
        }
        return a;
    }
}
