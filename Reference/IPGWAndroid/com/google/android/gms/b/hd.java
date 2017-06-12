package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.o;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@fd
public final class hd extends FrameLayout implements gv {
    private final gv a;
    private final gu b;

    public hd(gv gvVar) {
        super(gvVar.getContext());
        this.a = gvVar;
        this.b = new gu(gvVar.d(), this, this);
        gw i = this.a.i();
        if (i != null) {
            i.a((gv) this);
        }
        addView(this.a.getView());
    }

    public final void a() {
        this.a.a();
    }

    public final void a(int i) {
        this.a.a(i);
    }

    public final void a(AdSizeParcel adSizeParcel) {
        this.a.a(adSizeParcel);
    }

    public final void a(c cVar) {
        this.a.a(cVar);
    }

    public final void a(String str) {
        this.a.a(str);
    }

    public final void a(String str, Map<String, ?> map) {
        this.a.a(str, map);
    }

    public final void a(String str, JSONObject jSONObject) {
        this.a.a(str, jSONObject);
    }

    public final void a(boolean z) {
        this.a.a(z);
    }

    public final void b() {
        this.a.b();
    }

    public final void b(c cVar) {
        this.a.b(cVar);
    }

    public final void b(boolean z) {
        this.a.b(z);
    }

    public final Activity c() {
        return this.a.c();
    }

    public final void c(boolean z) {
        this.a.c(z);
    }

    public final Context d() {
        return this.a.d();
    }

    public final b e() {
        return this.a.e();
    }

    public final c f() {
        return this.a.f();
    }

    public final c g() {
        return this.a.g();
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this.a.getWebView();
    }

    public final AdSizeParcel h() {
        return this.a.h();
    }

    public final gw i() {
        return this.a.i();
    }

    public final boolean j() {
        return this.a.j();
    }

    public final f k() {
        return this.a.k();
    }

    public final VersionInfoParcel l() {
        return this.a.l();
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.a.loadUrl(str);
    }

    public final boolean m() {
        return this.a.m();
    }

    public final boolean n() {
        return this.a.n();
    }

    public final void o() {
        gu guVar = this.b;
        com.google.android.gms.common.internal.c.a("onDestroy must be called from the UI thread.");
        if (guVar.d != null) {
            o oVar = guVar.d;
            Runnable runnable = oVar.c;
            runnable.a = true;
            fs.a.removeCallbacks(runnable);
            if (!(oVar.a.c() == null || !oVar.e || oVar.f)) {
                oVar.a.c().getWindow().clearFlags(128);
                oVar.e = false;
            }
        }
        this.a.o();
    }

    public final void onPause() {
        com.google.android.gms.common.internal.c.a("onPause must be called from the UI thread.");
        this.a.onPause();
    }

    public final void onResume() {
        this.a.onResume();
    }

    public final boolean p() {
        return this.a.p();
    }

    public final gu q() {
        return this.b;
    }

    public final as r() {
        return this.a.r();
    }

    public final av s() {
        return this.a.s();
    }

    public final void setBackgroundColor(int i) {
        this.a.setBackgroundColor(i);
    }

    public final void setContext(Context context) {
        this.a.setContext(context);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(OnTouchListener onTouchListener) {
        this.a.setOnTouchListener(onTouchListener);
    }

    public final void setRequestedOrientation(int i) {
        this.a.setRequestedOrientation(i);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.a.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.a.setWebViewClient(webViewClient);
    }

    public final void t() {
        this.a.t();
    }

    public final void u() {
        this.a.u();
    }
}
