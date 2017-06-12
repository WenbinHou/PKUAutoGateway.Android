package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;

final class be implements Callback {
    final /* synthetic */ bd a;

    be(bd bdVar) {
        this.a = bdVar;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                bd bdVar = this.a;
                bg bgVar = (bg) message.obj;
                synchronized (bdVar.a) {
                    if (bdVar.b == bgVar || bdVar.c == bgVar) {
                        bdVar.a(bgVar);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
