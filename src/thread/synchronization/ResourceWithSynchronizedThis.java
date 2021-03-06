package thread.synchronization;

import java.util.concurrent.TimeUnit;

public class ResourceWithSynchronizedThis  implements Runnable{
	static int length = 100;
	
	public void methodA(){
		synchronized(this){
			for (int i = 0; i < length; i++) {
				try {
					System.out.println("Called Method A by = "+Thread.currentThread().getName()+" count= "+i);
					TimeUnit.MILLISECONDS.sleep(500);
					Thread.yield();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Method A Finished used by = "+Thread.currentThread().getName());
		}
	}
	@Override
	public void run() {
		methodA();
	}
}
