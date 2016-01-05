package thread.synchronization;

import java.util.concurrent.TimeUnit;

public class MultipleMethods {
	
	public static synchronized void methodA(){
		for (int i = 0; i < 20 ; i++) {
			try {
				System.out.println("Block 1 running for = "+Thread.currentThread().getName()+" count= "+i);
				TimeUnit.MILLISECONDS.sleep(500);
				Thread.yield();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void methodB(){
		for (int i = 0; i < 20 ; i++) {
			try {
				System.out.println("Block B running for = "+Thread.currentThread().getName()+" count= "+i);
				TimeUnit.MILLISECONDS.sleep(500);
				Thread.yield();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static synchronized void methodC(){
		for (int i = 0; i < 20 ; i++) {
			try {
				System.out.println("Block B running for = "+Thread.currentThread().getName()+" count= "+i);
				TimeUnit.MILLISECONDS.sleep(500);
				Thread.yield();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
