package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.a.a.i;
import com.a.a.o;
import com.a.a.x;
import java.util.UUID;

public final class fm {
    public static String a() {
        try {
            String str = "";
            String a = o.a("store_passwd");
            if (a != null) {
                str = a;
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(Context context) {
        return context.getSharedPreferences("preference_file_key", 0).getString("store_latest_ip", "");
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("preference_file_key", 0);
        if (!a(context).equals(str)) {
            Editor edit = sharedPreferences.edit();
            edit.putString("store_latest_ip", str);
            edit.commit();
        }
    }

    public static void a(String str) {
        Object obj = null;
        Object obj2 = "store_passwd";
        x.a("Key", obj2);
        x.a();
        if (str == null) {
            x.a();
            o.a.b.b(obj2);
            return;
        }
        x.a("Value", (Object) str);
        byte[] a = o.a.c.a(str);
        if (!(a == null || a.length == 0)) {
            String a2 = o.a.d.a(a);
            if (a2 != null) {
                obj = i.a(a2, (Object) str);
            }
        }
        if (obj != null) {
            o.a.b.a(obj2, obj);
        }
    }

    public static String b(Context context) {
        return context.getSharedPreferences("preference_file_key", 0).getString("store_username", "");
    }

    public static void b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("preference_file_key", 0);
        if (!b(context).equals(str)) {
            Editor edit = sharedPreferences.edit();
            edit.putString("store_username", str);
            edit.commit();
        }
    }

    public static String c(Context context) {
        return context.getSharedPreferences("preference_file_key", 0).getString("store_needstore_username", "");
    }

    public static void c(Context context, String str) {
        Editor edit = context.getSharedPreferences("preference_file_key", 0).edit();
        edit.putString("store_needstore_username", str);
        edit.commit();
    }

    public static String d(Context context) {
        return context.getSharedPreferences("preference_file_key", 0).getString("store_needstore_passwd", "");
    }

    public static void d(Context context, String str) {
        Editor edit = context.getSharedPreferences("preference_file_key", 0).edit();
        edit.putString("store_needstore_passwd", str);
        edit.commit();
    }

    public static String e(Context context) {
        return context.getSharedPreferences("preference_file_key", 0).getString("store_language", "");
    }

    public static void e(Context context, String str) {
        Editor edit = context.getSharedPreferences("preference_file_key", 0).edit();
        edit.putString("store_language", str);
        edit.commit();
    }

    public static String f(Context context) {
        return context.getSharedPreferences("preference_file_key", 0).getString("store_range", "");
    }

    public static void f(Context context, String str) {
        Editor edit = context.getSharedPreferences("preference_file_key", 0).edit();
        edit.putString("store_range", str);
        edit.commit();
    }

    public static String g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("preference_file_key", 0);
        String string = sharedPreferences.getString("store_install_id", "");
        if (!string.equals("")) {
            return string;
        }
        string = UUID.randomUUID().toString();
        Editor edit = sharedPreferences.edit();
        edit.putString("store_install_id", string);
        edit.commit();
        return string;
    }
}
