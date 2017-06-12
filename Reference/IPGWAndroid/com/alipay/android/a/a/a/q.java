package com.alipay.android.a.a.a;

import android.content.Context;
import java.lang.reflect.Proxy;

public final class q extends ag {
    Context a;

    public q(Context context) {
        this.a = context;
    }

    public final <T> T a(Class<T> cls, e eVar) {
        ah ahVar = new ah(new r(this, eVar));
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ai(ahVar.a, cls, ahVar.b));
    }
}
