package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.bq;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

final class br extends LinearLayout {
    int a = -1;
    float b;
    bz c;
    final /* synthetic */ TabLayout d;
    private int e;
    private final Paint f;
    private int g = -1;
    private int h = -1;

    br(TabLayout tabLayout, Context context) {
        this.d = tabLayout;
        super(context);
        setWillNotDraw(false);
        this.f = new Paint();
    }

    private void b(int i, int i2) {
        if (i != this.g || i2 != this.h) {
            this.g = i;
            this.h = i2;
            bq.d(this);
        }
    }

    final void a() {
        int i;
        int i2;
        View childAt = getChildAt(this.a);
        if (childAt == null || childAt.getWidth() <= 0) {
            i = -1;
            i2 = -1;
        } else {
            i = childAt.getLeft();
            i2 = childAt.getRight();
            if (this.b > 0.0f && this.a < getChildCount() - 1) {
                View childAt2 = getChildAt(this.a + 1);
                i = (int) ((((float) i) * (1.0f - this.b)) + (this.b * ((float) childAt2.getLeft())));
                i2 = (int) ((((float) i2) * (1.0f - this.b)) + (((float) childAt2.getRight()) * this.b));
            }
        }
        b(i, i2);
    }

    final void a(int i) {
        if (this.f.getColor() != i) {
            this.f.setColor(i);
            bq.d(this);
        }
    }

    final void a(int i, int i2) {
        if (this.c != null && this.c.a.b()) {
            this.c.a.e();
        }
        Object obj = bq.h(this) == 1 ? 1 : null;
        View childAt = getChildAt(i);
        if (childAt == null) {
            a();
            return;
        }
        int i3;
        int i4;
        int left = childAt.getLeft();
        int right = childAt.getRight();
        if (Math.abs(i - this.a) <= 1) {
            i3 = this.g;
            i4 = this.h;
        } else {
            int a = this.d.b(24);
            if (i < this.a) {
                if (obj == null) {
                    i4 = right + a;
                    i3 = i4;
                }
            } else if (obj != null) {
                i4 = right + a;
                i3 = i4;
            }
            i4 = left - a;
            i3 = i4;
        }
        if (i3 != left || i4 != right) {
            bz a2 = cv.a();
            this.c = a2;
            a2.a(a.b);
            a2.a(i2);
            a2.a(0.0f, 1.0f);
            a2.a(new bs(this, i3, left, i4, right));
            a2.a.a(new cb(a2, new bt(this, i)));
            a2.a.a();
        }
    }

    final void b(int i) {
        if (this.e != i) {
            this.e = i;
            bq.d(this);
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g >= 0 && this.h > this.g) {
            canvas.drawRect((float) this.g, (float) (getHeight() - this.e), (float) this.h, (float) getHeight(), this.f);
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c == null || !this.c.a.b()) {
            a();
            return;
        }
        this.c.a.e();
        a(this.a, Math.round(((float) this.c.a.g()) * (1.0f - this.c.a.f())));
    }

    protected final void onMeasure(int i, int i2) {
        Object obj = null;
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i) == 1073741824 && this.d.t == 1 && this.d.s == 1) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                i3++;
                i4 = childAt.getVisibility() == 0 ? Math.max(i4, childAt.getMeasuredWidth()) : i4;
            }
            if (i4 > 0) {
                if (i4 * childCount <= getMeasuredWidth() - (this.d.b(16) * 2)) {
                    i3 = 0;
                    while (i3 < childCount) {
                        Object obj2;
                        LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                        if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                            obj2 = obj;
                        } else {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            obj2 = 1;
                        }
                        i3++;
                        obj = obj2;
                    }
                } else {
                    this.d.s = 0;
                    this.d.a(false);
                    obj = 1;
                }
                if (obj != null) {
                    super.onMeasure(i, i2);
                }
            }
        }
    }
}
