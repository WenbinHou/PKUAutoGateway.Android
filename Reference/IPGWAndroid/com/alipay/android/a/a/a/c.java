package com.alipay.android.a.a.a;

public final class c extends RuntimeException {
    String a;
    private int b;
    private String c;

    public c(Integer num, String str) {
        super(a(num, str));
        this.b = num.intValue();
        this.c = str;
    }

    public c(Integer num, String str, Throwable th) {
        super(a(num, str), th);
        this.b = num.intValue();
        this.c = str;
    }

    private static String a(Integer num, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RPCException: ");
        if (num != null) {
            stringBuilder.append("[").append(num).append("]");
        }
        stringBuilder.append(" : ");
        if (str != null) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
