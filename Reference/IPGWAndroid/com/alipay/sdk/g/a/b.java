package com.alipay.sdk.g.a;

import android.text.TextUtils;

public final class b {
    public String a;
    private String b;
    private String c;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                if (str2.startsWith("resultStatus")) {
                    this.a = a(str2, "resultStatus");
                }
                if (str2.startsWith("result")) {
                    this.b = a(str2, "result");
                }
                if (str2.startsWith("memo")) {
                    this.c = a(str2, "memo");
                }
            }
        }
    }

    private static String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str3.length() + str.indexOf(str3), str.lastIndexOf("}"));
    }

    public final String toString() {
        return "resultStatus={" + this.a + "};memo={" + this.c + "};result={" + this.b + "}";
    }
}
