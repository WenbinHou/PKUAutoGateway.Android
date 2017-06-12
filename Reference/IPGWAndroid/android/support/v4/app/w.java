package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.g.r;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class w<E> extends u {
    final Activity b;
    final Context c;
    final Handler d;
    final int e;
    public final y f;
    r<String, at> g;
    boolean h;
    av i;
    boolean j;
    boolean k;

    private w(Activity activity, Context context, Handler handler) {
        this.f = new y();
        this.b = activity;
        this.c = context;
        this.d = handler;
        this.e = 0;
    }

    w(q qVar) {
        this(qVar, qVar, qVar.a);
    }

    public View a(int i) {
        return null;
    }

    public void a(n nVar, Intent intent, int i) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.c.startActivity(intent);
    }

    final void a(String str) {
        if (this.g != null) {
            av avVar = (av) this.g.get(str);
            if (avVar != null && !avVar.f) {
                avVar.g();
                this.g.remove(str);
            }
        }
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    final av b(String str) {
        if (this.g == null) {
            this.g = new r();
        }
        av avVar = (av) this.g.get(str);
        if (avVar != null) {
            avVar.g = this;
        }
        return avVar;
    }

    public boolean b() {
        return true;
    }

    public LayoutInflater c() {
        return (LayoutInflater) this.c.getSystemService("layout_inflater");
    }

    public void d() {
    }

    public boolean e() {
        return true;
    }

    public int f() {
        return this.e;
    }

    final r<String, at> g() {
        int i;
        int i2 = 0;
        if (this.g != null) {
            int size = this.g.size();
            av[] avVarArr = new av[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                avVarArr[i3] = (av) this.g.c(i3);
            }
            i = 0;
            while (i2 < size) {
                av avVar = avVarArr[i2];
                if (avVar.f) {
                    i = 1;
                } else {
                    avVar.g();
                    this.g.remove(avVar.d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        return i != 0 ? this.g : null;
    }
}
