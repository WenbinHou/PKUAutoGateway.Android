package b.a.d;

import b.a.o;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class d implements HostnameVerifier {
    public static final d a = new d();

    private d() {
    }

    public static List<String> a(X509Certificate x509Certificate) {
        Collection a = a(x509Certificate, 7);
        Collection a2 = a(x509Certificate, 2);
        List<String> arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    private static List<String> a(X509Certificate x509Certificate, int i) {
        List<String> arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2) {
                    Integer num = (Integer) list.get(0);
                    if (num != null && num.intValue() == i) {
                        String str = (String) list.get(1);
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    private static boolean a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String toLowerCase = str2.toLowerCase(Locale.US);
        if (!toLowerCase.contains("*")) {
            return str.equals(toLowerCase);
        }
        if (!toLowerCase.startsWith("*.") || toLowerCase.indexOf(42, 1) != -1 || str.length() < toLowerCase.length() || "*.".equals(toLowerCase)) {
            return false;
        }
        toLowerCase = toLowerCase.substring(1);
        if (!str.endsWith(toLowerCase)) {
            return false;
        }
        int length = str.length() - toLowerCase.length();
        return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            int size;
            int i;
            if (o.b(str)) {
                List a = a(x509Certificate, 7);
                size = a.size();
                for (i = 0; i < size; i++) {
                    if (str.equalsIgnoreCase((String) a.get(i))) {
                        return true;
                    }
                }
                return false;
            }
            String toLowerCase = str.toLowerCase(Locale.US);
            List a2 = a(x509Certificate, 2);
            int size2 = a2.size();
            size = 0;
            Object obj = null;
            while (size < size2) {
                if (a(toLowerCase, (String) a2.get(size))) {
                    return true;
                }
                size++;
                i = 1;
            }
            if (obj == null) {
                c cVar = new c(x509Certificate.getSubjectX500Principal());
                String str2 = "cn";
                cVar.c = 0;
                cVar.d = 0;
                cVar.e = 0;
                cVar.f = 0;
                cVar.g = cVar.a.toCharArray();
                String a3 = cVar.a();
                if (a3 == null) {
                    a3 = null;
                } else {
                    String str3 = a3;
                    while (true) {
                        a3 = "";
                        if (cVar.c == cVar.b) {
                            a3 = null;
                        } else {
                            switch (cVar.g[cVar.c]) {
                                case '\"':
                                    cVar.c++;
                                    cVar.d = cVar.c;
                                    cVar.e = cVar.d;
                                    while (cVar.c != cVar.b) {
                                        if (cVar.g[cVar.c] == '\"') {
                                            cVar.c++;
                                            while (cVar.c < cVar.b && cVar.g[cVar.c] == ' ') {
                                                cVar.c++;
                                            }
                                            a3 = new String(cVar.g, cVar.d, cVar.e - cVar.d);
                                            break;
                                        }
                                        if (cVar.g[cVar.c] == '\\') {
                                            cVar.g[cVar.e] = cVar.d();
                                        } else {
                                            cVar.g[cVar.e] = cVar.g[cVar.c];
                                        }
                                        cVar.c++;
                                        cVar.e++;
                                    }
                                    throw new IllegalStateException("Unexpected end of DN: " + cVar.a);
                                case '#':
                                    a3 = cVar.b();
                                    break;
                                case '+':
                                case ',':
                                case ';':
                                    break;
                                default:
                                    a3 = cVar.c();
                                    break;
                            }
                            if (!str2.equalsIgnoreCase(str3)) {
                                if (cVar.c >= cVar.b) {
                                    a3 = null;
                                } else if (cVar.g[cVar.c] == ',' || cVar.g[cVar.c] == ';' || cVar.g[cVar.c] == '+') {
                                    cVar.c++;
                                    a3 = cVar.a();
                                    if (a3 == null) {
                                        throw new IllegalStateException("Malformed DN: " + cVar.a);
                                    }
                                    str3 = a3;
                                } else {
                                    throw new IllegalStateException("Malformed DN: " + cVar.a);
                                }
                            }
                        }
                    }
                }
                if (a3 != null) {
                    return a(toLowerCase, a3);
                }
            }
            return false;
        } catch (SSLException e) {
            return false;
        }
    }
}
