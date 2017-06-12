package com.a.a;

import android.text.TextUtils;
import java.security.GeneralSecurityException;

final class g implements m {
    private final String a;
    private final ac b;
    private f c;
    private String d;

    g(ac acVar, String str) {
        this.b = acVar;
        this.a = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private f b() {
        f a;
        z.a(5, "key is generating without password");
        try {
            String str = (String) this.b.a("adsfjlkj234234dasfgenasdfas");
            if (str != null) {
                a = a.a(str);
                if (a == null) {
                    a = a.a();
                    this.b.a("adsfjlkj234234dasfgenasdfas", a.toString());
                }
                z.a(5, "key is generated without password");
                return a;
            }
        } catch (Exception e) {
            z.a(4, "keys was not correct value, it is reset");
        } catch (GeneralSecurityException e2) {
            z.a(6, e2.getMessage());
            return null;
        }
        a = null;
        if (a == null) {
            a = a.a();
            this.b.a("adsfjlkj234234dasfgenasdfas", a.toString());
        }
        z.a(5, "key is generated without password");
        return a;
    }

    private f b(String str) {
        try {
            if (TextUtils.isEmpty(this.d)) {
                this.d = a.a(a.b());
                this.b.a("asdf3242klj", this.d);
            }
            return a.a(str, this.d);
        } catch (GeneralSecurityException e) {
            z.a(6, e.getMessage());
            return null;
        }
    }

    public final String a(byte[] bArr) {
        String str = null;
        if (bArr != null) {
            try {
                str = a.a(bArr, this.c).toString();
            } catch (GeneralSecurityException e) {
                z.a(3, e.getMessage());
            }
        }
        return str;
    }

    public final boolean a() {
        f b;
        this.d = (String) this.b.a("asdf3242klj");
        String str = this.a;
        if (str == null || this.b.c("adsfjlkj234234dasfgenasdfas")) {
            b = b();
        } else {
            b = b(str);
            if (b == null) {
                b = b();
            } else {
                z.a(5, "key is generated from password");
            }
        }
        this.c = b;
        return this.c != null;
    }

    public final byte[] a(String str) {
        byte[] bArr = null;
        if (str != null) {
            try {
                bArr = a.a(new b(str), this.c);
            } catch (GeneralSecurityException e) {
                z.a(3, e.getMessage());
            }
        }
        return bArr;
    }
}
