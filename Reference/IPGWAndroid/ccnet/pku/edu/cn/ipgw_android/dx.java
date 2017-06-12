package ccnet.pku.edu.cn.ipgw_android;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class dx implements OnCheckedChangeListener {
    final /* synthetic */ SwitchCompat a;
    final /* synthetic */ View b;
    final /* synthetic */ SwitchCompat c;
    final /* synthetic */ dw d;

    dx(dw dwVar, SwitchCompat switchCompat, View view, SwitchCompat switchCompat2) {
        this.d = dwVar;
        this.a = switchCompat;
        this.b = view;
        this.c = switchCompat2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.a.isChecked()) {
            fm.c(this.b.getContext(), "Y");
            return;
        }
        fm.c(this.b.getContext(), "N");
        fm.d(this.b.getContext(), "N");
        this.b.getContext();
        fm.a("");
        fm.b(this.b.getContext(), "");
        this.c.setChecked(false);
    }
}
