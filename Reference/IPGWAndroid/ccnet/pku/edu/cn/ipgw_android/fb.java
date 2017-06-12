package ccnet.pku.edu.cn.ipgw_android;

import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.a.r;

final class fb implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ fa b;

    fb(fa faVar, String str) {
        this.b = faVar;
        this.a = str;
    }

    public final void run() {
        r b = new r(this.b.a).a(this.b.a.getResources().getString(R.string.update_alert)).b(this.b.a.getResources().getString(R.string.app_fullname) + ": " + this.b.a.getResources().getString(R.string.update_msg));
        CharSequence string = this.b.a.getResources().getString(R.string.update_now);
        OnClickListener fdVar = new fd(this);
        b.a.i = string;
        b.a.j = fdVar;
        string = this.b.a.getResources().getString(R.string.update_nexttime);
        fdVar = new fc(this);
        b.a.k = string;
        b.a.l = fdVar;
        b.a().show();
        SharedPreferences sharedPreferences = this.b.a.getApplicationContext().getSharedPreferences("preference_file_key", 0);
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = sharedPreferences.edit();
        edit.putString("store_update_alerttime", String.valueOf(currentTimeMillis));
        edit.commit();
    }
}
