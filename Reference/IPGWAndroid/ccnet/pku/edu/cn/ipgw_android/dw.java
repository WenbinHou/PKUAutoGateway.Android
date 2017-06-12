package ccnet.pku.edu.cn.ipgw_android;

import android.content.res.Configuration;
import android.support.v4.app.n;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;

public final class dw extends n {
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Locale locale = new Locale(fm.e(a()));
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        b().getBaseContext().getResources().updateConfiguration(configuration, b().getBaseContext().getResources().getDisplayMetrics());
        View inflate = layoutInflater.inflate(R.layout.fragment_more, viewGroup, false);
        SwitchCompat switchCompat = (SwitchCompat) inflate.findViewById(R.id.switch_store_username);
        SwitchCompat switchCompat2 = (SwitchCompat) inflate.findViewById(R.id.switch_store_passwd);
        SwitchCompat switchCompat3 = (SwitchCompat) inflate.findViewById(R.id.switch_language);
        String c = fm.c(inflate.getContext());
        String d = fm.d(inflate.getContext());
        if (c.equals("")) {
            switchCompat.setChecked(true);
        } else if (c.equals("Y")) {
            switchCompat.setChecked(true);
        } else {
            switchCompat.setChecked(false);
        }
        if (d.equals("")) {
            switchCompat2.setChecked(true);
        } else if (d.equals("Y")) {
            switchCompat2.setChecked(true);
        } else {
            switchCompat2.setChecked(false);
        }
        c = fm.e(inflate.getContext());
        if (c.equals("") || c.equals("zh")) {
            switchCompat3.setChecked(false);
        } else {
            switchCompat3.setChecked(true);
        }
        switchCompat.setOnCheckedChangeListener(new dx(this, switchCompat, inflate, switchCompat2));
        switchCompat2.setOnCheckedChangeListener(new dy(this, switchCompat2, inflate));
        switchCompat3.setOnCheckedChangeListener(new dz(this, switchCompat3));
        ((TextView) inflate.findViewById(R.id.payment)).setOnClickListener(new ea(this));
        ((TextView) inflate.findViewById(R.id.reset_passwd)).setOnClickListener(new eb(this));
        ((TextView) inflate.findViewById(R.id.aboutus)).setOnClickListener(new ec(this));
        ((TextView) inflate.findViewById(R.id.itservice)).setOnClickListener(new ed(this));
        ((TextView) inflate.findViewById(R.id.portal)).setOnClickListener(new ee(this));
        return inflate;
    }
}
