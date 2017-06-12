package ccnet.pku.edu.cn.ipgw_android;

import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class dz implements OnCheckedChangeListener {
    final /* synthetic */ SwitchCompat a;
    final /* synthetic */ dw b;

    dz(dw dwVar, SwitchCompat switchCompat) {
        this.b = dwVar;
        this.a = switchCompat;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        fm.e(this.b.a(), this.a.isChecked() ? "en" : "zh");
        if (VERSION.SDK_INT >= 11) {
            this.b.b().recreate();
            return;
        }
        Intent intent = this.b.b().getIntent();
        this.b.b().finish();
        this.b.a(intent);
    }
}
