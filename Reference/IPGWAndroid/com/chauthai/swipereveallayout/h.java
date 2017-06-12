package com.chauthai.swipereveallayout;

import java.util.Map.Entry;

public final class h implements e {
    final /* synthetic */ String a;
    final /* synthetic */ SwipeRevealLayout b;
    final /* synthetic */ g c;

    public h(g gVar, String str, SwipeRevealLayout swipeRevealLayout) {
        this.c = gVar;
        this.a = str;
        this.b = swipeRevealLayout;
    }

    public final void a(int i) {
        int i2 = 0;
        this.c.a.put(this.a, Integer.valueOf(i));
        if (this.c.c) {
            g gVar = this.c;
            String str = this.a;
            SwipeRevealLayout swipeRevealLayout = this.b;
            synchronized (gVar.d) {
                for (Integer intValue : gVar.a.values()) {
                    int intValue2 = intValue.intValue();
                    intValue2 = (intValue2 == 2 || intValue2 == 3) ? i2 + 1 : i2;
                    i2 = intValue2;
                }
                if (i2 > 1) {
                    for (Entry entry : gVar.a.entrySet()) {
                        if (!((String) entry.getKey()).equals(str)) {
                            entry.setValue(Integer.valueOf(0));
                        }
                    }
                    for (SwipeRevealLayout swipeRevealLayout2 : gVar.b.values()) {
                        if (swipeRevealLayout2 != swipeRevealLayout) {
                            swipeRevealLayout2.b(true);
                        }
                    }
                }
            }
        }
    }
}
