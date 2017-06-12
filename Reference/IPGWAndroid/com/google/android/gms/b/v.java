package com.google.android.gms.b;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.ByteArrayOutputStream;

final class v {
    ByteArrayOutputStream a = new ByteArrayOutputStream(4096);
    Base64OutputStream b = new Base64OutputStream(this.a, 10);

    public final void a(byte[] bArr) {
        this.b.write(bArr);
    }

    public final String toString() {
        String byteArrayOutputStream;
        try {
            this.b.close();
        } catch (Throwable e) {
            b.b("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.a.close();
            byteArrayOutputStream = this.a.toString();
        } catch (Throwable e2) {
            b.b("HashManager: Unable to convert to Base64.", e2);
            byteArrayOutputStream = "";
        } finally {
            this.a = null;
            this.b = null;
        }
        return byteArrayOutputStream;
    }
}
