package b.a;

import b.aj;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

final class l extends j {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;

    public l(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.a = method;
        this.b = method2;
        this.c = method3;
        this.d = cls;
        this.e = cls2;
    }

    public final void a(SSLSocket sSLSocket) {
        try {
            this.c.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List<aj> list) {
        List arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            aj ajVar = (aj) list.get(i);
            if (ajVar != aj.HTTP_1_0) {
                arrayList.add(ajVar.toString());
            }
        }
        Object newProxyInstance;
        try {
            newProxyInstance = Proxy.newProxyInstance(j.class.getClassLoader(), new Class[]{this.d, this.e}, new m(arrayList));
            this.a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e) {
            newProxyInstance = e;
            throw new AssertionError(newProxyInstance);
        } catch (IllegalAccessException e2) {
            newProxyInstance = e2;
            throw new AssertionError(newProxyInstance);
        }
    }

    public final String b(SSLSocket sSLSocket) {
        try {
            m mVar = (m) Proxy.getInvocationHandler(this.b.invoke(null, new Object[]{sSLSocket}));
            if (mVar.b || mVar.c != null) {
                return mVar.b ? null : mVar.c;
            } else {
                f.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            }
        } catch (InvocationTargetException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }
}
