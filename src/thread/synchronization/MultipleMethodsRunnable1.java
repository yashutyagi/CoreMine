package thread.synchronization;

public class MultipleMethodsRunnable1 implements Runnable{
	
	public static void main(String[] args) throws InterruptedException {
		MultipleMethodsRunnable1 obj1 = new MultipleMethodsRunnable1();
		Thread t1 = new Thread(obj1,"T1");
		
		MultipleMethodsRunnable2 obj2 = new MultipleMethodsRunnable2();
		Thread t2 = new Thread(obj2,"T2");
		
		MultipleMethodsRunnable3 obj3 = new MultipleMethodsRunnable3();
		Thread t3 = new Thread(obj3,"T3");
		
		t2.start();
		Thread.sleep(1000);
		t3.start();
		Thread.sleep(1000);
		t1.start();
		
	}
	
	@Override
	public void run() {
		MultipleMethods.methodA();
	}
}

class MultipleMethodsRunnable2 implements Runnable{
	@Override
	public void run() {
		MultipleMethods.methodB();
	}
}


class MultipleMethodsRunnable3 implements Runnable{
	@Override
	public void run() {
		MultipleMethods.methodC();
	}
}
