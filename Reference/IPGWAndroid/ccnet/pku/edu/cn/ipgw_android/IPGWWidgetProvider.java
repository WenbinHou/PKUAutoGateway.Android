package ccnet.pku.edu.cn.ipgw_android;

import a.a.a.a;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.RemoteViews;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import com.a.a.o;
import com.a.a.p;
import com.a.a.r;
import com.a.a.y;

public class IPGWWidgetProvider extends AppWidgetProvider {
    private static String a(Context context) {
        try {
            return "IPGWAndroid" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + "_" + fn.a + "_" + fm.g(context);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    static void a(Context context, String str) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.ipgw_appwidget);
        remoteViews.setTextViewText(R.id.widget_title, context.getResources().getString(R.string.app_fullname));
        remoteViews.setTextViewText(R.id.widget_connect_free, context.getResources().getString(R.string.today_connect_free));
        remoteViews.setTextViewText(R.id.widget_connect_notfree, context.getResources().getString(R.string.today_connect_notfree));
        remoteViews.setTextViewText(R.id.widget_disconnect, context.getResources().getString(R.string.today_disconnect));
        remoteViews.setTextViewText(R.id.widget_disconnectall, context.getResources().getString(R.string.today_disconnectall));
        remoteViews.setTextViewText(R.id.widget_info, str);
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, IPGWWidgetProvider.class), remoteViews);
    }

    private void a(Context context, boolean z) {
        String b = fm.b(context);
        if (!o.a()) {
            p a = o.a(context);
            a.a = r.b;
            a.c = p.a(context);
            a.b = y.a;
            a.b();
        }
        String a2 = fm.a();
        if (b.equals("") || a2.equals("")) {
            a(context, context.getResources().getString(R.string.today_store_username_passwd));
            return;
        }
        String a3 = fm.a(context);
        ap a4 = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=open&username=" + b + "&password=" + a2 + "&iprange=" + (!z ? "fee" : "free") + "&ip=" + (a3.equals("") ? "" : a3) + "&lang=" + fn.b() + "&app=" + a(context));
        String str = "https://its.pku.edu.cn/cas/ITSClient";
        ag a5 = fn.a();
        try {
            a(context, context.getResources().getString(R.string.today_wait));
            a5.a(new ao().a(str).a("User-Agent", a(context)).a("POST", a4).a()).a(new et(this, context, b));
        } catch (Exception e) {
        }
    }

    private PendingIntent b(Context context, String str) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(str);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if ("clickConnectFree".equals(intent.getAction())) {
            a(context, true);
        } else if ("clickConnectNotFree".equals(intent.getAction())) {
            a(context, false);
        } else if ("clickConnectDisconnect".equals(intent.getAction())) {
            ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=close&lang=" + fn.b());
            r1 = "https://its.pku.edu.cn/cas/ITSClient";
            ag a2 = fn.a();
            try {
                a(context, context.getResources().getString(R.string.today_wait));
                a2.a(new ao().a(r1).a("User-Agent", a(context)).a("POST", a).a()).a(new ef(this, context));
            } catch (Exception e) {
            }
        } else if ("clickConnectDisconnectAll".equals(intent.getAction())) {
            String b = fm.b(context);
            if (!o.a()) {
                p a3 = o.a(context);
                a3.a = r.b;
                a3.c = p.a(context);
                a3.b = y.a;
                a3.b();
            }
            r1 = fm.a();
            if (b.equals("") || r1.equals("")) {
                a(context, context.getResources().getString(R.string.today_store_username_passwd));
                return;
            }
            ap a4 = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=closeall&username=" + b + "&password=" + r1 + "&lang=" + fn.b());
            String str = "https://its.pku.edu.cn/cas/ITSClient";
            ag a5 = fn.a();
            try {
                a(context, context.getResources().getString(R.string.today_wait));
                a5.a(new ao().a(str).a("User-Agent", a(context)).a("POST", a4).a()).a(new em(this, context, b));
            } catch (Exception e2) {
            }
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        if (!o.a()) {
            p a = o.a(context);
            a.a = r.b;
            a.c = p.a(context);
            a.b = y.a;
            a.b();
        }
        if (fn.a.equals("")) {
            a aVar = new a(context);
            String a2 = aVar.a();
            String b = aVar.b();
            if (a2 == null) {
                a2 = "";
            }
            if (b == null) {
                b = "";
            }
            fn.a = a2 + b;
        }
        for (int i : iArr) {
            PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.ipgw_appwidget);
            remoteViews.setTextViewText(R.id.widget_title, context.getResources().getString(R.string.app_fullname));
            remoteViews.setTextViewText(R.id.widget_connect_free, context.getResources().getString(R.string.today_connect_free));
            remoteViews.setTextViewText(R.id.widget_connect_notfree, context.getResources().getString(R.string.today_connect_notfree));
            remoteViews.setTextViewText(R.id.widget_disconnect, context.getResources().getString(R.string.today_disconnect));
            remoteViews.setTextViewText(R.id.widget_disconnectall, context.getResources().getString(R.string.today_disconnectall));
            remoteViews.setOnClickPendingIntent(R.id.widget_icon, activity);
            remoteViews.setOnClickPendingIntent(R.id.widget_title, activity);
            remoteViews.setOnClickPendingIntent(R.id.widget_info, activity);
            remoteViews.setOnClickPendingIntent(R.id.widget_connect_free, b(context, "clickConnectFree"));
            remoteViews.setOnClickPendingIntent(R.id.widget_connect_notfree, b(context, "clickConnectNotFree"));
            remoteViews.setOnClickPendingIntent(R.id.widget_disconnect, b(context, "clickConnectDisconnect"));
            remoteViews.setOnClickPendingIntent(R.id.widget_disconnectall, b(context, "clickConnectDisconnectAll"));
            String b2 = fm.b(context);
            String a3 = fm.a();
            if (b2.equals("") || a3.equals("")) {
                remoteViews.setTextViewText(R.id.widget_info, context.getResources().getString(R.string.today_store_username_passwd));
            } else {
                remoteViews.setTextViewText(R.id.widget_info, context.getResources().getString(R.string.today_currentuser) + " " + b2);
            }
            appWidgetManager.updateAppWidget(i, remoteViews);
        }
    }
}
