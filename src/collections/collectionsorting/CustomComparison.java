package collections.collectionsorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Fruit implements Comparable<Fruit>{
	private String name;
	private double price;
	
	
	public Fruit(String name,double price){
		this.name = name;
		this.price = price;
	}
	
	@Override
	public int compareTo(Fruit fruit) {
		return  FruitUtil.compareFruits(this,fruit);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString(){
		return "Fruit ["+name+","+price+"]";
		
	}
}

class FruitComparator implements Comparator<Fruit>{
	@Override
	public int compare(Fruit fruit1, Fruit fruit2) {
		return FruitUtil.compareFruits(fruit1, fruit2);
	}
}

class FruitUtil {
	public static int compareFruits(Fruit fruit1, Fruit fruit2){
		int returnVal = 0;
		if(fruit2!=null){
			if(fruit2.getName() == null || fruit1.getName() == null){
				if(fruit1.getName()==null && fruit2.getName() != null){
					returnVal = 1;
				}else if(fruit1.getName()!=null && fruit2.getName()==null){
					returnVal = -1;
				}else {
					returnVal = (int)(fruit2.getPrice() - fruit1.getPrice());
				}
			}else{
				returnVal = fruit1.getName().compareTo(fruit2.getName());
				if(returnVal == 0){
					returnVal = (int)(fruit2.getPrice() - fruit1.getPrice());
				}
			}
		}
		return returnVal;
	
	}
}
public class CustomComparison {
	public static void main(String[] args){
		Fruit[] fruits = new Fruit[]{new Fruit("Apple",50),new Fruit("Banana",40),
				new Fruit("Cherry",50),new Fruit("Date",50),new Fruit("Apple",30),
				new Fruit("Banana",50),new Fruit("Cherry",60),new Fruit("Date",70),
				new Fruit(null,0),new Fruit(null,10)};
		//AbstractSet<String> stete = new HashSet<String>();
		List<Fruit> fruitList = Arrays.asList(fruits);
		System.out.println("Unsorted FruitList1 = "+fruitList);
		List<Fruit> fruitList2 = Arrays.asList(fruits);
		System.out.println("Unsorted FruitList2 = "+fruitList2);
		Collections.sort(fruitList);
		System.out.println("Sorted FruitList1 = "+fruitList);
		Collections.sort(fruitList2,new FruitComparator());
		System.out.println("Sorted FruitList2 = "+fruitList2);
	}
}