package b.a.b;

import b.an;
import b.ar;

public final class b {
    public final an a;
    public final ar b;

    private b(an anVar, ar arVar) {
        this.a = anVar;
        this.b = arVar;
    }

    public static boolean a(ar arVar, an anVar) {
        switch (arVar.c) {
            case 200:
            case 203:
            case 204:
            case 300:
            case 301:
            case 308:
            case 404:
            case 405:
            case 410:
            case 414:
            case 501:
                break;
            case 302:
            case 307:
                if (arVar.a("Expires") == null && arVar.c().e == -1 && !arVar.c().g && !arVar.c().f) {
                    return false;
                }
            default:
                return false;
        }
        return (arVar.c().d || anVar.b().d) ? false : true;
    }
}
