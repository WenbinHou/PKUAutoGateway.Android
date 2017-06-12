package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.eq;
import com.google.android.gms.b.ex;

public class InAppPurchaseActivity extends Activity {
    private eq a;

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.a != null) {
                this.a.a(i, i2, intent);
            }
        } catch (Throwable e) {
            b.c("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = ex.a((Activity) this);
        if (this.a == null) {
            b.d("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.a.a();
        } catch (Throwable e) {
            b.c("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.a != null) {
                this.a.b();
            }
        } catch (Throwable e) {
            b.c("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
