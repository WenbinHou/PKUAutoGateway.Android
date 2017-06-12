package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@fd
public final class s {
    private final int a;
    private final int b;
    private final int c;
    private final r d = new x();

    public s(int i) {
        this.b = i;
        this.a = 6;
        this.c = 0;
    }

    private String a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        v vVar = new v();
        Arrays.sort(split, new t(this));
        int i = 0;
        while (i < split.length && i < this.b) {
            if (split[i].trim().length() != 0) {
                try {
                    vVar.a(this.d.a(split[i]));
                } catch (Throwable e) {
                    b.b("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return vVar.toString();
    }

    private String b(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        v vVar = new v();
        PriorityQueue priorityQueue = new PriorityQueue(this.b, new u(this));
        for (String b : split) {
            String[] b2 = w.b(b);
            if (b2.length != 0) {
                y.a(b2, this.b, this.a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                vVar.a(this.d.a(((z) it.next()).b));
            } catch (Throwable e) {
                b.b("Error while writing hash to byteStream", e);
            }
        }
        return vVar.toString();
    }

    public final String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.c) {
            case 0:
                return b(stringBuffer.toString());
            case 1:
                return a(stringBuffer.toString());
            default:
                return "";
        }
    }
}
