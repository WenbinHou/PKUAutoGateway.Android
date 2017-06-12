package com.google.android.gms.b;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Callable;

final class fx implements Callable<File> {
    final /* synthetic */ Context a;
    final /* synthetic */ fw b;

    fx(fw fwVar, Context context) {
        this.b = fwVar;
        this.a = context;
    }

    public final /* synthetic */ Object call() {
        return this.a.getCacheDir();
    }
}
