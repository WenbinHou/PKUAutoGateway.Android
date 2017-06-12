package b.a.b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class o extends ThreadLocal<DateFormat> {
    o() {
    }

    protected final /* synthetic */ Object initialValue() {
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(b.a.o.d);
        return simpleDateFormat;
    }
}
