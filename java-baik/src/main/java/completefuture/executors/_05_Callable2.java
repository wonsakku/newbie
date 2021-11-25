package completefuture.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Runnable과 다르게(viod) Callable은 return type(<T>) 이 있다.
public class _05_Callable2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Callable<String> callable = () -> {
			Thread.sleep(4000);
			return "Hello Callable";
		};
		
		Future<String> helloFuture = executorService.submit(callable);
		
		System.out.println(helloFuture.isDone()); // 끝났으면 true, 안끝났으면 false
		System.out.println("Started!!");
		
//		helloFuture.cancel(true); // true면 현재 작업을 기다림?
		helloFuture.cancel(false); // false면 현재 작업을 안기다림>?
		
		System.out.println(helloFuture.isDone()); // 끝났으면 true, 안끝났으면 false
		
		helloFuture.get();
		
		System.out.println("End!!");
		executorService.shutdown();
	}
}







