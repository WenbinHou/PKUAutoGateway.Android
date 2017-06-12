package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.a;
import android.support.v4.view.ay;
import android.support.v4.view.dk;
import android.support.v4.widget.w;
import android.support.v7.b.b;
import android.view.MotionEvent;
import android.view.View;

final class cx extends dg {
    private boolean h;
    private boolean i;
    private boolean j;
    private dk k;
    private w l;

    public cx(Context context, boolean z) {
        super(context, b.dropDownListViewStyle);
        this.i = z;
        setCacheColorHint(0);
    }

    protected final boolean a() {
        return this.j || super.a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        Object obj;
        View childAt;
        boolean z2 = true;
        int a = ay.a(motionEvent);
        switch (a) {
            case 1:
                z2 = false;
                break;
            case 2:
                break;
            case 3:
                z = false;
                obj = null;
                break;
            default:
                z = z2;
                obj = null;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            obj = null;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z = z2;
                int i2 = 1;
            } else {
                View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                float f = (float) x;
                float f2 = (float) findPointerIndex;
                this.j = true;
                if (VERSION.SDK_INT >= 21) {
                    drawableHotspotChanged(f, f2);
                }
                if (!isPressed()) {
                    setPressed(true);
                }
                layoutChildren();
                if (this.f != -1) {
                    childAt = getChildAt(this.f - getFirstVisiblePosition());
                    if (!(childAt == null || childAt == childAt2 || !childAt.isPressed())) {
                        childAt.setPressed(false);
                    }
                }
                this.f = pointToPosition;
                float left = f - ((float) childAt2.getLeft());
                float top = f2 - ((float) childAt2.getTop());
                if (VERSION.SDK_INT >= 21) {
                    childAt2.drawableHotspotChanged(left, top);
                }
                if (!childAt2.isPressed()) {
                    childAt2.setPressed(true);
                }
                Drawable selector = getSelector();
                Object obj2 = (selector == null || pointToPosition == -1) ? null : 1;
                if (obj2 != null) {
                    selector.setVisible(false, false);
                }
                Rect rect = this.a;
                rect.set(childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getBottom());
                rect.left -= this.b;
                rect.top -= this.c;
                rect.right += this.d;
                rect.bottom += this.e;
                try {
                    z2 = this.g.getBoolean(this);
                    if (childAt2.isEnabled() != z2) {
                        this.g.set(this, Boolean.valueOf(!z2));
                        if (pointToPosition != -1) {
                            refreshDrawableState();
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (obj2 != null) {
                    rect = this.a;
                    top = rect.exactCenterX();
                    float exactCenterY = rect.exactCenterY();
                    selector.setVisible(getVisibility() == 0, false);
                    a.a(selector, top, exactCenterY);
                }
                Drawable selector2 = getSelector();
                if (!(selector2 == null || pointToPosition == -1)) {
                    a.a(selector2, f, f2);
                }
                setSelectorEnabled(false);
                refreshDrawableState();
                z2 = true;
                if (a == 1) {
                    performItemClick(childAt2, pointToPosition, getItemIdAtPosition(pointToPosition));
                }
                z = z2;
                obj = null;
            }
        }
        if (!(z && r0 == null)) {
            this.j = false;
            setPressed(false);
            drawableStateChanged();
            childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            if (this.k != null) {
                this.k.a();
                this.k = null;
            }
        }
        if (z) {
            if (this.l == null) {
                this.l = new w(this);
            }
            this.l.a(true);
            this.l.onTouch(this, motionEvent);
        } else if (this.l != null) {
            this.l.a(false);
        }
        return z;
    }

    public final boolean hasFocus() {
        return this.i || super.hasFocus();
    }

    public final boolean hasWindowFocus() {
        return this.i || super.hasWindowFocus();
    }

    public final boolean isFocused() {
        return this.i || super.isFocused();
    }

    public final boolean isInTouchMode() {
        return (this.i && this.h) || super.isInTouchMode();
    }
}
