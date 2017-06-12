package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class fk implements OnTouchListener {
    private final GestureDetector a;

    public fk(Context context) {
        this.a = new GestureDetector(context, new fl());
    }

    public void a() {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
