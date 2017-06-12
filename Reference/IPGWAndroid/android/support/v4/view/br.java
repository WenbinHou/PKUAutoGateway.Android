package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

class br implements cd {
    WeakHashMap<View, dk> a = null;

    br() {
    }

    public void A(View view) {
    }

    public void B(View view) {
    }

    public boolean C(View view) {
        return false;
    }

    public boolean D(View view) {
        return view instanceof be ? ((be) view).isNestedScrollingEnabled() : false;
    }

    public ColorStateList E(View view) {
        return view instanceof bl ? ((bl) view).getSupportBackgroundTintList() : null;
    }

    public Mode F(View view) {
        return view instanceof bl ? ((bl) view).getSupportBackgroundTintMode() : null;
    }

    public void G(View view) {
        if (view instanceof be) {
            ((be) view).stopNestedScroll();
        }
    }

    public boolean H(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public float I(View view) {
        return x(view) + w(view);
    }

    public boolean J(View view) {
        return view.getWindowToken() != null;
    }

    public boolean K(View view) {
        return false;
    }

    public int a(int i, int i2) {
        return i | i2;
    }

    public int a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    public int a(View view) {
        return 2;
    }

    long a() {
        return 10;
    }

    public ed a(View view, ed edVar) {
        return edVar;
    }

    public void a(View view, float f) {
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public void a(View view, int i, Paint paint) {
    }

    public void a(View view, ColorStateList colorStateList) {
        if (view instanceof bl) {
            ((bl) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public void a(View view, Mode mode) {
        if (view instanceof bl) {
            ((bl) view).setSupportBackgroundTintMode(mode);
        }
    }

    public void a(View view, a aVar) {
    }

    public void a(View view, bi biVar) {
    }

    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, a() + j);
    }

    public void a(View view, boolean z) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public boolean a(View view, int i) {
        if (view instanceof bk) {
            boolean z;
            bk bkVar = (bk) view;
            int computeHorizontalScrollOffset = bkVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = bkVar.computeHorizontalScrollRange() - bkVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange != 0) {
                if (i < 0) {
                    z = computeHorizontalScrollOffset > 0;
                } else if (computeHorizontalScrollOffset < computeHorizontalScrollRange - 1) {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public ed b(View view, ed edVar) {
        return edVar;
    }

    public void b(View view, float f) {
    }

    public boolean b(View view) {
        return false;
    }

    public boolean b(View view, int i) {
        if (view instanceof bk) {
            boolean z;
            bk bkVar = (bk) view;
            int computeVerticalScrollOffset = bkVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = bkVar.computeVerticalScrollRange() - bkVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange != 0) {
                if (i < 0) {
                    z = computeVerticalScrollOffset > 0;
                } else if (computeVerticalScrollOffset < computeVerticalScrollRange - 1) {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void c(View view, float f) {
    }

    public void c(View view, int i) {
    }

    public boolean c(View view) {
        return false;
    }

    public void d(View view) {
        view.invalidate();
    }

    public void d(View view, float f) {
    }

    public void d(View view, int i) {
    }

    public int e(View view) {
        return 0;
    }

    public void e(View view, float f) {
    }

    public void e(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    public float f(View view) {
        return 1.0f;
    }

    public void f(View view, float f) {
    }

    public void f(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    public int g(View view) {
        return 0;
    }

    public int h(View view) {
        return 0;
    }

    public int i(View view) {
        return view.getMeasuredWidth();
    }

    public int j(View view) {
        return 0;
    }

    public void k(View view) {
    }

    public int l(View view) {
        return view.getPaddingLeft();
    }

    public int m(View view) {
        return view.getPaddingRight();
    }

    public boolean n(View view) {
        return true;
    }

    public float o(View view) {
        return 0.0f;
    }

    public float p(View view) {
        return 0.0f;
    }

    public float q(View view) {
        return 0.0f;
    }

    public int r(View view) {
        return ce.a(view);
    }

    public int s(View view) {
        return ce.b(view);
    }

    public dk t(View view) {
        return new dk(view);
    }

    public int u(View view) {
        return 0;
    }

    public void v(View view) {
    }

    public float w(View view) {
        return 0.0f;
    }

    public float x(View view) {
        return 0.0f;
    }

    public boolean y(View view) {
        return false;
    }

    public void z(View view) {
    }
}
