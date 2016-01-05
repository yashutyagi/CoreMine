package thread.synchronization;

public class ReourceStaticLevelUser {
	public static void main(String[] args) {
		
		ReourceStaticLevel res1 = ReourceStaticLevel.getInstance1();
		ReourceStaticLevel res2 = ReourceStaticLevel.getInstance2();
		ReourceStaticLevel res3 = ReourceStaticLevel.getInstance1();
		
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
