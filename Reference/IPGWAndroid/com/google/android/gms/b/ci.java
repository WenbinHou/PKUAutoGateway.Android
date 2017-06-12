package com.google.android.gms.b;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.overlay.o;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.c;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@fd
public final class ci implements cb {
    private final Map<gv, Integer> a = new WeakHashMap();

    private static int a(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                n.a();
                i = a.a(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                b.d("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public final void a(gv gvVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            b.d("Action missing from video GMSG.");
            return;
        }
        if (b.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            b.a("Video GMSG: " + str + " " + jSONObject.toString());
        }
        int parseColor;
        gu q;
        o a;
        if ("background".equals(str)) {
            str = (String) map.get("color");
            if (TextUtils.isEmpty(str)) {
                b.d("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                parseColor = Color.parseColor(str);
                q = gvVar.q();
                if (q != null) {
                    a = q.a();
                    if (a != null) {
                        a.setBackgroundColor(parseColor);
                        return;
                    }
                }
                this.a.put(gvVar, Integer.valueOf(parseColor));
                return;
            } catch (IllegalArgumentException e) {
                b.d("Invalid color parameter in video GMSG.");
                return;
            }
        }
        q = gvVar.q();
        if (q == null) {
            b.d("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int a2;
        if (equals || equals2) {
            Context context = gvVar.getContext();
            a2 = a(context, map, "x", 0);
            int a3 = a(context, map, "y", 0);
            int a4 = a(context, map, "w", -1);
            int a5 = a(context, map, "h", -1);
            try {
                Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
            }
            if (equals && q.a() == null) {
                if (q.d == null) {
                    an.a(q.a.s().b, q.a.r(), "vpr");
                    an.a(q.a.s().b);
                    q.d = new o(q.b, q.a);
                    q.c.addView(q.d, 0, new LayoutParams(-1, -1));
                    q.d.a(a2, a3, a4, a5);
                    q.a.i().i = false;
                }
                if (this.a.containsKey(gvVar)) {
                    parseColor = ((Integer) this.a.get(gvVar)).intValue();
                    a = q.a();
                    a.setBackgroundColor(parseColor);
                    a.b();
                    return;
                }
                return;
            }
            c.a("The underlay may only be modified from the UI thread.");
            if (q.d != null) {
                q.d.a(a2, a3, a4, a5);
                return;
            }
            return;
        }
        o a6 = q.a();
        if (a6 == null) {
            o.a(gvVar);
        } else if ("click".equals(str)) {
            context = gvVar.getContext();
            int a7 = a(context, map, "x", 0);
            a2 = a(context, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a7, (float) a2, 0);
            if (a6.d != null) {
                a6.d.dispatchTouchEvent(obtain);
            }
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            str = (String) map.get("time");
            if (str == null) {
                b.d("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                Float.parseFloat(str);
            } catch (NumberFormatException e3) {
                b.d("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equals(str)) {
            a6.setVisibility(4);
        } else if ("load".equals(str)) {
            a6.a();
        } else if ("mimetype".equals(str)) {
            a6.setMimeType((String) map.get("mimetype"));
        } else if ("muted".equals(str)) {
            Boolean.parseBoolean((String) map.get("muted"));
        } else if (!"pause".equals(str) && !"play".equals(str)) {
            if ("show".equals(str)) {
                a6.setVisibility(0);
            } else if ("src".equals(str)) {
                a6.i = (String) map.get("src");
            } else if ("volume".equals(str)) {
                str = (String) map.get("volume");
                if (str == null) {
                    b.d("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    Float.parseFloat(str);
                } catch (NumberFormatException e4) {
                    b.d("Could not parse volume parameter from volume video GMSG: " + str);
                }
            } else if ("watermark".equals(str)) {
                a6.b();
            } else {
                b.d("Unknown video action: " + str);
            }
        }
    }
}
