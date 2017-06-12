package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.l;
import com.google.android.gms.ads.internal.overlay.s;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@fd
public class gw extends WebViewClient {
    private static final String[] p = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] q = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    protected gv a;
    final HashMap<String, List<cb>> b;
    final Object c;
    a d;
    l e;
    public gy f;
    bn g;
    gz h;
    boolean i;
    cc j;
    boolean k;
    boolean l;
    s m;
    public c n;
    dr o;
    private cd r;
    private final dz s;
    private eb t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;

    public gw(gv gvVar, boolean z) {
        this(gvVar, z, new dz(gvVar, gvVar.d(), new aa(gvVar.getContext())));
    }

    private gw(gv gvVar, boolean z, dz dzVar) {
        this.b = new HashMap();
        this.c = new Object();
        this.i = false;
        this.a = gvVar;
        this.k = z;
        this.s = dzVar;
        this.o = null;
    }

    private void a(Context context, String str, String str2, String str3) {
        if (((Boolean) f.i().a(ak.ao)).booleanValue()) {
            String host;
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            String str4 = "host";
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    host = parse.getHost();
                    bundle.putString(str4, host);
                    f.c();
                    fs.a(context, this.a.l().b, "gmob-apps", bundle);
                }
            }
            host = "";
            bundle.putString(str4, host);
            f.c();
            fs.a(context, this.a.l().b, "gmob-apps", bundle);
        }
    }

    private void a(Uri uri) {
        String path = uri.getPath();
        List<cb> list = (List) this.b.get(path);
        if (list != null) {
            f.c();
            Map a = fs.a(uri);
            if (b.a(2)) {
                fk.e("Received GMSG: " + path);
                for (String path2 : a.keySet()) {
                    fk.e("  " + path2 + ": " + ((String) a.get(path2)));
                }
            }
            for (cb a2 : list) {
                a2.a(this.a, a);
            }
            return;
        }
        fk.e("No GMSG handler found for GMSG: " + uri);
    }

    private void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean a = this.o != null ? this.o.a() : false;
        f.b();
        Context context = this.a.getContext();
        if (!a) {
            z = true;
        }
        if (adOverlayInfoParcel.l == 4 && adOverlayInfoParcel.d == null) {
            if (adOverlayInfoParcel.c != null) {
                a aVar = adOverlayInfoParcel.c;
            }
            f.a();
            AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = adOverlayInfoParcel.b;
            s sVar = adOverlayInfoParcel.j;
            com.google.android.gms.ads.internal.overlay.a.a(context, adLauncherIntentInfoParcel);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.n.e);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.a(intent, adOverlayInfoParcel);
        if (!id.a(21)) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        f.c();
        fs.a(context, intent);
    }

    static /* synthetic */ void a(gw gwVar) {
        synchronized (gwVar.c) {
            gwVar.l = true;
        }
        gwVar.x++;
        gwVar.c();
    }

    private void a(String str, cb cbVar) {
        synchronized (this.c) {
            List list = (List) this.b.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.b.put(str, list);
            }
            list.add(cbVar);
        }
    }

    static /* synthetic */ void b(gw gwVar) {
        gwVar.x--;
        gwVar.c();
    }

    private void c() {
        if (this.f != null && ((this.v && this.x <= 0) || this.w)) {
            this.f.a(this.a);
            this.f = null;
        }
        this.a.u();
    }

    static /* synthetic */ void c(gw gwVar) {
        gwVar.w = true;
        gwVar.c();
    }

    public final void a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        l lVar = null;
        boolean m = this.a.m();
        a aVar = (!m || this.a.h().e) ? this.d : null;
        if (!m) {
            lVar = this.e;
        }
        a(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, aVar, lVar, this.m, this.a.l()));
    }

    public final void a(bn bnVar, s sVar, cc ccVar, c cVar) {
        if (cVar == null) {
            cVar = new c((byte) 0);
        }
        this.o = new dr(this.a);
        a("/appEvent", new bm(bnVar));
        a("/backButton", bp.k);
        a("/canOpenURLs", bp.b);
        a("/canOpenIntents", bp.c);
        a("/click", bp.d);
        a("/close", bp.e);
        a("/customClose", bp.g);
        a("/instrument", bp.n);
        a("/delayPageLoaded", new hb());
        a("/httpTrack", bp.h);
        a("/log", bp.i);
        a("/mraid", new ce(cVar, this.o));
        a("/mraidLoaded", this.s);
        a("/open", new cf(ccVar, cVar, this.o));
        a("/precache", bp.m);
        a("/touch", bp.j);
        a("/video", bp.l);
        a("/appStreaming", bp.f);
        this.d = null;
        this.e = null;
        this.g = bnVar;
        this.j = ccVar;
        this.m = sVar;
        this.n = cVar;
        this.t = null;
        this.r = null;
        this.i = true;
    }

    public final void a(gv gvVar) {
        this.a = gvVar;
    }

    public final void a(boolean z, int i) {
        a aVar = (!this.a.m() || this.a.h().e) ? this.d : null;
        a(new AdOverlayInfoParcel(aVar, this.e, this.m, this.a, z, i, this.a.l()));
    }

    public final void a(boolean z, int i, String str) {
        l lVar = null;
        boolean m = this.a.m();
        a aVar = (!m || this.a.h().e) ? this.d : null;
        if (!m) {
            lVar = new ha(this.a, this.e);
        }
        a(new AdOverlayInfoParcel(aVar, lVar, this.g, this.m, this.a, z, i, str, this.a.l(), this.j));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean m = this.a.m();
        a aVar = (!m || this.a.h().e) ? this.d : null;
        a(new AdOverlayInfoParcel(aVar, m ? null : new ha(this.a, this.e), this.g, this.m, this.a, z, i, str, str2, this.a.l(), this.j));
    }

    public final boolean a() {
        boolean z;
        synchronized (this.c) {
            z = this.k;
        }
        return z;
    }

    public final void b() {
        synchronized (this.c) {
            fk.e("Loading blank page in WebView, 2...");
            this.u = true;
            this.a.a("about:blank");
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        fk.e("Loading resource: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            a(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.c) {
            if (this.u) {
                fk.e("Blank page loaded, 1...");
                this.a.o();
                return;
            }
            this.v = true;
            c();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= p.length) ? String.valueOf(i) : p[(-i) - 1];
        a(this.a.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= q.length) ? String.valueOf(primaryError) : q[primaryError];
            a(this.a.getContext(), "ssl_err", valueOf, f.e().a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        fk.e("AdWebView shouldOverrideUrlLoading: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            a(parse);
        } else {
            if (this.i && webView == this.a.getWebView()) {
                String scheme = parse.getScheme();
                Object obj = ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) ? 1 : null;
                if (obj != null) {
                    if (this.d != null) {
                        if (((Boolean) f.i().a(ak.W)).booleanValue()) {
                            this.d = null;
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.a.getWebView().willNotDraw()) {
                b.d("AdWebView unable to handle URL: " + str);
            } else {
                Uri uri;
                try {
                    f k = this.a.k();
                    if (k != null && k.a(parse)) {
                        this.a.getContext();
                        parse = k.b(parse);
                    }
                    uri = parse;
                } catch (g e) {
                    b.d("Unable to append parameter to URL: " + str);
                    uri = parse;
                }
                if (this.n == null || this.n.a()) {
                    a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    b.a("Action was blocked because no click was detected.");
                }
            }
        }
        return true;
    }
}
