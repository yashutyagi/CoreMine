package thread.synchronization;

import java.util.concurrent.TimeUnit;



public class ReourceObjectLevel implements Runnable{
	private int length = 20;
	private Resource resource;
	public ReourceObjectLevel(Resource resource){
		this.resource = resource;
	}
	

	@Override
	public void run() {
		synchronized(resource){
			for (int i = 0; i < length ; i++) {
				try {
					System.out.println("Block 1 running for = "+Thread.currentThread().getName()+" count= "+i);
					TimeUnit.MILLISECONDS.sleep(500);
					Thread.yield();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
