package com.google.android.gms.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;

final class hn implements OnClickListener {
    final /* synthetic */ JsPromptResult a;

    hn(JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.cancel();
    }
}
