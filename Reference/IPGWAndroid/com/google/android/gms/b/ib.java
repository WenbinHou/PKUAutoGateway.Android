package com.google.android.gms.b;

import android.os.SystemClock;

public final class ib implements ia {
    public final long a() {
        return System.currentTimeMillis();
    }

    public final long b() {
        return SystemClock.elapsedRealtime();
    }
}
