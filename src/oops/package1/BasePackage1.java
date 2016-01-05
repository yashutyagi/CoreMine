package oops.package1;

public class BasePackage1 {
	public int aPublicInt;
	protected int aProtectedInt;
	int aDefaultInt;
	@SuppressWarnings("unused")
	private int aPrivateInt;
	
	public void aPublicMethod(){
		System.out.println("Public Access Method Called From BasePackage1");
	}
	
	protected void aProtectedMethod(){
		System.out.println("Protected Access Method Called From BasePackage1");
	}
	
	void aDefaultMethod(){
		System.out.println("Default Access Method Called From BasePackage1");
	}
	
	@SuppressWarnings("unused")
	private void aPrivateMethod(){
		System.out.println("Private Method Called From BasePackage1");
	}
}
