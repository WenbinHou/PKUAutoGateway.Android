package com.alipay.sdk.i;

import android.content.Context;
import android.text.TextUtils;
import com.b.a.a.a.h;
import com.b.a.c.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;

public final class b {
    private static b b;
    public Context a;

    private b() {
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(String[] strArr) {
        String readLine;
        Throwable th;
        String str = "";
        Process start;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(strArr);
            processBuilder.redirectErrorStream(false);
            start = processBuilder.start();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(start.getOutputStream());
                readLine = new DataInputStream(start.getInputStream()).readLine();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                start.waitFor();
                try {
                    start.destroy();
                } catch (Exception e) {
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    start.destroy();
                } catch (Exception e2) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            start = null;
            th = th4;
            start.destroy();
            throw th;
        }
        return readLine;
    }

    public static boolean b() {
        String[] strArr = new String[]{"/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < 5) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    String a = a(new String[]{"ls", "-l", strArr[i] + "su"});
                    return (TextUtils.isEmpty(a) || a.indexOf("root") == a.lastIndexOf("root")) ? false : true;
                } else {
                    i++;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public final void a(Context context) {
        this.a = context.getApplicationContext();
    }

    public final String c() {
        try {
            a a = com.b.a.c.b.a(this.a);
            return (a == null || h.a(a.d)) ? "ffffffffffffffffffffffff" : a.d;
        } catch (Throwable th) {
            return "";
        }
    }
}
