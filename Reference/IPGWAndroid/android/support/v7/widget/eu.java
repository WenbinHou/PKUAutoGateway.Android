package android.support.v7.widget;

import android.view.View;

final class eu {
    static int a(en enVar, dk dkVar, View view, View view2, eb ebVar, boolean z) {
        if (ebVar.l() == 0 || enVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(eb.a(view) - eb.a(view2)) + 1;
        }
        return Math.min(dkVar.e(), dkVar.b(view2) - dkVar.a(view));
    }

    static int a(en enVar, dk dkVar, View view, View view2, eb ebVar, boolean z, boolean z2) {
        if (ebVar.l() == 0 || enVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (enVar.a() - Math.max(eb.a(view), eb.a(view2))) - 1) : Math.max(0, Math.min(eb.a(view), eb.a(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(dkVar.b(view2) - dkVar.a(view))) / ((float) (Math.abs(eb.a(view) - eb.a(view2)) + 1)))) + ((float) (dkVar.b() - dkVar.a(view))));
    }

    static int b(en enVar, dk dkVar, View view, View view2, eb ebVar, boolean z) {
        if (ebVar.l() == 0 || enVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return enVar.a();
        }
        return (int) ((((float) (dkVar.b(view2) - dkVar.a(view))) / ((float) (Math.abs(eb.a(view) - eb.a(view2)) + 1))) * ((float) enVar.a()));
    }
}
