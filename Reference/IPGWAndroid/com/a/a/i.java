package com.a.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i {
    private static final Map<Character, k> a;

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Character.valueOf(k.OBJECT.e), k.OBJECT);
        a.put(Character.valueOf(k.LIST.e), k.LIST);
        a.put(Character.valueOf(k.MAP.e), k.MAP);
        a.put(Character.valueOf(k.SET.e), k.SET);
    }

    static j a(String str) {
        x.a("Text", str);
        int indexOf = str.indexOf(64);
        if (indexOf == -1) {
            throw new IllegalArgumentException("Text should contain delimiter");
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        if (TextUtils.isEmpty(substring) || TextUtils.isEmpty(substring2)) {
            throw new IllegalArgumentException("Invalid stored text");
        } else if (substring.charAt(substring.length() - 1) == 'V') {
            return a(substring, substring2);
        } else {
            throw new IllegalStateException("storedText is not valid");
        }
    }

    private static j a(String str, String str2) {
        Class cls;
        Class cls2 = null;
        String[] split = str.split("#");
        k kVar = (k) a.get(Character.valueOf(split[2].charAt(0)));
        if (!TextUtils.isEmpty(split[0])) {
            try {
                cls = Class.forName(split[0]);
            } catch (ClassNotFoundException e) {
                z.a(3, e.getMessage());
            }
            if (!TextUtils.isEmpty(split[1])) {
                try {
                    cls2 = Class.forName(split[1]);
                } catch (ClassNotFoundException e2) {
                    z.a(3, e2.getMessage());
                }
            }
            return new j(kVar, str2, cls, cls2);
        }
        cls = cls2;
        if (TextUtils.isEmpty(split[1])) {
            cls2 = Class.forName(split[1]);
        }
        return new j(kVar, str2, cls, cls2);
    }

    public static <T> String a(String str, T t) {
        String str2;
        k kVar;
        x.a("Cipher text", str);
        x.a("Value", (Object) t);
        String str3 = "";
        String str4 = "";
        if (List.class.isAssignableFrom(t.getClass())) {
            List list = (List) t;
            if (!list.isEmpty()) {
                str3 = list.get(0).getClass().getName();
            }
            str2 = str3;
            kVar = k.LIST;
        } else if (Map.class.isAssignableFrom(t.getClass())) {
            k kVar2;
            k kVar3 = k.MAP;
            Map map = (Map) t;
            if (!map.isEmpty()) {
                Iterator it = map.entrySet().iterator();
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    str4 = entry.getKey().getClass().getName();
                    str3 = entry.getValue().getClass().getName();
                    kVar2 = kVar3;
                    str2 = str4;
                    str4 = str3;
                    kVar = kVar2;
                }
            }
            String str5 = str4;
            str4 = str3;
            str3 = str5;
            kVar2 = kVar3;
            str2 = str4;
            str4 = str3;
            kVar = kVar2;
        } else if (Set.class.isAssignableFrom(t.getClass())) {
            Set set = (Set) t;
            if (!set.isEmpty()) {
                Iterator it2 = set.iterator();
                if (it2.hasNext()) {
                    str3 = it2.next().getClass().getName();
                }
            }
            str2 = str3;
            kVar = k.SET;
        } else {
            kVar = k.OBJECT;
            str2 = t.getClass().getName();
        }
        return str2 + "#" + str4 + "#" + kVar.e + 'V' + '@' + str;
    }
}
