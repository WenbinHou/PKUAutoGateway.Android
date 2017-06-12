package b.a.b;

import b.a.j;
import b.an;
import b.ar;
import b.y;

public final class v {
    static final String a = j.b();
    public static final String b = (a + "-Sent-Millis");
    public static final String c = (a + "-Received-Millis");
    public static final String d = (a + "-Selected-Protocol");
    public static final String e = (a + "-Response-Source");

    static {
        j.a();
    }

    public static long a(an anVar) {
        return a(anVar.c);
    }

    public static long a(ar arVar) {
        return a(arVar.f);
    }

    public static long a(y yVar) {
        return b(yVar.a("Content-Length"));
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static long b(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
