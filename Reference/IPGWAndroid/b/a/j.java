package b.a;

import b.a.d.e;
import b.a.d.f;
import b.aj;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class j {
    private static final j a = c();

    public static j a() {
        return a;
    }

    static <T> T a(Object obj, Class<T> cls, String str) {
        do {
            Class cls2 = obj.getClass();
            while (cls2 != Object.class) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    return (obj2 == null || !cls.isInstance(obj2)) ? null : cls.cast(obj2);
                } catch (NoSuchFieldException e) {
                    cls2 = cls2.getSuperclass();
                } catch (IllegalAccessException e2) {
                    throw new AssertionError();
                }
            }
            if (str.equals("delegate")) {
                break;
            }
            obj = a(obj, Object.class, "delegate");
        } while (obj != null);
        return null;
    }

    public static String b() {
        return "OkHttp";
    }

    private static j c() {
        Class cls;
        i iVar;
        i iVar2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        try {
            i iVar3 = new i(null, "setUseSessionTickets", Boolean.TYPE);
            i iVar4 = new i(null, "setHostname", String.class);
            i iVar5;
            try {
                Class.forName("android.net.Network");
                iVar5 = new i(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                try {
                    iVar = new i(null, "setAlpnProtocols", byte[].class);
                    iVar2 = iVar5;
                } catch (ClassNotFoundException e2) {
                    iVar = null;
                    iVar2 = iVar5;
                    return new k(cls, iVar3, iVar4, iVar2, iVar);
                }
            } catch (ClassNotFoundException e3) {
                iVar5 = null;
                iVar = null;
                iVar2 = iVar5;
                return new k(cls, iVar3, iVar4, iVar2, iVar);
            }
            return new k(cls, iVar3, iVar4, iVar2, iVar);
        } catch (ClassNotFoundException e4) {
            try {
                String str = "org.eclipse.jetty.alpn.ALPN";
                Class cls2 = Class.forName(str);
                cls = Class.forName(str + "$Provider");
                Class cls3 = Class.forName(str + "$ClientProvider");
                Class cls4 = Class.forName(str + "$ServerProvider");
                return new l(cls2.getMethod("put", new Class[]{SSLSocket.class, cls}), cls2.getMethod("get", new Class[]{SSLSocket.class}), cls2.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
            } catch (ClassNotFoundException e5) {
                return new j();
            } catch (NoSuchMethodException e6) {
                return new j();
            }
        }
    }

    public f a(X509TrustManager x509TrustManager) {
        return new e(x509TrustManager.getAcceptedIssuers());
    }

    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object a = a((Object) sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            return a == null ? null : (X509TrustManager) a(a, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<aj> list) {
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }
}
