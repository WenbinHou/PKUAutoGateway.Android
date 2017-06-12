package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.el;
import com.google.android.gms.b.er;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.fs;

@fd
public final class c extends er implements ServiceConnection {
    e a;
    private final Activity b;
    private Context c;
    private el d;
    private b e;
    private d f;
    private h g;
    private i h;
    private String i = null;

    public c(Activity activity) {
        this.b = activity;
        this.a = e.a(this.b.getApplicationContext());
    }

    public final void a() {
        GInAppPurchaseManagerInfoParcel a = GInAppPurchaseManagerInfoParcel.a(this.b.getIntent());
        this.g = a.e;
        this.h = a.b;
        this.d = a.c;
        this.e = new b(this.b.getApplicationContext());
        this.c = a.d;
        if (this.b.getResources().getConfiguration().orientation == 2) {
            this.b.setRequestedOrientation(f.e().a());
        } else {
            this.b.setRequestedOrientation(f.e().b());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.b.bindService(intent, this, 1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, Intent intent) {
        if (i == 1001) {
            try {
                int i3;
                Object obj;
                f.j();
                if (intent == null) {
                    i3 = 5;
                } else {
                    obj = intent.getExtras().get("RESPONSE_CODE");
                    if (obj == null) {
                        b.d("Intent with no response code, assuming OK (known issue)");
                        i3 = 0;
                    } else if (obj instanceof Integer) {
                        i3 = ((Integer) obj).intValue();
                    } else if (obj instanceof Long) {
                        i3 = (int) ((Long) obj).longValue();
                    } else {
                        b.d("Unexpected type for intent response code. " + obj.getClass().getName());
                        i3 = 5;
                    }
                }
                if (i2 == -1) {
                    f.j();
                    if (i3 == 0) {
                        i iVar = this.h;
                        String str = this.i;
                        if (str == null || intent == null) {
                            obj = null;
                        } else {
                            Object obj2;
                            f.j();
                            if (intent == null) {
                                obj2 = null;
                            } else {
                                String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
                            }
                            f.j();
                            obj = intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
                            if (obj2 == null || obj == null) {
                                obj = null;
                            } else {
                                f.j();
                                if (str.equals(g.a(obj2))) {
                                    if (iVar.a != null) {
                                        boolean z;
                                        Object obj3 = iVar.a;
                                        if (TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj3) || TextUtils.isEmpty(obj)) {
                                            b.b("Purchase verification failed: missing data.");
                                            z = false;
                                        } else {
                                            z = j.a(j.a(obj3), obj2, obj);
                                        }
                                        if (!z) {
                                            b.d("Fail to verify signature.");
                                            obj = null;
                                        }
                                    }
                                    obj = 1;
                                } else {
                                    b.d("Developer payload not match.");
                                    obj = null;
                                }
                            }
                        }
                    }
                }
                this.a.a(this.f);
                this.d.b(i3);
                this.b.finish();
                this.d.a();
            } catch (RemoteException e) {
                b.d("Fail to process purchase result.");
                this.b.finish();
            } finally {
                this.i = null;
            }
        }
    }

    public final void b() {
        this.b.unbindService(this);
        this.e.a = null;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        SQLiteException e;
        Throwable th;
        b bVar = this.e;
        try {
            bVar.a = bVar.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Exception e2) {
            if (bVar.c) {
                b.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
        try {
            f.c();
            this.i = fs.a();
            Bundle a = this.e.a(this.b.getPackageName(), this.d.a(), this.i);
            PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int i;
                f.j();
                Object obj = a.get("RESPONSE_CODE");
                if (obj == null) {
                    b.d("Bundle with null response code, assuming OK (known issue)");
                    i = 0;
                } else if (obj instanceof Integer) {
                    i = ((Integer) obj).intValue();
                } else if (obj instanceof Long) {
                    i = (int) ((Long) obj).longValue();
                } else {
                    b.d("Unexpected type for intent response code. " + obj.getClass().getName());
                    i = 5;
                }
                this.d.b(i);
                this.d.a();
                this.b.finish();
                return;
            }
            this.f = new d(this.d.a(), this.i);
            e eVar = this.a;
            d dVar = this.f;
            if (dVar != null) {
                synchronized (e.a) {
                    SQLiteDatabase a2 = eVar.a();
                    if (a2 == null) {
                    } else {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("product_id", dVar.c);
                        contentValues.put("developer_payload", dVar.b);
                        contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
                        dVar.a = a2.insert("InAppPurchase", null, contentValues);
                        if (((long) eVar.b()) > 20000) {
                            synchronized (e.a) {
                                SQLiteDatabase a3 = eVar.a();
                                if (a3 == null) {
                                } else {
                                    Cursor query;
                                    try {
                                        query = a3.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                                        if (query != null) {
                                            try {
                                                if (query.moveToFirst()) {
                                                    eVar.a(query == null ? null : new d(query.getLong(0), query.getString(1), query.getString(2)));
                                                }
                                            } catch (SQLiteException e3) {
                                                e = e3;
                                                try {
                                                    b.d("Error remove oldest record" + e.getMessage());
                                                    if (query != null) {
                                                        query.close();
                                                    }
                                                    this.b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                                                    return;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (query != null) {
                                                        query.close();
                                                    }
                                                    throw th;
                                                }
                                            }
                                        }
                                        if (query != null) {
                                            query.close();
                                        }
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                        query = null;
                                        b.d("Error remove oldest record" + e.getMessage());
                                        if (query != null) {
                                            query.close();
                                        }
                                        this.b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                                        return;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        query = null;
                                        if (query != null) {
                                            query.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
            return;
        } catch (RemoteException e5) {
            th = e5;
        } catch (SendIntentException e6) {
            th = e6;
        }
        b.c("Error when connecting in-app billing service", th);
        this.b.finish();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        b.c("In-app billing service disconnected.");
        this.e.a = null;
    }
}
