package com.google.android.gms.b;

import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class is implements h {
    private final Map<String, it> a;
    private long b;
    private final File c;
    private final int d;

    private is(File file) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0;
        this.c = file;
        this.d = 5242880;
    }

    public is(File file, byte b) {
        this(file);
    }

    static int a(InputStream inputStream) {
        return ((((e(inputStream) << 0) | 0) | (e(inputStream) << 8)) | (e(inputStream) << 16)) | (e(inputStream) << 24);
    }

    static void a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void a(String str, it itVar) {
        if (this.a.containsKey(str)) {
            it itVar2 = (it) this.a.get(str);
            this.b = (itVar.a - itVar2.a) + this.b;
        } else {
            this.b += itVar.a;
        }
        this.a.put(str, itVar);
    }

    private static byte[] a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long b(InputStream inputStream) {
        return (((((((0 | ((((long) e(inputStream)) & 255) << null)) | ((((long) e(inputStream)) & 255) << 8)) | ((((long) e(inputStream)) & 255) << 16)) | ((((long) e(inputStream)) & 255) << 24)) | ((((long) e(inputStream)) & 255) << 32)) | ((((long) e(inputStream)) & 255) << 40)) | ((((long) e(inputStream)) & 255) << 48)) | ((((long) e(inputStream)) & 255) << 56);
    }

    private synchronized void b(String str) {
        boolean delete = d(str).delete();
        it itVar = (it) this.a.get(str);
        if (itVar != null) {
            this.b -= itVar.a;
            this.a.remove(str);
        }
        if (!delete) {
            im.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    static String c(InputStream inputStream) {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    private static String c(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private File d(String str) {
        return new File(this.c, c(str));
    }

    static Map<String, String> d(InputStream inputStream) {
        int a = a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public final synchronized i a(String str) {
        i iVar;
        iu iuVar;
        IOException e;
        iu iuVar2;
        Throwable th;
        it itVar = (it) this.a.get(str);
        if (itVar == null) {
            iVar = null;
        } else {
            File d = d(str);
            try {
                iuVar = new iu(new FileInputStream(d));
                try {
                    it.a((InputStream) iuVar);
                    byte[] a = a((InputStream) iuVar, (int) (d.length() - ((long) iuVar.a)));
                    i iVar2 = new i();
                    iVar2.a = a;
                    iVar2.b = itVar.c;
                    iVar2.c = itVar.d;
                    iVar2.d = itVar.e;
                    iVar2.e = itVar.f;
                    iVar2.f = itVar.g;
                    iVar2.g = itVar.h;
                    try {
                        iuVar.close();
                        iVar = iVar2;
                    } catch (IOException e2) {
                        iVar = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    iuVar2 = iuVar;
                    try {
                        im.b("%s: %s", d.getAbsolutePath(), e.toString());
                        b(str);
                        if (iuVar2 != null) {
                            try {
                                iuVar2.close();
                            } catch (IOException e4) {
                                iVar = null;
                            }
                        }
                        iVar = null;
                        return iVar;
                    } catch (Throwable th2) {
                        th = th2;
                        iuVar = iuVar2;
                        if (iuVar != null) {
                            try {
                                iuVar.close();
                            } catch (IOException e5) {
                                iVar = null;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (iuVar != null) {
                        iuVar.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                iuVar2 = null;
                im.b("%s: %s", d.getAbsolutePath(), e.toString());
                b(str);
                if (iuVar2 != null) {
                    iuVar2.close();
                }
                iVar = null;
                return iVar;
            } catch (Throwable th4) {
                th = th4;
                iuVar = null;
                if (iuVar != null) {
                    iuVar.close();
                }
                throw th;
            }
        }
        return iVar;
    }

    public final synchronized void a() {
        Throwable th;
        if (this.c.exists()) {
            File[] listFiles = this.c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream = null;
                    BufferedInputStream bufferedInputStream2;
                    try {
                        bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            it a = it.a((InputStream) bufferedInputStream2);
                            a.a = file.length();
                            a(a.b, a);
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e) {
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    bufferedInputStream = bufferedInputStream2;
                                    th = th3;
                                }
                            }
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IOException e4) {
                        bufferedInputStream2 = null;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        } else if (!this.c.mkdirs()) {
            im.c("Unable to create cache dir %s", this.c.getAbsolutePath());
        }
        return;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e5) {
            }
        }
        throw th;
        throw th;
    }

    public final synchronized void a(String str, i iVar) {
        int i = 0;
        synchronized (this) {
            int length = iVar.a.length;
            if (this.b + ((long) length) >= ((long) this.d)) {
                int i2;
                if (im.b) {
                    im.a("Pruning old cache entries.", new Object[0]);
                }
                long j = this.b;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext()) {
                    it itVar = (it) ((Entry) it.next()).getValue();
                    if (d(itVar.b).delete()) {
                        this.b -= itVar.a;
                    } else {
                        im.b("Could not delete cache entry for key=%s, filename=%s", itVar.b, c(itVar.b));
                    }
                    it.remove();
                    i2 = i + 1;
                    if (((float) (this.b + ((long) length))) < ((float) this.d) * 0.9f) {
                        break;
                    }
                    i = i2;
                }
                i2 = i;
                if (im.b) {
                    im.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
            }
            File d = d(str);
            try {
                OutputStream fileOutputStream = new FileOutputStream(d);
                it itVar2 = new it(str, iVar);
                if (itVar2.a(fileOutputStream)) {
                    fileOutputStream.write(iVar.a);
                    fileOutputStream.close();
                    a(str, itVar2);
                } else {
                    fileOutputStream.close();
                    im.b("Failed to write header for %s", d.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException e) {
                if (!d.delete()) {
                    im.b("Could not clean up file %s", d.getAbsolutePath());
                }
            }
        }
    }
}
