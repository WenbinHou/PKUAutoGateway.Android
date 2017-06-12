package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.widget.ft;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements k, z, OnItemClickListener {
    private static final int[] a = new int[]{16842964, 16843049};
    private i b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ft a = ft.a(context, attributeSet, a, i);
        if (a.e(0)) {
            setBackgroundDrawable(a.a(0));
        }
        if (a.e(1)) {
            setDivider(a.a(1));
        }
        a.a.recycle();
    }

    public final void a(i iVar) {
        this.b = iVar;
    }

    public final boolean a(m mVar) {
        return this.b.a((MenuItem) mVar, null, 0);
    }

    public final int getWindowAnimations() {
        return this.c;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((m) getAdapter().getItem(i));
    }
}
