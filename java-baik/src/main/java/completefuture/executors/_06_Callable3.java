package completefuture.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Runnable과 다르게(viod) Callable은 return type(<T>) 이 있다.
public class _06_Callable3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Callable<String> callable = () -> {
			Thread.sleep(500);
			return "Hello";
		};
		
		Callable<String> java = () -> {
			Thread.sleep(1000);
			return "Java";
		};
		
		Callable<String> sakku = () -> {
			Thread.sleep(2000);
			return "sakku";
		};
		
		List<Future<String>> futures = executorService.invokeAll(Arrays.asList(callable, java, sakku));
		
		for(Future<String> f : futures) {
			System.out.println(f.get());
		}
		
		executorService.shutdown();
	}
}




















