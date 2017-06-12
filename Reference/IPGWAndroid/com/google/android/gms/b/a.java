package com.google.android.gms.b;

import android.content.Intent;

public final class a extends il {
    private Intent c;

    public a(ff ffVar) {
        super(ffVar);
    }

    public final String getMessage() {
        return this.c != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
