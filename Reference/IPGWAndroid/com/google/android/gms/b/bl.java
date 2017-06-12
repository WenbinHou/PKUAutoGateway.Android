package com.google.android.gms.b;

public final class bl implements ie {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public bl() {
        this((byte) 0);
    }

    private bl(byte b) {
        this.a = 2500;
        this.c = 1;
        this.d = 1.0f;
    }

    public final int a() {
        return this.a;
    }

    public final void a(il ilVar) {
        this.b++;
        this.a = (int) (((float) this.a) + (((float) this.a) * this.d));
        if ((this.b <= this.c ? 1 : null) == null) {
            throw ilVar;
        }
    }

    public final int b() {
        return this.b;
    }
}
