package b.a.b;

import java.io.IOException;
import java.lang.reflect.Method;

public final class aa extends Exception {
    public static final Method a;
    public IOException b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception e) {
            declaredMethod = null;
        }
        a = declaredMethod;
    }

    public aa(IOException iOException) {
        super(iOException);
        this.b = iOException;
    }
}
