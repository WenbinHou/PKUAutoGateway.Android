package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.g.a;
import android.support.v4.g.c;
import android.support.v7.b.b;
import android.support.v7.b.f;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ao {
    private static final Mode a = Mode.SRC_IN;
    private static ao b;
    private static final aq c = new aq();
    private static final int[] d = new int[]{f.abc_textfield_search_default_mtrl_alpha, f.abc_textfield_default_mtrl_alpha, f.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = new int[]{f.abc_ic_ab_back_mtrl_am_alpha, f.abc_ic_go_search_api_mtrl_alpha, f.abc_ic_search_api_mtrl_alpha, f.abc_ic_commit_search_api_mtrl_alpha, f.abc_ic_clear_mtrl_alpha, f.abc_ic_menu_share_mtrl_alpha, f.abc_ic_menu_copy_mtrl_am_alpha, f.abc_ic_menu_cut_mtrl_alpha, f.abc_ic_menu_selectall_mtrl_alpha, f.abc_ic_menu_paste_mtrl_am_alpha, f.abc_ic_menu_moreoverflow_mtrl_alpha, f.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] f = new int[]{f.abc_textfield_activated_mtrl_alpha, f.abc_textfield_search_activated_mtrl_alpha, f.abc_cab_background_top_mtrl_alpha, f.abc_text_cursor_material};
    private static final int[] g = new int[]{f.abc_popup_background_mtrl_mult, f.abc_cab_background_internal_bg, f.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = new int[]{f.abc_edit_text_material, f.abc_tab_indicator_material, f.abc_textfield_search_material, f.abc_spinner_mtrl_am_alpha, f.abc_spinner_textfield_background_material, f.abc_ratingbar_full_material, f.abc_switch_track_mtrl_alpha, f.abc_switch_thumb_material, f.abc_btn_default_mtrl_shape, f.abc_btn_borderless_material};
    private static final int[] i = new int[]{f.abc_btn_check_material, f.abc_btn_radio_material};
    private WeakHashMap<Context, SparseArray<ColorStateList>> j;
    private a<String, ar> k;
    private SparseArray<String> l;
    private final Object m = new Object();
    private final WeakHashMap<Context, android.support.v4.g.f<WeakReference<ConstantState>>> n = new WeakHashMap(0);
    private TypedValue o;

    private static PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter) c.a((Object) Integer.valueOf(aq.a(i, mode)));
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        c.a(Integer.valueOf(aq.a(i, mode)), porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Drawable a(Context context, long j) {
        synchronized (this.m) {
            android.support.v4.g.f fVar = (android.support.v4.g.f) this.n.get(context);
            if (fVar == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) fVar.a(j);
            if (weakReference != null) {
                ConstantState constantState = (ConstantState) weakReference.get();
                if (constantState != null) {
                    Drawable newDrawable = constantState.newDrawable(context.getResources());
                    return newDrawable;
                }
                int a = c.a(fVar.c, fVar.e, j);
                if (a >= 0 && fVar.d[a] != android.support.v4.g.f.a) {
                    fVar.d[a] = android.support.v4.g.f.a;
                    fVar.b = true;
                }
            }
        }
    }

    public static ao a() {
        if (b == null) {
            ao aoVar = new ao();
            b = aoVar;
            int i = VERSION.SDK_INT;
            if (i < 21) {
                aoVar.a("vector", new as());
                if (i >= 11) {
                    aoVar.a("animated-vector", new ap());
                }
            }
        }
        return b;
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (ch.c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i, mode));
    }

    public static void a(Drawable drawable, fr frVar, int[] iArr) {
        ColorFilter colorFilter = null;
        if (!ch.c(drawable) || drawable.mutate() == drawable) {
            if (frVar.d || frVar.c) {
                ColorStateList colorStateList = frVar.d ? frVar.a : null;
                Mode mode = frVar.c ? frVar.b : a;
                if (!(colorStateList == null || mode == null)) {
                    colorFilter = a(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(colorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private void a(String str, ar arVar) {
        if (this.k == null) {
            this.k = new a();
        }
        this.k.put(str, arVar);
    }

    private boolean a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.m) {
            android.support.v4.g.f fVar = (android.support.v4.g.f) this.n.get(context);
            if (fVar == null) {
                fVar = new android.support.v4.g.f();
                this.n.put(context, fVar);
            }
            fVar.a(j, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static ColorStateList c(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = fp.a(context, i);
        int a2 = fp.a(context, b.colorControlHighlight);
        r0[0] = fp.a;
        r1[0] = fp.c(context, b.colorButtonNormal);
        r0[1] = fp.d;
        r1[1] = android.support.v4.c.a.a(a2, a);
        r0[2] = fp.b;
        r1[2] = android.support.v4.c.a.a(a2, a);
        r0[3] = fp.h;
        r1[3] = a;
        return new ColorStateList(r0, r1);
    }

    final Drawable a(Context context, int i) {
        if (this.k == null || this.k.isEmpty()) {
            return null;
        }
        String str;
        if (this.l != null) {
            str = (String) this.l.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.k.get(str) == null)) {
                return null;
            }
        }
        this.l = new SparseArray();
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable a = a(context, j);
        if (a != null) {
            return a;
        }
        Drawable drawable;
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                int next;
                XmlPullParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                str = xml.getName();
                this.l.append(i, str);
                ar arVar = (ar) this.k.get(str);
                if (arVar != null) {
                    a = arVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a != null) {
                    a.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, j, a);
                }
                drawable = a;
                if (drawable == null) {
                    return drawable;
                }
                this.l.append(i, "appcompat_skip_skip");
                return drawable;
            } catch (Throwable e) {
                Log.e("AppCompatDrawableManager", "Exception while inflating drawable", e);
            }
        }
        drawable = a;
        if (drawable == null) {
            return drawable;
        }
        this.l.append(i, "appcompat_skip_skip");
        return drawable;
    }

    public final Drawable a(Context context, int i, boolean z) {
        Drawable a = a(context, i);
        if (a == null) {
            a = android.support.v4.b.a.a(context, i);
        }
        if (a != null) {
            a = a(context, i, z, a);
        }
        if (a != null) {
            ch.b(a);
        }
        return a;
    }

    final Drawable a(Context context, int i, boolean z, Drawable drawable) {
        boolean z2 = false;
        ColorStateList b = b(context, i);
        if (b != null) {
            if (ch.c(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.c.a.a.f(drawable);
            android.support.v4.c.a.a.a(drawable, b);
            Mode mode = null;
            if (i == f.abc_switch_thumb_material) {
                mode = Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawable;
            }
            android.support.v4.c.a.a.a(drawable, mode);
            return drawable;
        } else if (i == f.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{a(context, f.abc_cab_background_internal_bg, false), a(context, f.abc_cab_background_top_mtrl_alpha, false)});
        } else if (i == f.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            a(r0.findDrawableByLayerId(16908288), fp.a(context, b.colorControlNormal), a);
            a(r0.findDrawableByLayerId(16908303), fp.a(context, b.colorControlNormal), a);
            a(r0.findDrawableByLayerId(16908301), fp.a(context, b.colorControlActivated), a);
            return drawable;
        } else if (i == f.abc_ratingbar_indicator_material || i == f.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            a(r0.findDrawableByLayerId(16908288), fp.c(context, b.colorControlNormal), a);
            a(r0.findDrawableByLayerId(16908303), fp.a(context, b.colorControlActivated), a);
            a(r0.findDrawableByLayerId(16908301), fp.a(context, b.colorControlActivated), a);
            return drawable;
        } else {
            int i2;
            Mode mode2;
            int i3;
            int i4;
            Mode mode3 = a;
            if (a(d, i)) {
                i2 = b.colorControlNormal;
                mode2 = mode3;
                i3 = 1;
                i4 = -1;
            } else if (a(f, i)) {
                i2 = b.colorControlActivated;
                mode2 = mode3;
                i3 = 1;
                i4 = -1;
            } else if (a(g, i)) {
                i3 = 1;
                mode2 = Mode.MULTIPLY;
                i2 = 16842801;
                i4 = -1;
            } else if (i == f.abc_list_divider_mtrl_alpha) {
                i2 = 16842800;
                i4 = Math.round(40.8f);
                mode2 = mode3;
                i3 = 1;
            } else {
                i4 = -1;
                i2 = 0;
                mode2 = mode3;
                boolean z3 = false;
            }
            if (i3 != 0) {
                Drawable mutate = ch.c(drawable) ? drawable.mutate() : drawable;
                mutate.setColorFilter(a(fp.a(context, i2), mode2));
                if (i4 != -1) {
                    mutate.setAlpha(i4);
                }
                z2 = true;
            }
            return (z2 || !z) ? drawable : null;
        }
    }

    public final ColorStateList b(Context context, int i) {
        ColorStateList colorStateList;
        if (this.j != null) {
            SparseArray sparseArray = (SparseArray) this.j.get(context);
            colorStateList = sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList colorStateList2;
        int[][] iArr;
        int[] iArr2;
        if (i == f.abc_edit_text_material) {
            iArr = new int[3][];
            iArr2 = new int[]{fp.a, fp.c(context, b.colorControlNormal), fp.g};
            iArr2[1] = fp.a(context, b.colorControlNormal);
            iArr[2] = fp.h;
            iArr2[2] = fp.a(context, b.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == f.abc_switch_track_mtrl_alpha) {
            iArr = new int[3][];
            iArr2 = new int[]{fp.a, fp.a(context, 16842800, 0.1f), fp.e};
            iArr2[1] = fp.a(context, b.colorControlActivated, 0.3f);
            iArr[2] = fp.h;
            iArr2[2] = fp.a(context, 16842800, 0.3f);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == f.abc_switch_thumb_material) {
            iArr = new int[3][];
            iArr2 = new int[3];
            colorStateList2 = fp.b(context, b.colorSwitchThumbNormal);
            if (colorStateList2 == null || !colorStateList2.isStateful()) {
                iArr[0] = fp.a;
                iArr2[0] = fp.c(context, b.colorSwitchThumbNormal);
                iArr[1] = fp.e;
                iArr2[1] = fp.a(context, b.colorControlActivated);
                iArr[2] = fp.h;
                iArr2[2] = fp.a(context, b.colorSwitchThumbNormal);
            } else {
                iArr[0] = fp.a;
                iArr2[0] = colorStateList2.getColorForState(iArr[0], 0);
                iArr[1] = fp.e;
                iArr2[1] = fp.a(context, b.colorControlActivated);
                iArr[2] = fp.h;
                iArr2[2] = colorStateList2.getDefaultColor();
            }
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == f.abc_btn_default_mtrl_shape || i == f.abc_btn_borderless_material) {
            colorStateList2 = c(context, b.colorButtonNormal);
        } else if (i == f.abc_btn_colored_material) {
            colorStateList2 = c(context, b.colorAccent);
        } else if (i == f.abc_spinner_mtrl_am_alpha || i == f.abc_spinner_textfield_background_material) {
            iArr = new int[3][];
            iArr2 = new int[]{fp.a, fp.c(context, b.colorControlNormal), fp.g};
            iArr2[1] = fp.a(context, b.colorControlNormal);
            iArr[2] = fp.h;
            iArr2[2] = fp.a(context, b.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (a(e, i)) {
            colorStateList2 = fp.b(context, b.colorControlNormal);
        } else if (a(h, i)) {
            int a = fp.a(context, b.colorControlNormal);
            int a2 = fp.a(context, b.colorControlActivated);
            r2 = new int[7][];
            int[] iArr3 = new int[]{fp.a, fp.c(context, b.colorControlNormal), fp.b, a2, fp.c, a2, fp.d};
            iArr3[3] = a2;
            r2[4] = fp.e;
            iArr3[4] = a2;
            r2[5] = fp.f;
            iArr3[5] = a2;
            r2[6] = fp.h;
            iArr3[6] = a;
            colorStateList2 = new ColorStateList(r2, iArr3);
        } else if (a(i, i)) {
            iArr = new int[3][];
            iArr2 = new int[]{fp.a, fp.c(context, b.colorControlNormal), fp.e};
            iArr2[1] = fp.a(context, b.colorControlActivated);
            iArr[2] = fp.h;
            iArr2[2] = fp.a(context, b.colorControlNormal);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == f.abc_seekbar_thumb_material) {
            iArr = new int[2][];
            iArr2 = new int[]{fp.a, fp.c(context, b.colorControlActivated)};
            iArr[1] = fp.h;
            iArr2[1] = fp.a(context, b.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else {
            colorStateList2 = colorStateList;
        }
        if (colorStateList2 != null) {
            if (this.j == null) {
                this.j = new WeakHashMap();
            }
            sparseArray = (SparseArray) this.j.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.j.put(context, sparseArray);
            }
            sparseArray.append(i, colorStateList2);
        }
        return colorStateList2;
    }
}
