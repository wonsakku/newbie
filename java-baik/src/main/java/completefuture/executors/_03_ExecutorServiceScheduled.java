package completefuture.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _03_ExecutorServiceScheduled {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//		scheduledExecutorService.schedule(getRunnable("Hello"), 2, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
		
//		scheduledExecutorService.shutdown();
		
	}
	
	private static Runnable getRunnable(String message) {
		return () -> System.out.println(message + "`````````````" + Thread.currentThread().getName());
	}

}
