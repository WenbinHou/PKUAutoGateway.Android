package ccnet.pku.edu.cn.ipgw_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

public final class bx extends SQLiteOpenHelper {
    public bx(Context context) {
        super(context, "IPGW_Android.db", null, 1);
    }

    public final int a(ArrayList<fj> arrayList) {
        if (arrayList.size() == 0) {
            return 0;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = readableDatabase.rawQuery("SELECT id FROM msgs where msg_id = ?", new String[]{((fj) it.next()).a}).getCount() == 0 ? i + 1 : i;
        }
        return i;
    }

    public final void b(ArrayList<fj> arrayList) {
        if (((int) DatabaseUtils.queryNumEntries(getReadableDatabase(), "msgs")) >= 500) {
            getWritableDatabase().execSQL("DELETE FROM MSGS WHERE id NOT IN (select id from MSGS order by id desc limit 150)");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                String str = ((fj) it.next()).a;
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("msg_id", str);
                writableDatabase.insertOrThrow("msgs", null, contentValues);
            } catch (Exception e) {
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table IF NOT EXISTS msgs (id integer primary key AUTOINCREMENT, msg_id text UNIQUE)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msgs");
        onCreate(sQLiteDatabase);
    }
}
