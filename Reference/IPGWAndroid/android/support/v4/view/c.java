package android.support.v4.view;

import android.support.v4.view.a.f;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

final class c implements j {
    final /* synthetic */ a a;
    final /* synthetic */ b b;

    c(b bVar, a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    public final void a(View view, int i) {
        a.a(view, i);
    }

    public final void a(View view, Object obj) {
        this.a.a(view, new f(obj));
    }

    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return a.b(view, accessibilityEvent);
    }

    public final boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return a.a(viewGroup, view, accessibilityEvent);
    }

    public final void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.d(view, accessibilityEvent);
    }

    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        a.c(view, accessibilityEvent);
    }

    public final void d(View view, AccessibilityEvent accessibilityEvent) {
        a.a(view, accessibilityEvent);
    }
}
