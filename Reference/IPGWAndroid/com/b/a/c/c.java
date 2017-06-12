package com.b.a.c;

import android.content.Context;
import android.provider.Settings.System;
import com.b.a.a.a.a;
import com.b.a.a.a.b;
import com.b.a.a.a.f;
import com.b.a.a.a.g;
import com.b.a.a.a.h;
import com.b.a.b.a.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class c {
    private static final Object b = new Object();
    private static c c = null;
    private static final String j = (".UTSystemConfig" + File.separator + "Global");
    private Context a = null;
    private String d = null;
    private d e = null;
    private String f = "xx_utdid_key";
    private String g = "xx_utdid_domain";
    private d h = null;
    private d i = null;
    private Pattern k = Pattern.compile("[^0-9a-zA-Z=/+]+");

    private c(Context context) {
        this.a = context;
        this.i = new d(context, j, "Alvin2");
        this.h = new d(context, ".DataStorage", "ContextData");
        this.e = new d();
        this.f = String.format("K_%d", new Object[]{Integer.valueOf(h.b(this.f))});
        this.g = String.format("D_%d", new Object[]{Integer.valueOf(h.b(this.g))});
    }

    public static c a(Context context) {
        Object obj = 1;
        if (context != null && c == null) {
            synchronized (b) {
                if (c == null) {
                    c cVar = new c(context);
                    c = cVar;
                    if (cVar.i != null) {
                        if (h.a(cVar.i.b("UTDID2"))) {
                            String b = cVar.i.b("UTDID");
                            if (!h.a(b)) {
                                cVar.a(b);
                            }
                        }
                        Object obj2 = null;
                        if (!h.a(cVar.i.b("DID"))) {
                            cVar.i.a("DID");
                            obj2 = 1;
                        }
                        if (!h.a(cVar.i.b("EI"))) {
                            cVar.i.a("EI");
                            obj2 = 1;
                        }
                        if (h.a(cVar.i.b("SI"))) {
                            obj = obj2;
                        } else {
                            cVar.i.a("SI");
                        }
                        if (obj != null) {
                            cVar.i.a();
                        }
                    }
                }
            }
        }
        return c;
    }

    private void a(String str) {
        if (e(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && this.i != null) {
                this.i.a("UTDID2", str);
                this.i.a();
            }
        }
    }

    private void b(String str) {
        if (str != null && this.h != null && !str.equals(this.h.b(this.f))) {
            this.h.a(this.f, str);
            this.h.a();
        }
    }

    private final byte[] b() {
        String a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a2 = f.a(currentTimeMillis);
        byte[] a3 = f.a(nextInt);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(a3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            a = g.a(this.a);
        } catch (Exception e) {
            a = new Random().nextInt();
        }
        byteArrayOutputStream.write(f.a(h.b(a)), 0, 4);
        a2 = byteArrayOutputStream.toByteArray();
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), instance.getAlgorithm()));
        byteArrayOutputStream.write(f.a(h.b(b.a(instance.doFinal(a2), 2))));
        return byteArrayOutputStream.toByteArray();
    }

    private void c(String str) {
        if (this.a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && e(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = System.getString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception e) {
                }
                if (!e(str2)) {
                    try {
                        System.putString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                    } catch (Exception e2) {
                    }
                }
            }
        }
    }

    private void d(String str) {
        if (this.a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && str != null) {
            Object obj = null;
            try {
                obj = System.getString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp");
            } catch (Exception e) {
            }
            if (!str.equals(obj)) {
                try {
                    System.putString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp", str);
                } catch (Exception e2) {
                }
            }
        }
    }

    private boolean e(String str) {
        if (str == null) {
            return false;
        }
        CharSequence substring;
        if (str.endsWith("\n")) {
            substring = str.substring(0, str.length() - 1);
        }
        return 24 == substring.length() && !this.k.matcher(substring).find();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized String a() {
        String str;
        if (this.d != null) {
            str = this.d;
        } else {
            str = "";
            try {
                str = System.getString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk");
            } catch (Exception e) {
            }
            if (!e(str)) {
                String string;
                e eVar = new e();
                Object obj = null;
                try {
                    string = System.getString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp");
                } catch (Exception e2) {
                    string = null;
                }
                if (h.a(string)) {
                    obj = 1;
                } else {
                    str = eVar.b(string);
                    if (e(str)) {
                        c(str);
                    } else {
                        str = eVar.a(string);
                        if (e(str)) {
                            str = this.e.a(str);
                            if (!h.a(str)) {
                                d(str);
                                try {
                                    str = System.getString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp");
                                } catch (Exception e3) {
                                }
                                string = this.e.b(str);
                                if (e(string)) {
                                    this.d = string;
                                    a(string);
                                    b(str);
                                    c(this.d);
                                    str = this.d;
                                }
                            }
                        }
                        str = string;
                        string = this.e.b(str);
                        if (e(string)) {
                            this.d = string;
                            a(string);
                            b(str);
                            c(this.d);
                            str = this.d;
                        }
                    }
                }
                if (this.i != null) {
                    str = this.i.b("UTDID2");
                    if (!h.a(str)) {
                    }
                }
                str = null;
                if (e(str)) {
                    String a = this.e.a(str);
                    if (obj != null) {
                        d(a);
                    }
                    c(str);
                    b(a);
                    this.d = str;
                } else {
                    string = this.h.b(this.f);
                    if (!h.a(string)) {
                        str = eVar.a(string);
                        if (!e(str)) {
                            str = this.e.b(string);
                        }
                        if (e(str)) {
                            string = this.e.a(str);
                            if (!h.a(str)) {
                                this.d = str;
                                if (obj != null) {
                                    d(string);
                                }
                                a(this.d);
                                str = this.d;
                            }
                        }
                    }
                    try {
                        byte[] b = b();
                        if (b != null) {
                            this.d = b.a(b, 2);
                            a(this.d);
                            d dVar = this.e;
                            str = a.a(dVar.a, b.a(b, 2));
                            if (str != null) {
                                if (obj != null) {
                                    d(str);
                                }
                                b(str);
                            }
                            str = this.d;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    str = null;
                }
            }
        }
        return str;
    }
}
