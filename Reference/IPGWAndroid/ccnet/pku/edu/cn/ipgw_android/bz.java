package ccnet.pku.edu.cn.ipgw_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.n;
import android.support.v7.a.q;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public final class bz extends n {
    String Z = "";
    String aa = "";
    String ab = "";
    String ac = "";
    String ad = "";
    String ae = "";
    View af = null;
    q ag = null;

    static String[] a(String str) {
        String[] strArr = new String[0];
        if (str == null) {
            return null;
        }
        if (str.equals("")) {
            return strArr;
        }
        if (str.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }
        String[] split = str.split(";");
        int length = split.length;
        return length != 0 ? length % 4 != 0 ? null : split : strArr;
    }

    private void b(View view) {
        if (view != null) {
            EditText editText = (EditText) view.findViewById(R.id.userName);
            EditText editText2 = (EditText) view.findViewById(R.id.passwd);
            CharSequence b = fm.b(view.getContext());
            if (b.equals("")) {
                editText.setText("");
                editText2.setText("");
            } else {
                editText.setText(b);
                CharSequence a = fm.a();
                if (a.equals("")) {
                    editText2.setText("");
                } else {
                    editText2.setText(a);
                }
            }
            SwitchCompat switchCompat = (SwitchCompat) view.findViewById(R.id.switch_range);
            if (fm.f(b().getApplicationContext()).equals("N")) {
                switchCompat.setChecked(false);
            } else {
                switchCompat.setChecked(true);
            }
        }
    }

    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.af = layoutInflater.inflate(R.layout.fragment_login, viewGroup, false);
        TextView textView = (TextView) this.af.findViewById(R.id.textviewlogin);
        TextView textView2 = (TextView) this.af.findViewById(R.id.textviewdisconnect);
        TextView textView3 = (TextView) this.af.findViewById(R.id.textviewdisconnectall);
        SwitchCompat switchCompat = (SwitchCompat) this.af.findViewById(R.id.switch_range);
        this.af.setOnTouchListener(new de(this));
        switchCompat.setOnCheckedChangeListener(new df(this, switchCompat));
        EditText editText = (EditText) this.af.findViewById(R.id.userName);
        EditText editText2 = (EditText) this.af.findViewById(R.id.passwd);
        CharSequence b = fm.b(this.af.getContext());
        CharSequence a = fm.a();
        if (b.equals("")) {
            editText.setText("");
            editText2.setText("");
        } else {
            editText.setText(b);
            if (a.equals("")) {
                editText2.setText("");
            } else {
                editText2.setText(a);
            }
        }
        editText.setOnFocusChangeListener(new dg(this));
        editText.setOnFocusChangeListener(new dh(this));
        editText2.setOnFocusChangeListener(new di(this));
        textView3.setOnClickListener(new ck(this));
        textView2.setOnClickListener(new cl(this));
        textView.setOnClickListener(new cm(this, switchCompat));
        return this.af;
    }

    public final void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        switch (i) {
            case 1000:
                if (i2 == -1) {
                    Bundle extras = intent.getExtras();
                    boolean z = extras.getBoolean("extra_AllIP_Disconnected");
                    boolean z2 = extras.getBoolean("extra_CurrentIP_Disconnected");
                    int i3 = extras.getInt("extra_CountIP_Disconnected");
                    if (z) {
                        a(b().getWindow().getDecorView().getRootView(), c().getString(R.string.all_disconnected));
                        return;
                    } else if (z2) {
                        a(b().getWindow().getDecorView().getRootView(), c().getString(R.string.disconnected));
                        return;
                    } else if (i3 > 0) {
                        a(b().getWindow().getDecorView().getRootView(), c().getString(R.string.action_succeed));
                        return;
                    } else {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    final void a(View view) {
        ((TextView) view.findViewById(R.id.msg0)).setText("");
        ((TextView) view.findViewById(R.id.msg1)).setText("");
        ((TextView) view.findViewById(R.id.msg2)).setText("");
        ((TextView) view.findViewById(R.id.msg3)).setText("");
        ((TextView) view.findViewById(R.id.msg4)).setText("");
        ((TextView) view.findViewById(R.id.msg5)).setText("");
        this.Z = "";
        this.aa = "";
        this.ab = "";
        this.ac = "";
        this.ad = "";
        this.ae = "";
    }

    final void a(View view, String str) {
        a(view);
        TextView textView = (TextView) view.findViewById(R.id.msg0);
        textView.setText(str);
        this.Z = str;
        textView.setTextColor(view.getResources().getColor(R.color.colorIPGWGray));
    }

    public final void b(boolean z) {
        super.b(z);
        if (z && this.af != null) {
            b(this.I);
        }
    }

    public final void j() {
        super.j();
        b(this.I);
        View view = this.I;
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.msg0);
            textView.setText(this.Z);
            if (this.ab.equals("")) {
                textView.setTextColor(view.getResources().getColor(R.color.colorIPGWGray));
            } else {
                textView.setTextColor(c().getColor(R.color.colorPKURed));
            }
            textView = (TextView) view.findViewById(R.id.msg1);
            textView.setText(this.aa);
            textView.setTextColor(view.getResources().getColor(R.color.colorIPGWGray));
            textView = (TextView) view.findViewById(R.id.msg2);
            textView.setText(this.ab);
            textView.setTextColor(view.getResources().getColor(R.color.colorIPGWGray));
            textView = (TextView) view.findViewById(R.id.msg3);
            textView.setText(this.ac);
            textView.setTextColor(view.getResources().getColor(R.color.colorIPGWGray));
            textView = (TextView) view.findViewById(R.id.msg4);
            textView.setText(this.ad);
            textView.setTextColor(view.getResources().getColor(R.color.colorIPGWGray));
            textView = (TextView) view.findViewById(R.id.msg5);
            textView.setText(this.ae);
            textView.setTextColor(view.getResources().getColor(R.color.colorIPGWGray));
        }
    }

    public final void k() {
        super.k();
        if (this.ag != null && this.ag.isShowing()) {
            this.ag.dismiss();
            this.ag = null;
        }
    }
}
