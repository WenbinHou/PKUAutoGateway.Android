package b.a;

import java.util.concurrent.ThreadFactory;

final class p implements ThreadFactory {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;

    p(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.a);
        thread.setDaemon(this.b);
        return thread;
    }
}
