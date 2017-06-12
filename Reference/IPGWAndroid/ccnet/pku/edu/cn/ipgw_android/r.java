package ccnet.pku.edu.cn.ipgw_android;

import android.webkit.WebView;

final class r implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ o b;

    r(o oVar, String str) {
        this.b = oVar;
        this.a = str;
    }

    public final void run() {
        String substring;
        WebView webView;
        this.b.b.a.l.setRefreshing(false);
        int indexOf = this.a.indexOf("<!--AContentBegin-->");
        String str = "";
        if (indexOf >= 0) {
            int indexOf2 = this.a.indexOf("<!--AContentEnd-->", indexOf + 20);
            if (indexOf2 >= 0) {
                substring = this.a.substring(indexOf + 20, indexOf2);
                webView = (WebView) this.b.b.a.findViewById(R.id.msgcontent_webview);
                if (!substring.equals("")) {
                    webView.setVisibility(0);
                }
                webView.getSettings().setDefaultTextEncodingName("UTF-8");
                webView.loadData(substring, "text/html; charset=UTF-8", null);
            }
        }
        substring = str;
        webView = (WebView) this.b.b.a.findViewById(R.id.msgcontent_webview);
        if (substring.equals("")) {
            webView.setVisibility(0);
        }
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.loadData(substring, "text/html; charset=UTF-8", null);
    }
}
