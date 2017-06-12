package com.google.android.gms.b;

import java.io.UnsupportedEncodingException;

public class c extends hs<String> {
    private final hy<String> a;

    private c(String str, hy<String> hyVar, hx hxVar) {
        super(str, hxVar);
        this.a = hyVar;
    }

    public c(String str, hy<String> hyVar, hx hxVar, byte b) {
        this(str, hyVar, hxVar);
    }

    protected final hw<String> a(ff ffVar) {
        Object str;
        try {
            str = new String(ffVar.b, ix.a(ffVar.c, "ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            str = new String(ffVar.b);
        }
        return new hw(str, ix.a(ffVar));
    }

    protected final /* synthetic */ void a(Object obj) {
        this.a.a((String) obj);
    }
}
