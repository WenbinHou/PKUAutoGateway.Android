package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.b.g;
import android.support.v4.b.h;
import android.support.v4.b.i;
import android.support.v4.g.d;
import android.util.Log;
import java.io.PrintWriter;

final class aw implements h<Object>, i<Object> {
    final int a;
    final Bundle b;
    au<Object> c;
    g<Object> d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    aw n;
    final /* synthetic */ av o;

    final void a() {
        if (av.a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.h = false;
        if (!this.i && this.d != null && this.m) {
            this.m = false;
            this.d.a((i) this);
            this.d.a((h) this);
            this.d.d = false;
        }
    }

    final void a(g<Object> gVar, Object obj) {
        if (this.c != null) {
            String str;
            if (this.o.g != null) {
                String str2 = this.o.g.f.v;
                this.o.g.f.v = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (av.a) {
                    StringBuilder append = new StringBuilder("  onLoadFinished in ").append(gVar).append(": ");
                    StringBuilder stringBuilder = new StringBuilder(64);
                    d.a(obj, stringBuilder);
                    stringBuilder.append("}");
                    Log.v("LoaderManager", append.append(stringBuilder.toString()).toString());
                }
                if (this.o.g != null) {
                    this.o.g.f.v = str;
                }
                this.f = true;
            } catch (Throwable th) {
                if (this.o.g != null) {
                    this.o.g.f.v = str;
                }
            }
        }
    }

    public final void a(String str, PrintWriter printWriter) {
        while (true) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.d);
            if (this.d != null) {
                g gVar = this.d;
                String str2 = str + "  ";
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(gVar.a);
                printWriter.print(" mListener=");
                printWriter.println(gVar.b);
                if (gVar.d || gVar.g || gVar.h) {
                    printWriter.print(str2);
                    printWriter.print("mStarted=");
                    printWriter.print(gVar.d);
                    printWriter.print(" mContentChanged=");
                    printWriter.print(gVar.g);
                    printWriter.print(" mProcessingChange=");
                    printWriter.println(gVar.h);
                }
                if (gVar.e || gVar.f) {
                    printWriter.print(str2);
                    printWriter.print("mAbandoned=");
                    printWriter.print(gVar.e);
                    printWriter.print(" mReset=");
                    printWriter.println(gVar.f);
                }
            }
            if (this.e || this.f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                this = this.n;
                str = str + "  ";
            } else {
                return;
            }
        }
    }

    final void b() {
        while (true) {
            h hVar;
            if (av.a) {
                Log.v("LoaderManager", "  Destroying: " + hVar);
            }
            hVar.l = true;
            boolean z = hVar.f;
            hVar.f = false;
            if (hVar.c != null && hVar.d != null && hVar.e && z) {
                String str;
                if (av.a) {
                    Log.v("LoaderManager", "  Reseting: " + hVar);
                }
                if (hVar.o.g != null) {
                    str = hVar.o.g.f.v;
                    hVar.o.g.f.v = "onLoaderReset";
                } else {
                    str = null;
                }
                if (hVar.o.g != null) {
                    hVar.o.g.f.v = str;
                }
            }
            hVar.c = null;
            hVar.g = null;
            hVar.e = false;
            if (hVar.d != null) {
                if (hVar.m) {
                    hVar.m = false;
                    hVar.d.a((i) hVar);
                    hVar.d.a(hVar);
                }
                g gVar = hVar.d;
                gVar.f = true;
                gVar.d = false;
                gVar.e = false;
                gVar.g = false;
                gVar.h = false;
            }
            if (hVar.n != null) {
                hVar = hVar.n;
            } else {
                return;
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.a);
        stringBuilder.append(" : ");
        d.a(this.d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
