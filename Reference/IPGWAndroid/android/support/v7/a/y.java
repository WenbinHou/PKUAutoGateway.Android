package android.support.v7.a;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.b.j;
import android.util.Log;
import android.view.Window;
import android.view.Window.Callback;
import java.util.Calendar;

class y extends x {
    private static ax w;
    boolean p = true;
    private int x = -100;
    private boolean y;

    y(Context context, Window window, t tVar) {
        super(context, window, tVar);
    }

    Callback a(Callback callback) {
        return new z(this, callback);
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null && this.x == -100) {
            this.x = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public final void b(Bundle bundle) {
        super.b(bundle);
        if (this.x != -100) {
            bundle.putInt("appcompat:local_night_mode", this.x);
        }
    }

    public final boolean i() {
        boolean z;
        this.y = true;
        switch (this.x == -100 ? u.a : this.x) {
            case -1:
                switch (((UiModeManager) this.b.getSystemService("uimode")).getNightMode()) {
                    case 0:
                        z = false;
                        break;
                    case 2:
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
            case 0:
                if (w == null) {
                    w = new ax(this.b.getApplicationContext());
                }
                ax axVar = w;
                ay ayVar = ax.a;
                if (ax.a(ayVar)) {
                    z = ayVar.a;
                } else {
                    Location a = j.a(axVar.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? axVar.a("network") : null;
                    Location a2 = j.a(axVar.b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? axVar.a("gps") : null;
                    if (a2 == null || a == null) {
                        if (a2 != null) {
                            a = a2;
                        }
                    } else if (a2.getTime() > a.getTime()) {
                        a = a2;
                    }
                    if (a != null) {
                        ax.a(a);
                        z = ayVar.a;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i = Calendar.getInstance().get(11);
                        z = i < 6 || i >= 22;
                    }
                }
                if (!z) {
                    z = true;
                    break;
                }
                z = true;
                break;
                break;
            case 2:
                z = true;
                break;
            default:
                z = true;
                break;
        }
        Resources resources = this.b.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        switch (z) {
            case true:
                i = 16;
                break;
            case true:
                i = 32;
                break;
            default:
                i = 0;
                break;
        }
        if (i2 == i) {
            return false;
        }
        configuration.uiMode = i | (configuration.uiMode & -49);
        resources.updateConfiguration(configuration, null);
        return true;
    }
}
