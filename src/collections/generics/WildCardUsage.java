package collections.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WildCardUsage {


	public static void main(String... s){
		List<Integer> intList = Arrays.asList(2,3);
		List<String> stringList = Arrays.asList("four","five");
		List<Object> miscObjectList2 = Arrays.<Object>asList(2,3,"four","five");
		List<?> miscObjectList = Arrays.<Comparable<?>>asList(2,3,"four","five");

		List<Integer> ints = Arrays.asList(5, 6);
		Collections.copy(intList, ints);

		System.out.print("\nstringList = "+stringList.toString()+"\nmiscObjectList =  "+miscObjectList.toString());
		System.out.println("\nmiscObjectList2 = "+miscObjectList2);
		
		/**
		 *  The Get and Put Principle: 
		 *  Use an extends wildcard when you only get values out of a structure. 
		 *  Use a super wildcard when you only put values into a structure, 
		 *  and don’t use a wildcard when you both get and put.
		 */
		
		List<? super BaseInterface<Integer>> list1 = new ArrayList<Object>();
		List<? extends BaseInterface<Integer>> list2 = new ArrayList<Class1>();
		List<? extends Number> numbersList = new ArrayList<Double>();
		//numberList.add(new Double(3.12)); Can't Add anything,Compilation error
		someMethod(list1,list2);
		System.out.println("\n numbersList = "+numbersList);


		List<? super Number> numberList2 = new ArrayList<Serializable>();// as Number Implements Serializable
		numberList2.add(3.12);
		Number num = (Number) numberList2.get(0);
		System.out.println(num);//Can't Read without type cast

		


		/**
		 * Adding Float to a number type array wont give compile time error
		 * But on runtime will give ArrayStore Exception
		 * 
		 * List of anything of type number wont allow anything to add
		 * i.e. will prevent adding float,int,double etc which are all of type numbers
		 * at compile time.
		 * 
		 * Because compiler wont know to what type of object is this reference pointing to.
		 * 
		 */
		Number[] array1 = new Integer[3];
		try{
			array1[0] = 3;
			array1[1] = (int)2.14;//Runtime Error Here
			//array1[2] = 2.44f;
		}catch(ArrayStoreException e){
			e.printStackTrace();
		}
		List<Number> aList = new ArrayList<Number>(Arrays.<Number>asList(1,2,3));
		List<? extends Number> arrayList1 = aList;
		System.out.println("First Time = "+arrayList1);
		aList.add(22.4f);
		System.out.println("Second Time = "+arrayList1);
		//arrayList1.add(2.44f);//Compile Time Error Here
		System.out.println("array1 = "+Arrays.toString(array1)+"\narrayList1="+arrayList1);
		
		
		/**
		 * One subtype , rest superType will return List of superType 
		 */
		Integer number1 = new Integer(2);
		Number number2 = new Integer(33);
		List<Number> parentChildList = Arrays.asList(number2,number1);
		System.out.println("parentChildList = "+parentChildList);
		
		
		/**
		 * For Upcasting List of integers to list of numbers.... Casting like this <Number>
		 * 
		 * But only a method that is generictype can be Upcasted like this.
		 */
		
		Integer integre1 = new Integer(2);
		Integer integre2 = new Integer(33);
		List<Number> childOnlyToParentList = Arrays.<Number>asList(integre2,integre1);
		System.out.println("childOnlyToParentList = "+childOnlyToParentList);
		
		
		/**
		 * Co Variant In generics
		 */
		Class1 class1 = new Class1();
		
		List<Integer> speciFicTypeList = class1.getSpecificTypeList(); // Can be assigned to type of Interface implemented by Class1
		System.out.println("\nspeciFicTypeList = "+speciFicTypeList);
		
		List<Number> numssList = new ArrayList<Number>();
		List<? extends Number> numTypeList = class1.returnNumTypeList();
		numTypeList = numssList;
		numssList.add(2);
		numssList.add(22);
		numssList.add(24);
		System.out.println("apiList === "+numTypeList);
		
		Integer numss = new Integer(2);
		List<? super Integer> numbersLists = class1.getListSuperofType(numss);
		numbersLists.add(numss);
		List<Serializable> serializablesList = class1.returnSuperToNumTypeList();
		System.out.println("\n numbersLists = "+numbersLists+"\nserializablesList = "+serializablesList);
		
		
		/**
		 * 
		 */
		List<List<?>> lists = new ArrayList<List<?>>();
		lists.add(Arrays.asList(1,2,3));
		lists.add(Arrays.asList("four","five"));
	}



	public static <T>  void  someMethod(List<? super T> aList,List<? extends T> bList){
		System.out.println("Before List = "+bList);
	}
	
	
}

interface BaseInterface<T extends Number>{
	public List<T> getSpecificTypeList();
	
	public List<? extends Number> returnNumTypeList();
	
	public List<? super Number> returnSuperToNumTypeList();
	
	public <P> List<? super P> getListSuperofType(P type);
}

/**
 * Covariant Return Type
 * 
 *
 */
class Class1 implements BaseInterface<Integer>{
	private List<Integer> integers;
	
	@Override
	public List<Integer> getSpecificTypeList() {
		return integers;
	}
	
	@Override
	public List<Double> returnNumTypeList() {
		List<Double> apiList = new ArrayList<Double>();
		apiList.add(2.33);
		apiList.add(2.34);
		apiList.add(2.35);
		apiList = Collections.unmodifiableList(apiList);
		//apiList.add(2.36);
		return apiList;
	}
	
	@Override
	public List<Serializable> returnSuperToNumTypeList() {
		List<Serializable> serializablesList = Arrays.<Serializable>asList(1,2,3,"Four");
		return serializablesList;
	}
	
	@Override
	/**
	 * If declaration is of this type
	 * 
	 * Assigned value to the caller should be of same type
	 */
	public <P> List<? super P> getListSuperofType(P type) {
		List<? super P> aList = new ArrayList<P>();
		aList.add(type);
		return aList;
	}
	
	public <T> List<T> someMethod(T type){
		List<T> alist = new ArrayList<T>();
		alist.add(type);
		return alist;
		
	}
	
}

