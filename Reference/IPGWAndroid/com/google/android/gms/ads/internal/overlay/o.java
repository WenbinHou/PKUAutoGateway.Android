package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.gv;
import com.google.android.gms.common.internal.a;
import java.util.HashMap;
import java.util.Map;

@fd
public final class o extends FrameLayout {
    public final gv a;
    final FrameLayout b;
    public final v c;
    public m d;
    public boolean e;
    public boolean f;
    TextView g;
    long h;
    public String i;
    private String j;

    public o(Context context, gv gvVar) {
        super(context);
        this.a = gvVar;
        this.b = new FrameLayout(context);
        addView(this.b, new LayoutParams(-1, -1));
        a.a(gvVar.e());
        this.d = gvVar.e().b.a();
        if (this.d != null) {
            this.b.addView(this.d, new LayoutParams(-1, -1, 17));
        }
        this.g = new TextView(context);
        this.g.setBackgroundColor(-16777216);
        if (!c()) {
            this.b.addView(this.g, new LayoutParams(-1, -1));
            this.b.bringChildToFront(this.g);
        }
        this.c = new v(this);
        this.c.a();
        if (this.d == null) {
            a("error", "what", "AdVideoUnderlay Error", "extra", "Allocating player failed.");
        }
    }

    public static void a(gv gvVar) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        gvVar.a("onVideoEvent", hashMap);
    }

    public final void a() {
        if (this.d != null) {
            if (TextUtils.isEmpty(this.i)) {
                a("no_src", new String[0]);
                return;
            }
            this.d.setMimeType(this.j);
            this.d.setVideoPath(this.i);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    final void a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.a.a("onVideoEvent", hashMap);
    }

    public final void b() {
        if (this.d != null) {
            View textView = new TextView(this.d.getContext());
            textView.setText("AdMob - " + this.d.a());
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.b.addView(textView, new LayoutParams(-2, -2, 17));
            this.b.bringChildToFront(textView);
        }
    }

    final boolean c() {
        return this.g.getParent() != null;
    }

    public final void setMimeType(String str) {
        this.j = str;
    }
}
