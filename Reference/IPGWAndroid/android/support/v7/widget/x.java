package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class x extends DataSetObservable {
    private static final String c = x.class.getSimpleName();
    private static final Object d = new Object();
    private static final Map<String, x> e = new HashMap();
    final Object a;
    final List<y> b;
    private final List<aa> f;
    private final Context g;
    private final String h;
    private Intent i;
    private z j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private ab p;

    private boolean e() {
        if (this.j == null || this.i == null || this.b.isEmpty() || this.f.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.f);
        return true;
    }

    private void f() {
        int size = this.f.size() - this.k;
        if (size > 0) {
            this.n = true;
            for (int i = 0; i < size; i++) {
                this.f.remove(0);
            }
        }
    }

    private void g() {
        try {
            InputStream openFileInput = this.g.openFileInput(this.h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new aa(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(c, "Error reading historical recrod file: " + this.h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(c, "Error reading historical recrod file: " + this.h, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }

    public final int a() {
        int size;
        synchronized (this.a) {
            c();
            size = this.b.size();
        }
        return size;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.a) {
            c();
            List list = this.b;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((y) list.get(i)).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.a) {
            c();
            resolveInfo = ((y) this.b.get(i)).a;
        }
        return resolveInfo;
    }

    final boolean a(aa aaVar) {
        boolean add = this.f.add(aaVar);
        if (add) {
            this.n = true;
            f();
            if (this.m) {
                if (this.n) {
                    this.n = false;
                    if (!TextUtils.isEmpty(this.h)) {
                        AsyncTask acVar = new ac();
                        Object[] objArr = new Object[]{new ArrayList(this.f), this.h};
                        if (VERSION.SDK_INT >= 11) {
                            acVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
                        } else {
                            acVar.execute(objArr);
                        }
                    }
                }
                e();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    public final Intent b(int i) {
        synchronized (this.a) {
            if (this.i == null) {
                return null;
            }
            c();
            y yVar = (y) this.b.get(i);
            ComponentName componentName = new ComponentName(yVar.a.activityInfo.packageName, yVar.a.activityInfo.name);
            Intent intent = new Intent(this.i);
            intent.setComponent(componentName);
            if (this.p != null) {
                Intent intent2 = new Intent(intent);
                if (this.p.a()) {
                    return null;
                }
            }
            a(new aa(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo b() {
        synchronized (this.a) {
            c();
            if (this.b.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((y) this.b.get(0)).a;
            return resolveInfo;
        }
    }

    final void c() {
        int i;
        int i2 = 1;
        if (!this.o || this.i == null) {
            i = 0;
        } else {
            this.o = false;
            this.b.clear();
            List queryIntentActivities = this.g.getPackageManager().queryIntentActivities(this.i, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.b.add(new y(this, (ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.l && this.n && !TextUtils.isEmpty(this.h)) {
            this.l = false;
            this.m = true;
            g();
        } else {
            i2 = 0;
        }
        i |= i2;
        f();
        if (i != 0) {
            e();
            notifyChanged();
        }
    }
}
