package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.c.c;
import com.alipay.sdk.i.b;
import com.alipay.sdk.k.e;
import com.alipay.sdk.l.a;
import java.io.IOException;
import java.util.List;

public class AuthTask {
    static final Object a = e.class;
    private Activity b;
    private a c;

    public AuthTask(Activity activity) {
        this.b = activity;
        b a = b.a();
        Context context = this.b;
        c.a();
        a.a(context);
        com.alipay.sdk.app.a.a.a(activity);
        this.c = new a(activity, "去支付宝授权");
    }

    private String a(Activity activity, String str) {
        String a;
        k kVar;
        a();
        k kVar2 = null;
        try {
            List a2 = com.alipay.sdk.h.b.a(new com.alipay.sdk.f.a.a().a((Context) activity, str).a().optJSONObject("form").optJSONObject("onload"));
            b();
            for (int i = 0; i < a2.size(); i++) {
                if (((com.alipay.sdk.h.b) a2.get(i)).a == com.alipay.sdk.h.a.WapPay) {
                    a = a((com.alipay.sdk.h.b) a2.get(i));
                    return a;
                }
            }
            b();
            kVar = null;
        } catch (IOException e) {
            a = e;
            kVar2 = k.a(k.NETWORK_ERROR.h);
            com.alipay.sdk.app.a.a.a("net", (Throwable) a);
            kVar = kVar2;
            if (kVar == null) {
                kVar = k.a(k.FAILED.h);
            }
            return j.a(kVar.h, kVar.i, "");
        } catch (Throwable th) {
            a = th;
            com.alipay.sdk.app.a.a.a("biz", "H5AuthDataAnalysisError", (Throwable) a);
            kVar = kVar2;
            if (kVar == null) {
                kVar = k.a(k.FAILED.h);
            }
            return j.a(kVar.h, kVar.i, "");
        } finally {
            b();
        }
        if (kVar == null) {
            kVar = k.a(k.FAILED.h);
        }
        return j.a(kVar.h, kVar.i, "");
    }

    private String a(com.alipay.sdk.h.b bVar) {
        String[] strArr = bVar.b;
        Bundle bundle = new Bundle();
        bundle.putString("url", strArr[0]);
        Intent intent = new Intent(this.b, a.class);
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

    private void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    private static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
            return packageInfo != null && packageInfo.versionCode >= 73;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void b() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public synchronized String auth(String str, boolean z) {
        String a;
        if (z) {
            a();
        }
        b a2 = b.a();
        Context context = this.b;
        c.a();
        a2.a(context);
        String a3 = j.a();
        try {
            Context context2 = this.b;
            String a4 = new com.alipay.sdk.i.a(this.b).a(str);
            if (a(context2)) {
                a = new e(context2, new c(this)).a(a4);
                if (!TextUtils.equals(a, "failed")) {
                    if (TextUtils.isEmpty(a)) {
                        a = j.a();
                    }
                    com.alipay.sdk.c.a.b().a(this.b);
                    b();
                    com.alipay.sdk.app.a.a.a(this.b, str);
                }
            }
            a = a(context2, a4);
            com.alipay.sdk.c.a.b().a(this.b);
            b();
            com.alipay.sdk.app.a.a.a(this.b, str);
        } catch (Exception e) {
            com.alipay.sdk.c.a.b().a(this.b);
            b();
            com.alipay.sdk.app.a.a.a(this.b, str);
            a = a3;
        } catch (Throwable th) {
            com.alipay.sdk.c.a.b().a(this.b);
            b();
            com.alipay.sdk.app.a.a.a(this.b, str);
        }
        return a;
    }
}
