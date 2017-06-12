package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.bq;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.b.b;
import android.support.v7.b.g;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public final class q extends aq implements DialogInterface {
    private d a = new d(getContext(), this, getWindow());

    q(Context context, int i) {
        super(context, a(context, i));
    }

    static int a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected final void onCreate(Bundle bundle) {
        int indexOfChild;
        super.onCreate(bundle);
        d dVar = this.a;
        dVar.b.a().c(1);
        int i = (dVar.G == 0 || dVar.L != 1) ? dVar.F : dVar.G;
        dVar.b.setContentView(i);
        View findViewById = dVar.c.findViewById(g.parentPanel);
        View findViewById2 = findViewById.findViewById(g.topPanel);
        View findViewById3 = findViewById.findViewById(g.contentPanel);
        View findViewById4 = findViewById.findViewById(g.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(g.customPanel);
        View inflate = dVar.g != null ? dVar.g : dVar.h != 0 ? LayoutInflater.from(dVar.a).inflate(dVar.h, viewGroup, false) : null;
        Object obj = inflate != null ? 1 : null;
        if (obj == null || !d.a(inflate)) {
            dVar.c.setFlags(131072, 131072);
        }
        if (obj != null) {
            FrameLayout frameLayout = (FrameLayout) dVar.c.findViewById(g.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (dVar.m) {
                frameLayout.setPadding(dVar.i, dVar.j, dVar.k, dVar.l);
            }
            if (dVar.f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(g.topPanel);
        inflate = viewGroup.findViewById(g.contentPanel);
        View findViewById6 = viewGroup.findViewById(g.buttonPanel);
        ViewGroup a = d.a(findViewById5, findViewById2);
        ViewGroup a2 = d.a(inflate, findViewById3);
        ViewGroup a3 = d.a(findViewById6, findViewById4);
        dVar.w = (NestedScrollView) dVar.c.findViewById(g.scrollView);
        dVar.w.setFocusable(false);
        dVar.w.setNestedScrollingEnabled(false);
        dVar.B = (TextView) a2.findViewById(16908299);
        if (dVar.B != null) {
            if (dVar.e != null) {
                dVar.B.setText(dVar.e);
            } else {
                dVar.B.setVisibility(8);
                dVar.w.removeView(dVar.B);
                if (dVar.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) dVar.w.getParent();
                    indexOfChild = viewGroup2.indexOfChild(dVar.w);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(dVar.f, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    a2.setVisibility(8);
                }
            }
        }
        indexOfChild = 0;
        dVar.n = (Button) a3.findViewById(16908313);
        dVar.n.setOnClickListener(dVar.N);
        if (TextUtils.isEmpty(dVar.o)) {
            dVar.n.setVisibility(8);
        } else {
            dVar.n.setText(dVar.o);
            dVar.n.setVisibility(0);
            indexOfChild = 1;
        }
        dVar.q = (Button) a3.findViewById(16908314);
        dVar.q.setOnClickListener(dVar.N);
        if (TextUtils.isEmpty(dVar.r)) {
            dVar.q.setVisibility(8);
        } else {
            dVar.q.setText(dVar.r);
            dVar.q.setVisibility(0);
            indexOfChild |= 2;
        }
        dVar.t = (Button) a3.findViewById(16908315);
        dVar.t.setOnClickListener(dVar.N);
        if (TextUtils.isEmpty(dVar.u)) {
            dVar.t.setVisibility(8);
        } else {
            dVar.t.setText(dVar.u);
            dVar.t.setVisibility(0);
            indexOfChild |= 4;
        }
        if ((indexOfChild != 0 ? 1 : null) == null) {
            a3.setVisibility(8);
        }
        if (dVar.C != null) {
            a.addView(dVar.C, 0, new LayoutParams(-1, -2));
            dVar.c.findViewById(g.title_template).setVisibility(8);
        } else {
            dVar.z = (ImageView) dVar.c.findViewById(16908294);
            if ((!TextUtils.isEmpty(dVar.d) ? 1 : null) != null) {
                dVar.A = (TextView) dVar.c.findViewById(g.alertTitle);
                dVar.A.setText(dVar.d);
                if (dVar.x != 0) {
                    dVar.z.setImageResource(dVar.x);
                } else if (dVar.y != null) {
                    dVar.z.setImageDrawable(dVar.y);
                } else {
                    dVar.A.setPadding(dVar.z.getPaddingLeft(), dVar.z.getPaddingTop(), dVar.z.getPaddingRight(), dVar.z.getPaddingBottom());
                    dVar.z.setVisibility(8);
                }
            } else {
                dVar.c.findViewById(g.title_template).setVisibility(8);
                dVar.z.setVisibility(8);
                a.setVisibility(8);
            }
        }
        Object obj2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? null : 1;
        obj = (a == null || a.getVisibility() == 8) ? null : 1;
        Object obj3 = (a3 == null || a3.getVisibility() == 8) ? null : 1;
        if (obj3 == null && a2 != null) {
            findViewById = a2.findViewById(g.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (!(obj == null || dVar.w == null)) {
            dVar.w.setClipToPadding(true);
        }
        if (obj2 == null) {
            inflate = dVar.f != null ? dVar.f : dVar.w;
            if (inflate != null) {
                int i2 = (obj != null ? 1 : 0) | (obj3 != null ? 2 : 0);
                findViewById5 = dVar.c.findViewById(g.scrollIndicatorUp);
                findViewById = dVar.c.findViewById(g.scrollIndicatorDown);
                if (VERSION.SDK_INT >= 23) {
                    bq.f(inflate, i2);
                    if (findViewById5 != null) {
                        a2.removeView(findViewById5);
                    }
                    if (findViewById != null) {
                        a2.removeView(findViewById);
                    }
                } else {
                    if (findViewById5 != null && (i2 & 1) == 0) {
                        a2.removeView(findViewById5);
                        findViewById5 = null;
                    }
                    if (findViewById != null && (i2 & 2) == 0) {
                        a2.removeView(findViewById);
                        findViewById = null;
                    }
                    if (!(findViewById5 == null && findViewById == null)) {
                        if (dVar.e != null) {
                            dVar.w.setOnScrollChangeListener(new f(dVar, findViewById5, findViewById));
                            dVar.w.post(new g(dVar, findViewById5, findViewById));
                        } else if (dVar.f != null) {
                            dVar.f.setOnScrollListener(new h(dVar, findViewById5, findViewById));
                            dVar.f.post(new i(dVar, findViewById5, findViewById));
                        } else {
                            if (findViewById5 != null) {
                                a2.removeView(findViewById5);
                            }
                            if (findViewById != null) {
                                a2.removeView(findViewById);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = dVar.f;
        if (listView != null && dVar.D != null) {
            listView.setAdapter(dVar.D);
            int i3 = dVar.E;
            if (i3 >= 0) {
                listView.setItemChecked(i3, true);
                listView.setSelection(i3);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        d dVar = this.a;
        boolean z = dVar.w != null && dVar.w.a(keyEvent);
        return z ? true : super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        d dVar = this.a;
        boolean z = dVar.w != null && dVar.w.a(keyEvent);
        return z ? true : super.onKeyUp(i, keyEvent);
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }
}
