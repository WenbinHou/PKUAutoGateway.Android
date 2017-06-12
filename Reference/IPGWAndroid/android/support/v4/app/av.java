package android.support.v4.app;

import android.support.v4.b.g;
import android.support.v4.g.d;
import android.support.v4.g.s;
import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class av extends at {
    static boolean a = false;
    final s<aw> b;
    final s<aw> c;
    final String d;
    boolean e;
    boolean f;
    w g;

    public final void a(String str, PrintWriter printWriter) {
        int i = 0;
        if (this.b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.b.b(); i2++) {
                aw awVar = (aw) this.b.d(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.c(i2));
                printWriter.print(": ");
                printWriter.println(awVar.toString());
                awVar.a(str2, printWriter);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.c.b()) {
                awVar = (aw) this.c.d(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.c(i));
                printWriter.print(": ");
                printWriter.println(awVar.toString());
                awVar.a(str3, printWriter);
                i++;
            }
        }
    }

    public final boolean a() {
        int b = this.b.b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            aw awVar = (aw) this.b.d(i);
            int i2 = (!awVar.h || awVar.f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    final void b() {
        if (a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.e = true;
        for (int b = this.b.b() - 1; b >= 0; b--) {
            aw awVar = (aw) this.b.d(b);
            if (awVar.i && awVar.j) {
                awVar.h = true;
            } else if (awVar.h) {
                continue;
            } else {
                awVar.h = true;
                if (a) {
                    Log.v("LoaderManager", "  Starting: " + awVar);
                }
                if (awVar.d == null && awVar.c != null) {
                    awVar.d = awVar.c.a();
                }
                if (awVar.d == null) {
                    continue;
                } else if (!awVar.d.getClass().isMemberClass() || Modifier.isStatic(awVar.d.getClass().getModifiers())) {
                    if (!awVar.m) {
                        g gVar = awVar.d;
                        int i = awVar.a;
                        if (gVar.b != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        gVar.b = awVar;
                        gVar.a = i;
                        gVar = awVar.d;
                        if (gVar.c != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        gVar.c = awVar;
                        awVar.m = true;
                    }
                    g gVar2 = awVar.d;
                    gVar2.d = true;
                    gVar2.f = false;
                    gVar2.e = false;
                } else {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + awVar.d);
                }
            }
        }
    }

    final void c() {
        if (a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.e) {
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((aw) this.b.d(b)).a();
            }
            this.e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    final void d() {
        if (a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.e) {
            this.f = true;
            this.e = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                aw awVar = (aw) this.b.d(b);
                if (a) {
                    Log.v("LoaderManager", "  Retaining: " + awVar);
                }
                awVar.i = true;
                awVar.j = awVar.h;
                awVar.h = false;
                awVar.c = null;
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    final void e() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((aw) this.b.d(b)).k = true;
        }
    }

    final void f() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            aw awVar = (aw) this.b.d(b);
            if (awVar.h && awVar.k) {
                awVar.k = false;
                if (awVar.e) {
                    awVar.a(awVar.d, awVar.g);
                }
            }
        }
    }

    final void g() {
        int b;
        if (!this.f) {
            if (a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.b.b() - 1; b >= 0; b--) {
                ((aw) this.b.d(b)).b();
            }
            this.b.c();
        }
        if (a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.c.b() - 1; b >= 0; b--) {
            ((aw) this.c.d(b)).b();
        }
        this.c.c();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        d.a(this.g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
