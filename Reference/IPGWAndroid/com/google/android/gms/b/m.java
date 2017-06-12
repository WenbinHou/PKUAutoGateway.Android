package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.List;

@fd
@TargetApi(14)
public final class m extends Thread {
    final k a;
    final fc b;
    final int c;
    final int d;
    final int e;
    final int f;
    private boolean g;
    private boolean h;
    private final Object i;
    private final l j;
    private final int k;

    private boolean a() {
        try {
            Context context = this.j.b;
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (!((runningAppProcessInfo.importance == 100 ? 1 : null) == null || keyguardManager.inKeyguardRestrictedInputMode())) {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (powerManager == null ? false : powerManager.isScreenOn()) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    final q a(View view, j jVar) {
        int i = 0;
        if (view == null) {
            return new q(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new q(this, 0, 0);
            }
            jVar.b(text.toString(), globalVisibleRect);
            return new q(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof gv)) {
            jVar.b();
            WebView webView = (WebView) view;
            if (id.a(19)) {
                jVar.b();
                webView.post(new o(this, jVar, webView, globalVisibleRect));
                r1 = 1;
            } else {
                r1 = 0;
            }
            return r1 != 0 ? new q(this, 0, 1) : new q(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new q(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            r1 = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                q a = a(viewGroup.getChildAt(i2), jVar);
                r1 += a.a;
                i += a.b;
            }
            return new q(this, r1, i);
        }
    }

    public final void run() {
        while (!this.h) {
            try {
                if (a()) {
                    Activity activity = this.j.a;
                    if (activity == null) {
                        b.a("ContentFetchThread: no activity");
                    } else if (activity != null) {
                        View view = null;
                        if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                            view = activity.getWindow().getDecorView().findViewById(16908290);
                        }
                        if (!(view == null || view == null)) {
                            view.post(new n(this, view));
                        }
                    }
                } else {
                    b.a("ContentFetchTask: sleeping");
                    synchronized (this.i) {
                        this.g = true;
                        b.a("ContentFetchThread: paused, mPause = " + this.g);
                    }
                }
                Thread.sleep((long) (this.k * 1000));
            } catch (Throwable th) {
                b.b("Error in ContentFetchTask", th);
                this.b.a(th, true);
            }
            synchronized (this.i) {
                while (this.g) {
                    try {
                        b.a("ContentFetchTask: waiting");
                        this.i.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
