package d.a.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class b {
    public ArrayList a;

    public b() {
        this.a = new ArrayList();
    }

    public b(e eVar) {
        this();
        char c = eVar.c();
        if (c == '[') {
            c = ']';
        } else if (c == '(') {
            c = ')';
        } else {
            throw eVar.a("A JSONArray text must start with '['");
        }
        if (eVar.c() != ']') {
            eVar.a();
            while (true) {
                if (eVar.c() == ',') {
                    eVar.a();
                    this.a.add(null);
                } else {
                    eVar.a();
                    this.a.add(eVar.d());
                }
                char c2 = eVar.c();
                switch (c2) {
                    case ')':
                    case ']':
                        if (c != c2) {
                            throw eVar.a("Expected a '" + new Character(c) + "'");
                        }
                        return;
                    case ',':
                    case ';':
                        if (eVar.c() != ']') {
                            eVar.a();
                        } else {
                            return;
                        }
                    default:
                        throw eVar.a("Expected a ',' or ']'");
                }
            }
        }
    }

    public b(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                this.a.add(Array.get(obj, i));
            }
            return;
        }
        throw new a("JSONArray initial value should be a string or collection or array.");
    }

    public b(String str) {
        this(new e(str));
    }

    public b(Collection collection) {
        this.a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    private String a(String str) {
        int size = this.a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(c.a(this.a.get(i)));
        }
        return stringBuffer.toString();
    }

    public final Object a(int i) {
        Object obj = (i < 0 || i >= this.a.size()) ? null : this.a.get(i);
        if (obj != null) {
            return obj;
        }
        throw new a("JSONArray[" + i + "] not found.");
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception e) {
            return null;
        }
    }
}
