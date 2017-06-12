package com.google.android.gms.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

final class it {
    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public Map<String, String> h;

    private it() {
    }

    public it(String str, i iVar) {
        this.b = str;
        this.a = (long) iVar.a.length;
        this.c = iVar.b;
        this.d = iVar.c;
        this.e = iVar.d;
        this.f = iVar.e;
        this.g = iVar.f;
        this.h = iVar.g;
    }

    public static it a(InputStream inputStream) {
        it itVar = new it();
        if (is.a(inputStream) != 538247942) {
            throw new IOException();
        }
        itVar.b = is.c(inputStream);
        itVar.c = is.c(inputStream);
        if (itVar.c.equals("")) {
            itVar.c = null;
        }
        itVar.d = is.b(inputStream);
        itVar.e = is.b(inputStream);
        itVar.f = is.b(inputStream);
        itVar.g = is.b(inputStream);
        itVar.h = is.d(inputStream);
        return itVar;
    }

    public final boolean a(OutputStream outputStream) {
        try {
            is.a(outputStream, 538247942);
            is.a(outputStream, this.b);
            is.a(outputStream, this.c == null ? "" : this.c);
            is.a(outputStream, this.d);
            is.a(outputStream, this.e);
            is.a(outputStream, this.f);
            is.a(outputStream, this.g);
            Map map = this.h;
            if (map != null) {
                is.a(outputStream, map.size());
                for (Entry entry : map.entrySet()) {
                    is.a(outputStream, (String) entry.getKey());
                    is.a(outputStream, (String) entry.getValue());
                }
            } else {
                is.a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            im.b("%s", e.toString());
            return false;
        }
    }
}
