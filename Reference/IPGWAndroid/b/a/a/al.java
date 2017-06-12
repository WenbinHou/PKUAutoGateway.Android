package b.a.a;

import java.util.zip.Inflater;

final class al extends Inflater {
    final /* synthetic */ aj a;

    al(aj ajVar) {
        this.a = ajVar;
    }

    public final int inflate(byte[] bArr, int i, int i2) {
        int inflate = super.inflate(bArr, i, i2);
        if (inflate != 0 || !needsDictionary()) {
            return inflate;
        }
        setDictionary(aq.a);
        return super.inflate(bArr, i, i2);
    }
}
