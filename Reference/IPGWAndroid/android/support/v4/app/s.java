package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.PrintWriter;

final class s extends w<q> {
    final /* synthetic */ q a;

    public s(q qVar) {
        this.a = qVar;
        super(qVar);
    }

    public final View a(int i) {
        return this.a.findViewById(i);
    }

    public final void a(n nVar, Intent intent, int i) {
        Activity activity = this.a;
        activity.j = true;
        if (i == -1) {
            try {
                a.a(activity, intent, -1);
            } finally {
                activity.j = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            a.a(activity, intent, ((activity.a(nVar) + 1) << 16) + (65535 & i));
            activity.j = false;
        }
    }

    public final void a(String str, PrintWriter printWriter, String[] strArr) {
        this.a.dump(str, null, printWriter, strArr);
    }

    public final boolean a() {
        Window window = this.a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public final boolean b() {
        return !this.a.isFinishing();
    }

    public final LayoutInflater c() {
        return this.a.getLayoutInflater().cloneInContext(this.a);
    }

    public final void d() {
        this.a.b();
    }

    public final boolean e() {
        return this.a.getWindow() != null;
    }

    public final int f() {
        Window window = this.a.getWindow();
        return window == null ? 0 : window.getAttributes().windowAnimations;
    }
}
