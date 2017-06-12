package ccnet.pku.edu.cn.ipgw_android;

import android.app.Activity;
import android.support.v7.a.q;
import android.support.v7.widget.dt;
import android.support.v7.widget.eq;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.chauthai.swipereveallayout.g;
import java.util.ArrayList;

public final class bi extends dt<br> {
    ArrayList<bw> c = new ArrayList();
    final g d = new g();
    Activity e;
    String f;
    String g;
    String h;
    q i = null;

    public bi(Activity activity, String str, String str2) {
        this.e = activity;
        this.f = str;
        this.g = str2;
        this.d.c = true;
        this.h = fm.a(this.e.getApplicationContext());
    }

    public final int a() {
        return this.c == null ? 0 : this.c.size();
    }

    public final /* synthetic */ eq a(ViewGroup viewGroup) {
        return new bs(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.conn_item, viewGroup, false));
    }

    public final /* synthetic */ void a(eq eqVar, int i) {
        ((br) eqVar).b(this.c.get(i));
    }

    public final void a(ArrayList<bw> arrayList) {
        this.c.clear();
        this.c.addAll(arrayList);
        this.a.a();
    }
}
