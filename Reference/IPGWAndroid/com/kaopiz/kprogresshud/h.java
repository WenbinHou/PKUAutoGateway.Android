package com.kaopiz.kprogresshud;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

public final class h extends Dialog {
    c a;
    e b;
    View c;
    FrameLayout d;
    final /* synthetic */ f e;
    private TextView f;
    private TextView g;
    private String h;
    private String i;
    private BackgroundLayout j;
    private int k;
    private int l;

    public h(f fVar, Context context) {
        this.e = fVar;
        super(context);
    }

    final void a(View view) {
        if (view != null) {
            this.d.addView(view, new LayoutParams(-2, -2));
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(o.kprogresshud_hud);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.addFlags(2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = this.e.b;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
        this.j = (BackgroundLayout) findViewById(n.background);
        BackgroundLayout backgroundLayout = this.j;
        backgroundLayout.b = this.e.c;
        backgroundLayout.a(backgroundLayout.b, backgroundLayout.a);
        backgroundLayout = this.j;
        backgroundLayout.a = (float) d.a(this.e.d, backgroundLayout.getContext());
        backgroundLayout.a(backgroundLayout.b, backgroundLayout.a);
        if (this.k != 0) {
            LayoutParams layoutParams = this.j.getLayoutParams();
            layoutParams.width = d.a((float) this.k, getContext());
            layoutParams.height = d.a((float) this.l, getContext());
            this.j.setLayoutParams(layoutParams);
        }
        this.d = (FrameLayout) findViewById(n.container);
        a(this.c);
        if (this.a != null) {
            this.a.a(this.e.f);
        }
        if (this.b != null) {
            this.b.a((float) this.e.e);
        }
        this.f = (TextView) findViewById(n.label);
        if (this.h != null) {
            this.f.setText(this.h);
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        this.g = (TextView) findViewById(n.details_label);
        if (this.i != null) {
            this.g.setText(this.i);
            this.g.setVisibility(0);
            return;
        }
        this.g.setVisibility(8);
    }
}
