package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@fd
public final class hg extends MutableContextWrapper {
    Activity a;
    Context b;
    private Context c;

    public hg(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Object getSystemService(String str) {
        return this.b.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.c = context.getApplicationContext();
        this.a = context instanceof Activity ? (Activity) context : null;
        this.b = context;
        super.setBaseContext(this.c);
    }

    public final void startActivity(Intent intent) {
        if (this.a == null || id.a(21)) {
            intent.setFlags(268435456);
            this.c.startActivity(intent);
            return;
        }
        this.a.startActivity(intent);
    }
}
