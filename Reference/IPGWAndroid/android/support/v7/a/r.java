package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import ccnet.pku.edu.cn.ipgw_android.R;

public final class r {
    public final j a;
    private int b;

    public r(Context context) {
        this(context, q.a(context, 0));
    }

    private r(Context context, int i) {
        this.a = new j(new ContextThemeWrapper(context, q.a(context, i)));
        this.b = i;
    }

    public final q a() {
        q qVar = new q(this.a.a, this.b);
        j jVar = this.a;
        d a = qVar.a;
        if (jVar.g != null) {
            a.C = jVar.g;
        } else {
            if (jVar.f != null) {
                a.a(jVar.f);
            }
            if (jVar.d != null) {
                Drawable drawable = jVar.d;
                a.y = drawable;
                a.x = 0;
                if (a.z != null) {
                    if (drawable != null) {
                        a.z.setVisibility(0);
                        a.z.setImageDrawable(drawable);
                    } else {
                        a.z.setVisibility(8);
                    }
                }
            }
            if (jVar.c != 0) {
                a.a(jVar.c);
            }
            if (jVar.e != 0) {
                int i = jVar.e;
                TypedValue typedValue = new TypedValue();
                a.a.getTheme().resolveAttribute(i, typedValue, true);
                a.a(typedValue.resourceId);
            }
        }
        if (jVar.h != null) {
            CharSequence charSequence = jVar.h;
            a.e = charSequence;
            if (a.B != null) {
                a.B.setText(charSequence);
            }
        }
        if (jVar.i != null) {
            a.a(-1, jVar.i, jVar.j, null);
        }
        if (jVar.k != null) {
            a.a(-2, jVar.k, jVar.l, null);
        }
        if (jVar.m != null) {
            a.a(-3, jVar.m, jVar.n, null);
        }
        if (!(jVar.s == null && jVar.H == null && jVar.t == null)) {
            ListAdapter pVar;
            ListView listView = (ListView) jVar.b.inflate(a.H, null);
            Object simpleCursorAdapter;
            if (!jVar.D) {
                int i2 = jVar.E ? a.J : a.K;
                if (jVar.H != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(jVar.a, i2, jVar.H, new String[]{jVar.I}, new int[]{16908308});
                } else {
                    pVar = jVar.t != null ? jVar.t : new p(jVar.a, i2, jVar.s);
                }
            } else if (jVar.H == null) {
                pVar = new k(jVar, jVar.a, a.I, jVar.s, listView);
            } else {
                simpleCursorAdapter = new l(jVar, jVar.a, jVar.H, listView, a);
            }
            a.D = pVar;
            a.E = jVar.F;
            if (jVar.u != null) {
                listView.setOnItemClickListener(new m(jVar, a));
            } else if (jVar.G != null) {
                listView.setOnItemClickListener(new n(jVar, listView, a));
            }
            if (jVar.K != null) {
                listView.setOnItemSelectedListener(jVar.K);
            }
            if (jVar.E) {
                listView.setChoiceMode(1);
            } else if (jVar.D) {
                listView.setChoiceMode(2);
            }
            a.f = listView;
        }
        if (jVar.w != null) {
            if (jVar.B) {
                View view = jVar.w;
                int i3 = jVar.x;
                int i4 = jVar.y;
                int i5 = jVar.z;
                int i6 = jVar.A;
                a.g = view;
                a.h = 0;
                a.m = true;
                a.i = i3;
                a.j = i4;
                a.k = i5;
                a.l = i6;
            } else {
                a.g = jVar.w;
                a.h = 0;
                a.m = false;
            }
        } else if (jVar.v != 0) {
            i = jVar.v;
            a.g = null;
            a.h = i;
            a.m = false;
        }
        qVar.setCancelable(this.a.o);
        if (this.a.o) {
            qVar.setCanceledOnTouchOutside(true);
        }
        qVar.setOnCancelListener(this.a.p);
        qVar.setOnDismissListener(this.a.q);
        if (this.a.r != null) {
            qVar.setOnKeyListener(this.a.r);
        }
        return qVar;
    }

    public final r a(int i) {
        this.a.f = this.a.a.getText(i);
        return this;
    }

    public final r a(OnClickListener onClickListener) {
        this.a.k = this.a.a.getText(R.string.ok);
        this.a.l = onClickListener;
        return this;
    }

    public final r a(CharSequence charSequence) {
        this.a.f = charSequence;
        return this;
    }

    public final r b(CharSequence charSequence) {
        this.a.h = charSequence;
        return this;
    }
}
