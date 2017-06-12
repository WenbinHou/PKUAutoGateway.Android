package com.google.android.gms.b;

import java.util.Comparator;

final class u implements Comparator<z> {
    final /* synthetic */ s a;

    u(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        z zVar = (z) obj;
        z zVar2 = (z) obj2;
        int i = zVar.c - zVar2.c;
        return i != 0 ? i : (int) (zVar.a - zVar2.a);
    }
}
