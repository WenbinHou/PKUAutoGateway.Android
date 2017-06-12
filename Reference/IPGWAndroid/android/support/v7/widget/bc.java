package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.bq;
import android.support.v7.b.b;
import android.util.AttributeSet;
import android.widget.RatingBar;

public final class bc extends RatingBar {
    private ba a;
    private ao b;

    public bc(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.ratingBarStyle);
    }

    private bc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = ao.a();
        this.a = new ba(this, this.b);
        this.a.a(attributeSet, i);
    }

    protected final synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = this.a.b;
        if (bitmap != null) {
            setMeasuredDimension(bq.a(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
