package oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefrencePassTest {
	public static void main(String[] args) {
		Point pointx = new Point();//100,100
		Point pointy = new Point();//0,0
		List<String> aStringList = new ArrayList<String>(Arrays.asList("1","2","3"));
		changeList(aStringList);
		System.out.println(aStringList);
		swipePoints(pointx,pointy);
		System.out.println("Point x = "+pointx);
		System.out.println("Point y = "+pointy);

		/*	
		 * ================================================	*
		 * ================================================	*
		 * ================================================	*
		 * ================================================	*
		 *													*/
		Integer i1 = 1000;
		Integer i2 = 1000;
		if(i1==i2){
			System.out.println("Both equal");
		}
		Integer i3 = 127;
		Integer i4 = 127;
		if(i3 == i4){
			System.out.println("same object");
		}


		/*	
		 * ================================================	*
		 * ================================================	*
		 * ================================================	*
		 * ================================================	*
		 *													*/

		byte b1 = 12;
		byte b2 = 13;
		short s1 = 12;
		callByteMethod1(b1,b2);
		callByteMethod1(b1,s1);

		int anInt1 = 3; 
		callLongMethod(anInt1);
		//callLongMethod2(anInt1); 

		/**
		 * Auto widening does not work if method called
		 * specifically accepts wrapper class 
		 */

		Integer anInt2 = 3;
		callLongMethod(anInt2);
		/**
		 * Auto widening works if method called
		 * accepts primitive type and argument is wrapper class
		 */
		//callLongMethod2(anInt2);

	}

	public static void callLongMethod(long i) {
		System.out.println("called callLongMethod(long i)");
	}

	public static void callLongMethod2(Long i) {
		System.out.println("called callLongMethod(long i)");
	}

	/**
	 * Will be called when two shorts are passed only. 3
	 * No widening will take place if a specific method already exists
	 * @param b1
	 * @param b2
	 */
	public static void callByteMethod1(short b1, short b2) {
		System.out.println("called short b1, short b2");

	}

	/**
	 * Will be called always if 2 bytes are passed
	 * as var arg method is more generic and can acceopts any number of bytes
	 * and AutoBoxing is not preffered if specific method is available
	 * @param b1
	 * @param b2
	 */
	public static void callByteMethod1(byte b1, byte b2) {
		System.out.println("called byte b1, byte b2");
	}

	public static void callByteMethod1(byte ...b) {
		System.out.println("called byte ...b");
	}

	public static void callByteMethod1(Byte b1, Byte b2) {
		System.out.println("called Byte b1, Byte b2");
	}

	private static void changeList(List<String> aStringList) {
		aStringList = null;
		//aStringList.add("4");
		System.out.println("List Locally"+aStringList);
	}

	private static void swipePoints(Point arg1, Point arg2) {
		arg1.x = 100;
		arg1.y = 100;

		Point temp = arg1;
		arg1 = arg2;
		arg2 = temp;
	}
}

class Bridge {
	public enum Suits {
		CLUBS(20), DIAMONDS(20), HEARTS(30), SPADES(30),
		NOTRUMP(40){
			public int getValue(int bid){
				return ((bid-1)*30)+40; 
			} 
		};
		Suits(int points) {
			this.points = points;
		}

		private int points;

		public int getValue(int bid) {
			return points * bid;
		}
	}
	public static void main(String[] args) {
		System.out.println(Suits.NOTRUMP.getValue(3));
		System.out.println(Suits.SPADES + " " + Suits.SPADES.points);
		System.out.println(Suits.values());
	}
}
