package designpatterns.singleton;

import java.io.IOException;

public class Class implements Runnable {
	public void aMethod()  throws IOException{
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Processors = "+runtime.availableProcessors());
		System.out.println("Free Memory = "+runtime.freeMemory()/1024/1024);
		
		System.out.println("Max Memory = "+runtime.maxMemory()/1024/1024);
		System.out.println("Total Memory = "+runtime.totalMemory()/1024/1024);
		/*Process process = runtime.exec("dir");
		System.out.println(process.getInputStream().read());*/
		runtime.addShutdownHook(new Thread(this));
		runtime.runFinalization();
		System.out.println(runtime.freeMemory());
	}
	public static void main(String[] args) throws IOException {
		new Class().aMethod();
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
