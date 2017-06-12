package com.google.android.gms.b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@fd
public final class aw {
    boolean a = true;
    final Object b = new Object();
    aw c;
    private final List<as> d = new LinkedList();
    private final Map<String, String> e = new LinkedHashMap();

    public aw(String str, String str2) {
        this.e.put("action", str);
        this.e.put("ad_format", str2);
    }

    public final as a(long j) {
        return !this.a ? null : new as(j, null, null);
    }

    public final void a(String str, String str2) {
        if (this.a && !TextUtils.isEmpty(str2)) {
            al a = f.f().a();
            if (a != null) {
                synchronized (this.b) {
                    ao aoVar = (ao) a.b.get(str);
                    ao aoVar2 = aoVar != null ? aoVar : ao.a;
                    Map map = this.e;
                    map.put(str, aoVar2.a((String) map.get(str), str2));
                }
            }
        }
    }

    public final boolean a(as asVar, long j, String... strArr) {
        synchronized (this.b) {
            for (String asVar2 : strArr) {
                this.d.add(new as(j, asVar2, asVar));
            }
        }
        return true;
    }
}
