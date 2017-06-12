package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.b;
import android.support.v4.c.a.a;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.lang.ref.WeakReference;

class y extends ah {
    ap a;
    private int n;
    private bh o = new bh();
    private boolean p;

    y(da daVar, aq aqVar) {
        super(daVar, aqVar);
        this.n = daVar.getResources().getInteger(17694720);
        bh bhVar = this.o;
        View a = bhVar.a();
        if (a != daVar) {
            if (a != null) {
                View a2 = bhVar.a();
                int size = bhVar.a.size();
                for (int i = 0; i < size; i++) {
                    if (a2.getAnimation() == ((bj) bhVar.a.get(i)).b) {
                        a2.clearAnimation();
                    }
                }
                bhVar.d = null;
                bhVar.b = null;
                bhVar.c = null;
            }
            if (daVar != null) {
                bhVar.d = new WeakReference(daVar);
            }
        }
        this.o.a(h, a(new ac()));
        this.o.a(i, a(new ac()));
        this.o.a(j, a(new ad()));
    }

    private Animation a(Animation animation) {
        animation.setInterpolator(a.b);
        animation.setDuration((long) this.n);
        return animation;
    }

    float a() {
        return this.f;
    }

    void a(float f) {
        if (this.a != null) {
            this.a.a(f, this.g + f);
            h();
        }
    }

    void a(int i) {
        if (this.c != null) {
            Drawable drawable = this.c;
            r1 = new int[3][];
            int[] iArr = new int[]{i, i, h};
            iArr[1] = i;
            r1[2] = new int[0];
            iArr[2] = 0;
            a.a(drawable, new ColorStateList(r1, iArr));
        }
    }

    final void a(ColorStateList colorStateList) {
        if (this.b != null) {
            a.a(this.b, colorStateList);
        }
        if (this.d != null) {
            k kVar = this.d;
            if (colorStateList != null) {
                kVar.f = colorStateList.getColorForState(kVar.getState(), kVar.f);
            }
            kVar.e = colorStateList;
            kVar.g = true;
            kVar.invalidateSelf();
        }
    }

    final void a(Mode mode) {
        if (this.b != null) {
            a.a(this.b, mode);
        }
    }

    void a(Rect rect) {
        this.a.getPadding(rect);
    }

    void a(int[] iArr) {
        bj bjVar;
        bh bhVar = this.o;
        int size = bhVar.a.size();
        for (int i = 0; i < size; i++) {
            bj bjVar2 = (bj) bhVar.a.get(i);
            if (StateSet.stateSetMatches(bjVar2.a, iArr)) {
                bjVar = bjVar2;
                break;
            }
        }
        bjVar = null;
        if (bjVar != bhVar.b) {
            View a;
            if (!(bhVar.b == null || bhVar.c == null)) {
                a = bhVar.a();
                if (a != null && a.getAnimation() == bhVar.c) {
                    a.clearAnimation();
                }
                bhVar.c = null;
            }
            bhVar.b = bjVar;
            a = (View) bhVar.d.get();
            if (bjVar != null && a != null && a.getVisibility() == 0) {
                bhVar.c = bjVar.b;
                a = bhVar.a();
                if (a != null) {
                    a.startAnimation(bhVar.c);
                }
            }
        }
    }

    void b() {
        bh bhVar = this.o;
        if (bhVar.c != null) {
            View a = bhVar.a();
            if (a != null && a.getAnimation() == bhVar.c) {
                a.clearAnimation();
            }
        }
    }

    void c() {
        if (!this.p && this.k.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), b.design_fab_out);
            loadAnimation.setInterpolator(a.c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new z(this));
            this.k.startAnimation(loadAnimation);
        }
    }

    void d() {
        if (this.k.getVisibility() != 0 || this.p) {
            this.k.clearAnimation();
            this.k.a(0, false);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), b.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(a.d);
            loadAnimation.setAnimationListener(new aa(this));
            this.k.startAnimation(loadAnimation);
        }
    }

    void e() {
    }
}
