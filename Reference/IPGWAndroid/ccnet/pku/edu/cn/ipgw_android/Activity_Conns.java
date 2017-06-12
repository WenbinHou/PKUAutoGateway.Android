package ccnet.pku.edu.cn.ipgw_android;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.q;
import android.support.v7.a.s;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.dt;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import com.chauthai.swipereveallayout.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Activity_Conns extends s {
    String l;
    String m;
    int n = 0;
    boolean o = false;
    boolean p = false;
    q q = null;
    private bi r;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a a = c().a();
        Drawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.title));
        a.b();
        a.a();
        ((TextView) findViewById(R.id.abs_header)).setText(R.string.all_connections);
        a.a(bitmapDrawable);
        a.a(true);
        setContentView((int) R.layout.activity_conns);
        overridePendingTransition(R.animator.trans_left_in, R.animator.trans_left_out);
        ((Button) findViewById(R.id.btndiscall)).setOnClickListener(new c(this));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String[] stringArray = extras.getStringArray("ConnectoinStringInfo");
            this.l = extras.getString("UserNameStringInfo");
            this.m = extras.getString("PasswdStringInfo");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (stringArray.length % 4 == 0) {
                int length = stringArray.length / 4;
                for (int i = 0; i < length; i++) {
                    arrayList2.add(new bw(stringArray[i * 4], stringArray[(i * 4) + 2], stringArray[(i * 4) + 1], stringArray[(i * 4) + 3]));
                }
            }
            fn.e(this);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
            dt biVar = new bi(this, this.l, this.m);
            this.r = biVar;
            recyclerView.setAdapter(biVar);
            this.r.a(arrayList2);
            findViewById(R.id.connections_relative_layout).setOnTouchListener(new d(this, this));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                Intent intent = new Intent();
                intent.putExtra("extra_AllIP_Disconnected", this.p);
                intent.putExtra("extra_CurrentIP_Disconnected", this.o);
                intent.putExtra("extra_CountIP_Disconnected", this.n);
                setResult(-1, intent);
                if (this.q != null && this.q.isShowing()) {
                    this.q.dismiss();
                    this.q = null;
                }
                finish();
                overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.r != null) {
            g gVar = this.r.d;
            if (bundle != null && bundle.containsKey("ViewBinderHelper_Bundle_Map_Key")) {
                Map hashMap = new HashMap();
                Bundle bundle2 = bundle.getBundle("ViewBinderHelper_Bundle_Map_Key");
                Set<String> keySet = bundle2.keySet();
                if (keySet != null) {
                    for (String str : keySet) {
                        hashMap.put(str, Integer.valueOf(bundle2.getInt(str)));
                    }
                }
                gVar.a = hashMap;
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.r != null) {
            g gVar = this.r.d;
            if (bundle != null) {
                Bundle bundle2 = new Bundle();
                for (Entry entry : gVar.a.entrySet()) {
                    bundle2.putInt((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                }
                bundle.putBundle("ViewBinderHelper_Bundle_Map_Key", bundle2);
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (this.q != null && this.q.isShowing()) {
            this.q.dismiss();
            this.q = null;
        }
    }
}
