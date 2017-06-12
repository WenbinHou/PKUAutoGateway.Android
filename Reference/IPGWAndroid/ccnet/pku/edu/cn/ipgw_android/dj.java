package ccnet.pku.edu.cn.ipgw_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.aq;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.a.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class dj extends aq {
    ArrayList<fj> ah;
    boolean ai = false;
    View aj;
    SwipeRefreshLayout ak;
    q al = null;

    static /* synthetic */ ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            fj fjVar = (fj) it.next();
            String str = fjVar.b;
            String str2 = fjVar.c;
            HashMap hashMap = new HashMap();
            hashMap.put("title", str);
            hashMap.put("subtitle", str2);
            arrayList2.add(hashMap);
        }
        return arrayList2;
    }

    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.aj = layoutInflater.inflate(R.layout.layout_msglist, viewGroup, false);
        ((ListView) this.aj.findViewById(16908298)).addFooterView(((LayoutInflater) b().getSystemService("layout_inflater")).inflate(R.layout.layout_msg_footer, null, false));
        this.ak = (SwipeRefreshLayout) this.aj.findViewById(R.id.swiperefresh);
        this.ak.setOnRefreshListener(new dk(this));
        return this.aj;
    }

    public final void a(int i) {
        if (i >= this.ah.size()) {
            a(new Intent("android.intent.action.VIEW", Uri.parse("https://its.pku.edu.cn/announce/index.jsp")));
            return;
        }
        Intent intent = new Intent(b(), Activity_MsgContent.class);
        intent.putExtra("URL_MSG", ((fj) this.ah.get(i)).d);
        a(intent);
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
    }

    public final void b(boolean z) {
        super.b(z);
        if (z) {
            this.ai = true;
            q();
            return;
        }
        this.ai = false;
    }

    public final void j() {
        super.j();
        if (this.ai) {
            q();
        }
    }

    public final void k() {
        super.k();
        if (this.al != null && this.al.isShowing()) {
            this.al.dismiss();
            this.al = null;
        }
    }

    final void q() {
        ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=getmsgs");
        String str = "https://its.pku.edu.cn/cas/ITSClient";
        ag a2 = fn.a();
        try {
            View view = this.aj;
            this.ak.post(new dm(this));
            a2.a(new ao().a(str).a("User-Agent", fn.a(b())).a("POST", a).a()).a(new dn(this, view));
        } catch (Exception e) {
        }
    }
}
