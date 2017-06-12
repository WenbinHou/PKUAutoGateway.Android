package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class u {
    static int a = -1;

    u() {
    }

    public static u a(Activity activity, t tVar) {
        return a(activity, activity.getWindow(), tVar);
    }

    public static u a(Dialog dialog, t tVar) {
        return a(dialog.getContext(), dialog.getWindow(), tVar);
    }

    private static u a(Context context, Window window, t tVar) {
        int i = VERSION.SDK_INT;
        return i >= 23 ? new aa(context, window, tVar) : i >= 14 ? new y(context, window, tVar) : i >= 11 ? new x(context, window, tVar) : new ac(context, window, tVar);
    }

    public abstract a a();

    public abstract View a(int i);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract void b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, LayoutParams layoutParams);

    public abstract void c();

    public abstract boolean c(int i);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract boolean i();
}
