package com.alipay.sdk.l;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.d.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class b extends AlertDialog {
    final /* synthetic */ a a;

    protected b(a aVar, Context context) {
        this.a = aVar;
        super(context);
    }

    private static int a(Context context, float f) {
        return (int) ((context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics().density * f);
    }

    private static Drawable a(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        InputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(a.a(str));
            try {
                Options options = new Options();
                options.inDensity = 480;
                options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(byteArrayInputStream, null, options));
                try {
                    byteArrayInputStream.close();
                    return bitmapDrawable;
                } catch (Exception e) {
                    return bitmapDrawable;
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        View linearLayout = new LinearLayout(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, a(context, 50.0f));
        layoutParams.gravity = 17;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-450944201);
        gradientDrawable.setCornerRadius((float) a(context, 5.0f));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        View imageView = new ImageView(context);
        layoutParams = new LinearLayout.LayoutParams(a(context, 20.0f), a(context, 20.0f));
        layoutParams.gravity = 16;
        layoutParams.setMargins(a(this.a.c, 17.0f), a(this.a.c, 10.0f), a(this.a.c, 8.0f), a(this.a.c, 10.0f));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.FIT_CENTER);
        imageView.setImageDrawable(a(context, a.a));
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(900);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(rotateAnimation);
        View textView = new TextView(context);
        textView.setText(TextUtils.isEmpty(this.a.d) ? "正在加载" : this.a.d);
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, a(context, 17.0f), 0);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        setContentView(linearLayout);
        setCancelable(false);
    }
}
