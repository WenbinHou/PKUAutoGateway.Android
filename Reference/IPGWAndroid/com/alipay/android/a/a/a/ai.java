package com.alipay.android.a.a.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class ai implements InvocationHandler {
    protected p a;
    protected Class<?> b;
    protected aj c;

    public ai(p pVar, Class<?> cls, aj ajVar) {
        this.a = pVar;
        this.b = cls;
        this.c = ajVar;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.c.a(method, objArr);
    }
}
