package ccnet.pku.edu.cn.ipgw_android;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.s;
import android.view.MenuItem;
import android.widget.TextView;

public class Activity_AboutUs extends s {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a a = c().a();
        Drawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.title));
        a.b();
        a.a();
        ((TextView) findViewById(R.id.abs_header)).setText(R.string.aboutus);
        a.a(bitmapDrawable);
        a.a(true);
        setContentView((int) R.layout.activity_about);
        overridePendingTransition(R.animator.trans_left_in, R.animator.trans_left_out);
        TextView textView = (TextView) findViewById(R.id.appversion);
        String d = fn.d(this);
        if (d == null) {
            d = "";
        }
        textView.setText(getResources().getString(R.string.app_fullname) + " " + d);
        fn.e(this);
        findViewById(R.id.helpline);
        overridePendingTransition(R.animator.trans_left_in, R.animator.trans_left_out);
        findViewById(R.id.linearlayout_aboutus).setOnTouchListener(new a(this, this));
        findViewById(R.id.linearlayout_aboutus).setOnTouchListener(new b(this, this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
