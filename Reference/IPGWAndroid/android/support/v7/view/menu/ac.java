package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.d.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

class ac extends e<a> implements Menu {
    ac(Context context, a aVar) {
        super(context, aVar);
    }

    public MenuItem add(int i) {
        return a(((a) this.d).add(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(((a) this.d).add(i, i2, i3, i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(((a) this.d).add(i, i2, i3, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return a(((a) this.d).add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((a) this.d).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i) {
        return a(((a) this.d).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((a) this.d).addSubMenu(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((a) this.d).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((a) this.d).addSubMenu(charSequence));
    }

    public void clear() {
        if (this.b != null) {
            this.b.clear();
        }
        if (this.c != null) {
            this.c.clear();
        }
        ((a) this.d).clear();
    }

    public void close() {
        ((a) this.d).close();
    }

    public MenuItem findItem(int i) {
        return a(((a) this.d).findItem(i));
    }

    public MenuItem getItem(int i) {
        return a(((a) this.d).getItem(i));
    }

    public boolean hasVisibleItems() {
        return ((a) this.d).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((a) this.d).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((a) this.d).performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((a) this.d).performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        if (this.b != null) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
        ((a) this.d).removeGroup(i);
    }

    public void removeItem(int i) {
        if (this.b != null) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    break;
                }
            }
        }
        ((a) this.d).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((a) this.d).setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((a) this.d).setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        ((a) this.d).setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        ((a) this.d).setQwertyMode(z);
    }

    public int size() {
        return ((a) this.d).size();
    }
}
