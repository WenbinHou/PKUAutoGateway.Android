package com.a.a;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;

public final class n implements aa {
    private final Gson a;

    public n(Gson gson) {
        this.a = gson;
    }

    public final <T> T a(String str, Type type) {
        return TextUtils.isEmpty(str) ? null : this.a.fromJson(str, type);
    }

    public final String a(Object obj) {
        return this.a.toJson(obj);
    }
}
