package com.a.a;

import android.util.Log;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

public class d extends SecureRandomSpi {
    private static final File a = new File("/dev/urandom");
    private static final Object b = new Object();
    private static DataInputStream c;
    private static OutputStream d;
    private boolean e;

    private static DataInputStream a() {
        DataInputStream dataInputStream;
        synchronized (b) {
            if (c == null) {
                try {
                    c = new DataInputStream(new FileInputStream(a));
                } catch (Throwable e) {
                    throw new SecurityException("Failed to open " + a + " for reading", e);
                }
            }
            dataInputStream = c;
        }
        return dataInputStream;
    }

    private static OutputStream b() {
        OutputStream outputStream;
        synchronized (b) {
            if (d == null) {
                d = new FileOutputStream(a);
            }
            outputStream = d;
        }
        return outputStream;
    }

    protected byte[] engineGenerateSeed(int i) {
        byte[] bArr = new byte[i];
        engineNextBytes(bArr);
        return bArr;
    }

    protected void engineNextBytes(byte[] bArr) {
        if (!this.e) {
            engineSetSeed(c.c());
        }
        try {
            DataInputStream a;
            synchronized (b) {
                a = a();
            }
            synchronized (a) {
                a.readFully(bArr);
            }
        } catch (Throwable e) {
            throw new SecurityException("Failed to read from " + a, e);
        }
    }

    protected void engineSetSeed(byte[] bArr) {
        try {
            OutputStream b;
            synchronized (b) {
                b = b();
            }
            b.write(bArr);
            b.flush();
            this.e = true;
        } catch (IOException e) {
            try {
                Log.w(c.class.getSimpleName(), "Failed to mix seed into " + a);
            } finally {
                this.e = true;
            }
        }
    }
}
