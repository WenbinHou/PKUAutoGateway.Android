package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.a;
import android.support.v4.c.a.k;
import android.util.Log;
import java.lang.reflect.Field;

final class ch {
    public static final Rect a = new Rect();
    private static Class<?> b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    static Mode a(int i) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return VERSION.SDK_INT >= 11 ? Mode.valueOf("ADD") : null;
            default:
                return null;
        }
    }

    public static Rect a(Drawable drawable) {
        if (b != null) {
            try {
                Drawable g = a.g(drawable);
                Object invoke = g.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(g, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : b.getFields()) {
                        String name = field.getName();
                        Object obj = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case null:
                                rect.left = field.getInt(invoke);
                                break;
                            case 1:
                                rect.top = field.getInt(invoke);
                                break;
                            case 2:
                                rect.right = field.getInt(invoke);
                                break;
                            case 3:
                                rect.bottom = field.getInt(invoke);
                                break;
                            default:
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return a;
    }

    static void b(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(fp.e);
            } else {
                drawable.setState(fp.h);
            }
            drawable.setState(state);
        }
    }

    static boolean c(Drawable drawable) {
        Drawable drawable2 = drawable;
        while (!(drawable2 instanceof LayerDrawable)) {
            if (drawable2 instanceof InsetDrawable) {
                return VERSION.SDK_INT >= 14;
            } else {
                if (drawable2 instanceof StateListDrawable) {
                    return VERSION.SDK_INT >= 8;
                } else {
                    if (drawable2 instanceof GradientDrawable) {
                        return VERSION.SDK_INT >= 14;
                    } else {
                        if (drawable2 instanceof DrawableContainer) {
                            ConstantState constantState = drawable2.getConstantState();
                            if (constantState instanceof DrawableContainerState) {
                                for (Drawable c : ((DrawableContainerState) constantState).getChildren()) {
                                    if (!c(c)) {
                                        return false;
                                    }
                                }
                            }
                        } else if (drawable2 instanceof k) {
                            drawable2 = ((k) drawable2).a();
                        } else if (drawable2 instanceof android.support.v7.c.a.a) {
                            drawable2 = ((android.support.v7.c.a.a) drawable2).l;
                        }
                        return true;
                    }
                }
            }
        }
        return VERSION.SDK_INT >= 16;
    }
}
