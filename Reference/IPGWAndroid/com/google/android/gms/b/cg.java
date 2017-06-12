package com.google.android.gms.b;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class cg extends fi {
    private final String a = "play.google.com";
    private final String b = "market";
    private final int d = 10;
    private final String e;
    private final gv f;

    public cg(gv gvVar, String str) {
        this.f = gvVar;
        this.e = str;
    }

    public final void a() {
        String str;
        Throwable th;
        CharSequence charSequence;
        Throwable th2;
        int i = 0;
        String str2 = this.e;
        while (i < 10) {
            int i2 = i + 1;
            HttpURLConnection httpURLConnection;
            try {
                URL url = new URL(str2);
                if (!"play.google.com".equalsIgnoreCase(url.getHost())) {
                    if (!"market".equalsIgnoreCase(url.getProtocol())) {
                        CharSequence charSequence2;
                        CharSequence charSequence3;
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        f.c().a(this.f.getContext(), this.f.l().b, false, httpURLConnection);
                        int responseCode = httpURLConnection.getResponseCode();
                        Map headerFields = httpURLConnection.getHeaderFields();
                        String str3 = "";
                        if (responseCode >= 300 && responseCode <= 399) {
                            List list = null;
                            if (headerFields.containsKey("Location")) {
                                list = (List) headerFields.get("Location");
                            } else if (headerFields.containsKey("location")) {
                                list = (List) headerFields.get("location");
                            }
                            if (list != null && list.size() > 0) {
                                charSequence2 = (String) list.get(0);
                                if (TextUtils.isEmpty(charSequence2)) {
                                    b.d("Arrived at landing page, this ideally should not happen. Will open it in browser.");
                                    httpURLConnection.disconnect();
                                    str = str2;
                                    break;
                                }
                                try {
                                    httpURLConnection.disconnect();
                                    i = i2;
                                    charSequence3 = charSequence2;
                                } catch (Throwable e) {
                                    th = e;
                                    charSequence = charSequence2;
                                    th2 = th;
                                } catch (Throwable e2) {
                                    th = e2;
                                    charSequence = charSequence2;
                                    th2 = th;
                                } catch (Throwable e22) {
                                    th = e22;
                                    charSequence = charSequence2;
                                    th2 = th;
                                }
                            }
                        }
                        Object obj = str3;
                        if (TextUtils.isEmpty(charSequence2)) {
                            b.d("Arrived at landing page, this ideally should not happen. Will open it in browser.");
                            httpURLConnection.disconnect();
                            str = str2;
                            break;
                        }
                        httpURLConnection.disconnect();
                        i = i2;
                        charSequence3 = charSequence2;
                    } else {
                        str = str2;
                        break;
                    }
                }
                str = str2;
                break;
            } catch (Throwable e222) {
                th2 = e222;
                str = str2;
            } catch (Throwable e2222) {
                th2 = e2222;
                str = str2;
            } catch (Throwable e22222) {
                th2 = e22222;
                str = str2;
            } catch (Throwable th3) {
                httpURLConnection.disconnect();
            }
        }
        str = str2;
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(parse);
        f.c();
        fs.a(this.f.getContext(), intent);
        b.c("Error while pinging URL: " + str, th2);
        Uri parse2 = Uri.parse(str);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.addFlags(268435456);
        intent2.setData(parse2);
        f.c();
        fs.a(this.f.getContext(), intent2);
        b.c("Error while parsing ping URL: " + str, th2);
        Uri parse22 = Uri.parse(str);
        Intent intent22 = new Intent("android.intent.action.VIEW");
        intent22.addFlags(268435456);
        intent22.setData(parse22);
        f.c();
        fs.a(this.f.getContext(), intent22);
        b.c("Error while pinging URL: " + str, th2);
        Uri parse222 = Uri.parse(str);
        Intent intent222 = new Intent("android.intent.action.VIEW");
        intent222.addFlags(268435456);
        intent222.setData(parse222);
        f.c();
        fs.a(this.f.getContext(), intent222);
    }
}
