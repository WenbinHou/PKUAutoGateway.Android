package com.alipay.e.a.a.d.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class a {
    public static boolean a(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static String b(String str) {
        Throwable th;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader2;
        try {
            if (!new File(str).exists()) {
                return null;
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (Throwable th2) {
                        }
                    }
                } catch (IOException e) {
                    bufferedReader = bufferedReader2;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            bufferedReader2.close();
            return stringBuilder.toString();
        } catch (IOException e2) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable th4) {
                }
            }
            return stringBuilder.toString();
        } catch (Throwable th5) {
            Throwable th6 = th5;
            bufferedReader2 = null;
            th = th6;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable th7) {
                }
            }
            throw th;
        }
    }
}
