package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.view.TextureView;

@TargetApi(14)
public abstract class m extends TextureView {
    public abstract String a();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setMimeType(String str);

    public abstract void setVideoPath(String str);
}
