package completefuture.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _01_ExecutorisMultiThreadMain {

	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
//		ExecutorService executorService = Executors.newFixedThreadPool(4);
//		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(getRunnable("피카츄"));
		executorService.submit(getRunnable("라이츄"));
		executorService.submit(getRunnable("파이리"));
		executorService.submit(getRunnable("꼬부기"));
		executorService.submit(getRunnable("버터플"));
		executorService.submit(getRunnable("야도란"));
		executorService.submit(getRunnable("피존투"));
		executorService.submit(getRunnable("또가스"));
		
		executorService.shutdown();
	}
	
	
	private static Runnable getRunnable(String message) {
		return () -> System.out.println(message + "`````````````" + Thread.currentThread().getName());
	}
}
