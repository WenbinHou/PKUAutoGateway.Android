package com.alipay.e.a.a.d;

import android.os.Environment;
import com.alipay.e.a.a.d.a.a;
import java.io.File;

public final class b {
    public static String a(String str) {
        try {
            if (a()) {
                File file = new File(Environment.getExternalStorageDirectory(), str);
                if (file.exists()) {
                    return a.b(file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static boolean a() {
        String externalStorageState = Environment.getExternalStorageState();
        return externalStorageState != null && externalStorageState.length() > 0 && ((externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null);
    }
}
