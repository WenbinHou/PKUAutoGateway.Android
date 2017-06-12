package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.z;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NavigationMenuView extends RecyclerView implements z {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }

    public final void a(i iVar) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}
