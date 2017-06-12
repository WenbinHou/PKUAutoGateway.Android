package android.support.v7.widget;

import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;

final class r implements y {
    final /* synthetic */ k a;

    private r(k kVar) {
        this.a = kVar;
    }

    public final void a(i iVar, boolean z) {
        if (iVar instanceof ad) {
            ((ad) iVar).l.a(false);
        }
        y yVar = this.a.f;
        if (yVar != null) {
            yVar.a(iVar, z);
        }
    }

    public final boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        this.a.s = ((ad) iVar).getItem().getItemId();
        y yVar = this.a.f;
        return yVar != null ? yVar.a(iVar) : false;
    }
}
