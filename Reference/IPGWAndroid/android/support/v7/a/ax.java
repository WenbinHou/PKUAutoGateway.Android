package android.support.v7.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

final class ax {
    static final ay a = new ay();
    final Context b;
    private final LocationManager c;

    ax(Context context) {
        this.b = context;
        this.c = (LocationManager) context.getSystemService("location");
    }

    static void a(Location location) {
        long j;
        ay ayVar = a;
        long currentTimeMillis = System.currentTimeMillis();
        if (aw.a == null) {
            aw.a = new aw();
        }
        aw awVar = aw.a;
        awVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = awVar.b;
        awVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = awVar.d == 1;
        long j3 = awVar.c;
        long j4 = awVar.b;
        awVar.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = awVar.c;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3;
            j += 60000;
        }
        ayVar.a = z;
        ayVar.b = j2;
        ayVar.c = j3;
        ayVar.d = j4;
        ayVar.e = j5;
        ayVar.f = j;
    }

    static boolean a(ay ayVar) {
        return ayVar != null && ayVar.f > System.currentTimeMillis();
    }

    final Location a(String str) {
        if (this.c != null) {
            try {
                if (this.c.isProviderEnabled(str)) {
                    return this.c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }
}
