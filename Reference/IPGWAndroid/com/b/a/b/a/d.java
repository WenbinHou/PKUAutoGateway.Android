package com.b.a.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.b.a.a.a.h;
import java.io.File;
import java.util.Map.Entry;

public final class d {
    private String a = "";
    private String b = "";
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private SharedPreferences f;
    private b g;
    private Editor h;
    private c i;
    private Context j;
    private e k;
    private boolean l;

    public d(Context context, String str, String str2) {
        long j;
        long a;
        long j2;
        Editor edit;
        c c;
        String str3 = null;
        this.f = str3;
        this.g = str3;
        this.h = str3;
        this.i = str3;
        this.j = str3;
        this.k = str3;
        this.l = false;
        this.c = false;
        this.l = true;
        this.a = str2;
        this.b = str;
        this.j = context;
        if (context != null) {
            this.f = context.getSharedPreferences(str2, 0);
            j = this.f.getLong("t", 0);
        } else {
            j = 0;
        }
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!h.a(str3)) {
            if (str3.equals("mounted")) {
                this.e = true;
                this.d = true;
            } else if (str3.equals("mounted_ro")) {
                this.d = true;
                this.e = false;
            }
            if (!((!this.d && !this.e) || context == null || h.a(str))) {
                this.k = c(str);
                if (this.k != null) {
                    try {
                        this.g = this.k.a(str2);
                        a = this.g.a("t");
                        try {
                            j2 = this.f.getLong("t2", 0);
                        } catch (Exception e2) {
                            long j3 = a;
                            a = j;
                            j = j3;
                            j2 = a;
                            if (j2 == j) {
                            }
                            a = System.currentTimeMillis();
                            if (this.l) {
                            }
                            if (this.f != null) {
                                edit = this.f.edit();
                                edit.putLong("t2", a);
                                edit.commit();
                            }
                            if (this.g == null) {
                                c = this.g.c();
                                c.a("t2", a);
                                c.b();
                            }
                        }
                        try {
                            j = this.g.a("t2");
                            if (j2 >= j && j2 > 0) {
                                try {
                                    a(this.f, this.g);
                                    this.g = this.k.a(str2);
                                } catch (Exception e3) {
                                    a = j2;
                                    j2 = a;
                                    if (j2 == j) {
                                    }
                                    a = System.currentTimeMillis();
                                    if (this.l) {
                                    }
                                    if (this.f != null) {
                                        edit = this.f.edit();
                                        edit.putLong("t2", a);
                                        edit.commit();
                                    }
                                    if (this.g == null) {
                                        c = this.g.c();
                                        c.a("t2", a);
                                        c.b();
                                    }
                                }
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.l) {
                                }
                                if (this.f != null) {
                                    edit = this.f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.g == null) {
                                    c = this.g.c();
                                    c.a("t2", a);
                                    c.b();
                                }
                            } else if (j2 <= j && j > 0) {
                                a(this.g, this.f);
                                this.f = context.getSharedPreferences(str2, 0);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.l) {
                                }
                                if (this.f != null) {
                                    edit = this.f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.g == null) {
                                    c = this.g.c();
                                    c.a("t2", a);
                                    c.b();
                                }
                            } else if (j2 != 0 && j > 0) {
                                a(this.g, this.f);
                                this.f = context.getSharedPreferences(str2, 0);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.l) {
                                }
                                if (this.f != null) {
                                    edit = this.f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.g == null) {
                                    c = this.g.c();
                                    c.a("t2", a);
                                    c.b();
                                }
                            } else if (j == 0 || j2 <= 0) {
                                if (j2 == j) {
                                    a(this.f, this.g);
                                    this.g = this.k.a(str2);
                                }
                                if (j2 == j || (j2 == 0 && j == 0)) {
                                    a = System.currentTimeMillis();
                                    if (this.l || (this.l && j2 == 0 && j == 0)) {
                                        if (this.f != null) {
                                            edit = this.f.edit();
                                            edit.putLong("t2", a);
                                            edit.commit();
                                        }
                                        if (this.g == null) {
                                            c = this.g.c();
                                            c.a("t2", a);
                                            c.b();
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else {
                                a(this.f, this.g);
                                this.g = this.k.a(str2);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.l) {
                                }
                                if (this.f != null) {
                                    edit = this.f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.g == null) {
                                    c = this.g.c();
                                    c.a("t2", a);
                                    c.b();
                                }
                            }
                        } catch (Exception e4) {
                            j = a;
                            a = j2;
                            j2 = a;
                            if (j2 == j) {
                            }
                            a = System.currentTimeMillis();
                            if (this.l) {
                            }
                            if (this.f != null) {
                                edit = this.f.edit();
                                edit.putLong("t2", a);
                                edit.commit();
                            }
                            if (this.g == null) {
                                c = this.g.c();
                                c.a("t2", a);
                                c.b();
                            }
                        }
                    } catch (Exception e5) {
                        a = j;
                        j = 0;
                        j2 = a;
                        if (j2 == j) {
                        }
                        a = System.currentTimeMillis();
                        if (this.l) {
                        }
                        if (this.f != null) {
                            edit = this.f.edit();
                            edit.putLong("t2", a);
                            edit.commit();
                        }
                        if (this.g == null) {
                            c = this.g.c();
                            c.a("t2", a);
                            c.b();
                        }
                    }
                }
            }
            j2 = j;
            j = 0;
            if (j2 == j) {
            }
            a = System.currentTimeMillis();
            if (this.l) {
            }
            if (this.f != null) {
                edit = this.f.edit();
                edit.putLong("t2", a);
                edit.commit();
            }
            if (this.g == null) {
                c = this.g.c();
                c.a("t2", a);
                c.b();
            }
        }
        this.e = false;
        this.d = false;
        this.k = c(str);
        if (this.k != null) {
            this.g = this.k.a(str2);
            a = this.g.a("t");
            j2 = this.f.getLong("t2", 0);
            j = this.g.a("t2");
            if (j2 >= j) {
            }
            if (j2 <= j) {
            }
            if (j2 != 0) {
            }
            if (j == 0) {
            }
            if (j2 == j) {
                a(this.f, this.g);
                this.g = this.k.a(str2);
            }
            if (j2 == j) {
            }
            a = System.currentTimeMillis();
            if (this.l) {
            }
            if (this.f != null) {
                edit = this.f.edit();
                edit.putLong("t2", a);
                edit.commit();
            }
            if (this.g == null) {
                c = this.g.c();
                c.a("t2", a);
                c.b();
            }
        }
        j2 = j;
        j = 0;
        if (j2 == j) {
        }
        a = System.currentTimeMillis();
        if (this.l) {
        }
        if (this.f != null) {
            edit = this.f.edit();
            edit.putLong("t2", a);
            edit.commit();
        }
        try {
            if (this.g == null) {
                c = this.g.c();
                c.a("t2", a);
                c.b();
            }
        } catch (Exception e6) {
        }
    }

    private static void a(SharedPreferences sharedPreferences, b bVar) {
        if (sharedPreferences != null && bVar != null) {
            c c = bVar.c();
            c.a();
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    c.a(str, (String) value);
                } else if (value instanceof Integer) {
                    c.a(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    c.a(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    c.a(str, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    c.a(str, ((Boolean) value).booleanValue());
                }
            }
            c.b();
        }
    }

    private static void a(b bVar, SharedPreferences sharedPreferences) {
        if (bVar != null && sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.clear();
                for (Entry entry : bVar.b().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        edit.putString(str, (String) value);
                    } else if (value instanceof Integer) {
                        edit.putInt(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) value).booleanValue());
                    }
                }
                edit.commit();
            }
        }
    }

    private boolean b() {
        if (this.g == null) {
            return false;
        }
        boolean a = this.g.a();
        if (a) {
            return a;
        }
        a();
        return a;
    }

    private e c(String str) {
        File file;
        if (Environment.getExternalStorageDirectory() != null) {
            file = new File(String.format("%s%s%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), File.separator, str}));
            if (!file.exists()) {
                file.mkdirs();
            }
        } else {
            file = null;
        }
        if (file == null) {
            return null;
        }
        this.k = new e(file.getAbsolutePath());
        return this.k;
    }

    private void c() {
        if (this.h == null && this.f != null) {
            this.h = this.f.edit();
        }
        if (this.e && this.i == null && this.g != null) {
            this.i = this.g.c();
        }
        b();
    }

    public final void a(String str) {
        if (!h.a(str) && !str.equals("t")) {
            c();
            if (this.h != null) {
                this.h.remove(str);
            }
            if (this.i != null) {
                this.i.a(str);
            }
        }
    }

    public final void a(String str, String str2) {
        if (!h.a(str) && !str.equals("t")) {
            c();
            if (this.h != null) {
                this.h.putString(str, str2);
            }
            if (this.i != null) {
                this.i.a(str, str2);
            }
        }
    }

    public final boolean a() {
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.h != null) {
            if (!(this.l || this.f == null)) {
                this.h.putLong("t", currentTimeMillis);
            }
            if (!this.h.commit()) {
                z = false;
            }
        }
        if (!(this.f == null || this.j == null)) {
            this.f = this.j.getSharedPreferences(this.a, 0);
        }
        String str = null;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!h.a(str)) {
            if (str.equals("mounted")) {
                if (this.g == null) {
                    e c = c(this.b);
                    if (c != null) {
                        this.g = c.a(this.a);
                        if (this.l) {
                            a(this.g, this.f);
                        } else {
                            a(this.f, this.g);
                        }
                        this.i = this.g.c();
                    }
                } else if (!(this.i == null || this.i.b())) {
                    z = false;
                }
            }
            if (str.equals("mounted") || (str.equals("mounted_ro") && this.g != null)) {
                try {
                    if (this.k != null) {
                        this.g = this.k.a(this.a);
                    }
                } catch (Exception e2) {
                }
            }
        }
        return z;
    }

    public final String b(String str) {
        b();
        if (this.f != null) {
            String string = this.f.getString(str, "");
            if (!h.a(string)) {
                return string;
            }
        }
        return this.g != null ? this.g.a(str, "") : "";
    }
}
