package com.a.a;

import android.util.Base64;
import javax.crypto.SecretKey;

public final class f {
    SecretKey a;
    SecretKey b;

    public f(SecretKey secretKey, SecretKey secretKey2) {
        this.a = secretKey;
        this.b = secretKey2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return !this.b.equals(fVar.b) ? false : this.a.equals(fVar.a);
    }

    public final int hashCode() {
        return ((this.a.hashCode() + 31) * 31) + this.b.hashCode();
    }

    public final String toString() {
        return Base64.encodeToString(this.a.getEncoded(), 2) + ":" + Base64.encodeToString(this.b.getEncoded(), 2);
    }
}
