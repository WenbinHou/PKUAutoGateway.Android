package ccnet.pku.edu.cn.ipgw_android;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.a.q;
import android.support.v7.a.r;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import b.ag;
import b.ai;
import com.kaopiz.kprogresshud.f;
import com.kaopiz.kprogresshud.i;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class fn {
    public static String a = "";
    public static int b = 0;
    public static int c = 20;

    public static int a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (true) {
            if (split.length <= i && split2.length <= i) {
                return 0;
            }
            int parseInt = split.length > i ? Integer.parseInt(split[i]) : 0;
            int parseInt2 = split2.length > i ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i++;
        }
    }

    public static q a(View view, String str) {
        return new r(view.getContext()).a((int) R.string.error).b(str).a(null).a();
    }

    public static q a(View view, String str, OnClickListener onClickListener) {
        return new r(view.getContext()).a((int) R.string.success).b(str).a(onClickListener).a();
    }

    public static ag a() {
        ai aiVar = new ai();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (10 < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(10);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (toMillis != 0 || 10 <= 0) {
                aiVar.w = (int) toMillis;
                timeUnit = TimeUnit.SECONDS;
                if (10 < 0) {
                    throw new IllegalArgumentException("timeout < 0");
                } else if (timeUnit == null) {
                    throw new IllegalArgumentException("unit == null");
                } else {
                    toMillis = timeUnit.toMillis(10);
                    if (toMillis > 2147483647L) {
                        throw new IllegalArgumentException("Timeout too large.");
                    } else if (toMillis != 0 || 10 <= 0) {
                        aiVar.y = (int) toMillis;
                        timeUnit = TimeUnit.SECONDS;
                        if (10 < 0) {
                            throw new IllegalArgumentException("timeout < 0");
                        } else if (timeUnit == null) {
                            throw new IllegalArgumentException("unit == null");
                        } else {
                            toMillis = timeUnit.toMillis(10);
                            if (toMillis > 2147483647L) {
                                throw new IllegalArgumentException("Timeout too large.");
                            } else if (toMillis != 0 || 10 <= 0) {
                                aiVar.x = (int) toMillis;
                                return new ag(aiVar);
                            } else {
                                throw new IllegalArgumentException("Timeout too small.");
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Timeout too small.");
                    }
                }
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        }
    }

    public static String a(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        String d = d(activity);
        if (d == null) {
            d = "";
        }
        return stringBuilder.append("IPGWAndroid" + d).append("_").append(a).append("_").append(fm.g(activity.getApplicationContext())).toString();
    }

    public static q b(View view, String str) {
        return new r(view.getContext()).a((int) R.string.success).b(str).a(null).a();
    }

    public static String b() {
        return Locale.getDefault().getLanguage().equals("en") ? "en" : "";
    }

    public static void b(Activity activity) {
        View currentFocus = activity.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static f c(Activity activity) {
        f a = new f(activity).a(i.a);
        a.a.setCancelable(true);
        a.e = 2;
        a.b = 0.5f;
        return a;
    }

    public static String d(Activity activity) {
        try {
            return activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static void e(Activity activity) {
        if (VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            window.setFlags(67108864, 67108864);
            Resources resources = activity.getResources();
            int i = 0;
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                i = resources.getDimensionPixelSize(identifier);
            }
            View view = new View(activity);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.getLayoutParams().height = i;
            ((ViewGroup) window.getDecorView()).addView(view);
            view.setBackgroundColor(activity.getResources().getColor(R.color.colorPKURed));
        }
    }
}
