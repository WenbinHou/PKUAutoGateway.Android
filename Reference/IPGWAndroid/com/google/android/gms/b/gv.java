package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

@fd
public interface gv extends ct {
    void a();

    void a(int i);

    void a(AdSizeParcel adSizeParcel);

    void a(c cVar);

    void a(String str);

    void a(String str, Map<String, ?> map);

    void a(boolean z);

    void b();

    void b(c cVar);

    void b(boolean z);

    Activity c();

    void c(boolean z);

    Context d();

    b e();

    c f();

    c g();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    View getView();

    WebView getWebView();

    AdSizeParcel h();

    gw i();

    boolean j();

    f k();

    VersionInfoParcel l();

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    boolean m();

    void measure(int i, int i2);

    boolean n();

    void o();

    void onPause();

    void onResume();

    boolean p();

    gu q();

    as r();

    av s();

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void t();

    void u();
}
