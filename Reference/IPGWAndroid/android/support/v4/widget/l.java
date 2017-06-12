package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class l extends BaseAdapter implements p, Filterable {
    protected boolean a = false;
    protected boolean b = true;
    public Cursor c = null;
    public Context d;
    protected int e;
    protected m f;
    protected DataSetObserver g;
    protected o h;
    protected FilterQueryProvider i;

    public l(Context context) {
        this.d = context;
        this.e = -1;
        this.f = new m(this);
        this.g = new n();
    }

    public final Cursor a() {
        return this.c;
    }

    public Cursor a(CharSequence charSequence) {
        return this.i != null ? this.i.runQuery(charSequence) : this.c;
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public void a(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.c) {
            cursor2 = null;
        } else {
            cursor2 = this.c;
            if (cursor2 != null) {
                if (this.f != null) {
                    cursor2.unregisterContentObserver(this.f);
                }
                if (this.g != null) {
                    cursor2.unregisterDataSetObserver(this.g);
                }
            }
            this.c = cursor;
            if (cursor != null) {
                if (this.f != null) {
                    cursor.registerContentObserver(this.f);
                }
                if (this.g != null) {
                    cursor.registerDataSetObserver(this.g);
                }
                this.e = cursor.getColumnIndexOrThrow("_id");
                this.a = true;
                notifyDataSetChanged();
            } else {
                this.e = -1;
                this.a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract void a(View view, Cursor cursor);

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public CharSequence b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    protected final void b() {
        if (this.b && this.c != null && !this.c.isClosed()) {
            this.a = this.c.requery();
        }
    }

    public int getCount() {
        return (!this.a || this.c == null) ? 0 : this.c.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            return null;
        }
        this.c.moveToPosition(i);
        if (view == null) {
            view = b(this.d, this.c, viewGroup);
        }
        a(view, this.c);
        return view;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new o(this);
        }
        return this.h;
    }

    public Object getItem(int i) {
        if (!this.a || this.c == null) {
            return null;
        }
        this.c.moveToPosition(i);
        return this.c;
    }

    public long getItemId(int i) {
        return (this.a && this.c != null && this.c.moveToPosition(i)) ? this.c.getLong(this.e) : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.c.moveToPosition(i)) {
            if (view == null) {
                view = a(this.d, this.c, viewGroup);
            }
            a(view, this.c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
