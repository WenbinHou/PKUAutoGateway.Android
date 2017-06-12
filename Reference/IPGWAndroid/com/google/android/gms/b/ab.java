package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.f;

@fd
public abstract class ab<T> {
    final String a;
    final T b;
    private final int c;

    private ab(int i, String str, T t) {
        this.c = i;
        this.a = str;
        this.b = t;
        f.h().a.add(this);
    }

    public static ab<String> a(int i, String str) {
        ab<String> a = a(i, str, null);
        f.h().b.add(a);
        return a;
    }

    public static ab<Integer> a(int i, String str, int i2) {
        return new ad(i, str, Integer.valueOf(i2));
    }

    public static ab<Boolean> a(int i, String str, Boolean bool) {
        return new ac(i, str, bool);
    }

    public static ab<String> a(int i, String str, String str2) {
        return new af(i, str, str2);
    }

    public static ab<String> a(String str) {
        ab<String> a = a(0, str, null);
        f.h().c.add(a);
        return a;
    }

    public static ab<Long> a(String str, long j) {
        return new ae(str, Long.valueOf(j));
    }

    protected abstract T a(SharedPreferences sharedPreferences);
}
