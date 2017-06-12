package com.google.android.gms.b;

import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;

@fd
public final class w {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(String str) {
        byte[] bytes;
        int i = 0;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        int length = bytes.length;
        int i2 = (length & -4) + 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = ((((bytes[i3] & 255) | ((bytes[i3 + 1] & 255) << 8)) | ((bytes[i3 + 2] & 255) << 16)) | (bytes[i3 + 3] << 24)) * -862048943;
            i4 ^= ((i5 >>> 17) | (i5 << 15)) * 461845907;
            i3 += 4;
            i4 = -430675100 + (((i4 >>> 19) | (i4 << 13)) * 5);
        }
        switch (length & 3) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                i = (bytes[i2 + 2] & 255) << 16;
                break;
            default:
                int i6 = i4;
                break;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char[] toCharArray = str.toCharArray();
        int length = str.length();
        Object obj = null;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            Object obj2;
            int i3;
            Object obj3;
            Object obj4;
            int codePointAt = Character.codePointAt(toCharArray, i2);
            int charCount = Character.charCount(codePointAt);
            if (Character.isLetter(codePointAt)) {
                UnicodeBlock of = UnicodeBlock.of(codePointAt);
                obj2 = (of == UnicodeBlock.BOPOMOFO || of == UnicodeBlock.BOPOMOFO_EXTENDED || of == UnicodeBlock.CJK_COMPATIBILITY || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || of == UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || of == UnicodeBlock.HANGUL_JAMO || of == UnicodeBlock.HANGUL_SYLLABLES || of == UnicodeBlock.HIRAGANA || of == UnicodeBlock.KATAKANA || of == UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) ? 1 : null;
                if (obj2 == null) {
                    obj2 = ((codePointAt < 65382 || codePointAt > 65437) && (codePointAt < 65441 || codePointAt > 65500)) ? null : 1;
                }
                obj2 = 1;
                if (obj2 == null) {
                    if (obj != null) {
                        arrayList.add(new String(toCharArray, i, i2 - i));
                    }
                    arrayList.add(new String(toCharArray, i2, charCount));
                    i3 = i;
                    obj3 = null;
                } else if (!Character.isLetterOrDigit(codePointAt) || Character.getType(codePointAt) == 6 || Character.getType(codePointAt) == 8) {
                    if (obj == null) {
                        i = i2;
                    }
                    i3 = i;
                    i = 1;
                } else if (obj != null) {
                    arrayList.add(new String(toCharArray, i, i2 - i));
                    i3 = i;
                    obj3 = null;
                } else {
                    obj4 = obj;
                    i3 = i;
                    obj3 = obj4;
                }
                i2 += charCount;
                obj4 = obj3;
                i = i3;
                obj = obj4;
            }
            obj2 = null;
            if (obj2 == null) {
                if (Character.isLetterOrDigit(codePointAt)) {
                }
                if (obj == null) {
                    i = i2;
                }
                i3 = i;
                i = 1;
            } else {
                if (obj != null) {
                    arrayList.add(new String(toCharArray, i, i2 - i));
                }
                arrayList.add(new String(toCharArray, i2, charCount));
                i3 = i;
                obj3 = null;
            }
            i2 += charCount;
            obj4 = obj3;
            i = i3;
            obj = obj4;
        }
        if (obj != null) {
            arrayList.add(new String(toCharArray, i, i2 - i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
