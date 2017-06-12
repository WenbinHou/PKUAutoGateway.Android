package com.alipay.android.a.a.a;

import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class s extends d {
    private p g;

    public s(p pVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, "application/x-www-form-urlencoded", z);
        this.g = pVar;
    }

    public final Object a() {
        Throwable e;
        ad yVar = new y(this.g.a());
        yVar.b = this.b;
        yVar.c = this.e;
        yVar.e = this.f;
        yVar.a("id", String.valueOf(this.d));
        yVar.a("operationType", this.c);
        yVar.a("gzip", String.valueOf(this.g.d()));
        yVar.a(new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> list = this.g.c().b;
        if (!(list == null || list.isEmpty())) {
            for (Header a : list) {
                yVar.a(a);
            }
        }
        new StringBuilder("threadid = ").append(Thread.currentThread().getId()).append("; ").append(yVar.toString());
        try {
            ae aeVar = (ae) this.g.b().a(yVar).get();
            if (aeVar != null) {
                return aeVar.a();
            }
            throw new c(Integer.valueOf(9), "response is null");
        } catch (Throwable e2) {
            throw new c(Integer.valueOf(13), "", e2);
        } catch (Throwable e22) {
            Throwable th = e22;
            e22 = th.getCause();
            if (e22 == null || !(e22 instanceof a)) {
                throw new c(Integer.valueOf(9), "", th);
            }
            a aVar = (a) e22;
            int i = aVar.a;
            switch (i) {
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 3;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 6;
                    break;
                case 6:
                    i = 7;
                    break;
                case 7:
                    i = 8;
                    break;
                case 8:
                    i = 15;
                    break;
                case 9:
                    i = 16;
                    break;
            }
            throw new c(Integer.valueOf(i), aVar.b);
        } catch (Throwable e222) {
            throw new c(Integer.valueOf(13), "", e222);
        }
    }
}
