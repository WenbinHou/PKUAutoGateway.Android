package com.alipay.sdk.k;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay.Stub;

final class g implements ServiceConnection {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a.c) {
            this.a.b = Stub.asInterface(iBinder);
            this.a.c.notify();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.b = null;
    }
}
