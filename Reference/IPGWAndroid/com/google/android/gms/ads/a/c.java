package com.google.android.gms.ads.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.internal.client.b;
import com.google.android.gms.ads.internal.client.k;
import com.google.android.gms.b.bd;

public final class c extends ViewGroup {
    private final b a;

    public final a getAdListener() {
        return this.a.a;
    }

    public final com.google.android.gms.ads.c getAdSize() {
        return this.a.a();
    }

    public final com.google.android.gms.ads.c[] getAdSizes() {
        return this.a.c;
    }

    public final String getAdUnitId() {
        return this.a.d;
    }

    public final a getAppEventListener() {
        return this.a.e;
    }

    public final String getMediationAdapterClassName() {
        return this.a.b();
    }

    public final b getOnCustomRenderedAdLoadedListener() {
        return this.a.h;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected final void onMeasure(int i, int i2) {
        int b;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            com.google.android.gms.ads.c adSize = getAdSize();
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

    public final void setAdListener(a aVar) {
        this.a.a(aVar);
    }

    public final void setAdSizes(com.google.android.gms.ads.c... cVarArr) {
        if (cVarArr == null || cVarArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.a.b(cVarArr);
    }

    public final void setAdUnitId(String str) {
        this.a.a(str);
    }

    public final void setAppEventListener(a aVar) {
        b bVar = this.a;
        try {
            bVar.e = aVar;
            if (bVar.b != null && aVar != null) {
                k kVar = new k(aVar);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the AppEventListener.", e);
        }
    }

    public final void setCorrelator(f fVar) {
        this.a.j = fVar;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.a.i = z;
    }

    public final void setOnCustomRenderedAdLoadedListener(b bVar) {
        b bVar2 = this.a;
        bVar2.h = bVar;
        try {
            if (bVar2.b != null && bVar != null) {
                bd bdVar = new bd(bVar);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }
}
