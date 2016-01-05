package thread.Path;

public class Printer {
	public synchronized void printNum(int number) throws InterruptedException{
		this.notify();
		System.out.println(Thread.currentThread().getName()+" Printed = "+number);
		this.wait();
	}
}
