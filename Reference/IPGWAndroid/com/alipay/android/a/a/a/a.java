package com.alipay.android.a.a.a;

public final class a extends Exception {
    int a;
    String b;

    public a(Integer num, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Http Transport error");
        if (num != null) {
            stringBuilder.append("[").append(num).append("]");
        }
        stringBuilder.append(" : ");
        if (str != null) {
            stringBuilder.append(str);
        }
        super(stringBuilder.toString());
        this.a = num.intValue();
        this.b = str;
    }
}
