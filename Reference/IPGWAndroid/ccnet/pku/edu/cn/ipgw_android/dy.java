package ccnet.pku.edu.cn.ipgw_android;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class dy implements OnCheckedChangeListener {
    final /* synthetic */ SwitchCompat a;
    final /* synthetic */ View b;
    final /* synthetic */ dw c;

    dy(dw dwVar, SwitchCompat switchCompat, View view) {
        this.c = dwVar;
        this.a = switchCompat;
        this.b = view;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.a.isChecked()) {
            fm.d(this.b.getContext(), "Y");
            return;
        }
        fm.d(this.b.getContext(), "N");
        this.b.getContext();
        fm.a("");
    }
}
