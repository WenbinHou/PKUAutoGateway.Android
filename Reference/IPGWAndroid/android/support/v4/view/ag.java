package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;

class ag implements af {
    ag() {
    }

    public final an a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        return factory instanceof ak ? ((ak) factory).a : null;
    }

    public void a(LayoutInflater layoutInflater, an anVar) {
        layoutInflater.setFactory(anVar != null ? new ak(anVar) : null);
    }
}
