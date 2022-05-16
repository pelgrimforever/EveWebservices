package eve.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Configsystemactivity implements ServletContextListener {

    private ScheduledExecutorService schedulerbackup;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        schedulerbackup = Executors.newSingleThreadScheduledExecutor();
        schedulerbackup.scheduleAtFixedRate(new Schedulesystemactivity(), 0, 1, TimeUnit.DAYS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        schedulerbackup.shutdownNow();
    }

}