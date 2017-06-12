package com.a.a;

import android.util.Log;

final class z {
    static void a(int i, String str) {
        if ((o.a == null ? y.a : o.a.e) != y.a) {
            int length = str != null ? str.length() : 0;
            if (length == 0) {
                return;
            }
            if (length <= 4000) {
                b(i, str);
                return;
            }
            for (int i2 = 0; i2 < length; i2 += 4000) {
                b(i, str.substring(i2, Math.min(length, i2 + 4000)));
            }
        }
    }

    private static void b(int i, String str) {
        switch (i) {
            case 2:
                Log.v("Hawk", str);
                return;
            case 4:
                Log.i("Hawk", str);
                return;
            case 5:
                Log.w("Hawk", str);
                return;
            case 6:
                Log.e("Hawk", str, null);
                return;
            case 7:
                Log.wtf("Hawk", str);
                return;
            default:
                Log.d("Hawk", str);
                return;
        }
    }
}
