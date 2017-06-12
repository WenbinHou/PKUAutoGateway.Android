package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.Iterator;

@fd
public final class j {
    final Object a = new Object();
    int b = 0;
    int c = 0;
    int d = 0;
    String e = "";
    private final int f;
    private final int g;
    private final int h;
    private final s i;
    private ArrayList<String> j = new ArrayList();
    private ArrayList<String> k = new ArrayList();
    private int l;
    private String m = "";

    public j(int i, int i2, int i3, int i4) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = new s(i4);
    }

    private static String a(ArrayList<String> arrayList) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > 100) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= 100 ? stringBuffer2.substring(0, 100) : stringBuffer2;
    }

    public final void a(String str, boolean z) {
        b(str, z);
        synchronized (this.a) {
            if (this.d < 0) {
                b.a("ActivityContent: negative number of WebViews.");
            }
            c();
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.d == 0;
        }
        return z;
    }

    public final void b() {
        synchronized (this.a) {
            this.d++;
        }
    }

    final void b(String str, boolean z) {
        if (str != null && str.length() >= this.h) {
            synchronized (this.a) {
                this.j.add(str);
                this.b += str.length();
                if (z) {
                    this.k.add(str);
                }
            }
        }
    }

    public final void c() {
        synchronized (this.a) {
            int i = (this.b * this.f) + (this.c * this.g);
            if (i > this.l) {
                this.l = i;
                this.e = this.i.a(this.j);
                this.m = this.i.a(this.k);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        j jVar = (j) obj;
        return jVar.e != null && jVar.e.equals(this.e);
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "ActivityContent fetchId: " + this.c + " score:" + this.l + " total_length:" + this.b + "\n text: " + a(this.j) + "\n viewableText" + a(this.k) + "\n signture: " + this.e + "\n viewableSignture: " + this.m;
    }
}
