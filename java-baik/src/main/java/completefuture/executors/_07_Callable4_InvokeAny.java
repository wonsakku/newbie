package completefuture.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Runnable과 다르게(viod) Callable은 return type(<T>) 이 있다.
public class _07_Callable4_InvokeAny {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		Callable<String> callable = () -> {
			Thread.sleep(2000);
			return "Hello";
		};
		
		Callable<String> java = () -> {
			Thread.sleep(1000);
			return "Java";
		};
		
		Callable<String> sakku = () -> {
			Thread.sleep(100);
			return "sakku";
		};
		
		String invokeAny = executorService.invokeAny(Arrays.asList(callable, java, sakku));
		
		System.out.println(invokeAny);
		
		executorService.shutdown();
	}
}




















