package com.alipay.android.a.a.a;

import android.os.Looper;
import com.alipay.android.a.a.a.a.d;
import com.alipay.android.a.a.a.a.e;
import com.alipay.android.a.a.a.a.f;
import com.alipay.c.a.a.a.a;
import com.alipay.c.a.a.a.b;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class aj {
    private static final ThreadLocal<Object> a = new ThreadLocal();
    private static final ThreadLocal<Map<String, Object>> b = new ThreadLocal();
    private byte c = (byte) 0;
    private AtomicInteger d;
    private ah e;

    public aj(ah ahVar) {
        this.e = ahVar;
        this.d = new AtomicInteger();
    }

    public final Object a(Method method, Object[] objArr) {
        boolean z = true;
        boolean z2 = Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
        if (z2) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        a aVar = (a) method.getAnnotation(a.class);
        if (method.getAnnotation(b.class) == null) {
            z = false;
        }
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        a.set(null);
        b.set(null);
        if (aVar == null) {
            throw new IllegalStateException("OperationType must be set.");
        }
        String a = aVar.a();
        int incrementAndGet = this.d.incrementAndGet();
        try {
            if (this.c == (byte) 0) {
                f eVar = new e(incrementAndGet, a, objArr);
                if (b.get() != null) {
                    eVar.a(b.get());
                }
                byte[] bArr = (byte[]) new s(this.e.a, method, incrementAndGet, a, eVar.a(), z).a();
                b.set(null);
                Object a2 = new d(genericReturnType, bArr).a();
                if (genericReturnType != Void.TYPE) {
                    a.set(a2);
                }
            }
            return a.get();
        } catch (c e) {
            e.a = a;
            throw e;
        }
    }
}
