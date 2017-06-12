package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@fd
public final class he extends WebView implements OnGlobalLayoutListener, DownloadListener, gv {
    private int A = -1;
    private Map<String, cm> B;
    private final WindowManager C;
    private final hg a;
    private final Object b = new Object();
    private final f c;
    private final VersionInfoParcel d;
    private final b e;
    private gw f;
    private c g;
    private AdSizeParcel h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private Boolean m;
    private int n;
    private boolean o = true;
    private String p = "";
    private as q;
    private as r;
    private as s;
    private av t;
    private WeakReference<OnClickListener> u;
    private c v;
    private gq w;
    private int x = -1;
    private int y = -1;
    private int z = -1;

    private he(hg hgVar, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, b bVar) {
        super(hgVar);
        this.a = hgVar;
        this.h = adSizeParcel;
        this.k = true;
        this.n = -1;
        this.c = null;
        this.d = versionInfoParcel;
        this.e = bVar;
        this.C = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setUserAgentString(f.c().a((Context) hgVar, versionInfoParcel.b));
        f.e().a(getContext(), settings);
        setDownloadListener(this);
        y();
        if (id.a(17)) {
            addJavascriptInterface(new hh(this), "googleAdsJsInterface");
        }
        this.w = new gq(this.a.a, this);
        C();
        this.t = new av(new aw("make_wv", this.h.b));
        aw awVar = this.t.b;
        synchronized (awVar.b) {
            awVar.c = null;
        }
        this.r = an.a(this.t.b);
        this.t.a("native:view_create", this.r);
        this.s = null;
        this.q = null;
    }

    private void A() {
        synchronized (this.b) {
            if (this.l) {
                f.e().a((View) this);
            }
            this.l = false;
        }
    }

