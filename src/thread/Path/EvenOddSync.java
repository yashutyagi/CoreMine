package thread.Path;


public class EvenOddSync {
	public final static String STRING1 = "string";
	public static void main(String[] args) {
		/*Printer commonPrinter = new Printer();
		
		Runnable evenPrinter = new EvenPrinter(commonPrinter);
		Runnable oddPrinter = new OddPrinter(commonPrinter);
		ThreadFactory threadFactory = new CustomThreadFactory();
		Thread t1 = new Thread(evenPrinter);
		t1.setName("EvenPrinter");
		
		
		Thread t2 = new Thread(oddPrinter);
		t2.setName("OddPrinter");
		
		t2.start();
		t1.start();
		
		ExecutorService exec = Executors.newCachedThreadPool(threadFactory);
		exec.submit(evenPrinter);
		exec.submit(oddPrinter);
		exec.shutdown();*/
		EvenPrinter printer = new EvenPrinter(null);
		printer.setString("string");
		
		String s1 = "string";
		String s2 = "string";
		String s3 = "string".intern();
		String s4 = s1.intern();
		String s5 = new String("string");
		String s6 = new String("string").intern();
		String s7 = STRING1;
		String s8 = EvenPrinter.STRING2;
		String s9 = printer.getString();
		String s10 = "str";
		String s11 = "ing";
		String s12 = s10+s11;
		if(s1==s2){
			System.out.println("s1 and s2 are equal");
		}
		if(s1==s3){
			System.out.println("s1 and s3 are equal");
		}
		if(s1==s4){
			System.out.println("s1 and s4 are equal");
		}
		if(s1==s5){
			System.out.println("s1 and s5 are equal");
		}
		if(s1==s6){
			System.out.println("s1 and s6 are equal");
		}
		if(s1==s7){
			System.out.println("s1 and s7 are equal");
		}
		if(s1==s8){
			System.out.println("s1 and s8 are equal");
		}
		if(s1==s9){
			System.out.println("s1 and s9 are equal");
		}
		if(s1==s12){
			System.out.println("s1 and s12 are equal");
		}
	}
}
