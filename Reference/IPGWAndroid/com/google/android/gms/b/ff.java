package com.google.android.gms.b;

import java.util.Map;

public final class ff {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final boolean d;
    public final long e;

    public ff(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        this.d = z;
        this.e = j;
    }

    public ff(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }
}
