package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.g.c;
import android.support.v4.g.r;
import android.support.v4.g.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class q extends m {
    final Handler a = new r(this);
    public final v b = new v(new s(this));
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    int i;
    boolean j;
    s<String> k;

    private static String a(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    final int a(n nVar) {
        if (this.k.b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (true) {
            s sVar = this.k;
            int i = this.i;
            if (sVar.a) {
                sVar.a();
            }
            if (c.a(sVar.b, sVar.c, i) >= 0) {
                this.i = (this.i + 1) % 65534;
            } else {
                int i2 = this.i;
                this.k.a(i2, nVar.h);
                this.i = (this.i + 1) % 65534;
                return i2;
            }
        }
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.b.a.f.a(view, str, context, attributeSet);
    }

    final void a(boolean z) {
        if (!this.f) {
            this.f = true;
            this.g = z;
            this.a.removeMessages(1);
            v vVar = this.b;
            boolean z2 = this.g;
            w wVar = vVar.a;
            wVar.h = z2;
            if (wVar.i != null && wVar.k) {
                wVar.k = false;
                if (z2) {
                    wVar.i.d();
                } else {
                    wVar.i.c();
                }
            }
            this.b.a.f.a(2);
        }
    }

    protected final void a_() {
        this.b.a.f.j();
    }

    public void b() {
        if (VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        } else {
            this.h = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print("mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f);
        w wVar = this.b.a;
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(wVar.k);
        if (wVar.i != null) {
            printWriter.print(str2);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(wVar.i)));
            printWriter.println(":");
            wVar.i.a(str2 + "  ", printWriter);
        }
        this.b.a.f.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        a(str + "  ", printWriter, getWindow().getDecorView());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.b.a();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.k.a(i4);
            this.k.b(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            n a = this.b.a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.b.a.f.c()) {
            if (VERSION.SDK_INT >= 21) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.a.f.a(configuration);
    }

    public void onCreate(Bundle bundle) {
        v vVar = this.b;
        vVar.a.f.a(vVar.a, vVar.a, null);
        super.onCreate(bundle);
        t tVar = (t) getLastNonConfigurationInstance();
        if (tVar != null) {
            this.b.a.g = tVar.c;
        }
        if (bundle != null) {
            this.b.a.f.a(bundle.getParcelable("android:support:fragments"), tVar != null ? tVar.b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.k = new s(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.k.a(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.k == null) {
            this.k = new s();
            this.i = 0;
        }
        this.b.a.f.g();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= 11 ? super.onCreatePanelMenu(i, menu) | this.b.a.f.a(menu, getMenuInflater()) : true;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        a(false);
        this.b.a.f.l();
        w wVar = this.b.a;
        if (wVar.i != null) {
            wVar.i.g();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.b.a.f.m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.b.a.f.a(menuItem);
            case 6:
                return this.b.a.f.b(menuItem);
            default:
                return false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b.a();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.b.a.f.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.d = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            a_();
        }
        this.b.a.f.a(4);
    }

    public void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        a_();
        this.b.b();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.h) {
            this.h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return super.onPreparePanel(0, view, menu) | this.b.a.f.a(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.k.a(i3);
            this.k.b(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            } else if (this.b.a(str) == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                n.f();
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.d = true;
        this.b.b();
    }

    public final Object onRetainNonConfigurationInstance() {
        List list;
        if (this.e) {
            a(true);
        }
        y yVar = this.b.a.f;
        if (yVar.f != null) {
            list = null;
            for (int i = 0; i < yVar.f.size(); i++) {
                n nVar = (n) yVar.f.get(i);
                if (nVar != null && nVar.B) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(nVar);
                    nVar.C = true;
                    nVar.k = nVar.j != null ? nVar.j.g : -1;
                    if (y.a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + nVar);
                    }
                }
            }
        } else {
            list = null;
        }
        r g = this.b.a.g();
        if (list == null && g == null) {
            return null;
        }
        t tVar = new t();
        tVar.a = null;
        tVar.b = list;
        tVar.c = g;
        return tVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable f = this.b.a.f.f();
        if (f != null) {
            bundle.putParcelable("android:support:fragments", f);
        }
        if (this.k.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.i);
            int[] iArr = new int[this.k.b()];
            String[] strArr = new String[this.k.b()];
            for (int i = 0; i < this.k.b(); i++) {
                iArr[i] = this.k.c(i);
                strArr[i] = (String) this.k.d(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    public void onStart() {
        super.onStart();
        this.e = false;
        this.f = false;
        this.a.removeMessages(1);
        if (!this.c) {
            this.c = true;
            this.b.a.f.h();
        }
        this.b.a();
        this.b.b();
        w wVar = this.b.a;
        if (!wVar.k) {
            wVar.k = true;
            if (wVar.i != null) {
                wVar.i.b();
            } else if (!wVar.j) {
                wVar.i = wVar.b("(root)");
                if (!(wVar.i == null || wVar.i.e)) {
                    wVar.i.b();
                }
            }
            wVar.j = true;
        }
        this.b.a.f.i();
        w wVar2 = this.b.a;
        if (wVar2.g != null) {
            int i;
            int size = wVar2.g.size();
            av[] avVarArr = new av[size];
            for (i = size - 1; i >= 0; i--) {
                avVarArr[i] = (av) wVar2.g.c(i);
            }
            for (i = 0; i < size; i++) {
                av avVar = avVarArr[i];
                if (avVar.f) {
                    if (av.a) {
                        Log.v("LoaderManager", "Finished Retaining in " + avVar);
                    }
                    avVar.f = false;
                    for (int b = avVar.b.b() - 1; b >= 0; b--) {
                        aw awVar = (aw) avVar.b.d(b);
                        if (awVar.i) {
                            if (av.a) {
                                Log.v("LoaderManager", "  Finished Retaining: " + awVar);
                            }
                            awVar.i = false;
                            if (!(awVar.h == awVar.j || awVar.h)) {
                                awVar.a();
                            }
                        }
                        if (awVar.h && awVar.e && !awVar.k) {
                            awVar.a(awVar.d, awVar.g);
                        }
                    }
                }
                avVar.f();
            }
        }
    }

    public void onStateNotSaved() {
        this.b.a();
    }

    public void onStop() {
        super.onStop();
        this.e = true;
        this.a.sendEmptyMessage(1);
        this.b.a.f.k();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.j || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}
