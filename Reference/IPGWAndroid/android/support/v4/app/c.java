package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

final class c extends d {
    private c() {
        super();
    }

    public final int a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }

    public final String a(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
