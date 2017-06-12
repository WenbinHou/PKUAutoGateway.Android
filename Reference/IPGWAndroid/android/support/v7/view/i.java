package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.d.a.a;
import android.support.v4.view.n;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import org.xmlpull.v1.XmlPullParser;

public final class i extends MenuInflater {
    private static final Class<?>[] a;
    private static final Class<?>[] b;
    private final Object[] c;
    private final Object[] d = this.c;
    private Context e;
    private Object f;

    static {
        Class[] clsArr = new Class[]{Context.class};
        a = clsArr;
        b = clsArr;
    }

    public i(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        k kVar = new k(this, menu);
        int eventType = xmlPullParser.getEventType();
        Object obj = null;
        Object obj2 = null;
        while (eventType != 2) {
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                break;
            }
        }
        String name = xmlPullParser.getName();
        if (name.equals("menu")) {
            eventType = xmlPullParser.next();
            Object obj3 = null;
            while (obj3 == null) {
                Object obj4;
                Object obj5;
                switch (eventType) {
                    case 1:
                        throw new RuntimeException("Unexpected end of document");
                    case 2:
                        if (obj == null) {
                            name = xmlPullParser.getName();
                            if (!name.equals("group")) {
                                if (!name.equals("item")) {
                                    if (!name.equals("menu")) {
                                        obj2 = 1;
                                        obj4 = obj3;
                                        String str = name;
                                        obj5 = obj4;
                                        break;
                                    }
                                    a(xmlPullParser, attributeSet, kVar.b());
                                    obj5 = obj3;
                                    obj3 = obj2;
                                    obj2 = obj;
                                    break;
                                }
                                TypedArray obtainStyledAttributes = kVar.z.e.obtainStyledAttributes(attributeSet, l.MenuItem);
                                kVar.i = obtainStyledAttributes.getResourceId(l.MenuItem_android_id, 0);
                                kVar.j = (obtainStyledAttributes.getInt(l.MenuItem_android_menuCategory, kVar.c) & -65536) | (obtainStyledAttributes.getInt(l.MenuItem_android_orderInCategory, kVar.d) & 65535);
                                kVar.k = obtainStyledAttributes.getText(l.MenuItem_android_title);
                                kVar.l = obtainStyledAttributes.getText(l.MenuItem_android_titleCondensed);
                                kVar.m = obtainStyledAttributes.getResourceId(l.MenuItem_android_icon, 0);
                                kVar.n = k.a(obtainStyledAttributes.getString(l.MenuItem_android_alphabeticShortcut));
                                kVar.o = k.a(obtainStyledAttributes.getString(l.MenuItem_android_numericShortcut));
                                if (obtainStyledAttributes.hasValue(l.MenuItem_android_checkable)) {
                                    kVar.p = obtainStyledAttributes.getBoolean(l.MenuItem_android_checkable, false) ? 1 : 0;
                                } else {
                                    kVar.p = kVar.e;
                                }
                                kVar.q = obtainStyledAttributes.getBoolean(l.MenuItem_android_checked, false);
                                kVar.r = obtainStyledAttributes.getBoolean(l.MenuItem_android_visible, kVar.f);
                                kVar.s = obtainStyledAttributes.getBoolean(l.MenuItem_android_enabled, kVar.g);
                                kVar.t = obtainStyledAttributes.getInt(l.MenuItem_showAsAction, -1);
                                kVar.x = obtainStyledAttributes.getString(l.MenuItem_android_onClick);
                                kVar.u = obtainStyledAttributes.getResourceId(l.MenuItem_actionLayout, 0);
                                kVar.v = obtainStyledAttributes.getString(l.MenuItem_actionViewClass);
                                kVar.w = obtainStyledAttributes.getString(l.MenuItem_actionProviderClass);
                                obj5 = kVar.w != null ? 1 : null;
                                if (obj5 != null && kVar.u == 0 && kVar.v == null) {
                                    kVar.y = (n) kVar.a(kVar.w, b, kVar.z.d);
                                } else {
                                    if (obj5 != null) {
                                        Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                    }
                                    kVar.y = null;
                                }
                                obtainStyledAttributes.recycle();
                                kVar.h = false;
                                obj5 = obj3;
                                obj3 = obj2;
                                obj2 = obj;
                                break;
                            }
                            TypedArray obtainStyledAttributes2 = kVar.z.e.obtainStyledAttributes(attributeSet, l.MenuGroup);
                            kVar.b = obtainStyledAttributes2.getResourceId(l.MenuGroup_android_id, 0);
                            kVar.c = obtainStyledAttributes2.getInt(l.MenuGroup_android_menuCategory, 0);
                            kVar.d = obtainStyledAttributes2.getInt(l.MenuGroup_android_orderInCategory, 0);
                            kVar.e = obtainStyledAttributes2.getInt(l.MenuGroup_android_checkableBehavior, 0);
                            kVar.f = obtainStyledAttributes2.getBoolean(l.MenuGroup_android_visible, true);
                            kVar.g = obtainStyledAttributes2.getBoolean(l.MenuGroup_android_enabled, true);
                            obtainStyledAttributes2.recycle();
                            obj5 = obj3;
                            obj3 = obj2;
                            obj2 = obj;
                            break;
                        }
                        break;
                    case 3:
                        name = xmlPullParser.getName();
                        if (obj == null || !name.equals(obj2)) {
                            if (!name.equals("group")) {
                                if (!name.equals("item")) {
                                    if (name.equals("menu")) {
                                        obj5 = 1;
                                        obj3 = obj2;
                                        obj2 = obj;
                                        break;
                                    }
                                } else if (!kVar.h) {
                                    if (kVar.y != null && kVar.y.e()) {
                                        kVar.b();
                                        obj5 = obj3;
                                        obj3 = obj2;
                                        obj2 = obj;
                                        break;
                                    }
                                    kVar.h = true;
                                    kVar.a(kVar.a.add(kVar.b, kVar.i, kVar.j, kVar.k));
                                    obj5 = obj3;
                                    obj3 = obj2;
                                    obj2 = obj;
                                    break;
                                }
                            }
                            kVar.a();
                            obj5 = obj3;
                            obj3 = obj2;
                            obj2 = obj;
                            break;
                        }
                        obj2 = null;
                        obj4 = obj3;
                        obj3 = null;
                        obj5 = obj4;
                        break;
                        break;
                    default:
                        obj5 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        break;
                }
                obj4 = obj5;
                eventType = xmlPullParser.next();
                obj = obj2;
                obj2 = obj3;
                obj3 = obj4;
            }
            return;
        }
        throw new RuntimeException("Expecting menu, got " + name);
    }

    static /* synthetic */ Object b(i iVar) {
        if (iVar.f == null) {
            Object obj = iVar.e;
            while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                obj = ((ContextWrapper) obj).getBaseContext();
            }
            iVar.f = obj;
        }
        return iVar.f;
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.e.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }
}
