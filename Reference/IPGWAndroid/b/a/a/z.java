package b.a.a;

import c.i;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

final class z {
    private static final x[] a = new x[]{new x(x.e, ""), new x(x.b, "GET"), new x(x.b, "POST"), new x(x.c, "/"), new x(x.c, "/index.html"), new x(x.d, "http"), new x(x.d, "https"), new x(x.a, "200"), new x(x.a, "204"), new x(x.a, "206"), new x(x.a, "304"), new x(x.a, "400"), new x(x.a, "404"), new x(x.a, "500"), new x("accept-charset", ""), new x("accept-encoding", "gzip, deflate"), new x("accept-language", ""), new x("accept-ranges", ""), new x("accept", ""), new x("access-control-allow-origin", ""), new x("age", ""), new x("allow", ""), new x("authorization", ""), new x("cache-control", ""), new x("content-disposition", ""), new x("content-encoding", ""), new x("content-language", ""), new x("content-length", ""), new x("content-location", ""), new x("content-range", ""), new x("content-type", ""), new x("cookie", ""), new x("date", ""), new x("etag", ""), new x("expect", ""), new x("expires", ""), new x("from", ""), new x("host", ""), new x("if-match", ""), new x("if-modified-since", ""), new x("if-none-match", ""), new x("if-range", ""), new x("if-unmodified-since", ""), new x("last-modified", ""), new x("link", ""), new x("location", ""), new x("max-forwards", ""), new x("proxy-authenticate", ""), new x("proxy-authorization", ""), new x("range", ""), new x("referer", ""), new x("refresh", ""), new x("retry-after", ""), new x("server", ""), new x("set-cookie", ""), new x("strict-transport-security", ""), new x("transfer-encoding", ""), new x("user-agent", ""), new x("vary", ""), new x("via", ""), new x("www-authenticate", "")};
    private static final Map<i, Integer> b;

    static {
        int i = 0;
        Map linkedHashMap = new LinkedHashMap(a.length);
        while (i < a.length) {
            if (!linkedHashMap.containsKey(a[i].h)) {
                linkedHashMap.put(a[i].h, Integer.valueOf(i));
            }
            i++;
        }
        b = Collections.unmodifiableMap(linkedHashMap);
    }

    static /* synthetic */ i a(i iVar) {
        int i = 0;
        int length = iVar.c.length;
        while (i < length) {
            byte b = iVar.c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + iVar.a());
            }
        }
        return iVar;
    }
}
