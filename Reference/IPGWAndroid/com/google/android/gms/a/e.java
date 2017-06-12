package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.a;

public abstract class e<T> {
    private final String a;
    private T b;

    public e(String str) {
        this.a = str;
    }

    public final T a(Context context) {
        if (this.b == null) {
            if (context == null) {
                throw new NullPointerException("null reference");
            }
            Context b = a.b(context);
            if (b == null) {
                throw new f("Could not get remote context.");
            }
            try {
                this.b = a((IBinder) b.getClassLoader().loadClass(this.a).newInstance());
            } catch (Throwable e) {
                throw new f("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new f("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new f("Could not access creator.", e22);
            }
        }
        return this.b;
    }

    public abstract T a(IBinder iBinder);
}
