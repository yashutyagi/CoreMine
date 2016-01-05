package thread.Path;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 extends Thread {
	volatile int a = 2;
	private Lock lock = new ReentrantLock();

	public int getValue() throws InterruptedException {
		lock.lock();
		try {
			System.out.println(" Entered Thread = "+Thread.currentThread().getName());
			a++;
			Thread.yield();
			TimeUnit.MILLISECONDS.sleep(2000);
			a++;
			System.out.println(" Work Done by Thread = "+Thread.currentThread().getName()+" = val ="+a);
			return a;
		} finally {
			System.out.println(" Finished Thread = "+Thread.currentThread().getName());
			lock.unlock();
		}
	}

	static Test1 test = null;

	public static void main(String[] args) {
		test = new Test1();
		Thread t1 = new Test1();
		t1.start();
		t1.setName("T1");
		Thread t2 = new Test1();
		t2.start();
		t2.setName("T2");
	}

	public void run() {
		while (true) {
			int a;
			try {
				a = test.getValue();
				if (a % 2 != 0) {
					System.out.println("Wrong Value" + a);
					System.exit(0);
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
