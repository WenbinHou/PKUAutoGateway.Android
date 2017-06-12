package android.support.v7.view;

import android.content.Context;
import android.support.v4.d.a.a;
import android.support.v4.d.a.b;
import android.support.v4.g.r;
import android.support.v7.view.menu.ab;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public final class h implements c {
    final Callback a;
    final Context b;
    final ArrayList<g> c = new ArrayList();
    final r<Menu, Menu> d = new r();

    public h(Context context, Callback callback) {
        this.b = context;
        this.a = callback;
    }

    private Menu a(Menu menu) {
        Menu menu2 = (Menu) this.d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = ab.a(this.b, (a) menu);
        this.d.put(menu, menu2);
        return menu2;
    }

    public final void a(b bVar) {
        this.a.onDestroyActionMode(b(bVar));
    }

    public final boolean a(b bVar, Menu menu) {
        return this.a.onCreateActionMode(b(bVar), a(menu));
    }

    public final boolean a(b bVar, MenuItem menuItem) {
        return this.a.onActionItemClicked(b(bVar), ab.a(this.b, (b) menuItem));
    }

    public final ActionMode b(b bVar) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.c.get(i);
            if (gVar != null && gVar.b == bVar) {
                return gVar;
            }
        }
        ActionMode gVar2 = new g(this.b, bVar);
        this.c.add(gVar2);
        return gVar2;
    }

    public final boolean b(b bVar, Menu menu) {
        return this.a.onPrepareActionMode(b(bVar), a(menu));
    }
}
