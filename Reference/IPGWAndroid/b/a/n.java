package b.a;

import b.au;
import java.util.LinkedHashSet;
import java.util.Set;

public final class n {
    private final Set<au> a = new LinkedHashSet();

    public final synchronized void a(au auVar) {
        this.a.add(auVar);
    }

    public final synchronized void b(au auVar) {
        this.a.remove(auVar);
    }

    public final synchronized boolean c(au auVar) {
        return this.a.contains(auVar);
    }
}
