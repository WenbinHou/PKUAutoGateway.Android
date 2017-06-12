package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.ads.internal.util.client.b;

public final class f extends SQLiteOpenHelper {
    final /* synthetic */ e a;

    public f(e eVar, Context context, String str) {
        this.a = eVar;
        super(context, str, null, 4);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(e.b);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b.c("Database updated from version " + i + " to version " + i2);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
        onCreate(sQLiteDatabase);
    }
}
