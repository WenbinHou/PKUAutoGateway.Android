package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.bq;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.b.b;
import android.support.v7.b.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

final class d {
    TextView A;
    TextView B;
    View C;
    ListAdapter D;
    int E = -1;
    int F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L = 0;
    Handler M;
    final OnClickListener N = new e(this);
    final Context a;
    final aq b;
    final Window c;
    CharSequence d;
    CharSequence e;
    ListView f;
    View g;
    int h;
    int i;
    int j;
    int k;
    int l;
    boolean m = false;
    Button n;
    CharSequence o;
    Message p;
    Button q;
    CharSequence r;
    Message s;
    Button t;
    CharSequence u;
    Message v;
    NestedScrollView w;
    int x = 0;
    Drawable y;
    ImageView z;

    public d(Context context, aq aqVar, Window window) {
        this.a = context;
        this.b = aqVar;
        this.c = window;
        this.M = new o(aqVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, l.AlertDialog, b.alertDialogStyle, 0);
        this.F = obtainStyledAttributes.getResourceId(l.AlertDialog_android_layout, 0);
        this.G = obtainStyledAttributes.getResourceId(l.AlertDialog_buttonPanelSideLayout, 0);
        this.H = obtainStyledAttributes.getResourceId(l.AlertDialog_listLayout, 0);
        this.I = obtainStyledAttributes.getResourceId(l.AlertDialog_multiChoiceItemLayout, 0);
        this.J = obtainStyledAttributes.getResourceId(l.AlertDialog_singleChoiceItemLayout, 0);
        this.K = obtainStyledAttributes.getResourceId(l.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
    }

    static ViewGroup a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    static /* synthetic */ void a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(bq.b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!bq.b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i) {
        this.y = null;
        this.x = i;
        if (this.z == null) {
            return;
        }
        if (i != 0) {
            this.z.setVisibility(0);
            this.z.setImageResource(this.x);
            return;
        }
        this.z.setVisibility(8);
    }

    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (onClickListener != null) {
            message = this.M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.u = charSequence;
                this.v = message;
                return;
            case -2:
                this.r = charSequence;
                this.s = message;
                return;
            case -1:
                this.o = charSequence;
                this.p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void a(CharSequence charSequence) {
        this.d = charSequence;
        if (this.A != null) {
            this.A.setText(charSequence);
        }
    }
}
