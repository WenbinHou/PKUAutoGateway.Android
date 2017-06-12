package com.alipay.e.a.a.c;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class b implements FileFilter {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
