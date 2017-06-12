package com.alipay.e.a.a.c;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private static a a = new a();

    private a() {
    }

    public static a a() {
        return a;
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getDeviceId() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String b() {
        InputStreamReader inputStreamReader;
        Throwable th;
        InputStreamReader inputStreamReader2 = null;
        String str = "0000000000000000";
        LineNumberReader lineNumberReader;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo | grep Serial").getInputStream());
            try {
                lineNumberReader = new LineNumberReader(inputStreamReader);
                int i = 1;
                while (i < 100) {
                    try {
                        String readLine = lineNumberReader.readLine();
                        if (readLine != null) {
                            if (readLine.indexOf("Serial") >= 0) {
                                str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                                break;
                            }
                            i++;
                        }
                    } catch (Exception e) {
                        inputStreamReader2 = inputStreamReader;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                try {
                    lineNumberReader.close();
                } catch (IOException e2) {
                }
                try {
                    inputStreamReader.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                lineNumberReader = null;
                inputStreamReader2 = inputStreamReader;
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (IOException e5) {
                    }
                }
                if (inputStreamReader2 != null) {
                    try {
                        inputStreamReader2.close();
                    } catch (IOException e6) {
                    }
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                lineNumberReader = null;
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (IOException e7) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            lineNumberReader = null;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            return str;
        } catch (Throwable th4) {
            th = th4;
            lineNumberReader = null;
            inputStreamReader = null;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
        return str;
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getSubscriberId() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String c(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getLine1Number() : str;
        } catch (Exception e) {
            return str;
        }
    }

    public static String d() {
        String k = k();
        return !com.alipay.e.a.a.b.a.a(k) ? k : l();
    }

    public static String d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String c;
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List<Sensor> sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null && sensorList.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Sensor sensor : sensorList) {
                        stringBuilder.append(sensor.getName());
                        stringBuilder.append(sensor.getVersion());
                        stringBuilder.append(sensor.getVendor());
                    }
                    c = com.alipay.e.a.a.b.a.c(stringBuilder.toString());
                    return c;
                }
            }
            c = null;
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    public static String e() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        long j = 0;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (IOException e) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e2) {
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                    }
                }
                return String.valueOf(j);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e4) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j = (long) Integer.parseInt(readLine.split("\\s+")[1]);
                }
                try {
                    fileReader.close();
                } catch (IOException e6) {
                }
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                }
            } catch (IOException e8) {
                bufferedReader2 = bufferedReader;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return String.valueOf(j);
            } catch (Throwable th3) {
                th = th3;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (IOException e9) {
            fileReader = null;
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return String.valueOf(j);
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            bufferedReader = null;
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return String.valueOf(j);
    }

    public static String e(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Exception e) {
            return null;
        }
    }

    public static String f() {
        long j = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
        }
        return String.valueOf(j);
    }

    public static String f(Context context) {
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e) {
            return null;
        }
    }

    public static String g() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
        } catch (Exception e) {
        }
        return String.valueOf(j);
    }

    public static String g(Context context) {
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e) {
            return null;
        }
    }

    public static String h() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return (defaultAdapter == null || defaultAdapter.isEnabled()) ? defaultAdapter.getAddress() : "";
        } catch (Exception e) {
            return null;
        }
    }

    public static String h(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            return null;
        }
    }

    public static String i() {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            Object newInstance = cls.newInstance();
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(newInstance, new Object[]{"gsm.version.baseband", "no message"});
        } catch (Exception e) {
            return null;
        }
    }

    public static String i(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            return "";
        }
    }

    public static String j() {
        String str = "";
        try {
            return Build.SERIAL;
        } catch (Exception e) {
            return str;
        }
    }

    public static String j(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return null;
        }
    }

    private static String k() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (com.alipay.e.a.a.b.a.a(readLine)) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                        }
                    } else {
                        str = readLine.trim();
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (IOException e5) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e7) {
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                    }
                    throw th;
                }
            } catch (IOException e10) {
                bufferedReader = null;
                bufferedReader.close();
                fileReader.close();
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = null;
                th = th4;
                bufferedReader.close();
                fileReader.close();
                throw th;
            }
        } catch (IOException e11) {
            bufferedReader = null;
            fileReader = null;
            bufferedReader.close();
            fileReader.close();
            return str;
        } catch (Throwable th32) {
            fileReader = null;
            th = th32;
            bufferedReader = null;
            bufferedReader.close();
            fileReader.close();
            throw th;
        }
        return str;
    }

    public static String k(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return String.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String l() {
        FileReader fileReader;
        Throwable th;
        String str = null;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!com.alipay.e.a.a.b.a.a(readLine)) {
                                String[] split = readLine.split(":");
                                if (split != null && split.length > 1 && split[0].contains("BogoMIPS")) {
                                    break;
                                }
                            }
                        }
                        try {
                            break;
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                fileReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                }
            } catch (IOException e4) {
                bufferedReader = null;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e5) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                    }
                }
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = null;
                th = th4;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e7) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (IOException e9) {
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str;
        } catch (Throwable th32) {
            fileReader = null;
            th = th32;
            bufferedReader = null;
            if (fileReader != null) {
                fileReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return str;
    }

    public static String l(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager.isWifiEnabled()) {
                return wifiManager.getConnectionInfo().getBSSID();
            }
        } catch (Throwable th) {
        }
        return "";
    }

    public static Map<String, Integer> m(Context context) {
        Map<String, Integer> hashMap = new HashMap();
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                for (PackageInfo packageInfo : installedPackages) {
                    hashMap.put(packageInfo.packageName, Integer.valueOf(packageInfo.applicationInfo.uid));
                }
            }
        } catch (Throwable th) {
        }
        return hashMap;
    }

    public final String c() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new b(this)).length);
        } catch (Exception e) {
            return "1";
        }
    }
}
