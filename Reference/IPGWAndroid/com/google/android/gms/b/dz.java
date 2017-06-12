package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;
import org.json.JSONObject;

@fd
public final class dz extends ea implements cb {
    DisplayMetrics a;
    int b = -1;
    int c = -1;
    int d = -1;
    int e = -1;
    int f = -1;
    int g = -1;
    private final gv h;
    private final Context i;
    private final WindowManager j;
    private final aa k;
    private float l;
    private int m;

    public dz(gv gvVar, Context context, aa aaVar) {
        super(gvVar);
        this.h = gvVar;
        this.i = context;
        this.k = aaVar;
        this.j = (WindowManager) context.getSystemService("window");
    }

    public final void a(gv gvVar, Map<String, String> map) {
        int[] a;
        int i;
        this.a = new DisplayMetrics();
        Display defaultDisplay = this.j.getDefaultDisplay();
        defaultDisplay.getMetrics(this.a);
        this.l = this.a.density;
        this.m = defaultDisplay.getRotation();
        n.a();
        this.b = a.b(this.a, this.a.widthPixels);
        n.a();
        this.c = a.b(this.a, this.a.heightPixels);
        Activity c = this.h.c();
        if (c == null || c.getWindow() == null) {
            this.d = this.b;
            this.e = this.c;
        } else {
            f.c();
            a = fs.a(c);
            n.a();
            this.d = a.b(this.a, a[0]);
            n.a();
            this.e = a.b(this.a, a[1]);
        }
        if (this.h.h().e) {
            this.f = this.b;
            this.g = this.c;
        } else {
            this.h.measure(0, 0);
            n.a();
            this.f = a.b(this.i, this.h.getMeasuredWidth());
            n.a();
            this.g = a.b(this.i, this.h.getMeasuredHeight());
        }
        a(this.b, this.c, this.d, this.e, this.l, this.m);
        dy dyVar = new dy();
        aa aaVar = this.k;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        dyVar.b = aaVar.a(intent);
        aaVar = this.k;
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        dyVar.a = aaVar.a(intent);
        dyVar.c = this.k.b();
        dyVar.d = this.k.a();
        dyVar.e = true;
        this.h.a("onDeviceFeaturesReceived", new dx(dyVar).a());
        a = new int[2];
        this.h.getLocationOnScreen(a);
        n.a();
        int b = a.b(this.i, a[0]);
        n.a();
        int b2 = a.b(this.i, a[1]);
        if (this.i instanceof Activity) {
            f.c();
            i = fs.c((Activity) this.i)[0];
        } else {
            i = 0;
        }
        i = b2 - i;
        int i2 = this.f;
        try {
            this.s.a("onDefaultPositionReceived", new JSONObject().put("x", b).put("y", i).put("width", i2).put("height", this.g));
        } catch (Throwable e) {
            b.b("Error occured while dispatching default position.", e);
        }
        gw i3 = this.h.i();
        if (i3.o != null) {
            dr drVar = i3.o;
            drVar.d = b;
            drVar.e = b2;
        }
        if (b.a(2)) {
            b.c("Dispatching Ready Event.");
        }
        try {
            this.s.a("onReadyEventReceived", new JSONObject().put("js", this.h.l().b));
        } catch (Throwable e2) {
            b.b("Error occured while dispatching ready Event.", e2);
        }
    }
}
