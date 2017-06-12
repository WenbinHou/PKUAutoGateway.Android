package com.google.android.gms.b;

import java.util.Comparator;

final class t implements Comparator<String> {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((String) obj2).length() - ((String) obj).length();
    }
}
