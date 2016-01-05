package thread.Executors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class TaskResult{
	private String value;
	private String taskName;
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskName() {
		return taskName;
	}
}
class DemoTask implements Callable<TaskResult>,Runnable{
	private String name;
	public DemoTask(String name){
		this.name = name;
	}
	@Override
	public void run() {
		call();
	}
	@Override
	public TaskResult call(){
		TaskResult result = new TaskResult();
		try{
			String value = String.valueOf(Math.random()*100);
			System.out.printf("Running Task %s with value %s \n",name,value);
			result.setTaskName(name);
			result.setValue(value);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
}

public class ExecutorInvokes {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*ExecutorService exec = Executors.newFixedThreadPool(3);
		List<DemoTask> taskList = new ArrayList<DemoTask>();
		for(int i=0;i<5;i++){
			taskList.add(new DemoTask("Task"+i));
		}
		TaskResult resultOne = exec.invokeAny(taskList);
		List<Future<TaskResult>> results = exec.invokeAll(taskList);
		for(Future<TaskResult> future : results){
			System.out.printf("Task Name %s -- Task Value %s \n ",future.get().getTaskName(),future.get().getValue());
		}
		System.out.printf("Task Name %s -- Task Value %s \n ",resultOne.getTaskName(),resultOne.getValue());*/
		//ScheduledExecutorService exec = Executors.newScheduledThreadPool(3);
		for(int i=0;i<5;i++){
			/**
			 * execute All 5 after 2 Seconds Delay
			 */
			//exec.schedule((Callable<TaskResult>)new DemoTask("Task"+i),2,TimeUnit.SECONDS);
		}
		
		/**
		 * Execute task after every 2 seconds
		 * 
		 * Need to have awaitTermination otherwise task won't run
		 */
		//exec.scheduleAtFixedRate(new DemoTask("Task"),2,2,TimeUnit.SECONDS);
		//exec.awaitTermination(20,TimeUnit.SECONDS);
		//exec.shutdown();
		
		/**
		 * Cancellation 
		 * 
		 * Cancle Task if required
		 * 
		 * throws cancellation exception.shutdown finally
		 * 
		 * Method will return false if task isn't canceled
		 */
		ExecutorService exec = Executors.newFixedThreadPool(5);
		try{
			for(int i=0;i<5;i++){
				Future<TaskResult> future = exec.submit((Callable<TaskResult>)new DemoTask("Task"+i));
				if(i>3){
					future.cancel(false);
				}
				System.out.println("i vallue=="+future.get().getTaskName());
				
			}
			List<String> aList = new ArrayList<String>(2);
			aList.add("zzz");
			aList.add("aaa");
			Collections.sort(aList,String.CASE_INSENSITIVE_ORDER);
			
		}catch(CancellationException ex){
			ex.printStackTrace();
		}
		finally{
			exec.shutdown();
		}
		Map<String,AtomicInteger> map = new TreeMap<String, AtomicInteger>(String.CASE_INSENSITIVE_ORDER);
		ConcurrentHashMap<String,String> maps = new ConcurrentHashMap<String, String>();
		maps.remove("", "");
		String value = "Key";
		for(int i=0;i<12;i++){
			map.put(value+i, new AtomicInteger(1));
		}
		value = "key";
		for(int i=8;i<25;i++){
			getAndAddFrequency(map,value+i);
		}
		System.out.println("Value of Map == "+map);
	}

	private static void getAndAddFrequency(Map<String,AtomicInteger> map,String key) {
	
		if(!map.containsKey(key)){
			map.put(key, new AtomicInteger(1));
		}else{
			map.get(key).getAndIncrement();
		}
	}
}
