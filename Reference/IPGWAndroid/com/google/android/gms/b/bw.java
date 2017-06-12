package com.google.android.gms.b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class bw implements cb {
    bw() {
    }

    public final void a(gv gvVar, Map<String, String> map) {
        PackageManager packageManager = gvVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        Object optString2 = jSONObject2.optString("u");
                        Object optString3 = jSONObject2.optString("i");
                        Object optString4 = jSONObject2.optString("m");
                        Object optString5 = jSONObject2.optString("p");
                        Object optString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        Intent intent = new Intent();
                        if (!TextUtils.isEmpty(optString2)) {
                            intent.setData(Uri.parse(optString2));
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            intent.setAction(optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            intent.setType(optString4);
                        }
                        if (!TextUtils.isEmpty(optString5)) {
                            intent.setPackage(optString5);
                        }
                        if (!TextUtils.isEmpty(optString6)) {
                            String[] split = optString6.split("/", 2);
                            if (split.length == 2) {
                                intent.setComponent(new ComponentName(split[0], split[1]));
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (Throwable e) {
                            b.b("Error constructing openable urls response.", e);
                        }
                    } catch (Throwable e2) {
                        b.b("Error parsing the intent data.", e2);
                    }
                }
                gvVar.a("openableIntents", jSONObject);
            } catch (JSONException e3) {
                gvVar.a("openableIntents", new JSONObject());
            }
        } catch (JSONException e4) {
            gvVar.a("openableIntents", new JSONObject());
        }
    }
}
