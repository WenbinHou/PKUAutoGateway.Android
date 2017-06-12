package android.support.v7.a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.support.v4.view.bq;
import android.support.v4.widget.af;
import android.support.v7.b.b;
import android.support.v7.b.g;
import android.support.v7.view.c;
import android.support.v7.view.e;
import android.support.v7.view.f;
import android.support.v7.view.h;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ViewStubCompat;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Window.Callback;
import android.widget.PopupWindow;

class z extends w {
    final /* synthetic */ y b;

    z(y yVar, Callback callback) {
        this.b = yVar;
        super(yVar, callback);
    }

    final ActionMode a(ActionMode.Callback callback) {
        Object hVar = new h(this.b.b, callback);
        ac acVar = this.b;
        if (acVar.q != null) {
            acVar.q.c();
        }
        c alVar = new al(acVar, hVar);
        a a = acVar.a();
        if (a != null) {
            acVar.q = a.a(alVar);
        }
        if (acVar.q == null) {
            acVar.l();
            if (acVar.q != null) {
                acVar.q.c();
            }
            c alVar2 = new al(acVar, alVar);
            if (acVar.r == null) {
                if (acVar.l) {
                    Context eVar;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = acVar.b.getTheme();
                    theme.resolveAttribute(b.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = acVar.b.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        eVar = new e(acVar.b, 0);
                        eVar.getTheme().setTo(newTheme);
                    } else {
                        eVar = acVar.b;
                    }
                    acVar.r = new ActionBarContextView(eVar);
                    acVar.s = new PopupWindow(eVar, null, b.actionModePopupWindowStyle);
                    af.a(acVar.s, 2);
                    acVar.s.setContentView(acVar.r);
                    acVar.s.setWidth(-1);
                    eVar.getTheme().resolveAttribute(b.actionBarSize, typedValue, true);
                    acVar.r.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, eVar.getResources().getDisplayMetrics()));
                    acVar.s.setHeight(-2);
                    acVar.t = new ah(acVar);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) acVar.v.findViewById(g.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(acVar.k()));
                        acVar.r = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (acVar.r != null) {
                acVar.l();
                acVar.r.b();
                android.support.v7.view.b fVar = new f(acVar.r.getContext(), acVar.r, alVar2, acVar.s == null);
                if (alVar.a(fVar, fVar.b())) {
                    fVar.d();
                    acVar.r.a(fVar);
                    acVar.q = fVar;
                    bq.c(acVar.r, 0.0f);
                    acVar.u = bq.r(acVar.r).a(1.0f);
                    acVar.u.a(new aj(acVar));
                    if (acVar.s != null) {
                        acVar.c.getDecorView().post(acVar.t);
                    }
                } else {
                    acVar.q = null;
                }
            }
            acVar.q = acVar.q;
        }
        android.support.v7.view.b bVar = acVar.q;
        return bVar != null ? hVar.b(bVar) : null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.b.p ? a(callback) : super.onWindowStartingActionMode(callback);
    }
}
