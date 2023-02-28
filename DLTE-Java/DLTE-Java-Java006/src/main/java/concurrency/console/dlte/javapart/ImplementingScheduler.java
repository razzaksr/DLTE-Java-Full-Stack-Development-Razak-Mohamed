package concurrency.console.dlte.javapart;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ImplementingScheduler {
    public static void main(String[] args) {
        Wallet wall=new Wallet();

        ScheduledExecutorService service= Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> futureService= service.scheduleAtFixedRate(wall,5,5,TimeUnit.SECONDS);

        service.schedule(new Runnable() {
            @Override
            public void run() {
                futureService.cancel(true);
                service.shutdown();
            }
        },30,TimeUnit.SECONDS);
    }
}
