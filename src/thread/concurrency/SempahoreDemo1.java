package thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SempahoreDemo1 {
	public static void main(String[] args) {
		RunnerClass clas = new RunnerClass();
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++){
			exec.execute(clas);
		}
		exec.shutdown();
	}
}

class RunnerClass implements Runnable{
	Semaphore semaphore = new Semaphore(3);
	@Override
	public void run() {
		try {
			semaphore.acquire();
			for(int i=0;i<20;i++){
				System.out.printf("\n %s Thread running Count Val %s ",Thread.currentThread().getName(),i);
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
}
