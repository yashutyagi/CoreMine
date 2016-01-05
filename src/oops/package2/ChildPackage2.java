package oops.package2;

import oops.package1.BasePackage1;

public class ChildPackage2 extends BasePackage1{
	public void checkMethods(){
		aPublicMethod();
		aProtectedMethod();
		//aDefaultMethod();
		//aPrivateMethod();
		
		this.aPublicMethod();
		this.aProtectedMethod();
		//this.aDefaultMethod();
		//this.aPrivateMethod();
		
		BasePackage1 basepackage1 = new BasePackage1();
		basepackage1.aPublicMethod();
		//basepackage1.aProtectedMethod();
		//basepackage1.aDefaultMethod();
		//basepackage1.aPrivateMethod();
		
		System.out.println("A Public Int "+aPublicInt);
		System.out.println("A Protected Int "+aProtectedInt);
		//System.out.println("A Default Int "+aDefaultInt);
		//System.out.println("A Private Int "+aPrivateInt);

		System.out.println(this.aPublicInt);
		System.out.println(this.aProtectedInt);
		//System.out.println(this.aDefaultInt);
		//System.out.println(this.aPrivateInt);
		
		System.out.println(basepackage1.aPublicInt);
		//System.out.println(basepackage1.aProtectedInt);
		//System.out.println(basepackage1.aDefaultInt);
		//System.out.println(basepackage1.aPrivateInt);
	}
}
