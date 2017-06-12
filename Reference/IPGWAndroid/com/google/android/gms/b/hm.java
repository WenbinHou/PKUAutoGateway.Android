package com.google.android.gms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsPromptResult;

final class hm implements OnCancelListener {
    final /* synthetic */ JsPromptResult a;

    hm(JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}
