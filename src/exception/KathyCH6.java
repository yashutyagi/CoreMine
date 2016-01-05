package exception;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class KathyCH6 {
	public static void main(String[] args) {
		Emu.main(null);
		try {
			byte x = 2;
			switch (x) {
			case 23:
				reverse("Hello");
			case 12:
				System.out.println(reverse(" aa "));
			case 3:
				String str = "abc";
				reverse(str);
				break;
			case 4:
				DateFormat sdf = DateFormat.getDateInstance(2);
				sdf.format(new Date());
				break;
			default:
				Calendar cal = Calendar.getInstance(Locale.US);
				Date date = cal.getTime();
				cal.setTime(date);
			}
			System.out.println(reverse(" "));
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
	}

	private static String reverse(String aString) {
		if (aString == null || aString.trim().length() == 0) {
			throw new IllegalArgumentException(
					"String should be atleast one character long");
		}
		char[] charArray = aString.toCharArray();
		String retString = "";

		for (int i = charArray.length - 1; i >= 0; i--) {
			retString = retString + charArray[i];
		}
		return retString;
	}
}

class Emu {
	
	static String s = "-";
	public static void aFoo(){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		dateFormat.format(date);
		final Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -5);
		cal.roll(Calendar.MONTH,10);
		
		new Thread(new Runnable() {
		
			@Override
			public void run() {
				for (int i = 0; i < 12; i++) {
					try {
						System.out.println(cal.getTime().toString());
						TimeUnit.SECONDS.sleep(6);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		
			}
		}).start();
	}
	
	public static void main(String[] args) {
		aFoo();
		String s = new String();
		System.out.println("s = " + s);
		try {
			throw new Exception();
		} catch (Exception e) {
			try {
				try {
					throw new Exception();
				} catch (Exception ex) {
					s += "ic ";
				}
				throw new Exception();
			} catch (Exception x) {
				s += "mc ";
			} finally {
				s += "mf ";
			}
		} finally {
			s += "of ";
		}
		System.out.println(s);
	}
}
