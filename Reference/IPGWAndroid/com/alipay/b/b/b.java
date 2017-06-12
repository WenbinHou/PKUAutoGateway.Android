package com.alipay.b.b;

import com.alipay.e.a.a.a.c.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private File a = null;
    private a b = null;

    public b(String str, a aVar) {
        this.a = new File(str);
        this.b = aVar;
    }

    private static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    final synchronized void a() {
        int i = 0;
        synchronized (this) {
            if (this.a != null) {
                if (this.a.exists() && this.a.isDirectory() && this.a.list().length != 0) {
                    int i2;
                    String str;
                    List arrayList = new ArrayList();
                    for (Object add : this.a.list()) {
                        arrayList.add(add);
                    }
                    Collections.sort(arrayList);
                    String str2 = (String) arrayList.get(arrayList.size() - 1);
                    int size = arrayList.size();
                    int i3;
                    if (!str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                        i3 = size;
                        str = str2;
                        i2 = i3;
                    } else if (arrayList.size() >= 2) {
                        i3 = size - 1;
                        str = (String) arrayList.get(arrayList.size() - 2);
                        i2 = i3;
                    }
                    size = !this.b.a(a(com.alipay.e.a.a.b.b.a(this.a.getAbsolutePath(), str))) ? i2 - 1 : i2;
                    while (i < size) {
                        new File(this.a, (String) arrayList.get(i)).delete();
                        i++;
                    }
                }
            }
        }
    }
}
