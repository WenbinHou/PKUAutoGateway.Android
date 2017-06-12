package com.b.a.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

public final class g {
    private static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        Object a = f.a(currentTimeMillis);
        Object a2 = f.a(nanoTime);
        Object a3 = f.a(nextInt);
        Object a4 = f.a(nextInt2);
        Object obj = new byte[16];
        System.arraycopy(a, 0, obj, 0, 4);
        System.arraycopy(a2, 0, obj, 4, 4);
        System.arraycopy(a3, 0, obj, 8, 4);
        System.arraycopy(a4, 0, obj, 12, 4);
        return b.a(obj, 2);
    }

    public static String a(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str = telephonyManager != null ? telephonyManager.getDeviceId() : null;
            } catch (Exception e) {
            }
        }
        return h.a(str) ? a() : str;
    }

    public static String b(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str = telephonyManager != null ? telephonyManager.getSubscriberId() : null;
            } catch (Exception e) {
            }
        }
        return h.a(str) ? a() : str;
    }
}
