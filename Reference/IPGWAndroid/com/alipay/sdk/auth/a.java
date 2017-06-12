package com.alipay.sdk.auth;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

final class a extends WebChromeClient {
    final /* synthetic */ AuthActivity a;

    private a(AuthActivity authActivity) {
        this.a = authActivity;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        if (TextUtils.isEmpty(message)) {
            return super.onConsoleMessage(consoleMessage);
        }
        Object obj = null;
        if (message.startsWith("h5container.message: ")) {
            obj = message.replaceFirst("h5container.message: ", "");
        }
        if (TextUtils.isEmpty(obj)) {
            return super.onConsoleMessage(consoleMessage);
        }
        AuthActivity.b(this.a, obj);
        return super.onConsoleMessage(consoleMessage);
    }
}
