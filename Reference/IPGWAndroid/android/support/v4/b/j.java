package android.support.v4.b;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.b;

public final class j {
    public static int a(Context context, String str) {
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String a = b.a(str);
        if (a != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            if (b.a(context, a, packageName) != 0) {
                return -2;
            }
        }
        return 0;
    }
}
