package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

final class ae implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView a;

    public final void onClick(View view) {
        if (view == this.a.g) {
            this.a.a();
            Intent b = this.a.b.a.b(this.a.b.a.a(this.a.b.a.b()));
            if (b != null) {
                b.addFlags(524288);
                this.a.getContext().startActivity(b);
            }
        } else if (view == this.a.e) {
            this.a.m = false;
            this.a.a(this.a.n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void onDismiss() {
        if (this.a.l != null) {
            this.a.l.onDismiss();
        }
        if (this.a.a != null) {
            this.a.a.a(false);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (((ad) adapterView.getAdapter()).getItemViewType(i)) {
            case 0:
                this.a.a();
                if (!this.a.m) {
                    if (!this.a.b.b) {
                        i++;
                    }
                    Intent b = this.a.b.a.b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.a.getContext().startActivity(b);
                        return;
                    }
                    return;
                } else if (i > 0) {
                    x xVar = this.a.b.a;
                    synchronized (xVar.a) {
                        xVar.c();
                        y yVar = (y) xVar.b.get(i);
                        y yVar2 = (y) xVar.b.get(0);
                        xVar.a(new aa(new ComponentName(yVar.a.activityInfo.packageName, yVar.a.activityInfo.name), System.currentTimeMillis(), yVar2 != null ? (yVar2.b - yVar.b) + 5.0f : 1.0f));
                    }
                    return;
                } else {
                    return;
                }
            case 1:
                this.a.a(Integer.MAX_VALUE);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean onLongClick(View view) {
        if (view == this.a.g) {
            if (this.a.b.getCount() > 0) {
                this.a.m = true;
                this.a.a(this.a.n);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
