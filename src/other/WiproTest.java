package other;



public class WiproTest {

	/**
	 * @param args
	 */
	int anInt = 1;
	public static void main(String[] args) {
		
		String[] arr = new String[] { "1#3", "4#5", "7#12", "20#23", "23#24" };
		int returnValue = profit_value(arr, 5);
		System.out.println("Answer = " + returnValue);
	}

	// 0,1
	/**
	 * 0- 0,1 1- 1,2 2- 2,3 3- 3,4
	 */
	public static int profit_value(String[] input1, int input2) {
		int bookings = 1;
		for (int i = 0; i < input2 - 1; i++) {
			String currEndTime = input1[i].split("#")[1];// 3,5,12,23
			String nextBeginTime = input1[i + 1].split("#")[0];// 4,7,20,23
			if (nextBeginTime.compareTo(currEndTime) >= 0) {
				++bookings;
			}

		}
		return bookings;
	}
}
