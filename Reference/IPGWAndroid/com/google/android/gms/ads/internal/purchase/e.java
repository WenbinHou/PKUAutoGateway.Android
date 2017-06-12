package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.fd;
import java.util.Locale;

@fd
public final class e {
    static final Object a = new Object();
    private static final String b = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
    private static e d;
    private final f c;

    private e(Context context) {
        this.c = new f(this, context, "google_inapp_purchase.db");
    }

    public static e a(Context context) {
        e eVar;
        synchronized (a) {
            if (d == null) {
                d = new e(context);
            }
            eVar = d;
        }
        return eVar;
    }

    public final SQLiteDatabase a() {
        try {
            return this.c.getWritableDatabase();
        } catch (SQLiteException e) {
            b.d("Error opening writable conversion tracking database");
            return null;
        }
    }

    public final void a(d dVar) {
        if (dVar != null) {
            synchronized (a) {
                SQLiteDatabase a = a();
                if (a == null) {
                    return;
                }
                a.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[]{"purchase_id", Long.valueOf(dVar.a)}), null);
            }
        }
    }

    public final int b() {
        Cursor cursor = null;
        int i = 0;
        synchronized (a) {
            SQLiteDatabase a = a();
            if (a == null) {
            } else {
                try {
                    cursor = a.rawQuery("select count(*) from InAppPurchase", null);
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (SQLiteException e) {
                    b.d("Error getting record count" + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }
}