    private void B() {
        synchronized (this.b) {
            if (this.B != null) {
                Iterator it = this.B.values().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    private void C() {
        if (this.t != null) {
            aw awVar = this.t.b;
            if (awVar != null && f.f().a() != null) {
                f.f().a().a.offer(awVar);
            }
        }
    }

    public static he a(Context context, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, b bVar) {
        return new he(new hg(context), adSizeParcel, versionInfoParcel, bVar);
    }

    private void a(Boolean bool) {
        this.m = bool;
        fg f = f.f();
        synchronized (f.a) {
            f.b = bool;
        }
    }

    private void b(String str) {
        synchronized (this.b) {
            if (n()) {
                com.google.android.gms.ads.internal.util.client.b.d("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    private boolean v() {
        if (!this.f.a()) {
            return false;
        }
        int i;
        int i2;
        f.c();
        DisplayMetrics a = fs.a(this.C);
        n.a();
        int b = a.b(a, a.widthPixels);
        n.a();
        int b2 = a.b(a, a.heightPixels);
        Activity activity = this.a.a;
        if (activity == null || activity.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            f.c();
            int[] a2 = fs.a(activity);
            n.a();
            i2 = a.b(a, a2[0]);
            n.a();
            i = a.b(a, a2[1]);
        }
        if (this.y == b && this.x == b2 && this.z == i2 && this.A == i) {
            return false;
        }
        boolean z = (this.y == b && this.x == b2) ? false : true;
        this.y = b;
        this.x = b2;
        this.z = i2;
        this.A = i;
        new ea(this).a(b, b2, i2, i, a.density, this.C.getDefaultDisplay().getRotation());
        return z;
    }

    private Boolean w() {
        Boolean bool;
        synchronized (this.b) {
            bool = this.m;
        }
        return bool;
    }

    private void x() {
        an.a(this.t.b, this.q, "aeh");
    }

    private void y() {
        synchronized (this.b) {
            if (this.k || this.h.e) {
                if (VERSION.SDK_INT < 14) {
                    com.google.android.gms.ads.internal.util.client.b.a("Disabling hardware acceleration on an overlay.");
                    z();
                } else {
                    com.google.android.gms.ads.internal.util.client.b.a("Enabling hardware acceleration on an overlay.");
                    A();
                }
            } else if (VERSION.SDK_INT < 18) {
                com.google.android.gms.ads.internal.util.client.b.a("Disabling hardware acceleration on an AdView.");
                z();
            } else {
                com.google.android.gms.ads.internal.util.client.b.a("Enabling hardware acceleration on an AdView.");
                A();
            }
        }
    }

    private void z() {
        synchronized (this.b) {
            if (!this.l) {
                f.e().b(this);
            }
            this.l = true;
        }
    }

    public final void a() {
        x();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.d.b);
        a("onhide", hashMap);
    }

    public final void a(int i) {
        x();
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.d.b);
        a("onhide", hashMap);
    }

    public final void a(AdSizeParcel adSizeParcel) {
        synchronized (this.b) {
            this.h = adSizeParcel;
            requestLayout();
        }
    }

    public final void a(c cVar) {
        synchronized (this.b) {
            this.g = cVar;
        }
    }

    public final void a(String str) {
        synchronized (this.b) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.b.d("Could not call loadUrl. " + th);
            }
        }
    }

    public final void a(String str, Map<String, ?> map) {
        try {
            a(str, f.c().a((Map) map));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.b.d("Could not convert parameters to JSON.");
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        fk.e("Dispatching AFMA event: " + stringBuilder.toString());
        jSONObject2 = stringBuilder.toString();
        if (id.a(19)) {
            if (w() == null) {
                synchronized (this.b) {
                    this.m = f.f().c();
                    if (this.m == null) {
                        try {
                            evaluateJavascript("(function(){})()", null);
                            a(Boolean.valueOf(true));
                        } catch (IllegalStateException e) {
                            a(Boolean.valueOf(false));
                        }
                    }
                }
            }
            if (w().booleanValue()) {
                synchronized (this.b) {
                    if (n()) {
                        com.google.android.gms.ads.internal.util.client.b.d("The webview is destroyed. Ignoring action.");
                    } else {
                        evaluateJavascript(jSONObject2, null);
                    }
                }
                return;
            }
            b("javascript:" + jSONObject2);
            return;
        }
        b("javascript:" + jSONObject2);
    }

    public final void a(boolean z) {
        synchronized (this.b) {
            this.k = z;
            y();
        }
    }

    public final void b() {
        if (this.q == null) {
            an.a(this.t.b, this.s, "aes");
            this.q = an.a(this.t.b);
            this.t.a("native:view_show", this.q);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.d.b);
        a("onshow", hashMap);
    }

    public final void b(c cVar) {
        synchronized (this.b) {
            this.v = cVar;
        }
    }

    public final void b(boolean z) {
        synchronized (this.b) {
            if (this.g != null) {
                this.g.a(this.f.a(), z);
            } else {
                this.i = z;
            }
        }
    }

    public final Activity c() {
        return this.a.a;
    }

    public final void c(boolean z) {
        synchronized (this.b) {
            this.o = z;
        }
    }

    public final Context d() {
        return this.a.b;
    }

    public final void destroy() {
        synchronized (this.b) {
            C();
            gq gqVar = this.w;
            gqVar.c = false;
            gqVar.b();
            if (this.g != null) {
                this.g.a();
                this.g.k();
                this.g = null;
            }
            gw gwVar = this.f;
            synchronized (gwVar.c) {
                gwVar.b.clear();
                gwVar.d = null;
                gwVar.e = null;
                gwVar.f = null;
                gwVar.g = null;
                gwVar.i = false;
                gwVar.k = false;
                gwVar.l = false;
                gwVar.j = null;
                gwVar.m = null;
                gwVar.h = null;
                if (gwVar.o != null) {
                    gwVar.o.a(true);
                    gwVar.o = null;
                }
            }
            if (this.j) {
                return;
            }
            f.k();
            cl.a(this);
            B();
            this.j = true;
            fk.e("Initiating WebView self destruct sequence in 3...");
            this.f.b();
        }
    }

    public final b e() {
        return this.e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(19)
    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.b) {
            if (n()) {
                com.google.android.gms.ads.internal.util.client.b.d("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                super.evaluateJavascript(str, valueCallback);
            }
        }
    }

    public final c f() {
        c cVar;
        synchronized (this.b) {
            cVar = this.g;
        }
        return cVar;
    }

    protected final void finalize() {
        synchronized (this.b) {
            if (!this.j) {
                f.k();
                cl.a(this);
                B();
            }
        }
        super.finalize();
    }

    public final c g() {
        c cVar;
        synchronized (this.b) {
            cVar = this.v;
        }
        return cVar;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    public final AdSizeParcel h() {
        AdSizeParcel adSizeParcel;
        synchronized (this.b) {
            adSizeParcel = this.h;
        }
        return adSizeParcel;
    }

    public final gw i() {
        return this.f;
    }

    public final boolean j() {
        return this.i;
    }

    public final f k() {
        return this.c;
    }

    public final VersionInfoParcel l() {
        return this.d;
    }

    public final void loadData(String str, String str2, String str3) {
        synchronized (this.b) {
            if (n()) {
                com.google.android.gms.ads.internal.util.client.b.d("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.b) {
            if (n()) {
                com.google.android.gms.ads.internal.util.client.b.d("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public final void loadUrl(String str) {
        synchronized (this.b) {
            if (n()) {
                com.google.android.gms.ads.internal.util.client.b.d("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.b.d("Could not call loadUrl. " + th);
                }
            }
        }
    }

    public final boolean m() {
        boolean z;
        synchronized (this.b) {
            z = this.k;
        }
        return z;
    }

    public final boolean n() {
        boolean z;
        synchronized (this.b) {
            z = this.j;
        }
        return z;
    }

    public final void o() {
        synchronized (this.b) {
            fk.e("Destroying WebView!");
            fs.a.post(new hf(this));
        }
    }

    protected final void onAttachedToWindow() {
        synchronized (this.b) {
            super.onAttachedToWindow();
            if (!n()) {
                gq gqVar = this.w;
                gqVar.b = true;
                if (gqVar.c) {
                    gqVar.a();
                }
            }
        }
    }

    protected final void onDetachedFromWindow() {
        synchronized (this.b) {
            if (!n()) {
                gq gqVar = this.w;
                gqVar.b = false;
                gqVar.b();
            }
            super.onDetachedFromWindow();
        }
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            f.c();
            fs.a(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.b.a("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (!n()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public final void onGlobalLayout() {
        boolean v = v();
        c f = f();
        if (f != null && v && f.m) {
            f.m = false;
            f.m();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void onMeasure(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        synchronized (this.b) {
            if (n()) {
                setMeasuredDimension(0, 0);
            } else if (isInEditMode() || this.k || this.h.i || this.h.j) {
                super.onMeasure(i, i2);
            } else if (this.h.e) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.C.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                int mode = MeasureSpec.getMode(i);
                int size = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                int size2 = MeasureSpec.getSize(i2);
                mode = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i3 = size2;
                }
                if (this.h.g > mode || this.h.d > r0) {
                    float f = this.a.getResources().getDisplayMetrics().density;
                    com.google.android.gms.ads.internal.util.client.b.d("Not enough space to show ad. Needs " + ((int) (((float) this.h.g) / f)) + "x" + ((int) (((float) this.h.d) / f)) + " dp, but only has " + ((int) (((float) size) / f)) + "x" + ((int) (((float) size2) / f)) + " dp.");
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                } else {
                    if (getVisibility() != 8) {
                        setVisibility(0);
                    }
                    setMeasuredDimension(this.h.g, this.h.d);
                }
            }
        }
    }

    public final void onPause() {
        if (!n()) {
            try {
                if (id.a(11)) {
                    super.onPause();
                }
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.b("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!n()) {
            try {
                if (id.a(11)) {
                    super.onResume();
                }
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.b("Could not resume webview.", e);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return n() ? false : super.onTouchEvent(motionEvent);
    }

    public final boolean p() {
        boolean z;
        synchronized (this.b) {
            an.a(this.t.b, this.q, "aebb");
            z = this.o;
        }
        return z;
    }

    public final gu q() {
        return null;
    }

    public final as r() {
        return this.s;
    }

    public final av s() {
        return this.t;
    }

    public final void setContext(Context context) {
        this.a.setBaseContext(context);
        this.w.a = this.a.a;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.u = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final void setRequestedOrientation(int i) {
        synchronized (this.b) {
            this.n = i;
            if (this.g != null) {
                this.g.a(this.n);
            }
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof gw) {
            this.f = (gw) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!n()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.b("Could not stop loading webview.", e);
            }
        }
    }

    public final void t() {
        gq gqVar = this.w;
        gqVar.c = true;
        if (gqVar.b) {
            gqVar.a();
        }
    }

    public final void u() {
        if (this.s == null) {
            this.s = an.a(this.t.b);
            this.t.a("native:view_load", this.s);
        }
    }
}
