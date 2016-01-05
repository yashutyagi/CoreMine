package thread.Executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class CallableTaks implements Callable<String>{
	private String name;
	public String getName(){
		return name;
	}
	public CallableTaks(String name){
		this.name = name;
	}
	@Override
	public String call() throws Exception {
		System.out.println("Task Running");
		int duration = 5;
		TimeUnit.SECONDS.sleep(duration);
		return name;
	}
}

class MyFutureTask extends FutureTask<String>{
	private String name;

	public String getName(){
		return name;
	}
	
	public MyFutureTask(Callable<String> callable) {
		super(callable);
		this.name = ((CallableTaks) callable).getName();
	}
	@Override
	protected void done() {
		super.done();
		System.out.printf("Task \"%s\" complted \n",name);
	}
}

public class WorkAfterThreadFinish {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		exec.setRejectedExecutionHandler(new RejectedExecutionHandler(){

			@Override
			public void rejectedExecution(Runnable r,
					ThreadPoolExecutor executor) {
				System.out.println("Task execution rejected");
				/**
				 * Can re run rejected task here
				 */
				/*Thread t = new Thread(r);
				t.setName("T1");
				t.start();*/
			}
		});
		//exec.submit(new CallableTaks("Task")); Normal Way 
		
		/**
		 *  Call back Feature
		 */
		CallableTaks callableTaks = new CallableTaks("CallableTask");
		MyFutureTask futureTasks = new MyFutureTask(callableTaks);
		exec.shutdown();
		exec.awaitTermination(6000,TimeUnit.MILLISECONDS);
		Thread.sleep(5000);
		Future<?> result = exec.submit(futureTasks);
		/**
		 * this submit is runnable as future task implements an interface
		 * that extends Runnable
		 */
		System.out.println("Task Completed "+(result.get()==null));//will be null if completed successful.
	}
}
