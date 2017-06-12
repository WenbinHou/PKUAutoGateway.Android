package com.alipay.android.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class aa implements Callable<ae> {
    private static final HttpRequestRetryHandler e = new h();
    protected v a;
    protected Context b;
    protected y c;
    String d;
    private HttpUriRequest f;
    private HttpContext g = new BasicHttpContext();
    private CookieStore h = new BasicCookieStore();
    private CookieManager i;
    private AbstractHttpEntity j;
    private HttpHost k;
    private URL l;
    private int m = 0;
    private boolean n = false;
    private boolean o = false;
    private String p = null;
    private String q;

    public aa(v vVar, y yVar) {
        this.a = vVar;
        this.b = this.a.a;
        this.c = yVar;
    }

    private static long a(String[] strArr) {
        int i = 0;
        while (i < strArr.length) {
            if ("max-age".equalsIgnoreCase(strArr[i]) && strArr[i + 1] != null) {
                try {
                    return Long.parseLong(strArr[i + 1]);
                } catch (Exception e) {
                }
            }
            i++;
        }
        return 0;
    }

    private ae a(HttpResponse httpResponse, int i, String str) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        String str2 = null;
        new StringBuilder("开始handle，handleResponse-1,").append(Thread.currentThread().getId());
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null && httpResponse.getStatusLine().getStatusCode() == 200) {
            new StringBuilder("200，开始处理，handleResponse-2,threadid = ").append(Thread.currentThread().getId());
            try {
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    String str3;
                    long currentTimeMillis = System.currentTimeMillis();
                    a(entity, byteArrayOutputStream2);
                    byte[] toByteArray = byteArrayOutputStream2.toByteArray();
                    this.o = false;
                    v vVar = this.a;
                    vVar.e = (System.currentTimeMillis() - currentTimeMillis) + vVar.e;
                    vVar = this.a;
                    vVar.c = ((long) toByteArray.length) + vVar.c;
                    new StringBuilder("res:").append(toByteArray.length);
                    ae zVar = new z(a(httpResponse), i, str, toByteArray);
                    currentTimeMillis = b(httpResponse);
                    Header contentType = httpResponse.getEntity().getContentType();
                    if (contentType != null) {
                        HashMap a = a(contentType.getValue());
                        str2 = (String) a.get("charset");
                        str3 = (String) a.get("Content-Type");
                    } else {
                        str3 = null;
                    }
                    zVar.a(str3);
                    zVar.c = str2;
                    zVar.a = System.currentTimeMillis();
                    zVar.b = currentTimeMillis;
                    try {
                        byteArrayOutputStream2.close();
                        return zVar;
                    } catch (IOException e) {
                        throw new RuntimeException("ArrayOutputStream close error!", e.getCause());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    OutputStream outputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                byteArrayOutputStream = null;
                th = th4;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } else if (entity != null) {
            return null;
        } else {
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
    }

    private static b a(HttpResponse httpResponse) {
        b bVar = new b();
        for (Header header : httpResponse.getAllHeaders()) {
            bVar.a.put(header.getName(), header.getValue());
        }
        return bVar;
    }

    private static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str2 : str.split(";")) {
            String[] split = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split[0], split[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        Closeable a = i.a(httpEntity);
        long contentLength = httpEntity.getContentLength();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = a.read(bArr);
                if (read == -1 || this.c.f) {
                    outputStream.flush();
                } else {
                    outputStream.write(bArr, 0, read);
                    if (this.c.a() != null && contentLength > 0) {
                    }
                }
            }
            outputStream.flush();
            ab.a(a);
        } catch (Exception e) {
            e.getCause();
            throw new IOException("HttpWorker Request Error!" + e.getLocalizedMessage());
        } catch (Throwable th) {
            ab.a(a);
        }
    }

    private static long b(HttpResponse httpResponse) {
        long j = 0;
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException e) {
                }
            }
        }
        firstHeader = httpResponse.getFirstHeader("Expires");
        return firstHeader != null ? i.b(firstHeader.getValue()) - System.currentTimeMillis() : j;
    }

    private URI b() {
        String str = this.c.a;
        if (this.d != null) {
            str = this.d;
        }
        if (str != null) {
            return new URI(str);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        if (this.f != null) {
            return this.f;
        }
        if (this.j == null) {
            byte[] bArr = this.c.b;
            CharSequence a = this.c.a("gzip");
            if (bArr != null) {
                if (TextUtils.equals(a, "true")) {
                    this.j = i.a(bArr);
                } else {
                    this.j = new ByteArrayEntity(bArr);
                }
                this.j.setContentType(this.c.c);
            }
        }
        HttpEntity httpEntity = this.j;
        if (httpEntity != null) {
            HttpUriRequest httpPost = new HttpPost(b());
            httpPost.setEntity(httpEntity);
            this.f = httpPost;
        } else {
            this.f = new HttpGet(b());
        }
        return this.f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ae d() {
        ae a;
        while (true) {
            try {
                int i;
                int statusCode;
                NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getAllNetworkInfo();
                if (allNetworkInfo == null) {
                    i = 0;
                } else {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                }
                if (i != 0) {
                    Object httpHost;
                    HttpHost httpHost2;
                    URL h;
                    HttpResponse execute;
                    long currentTimeMillis;
                    v vVar;
                    List<Cookie> cookies;
                    String reasonPhrase;
                    ArrayList arrayList = this.c.d;
                    if (!(arrayList == null || arrayList.isEmpty())) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            c().addHeader((Header) it.next());
                        }
                    }
                    i.a(c());
                    i.b(c());
                    c().addHeader("cookie", i().getCookie(this.c.a));
                    this.g.setAttribute("http.cookie-store", this.h);
                    ((DefaultHttpClient) this.a.b.b).setHttpRequestRetryHandler(e);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    new StringBuilder("By Http/Https to request. operationType=").append(f()).append(" url=").append(this.f.getURI().toString());
                    HttpParams params = this.a.b.getParams();
                    String str = "http.route.default-proxy";
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        String defaultHost = Proxy.getDefaultHost();
                        int defaultPort = Proxy.getDefaultPort();
                        if (defaultHost != null) {
                            httpHost = new HttpHost(defaultHost, defaultPort);
                            if (httpHost != null && TextUtils.equals(httpHost.getHostName(), "127.0.0.1") && httpHost.getPort() == 8087) {
                                httpHost = null;
                            }
                            params.setParameter(str, httpHost);
                            if (this.k == null) {
                                httpHost2 = this.k;
                            } else {
                                h = h();
                                this.k = new HttpHost(h.getHost(), g(), h.getProtocol());
                                httpHost2 = this.k;
                            }
                            if (g() == 80) {
                                httpHost2 = new HttpHost(h().getHost());
                            }
                            execute = this.a.b.execute(httpHost2, this.f, this.g);
                            currentTimeMillis = System.currentTimeMillis();
                            vVar = this.a;
                            vVar.d = (currentTimeMillis - currentTimeMillis2) + vVar.d;
                            vVar.f++;
                            cookies = this.h.getCookies();
                            if (this.c.e) {
                                i().removeAllCookie();
                            }
                            if (!cookies.isEmpty()) {
                                for (Cookie cookie : cookies) {
                                    if (cookie.getDomain() != null) {
                                        i().setCookie(this.c.a, cookie.getName() + "=" + cookie.getValue() + "; domain=" + cookie.getDomain() + (cookie.isSecure() ? "; Secure" : ""));
                                        CookieSyncManager.getInstance().sync();
                                    }
                                }
                            }
                            statusCode = execute.getStatusLine().getStatusCode();
                            reasonPhrase = execute.getStatusLine().getReasonPhrase();
                            if (statusCode != 200) {
                                if ((statusCode != 304 ? 1 : 0) == 0) {
                                    throw new a(Integer.valueOf(execute.getStatusLine().getStatusCode()), execute.getStatusLine().getReasonPhrase());
                                }
                            }
                            a = a(execute, statusCode, reasonPhrase);
                            currentTimeMillis2 = -1;
                            if (!(a == null || a.a() == null)) {
                                currentTimeMillis2 = (long) a.a().length;
                            }
                            if (currentTimeMillis2 == -1 && (a instanceof z)) {
                                Long.parseLong((String) ((z) a).d.a.get("Content-Length"));
                            }
                            break;
                        }
                    }
                    httpHost = null;
                    httpHost = null;
                    params.setParameter(str, httpHost);
                    if (this.k == null) {
                        h = h();
                        this.k = new HttpHost(h.getHost(), g(), h.getProtocol());
                        httpHost2 = this.k;
                    } else {
                        httpHost2 = this.k;
                    }
                    if (g() == 80) {
                        httpHost2 = new HttpHost(h().getHost());
                    }
                    execute = this.a.b.execute(httpHost2, this.f, this.g);
                    currentTimeMillis = System.currentTimeMillis();
                    vVar = this.a;
                    vVar.d = (currentTimeMillis - currentTimeMillis2) + vVar.d;
                    vVar.f++;
                    cookies = this.h.getCookies();
                    if (this.c.e) {
                        i().removeAllCookie();
                    }
                    if (cookies.isEmpty()) {
                        for (Cookie cookie2 : cookies) {
                            if (cookie2.getDomain() != null) {
                                if (cookie2.isSecure()) {
                                }
                                i().setCookie(this.c.a, cookie2.getName() + "=" + cookie2.getValue() + "; domain=" + cookie2.getDomain() + (cookie2.isSecure() ? "; Secure" : ""));
                                CookieSyncManager.getInstance().sync();
                            }
                        }
                    }
                    statusCode = execute.getStatusLine().getStatusCode();
                    reasonPhrase = execute.getStatusLine().getReasonPhrase();
                    if (statusCode != 200) {
                        if (statusCode != 304) {
                        }
                        if ((statusCode != 304 ? 1 : 0) == 0) {
                            throw new a(Integer.valueOf(execute.getStatusLine().getStatusCode()), execute.getStatusLine().getReasonPhrase());
                        }
                    }
                    a = a(execute, statusCode, reasonPhrase);
                    currentTimeMillis2 = -1;
                    currentTimeMillis2 = (long) a.a().length;
                    Long.parseLong((String) ((z) a).d.a.get("Content-Length"));
                    break;
                }
                throw new a(Integer.valueOf(1), "The network is not available");
            } catch (a e) {
                e();
                new StringBuilder().append(e);
                throw e;
            } catch (URISyntaxException e2) {
                throw new RuntimeException("Url parser error!", e2.getCause());
            } catch (SSLHandshakeException e3) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e3);
                }
                new StringBuilder().append(e3);
                throw new a(Integer.valueOf(2), String.valueOf(e3));
            } catch (SSLPeerUnverifiedException e4) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e4);
                }
                new StringBuilder().append(e4);
                throw new a(Integer.valueOf(2), String.valueOf(e4));
            } catch (SSLException e5) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e5);
                }
                new StringBuilder().append(e5);
                throw new a(Integer.valueOf(6), String.valueOf(e5));
            } catch (ConnectionPoolTimeoutException e6) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e6);
                }
                new StringBuilder().append(e6);
                throw new a(Integer.valueOf(3), String.valueOf(e6));
            } catch (ConnectTimeoutException e7) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e7);
                }
                new StringBuilder().append(e7);
                throw new a(Integer.valueOf(3), String.valueOf(e7));
            } catch (SocketTimeoutException e8) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e8);
                }
                new StringBuilder().append(e8);
                throw new a(Integer.valueOf(4), String.valueOf(e8));
            } catch (NoHttpResponseException e9) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e9);
                }
                new StringBuilder().append(e9);
                throw new a(Integer.valueOf(5), String.valueOf(e9));
            } catch (HttpHostConnectException e10) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e10);
                }
                throw new a(Integer.valueOf(8), String.valueOf(e10));
            } catch (UnknownHostException e11) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e11);
                }
                new StringBuilder().append(e11);
                throw new a(Integer.valueOf(9), String.valueOf(e11));
            } catch (IOException e12) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e12);
                }
                new StringBuilder().append(e12);
                throw new a(Integer.valueOf(6), String.valueOf(e12));
            } catch (NullPointerException e13) {
                e();
                if (this.m > 0) {
                    new StringBuilder().append(e13);
                    throw new a(Integer.valueOf(0), String.valueOf(e13));
                }
                this.m++;
            } catch (Exception e14) {
                e();
                if (this.c.a() != null) {
                    new StringBuilder().append(e14);
                }
                throw new a(Integer.valueOf(0), String.valueOf(e14));
            }
        }
        String str2 = this.c.a;
        if (!(str2 == null || TextUtils.isEmpty(f()))) {
            new StringBuilder().append(str2).append("#").append(f());
        }
        return a;
    }

    private void e() {
        if (this.f != null) {
            this.f.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        this.q = this.c.a("operationType");
        return this.q;
    }

    private int g() {
        URL h = h();
        return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
    }

    private URL h() {
        if (this.l != null) {
            return this.l;
        }
        this.l = new URL(this.c.a);
        return this.l;
    }

    private CookieManager i() {
        if (this.i != null) {
            return this.i;
        }
        this.i = CookieManager.getInstance();
        return this.i;
    }

    public final y a() {
        return this.c;
    }

    public final /* synthetic */ Object call() {
        return d();
    }
}
