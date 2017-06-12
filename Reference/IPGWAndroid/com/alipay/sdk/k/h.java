package com.alipay.sdk.k;

import android.content.Intent;
import android.os.Bundle;
import com.alipay.android.app.IRemoteServiceCallback.Stub;

final class h extends Stub {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public final boolean isHideLoadingScreen() {
        return false;
    }

    public final void payEnd(boolean z, String str) {
    }

    public final void startActivity(String str, String str2, int i, Bundle bundle) {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putInt("CallingPid", i);
            intent.putExtras(bundle);
        } catch (Exception e) {
        }
        intent.setClassName(str, str2);
        if (this.a.a != null) {
            this.a.a.startActivity(intent);
        }
    }
}
