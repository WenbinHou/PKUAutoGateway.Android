package b.a.a;

final class ae {
    private static final String[] a = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] b = new String[64];
    private static final String[] c = new String[256];

    static {
        int i;
        int i2 = 0;
        for (i = 0; i < c.length; i++) {
            c[i] = String.format("%8s", new Object[]{Integer.toBinaryString(i)}).replace(' ', '0');
        }
        b[0] = "";
        b[1] = "END_STREAM";
        int[] iArr = new int[]{1};
        b[8] = "PADDED";
        for (i = 0; i <= 0; i++) {
            int i3 = iArr[i];
            b[i3 | 8] = b[i3] + "|PADDED";
        }
        b[4] = "END_HEADERS";
        b[32] = "PRIORITY";
        b[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = new int[]{4, 32, 36};
        for (i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            for (i = 0; i <= 0; i++) {
                int i5 = iArr[i];
                b[i5 | i4] = b[i5] + '|' + b[i4];
                b[(i5 | i4) | 8] = b[i5] + '|' + b[i4] + "|PADDED";
            }
        }
        while (i2 < b.length) {
            if (b[i2] == null) {
                b[i2] = c[i2];
            }
            i2++;
        }
    }

    ae() {
    }

    static String a(boolean z, int i, int i2, byte b, byte b2) {
        Object obj;
        String str;
        if (b < a.length) {
            obj = a[b];
        } else {
            String format = String.format("0x%02x", new Object[]{Byte.valueOf(b)});
        }
        if (b2 != (byte) 0) {
            switch (b) {
                case (byte) 2:
                case (byte) 3:
                case (byte) 7:
                case (byte) 8:
                    str = c[b2];
                    break;
                case (byte) 4:
                case (byte) 6:
                    if (b2 != (byte) 1) {
                        str = c[b2];
                        break;
                    }
                    str = "ACK";
                    break;
                default:
                    str = b2 < b.length ? b[b2] : c[b2];
                    if (b != (byte) 5 || (b2 & 4) == 0) {
                        if (b == (byte) 0 && (b2 & 32) != 0) {
                            str = str.replace("PRIORITY", "COMPRESSED");
                            break;
                        }
                    }
                    str = str.replace("HEADERS", "PUSH_PROMISE");
                    break;
                    break;
            }
        }
        str = "";
        String str2 = "%s 0x%08x %5d %-13s %s";
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = obj;
        objArr[4] = str;
        return String.format(str2, objArr);
    }
}
