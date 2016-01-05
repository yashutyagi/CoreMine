package thread.Path;

public class EvenPrinter implements Runnable {
	
	private Printer printer;
	private String string;
	public EvenPrinter(Printer printer){
		this.printer = printer;
	}
	
	public final static String STRING2 = "string";
	@Override
	public void run() {
		Thread.currentThread().setName(this.getClass().getName());
		for(int i=2;i<=100;i++){
			if(i%2==0){
				try {
					printer.printNum(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		printer.notifyAll();
	}
	public void setString(String string) {
		this.string = string;
		
	}
	public String getString() {
		return string;
	}
}
