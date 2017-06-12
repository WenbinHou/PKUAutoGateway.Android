package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.f;
import android.support.v4.view.bq;
import android.support.v4.widget.bd;
import android.support.v7.a.c;
import android.support.v7.widget.ao;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

final class bw extends LinearLayout implements OnLongClickListener {
    final /* synthetic */ TabLayout a;
    private bu b;
    private TextView c;
    private ImageView d;
    private View e;
    private TextView f;
    private ImageView g;
    private int h = 2;

    public bw(TabLayout tabLayout, Context context) {
        this.a = tabLayout;
        super(context);
        if (tabLayout.m != 0) {
            setBackgroundDrawable(ao.a().a(context, tabLayout.m, false));
        }
        bq.a(this, tabLayout.e, tabLayout.f, tabLayout.g, tabLayout.h);
        setGravity(17);
        setOrientation(1);
        setClickable(true);
    }

    private void a(bu buVar) {
        if (buVar != this.b) {
            this.b = buVar;
            a();
        }
    }

    static /* synthetic */ void a(bw bwVar) {
        bwVar.a(null);
        bwVar.setSelected(false);
    }

    private void a(TextView textView, ImageView imageView) {
        Drawable drawable = this.b != null ? this.b.b : null;
        CharSequence charSequence = this.b != null ? this.b.c : null;
        CharSequence charSequence2 = this.b != null ? this.b.d : null;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
            imageView.setContentDescription(charSequence2);
        }
        boolean z = !TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (z) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText(null);
            }
            textView.setContentDescription(charSequence2);
        }
        if (imageView != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
            int a = (z && imageView.getVisibility() == 0) ? this.a.b(8) : 0;
            if (a != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = a;
                imageView.requestLayout();
            }
        }
        if (z || TextUtils.isEmpty(charSequence2)) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    final void a() {
        bu buVar = this.b;
        View view = buVar != null ? buVar.f : null;
        if (view != null) {
            bw parent = view.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(view);
                }
                addView(view);
            }
            this.e = view;
            if (this.c != null) {
                this.c.setVisibility(8);
            }
            if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setImageDrawable(null);
            }
            this.f = (TextView) view.findViewById(16908308);
            if (this.f != null) {
                this.h = bd.a(this.f);
            }
            this.g = (ImageView) view.findViewById(16908294);
        } else {
            if (this.e != null) {
                removeView(this.e);
                this.e = null;
            }
            this.f = null;
            this.g = null;
        }
        if (this.e == null) {
            if (this.d == null) {
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(f.design_layout_tab_icon, this, false);
                addView(imageView, 0);
                this.d = imageView;
            }
            if (this.c == null) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(f.design_layout_tab_text, this, false);
                addView(textView);
                this.c = textView;
                this.h = bd.a(this.c);
            }
            this.c.setTextAppearance(getContext(), this.a.i);
            if (this.a.j != null) {
                this.c.setTextColor(this.a.j);
            }
            a(this.c, this.d);
        } else if (this.f != null || this.g != null) {
            a(this.f, this.g);
        }
    }

    @TargetApi(14)
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(c.class.getName());
    }

    @TargetApi(14)
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(c.class.getName());
    }

    public final boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.b.d, 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public final void onMeasure(int i, int i2) {
        int i3 = 1;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int f = this.a.getTabMaxWidth();
        if (f > 0 && (mode == 0 || size > f)) {
            i = MeasureSpec.makeMeasureSpec(this.a.n, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.c != null) {
            getResources();
            float h = this.a.k;
            size = this.h;
            if (this.d != null && this.d.getVisibility() == 0) {
                size = 1;
            } else if (this.c != null && this.c.getLineCount() > 1) {
                h = this.a.l;
            }
            float textSize = this.c.getTextSize();
            int lineCount = this.c.getLineCount();
            int a = bd.a(this.c);
            if (h != textSize || (a >= 0 && size != a)) {
                if (this.a.t == 1 && h > textSize && lineCount == 1) {
                    Layout layout = this.c.getLayout();
                    if (layout == null || layout.getLineWidth(0) * (h / layout.getPaint().getTextSize()) > ((float) layout.getWidth())) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    this.c.setTextSize(0, h);
                    this.c.setMaxLines(size);
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    public final boolean performClick() {
        boolean performClick = super.performClick();
        if (this.b == null) {
            return performClick;
        }
        this.b.a();
        return true;
    }

    public final void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
            if (this.c != null) {
                this.c.setSelected(z);
            }
            if (this.d != null) {
                this.d.setSelected(z);
            }
        }
    }
}
