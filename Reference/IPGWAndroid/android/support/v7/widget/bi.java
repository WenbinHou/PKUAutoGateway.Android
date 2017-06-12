package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.bq;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

final class bi extends cu {
    CharSequence a;
    final /* synthetic */ bf b;
    private ListAdapter n;
    private final Rect o = new Rect();

    public bi(bf bfVar, Context context, AttributeSet attributeSet, int i) {
        this.b = bfVar;
        super(context, attributeSet, i);
        this.l = bfVar;
        c();
        this.k = 0;
        this.m = new bj(this, bfVar);
    }

    static /* synthetic */ boolean a(bi biVar, View view) {
        return bq.H(view) && view.getGlobalVisibleRect(biVar.o);
    }

    final void a() {
        int i;
        Drawable background = this.c.getBackground();
        if (background != null) {
            background.getPadding(this.b.l);
            i = gi.a(this.b) ? this.b.l.right : -this.b.l.left;
        } else {
            Rect b = this.b.l;
            this.b.l.right = 0;
            b.left = 0;
            i = 0;
        }
        int paddingLeft = this.b.getPaddingLeft();
        int paddingRight = this.b.getPaddingRight();
        int width = this.b.getWidth();
        if (this.b.k == -2) {
            int a = this.b.a((SpinnerAdapter) this.n, this.c.getBackground());
            int i2 = (this.b.getContext().getResources().getDisplayMetrics().widthPixels - this.b.l.left) - this.b.l.right;
            if (a <= i2) {
                i2 = a;
            }
            a(Math.max(i2, (width - paddingLeft) - paddingRight));
        } else if (this.b.k == -1) {
            a((width - paddingLeft) - paddingRight);
        } else {
            a(this.b.k);
        }
        this.f = gi.a(this.b) ? ((width - paddingRight) - this.e) + i : i + paddingLeft;
    }

    public final void a(ListAdapter listAdapter) {
        super.a(listAdapter);
        this.n = listAdapter;
    }

    public final void b() {
        boolean isShowing = this.c.isShowing();
        a();
        e();
        super.b();
        this.d.setChoiceMode(1);
        int selectedItemPosition = this.b.getSelectedItemPosition();
        cx cxVar = this.d;
        if (this.c.isShowing() && cxVar != null) {
            cxVar.h = false;
            cxVar.setSelection(selectedItemPosition);
            if (VERSION.SDK_INT >= 11 && cxVar.getChoiceMode() != 0) {
                cxVar.setItemChecked(selectedItemPosition, true);
            }
        }
        if (!isShowing) {
            ViewTreeObserver viewTreeObserver = this.b.getViewTreeObserver();
            if (viewTreeObserver != null) {
                OnGlobalLayoutListener bkVar = new bk(this);
                viewTreeObserver.addOnGlobalLayoutListener(bkVar);
                a(new bl(this, bkVar));
            }
        }
    }
}
