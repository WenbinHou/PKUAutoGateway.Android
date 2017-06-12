package android.support.design.widget;

import android.support.v4.view.bq;

class ae extends y {
    private boolean n;

    ae(da daVar, aq aqVar) {
        super(daVar, aqVar);
    }

    final void c() {
        if (!this.n && this.k.getVisibility() == 0) {
            if (!bq.F(this.k) || this.k.isInEditMode()) {
                this.k.a(8, false);
                return;
            }
            this.k.animate().cancel();
            this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(a.c).setListener(new af(this));
        }
    }

    final void d() {
        if (!this.n && this.k.getVisibility() == 0) {
            return;
        }
        if (!bq.F(this.k) || this.k.isInEditMode()) {
            this.k.a(0, false);
            this.k.setAlpha(1.0f);
            this.k.setScaleY(1.0f);
            this.k.setScaleX(1.0f);
            return;
        }
        this.k.animate().cancel();
        if (this.k.getVisibility() != 0) {
            this.k.setAlpha(0.0f);
            this.k.setScaleY(0.0f);
            this.k.setScaleX(0.0f);
        }
        this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(a.d).setListener(new ag(this));
    }

    boolean f() {
        return true;
    }

    final void g() {
        float rotation = this.k.getRotation();
        if (this.a != null) {
            ap apVar = this.a;
            float f = -rotation;
            if (apVar.k != f) {
                apVar.k = f;
                apVar.invalidateSelf();
            }
        }
        if (this.d != null) {
            k kVar = this.d;
            rotation = -rotation;
            if (rotation != kVar.h) {
                kVar.h = rotation;
                kVar.invalidateSelf();
            }
        }
    }
}
