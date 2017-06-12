package com.alipay.android.a.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public final class y extends ad {
    String a;
    byte[] b;
    String c = "application/x-www-form-urlencoded";
    ArrayList<Header> d = new ArrayList();
    boolean e;
    private Map<String, String> h = new HashMap();

    public y(String str) {
        this.a = str;
    }

    public final String a(String str) {
        return this.h == null ? null : (String) this.h.get(str);
    }

    public final void a(String str, String str2) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        this.h.put(str, str2);
    }

    public final void a(Header header) {
        this.d.add(header);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        if (this.b == null) {
            if (yVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(yVar.b)) {
            return false;
        }
        return this.a == null ? yVar.a == null : this.a.equals(yVar.a);
    }

    public final int hashCode() {
        int i = 1;
        if (this.h != null && this.h.containsKey("id")) {
            i = ((String) this.h.get("id")).hashCode() + 31;
        }
        return (this.a == null ? 0 : this.a.hashCode()) + (i * 31);
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", new Object[]{this.a, this.d});
    }
}
