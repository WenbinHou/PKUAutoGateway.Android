package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;

public final class em {
    int a;
    private int b;
    private int c;
    private int d;
    private Interpolator e;
    private boolean f;
    private int g;

    static /* synthetic */ void a(em emVar, RecyclerView recyclerView) {
        if (emVar.a >= 0) {
            int i = emVar.a;
            emVar.a = -1;
            RecyclerView.c(recyclerView, i);
            emVar.f = false;
        } else if (!emVar.f) {
            emVar.g = 0;
        } else if (emVar.e != null && emVar.d <= 0) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (emVar.d <= 0) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        } else {
            if (emVar.e != null) {
                recyclerView.n.a(emVar.b, emVar.c, emVar.d, emVar.e);
            } else if (emVar.d == Integer.MIN_VALUE) {
                recyclerView.n.a(emVar.b, emVar.c);
            } else {
                recyclerView.n.a(emVar.b, emVar.c, emVar.d);
            }
            emVar.g++;
            if (emVar.g > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            emVar.f = false;
        }
    }
}
