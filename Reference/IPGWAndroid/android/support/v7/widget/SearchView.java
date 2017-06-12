package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.l;
import android.support.v7.b.b;
import android.support.v7.b.e;
import android.support.v7.view.d;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import java.util.WeakHashMap;

public final class SearchView extends co implements d {
    static final ez a = new ez();
    private static final boolean b = (VERSION.SDK_INT >= 8);
    private boolean A;
    private boolean B;
    private int C;
    private boolean D;
    private CharSequence E;
    private boolean F;
    private int G;
    private SearchableInfo H;
    private Bundle I;
    private Runnable J;
    private final Runnable K;
    private Runnable L;
    private final WeakHashMap<String, ConstantState> M;
    private final SearchAutoComplete c;
    private final View d;
    private final View e;
    private final ImageView f;
    private final ImageView g;
    private final ImageView h;
    private final ImageView i;
    private final ImageView j;
    private final Drawable k;
    private final int l;
    private final int m;
    private final Intent n;
    private final Intent o;
    private final CharSequence p;
    private fb q;
    private fa r;
    private OnFocusChangeListener s;
    private fc t;
    private OnClickListener u;
    private boolean v;
    private boolean w;
    private l x;
    private boolean y;
    private CharSequence z;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new fd();
        boolean a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.a));
        }
    }

    public class SearchAutoComplete extends ai {
        private int a;
        private SearchView b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, b.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = getThreshold();
        }

        public boolean enoughToFilter() {
            return this.a <= 0 || super.enoughToFilter();
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.b.d();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.b.clearFocus();
                        this.b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.a(getContext())) {
                    ez ezVar = SearchView.a;
                    if (ezVar.c != null) {
                        try {
                            ezVar.c.invoke(this, new Object[]{Boolean.valueOf(true)});
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.a = i;
        }
    }

    private void a(boolean z) {
        Object obj = 1;
        int i = 8;
        this.w = z;
        int i2 = z ? 0 : 8;
        Object obj2 = !TextUtils.isEmpty(this.c.getText()) ? 1 : null;
        this.f.setVisibility(i2);
        i2 = (this.y && e() && hasFocus() && (obj2 != null || !this.D)) ? 0 : 8;
        this.g.setVisibility(i2);
        this.d.setVisibility(z ? 8 : 0);
        i2 = (this.j.getDrawable() == null || this.v) ? 8 : 0;
        this.j.setVisibility(i2);
        Object obj3 = !TextUtils.isEmpty(this.c.getText()) ? 1 : null;
        Object obj4 = (obj3 != null || (this.v && !this.F)) ? 1 : null;
        this.h.setVisibility(obj4 != null ? 0 : 8);
        Drawable drawable = this.h.getDrawable();
        if (drawable != null) {
            drawable.setState(obj3 != null ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
        if (obj2 != null) {
            obj = null;
        }
        if (!this.D || this.w || r4 == null) {
            i2 = 8;
        } else {
            this.g.setVisibility(8);
            i2 = 0;
        }
        this.i.setVisibility(i2);
        if (e() && (this.g.getVisibility() == 0 || this.i.getVisibility() == 0)) {
            i = 0;
        }
        this.e.setVisibility(i);
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean e() {
        return (this.y || this.D) && !this.w;
    }

    private void f() {
        post(this.K);
    }

    private void g() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.c;
        if (queryHint == null) {
            queryHint = "";
        }
        if (this.v && this.k != null) {
            int textSize = (int) (((double) this.c.getTextSize()) * 1.25d);
            this.k.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.k), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            Object obj = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(e.abc_search_view_preferred_width);
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.J);
            return;
        }
        removeCallbacks(this.J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public final void a() {
        if (!this.F) {
            this.F = true;
            this.G = this.c.getImeOptions();
            this.c.setImeOptions(this.G | 33554432);
            this.c.setText("");
            setIconified(false);
        }
    }

    public final void b() {
        CharSequence charSequence = "";
        this.c.setText(charSequence);
        this.c.setSelection(this.c.length());
        this.E = charSequence;
        clearFocus();
        a(true);
        this.c.setImeOptions(this.G);
        this.F = false;
    }

    public final void clearFocus() {
        this.B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.c.clearFocus();
        this.B = false;
    }

    final void d() {
        a(this.w);
        f();
        if (this.c.hasFocus()) {
            ez ezVar = a;
            SearchAutoComplete searchAutoComplete = this.c;
            if (ezVar.a != null) {
                try {
                    ezVar.a.invoke(searchAutoComplete, new Object[0]);
                } catch (Exception e) {
                }
            }
            ezVar = a;
            searchAutoComplete = this.c;
            if (ezVar.b != null) {
                try {
                    ezVar.b.invoke(searchAutoComplete, new Object[0]);
                } catch (Exception e2) {
                }
            }
        }
    }

    public final int getImeOptions() {
        return this.c.getImeOptions();
    }

    public final int getInputType() {
        return this.c.getInputType();
    }

    public final int getMaxWidth() {
        return this.C;
    }

    public final CharSequence getQuery() {
        return this.c.getText();
    }

    public final CharSequence getQueryHint() {
        return this.z != null ? this.z : (!b || this.H == null || this.H.getHintId() == 0) ? this.p : getContext().getText(this.H.getHintId());
    }

    final int getSuggestionCommitIconResId() {
        return this.m;
    }

    final int getSuggestionRowLayout() {
        return this.l;
    }

    public final l getSuggestionsAdapter() {
        return this.x;
    }

    protected final void onDetachedFromWindow() {
        removeCallbacks(this.K);
        post(this.L);
        super.onDetachedFromWindow();
    }

    protected final void onMeasure(int i, int i2) {
        if (this.w) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.C, size);
                    break;
                }
            case 0:
                if (this.C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.C;
                    break;
                }
            case 1073741824:
                if (this.C > 0) {
                    size = Math.min(this.C, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    protected final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(savedState.a);
        requestLayout();
    }

    protected final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.w;
        return savedState;
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        f();
    }

    public final boolean requestFocus(int i, Rect rect) {
        if (this.B || !isFocusable()) {
            return false;
        }
        if (this.w) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.c.requestFocus(i, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    public final void setAppSearchData(Bundle bundle) {
        this.I = bundle;
    }

    public final void setIconified(boolean z) {
        if (!z) {
            a(false);
            this.c.requestFocus();
            setImeVisibility(true);
            if (this.u != null) {
                this.u.onClick(this);
            }
        } else if (!TextUtils.isEmpty(this.c.getText())) {
            this.c.setText("");
            this.c.requestFocus();
            setImeVisibility(true);
        } else if (!this.v) {
        } else {
            if (this.r == null || !this.r.a()) {
                clearFocus();
                a(true);
            }
        }
    }

    public final void setIconifiedByDefault(boolean z) {
        if (this.v != z) {
            this.v = z;
            a(z);
            g();
        }
    }

    public final void setImeOptions(int i) {
        this.c.setImeOptions(i);
    }

    public final void setInputType(int i) {
        this.c.setInputType(i);
    }

    public final void setMaxWidth(int i) {
        this.C = i;
        requestLayout();
    }

    public final void setOnCloseListener(fa faVar) {
        this.r = faVar;
    }

    public final void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.s = onFocusChangeListener;
    }

    public final void setOnQueryTextListener(fb fbVar) {
        this.q = fbVar;
    }

    public final void setOnSearchClickListener(OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public final void setOnSuggestionListener(fc fcVar) {
        this.t = fcVar;
    }

    final void setQuery(CharSequence charSequence) {
        this.c.setText(charSequence);
        this.c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public final void setQueryHint(CharSequence charSequence) {
        this.z = charSequence;
        g();
    }

    public final void setQueryRefinementEnabled(boolean z) {
        this.A = z;
        if (this.x instanceof fl) {
            ((fl) this.x).j = z ? 2 : 1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setSearchableInfo(SearchableInfo searchableInfo) {
        boolean z = true;
        this.H = searchableInfo;
        if (this.H != null) {
            if (b) {
                this.c.setThreshold(this.H.getSuggestThreshold());
                this.c.setImeOptions(this.H.getImeOptions());
                int inputType = this.H.getInputType();
                if ((inputType & 15) == 1) {
                    inputType &= -65537;
                    if (this.H.getSuggestAuthority() != null) {
                        inputType = (inputType | 65536) | 524288;
                    }
                }
                this.c.setInputType(inputType);
                if (this.x != null) {
                    this.x.a(null);
                }
                if (this.H.getSuggestAuthority() != null) {
                    this.x = new fl(getContext(), this, this.H, this.M);
                    this.c.setAdapter(this.x);
                    ((fl) this.x).j = this.A ? 2 : 1;
                }
            }
            g();
        }
        if (b) {
            boolean z2;
            if (this.H != null && this.H.getVoiceSearchEnabled()) {
                Intent intent = this.H.getVoiceSearchLaunchWebSearch() ? this.n : this.H.getVoiceSearchLaunchRecognizer() ? this.o : null;
                if (intent != null) {
                    z2 = getContext().getPackageManager().resolveActivity(intent, 65536) != null;
                }
            }
            z2 = false;
        }
        z = false;
        this.D = z;
        if (this.D) {
            this.c.setPrivateImeOptions("nm");
        }
        a(this.w);
    }

    public final void setSubmitButtonEnabled(boolean z) {
        this.y = z;
        a(this.w);
    }

    public final void setSuggestionsAdapter(l lVar) {
        this.x = lVar;
        this.c.setAdapter(this.x);
    }
}
