package com.google.android.gms.b;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

@fd
public final class do extends ea {
    final Context a;
    String b = c("description");
    long c = d("start_ticks");
    long d = d("end_ticks");
    String e = c("summary");
    String f = c("location");
    private final Map<String, String> g;

    public do(gv gvVar, Map<String, String> map) {
        super(gvVar, "createCalendarEvent");
        this.g = map;
        this.a = gvVar.c();
    }

    private String c(String str) {
        return TextUtils.isEmpty((CharSequence) this.g.get(str)) ? "" : (String) this.g.get(str);
    }

    private long d(String str) {
        String str2 = (String) this.g.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
