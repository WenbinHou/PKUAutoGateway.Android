package com.kaopiz.kprogresshud;

import android.content.Context;

final class d {
    private static float a;

    public static int a(float f, Context context) {
        if (a == 0.0f) {
            a = context.getResources().getDisplayMetrics().density;
        }
        return (int) (a * f);
    }
}
