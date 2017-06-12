package ccnet.pku.edu.cn.ipgw_android;

import android.graphics.PorterDuff.Mode;
import android.support.design.widget.bp;
import android.support.design.widget.bu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

final class fh implements bp {
    final /* synthetic */ MainActivity a;

    fh(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public final void a(bu buVar) {
        View view = buVar.f;
        if (view != null) {
            if (view.getId() == R.id.tabview_home) {
                ((ImageView) view.findViewById(R.id.tab_imageview_home)).setColorFilter(this.a.getResources().getColor(R.color.colorPKURed), Mode.SRC_IN);
                ((TextView) this.a.findViewById(R.id.tab_textview_home)).setTextColor(this.a.getResources().getColor(R.color.colorPKURed));
                ((TextView) this.a.findViewById(R.id.toolbar_title)).setText(R.string.pkuits);
            } else if (view.getId() == R.id.tabview_info) {
                ((ImageView) view.findViewById(R.id.tab_imageview_info)).setColorFilter(this.a.getResources().getColor(R.color.colorPKURed), Mode.SRC_IN);
                ((TextView) this.a.findViewById(R.id.tab_textview_info)).setTextColor(this.a.getResources().getColor(R.color.colorPKURed));
                ((TextView) this.a.findViewById(R.id.toolbar_title)).setText(R.string.tab_notifications);
            } else if (view.getId() == R.id.tabview_more) {
                ((ImageView) view.findViewById(R.id.tab_imageview_more)).setColorFilter(this.a.getResources().getColor(R.color.colorPKURed), Mode.SRC_IN);
                ((TextView) this.a.findViewById(R.id.tab_textview_more)).setTextColor(this.a.getResources().getColor(R.color.colorPKURed));
                ((TextView) this.a.findViewById(R.id.toolbar_title)).setText(R.string.tab_more);
            }
            this.a.n.setCurrentItem(buVar.e);
        }
    }

    public final void b(bu buVar) {
        View view = buVar.f;
        if (view != null) {
            if (view.getId() == R.id.tabview_home) {
                ((ImageView) view.findViewById(R.id.tab_imageview_home)).setColorFilter(this.a.getResources().getColor(R.color.colorIPGWGray), Mode.SRC_IN);
                ((TextView) this.a.findViewById(R.id.tab_textview_home)).setTextColor(this.a.getResources().getColor(R.color.colorIPGWGray));
            } else if (view.getId() == R.id.tabview_info) {
                ((ImageView) view.findViewById(R.id.tab_imageview_info)).setColorFilter(this.a.getResources().getColor(R.color.colorIPGWGray), Mode.SRC_IN);
                ((TextView) this.a.findViewById(R.id.tab_textview_info)).setTextColor(this.a.getResources().getColor(R.color.colorIPGWGray));
            } else if (view.getId() == R.id.tabview_more) {
                ((ImageView) view.findViewById(R.id.tab_imageview_more)).setColorFilter(this.a.getResources().getColor(R.color.colorIPGWGray), Mode.SRC_IN);
                ((TextView) this.a.findViewById(R.id.tab_textview_more)).setTextColor(this.a.getResources().getColor(R.color.colorIPGWGray));
            }
        }
    }
}
