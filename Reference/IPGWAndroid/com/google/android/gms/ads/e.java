package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.b;
import com.google.android.gms.ads.purchase.a;
import com.google.android.gms.b.ew;

class e extends ViewGroup {
    private final b a;

    public a getAdListener() {
        return this.a.a;
    }

    public c getAdSize() {
        return this.a.a();
    }

    public String getAdUnitId() {
        return this.a.d;
    }

    public a getInAppPurchaseListener() {
        return this.a.f;
    }

    public String getMediationAdapterClassName() {
        return this.a.b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int b;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            c adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                b = adSize.b(context);
                i3 = adSize.a(context);
            } else {
                b = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            b = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(b, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(a aVar) {
        this.a.a(aVar);
        if (aVar != null && (aVar instanceof com.google.android.gms.ads.internal.client.a)) {
            this.a.a((com.google.android.gms.ads.internal.client.a) aVar);
        } else if (aVar == null) {
            this.a.a(null);
        }
    }

    public void setAdSize(c cVar) {
        this.a.a(cVar);
    }

    public void setAdUnitId(String str) {
        this.a.a(str);
    }

    public void setInAppPurchaseListener(a aVar) {
        b bVar = this.a;
        if (bVar.g != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            bVar.f = aVar;
            if (bVar.b != null && aVar != null) {
                ew ewVar = new ew(aVar);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the InAppPurchaseListener.", e);
        }
    }
}
