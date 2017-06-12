package com.alipay.sdk.app.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alipay.sdk.j.b;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i = "";
    String j;

    public c(Context context) {
        String format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());
        this.a = String.format("123456789,%s", new Object[]{format});
        this.c = a(context);
        format = a("15.1.0");
        String a = a("h.a.3.1.0");
        this.d = String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", new Object[]{format, a});
        format = a(b.a().a);
        a = a(com.alipay.sdk.i.b.a().c());
        this.e = String.format("%s,%s,-,-,-", new Object[]{format, a});
        format = a(com.alipay.sdk.k.b.d(context));
        String a2 = a(VERSION.RELEASE);
        String a3 = a(Build.MODEL);
        String a4 = a(com.alipay.sdk.k.b.a(context).a());
        String a5 = a(com.alipay.sdk.k.b.b(context).p);
        String a6 = a(com.alipay.sdk.k.b.a(context).b());
        this.f = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[]{format, "android", a2, a3, "-", a4, a5, "gw", a6});
        this.g = "-";
        this.h = "-";
        this.j = "-";
    }

    private static String a(Context context) {
        String str = "-";
        String str2 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                str = applicationContext.getPackageName();
                str2 = applicationContext.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (Throwable th) {
            }
        }
        return String.format("%s,%s,-,-,-", new Object[]{str, str2});
    }

    static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("-", "=").replace("^", "~");
    }

    private static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName()).append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + " 》 ");
                }
            }
        } catch (Throwable th2) {
        }
        return stringBuffer.toString();
    }

    public final void a(String str, String str2, String str3) {
        String str4 = "-";
        String str5 = "";
        if (!TextUtils.isEmpty(this.i)) {
            str5 = str5 + "^";
        }
        this.i += (str5 + String.format("%s,%s,%s,%s", new Object[]{str, str2, a(str3), str4}));
    }

    public final void a(String str, String str2, Throwable th) {
        a(str, str2, a(th));
    }
}
