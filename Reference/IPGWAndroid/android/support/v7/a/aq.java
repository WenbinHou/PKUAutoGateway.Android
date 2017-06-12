package android.support.v7.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.b.b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class aq extends Dialog implements t {
    private u a;

    public aq(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(b.dialogTheme, typedValue, true);
            i = typedValue.resourceId;
        }
        super(context, i);
        a().a(null);
        a().i();
    }

    public final u a() {
        if (this.a == null) {
            this.a = u.a((Dialog) this, (t) this);
        }
        return this.a;
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    public View findViewById(int i) {
        return a().a(i);
    }

    public void invalidateOptionsMenu() {
        a().f();
    }

    protected void onCreate(Bundle bundle) {
        a().h();
        super.onCreate(bundle);
        a().a(bundle);
    }

    protected void onStop() {
        super.onStop();
        a().d();
    }

    public void setContentView(int i) {
        a().b(i);
    }

    public void setContentView(View view) {
        a().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }
}
