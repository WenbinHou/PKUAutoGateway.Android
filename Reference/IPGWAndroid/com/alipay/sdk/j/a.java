package com.alipay.sdk.j;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alipay.sdk.d.b;
import java.lang.ref.WeakReference;

public final class a extends SQLiteOpenHelper {
    private WeakReference<Context> a;

    public a(Context context) {
        super(context, "msp.db", null, 1);
        this.a = new WeakReference(context);
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        int i;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select count(*) from tb_tid where name=?", new String[]{c(str, str2)});
            int i2 = cursor.moveToFirst() ? cursor.getInt(0) : 0;
            if (cursor != null) {
                cursor.close();
                i = i2;
            } else {
                i = i2;
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
                i = 0;
            } else {
                i = 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i > 0;
    }

    private static String c(String str, String str2) {
        return str + str2;
    }

    public final String a(String str, String str2) {
        Throwable th;
        String str3 = null;
        String str4 = "select tid from tb_tid where name=?";
        SQLiteDatabase readableDatabase;
        Cursor rawQuery;
        try {
            readableDatabase = getReadableDatabase();
            try {
                rawQuery = readableDatabase.rawQuery(str4, new String[]{c(str, str2)});
                try {
                    if (rawQuery.moveToFirst()) {
                        str3 = rawQuery.getString(0);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (readableDatabase == null || !readableDatabase.isOpen()) {
                        str4 = str3;
                    } else {
                        readableDatabase.close();
                        str4 = str3;
                    }
                } catch (Exception e) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (readableDatabase == null) {
                    }
                    str4 = null;
                    return TextUtils.isEmpty(str4) ? str4 : b.a(2, str4, com.alipay.sdk.k.b.c((Context) this.a.get()));
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    readableDatabase.close();
                    throw th;
                }
            } catch (Exception e2) {
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (readableDatabase == null) {
                }
                str4 = null;
                if (TextUtils.isEmpty(str4)) {
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                rawQuery = null;
                th = th4;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                readableDatabase.close();
                throw th;
            }
        } catch (Exception e3) {
            rawQuery = null;
            readableDatabase = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (readableDatabase == null && readableDatabase.isOpen()) {
                readableDatabase.close();
                str4 = null;
            } else {
                str4 = null;
            }
            if (TextUtils.isEmpty(str4)) {
            }
        } catch (Throwable th32) {
            readableDatabase = null;
            th = th32;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (readableDatabase != null && readableDatabase.isOpen()) {
                readableDatabase.close();
            }
            throw th;
        }
        if (TextUtils.isEmpty(str4)) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(String str, String str2, String str3, String str4) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase = null;
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                if (a(writableDatabase, str, str2)) {
                    writableDatabase.execSQL("update tb_tid set tid=?, key_tid=?, dt=datetime('now', 'localtime') where name=?", new Object[]{b.a(1, str3, com.alipay.sdk.k.b.c((Context) this.a.get())), str4, c(str, str2)});
                } else {
                    String a = b.a(1, str3, com.alipay.sdk.k.b.c((Context) this.a.get()));
                    writableDatabase.execSQL("insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))", new Object[]{c(str, str2), a, str4});
                    Cursor rawQuery = writableDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
                    if (rawQuery.getCount() <= 14) {
                        rawQuery.close();
                    } else {
                        int i;
                        int count = rawQuery.getCount() - 14;
                        String[] strArr = new String[count];
                        if (rawQuery.moveToFirst()) {
                            i = 0;
                            do {
                                strArr[i] = rawQuery.getString(0);
                                i++;
                                if (!rawQuery.moveToNext()) {
                                    break;
                                }
                            } while (count > i);
                        }
                        rawQuery.close();
                        for (i = 0; i < count; i++) {
                            if (!TextUtils.isEmpty(strArr[i])) {
                                writableDatabase.delete("tb_tid", "name=?", new String[]{strArr[i]});
                            }
                        }
                    }
                }
                if (writableDatabase != null && writableDatabase.isOpen()) {
                    writableDatabase.close();
                }
            } catch (Exception e) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            if (sQLiteDatabase != null) {
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            writableDatabase = null;
            th = th4;
            if (writableDatabase != null && writableDatabase.isOpen()) {
                writableDatabase.close();
            }
            throw th;
        }
    }

    public final String b(String str, String str2) {
        Throwable th;
        String str3 = null;
        String str4 = "select key_tid from tb_tid where name=?";
        SQLiteDatabase readableDatabase;
        Cursor rawQuery;
        try {
            readableDatabase = getReadableDatabase();
            try {
                rawQuery = readableDatabase.rawQuery(str4, new String[]{c(str, str2)});
                try {
                    if (rawQuery.moveToFirst()) {
                        str3 = rawQuery.getString(0);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (readableDatabase != null && readableDatabase.isOpen()) {
                        readableDatabase.close();
                    }
                } catch (Exception e) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    readableDatabase.close();
                    return str3;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    readableDatabase.close();
                    throw th;
                }
            } catch (Exception e2) {
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                readableDatabase.close();
                return str3;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                rawQuery = null;
                th = th4;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                readableDatabase.close();
                throw th;
            }
        } catch (Exception e3) {
            rawQuery = null;
            readableDatabase = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (readableDatabase != null && readableDatabase.isOpen()) {
                readableDatabase.close();
            }
            return str3;
        } catch (Throwable th32) {
            readableDatabase = null;
            th = th32;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (readableDatabase != null && readableDatabase.isOpen()) {
                readableDatabase.close();
            }
            throw th;
        }
        return str3;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("drop table if exists tb_tid");
        onCreate(sQLiteDatabase);
    }
}
