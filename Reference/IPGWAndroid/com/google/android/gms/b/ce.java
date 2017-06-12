package com.google.android.gms.b;

import android.app.AlertDialog.Builder;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.g.a;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

@fd
public final class ce implements cb {
    static final Map<String, Integer> a;
    private final c b;
    private final dr c;

    static {
        Integer valueOf = Integer.valueOf(1);
        Integer valueOf2 = Integer.valueOf(2);
        Integer valueOf3 = Integer.valueOf(3);
        Integer valueOf4 = Integer.valueOf(4);
        Integer valueOf5 = Integer.valueOf(5);
        Integer valueOf6 = Integer.valueOf(6);
        Map aVar = new a(6);
        aVar.put("resize", valueOf);
        aVar.put("playVideo", valueOf2);
        aVar.put("storePicture", valueOf3);
        aVar.put("createCalendarEvent", valueOf4);
        aVar.put("setOrientationProperties", valueOf5);
        aVar.put("closeResizedAd", valueOf6);
        a = Collections.unmodifiableMap(aVar);
    }

    public ce(c cVar, dr drVar) {
        this.b = cVar;
        this.c = drVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(gv gvVar, Map<String, String> map) {
        boolean z = true;
        int intValue = ((Integer) a.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.b == null || this.b.a()) {
            String str;
            switch (intValue) {
                case 1:
                    ea eaVar = this.c;
                    synchronized (eaVar.j) {
                        if (eaVar.l == null) {
                            eaVar.a("Not an activity context. Cannot resize.");
                            return;
                        } else if (eaVar.k.h() == null) {
                            eaVar.a("Webview is not yet available, size is not set.");
                            return;
                        } else if (eaVar.k.h().e) {
                            eaVar.a("Is interstitial. Cannot resize an interstitial.");
                            return;
                        } else if (eaVar.k.m()) {
                            eaVar.a("Cannot resize an expanded banner.");
                            return;
                        } else {
                            if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
                                f.c();
                                eaVar.i = fs.a((String) map.get("width"));
                            }
                            if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
                                f.c();
                                eaVar.f = fs.a((String) map.get("height"));
                            }
                            if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
                                f.c();
                                eaVar.g = fs.a((String) map.get("offsetX"));
                            }
                            if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
                                f.c();
                                eaVar.h = fs.a((String) map.get("offsetY"));
                            }
                            if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
                                eaVar.c = Boolean.parseBoolean((String) map.get("allowOffscreen"));
                            }
                            str = (String) map.get("customClosePosition");
                            if (!TextUtils.isEmpty(str)) {
                                eaVar.b = str;
                            }
                            boolean z2 = eaVar.i >= 0 && eaVar.f >= 0;
                            if (z2) {
                                Window window = eaVar.l.getWindow();
                                if (window == null || window.getDecorView() == null) {
                                    eaVar.a("Activity context is not ready, cannot get window or decor view.");
                                    return;
                                }
                                int i;
                                f.c();
                                int[] b = fs.b(eaVar.l);
                                f.c();
                                int[] c = fs.c(eaVar.l);
                                int i2 = b[0];
                                intValue = b[1];
                                if (eaVar.i < 50 || eaVar.i > i2) {
                                    b.d("Width is too small or too large.");
                                    z2 = false;
                                } else if (eaVar.f < 50 || eaVar.f > intValue) {
                                    b.d("Height is too small or too large.");
                                    z2 = false;
                                } else if (eaVar.f == intValue && eaVar.i == i2) {
                                    b.d("Cannot resize to a full-screen ad.");
                                    z2 = false;
                                } else {
                                    if (eaVar.c) {
                                        str = eaVar.b;
                                        switch (str.hashCode()) {
                                            case -1364013995:
                                                if (str.equals("center")) {
                                                    z2 = true;
                                                    break;
                                                }
                                            case -1012429441:
                                                if (str.equals("top-left")) {
                                                    z2 = false;
                                                    break;
                                                }
                                            case -655373719:
                                                if (str.equals("bottom-left")) {
                                                    z2 = true;
                                                    break;
                                                }
                                            case 1163912186:
                                                if (str.equals("bottom-right")) {
                                                    z2 = true;
                                                    break;
                                                }
                                            case 1288627767:
                                                if (str.equals("bottom-center")) {
                                                    z2 = true;
                                                    break;
                                                }
                                            case 1755462605:
                                                if (str.equals("top-center")) {
                                                    z2 = true;
                                                    break;
                                                }
                                            default:
                                                z2 = true;
                                                break;
                                        }
                                        switch (z2) {
                                            case false:
                                                intValue = eaVar.d + eaVar.g;
                                                i = eaVar.e + eaVar.h;
                                                break;
                                            case true:
                                                intValue = ((eaVar.d + eaVar.g) + (eaVar.i / 2)) - 25;
                                                i = eaVar.e + eaVar.h;
                                                break;
                                            case true:
                                                intValue = ((eaVar.d + eaVar.g) + (eaVar.i / 2)) - 25;
                                                i = ((eaVar.e + eaVar.h) + (eaVar.f / 2)) - 25;
                                                break;
                                            case true:
                                                intValue = eaVar.d + eaVar.g;
                                                i = ((eaVar.e + eaVar.h) + eaVar.f) - 50;
                                                break;
                                            case true:
                                                intValue = ((eaVar.d + eaVar.g) + (eaVar.i / 2)) - 25;
                                                i = ((eaVar.e + eaVar.h) + eaVar.f) - 50;
                                                break;
                                            case true:
                                                intValue = ((eaVar.d + eaVar.g) + eaVar.i) - 50;
                                                i = ((eaVar.e + eaVar.h) + eaVar.f) - 50;
                                                break;
                                            default:
                                                intValue = ((eaVar.d + eaVar.g) + eaVar.i) - 50;
                                                i = eaVar.e + eaVar.h;
                                                break;
                                        }
                                        if (intValue < 0 || intValue + 50 > i2 || r2 < c[0] || r2 + 50 > c[1]) {
                                            z2 = false;
                                        }
                                    }
                                    z2 = true;
                                }
                                if (!z2) {
                                    c = null;
                                } else if (eaVar.c) {
                                    c = new int[]{eaVar.d + eaVar.g, eaVar.e + eaVar.h};
                                } else {
                                    f.c();
                                    b = fs.b(eaVar.l);
                                    f.c();
                                    int[] c2 = fs.c(eaVar.l);
                                    int i3 = b[0];
                                    i = eaVar.g + eaVar.d;
                                    intValue = eaVar.e + eaVar.h;
                                    i3 = i < 0 ? 0 : eaVar.i + i > i3 ? i3 - eaVar.i : i;
                                    i = intValue < c2[0] ? c2[0] : eaVar.f + intValue > c2[1] ? c2[1] - eaVar.f : intValue;
                                    c = new int[]{i3, i};
                                }
                                if (c == null) {
                                    eaVar.a("Resize location out of screen or close button is not visible.");
                                    return;
                                }
                                n.a();
                                i2 = com.google.android.gms.ads.internal.util.client.a.a(eaVar.l, eaVar.i);
                                n.a();
                                int a = com.google.android.gms.ads.internal.util.client.a.a(eaVar.l, eaVar.f);
                                ViewParent parent = eaVar.k.getView().getParent();
                                if (parent == null || !(parent instanceof ViewGroup)) {
                                    eaVar.a("Webview is detached, probably in the middle of a resize or expand.");
                                    return;
                                }
                                ((ViewGroup) parent).removeView(eaVar.k.getView());
                                if (eaVar.p == null) {
                                    eaVar.r = (ViewGroup) parent;
                                    f.c();
                                    Bitmap a2 = fs.a(eaVar.k.getView());
                                    eaVar.n = new ImageView(eaVar.l);
                                    eaVar.n.setImageBitmap(a2);
                                    eaVar.m = eaVar.k.h();
                                    eaVar.r.addView(eaVar.n);
                                } else {
                                    eaVar.p.dismiss();
                                }
                                eaVar.q = new RelativeLayout(eaVar.l);
                                eaVar.q.setBackgroundColor(0);
                                eaVar.q.setLayoutParams(new LayoutParams(i2, a));
                                f.c();
                                eaVar.p = fs.a(eaVar.q, i2, a);
                                eaVar.p.setOutsideTouchable(true);
                                eaVar.p.setTouchable(true);
                                eaVar.p.setClippingEnabled(!eaVar.c);
                                eaVar.q.addView(eaVar.k.getView(), -1, -1);
                                eaVar.o = new LinearLayout(eaVar.l);
                                n.a();
                                i = com.google.android.gms.ads.internal.util.client.a.a(eaVar.l, 50);
                                n.a();
                                LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, com.google.android.gms.ads.internal.util.client.a.a(eaVar.l, 50));
                                String str2 = eaVar.b;
                                switch (str2.hashCode()) {
                                    case -1364013995:
                                        if (str2.equals("center")) {
                                            z = true;
                                            break;
                                        }
                                        break;
                                    case -1012429441:
                                        if (str2.equals("top-left")) {
                                            z = false;
                                            break;
                                        }
                                        break;
                                    case -655373719:
                                        if (str2.equals("bottom-left")) {
                                            z = true;
                                            break;
                                        }
                                        break;
                                    case 1163912186:
                                        if (str2.equals("bottom-right")) {
                                            z = true;
                                            break;
                                        }
                                        break;
                                    case 1288627767:
                                        if (str2.equals("bottom-center")) {
                                            z = true;
                                            break;
                                        }
                                        break;
                                    case 1755462605:
                                        if (str2.equals("top-center")) {
                                            z = true;
                                            break;
                                        }
                                        break;
                                }
                                switch (z) {
                                    case false:
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(9);
                                        break;
                                    case true:
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(14);
                                        break;
                                    case true:
                                        layoutParams.addRule(13);
                                        break;
                                    case true:
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(9);
                                        break;
                                    case true:
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(14);
                                        break;
                                    case true:
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(11);
                                        break;
                                    default:
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                        break;
                                }
                                eaVar.o.setOnClickListener(new ds(eaVar));
                                eaVar.o.setContentDescription("Close button");
                                eaVar.q.addView(eaVar.o, layoutParams);
                                try {
                                    PopupWindow popupWindow = eaVar.p;
                                    View decorView = window.getDecorView();
                                    n.a();
                                    int a3 = com.google.android.gms.ads.internal.util.client.a.a(eaVar.l, c[0]);
                                    n.a();
                                    popupWindow.showAtLocation(decorView, 0, a3, com.google.android.gms.ads.internal.util.client.a.a(eaVar.l, c[1]));
                                    eaVar.k.a(new AdSizeParcel(eaVar.l, new com.google.android.gms.ads.c(eaVar.i, eaVar.f)));
                                    intValue = c[0];
                                    i = c[1];
                                    f.c();
                                    try {
                                        eaVar.s.a("onSizeChanged", new JSONObject().put("x", intValue).put("y", i - fs.c(eaVar.l)[0]).put("width", eaVar.i).put("height", eaVar.f));
                                    } catch (Throwable e) {
                                        b.b("Error occured while dispatching size change.", e);
                                    }
                                    eaVar.b("resized");
                                    return;
                                } catch (RuntimeException e2) {
                                    eaVar.a("Cannot show popup window: " + e2.getMessage());
                                    eaVar.q.removeView(eaVar.k.getView());
                                    if (eaVar.r != null) {
                                        eaVar.r.removeView(eaVar.n);
                                        eaVar.r.addView(eaVar.k.getView());
                                        eaVar.k.a(eaVar.m);
                                    }
                                    return;
                                }
                            }
                            eaVar.a("Invalid width and height options. Cannot resize.");
                            return;
                        }
                    }
                case 3:
                    du duVar = new du(gvVar, map);
                    if (duVar.b == null) {
                        duVar.a("Activity context is not available");
                        return;
                    }
                    f.c();
                    if (fs.c(duVar.b).a()) {
                        str = (String) duVar.a.get("iurl");
                        if (TextUtils.isEmpty(str)) {
                            duVar.a("Image url cannot be empty.");
                            return;
                        } else if (URLUtil.isValidUrl(str)) {
                            String lastPathSegment = Uri.parse(str).getLastPathSegment();
                            f.c();
                            if (fs.b(lastPathSegment)) {
                                f.c();
                                Builder b2 = fs.b(duVar.b);
                                b2.setTitle(f.f().a(com.google.android.gms.b.store_picture_title, "Save image"));
                                b2.setMessage(f.f().a(com.google.android.gms.b.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                                b2.setPositiveButton(f.f().a(com.google.android.gms.b.accept, "Accept"), new dv(duVar, str, lastPathSegment));
                                b2.setNegativeButton(f.f().a(com.google.android.gms.b.decline, "Decline"), new dw(duVar));
                                b2.create().show();
                                return;
                            }
                            duVar.a("Image type not recognized: " + lastPathSegment);
                            return;
                        } else {
                            duVar.a("Invalid image url: " + str);
                            return;
                        }
                    }
                    duVar.a("Feature is not supported by the device.");
                    return;
                case 4:
                    do doVar = new do(gvVar, map);
                    if (doVar.a == null) {
                        doVar.a("Activity context is not available.");
                        return;
                    }
                    f.c();
                    if (fs.c(doVar.a).b()) {
                        f.c();
                        Builder b3 = fs.b(doVar.a);
                        b3.setTitle(f.f().a(com.google.android.gms.b.create_calendar_title, "Create calendar event"));
                        b3.setMessage(f.f().a(com.google.android.gms.b.create_calendar_message, "Allow Ad to create a calendar event?"));
                        b3.setPositiveButton(f.f().a(com.google.android.gms.b.accept, "Accept"), new dp(doVar));
                        b3.setNegativeButton(f.f().a(com.google.android.gms.b.decline, "Decline"), new dq(doVar));
                        b3.create().show();
                        return;
                    }
                    doVar.a("This feature is not available on the device.");
                    return;
                case 5:
                    dt dtVar = new dt(gvVar, map);
                    if (dtVar.a == null) {
                        b.d("AdWebView is null");
                        return;
                    }
                    intValue = "portrait".equalsIgnoreCase(dtVar.c) ? f.e().b() : "landscape".equalsIgnoreCase(dtVar.c) ? f.e().a() : dtVar.b ? -1 : f.e().c();
                    dtVar.a.setRequestedOrientation(intValue);
                    return;
                case 6:
                    this.c.a(true);
                    return;
                default:
                    b.c("Unknown MRAID command called.");
                    return;
            }
        }
        b.a("Action was blocked because no click was detected.");
    }
}
