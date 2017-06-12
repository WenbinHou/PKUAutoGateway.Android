package com.alipay.e.a.a.b;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class b {
    public static String a(String str, String str2) {
        Exception e;
        Throwable th;
        FileReader fileReader;
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                char[] cArr = new char[((int) file.length())];
                fileReader = new FileReader(file);
                try {
                    fileReader.read(cArr);
                    String valueOf = String.valueOf(cArr);
                    try {
                        fileReader.close();
                        return valueOf;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return valueOf;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.getMessage();
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileReader.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
            fileReader = null;
            try {
                fileReader.close();
                return null;
            } catch (IOException e222) {
                e222.printStackTrace();
                return null;
            }
        } catch (Exception e5) {
            Exception exception = e5;
            fileReader = null;
            e = exception;
            e.getMessage();
            fileReader.close();
            return "";
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileReader = null;
            th = th4;
            fileReader.close();
            throw th;
        }
    }
}
