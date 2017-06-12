package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.fd;

@fd
public class l {
    public static String b = null;
    public m a;

    public l() {
        a.a();
        if (b != null) {
            try {
                this.a = (m) l.class.getClassLoader().loadClass(b).newInstance();
                return;
            } catch (Throwable e) {
                b.c("Failed to instantiate ClientApi class.", e);
                this.a = new d();
                return;
            }
        }
        b.d("No client jar implementation found.");
        this.a = new d();
    }
}
