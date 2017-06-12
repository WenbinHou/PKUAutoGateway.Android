package com.google.android.gms.b;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

final class bx implements cb {
    bx() {
    }

    public final void a(gv gvVar, Map<String, String> map) {
        String str = (String) map.get("u");
        if (str == null) {
            b.d("URL missing from click GMSG.");
            return;
        }
        Uri b;
        Uri parse = Uri.parse(str);
        try {
            f k = gvVar.k();
            if (k != null && k.a(parse)) {
                gvVar.getContext();
                b = k.b(parse);
                new gn(gvVar.getContext(), gvVar.l().b, b.toString()).b();
            }
        } catch (g e) {
            b.d("Unable to append parameter to URL: " + str);
        }
        b = parse;
        new gn(gvVar.getContext(), gvVar.l().b, b.toString()).b();
    }
}
