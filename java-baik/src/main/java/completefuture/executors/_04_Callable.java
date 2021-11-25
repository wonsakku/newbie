package completefuture.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Runnable과 다르게(viod) Callable은 return type(<T>) 이 있다.
public class _04_Callable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Callable<String> callable = () -> {
			Thread.sleep(1000);
			return "Hello Callable";
		};
		
		Future<String> helloFuture = executorService.submit(callable);
		
		System.out.println(helloFuture.isDone()); // 끝났으면 true, 안끝났으면 false
		System.out.println("Started!!");
		
		helloFuture.get(); // blocking call -> 결과값을 가져올 때까지 기다림.
		
		System.out.println(helloFuture.isDone()); // 끝났으면 true, 안끝났으면 false
		System.out.println("End!!");
		executorService.shutdown();
	}
}







