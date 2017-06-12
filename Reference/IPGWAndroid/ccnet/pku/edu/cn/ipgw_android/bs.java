package ccnet.pku.edu.cn.ipgw_android;

import android.view.View;
import android.widget.TextView;
import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.g;
import com.chauthai.swipereveallayout.h;

final class bs extends br {
    final /* synthetic */ bi m;
    private SwipeRevealLayout n = ((SwipeRevealLayout) this.a.findViewById(R.id.swipe_layout));
    private View o = this.a.findViewById(R.id.disconnect_layout);
    private TextView p = ((TextView) this.a.findViewById(R.id.conn_title));
    private View q = this.a.findViewById(R.id.disconnect_top_layout);
    private TextView r = ((TextView) this.a.findViewById(R.id.conn_subtitle));

    public bs(bi biVar, View view) {
        this.m = biVar;
        super(biVar, view);
    }

    final void b(Object obj) {
        super.b(obj);
        if (obj != null) {
            bw bwVar = (bw) obj;
            g gVar = this.m.d;
            SwipeRevealLayout swipeRevealLayout = this.n;
            String str = bwVar.a;
            gVar.b.values().remove(swipeRevealLayout);
            gVar.b.put(str, swipeRevealLayout);
            swipeRevealLayout.a = true;
            swipeRevealLayout.b.a();
            swipeRevealLayout.setDragStateChangeListener(new h(gVar, str, swipeRevealLayout));
            if (gVar.a.containsKey(str)) {
                int intValue = ((Integer) gVar.a.get(str)).intValue();
                if (intValue == 0 || intValue == 1 || intValue == 4) {
                    swipeRevealLayout.b(false);
                } else {
                    swipeRevealLayout.a(false);
                }
            } else {
                gVar.a.put(str, Integer.valueOf(0));
                swipeRevealLayout.b(false);
            }
            this.q.setOnLongClickListener(new bt(this));
            this.o.setOnClickListener(new bu(this));
            this.n.setSwipeListener(new bv(this));
            if (this.m.h.equals("") || !this.m.h.equals(bwVar.a)) {
                this.p.setText(bwVar.a + ": " + bwVar.b);
            } else {
                this.p.setText("☆" + bwVar.a + ": " + bwVar.b);
            }
            this.r.setText(bwVar.d + " (" + bwVar.c + ")");
        }
    }
}
