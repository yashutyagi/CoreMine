package collections.generics;

import java.util.ArrayList;
import java.util.Collection;

public class MISCUtils {
	public static <T> Collection<T> toList(T[] array){
		Collection<T> returnList = null;
		if(array!=null){
			returnList = new ArrayList<T>();
			for (T t : array) {
				returnList.add(t);
			}
		}
		return returnList;
	}
}
