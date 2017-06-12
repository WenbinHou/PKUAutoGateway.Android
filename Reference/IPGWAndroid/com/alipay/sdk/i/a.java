package com.alipay.sdk.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

public final class a {
    private String a = "";
    private String b = "";

    public a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.a = packageInfo.versionName;
            this.b = packageInfo.packageName;
        } catch (Exception e) {
        }
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str4;
        String[] split = str.split(str2);
        int i = 0;
        while (i < split.length) {
            if (!TextUtils.isEmpty(split[i]) && split[i].startsWith(str3)) {
                str4 = split[i];
                break;
            }
            i++;
        }
        str4 = null;
        return str4;
    }

    private String b(String str) {
        try {
            String a = a(str, "&", "bizcontext=");
            if (TextUtils.isEmpty(a)) {
                return str + "&" + b("bizcontext=", "");
            }
            int indexOf = str.indexOf(a);
            String substring = str.substring(0, indexOf);
            return substring + b(a, "bizcontext=", "") + str.substring(indexOf + a.length());
        } catch (Throwable th) {
            return str;
        }
    }

    private String b(String str, String str2) {
        return str + a("", "") + str2;
    }

    private String b(String str, String str2, String str3) {
        String substring = str.substring(str2.length());
        JSONObject jSONObject = new JSONObject(substring.substring(0, substring.length() - str3.length()));
        if (!jSONObject.has("appkey")) {
            jSONObject.put("appkey", "2014052600006128");
        }
        if (!jSONObject.has("ty")) {
            jSONObject.put("ty", "and_lite");
        }
        if (!jSONObject.has("sv")) {
            jSONObject.put("sv", "h.a.3.1.0");
        }
        if (!jSONObject.has("an")) {
            jSONObject.put("an", this.b);
        }
        if (!jSONObject.has("av")) {
            jSONObject.put("av", this.a);
        }
        if (!jSONObject.has("sdk_start_time")) {
            jSONObject.put("sdk_start_time", System.currentTimeMillis());
        }
        return str2 + jSONObject.toString() + str3;
    }

    private String c(String str) {
        try {
            String a = a(str, "\"&", "bizcontext=\"");
            if (TextUtils.isEmpty(a)) {
                return str + "&" + b("bizcontext=\"", "\"");
            }
            if (!a.endsWith("\"")) {
                a = a + "\"";
            }
            int indexOf = str.indexOf(a);
            String substring = str.substring(0, indexOf);
            return substring + b(a, "bizcontext=\"", "\"") + str.substring(indexOf + a.length());
        } catch (Throwable th) {
            return str;
        }
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
            return str;
        }
        return (!str.contains("\"&") ? 1 : null) != null ? b(str) : c(str);
    }

    public final String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", "2014052600006128");
            jSONObject.put("ty", "and_lite");
            jSONObject.put("sv", "h.a.3.1.0");
            jSONObject.put("an", this.b);
            jSONObject.put("av", this.a);
            jSONObject.put("sdk_start_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, str2);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
