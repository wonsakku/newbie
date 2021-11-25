package completefuture.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _02_ExecutorsSingleThreadMain {

	public static void main(String[] args) {
//		Executor
//		ExecutorService extends Executor
//		ScheduledExecutorService extends ExcecutorService
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		executorService.submit(() -> System.out.println("ThreadName : " + Thread.currentThread().getName()));
		
		//executorService는 작업을 실행하면 다음 작업이 들어올 때까지 계속 대기하기 때문에 process가 죽지 않는다.
		// 그래서 명시적으로 종료해야 한다.
		executorService.shutdown(); // graceful shutdown - 현재 작업 끝까지 마치고 끝냄
//		executorService.shutdownNow(); // 좐인한~
		
		
		
		
//		executorService.execute(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Thread" + Thread.currentThread().getName());
//			}
//		});
		
		
		
	}
}














