package com.google.android.gms.b;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.a;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

@fd
public final class fg {
    final Object a = new Object();
    Boolean b = null;
    private final String c = fs.a();
    private final fh d = new fh(this.c);
    private BigInteger e = BigInteger.ONE;
    private final HashSet<Object> f = new HashSet();
    private final HashMap<String, Object> g = new HashMap();
    private boolean h = false;
    private boolean i = true;
    private int j = 0;
    private boolean k = false;
    private Context l;
    private VersionInfoParcel m;
    private al n = null;
    private boolean o = true;
    private l p = null;
    private m q = null;
    private k r = null;
    private final LinkedList<Thread> s = new LinkedList();
    private final fc t = null;
    private String u;
    private boolean v = false;
    private boolean w = false;

    public final al a() {
        al alVar;
        synchronized (this.a) {
            alVar = this.n;
        }
        return alVar;
    }

    public final String a(int i, String str) {
        Resources resources = this.m.e ? this.l.getResources() : a.a(this.l);
        return resources == null ? str : resources.getString(i);
    }

    public final void a(Throwable th, boolean z) {
        new fc(this.l, this.m).a(th, z);
    }

    public final String b() {
        String str;
        synchronized (this.a) {
            str = this.u;
        }
        return str;
    }

    public final Boolean c() {
        Boolean bool;
        synchronized (this.a) {
            bool = this.b;
        }
        return bool;
    }
}
