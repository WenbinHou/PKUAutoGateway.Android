package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class aq extends n {
    ListAdapter Z;
    ListView aa;
    View ab;
    TextView ac;
    View ad;
    View ae;
    CharSequence af;
    boolean ag;
    private final Handler ah = new Handler();
    private final Runnable ai = new ar(this);
    private final OnItemClickListener aj = new as(this);

    private void a(boolean z, boolean z2) {
        q();
        if (this.ad == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.ag != z) {
            this.ag = z;
            if (z) {
                if (z2) {
                    this.ad.startAnimation(AnimationUtils.loadAnimation(b(), 17432577));
                    this.ae.startAnimation(AnimationUtils.loadAnimation(b(), 17432576));
                } else {
                    this.ad.clearAnimation();
                    this.ae.clearAnimation();
                }
                this.ad.setVisibility(8);
                this.ae.setVisibility(0);
                return;
            }
            if (z2) {
                this.ad.startAnimation(AnimationUtils.loadAnimation(b(), 17432576));
                this.ae.startAnimation(AnimationUtils.loadAnimation(b(), 17432577));
            } else {
                this.ad.clearAnimation();
                this.ae.clearAnimation();
            }
            this.ad.setVisibility(0);
            this.ae.setVisibility(8);
        }
    }

    private void q() {
        if (this.aa == null) {
            View view = this.I;
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.aa = (ListView) view;
            } else {
                this.ac = (TextView) view.findViewById(16711681);
                if (this.ac == null) {
                    this.ab = view.findViewById(16908292);
                } else {
                    this.ac.setVisibility(8);
                }
                this.ad = view.findViewById(16711682);
                this.ae = view.findViewById(16711683);
                view = view.findViewById(16908298);
                if (view instanceof ListView) {
                    this.aa = (ListView) view;
                    if (this.ab != null) {
                        this.aa.setEmptyView(this.ab);
                    } else if (this.af != null) {
                        this.ac.setText(this.af);
                        this.aa.setEmptyView(this.ac);
                    }
                } else if (view == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.ag = true;
            this.aa.setOnItemClickListener(this.aj);
            if (this.Z != null) {
                ListAdapter listAdapter = this.Z;
                this.Z = null;
                a(listAdapter);
            } else if (this.ad != null) {
                a(false, false);
            }
            this.ah.post(this.ai);
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Context b = b();
        View frameLayout = new FrameLayout(b);
        View linearLayout = new LinearLayout(b);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(b, null, 16842874), new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        linearLayout = new FrameLayout(b);
        linearLayout.setId(16711683);
        View textView = new TextView(b());
        textView.setId(16711681);
        textView.setGravity(17);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        textView = new ListView(b());
        textView.setId(16908298);
        textView.setDrawSelectorOnTop(false);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        return frameLayout;
    }

    public void a(int i) {
    }

    public final void a(View view, Bundle bundle) {
        super.a(view, bundle);
        q();
    }

    public final void a(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.Z != null;
        this.Z = listAdapter;
        if (this.aa != null) {
            this.aa.setAdapter(listAdapter);
            if (!this.ag && !z2) {
                if (this.I.getWindowToken() != null) {
                    z = true;
                }
                a(true, z);
            }
        }
    }

    public final void l() {
        this.ah.removeCallbacks(this.ai);
        this.aa = null;
        this.ag = false;
        this.ae = null;
        this.ad = null;
        this.ab = null;
        this.ac = null;
        super.l();
    }
}
