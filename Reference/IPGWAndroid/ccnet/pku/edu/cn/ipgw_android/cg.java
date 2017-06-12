package ccnet.pku.edu.cn.ipgw_android;

import android.widget.TextView;

final class cg implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ ca g;

    cg(ca caVar, String str, String str2, String str3, String str4, String str5, String str6) {
        this.g = caVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public final void run() {
        this.g.f.a(this.g.c);
        TextView textView = (TextView) this.g.c.findViewById(R.id.msg0);
        textView.setTextColor(this.g.f.c().getColor(R.color.colorPKURed));
        textView.setText(this.g.f.c().getString(R.string.connected) + this.a);
        this.g.f.Z = this.g.f.c().getString(R.string.connected) + this.a;
        textView = (TextView) this.g.c.findViewById(R.id.msg2);
        textView.setTextColor(this.g.f.c().getColor(R.color.colorIPGWGray));
        textView.setText(this.b);
        this.g.f.ab = this.b;
        textView = (TextView) this.g.c.findViewById(R.id.msg4);
        textView.setTextColor(this.g.f.c().getColor(R.color.colorIPGWGray));
        textView.setText(this.c);
        this.g.f.ad = this.c;
        textView = (TextView) this.g.c.findViewById(R.id.msg1);
        textView.setTextColor(this.g.f.c().getColor(R.color.colorIPGWGray));
        textView.setText(this.d);
        this.g.f.aa = this.d;
        textView = (TextView) this.g.c.findViewById(R.id.msg3);
        textView.setTextColor(this.g.f.c().getColor(R.color.colorIPGWGray));
        textView.setText(this.e);
        this.g.f.ac = this.e;
        textView = (TextView) this.g.c.findViewById(R.id.msg5);
        textView.setTextColor(this.g.f.c().getColor(R.color.colorIPGWGray));
        textView.setText(this.f);
        this.g.f.ae = this.f;
    }
}
