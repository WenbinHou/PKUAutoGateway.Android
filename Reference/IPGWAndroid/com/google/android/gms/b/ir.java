package com.google.android.gms.b;

import java.util.Comparator;

final class ir implements Comparator<byte[]> {
    ir() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((byte[]) obj).length - ((byte[]) obj2).length;
    }
}
