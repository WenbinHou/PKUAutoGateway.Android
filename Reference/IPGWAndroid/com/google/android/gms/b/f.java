package com.google.android.gms.b;

import android.net.Uri;

public final class f {
    static final String[] a = new String[]{"/aclk", "/pcs/click"};
    e b;
    private String c;
    private String[] d;

    private boolean c(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.c);
        } catch (NullPointerException e) {
            return false;
        }
    }

    private Uri d(Uri uri) {
        try {
            boolean c = c(uri);
            if (c) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new g("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new g("Query parameter already exists: ms");
            }
            String a = this.b.a();
            String uri2;
            String encodedPath;
            if (c) {
                String str = "dc_ms";
                uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(a).append(";").append(uri2.substring(indexOf + 1)).toString());
                }
                encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(a).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
            }
            uri2 = "ms";
            encodedPath = uri.toString();
            int indexOf3 = encodedPath.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = encodedPath.indexOf("?adurl");
            }
            return indexOf3 != -1 ? Uri.parse(new StringBuilder(encodedPath.substring(0, indexOf3 + 1)).append(uri2).append("=").append(a).append("&").append(encodedPath.substring(indexOf3 + 1)).toString()) : uri.buildUpon().appendQueryParameter(uri2, a).build();
        } catch (UnsupportedOperationException e) {
            throw new g("Provided Uri is not in a valid state");
        }
    }

    public final boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.d) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final Uri b(Uri uri) {
        try {
            uri.getQueryParameter("ai");
            return d(uri);
        } catch (UnsupportedOperationException e) {
            throw new g("Provided Uri is not in a valid state");
        }
    }
}
