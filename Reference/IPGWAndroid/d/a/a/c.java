package d.a.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class c {
    public static final Object b = new d();
    public Map a;

    public c() {
        this.a = new HashMap();
    }

    public c(e eVar) {
        this();
        if (eVar.c() != '{') {
            throw eVar.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            switch (eVar.c()) {
                case '\u0000':
                    throw eVar.a("A JSONObject text must end with '}'");
                case '}':
                    return;
                default:
                    eVar.a();
                    String obj = eVar.d().toString();
                    char c = eVar.c();
                    if (c == '=') {
                        if (eVar.b() != '>') {
                            eVar.a();
                        }
                    } else if (c != ':') {
                        throw eVar.a("Expected a ':' after a key");
                    }
                    Object d = eVar.d();
                    if (obj == null) {
                        throw new a("Null key.");
                    }
                    if (d != null) {
                        b(d);
                        this.a.put(obj, d);
                    } else {
                        this.a.remove(obj);
                    }
                    switch (eVar.c()) {
                        case ',':
                        case ';':
                            if (eVar.c() != '}') {
                                eVar.a();
                            } else {
                                return;
                            }
                        case '}':
                            return;
                        default:
                            throw eVar.a("Expected a ',' or '}'");
                    }
            }
        }
    }

    public c(String str) {
        this(new e(str));
    }

    public c(Map map) {
        if (map == null) {
            map = new HashMap();
        }
        this.a = map;
    }

    static String a(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof c) || (obj instanceof b)) ? obj.toString() : obj instanceof Map ? new c((Map) obj).toString() : obj instanceof Collection ? new b((Collection) obj).toString() : obj.getClass().isArray() ? new b(obj).toString() : b(obj.toString());
        } else {
            obj = (Number) obj;
            if (obj == null) {
                throw new a("Null pointer");
            }
            b(obj);
            String obj2 = obj.toString();
            if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
                return obj2;
            }
            while (obj2.endsWith("0")) {
                obj2 = obj2.substring(0, obj2.length() - 1);
            }
            return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
        }
    }

    public static String b(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                case '\\':
                    stringBuffer.append('\\');
                    stringBuffer.append(charAt);
                    break;
                case '/':
                    if (i2 == 60) {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt);
                    break;
                default:
                    if (charAt >= ' ' && ((charAt < '' || charAt >= ' ') && (charAt < ' ' || charAt >= '℀'))) {
                        stringBuffer.append(charAt);
                        break;
                    }
                    String str2 = "000" + Integer.toHexString(charAt);
                    stringBuffer.append("\\u" + str2.substring(str2.length() - 4));
                    break;
                    break;
            }
            i++;
            char c = charAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    private static void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                throw new a("JSON does not allow non-finite numbers.");
            }
        } else if (!(obj instanceof Float)) {
        } else {
            if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                throw new a("JSON does not allow non-finite numbers.");
            }
        }
    }

    public final Object a(String str) {
        Object obj = str == null ? null : this.a.get(str);
        if (obj != null) {
            return obj;
        }
        throw new a("JSONObject[" + b(str) + "] not found.");
    }

    public final Iterator a() {
        return this.a.keySet().iterator();
    }

    public String toString() {
        try {
            Iterator a = a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (a.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = a.next();
                stringBuffer.append(b(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(a(this.a.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
