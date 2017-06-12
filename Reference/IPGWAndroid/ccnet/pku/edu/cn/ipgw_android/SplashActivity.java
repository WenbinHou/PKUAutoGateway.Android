package ccnet.pku.edu.cn.ipgw_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.a.s;

public class SplashActivity extends s {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
