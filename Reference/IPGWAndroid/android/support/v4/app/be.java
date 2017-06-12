package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class be implements Iterable<Intent> {
    private static final bg c;
    public final ArrayList<Intent> a = new ArrayList();
    public final Context b;

    static {
        if (VERSION.SDK_INT >= 11) {
            c = new bi();
        } else {
            c = new bh();
        }
    }

    private be(Context context) {
        this.b = context;
    }

    public static be a(Context context) {
        return new be(context);
    }

    public final be a(ComponentName componentName) {
        int size = this.a.size();
        try {
            Intent a = ax.a(this.b, componentName);
            while (a != null) {
                this.a.add(size, a);
                a = ax.a(this.b, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public final Iterator<Intent> iterator() {
        return this.a.iterator();
    }
}
