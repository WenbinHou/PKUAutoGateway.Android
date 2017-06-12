package ccnet.pku.edu.cn.ipgw_android;

final class m implements Runnable {
    final /* synthetic */ Activity_MsgContent a;

    m(Activity_MsgContent activity_MsgContent) {
        this.a = activity_MsgContent;
    }

    public final void run() {
        this.a.l.setRefreshing(true);
    }
}
