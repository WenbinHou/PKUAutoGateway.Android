package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.b.a;
import android.support.v4.widget.ao;
import android.support.v7.b.b;
import android.support.v7.b.g;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

final class fl extends ao implements OnClickListener {
    int j = 1;
    private final SearchManager k = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView l;
    private final SearchableInfo m;
    private final Context n;
    private final WeakHashMap<String, ConstantState> o;
    private final int p;
    private boolean q = false;
    private ColorStateList r;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;

    public fl(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.l = searchView;
        this.m = searchableInfo;
        this.p = searchView.getSuggestionCommitIconResId();
        this.n = context;
        this.o = weakHashMap;
    }

    private Drawable a(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable a(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return b(uri);
            }
            openInputStream = this.n.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.n.getPackageName() + "/" + parseInt;
            b = b(str2);
            if (b != null) {
                return b;
            }
            b = a.a(this.n, parseInt);
            a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = b(str);
            if (b != null) {
                return b;
            }
            b = a(Uri.parse(str));
            a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private static String a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    private static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private static void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.o.put(str, drawable.getConstantState());
        }
    }

    private Drawable b(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    private Drawable b(String str) {
        ConstantState constantState = (ConstantState) this.o.get(str);
        return constantState == null ? null : constantState.newDrawable();
    }

    private static void c(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public final Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.l.getVisibility() != 0 || this.l.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor;
            SearchableInfo searchableInfo = this.m;
            if (searchableInfo == null) {
                cursor = null;
            } else {
                String suggestAuthority = searchableInfo.getSuggestAuthority();
                if (suggestAuthority == null) {
                    cursor = null;
                } else {
                    String[] strArr;
                    Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
                    String suggestPath = searchableInfo.getSuggestPath();
                    if (suggestPath != null) {
                        fragment.appendEncodedPath(suggestPath);
                    }
                    fragment.appendPath("search_suggest_query");
                    suggestPath = searchableInfo.getSuggestSelection();
                    if (suggestPath != null) {
                        strArr = new String[]{charSequence2};
                    } else {
                        fragment.appendPath(charSequence2);
                        strArr = null;
                    }
                    fragment.appendQueryParameter("limit", "50");
                    cursor = this.d.getContentResolver().query(fragment.build(), null, suggestPath, strArr, null);
                }
            }
            if (cursor != null) {
                cursor.getCount();
                return cursor;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public final View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.a(context, cursor, viewGroup);
        a.setTag(new fm(a));
        ((ImageView) a.findViewById(g.edit_query)).setImageResource(this.p);
        return a;
    }

    public final void a(Cursor cursor) {
        if (this.q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.s = cursor.getColumnIndex("suggest_text_1");
                this.t = cursor.getColumnIndex("suggest_text_2");
                this.u = cursor.getColumnIndex("suggest_text_2_url");
                this.v = cursor.getColumnIndex("suggest_icon_1");
                this.w = cursor.getColumnIndex("suggest_icon_2");
                this.x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public final void a(View view, Cursor cursor) {
        Drawable drawable = null;
        fm fmVar = (fm) view.getTag();
        int i = this.x != -1 ? cursor.getInt(this.x) : 0;
        if (fmVar.a != null) {
            a(fmVar.a, a(cursor, this.s));
        }
        if (fmVar.b != null) {
            CharSequence charSequence;
            CharSequence a = a(cursor, this.u);
            if (a != null) {
                if (this.r == null) {
                    TypedValue typedValue = new TypedValue();
                    this.d.getTheme().resolveAttribute(b.textColorSearchUrl, typedValue, true);
                    this.r = this.d.getResources().getColorStateList(typedValue.resourceId);
                }
                CharSequence spannableString = new SpannableString(a);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.r, null), 0, a.length(), 33);
                charSequence = spannableString;
            } else {
                charSequence = a(cursor, this.t);
            }
            if (TextUtils.isEmpty(charSequence)) {
                if (fmVar.a != null) {
                    fmVar.a.setSingleLine(false);
                    fmVar.a.setMaxLines(2);
                }
            } else if (fmVar.a != null) {
                fmVar.a.setSingleLine(true);
                fmVar.a.setMaxLines(1);
            }
            a(fmVar.b, charSequence);
        }
        if (fmVar.c != null) {
            Drawable drawable2;
            ImageView imageView = fmVar.c;
            if (this.v == -1) {
                drawable2 = null;
            } else {
                drawable2 = a(cursor.getString(this.v));
                if (drawable2 == null) {
                    ComponentName searchActivity = this.m.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.o.containsKey(flattenToShortString)) {
                        ConstantState constantState = (ConstantState) this.o.get(flattenToShortString);
                        drawable2 = constantState == null ? null : constantState.newDrawable(this.n.getResources());
                    } else {
                        Drawable a2 = a(searchActivity);
                        this.o.put(flattenToShortString, a2 == null ? null : a2.getConstantState());
                        drawable2 = a2;
                    }
                    if (drawable2 == null) {
                        drawable2 = this.d.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            a(imageView, drawable2, 4);
        }
        if (fmVar.d != null) {
            ImageView imageView2 = fmVar.d;
            if (this.w != -1) {
                drawable = a(cursor.getString(this.w));
            }
            a(imageView2, drawable, 8);
        }
        if (this.j == 2 || (this.j == 1 && (i & 1) != 0)) {
            fmVar.e.setVisibility(0);
            fmVar.e.setTag(fmVar.a.getText());
            fmVar.e.setOnClickListener(this);
            return;
        }
        fmVar.e.setVisibility(8);
    }

    public final CharSequence b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.m.shouldRewriteQueryFromData()) {
            a = a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.m.shouldRewriteQueryFromText()) {
            return null;
        }
        a = a(cursor, "suggest_text_1");
        return a != null ? a : null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = a(this.d, this.c, viewGroup);
            if (a != null) {
                ((fm) a.getTag()).a.setText(e.toString());
            }
            return a;
        }
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        c(this.c);
    }

    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        c(this.c);
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.l.setQuery((CharSequence) tag);
        }
    }
}
