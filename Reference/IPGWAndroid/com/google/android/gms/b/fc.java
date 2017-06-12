package com.google.android.gms.b;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@fd
public final class fc implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler a = null;
    private UncaughtExceptionHandler b = null;
    private Context c;
    private VersionInfoParcel d;

    public fc(Context context, VersionInfoParcel versionInfoParcel) {
        this.c = context;
        this.d = versionInfoParcel;
    }

    private static boolean a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        if (str.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (str.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(fd.class);
        } catch (Throwable e) {
            b.a("Fail to check class type for class " + str, e);
            return z;
        }
    }

    public final void a(Throwable th, boolean z) {
        if (((Boolean) f.i().a(ak.g)).booleanValue()) {
            Throwable th2;
            if (((Boolean) f.i().a(ak.h)).booleanValue()) {
                th2 = th;
            } else {
                Throwable th3;
                LinkedList linkedList = new LinkedList();
                for (th3 = th; th3 != null; th3 = th3.getCause()) {
                    linkedList.push(th3);
                }
                th2 = null;
                while (!linkedList.isEmpty()) {
                    Throwable th4;
                    th3 = (Throwable) linkedList.pop();
                    StackTraceElement[] stackTrace = th3.getStackTrace();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                    Object obj = null;
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        if (a(stackTraceElement.getClassName())) {
                            obj = 1;
                            arrayList.add(stackTraceElement);
                        } else {
                            String className = stackTraceElement.getClassName();
                            Object obj2 = (TextUtils.isEmpty(className) || !(className.startsWith("android.") || className.startsWith("java."))) ? null : 1;
                            if (obj2 != null) {
                                arrayList.add(stackTraceElement);
                            } else {
                                arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                            }
                        }
                    }
                    if (obj != null) {
                        th4 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                        th4.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                    } else {
                        th4 = th2;
                    }
                    th2 = th4;
                }
            }
            if (th2 != null) {
                Class cls = th.getClass();
                List arrayList2 = new ArrayList();
                Writer stringWriter = new StringWriter();
                th2.printStackTrace(new PrintWriter(stringWriter));
                f.c();
                arrayList2.add(new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", fs.b()).appendQueryParameter("js", this.d.b).appendQueryParameter("appid", this.c.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", ak.a())).appendQueryParameter("trapped", String.valueOf(z)).toString());
                f.c();
                fs.a(this.c, this.d.b, arrayList2, f.f().b());
            }
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        if (th != null) {
            boolean z2 = false;
            z = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if (a(stackTraceElement.getClassName())) {
                        z = true;
                    }
                    if (getClass().getName().equals(stackTraceElement.getClassName())) {
                        z2 = true;
                    }
                }
            }
            if (z && !r2) {
                z = true;
                if (z) {
                    if (Looper.getMainLooper().getThread() == thread) {
                        a(th, true);
                        return;
                    }
                    a(th, false);
                }
                if (this.a != null) {
                    this.a.uncaughtException(thread, th);
                } else if (this.b != null) {
                    this.b.uncaughtException(thread, th);
                }
            }
        }
        z = false;
        if (z) {
            if (Looper.getMainLooper().getThread() == thread) {
                a(th, false);
            } else {
                a(th, true);
                return;
            }
        }
        if (this.a != null) {
            this.a.uncaughtException(thread, th);
        } else if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }
}
