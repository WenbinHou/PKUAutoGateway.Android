package com.google.android.gms.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@fd
public final class gd {
    final Context a;
    private String b;
    private final float c;
    private float d;
    private float e;
    private float f;
    private int g;

    private gd(Context context) {
        this.g = 0;
        this.a = context;
        this.c = context.getResources().getDisplayMetrics().density;
    }

    public gd(Context context, String str) {
        this(context);
        this.b = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, float f, float f2) {
        if (i == 0) {
            this.g = 0;
            this.d = f;
            this.e = f2;
            this.f = f2;
        } else if (this.g == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.e) {
                    this.e = f2;
                } else if (f2 < this.f) {
                    this.f = f2;
                }
                if (this.e - this.f > 30.0f * this.c) {
                    this.g = -1;
                    return;
                }
                if (this.g == 0 || this.g == 2) {
                    if (f - this.d >= 50.0f * this.c) {
                        this.d = f;
                        this.g++;
                    }
                } else if ((this.g == 1 || this.g == 3) && f - this.d <= -50.0f * this.c) {
                    this.d = f;
                    this.g++;
                }
                if (this.g == 1 || this.g == 3) {
                    if (f > this.d) {
                        this.d = f;
                    }
                } else if (this.g == 2 && f < this.d) {
                    this.d = f;
                }
            } else if (i != 1 || this.g != 4) {
            } else {
                if (this.a instanceof Activity) {
                    Object obj = this.b;
                    if (!TextUtils.isEmpty(obj)) {
                        Uri build = new Builder().encodedQuery(obj.replaceAll("\\+", "%20")).build();
                        StringBuilder stringBuilder = new StringBuilder();
                        f.c();
                        Map a = fs.a(build);
                        for (String str : a.keySet()) {
                            stringBuilder.append(str).append(" = ").append((String) a.get(str)).append("\n\n");
                        }
                        obj = stringBuilder.toString().trim();
                    }
                    obj = "No debug information";
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
                    builder.setMessage(obj);
                    builder.setTitle("Ad Information");
                    builder.setPositiveButton("Share", new ge(this, obj));
                    builder.setNegativeButton("Close", new gf(this));
                    builder.create().show();
                    return;
                }
                b.c("Can not create dialog without Activity Context");
            }
        }
    }
}
