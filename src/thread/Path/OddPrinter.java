package thread.Path;

public class OddPrinter implements Runnable{
	private Printer printer;
	public OddPrinter(Printer printer){
		this.printer = printer;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(this.getClass().getName());
		for(int i=1;i<=100;i++){
			if(i%2!=0){
				try {
					printer.printNum(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		printer.notifyAll();
	}
}
