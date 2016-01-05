package thread.synchronization;

import java.util.concurrent.TimeUnit;



public class ReourceStaticLevel implements Runnable{
	private int length = 20;
	private static ReourceStaticLevel resource;
	private static ReourceStaticLevel resource2;
	private ReourceStaticLevel(){}
	
	public static ReourceStaticLevel getInstance1(){
		if(resource == null){
			resource = new ReourceStaticLevel();
			System.out.println("Object created "+resource.hashCode());
		}
		return resource;
	}
	
	public static ReourceStaticLevel getInstance2(){
		if(resource2 == null){
			resource2 = new ReourceStaticLevel();
			System.out.println("Object created "+resource2.hashCode());
		}
		return resource2;
	}

	@Override
	public void run() {
		mathodA();
	}


	private void mathodA() {
		synchronized(resource){
			for (int i = 0; i < length ; i++) {
				try {
					System.out.println("Block 1 running for = "+Thread.currentThread().getName()+" count= "+i);
					System.out.print(" hashCode"+resource.hashCode());
					TimeUnit.MILLISECONDS.sleep(500);
					Thread.yield();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
