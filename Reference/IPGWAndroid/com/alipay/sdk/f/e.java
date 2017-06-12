package com.alipay.sdk.f;

import com.alipay.sdk.b.a;
import com.alipay.sdk.d.c;
import com.alipay.sdk.d.d;
import com.alipay.sdk.k.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;

public final class e {
    private boolean a;
    private String b = j.c();

    public e(boolean z) {
        this.a = z;
    }

    private static byte[] a(byte[]... bArr) {
        Throwable th;
        int i = 0;
        byte[] bArr2 = null;
        if (bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream;
            DataOutputStream dataOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    while (i < bArr.length) {
                        try {
                            int length = bArr[i].length;
                            dataOutputStream.write(String.format(Locale.getDefault(), "%05d", new Object[]{Integer.valueOf(length)}).getBytes());
                            dataOutputStream.write(bArr[i]);
                            i++;
                        } catch (Exception e) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    dataOutputStream.flush();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e2) {
                    }
                    try {
                        dataOutputStream.close();
                    } catch (Exception e3) {
                    }
                } catch (Exception e4) {
                    dataOutputStream = null;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return bArr2;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    dataOutputStream = null;
                    th = th4;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e8) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                dataOutputStream = null;
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                return bArr2;
            } catch (Throwable th32) {
                byteArrayOutputStream = null;
                th = th32;
                dataOutputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw th;
            }
        }
        return bArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b a(c cVar) {
        ByteArrayInputStream byteArrayInputStream;
        String str;
        String str2;
        Throwable th;
        try {
            byteArrayInputStream = new ByteArrayInputStream(cVar.b);
            try {
                String str3;
                byte[] bArr = new byte[5];
                byteArrayInputStream.read(bArr);
                byte[] bArr2 = new byte[Integer.parseInt(new String(bArr))];
                byteArrayInputStream.read(bArr2);
                str = new String(bArr2);
                bArr2 = new byte[5];
                byteArrayInputStream.read(bArr2);
                int parseInt = Integer.parseInt(new String(bArr2));
                if (parseInt > 0) {
                    bArr2 = new byte[parseInt];
                    byteArrayInputStream.read(bArr2);
                    if (this.a) {
                        bArr2 = com.alipay.sdk.d.e.b(this.b, bArr2);
                    }
                    str3 = new String(cVar.a ? c.b(bArr2) : bArr2);
                } else {
                    str3 = null;
                }
                try {
                    byteArrayInputStream.close();
                    str2 = str3;
                } catch (Exception e) {
                    str2 = str3;
                }
            } catch (Exception e2) {
                str = null;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                        str2 = null;
                    } catch (Exception e3) {
                        str2 = null;
                    }
                } else {
                    str2 = null;
                }
                if (str == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            byteArrayInputStream = null;
            str = null;
            if (byteArrayInputStream != null) {
                str2 = null;
            } else {
                byteArrayInputStream.close();
                str2 = null;
            }
            if (str == null) {
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            byteArrayInputStream = null;
            th = th4;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
        return (str == null || str2 != null) ? new b(str, str2) : null;
    }

    public final c a(b bVar, boolean z) {
        byte[] a;
        byte[] bytes = bVar.a.getBytes();
        byte[] bytes2 = bVar.b.getBytes();
        if (z) {
            try {
                bytes2 = c.a(bytes2);
            } catch (Exception e) {
                z = false;
            }
        }
        if (this.a) {
            byte[] a2 = d.a(this.b, a.b);
            bytes2 = com.alipay.sdk.d.e.a(this.b, bytes2);
            a = a(bytes, a2, bytes2);
        } else {
            a = a(bytes, bytes2);
        }
        return new c(z, a);
    }
}
