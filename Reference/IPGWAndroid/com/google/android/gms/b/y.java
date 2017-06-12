package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.PriorityQueue;

@fd
public final class y {
    private static long a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? a((j * j) % 1073807359, i / 2) % 1073807359 : ((a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    private static long a(String[] strArr, int i) {
        long a = (((long) w.a(strArr[0])) + 2147483647L) % 1073807359;
        for (int i2 = 1; i2 < i + 0; i2++) {
            a = (((a * 16785407) % 1073807359) + ((((long) w.a(strArr[i2])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }

    private static String a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            b.b("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    private static void a(int i, long j, String str, int i2, PriorityQueue<z> priorityQueue) {
        z zVar = new z(j, str, i2);
        if ((priorityQueue.size() != i || ((z) priorityQueue.peek()).a <= zVar.a) && !priorityQueue.contains(zVar)) {
            priorityQueue.add(zVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void a(String[] strArr, int i, int i2, PriorityQueue<z> priorityQueue) {
        if (strArr.length < i2) {
            a(i, a(strArr, strArr.length), a(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long a = a(strArr, i2);
        a(i, a, a(strArr, 0, i2), i2, priorityQueue);
        long a2 = a(16785407, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            a += 1073807359;
            a = (((((a - ((((((long) w.a(strArr[i3 - 1])) + 2147483647L) % 1073807359) * a2) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) w.a(strArr[(i3 + i2) - 1])) + 2147483647L) % 1073807359)) % 1073807359;
            a(i, a, a(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }
}
