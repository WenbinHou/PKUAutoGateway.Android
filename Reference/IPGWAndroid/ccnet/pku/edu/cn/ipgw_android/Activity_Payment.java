package ccnet.pku.edu.cn.ipgw_android;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.a.a;
import android.support.v7.a.q;
import android.support.v7.a.s;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_Payment extends s {
    q l = null;
    private Handler m = new ah(this);

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
        ((TextView) a.c().findViewById(R.id.abs_header)).setText(R.string.pay);
        a.a(bitmapDrawable);
        a.a((int) R.string.pay);
        a.a(true);
        setContentView((int) R.layout.activity_payment);
        overridePendingTransition(R.animator.trans_left_in, R.animator.trans_left_out);
        fn.e(this);
        EditText editText = (EditText) findViewById(R.id.userName_Pay);
        EditText editText2 = (EditText) findViewById(R.id.passwd_Pay);
        CharSequence b = fm.b(getApplicationContext());
        if (b.equals("")) {
            editText.setText("");
            editText2.setText("");
        } else {
            editText.setText(b);
            CharSequence a2 = fm.a();
            if (a2.equals("")) {
                editText2.setText("");
            } else {
                editText2.setText(a2);
            }
        }
        ((TextView) findViewById(R.id.textviewpay)).setOnClickListener(new v(this));
        findViewById(R.id.linearlayout_pay).setOnTouchListener(new w(this, this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.l != null && this.l.isShowing()) {
                this.l.dismiss();
                this.l = null;
            }
            finish();
            overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onStop() {
        super.onStop();
        if (this.l != null && this.l.isShowing()) {
            this.l.dismiss();
            this.l = null;
        }
    }
}
