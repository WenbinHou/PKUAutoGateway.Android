package android.support.v7.a;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.i;
import android.view.View;
import android.view.ViewGroup;

final class ao {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    i j;
    g k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q = false;
    boolean r;
    Bundle s;

    ao(int i) {
        this.a = i;
    }

    final void a(i iVar) {
        if (iVar != this.j) {
            if (this.j != null) {
                this.j.b(this.k);
            }
            this.j = iVar;
            if (iVar != null && this.k != null) {
                iVar.a(this.k);
            }
        }
    }
}
