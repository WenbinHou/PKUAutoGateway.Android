package android.support.v7.widget;

import android.support.v4.g.o;
import android.support.v4.g.p;
import java.util.ArrayList;
import java.util.List;

final class af implements dj {
    final ArrayList<ah> a;
    final ArrayList<ah> b;
    final ag c;
    Runnable d;
    final boolean e;
    final di f;
    int g;
    private o<ah> h;

    af(ag agVar) {
        this(agVar, (byte) 0);
    }

    private af(ag agVar, byte b) {
        this.h = new p(30);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.g = 0;
        this.c = agVar;
        this.e = false;
        this.f = new di(this);
    }

    private void a(ah ahVar, int i) {
        this.c.a(ahVar);
        switch (ahVar.a) {
            case 2:
                this.c.a(i, ahVar.d);
                return;
            case 4:
                this.c.a(i, ahVar.d, ahVar.c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private void a(List<ah> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a((ah) list.get(i));
        }
        list.clear();
    }

    private int b(int i, int i2) {
        int i3;
        int size = this.b.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            ah ahVar = (ah) this.b.get(size);
            if (ahVar.a == 8) {
                int i6;
                if (ahVar.b < ahVar.d) {
                    i6 = ahVar.b;
                    i3 = ahVar.d;
                } else {
                    i6 = ahVar.d;
                    i3 = ahVar.b;
                }
                if (i4 < i6 || i4 > r2) {
                    if (i4 < ahVar.b) {
                        if (i2 == 1) {
                            ahVar.b++;
                            ahVar.d++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            ahVar.b--;
                            ahVar.d--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == ahVar.b) {
                    if (i2 == 1) {
                        ahVar.d++;
                    } else if (i2 == 2) {
                        ahVar.d--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        ahVar.b++;
                    } else if (i2 == 2) {
                        ahVar.b--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (ahVar.b <= i4) {
                    if (ahVar.a == 1) {
                        i5 = i4 - ahVar.d;
                    } else if (ahVar.a == 2) {
                        i5 = ahVar.d + i4;
                    }
                } else if (i2 == 1) {
                    ahVar.b++;
                    i5 = i4;
                } else if (i2 == 2) {
                    ahVar.b--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.b.size() - 1; i3 >= 0; i3--) {
            ahVar = (ah) this.b.get(i3);
            if (ahVar.a == 8) {
                if (ahVar.d == ahVar.b || ahVar.d < 0) {
                    this.b.remove(i3);
                    a(ahVar);
                }
            } else if (ahVar.d <= 0) {
                this.b.remove(i3);
                a(ahVar);
            }
        }
        return i4;
    }

    private void b(ah ahVar) {
        if (ahVar.a == 1 || ahVar.a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int b = b(ahVar.b, ahVar.a);
        int i2 = ahVar.b;
        switch (ahVar.a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + ahVar);
        }
        int i3 = 1;
        int i4 = b;
        b = i2;
        for (i2 = 1; i2 < ahVar.d; i2++) {
            Object obj;
            int b2 = b(ahVar.b + (i * i2), ahVar.a);
            int i5;
            switch (ahVar.a) {
                case 2:
                    if (b2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (b2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                ah a = a(ahVar.a, i4, i3, ahVar.c);
                a(a, b);
                a(a);
                if (ahVar.a == 4) {
                    b += i3;
                }
                i3 = 1;
                i4 = b2;
            }
        }
        Object obj2 = ahVar.c;
        a(ahVar);
        if (i3 > 0) {
            ah a2 = a(ahVar.a, i4, i3, obj2);
            a(a2, b);
            a(a2);
        }
    }

    private void c(ah ahVar) {
        this.b.add(ahVar);
        switch (ahVar.a) {
            case 1:
                this.c.c(ahVar.b, ahVar.d);
                return;
            case 2:
                this.c.b(ahVar.b, ahVar.d);
                return;
            case 4:
                this.c.a(ahVar.b, ahVar.d, ahVar.c);
                return;
            case 8:
                this.c.d(ahVar.b, ahVar.d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + ahVar);
        }
    }

    private boolean c(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ah ahVar = (ah) this.b.get(i2);
            if (ahVar.a == 8) {
                if (a(ahVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (ahVar.a == 1) {
                int i3 = ahVar.b + ahVar.d;
                for (int i4 = ahVar.b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    final int a(int i, int i2) {
        int size = this.b.size();
        int i3 = i;
        while (i2 < size) {
            ah ahVar = (ah) this.b.get(i2);
            if (ahVar.a == 8) {
                if (ahVar.b == i3) {
                    i3 = ahVar.d;
                } else {
                    if (ahVar.b < i3) {
                        i3--;
                    }
                    if (ahVar.d <= i3) {
                        i3++;
                    }
                }
            } else if (ahVar.b > i3) {
                continue;
            } else if (ahVar.a == 2) {
                if (i3 < ahVar.b + ahVar.d) {
                    return -1;
                }
                i3 -= ahVar.d;
            } else if (ahVar.a == 1) {
                i3 += ahVar.d;
            }
            i2++;
        }
        return i3;
    }

    public final ah a(int i, int i2, int i3, Object obj) {
        ah ahVar = (ah) this.h.a();
        if (ahVar == null) {
            return new ah(i, i2, i3, obj);
        }
        ahVar.a = i;
        ahVar.b = i2;
        ahVar.d = i3;
        ahVar.c = obj;
        return ahVar;
    }

    final void a() {
        a(this.a);
        a(this.b);
        this.g = 0;
    }

    public final void a(ah ahVar) {
        if (!this.e) {
            ahVar.c = null;
            this.h.a(ahVar);
        }
    }

    final boolean a(int i) {
        return (this.g & i) != 0;
    }

    final int b(int i) {
        return a(i, 0);
    }

    final void b() {
        di diVar = this.f;
        List list = this.a;
        while (true) {
            int i;
            ah ahVar;
            ah ahVar2;
            ah ahVar3;
            int i2;
            int i3;
            int i4;
            Object obj = null;
            int size = list.size() - 1;
            while (size >= 0) {
                Object obj2;
                int i5;
                Object obj3;
                Object obj4;
                int size2;
                int i6;
                int i7;
                if (((ah) list.get(size)).a != 8) {
                    obj2 = 1;
                } else if (obj != null) {
                    i = size;
                    if (i != -1) {
                        i5 = i + 1;
                        ahVar = (ah) list.get(i);
                        ahVar2 = (ah) list.get(i5);
                        switch (ahVar2.a) {
                            case 1:
                                size = 0;
                                if (ahVar.d < ahVar2.b) {
                                    size = -1;
                                }
                                if (ahVar.b < ahVar2.b) {
                                    size++;
                                }
                                if (ahVar2.b <= ahVar.b) {
                                    ahVar.b += ahVar2.d;
                                }
                                if (ahVar2.b <= ahVar.d) {
                                    ahVar.d += ahVar2.d;
                                }
                                ahVar2.b = size + ahVar2.b;
                                list.set(i, ahVar2);
                                list.set(i5, ahVar);
                                break;
                            case 2:
                                ahVar3 = null;
                                obj3 = null;
                                if (ahVar.b < ahVar.d) {
                                    obj4 = null;
                                    if (ahVar2.b == ahVar.b && ahVar2.d == ahVar.d - ahVar.b) {
                                        obj3 = 1;
                                    }
                                } else {
                                    obj4 = 1;
                                    if (ahVar2.b == ahVar.d + 1 && ahVar2.d == ahVar.b - ahVar.d) {
                                        obj3 = 1;
                                    }
                                }
                                if (ahVar.d < ahVar2.b) {
                                    if (ahVar.d < ahVar2.b + ahVar2.d) {
                                        ahVar2.d--;
                                        ahVar.a = 2;
                                        ahVar.d = 1;
                                        if (ahVar2.d != 0) {
                                            break;
                                        }
                                        list.remove(i5);
                                        diVar.a.a(ahVar2);
                                        break;
                                    }
                                }
                                ahVar2.b--;
                                if (ahVar.b <= ahVar2.b) {
                                    ahVar2.b++;
                                } else if (ahVar.b < ahVar2.b + ahVar2.d) {
                                    ahVar3 = diVar.a.a(2, ahVar.b + 1, (ahVar2.b + ahVar2.d) - ahVar.b, null);
                                    ahVar2.d = ahVar.b - ahVar2.b;
                                }
                                if (obj3 == null) {
                                    if (obj4 == null) {
                                        if (ahVar3 != null) {
                                            if (ahVar.b > ahVar3.b) {
                                                ahVar.b -= ahVar3.d;
                                            }
                                            if (ahVar.d > ahVar3.b) {
                                                ahVar.d -= ahVar3.d;
                                            }
                                        }
                                        if (ahVar.b > ahVar2.b) {
                                            ahVar.b -= ahVar2.d;
                                        }
                                        if (ahVar.d > ahVar2.b) {
                                            ahVar.d -= ahVar2.d;
                                        }
                                    } else {
                                        if (ahVar3 != null) {
                                            if (ahVar.b >= ahVar3.b) {
                                                ahVar.b -= ahVar3.d;
                                            }
                                            if (ahVar.d >= ahVar3.b) {
                                                ahVar.d -= ahVar3.d;
                                            }
                                        }
                                        if (ahVar.b >= ahVar2.b) {
                                            ahVar.b -= ahVar2.d;
                                        }
                                        if (ahVar.d >= ahVar2.b) {
                                            ahVar.d -= ahVar2.d;
                                        }
                                    }
                                    list.set(i, ahVar2);
                                    if (ahVar.b == ahVar.d) {
                                        list.set(i5, ahVar);
                                    } else {
                                        list.remove(i5);
                                    }
                                    if (ahVar3 == null) {
                                        break;
                                    }
                                    list.add(i, ahVar3);
                                    break;
                                }
                                list.set(i, ahVar2);
                                list.remove(i5);
                                diVar.a.a(ahVar);
                                break;
                            case 4:
                                obj4 = null;
                                obj3 = null;
                                if (ahVar.d < ahVar2.b) {
                                    ahVar2.b--;
                                } else if (ahVar.d < ahVar2.b + ahVar2.d) {
                                    ahVar2.d--;
                                    obj4 = diVar.a.a(4, ahVar.b, 1, ahVar2.c);
                                }
                                if (ahVar.b <= ahVar2.b) {
                                    ahVar2.b++;
                                } else if (ahVar.b < ahVar2.b + ahVar2.d) {
                                    i2 = (ahVar2.b + ahVar2.d) - ahVar.b;
                                    obj3 = diVar.a.a(4, ahVar.b + 1, i2, ahVar2.c);
                                    ahVar2.d -= i2;
                                }
                                list.set(i5, ahVar);
                                if (ahVar2.d <= 0) {
                                    list.set(i, ahVar2);
                                } else {
                                    list.remove(i);
                                    diVar.a.a(ahVar2);
                                }
                                if (obj4 != null) {
                                    list.add(i, obj4);
                                }
                                if (obj3 == null) {
                                    break;
                                }
                                list.add(i, obj3);
                                break;
                            default:
                                break;
                        }
                    }
                    size2 = this.a.size();
                    for (i = 0; i < size2; i++) {
                        ahVar = (ah) this.a.get(i);
                        switch (ahVar.a) {
                            case 1:
                                c(ahVar);
                                break;
                            case 2:
                                i5 = ahVar.b;
                                i6 = ahVar.d + ahVar.b;
                                i2 = -1;
                                size = ahVar.b;
                                i3 = 0;
                                while (size < i6) {
                                    obj = null;
                                    if (this.c.a(size) == null || c(size)) {
                                        if (i2 == 0) {
                                            b(a(2, i5, i3, null));
                                            obj = 1;
                                        }
                                        i2 = 1;
                                    } else {
                                        if (i2 == 1) {
                                            c(a(2, i5, i3, null));
                                            obj = 1;
                                        }
                                        i2 = 0;
                                    }
                                    if (obj == null) {
                                        i4 = size - i3;
                                        size = i6 - i3;
                                        i6 = 1;
                                    } else {
                                        i7 = size;
                                        size = i6;
                                        i6 = i3 + 1;
                                        i4 = i7;
                                    }
                                    i3 = i6;
                                    i6 = size;
                                    size = i4 + 1;
                                }
                                if (i3 != ahVar.d) {
                                    a(ahVar);
                                    ahVar = a(2, i5, i3, null);
                                }
                                if (i2 != 0) {
                                    c(ahVar);
                                    break;
                                } else {
                                    b(ahVar);
                                    break;
                                }
                                break;
                            case 4:
                                i2 = ahVar.b;
                                i3 = ahVar.b + ahVar.d;
                                i6 = ahVar.b;
                                i4 = 0;
                                size = i2;
                                i2 = -1;
                                while (i6 < i3) {
                                    if (this.c.a(i6) == null || c(i6)) {
                                        if (i2 == 0) {
                                            b(a(4, size, i4, ahVar.c));
                                            i4 = 0;
                                            size = i6;
                                        }
                                        i2 = size;
                                        size = i4;
                                        i4 = 1;
                                    } else {
                                        if (i2 == 1) {
                                            c(a(4, size, i4, ahVar.c));
                                            i4 = 0;
                                            size = i6;
                                        }
                                        i2 = size;
                                        size = i4;
                                        i4 = 0;
                                    }
                                    i6++;
                                    i7 = i4;
                                    i4 = size + 1;
                                    size = i2;
                                    i2 = i7;
                                }
                                if (i4 != ahVar.d) {
                                    obj3 = ahVar.c;
                                    a(ahVar);
                                    ahVar = a(4, size, i4, obj3);
                                }
                                if (i2 != 0) {
                                    c(ahVar);
                                    break;
                                } else {
                                    b(ahVar);
                                    break;
                                }
                                break;
                            case 8:
                                c(ahVar);
                                break;
                        }
                        if (this.d != null) {
                            this.d.run();
                        }
                    }
                    this.a.clear();
                    return;
                } else {
                    obj2 = obj;
                }
                size--;
                obj = obj2;
            }
            i = -1;
            if (i != -1) {
                i5 = i + 1;
                ahVar = (ah) list.get(i);
                ahVar2 = (ah) list.get(i5);
                switch (ahVar2.a) {
                    case 1:
                        size = 0;
                        if (ahVar.d < ahVar2.b) {
                            size = -1;
                        }
                        if (ahVar.b < ahVar2.b) {
                            size++;
                        }
                        if (ahVar2.b <= ahVar.b) {
                            ahVar.b += ahVar2.d;
                        }
                        if (ahVar2.b <= ahVar.d) {
                            ahVar.d += ahVar2.d;
                        }
                        ahVar2.b = size + ahVar2.b;
                        list.set(i, ahVar2);
                        list.set(i5, ahVar);
                        break;
                    case 2:
                        ahVar3 = null;
                        obj3 = null;
                        if (ahVar.b < ahVar.d) {
                            obj4 = null;
                            obj3 = 1;
                            break;
                        }
                        obj4 = 1;
                        obj3 = 1;
                        break;
                        if (ahVar.d < ahVar2.b) {
                            if (ahVar.d < ahVar2.b + ahVar2.d) {
                                ahVar2.d--;
                                ahVar.a = 2;
                                ahVar.d = 1;
                                if (ahVar2.d != 0) {
                                    list.remove(i5);
                                    diVar.a.a(ahVar2);
                                    break;
                                }
                                break;
                            }
                        }
                        ahVar2.b--;
                        if (ahVar.b <= ahVar2.b) {
                            ahVar2.b++;
                        } else if (ahVar.b < ahVar2.b + ahVar2.d) {
                            ahVar3 = diVar.a.a(2, ahVar.b + 1, (ahVar2.b + ahVar2.d) - ahVar.b, null);
                            ahVar2.d = ahVar.b - ahVar2.b;
                        }
                        if (obj3 == null) {
                            list.set(i, ahVar2);
                            list.remove(i5);
                            diVar.a.a(ahVar);
                            break;
                        }
                        if (obj4 == null) {
                            if (ahVar3 != null) {
                                if (ahVar.b >= ahVar3.b) {
                                    ahVar.b -= ahVar3.d;
                                }
                                if (ahVar.d >= ahVar3.b) {
                                    ahVar.d -= ahVar3.d;
                                }
                            }
                            if (ahVar.b >= ahVar2.b) {
                                ahVar.b -= ahVar2.d;
                            }
                            if (ahVar.d >= ahVar2.b) {
                                ahVar.d -= ahVar2.d;
                            }
                        } else {
                            if (ahVar3 != null) {
                                if (ahVar.b > ahVar3.b) {
                                    ahVar.b -= ahVar3.d;
                                }
                                if (ahVar.d > ahVar3.b) {
                                    ahVar.d -= ahVar3.d;
                                }
                            }
                            if (ahVar.b > ahVar2.b) {
                                ahVar.b -= ahVar2.d;
                            }
                            if (ahVar.d > ahVar2.b) {
                                ahVar.d -= ahVar2.d;
                            }
                        }
                        list.set(i, ahVar2);
                        if (ahVar.b == ahVar.d) {
                            list.remove(i5);
                        } else {
                            list.set(i5, ahVar);
                        }
                        if (ahVar3 == null) {
                            list.add(i, ahVar3);
                            break;
                        }
                        break;
                    case 4:
                        obj4 = null;
                        obj3 = null;
                        if (ahVar.d < ahVar2.b) {
                            ahVar2.b--;
                        } else if (ahVar.d < ahVar2.b + ahVar2.d) {
                            ahVar2.d--;
                            obj4 = diVar.a.a(4, ahVar.b, 1, ahVar2.c);
                        }
                        if (ahVar.b <= ahVar2.b) {
                            ahVar2.b++;
                        } else if (ahVar.b < ahVar2.b + ahVar2.d) {
                            i2 = (ahVar2.b + ahVar2.d) - ahVar.b;
                            obj3 = diVar.a.a(4, ahVar.b + 1, i2, ahVar2.c);
                            ahVar2.d -= i2;
                        }
                        list.set(i5, ahVar);
                        if (ahVar2.d <= 0) {
                            list.remove(i);
                            diVar.a.a(ahVar2);
                        } else {
                            list.set(i, ahVar2);
                        }
                        if (obj4 != null) {
                            list.add(i, obj4);
                        }
                        if (obj3 == null) {
                            list.add(i, obj3);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            size2 = this.a.size();
            for (i = 0; i < size2; i++) {
                ahVar = (ah) this.a.get(i);
                switch (ahVar.a) {
                    case 1:
                        c(ahVar);
                        break;
                    case 2:
                        i5 = ahVar.b;
                        i6 = ahVar.d + ahVar.b;
                        i2 = -1;
                        size = ahVar.b;
                        i3 = 0;
                        while (size < i6) {
                            obj = null;
                            if (this.c.a(size) == null) {
                                break;
                            }
                            if (i2 == 0) {
                                b(a(2, i5, i3, null));
                                obj = 1;
                            }
                            i2 = 1;
                            if (obj == null) {
                                i7 = size;
                                size = i6;
                                i6 = i3 + 1;
                                i4 = i7;
                            } else {
                                i4 = size - i3;
                                size = i6 - i3;
                                i6 = 1;
                            }
                            i3 = i6;
                            i6 = size;
                            size = i4 + 1;
                        }
                        if (i3 != ahVar.d) {
                            a(ahVar);
                            ahVar = a(2, i5, i3, null);
                        }
                        if (i2 != 0) {
                            b(ahVar);
                            break;
                        } else {
                            c(ahVar);
                            break;
                        }
                    case 4:
                        i2 = ahVar.b;
                        i3 = ahVar.b + ahVar.d;
                        i6 = ahVar.b;
                        i4 = 0;
                        size = i2;
                        i2 = -1;
                        while (i6 < i3) {
                            if (this.c.a(i6) == null) {
                                break;
                            }
                            if (i2 == 0) {
                                b(a(4, size, i4, ahVar.c));
                                i4 = 0;
                                size = i6;
                            }
                            i2 = size;
                            size = i4;
                            i4 = 1;
                            i6++;
                            i7 = i4;
                            i4 = size + 1;
                            size = i2;
                            i2 = i7;
                        }
                        if (i4 != ahVar.d) {
                            obj3 = ahVar.c;
                            a(ahVar);
                            ahVar = a(4, size, i4, obj3);
                        }
                        if (i2 != 0) {
                            b(ahVar);
                            break;
                        } else {
                            c(ahVar);
                            break;
                        }
                    case 8:
                        c(ahVar);
                        break;
                }
                if (this.d != null) {
                    this.d.run();
                }
            }
            this.a.clear();
            return;
        }
    }

    final void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.c.b((ah) this.b.get(i));
        }
        a(this.b);
        this.g = 0;
    }

    final boolean d() {
        return this.a.size() > 0;
    }

    final void e() {
        c();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            ah ahVar = (ah) this.a.get(i);
            switch (ahVar.a) {
                case 1:
                    this.c.b(ahVar);
                    this.c.c(ahVar.b, ahVar.d);
                    break;
                case 2:
                    this.c.b(ahVar);
                    this.c.a(ahVar.b, ahVar.d);
                    break;
                case 4:
                    this.c.b(ahVar);
                    this.c.a(ahVar.b, ahVar.d, ahVar.c);
                    break;
                case 8:
                    this.c.b(ahVar);
                    this.c.d(ahVar.b, ahVar.d);
                    break;
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a(this.a);
        this.g = 0;
    }
}
