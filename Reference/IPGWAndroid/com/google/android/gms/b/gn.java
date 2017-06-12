package com.google.android.gms.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@fd
public final class gn extends fi {
    private final String a;
    private final Context b;
    private final String d;
    private String e = null;

    public gn(Context context, String str, String str2) {
        this.b = context;
        this.a = str;
        this.d = str2;
    }

    public gn(Context context, String str, String str2, String str3) {
        this.b = context;
        this.a = str;
        this.d = str2;
        this.e = str3;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        try {
            fk.e("Pinging URL: " + this.d);
            httpURLConnection = (HttpURLConnection) new URL(this.d).openConnection();
            if (TextUtils.isEmpty(this.e)) {
                f.c().a(this.b, this.a, true, httpURLConnection);
            } else {
                f.c();
                fs.a(httpURLConnection, this.e);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                b.d("Received non-success response code " + responseCode + " from pinging URL: " + this.d);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            b.d("Error while parsing ping URL: " + this.d + ". " + e.getMessage());
        } catch (IOException e2) {
            b.d("Error while pinging URL: " + this.d + ". " + e2.getMessage());
        } catch (RuntimeException e3) {
            b.d("Error while pinging URL: " + this.d + ". " + e3.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
