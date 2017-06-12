package com.google.android.gms.b;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

public final class ip implements de {
    protected static final boolean a = im.b;
    private static int d = 3000;
    private static int e = 4096;
    protected final iy b;
    protected final iq c;

    public ip(iy iyVar) {
        this(iyVar, new iq(e));
    }

    private ip(iy iyVar, iq iqVar) {
        this.b = iyVar;
        this.c = iqVar;
    }

    private static Map<String, String> a(Header[] headerArr) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private static void a(String str, hs<?> hsVar, il ilVar) {
        ie ieVar = hsVar.l;
        int c = hsVar.c();
        try {
            ieVar.a(ilVar);
            hsVar.a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(c)}));
        } catch (il e) {
            hsVar.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(c)}));
            throw e;
        }
    }

    private byte[] a(HttpEntity httpEntity) {
        b bVar = new b(this.c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new if();
            }
            bArr = this.c.a(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                bVar.write(bArr, 0, read);
            }
            byte[] toByteArray = bVar.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                im.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a(bArr);
            bVar.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ff a(hs<?> hsVar) {
        StatusLine statusLine;
        String str;
        Object[] objArr;
        Throwable e;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            int statusCode;
            byte[] a;
            HttpResponse httpResponse = null;
            Map emptyMap = Collections.emptyMap();
            try {
                Map hashMap = new HashMap();
                i iVar = hsVar.m;
                if (iVar != null) {
                    if (iVar.b != null) {
                        hashMap.put("If-None-Match", iVar.b);
                    }
                    if (iVar.d > 0) {
                        hashMap.put("If-Modified-Since", DateUtils.formatDate(new Date(iVar.d)));
                    }
                }
                HttpResponse a2 = this.b.a(hsVar, hashMap);
                statusLine = a2.getStatusLine();
                statusCode = statusLine.getStatusCode();
                emptyMap = a(a2.getAllHeaders());
                if (statusCode != 304) {
                    a = a2.getEntity() != null ? a(a2.getEntity()) : new byte[0];
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    if (!a && elapsedRealtime2 <= ((long) d)) {
                        break;
                    }
                    str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
                    objArr = new Object[5];
                    objArr[0] = hsVar;
                    objArr[1] = Long.valueOf(elapsedRealtime2);
                    if (a == null) {
                        break;
                    }
                    break;
                    objArr[2] = r2;
                    objArr[3] = Integer.valueOf(statusLine.getStatusCode());
                    objArr[4] = Integer.valueOf(hsVar.l.b());
                    im.b(str, objArr);
                } else {
                    break;
                }
            } catch (SocketTimeoutException e2) {
                a("socket", hsVar, new ik());
            } catch (ConnectTimeoutException e3) {
                a("connection", hsVar, new ik());
            } catch (Throwable e4) {
                throw new RuntimeException("Bad URL " + hsVar.d, e4);
            } catch (IOException e5) {
                e4 = e5;
                a = null;
                if (httpResponse != null) {
                    statusCode = httpResponse.getStatusLine().getStatusCode();
                    im.c("Unexpected response code %d for %s", Integer.valueOf(statusCode), hsVar.d);
                    if (a != null) {
                        ff ffVar = new ff(statusCode, a, emptyMap, false, SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (statusCode != 401) {
                        }
                        a("auth", hsVar, new a(ffVar));
                    } else {
                        throw new fb((byte) 0);
                    }
                }
                throw new go(e4);
            }
        }
        String str2 = "null";
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(statusLine.getStatusCode());
        objArr[4] = Integer.valueOf(hsVar.l.b());
        im.b(str, objArr);
        if (statusCode >= 200 && statusCode <= 299) {
            return new ff(statusCode, a, emptyMap, false, SystemClock.elapsedRealtime() - elapsedRealtime);
        }
        throw new IOException();
    }
}
