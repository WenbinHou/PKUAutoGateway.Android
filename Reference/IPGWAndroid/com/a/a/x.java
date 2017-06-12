package com.a.a;

public final class x {
    public static void a() {
        if (!o.a()) {
            throw new IllegalStateException("Hawk is not built. Please call build() and wait the initialisation finishes.");
        }
    }

    public static void a(String str, Object obj) {
        if (obj == null) {
            throw new NullPointerException(str + " should not be null");
        }
    }

    public static void a(String str, String str2) {
        Object obj = (str2 == null || str2.trim().length() == 0) ? 1 : null;
        if (obj != null) {
            throw new NullPointerException(str + " should not be null or empty");
        }
    }
}
