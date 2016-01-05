package innerclass;


public class NormalInnerClass1 {
	private int outerInt = 1;
	public void aNonStaticMethod(){
		System.out.println(new MyInnerClass().innerInt);
		new MyInnerClass().aInnerNonStaticMethod();
	}
	
	public static void aStaticMethod(){
		//System.out.println(new MyOuter().innerInt); // Compilation error for static method
		System.out.println(new NormalInnerClass1().new MyInnerClass().innerInt);
	}
	public class MyInnerClass{
		private int innerInt = 1;
		public void aInnerNonStaticMethod(){
			outerInt = 3;
			System.out.println(outerInt); // Implictly has outer class private as well as public variable
		}
		
		/**
		 * Can't define static method in normal inner class
		 */
		/*public static void aStaticMethod(){
			//System.out.println(new MyOuter().innerInt); // Compilation error for static method
			System.out.println(new NormalInnerClass1().new MyInnerClass().innerInt);
		}*/
	}
}
