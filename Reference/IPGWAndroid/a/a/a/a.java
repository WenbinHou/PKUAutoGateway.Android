package a.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

public final class a {
    private final Context a;
    private final TelephonyManager b;
    private final String c = "na";

    public a(Context context) {
        this.a = context;
        this.b = (TelephonyManager) context.getSystemService("phone");
    }

    public final String a() {
        String str = this.c;
        try {
            str = Build.BRAND;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str == null || str.length() == 0) {
            str = this.c;
        }
        return str.indexOf(" ") > 0 ? str.replaceAll(" ", "_") : str;
    }

    public final String b() {
        String str = this.c;
        try {
            str = VERSION.RELEASE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (str == null || str.length() == 0) ? this.c : str;
    }
}
