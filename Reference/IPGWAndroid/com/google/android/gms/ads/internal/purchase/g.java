package com.google.android.gms.ads.internal.purchase;

import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.fd;
import org.json.JSONException;
import org.json.JSONObject;

@fd
public final class g {
    public static String a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                b.d("Fail to parse purchase data");
            }
        }
        return str2;
    }
}
