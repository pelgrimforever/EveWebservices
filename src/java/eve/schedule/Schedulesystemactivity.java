package eve.schedule;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class Schedulesystemactivity implements Runnable {

    @Schedule(hour="3", minute="0", second="0", persistent=false)
    public void run() {
        new Systemactivitytask();
    }

}