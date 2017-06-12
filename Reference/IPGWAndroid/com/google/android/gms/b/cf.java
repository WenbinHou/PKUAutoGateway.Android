package com.google.android.gms.b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@fd
public final class cf implements cb {
    private final cc a;
    private final c b;
    private final dr c;

    public cf(cc ccVar, c cVar, dr drVar) {
        this.a = ccVar;
        this.b = cVar;
        this.c = drVar;
    }

    private void a(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }

    private static boolean a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return f.e().b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return f.e().a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return f.e().c();
            }
        }
        return -1;
    }

    public final void a(gv gvVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            b.d("Action missing from an open GMSG.");
        } else if (this.b == null || this.b.a()) {
            gw i = gvVar.i();
            if ("expand".equalsIgnoreCase(str)) {
                if (gvVar.m()) {
                    b.d("Cannot expand WebView that is already expanded.");
                    return;
                }
                a(false);
                i.a(a((Map) map), b(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                a(false);
                if (str != null) {
                    i.a(a((Map) map), b(map), str);
                } else {
                    i.a(a((Map) map), b(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                map.get("product_id");
                str = (String) map.get("report_urls");
                if (this.a == null) {
                    return;
                }
                if (str == null || str.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                } else {
                    ArrayList arrayList2 = new ArrayList(Arrays.asList(str.split(" ")));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("play_store"))) {
                str = (String) map.get("u");
                if (TextUtils.isEmpty(str)) {
                    b.d("Destination url cannot be empty.");
                } else {
                    new cg(gvVar, str).b();
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                a(true);
                Context context = gvVar.getContext();
                if (TextUtils.isEmpty((String) map.get("u"))) {
                    b.d("Destination url cannot be empty.");
                    return;
                }
                try {
                    gvVar.i().a(new AdLauncherIntentInfoParcel(new ch(gvVar).a(context, (Map) map)));
                } catch (ActivityNotFoundException e) {
                    b.d(e.getMessage());
                }
            } else {
                String str2;
                a(true);
                str = (String) map.get("u");
                if (TextUtils.isEmpty(str)) {
                    str2 = str;
                } else {
                    f.c();
                    str2 = fs.a(gvVar, str);
                }
                i.a(new AdLauncherIntentInfoParcel((String) map.get("i"), str2, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            map.get("u");
            b.a("Action was blocked because no click was detected.");
        }
    }
}
