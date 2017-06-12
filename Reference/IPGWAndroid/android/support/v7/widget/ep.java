package android.support.v7.widget;

import android.support.v4.e.e;
import android.support.v4.view.bq;
import android.support.v4.widget.ap;
import android.view.View;
import android.view.animation.Interpolator;

final class ep implements Runnable {
    int a;
    int b;
    ap c;
    final /* synthetic */ RecyclerView d;
    private Interpolator e = RecyclerView.ao;
    private boolean f = false;
    private boolean g = false;

    public ep(RecyclerView recyclerView) {
        this.d = recyclerView;
        this.c = ap.a(recyclerView.getContext(), RecyclerView.ao);
    }

    final void a() {
        if (this.f) {
            this.g = true;
            return;
        }
        this.d.removeCallbacks(this);
        bq.a(this.d, (Runnable) this);
    }

    public final void a(int i, int i2) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt(0.0d);
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.d.getWidth() : this.d.getHeight();
        int i3 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i3)) + ((float) i3);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(sin / ((float) sqrt))) * 4;
        } else {
            round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
        }
        a(i, i2, Math.min(round, 2000));
    }

    public final void a(int i, int i2, int i3) {
        a(i, i2, i3, RecyclerView.ao);
    }

    public final void a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.e != interpolator) {
            this.e = interpolator;
            this.c = ap.a(this.d.getContext(), interpolator);
        }
        this.d.setScrollState(2);
        this.b = 0;
        this.a = 0;
        this.c.a(0, 0, i, i2, i3);
        a();
    }

    public final void b() {
        this.d.removeCallbacks(this);
        this.c.h();
    }

    public final void run() {
        if (this.d.e == null) {
            b();
            return;
        }
        this.g = false;
        this.f = true;
        this.d.j();
        ap apVar = this.c;
        el elVar = this.d.e.r;
        if (apVar.g()) {
            int a;
            int i;
            int f;
            int i2;
            View view;
            Object obj;
            Object obj2;
            int b = apVar.b();
            int c = apVar.c();
            int i3 = b - this.a;
            int i4 = c - this.b;
            int i5 = 0;
            int i6 = 0;
            this.a = b;
            this.b = c;
            int i7 = 0;
            int i8 = 0;
            if (this.d.y != null) {
                this.d.a();
                this.d.p();
                e.a("RV Scroll");
                if (i3 != 0) {
                    i5 = this.d.e.a(i3, this.d.a, this.d.o);
                    i7 = i3 - i5;
                }
                if (i4 != 0) {
                    i6 = this.d.e.b(i4, this.d.a, this.d.o);
                    i8 = i4 - i6;
                }
                e.a();
                this.d.A();
                this.d.q();
                this.d.a(false);
                if (!(elVar == null || elVar.b || !elVar.c)) {
                    a = this.d.o.a();
                    if (a == 0) {
                        elVar.a();
                        i = i7;
                        i7 = i6;
                        i6 = i;
                        if (!this.d.A.isEmpty()) {
                            this.d.invalidate();
                        }
                        if (bq.a(this.d) != 2) {
                            this.d.b(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            f = (int) apVar.f();
                            if (i6 == b) {
                                a = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                                i2 = a;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != c) {
                                f = 0;
                            } else if (i8 < 0) {
                                f = -f;
                            } else if (i8 <= 0) {
                                f = 0;
                            }
                            if (bq.a(this.d) != 2) {
                                view = this.d;
                                if (i2 < 0) {
                                    view.b();
                                    view.i.a(-i2);
                                } else if (i2 > 0) {
                                    view.c();
                                    view.k.a(i2);
                                }
                                if (f < 0) {
                                    view.d();
                                    view.j.a(-f);
                                } else if (f > 0) {
                                    view.e();
                                    view.l.a(f);
                                }
                                if (!(i2 == 0 && f == 0)) {
                                    bq.d(view);
                                }
                            }
                            if ((i2 != 0 || i6 == b || apVar.d() == 0) && (f != 0 || i8 == c || apVar.e() == 0)) {
                                apVar.h();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.d.g();
                        }
                        if (!this.d.awakenScrollBars()) {
                            this.d.invalidate();
                        }
                        obj = (i4 == 0 && this.d.e.f() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.d.e.e() && i5 == i3) ? 1 : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                        if (!apVar.a() || obj2 == null) {
                            this.d.setScrollState(0);
                        } else {
                            a();
                        }
                    } else {
                        if (elVar.a >= a) {
                            elVar.a = a - 1;
                        }
                        el.a(elVar);
                    }
                }
            }
            i = i7;
            i7 = i6;
            i6 = i;
            if (this.d.A.isEmpty()) {
                this.d.invalidate();
            }
            if (bq.a(this.d) != 2) {
                this.d.b(i3, i4);
            }
            f = (int) apVar.f();
            if (i6 == b) {
                i2 = 0;
            } else {
                if (i6 >= 0) {
                    if (i6 <= 0) {
                    }
                }
                i2 = a;
            }
            if (i8 != c) {
                f = 0;
            } else if (i8 < 0) {
                f = -f;
            } else if (i8 <= 0) {
                f = 0;
            }
            if (bq.a(this.d) != 2) {
                view = this.d;
                if (i2 < 0) {
                    view.b();
                    view.i.a(-i2);
                } else if (i2 > 0) {
                    view.c();
                    view.k.a(i2);
                }
                if (f < 0) {
                    view.d();
                    view.j.a(-f);
                } else if (f > 0) {
                    view.e();
                    view.l.a(f);
                }
                bq.d(view);
            }
            apVar.h();
            this.d.g();
            if (this.d.awakenScrollBars()) {
                this.d.invalidate();
            }
            if (i4 == 0) {
            }
            if (i3 == 0) {
            }
            if (i3 == 0) {
            }
            if (apVar.a()) {
            }
            this.d.setScrollState(0);
        }
        if (elVar != null) {
            if (elVar.b) {
                el.a(elVar);
            }
            if (!this.g) {
                elVar.a();
            }
        }
        this.f = false;
        if (this.g) {
            a();
        }
    }
}
