package b;

public final class q {
    boolean a;
    String[] b;
    String[] c;
    boolean d;

    public q(p pVar) {
        this.a = pVar.d;
        this.b = pVar.f;
        this.c = pVar.g;
        this.d = pVar.e;
    }

    q(boolean z) {
        this.a = z;
    }

    public final q a() {
        if (this.a) {
            this.d = true;
            return this;
        }
        throw new IllegalStateException("no TLS extensions for cleartext connections");
    }

    public final q a(av... avVarArr) {
        if (this.a) {
            String[] strArr = new String[avVarArr.length];
            for (int i = 0; i < avVarArr.length; i++) {
                strArr[i] = avVarArr[i].e;
            }
            return b(strArr);
        }
        throw new IllegalStateException("no TLS versions for cleartext connections");
    }

    public final q a(String... strArr) {
        if (!this.a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        } else if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        } else {
            this.b = (String[]) strArr.clone();
            return this;
        }
    }

    public final p b() {
        return new p();
    }

    public final q b(String... strArr) {
        if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        } else if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        } else {
            this.c = (String[]) strArr.clone();
            return this;
        }
    }
}
