package b.a;

import b.aa;
import c.i;
import c.x;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class o {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];
    public static final Charset c = Charset.forName("UTF-8");
    public static final TimeZone d = TimeZone.getTimeZone("GMT");
    private static final Pattern e = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static int a(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i3++;
                default:
                    return i3;
            }
        }
        return i2;
    }

    public static int a(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    public static int a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    public static i a(i iVar) {
        try {
            return i.a(MessageDigest.getInstance("SHA-1").digest(iVar.d()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static String a(aa aaVar, boolean z) {
        String str = aaVar.b.contains(":") ? "[" + aaVar.b + "]" : aaVar.b;
        return (z || aaVar.c != aa.a(aaVar.a)) ? str + ":" + aaVar.c : str;
    }

    public static String a(String str) {
        Object obj = 1;
        try {
            String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (toLowerCase.isEmpty()) {
                return null;
            }
            for (int i = 0; i < toLowerCase.length(); i++) {
                char charAt = toLowerCase.charAt(i);
                if (charAt <= '\u001f' || charAt >= '' || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                }
            }
            obj = null;
            return obj == null ? toLowerCase : null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new p(str, z);
    }

    public static void a(long j, long j2) {
        if ((0 | j2) < 0 || 0 > j || j - 0 < j2) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(Closeable closeable, Closeable closeable2) {
        Object obj = null;
        try {
            closeable.close();
        } catch (Throwable th) {
            obj = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (obj == null) {
                Throwable th3 = th2;
            }
        }
        if (obj != null) {
            if (obj instanceof IOException) {
                throw ((IOException) obj);
            } else if (obj instanceof RuntimeException) {
                throw ((RuntimeException) obj);
            } else if (obj instanceof Error) {
                throw ((Error) obj);
            } else {
                throw new AssertionError(obj);
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static boolean a(c.x r12, int r13, java.util.concurrent.TimeUnit r14) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0068 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r6 = java.lang.System.nanoTime();
        r0 = r12.a();
        r0 = r0.e_();
        if (r0 == 0) goto L_0x0050;
    L_0x0013:
        r0 = r12.a();
        r0 = r0.c();
        r0 = r0 - r6;
    L_0x001c:
        r4 = r12.a();
        r8 = (long) r13;
        r8 = r14.toNanos(r8);
        r8 = java.lang.Math.min(r0, r8);
        r8 = r8 + r6;
        r4.a(r8);
        r4 = new c.f;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        r4.<init>();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
    L_0x0032:
        r8 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        r8 = r12.a(r4, r8);	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        r10 = -1;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        if (r5 == 0) goto L_0x0052;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
    L_0x003e:
        r4.o();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0071 }
        goto L_0x0032;
    L_0x0042:
        r4 = move-exception;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0068;
    L_0x0047:
        r0 = r12.a();
        r0.f_();
    L_0x004e:
        r0 = 0;
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = r2;
        goto L_0x001c;
    L_0x0052:
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x005f;
    L_0x0056:
        r0 = r12.a();
        r0.f_();
    L_0x005d:
        r0 = 1;
        goto L_0x004f;
    L_0x005f:
        r2 = r12.a();
        r0 = r0 + r6;
        r2.a(r0);
        goto L_0x005d;
    L_0x0068:
        r2 = r12.a();
        r0 = r0 + r6;
        r2.a(r0);
        goto L_0x004e;
    L_0x0071:
        r4 = move-exception;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x007e;
    L_0x0076:
        r0 = r12.a();
        r0.f_();
    L_0x007d:
        throw r4;
    L_0x007e:
        r2 = r12.a();
        r0 = r0 + r6;
        r2.a(r0);
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.o.a(c.x, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static boolean a(x xVar, TimeUnit timeUnit) {
        try {
            return a(xVar, 100, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    public static <T> T[] a(Class<T> cls, T[] tArr, T[] tArr2) {
        List arrayList = new ArrayList();
        for (Object obj : tArr) {
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList.toArray((Object[]) Array.newInstance(cls, arrayList.size()));
    }

    public static int b(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i3--;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    public static i b(i iVar) {
        try {
            return i.a(MessageDigest.getInstance("SHA-256").digest(iVar.d()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static boolean b(String str) {
        return e.matcher(str).matches();
    }

    public static String[] b(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    public static String c(String str, int i, int i2) {
        int a = a(str, i, i2);
        return str.substring(a, b(str, a, i2));
    }
}
