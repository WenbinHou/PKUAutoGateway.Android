package ccnet.pku.edu.cn.ipgw_android;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class df implements OnCheckedChangeListener {
    final /* synthetic */ SwitchCompat a;
    final /* synthetic */ bz b;

    df(bz bzVar, SwitchCompat switchCompat) {
        this.b = bzVar;
        this.a = switchCompat;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.a.isChecked()) {
            fm.f(this.b.b().getApplicationContext(), "Y");
        } else {
            fm.f(this.b.b().getApplicationContext(), "N");
        }
    }
}
