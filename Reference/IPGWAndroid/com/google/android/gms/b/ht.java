package com.google.android.gms.b;

final class ht implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ hs c;

    ht(hs hsVar, String str, long j) {
        this.c = hsVar;
        this.a = str;
        this.b = j;
    }

    public final void run() {
        this.c.a.a(this.a, this.b);
        this.c.a.a(toString());
    }
}
