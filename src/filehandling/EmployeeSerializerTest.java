package filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EmployeeSerializerTest {
	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		/*Employee employeObj = new Employee();
		employeObj.setEmployeeId("1");
		employeObj.setName("First Employee");
		employeObj.setDesignation("Designation");
		employeObj.getPhoneNumbers().add("9015787878");
		employeObj.getPhoneNumbers().add("9015787875");
		
		Address homeAddress = new Address();
		homeAddress.setHouseNumber("C1");
		homeAddress.setStreetName("Street1");
		homeAddress.setCityName("City1");
		homeAddress.setStateName(States.UTTARAKHAND);
		
		Address officeAddress = new Address();
		officeAddress.setHouseNumber("C2");
		officeAddress.setStreetName("Street2");
		officeAddress.setCityName("City2");
		officeAddress.setStateName(States.HARYANA);
		
		employeObj.getAddresses().add(homeAddress);
		employeObj.getAddresses().add(officeAddress);
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("emp.ser"));
		os.writeObject(employeObj);*/
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.ser"));
		Employee employeObj2 = (Employee) ois.readObject();
		System.out.println(employeObj2.getName());
		System.out.println(employeObj2.getPhoneNumbers());
		System.out.println(employeObj2.getAddresses());

	}

}
