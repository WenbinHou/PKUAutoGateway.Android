package ccnet.pku.edu.cn.ipgw_android;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.a.a;
import android.support.v7.a.q;
import android.support.v7.a.s;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Timer;

public class Activity_ResetPasswd extends s {
    static boolean l = false;
    static int m = 0;
    static Timer o = new Timer();
    final int n = 2000;
    q p = null;
    TextView q;

    final void a(TextView textView) {
        new Handler(Looper.getMainLooper()).post(new aq(this, textView));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View currentFocus = getCurrentFocus();
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (currentFocus instanceof EditText) {
            currentFocus = getCurrentFocus();
            int[] iArr = new int[2];
            currentFocus.getLocationOnScreen(iArr);
            float rawX = (motionEvent.getRawX() + ((float) currentFocus.getLeft())) - ((float) iArr[0]);
            float rawY = (motionEvent.getRawY() + ((float) currentFocus.getTop())) - ((float) iArr[1]);
            if (motionEvent.getAction() == 1 && (rawX < ((float) currentFocus.getLeft()) || rawX >= ((float) currentFocus.getRight()) || rawY < ((float) currentFocus.getTop()) || rawY > ((float) currentFocus.getBottom()))) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return dispatchTouchEvent;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a a = c().a();
        Drawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.title));
        a.b();
        a.a();
        ((TextView) a.c().findViewById(R.id.abs_header)).setText(R.string.reset_passwd);
        a.a(bitmapDrawable);
        a.a((int) R.string.reset_passwd);
        a.a(true);
        setContentView((int) R.layout.activity_resetpasswd);
        overridePendingTransition(R.animator.trans_left_in, R.animator.trans_left_out);
        fn.e(this);
        EditText editText = (EditText) findViewById(R.id.userName_ResetPasswd);
        CharSequence b = fm.b(getApplicationContext());
        if (b.equals("")) {
            editText.setText("");
        } else {
            editText.setText(b);
        }
        this.q = (TextView) findViewById(R.id.textviewSendCode);
        if (l) {
            this.q.setEnabled(false);
            this.q.setTextColor(getResources().getColor(R.color.black2));
            this.q.setText(getResources().getString(R.string.send_authencodes_wait) + m);
            if (o != null) {
                o.cancel();
            }
            o = new Timer();
            o.schedule(new aj(this), 0, 2000);
        }
        this.q.setOnClickListener(new ak(this));
        ((TextView) findViewById(R.id.textviewResetPasswd)).setOnClickListener(new an(this));
        findViewById(R.id.linearlayout_resetpasswd).setOnTouchListener(new ap(this, this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.p != null && this.p.isShowing()) {
                this.p.dismiss();
                this.p = null;
            }
            finish();
            overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onStop() {
        super.onStop();
        if (this.p != null && this.p.isShowing()) {
            this.p.dismiss();
            this.p = null;
        }
    }
}
