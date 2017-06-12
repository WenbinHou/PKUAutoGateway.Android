package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.c.c;
import com.alipay.sdk.f.a.d;
import com.alipay.sdk.i.b;
import com.alipay.sdk.k.e;
import com.alipay.sdk.k.i;
import com.alipay.sdk.k.j;
import com.alipay.sdk.l.a;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class PayTask {
    static final Object a = e.class;
    private Activity b;
    private a c;
    private String d = "wappaygw.alipay.com/service/rest.htm";
    private String e = "mclient.alipay.com/service/rest.htm";
    private String f = "mclient.alipay.com/home/exterfaceAssign.htm";
    private Map<String, b> g = new HashMap();

    public PayTask(Activity activity) {
        this.b = activity;
        b a = b.a();
        Context context = this.b;
        c.a();
        a.a(context);
        com.alipay.sdk.app.a.a.a(activity);
        this.c = new a(activity, "去支付宝付款");
    }

    private String a(com.alipay.sdk.h.b bVar) {
        String[] strArr = bVar.b;
        Intent intent = new Intent(this.b, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", strArr[0]);
        if (strArr.length == 2) {
            bundle.putString("cookie", strArr[1]);
        }
        intent.putExtras(bundle);
        this.b.startActivity(intent);
        synchronized (a) {
            try {
                a.wait();
            } catch (InterruptedException e) {
                return j.a();
            }
        }
        Object obj = j.a;
        return TextUtils.isEmpty(obj) ? j.a() : obj;
    }

    private String a(String str) {
        k kVar;
        int i = 0;
        a();
        com.alipay.sdk.j.a aVar;
        try {
            List a = com.alipay.sdk.h.b.a(new d().a(this.b, str).a().optJSONObject("form").optJSONObject("onload"));
            for (int i2 = 0; i2 < a.size(); i2++) {
                if (((com.alipay.sdk.h.b) a.get(i2)).a == com.alipay.sdk.h.a.Update) {
                    String[] strArr = ((com.alipay.sdk.h.b) a.get(i2)).b;
                    if (strArr.length == 3 && TextUtils.equals("tid", strArr[0])) {
                        Context context = b.a().a;
                        com.alipay.sdk.j.b a2 = com.alipay.sdk.j.b.a();
                        if (!(TextUtils.isEmpty(strArr[1]) || TextUtils.isEmpty(strArr[2]))) {
                            a2.a = strArr[1];
                            a2.b = strArr[2];
                            aVar = new com.alipay.sdk.j.a(context);
                            aVar.a(com.alipay.sdk.k.b.a(context).a(), com.alipay.sdk.k.b.a(context).b(), a2.a, a2.b);
                            aVar.close();
                        }
                    }
                }
            }
            b();
            while (i < a.size()) {
                if (((com.alipay.sdk.h.b) a.get(i)).a == com.alipay.sdk.h.a.WapPay) {
                    String a3 = a((com.alipay.sdk.h.b) a.get(i));
                    b();
                    return a3;
                }
                i++;
            }
            b();
            kVar = null;
        } catch (Exception e) {
            aVar.close();
        } catch (Throwable e2) {
            k a4 = k.a(k.NETWORK_ERROR.h);
            com.alipay.sdk.app.a.a.a("net", e2);
            b();
            kVar = a4;
        } catch (Throwable th) {
            b();
        }
        if (kVar == null) {
            kVar = k.a(k.FAILED.h);
        }
        return j.a(kVar.h, kVar.i, "");
    }

    private void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    private static boolean a(boolean z, boolean z2, String str, StringBuilder stringBuilder, Map<String, String> map, String... strArr) {
        String str2;
        String str3 = "";
        for (Object obj : strArr) {
            if (!TextUtils.isEmpty((CharSequence) map.get(obj))) {
                str2 = (String) map.get(obj);
                break;
            }
        }
        str2 = str3;
        if (TextUtils.isEmpty(str2)) {
            if (z2) {
                return false;
            }
        } else if (z) {
            stringBuilder.append("&").append(str).append("=\"").append(str2).append("\"");
        } else {
            stringBuilder.append(str).append("=\"").append(str2).append("\"");
        }
        return true;
    }

    private void b() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        String trim;
        if (!TextUtils.isEmpty(str)) {
            String trim2;
            trim = str.trim();
            if (trim.startsWith("https://" + this.d) || trim.startsWith("http://" + this.d)) {
                trim2 = trim.replaceFirst("(http|https)://" + this.d + "\\?", "").trim();
                if (!TextUtils.isEmpty(trim2)) {
                    trim = "_input_charset=\"utf-8\"&ordertoken=\"" + j.a("<request_token>", "</request_token>", (String) j.a(trim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.i.a(this.b).a("sc", "h5tonative") + "\"";
                }
            }
            try {
                if (trim.startsWith("https://" + this.e) || trim.startsWith("http://" + this.e)) {
                    trim2 = trim.replaceFirst("(http|https)://" + this.e + "\\?", "").trim();
                    if (!TextUtils.isEmpty(trim2)) {
                        trim = "_input_charset=\"utf-8\"&ordertoken=\"" + j.a("<request_token>", "</request_token>", (String) j.a(trim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.i.a(this.b).a("sc", "h5tonative") + "\"";
                    }
                }
                if ((trim.startsWith("https://" + this.f) || trim.startsWith("http://" + this.f)) && trim.contains("alipay.wap.create.direct.pay.by.user") && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://" + this.f + "\\?", "").trim())) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str);
                        jSONObject.put("bizcontext", new com.alipay.sdk.i.a(this.b).a("sc", "h5tonative"));
                        trim = "new_external_info==" + jSONObject.toString();
                    } catch (Throwable th) {
                    }
                }
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com\\/w\\/trade_pay\\.do.?|mali\\.alipay\\.com\\/w\\/trade_pay\\.do.?|mclient\\.alipay\\.com\\/w\\/trade_pay\\.do.?)").matcher(str).find()) {
                    trim = j.a("?", "", str);
                    if (!TextUtils.isEmpty(trim)) {
                        Map a = j.a(trim);
                        StringBuilder stringBuilder = new StringBuilder();
                        if (a(false, true, "trade_no", stringBuilder, a, "trade_no", "alipay_trade_no")) {
                            a(true, false, "pay_phase_id", stringBuilder, a, "payPhaseId", "pay_phase_id", "out_relation_id");
                            stringBuilder.append("&biz_sub_type=\"TRADE\"");
                            stringBuilder.append("&biz_type=\"trade\"");
                            trim = (String) a.get("app_name");
                            if (TextUtils.isEmpty(trim) && !TextUtils.isEmpty((CharSequence) a.get("cid"))) {
                                trim = "ali1688";
                            } else if (TextUtils.isEmpty(trim) && !(TextUtils.isEmpty((CharSequence) a.get("sid")) && TextUtils.isEmpty((CharSequence) a.get("s_id")))) {
                                trim = "tb";
                            }
                            stringBuilder.append("&app_name=\"" + trim + "\"");
                            if (a(true, true, "extern_token", stringBuilder, a, "extern_token", "cid", "sid", "s_id")) {
                                a(true, false, "appenv", stringBuilder, a, "appenv");
                                stringBuilder.append("&pay_channel_id=\"alipay_sdk\"");
                                b bVar = new b();
                                bVar.a = (String) a.get("return_url");
                                bVar.b = (String) a.get("pay_order_id");
                                trim = stringBuilder.toString() + "&bizcontext=\"" + new com.alipay.sdk.i.a(this.b).a("sc", "h5tonative") + "\"";
                                this.g.put(trim, bVar);
                            } else {
                                trim = "";
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
            }
        }
        trim = "";
        return trim;
    }

    public synchronized String fetchTradeToken() {
        return i.b(this.b, "pref_trade_token", "");
    }

    public String getVersion() {
        return "15.1.0";
    }

    public synchronized com.alipay.sdk.k.a h5Pay(String str, boolean z) {
        com.alipay.sdk.k.a aVar;
        synchronized (this) {
            com.alipay.sdk.k.a aVar2 = new com.alipay.sdk.k.a();
            try {
                str.trim();
                String[] split = pay(str, z).split(";");
                Map hashMap = new HashMap();
                for (String str2 : split) {
                    String substring = str2.substring(0, str2.indexOf("={"));
                    String str3 = substring + "={";
                    hashMap.put(substring, str2.substring(str3.length() + str2.indexOf(str3), str2.lastIndexOf("}")));
                }
                if (hashMap.containsKey("resultStatus")) {
                    aVar2.b = (String) hashMap.get("resultStatus");
                }
                if (hashMap.containsKey("callBackUrl")) {
                    aVar2.a = (String) hashMap.get("callBackUrl");
                } else if (hashMap.containsKey("result")) {
                    try {
                        String str4 = (String) hashMap.get("result");
                        if (str4.length() > 15) {
                            b bVar = (b) this.g.get(str);
                            if (bVar != null) {
                                if (TextUtils.isEmpty(bVar.b)) {
                                    aVar2.a = bVar.a;
                                } else {
                                    aVar2.a = com.alipay.sdk.c.a.b().a.replace("$OrderId$", bVar.b);
                                }
                                this.g.remove(str);
                                aVar = aVar2;
                            } else {
                                CharSequence a = j.a("&callBackUrl=\"", "\"", str4);
                                if (TextUtils.isEmpty(a)) {
                                    a = j.a("&call_back_url=\"", "\"", str4);
                                    if (TextUtils.isEmpty(a)) {
                                        a = j.a("&return_url=\"", "\"", str4);
                                        if (TextUtils.isEmpty(a)) {
                                            a = URLDecoder.decode(j.a("&return_url=", "&", str4), "utf-8");
                                            if (TextUtils.isEmpty(a)) {
                                                str4 = URLDecoder.decode(j.a("&callBackUrl=", "&", str4), "utf-8");
                                                if (TextUtils.isEmpty(str4)) {
                                                    str4 = com.alipay.sdk.c.a.b().a;
                                                }
                                                aVar2.a = URLDecoder.decode(str4, "utf-8");
                                            }
                                        }
                                    }
                                }
                                CharSequence charSequence = a;
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = com.alipay.sdk.c.a.b().a;
                                }
                                aVar2.a = URLDecoder.decode(str4, "utf-8");
                            }
                        } else {
                            b bVar2 = (b) this.g.get(str);
                            if (bVar2 != null) {
                                aVar2.a = bVar2.a;
                                this.g.remove(str);
                                aVar = aVar2;
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
            }
            aVar = aVar2;
        }
        return aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized String pay(String str, boolean z) {
        String str2;
        Object obj = null;
        synchronized (this) {
            if (z) {
                a();
            }
            String str3 = "";
            try {
                Context context;
                String[] split;
                int i;
                String[] split2;
                int i2;
                String a = new com.alipay.sdk.i.a(this.b).a(str);
                if (!a.contains("paymethod=\"expressGateway\"") && j.b(this.b)) {
                    e eVar = new e(this.b, new i(this));
                    CharSequence a2 = eVar.a(a);
                    eVar.a = null;
                    if (!TextUtils.equals(a2, "failed")) {
                        if (TextUtils.isEmpty(a2)) {
                            str3 = j.a();
                        } else {
                            CharSequence charSequence = a2;
                        }
                        context = this.b;
                        if (!TextUtils.isEmpty(str3)) {
                            split = str3.split(";");
                            i = 0;
                            while (i < split.length) {
                                if (split[i].startsWith("result={") && split[i].endsWith("}")) {
                                    split2 = split[i].substring(8, split[i].length() - 1).split("&");
                                    i2 = 0;
                                    while (i2 < split2.length) {
                                        if (!split2[i2].startsWith("trade_token=\"") && split2[i2].endsWith("\"")) {
                                            obj = split2[i2].substring(13, split2[i2].length() - 1);
                                            break;
                                        } else if (split2[i2].startsWith("trade_token=")) {
                                            obj = split2[i2].substring(12);
                                            break;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                i++;
                            }
                        }
                        if (!TextUtils.isEmpty(obj)) {
                            i.a(context, "pref_trade_token", obj);
                        }
                        com.alipay.sdk.c.a.b().a(this.b);
                        b();
                        com.alipay.sdk.app.a.a.a(this.b, str);
                        str2 = str3;
                    }
                }
                str3 = a(a);
                context = this.b;
                if (TextUtils.isEmpty(str3)) {
                    split = str3.split(";");
                    i = 0;
                    while (i < split.length) {
                        split2 = split[i].substring(8, split[i].length() - 1).split("&");
                        i2 = 0;
                        while (i2 < split2.length) {
                            if (!split2[i2].startsWith("trade_token=\"")) {
                            }
                            if (split2[i2].startsWith("trade_token=")) {
                                obj = split2[i2].substring(12);
                                break;
                            }
                            i2++;
                        }
                        i++;
                    }
                }
                if (TextUtils.isEmpty(obj)) {
                    i.a(context, "pref_trade_token", obj);
                }
                com.alipay.sdk.c.a.b().a(this.b);
                b();
                com.alipay.sdk.app.a.a.a(this.b, str);
                str2 = str3;
            } catch (Throwable th) {
                com.alipay.sdk.c.a.b().a(this.b);
                b();
                com.alipay.sdk.app.a.a.a(this.b, str);
            }
        }
        return str2;
    }
}
