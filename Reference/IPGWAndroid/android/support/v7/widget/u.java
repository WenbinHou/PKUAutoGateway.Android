package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;

public final class u extends cp {
    @ExportedProperty
    public boolean a;
    @ExportedProperty
    public int b;
    @ExportedProperty
    public int c;
    @ExportedProperty
    public boolean d;
    @ExportedProperty
    public boolean e;
    boolean f;

    public u() {
        super(-2, -2);
        this.a = false;
    }

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public u(u uVar) {
        super(uVar);
        this.a = uVar.a;
    }

    public u(LayoutParams layoutParams) {
        super(layoutParams);
    }
}
