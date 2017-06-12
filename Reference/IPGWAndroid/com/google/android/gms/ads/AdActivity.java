package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.ec;
import com.google.android.gms.b.ee;

public class AdActivity extends Activity {
    private ee a;

    private void a() {
        if (this.a != null) {
            try {
                this.a.l();
            } catch (Throwable e) {
                b.c("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.a != null) {
                z = this.a.e();
            }
        } catch (Throwable e) {
            b.c("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = ec.a((Activity) this);
        if (this.a == null) {
            b.d("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.a.a(bundle);
        } catch (Throwable e) {
            b.c("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.a != null) {
                this.a.k();
            }
        } catch (Throwable e) {
            b.c("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.a != null) {
                this.a.i();
            }
        } catch (Throwable e) {
            b.c("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.a != null) {
                this.a.f();
            }
        } catch (Throwable e) {
            b.c("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.a != null) {
                this.a.h();
            }
        } catch (Throwable e) {
            b.c("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.a != null) {
                this.a.b(bundle);
            }
        } catch (Throwable e) {
            b.c("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.a != null) {
                this.a.g();
            }
        } catch (Throwable e) {
            b.c("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.a != null) {
                this.a.j();
            }
        } catch (Throwable e) {
            b.c("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }
}
