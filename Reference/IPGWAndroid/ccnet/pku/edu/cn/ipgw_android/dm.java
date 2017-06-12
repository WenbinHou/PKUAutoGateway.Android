package ccnet.pku.edu.cn.ipgw_android;

final class dm implements Runnable {
    final /* synthetic */ dj a;

    dm(dj djVar) {
        this.a = djVar;
    }

    public final void run() {
        this.a.ak.setRefreshing(true);
    }
}
