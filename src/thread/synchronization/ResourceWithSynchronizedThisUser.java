package thread.synchronization;

public class ResourceWithSynchronizedThisUser {
	public static void main(String[] args) {
		
		ResourceWithSynchronizedThis instanceOne = new ResourceWithSynchronizedThis();
		ResourceWithSynchronizedThis instanceTwo = new ResourceWithSynchronizedThis();
		
		Thread t1 = new Thread(instanceOne);
		t1.setName("T1");
		
		Thread t2 = new Thread(instanceTwo);
		t2.setName("T2");
		
		Thread t3 = new Thread(instanceOne);
		t3.setName("T3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}