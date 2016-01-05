package thread.synchronization;

public class ReourceObjectLevelUser {
	public static void main(String[] args) {
		Resource resource1 = new Resource();
		Resource resource2 = new Resource();
		
		ReourceObjectLevel res1 = new ReourceObjectLevel(resource1);
		ReourceObjectLevel res2 = new ReourceObjectLevel(resource2);
		ReourceObjectLevel res3 = new ReourceObjectLevel(resource1);
		
		Thread t1 = new Thread(res1);
		t1.setName("T1");
		
		Thread t2 = new Thread(res2);
		t2.setName("T2");
		
		Thread t3 = new Thread(res3);
		t3.setName("T3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
