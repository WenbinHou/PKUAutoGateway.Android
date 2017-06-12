package ccnet.pku.edu.cn.ipgw_android;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.a.a;
import android.support.v7.a.q;
import android.support.v7.a.s;
import android.view.MenuItem;

public class Activity_MsgContent extends s {
    SwipeRefreshLayout l;
    String m = null;
    q n = null;

    private void d() {
        this.l.post(new m(this));
        new Handler().postDelayed(new n(this), 200);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a a = c().a();
        Drawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.title));
        a.b();
        a.a();
        a.a(bitmapDrawable);
        a.a((int) R.string.pkuits);
        a.a(true);
        setContentView((int) R.layout.activity_msg_content);
        overridePendingTransition(R.animator.trans_left_in, R.animator.trans_left_out);
        this.l = (SwipeRefreshLayout) findViewById(R.id.swiperefresh_msgcontent);
        this.l.setOnRefreshListener(new t(this));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.m = extras.getString("URL_MSG");
        }
        if (this.m != null) {
            d();
        }
        fn.e(this);
        findViewById(R.id.msgcontent_webview).setOnTouchListener(new u(this, this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                if (this.n != null && this.n.isShowing()) {
                    this.n.dismiss();
                    this.n = null;
                }
                finish();
                overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onStop() {
        super.onStop();
        if (this.n != null && this.n.isShowing()) {
            this.n.dismiss();
            this.n = null;
        }
    }
}
