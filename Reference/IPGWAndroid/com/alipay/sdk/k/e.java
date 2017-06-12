package com.alipay.sdk.k;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.c.a;
import java.util.List;

public class e {
    public Activity a;
    private IAlixPay b;
    private final Object c = IAlixPay.class;
    private boolean d;
    private f e;
    private ServiceConnection f = new g(this);
    private IRemoteServiceCallback g = new h(this);

    public e(Activity activity, f fVar) {
        this.a = activity;
        this.e = fVar;
    }

    private String a(String str, Intent intent) {
        String str2;
        String f = j.f(this.a);
        this.a.getApplicationContext().bindService(intent, this.f, 1);
        synchronized (this.c) {
            if (this.b == null) {
                try {
                    this.c.wait((long) a.b().a());
                } catch (InterruptedException e) {
                }
            }
        }
        try {
            if (this.b == null) {
                String f2 = j.f(this.a);
                List installedPackages = this.a.getPackageManager().getInstalledPackages(0);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < installedPackages.size(); i++) {
                    PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
                    int i2 = packageInfo.applicationInfo.flags;
                    if ((i2 & 1) == 0 && (i2 & 128) == 0) {
                        i2 = 1;
                    } else {
                        boolean z = false;
                    }
                    if (i2 != 0) {
                        if (packageInfo.packageName.equals("com.eg.android.AlipayGphone")) {
                            stringBuilder.append(packageInfo.packageName).append(packageInfo.versionCode).append("-");
                        } else if (!(packageInfo.packageName.contains("theme") || packageInfo.packageName.startsWith("com.google.") || packageInfo.packageName.startsWith("com.android."))) {
                            stringBuilder.append(packageInfo.packageName).append("-");
                        }
                    }
                }
                com.alipay.sdk.app.a.a.a("biz", "ClientBindFailed", f + "|" + f2 + "|" + stringBuilder.toString());
                str2 = "failed";
                try {
                    this.a.unbindService(this.f);
                } catch (Throwable th) {
                }
                this.g = null;
                this.f = null;
                this.b = null;
                if (this.d) {
                    this.a.setRequestedOrientation(0);
                    this.d = false;
                }
                return str2;
            }
            if (this.e != null) {
                this.e.a();
            }
            if (this.a.getRequestedOrientation() == 0) {
                this.a.setRequestedOrientation(1);
                this.d = true;
            }
            this.b.registerCallback(this.g);
            str2 = this.b.Pay(str);
            this.b.unregisterCallback(this.g);
            try {
                this.a.unbindService(this.f);
            } catch (Throwable th2) {
            }
            this.g = null;
            this.f = null;
            this.b = null;
            if (this.d) {
                this.a.setRequestedOrientation(0);
                this.d = false;
            }
            return str2;
        } catch (Throwable th3) {
        }
        this.g = null;
        this.f = null;
        this.b = null;
        if (this.d) {
            this.a.setRequestedOrientation(0);
            this.d = false;
        }
        return str2;
    }

    public final String a(String str) {
        Intent intent;
        try {
            k a = j.a(this.a, "com.eg.android.AlipayGphone");
            if (a != null) {
                String a2 = j.a(a.a);
                if (!(a2 == null || TextUtils.equals(a2, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649"))) {
                    com.alipay.sdk.app.a.a.a("biz", "ClientSignError", a2);
                    return "failed";
                }
            }
            if (a.b > 78) {
                intent = new Intent();
                intent.setClassName("com.eg.android.AlipayGphone", "com.alipay.android.app.TransProcessPayActivity");
                this.a.startActivity(intent);
                Thread.sleep(150);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        intent = new Intent();
        intent.setPackage("com.eg.android.AlipayGphone");
        intent.setAction("com.eg.android.AlipayGphone.IAlixPay");
        return a(str, intent);
    }
}
