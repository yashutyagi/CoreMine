package filehandling;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 2058137021628476395L;
	
	private String employeeId;
	private String name;
	private String designation;
	private Set<String> phoneNumbers = new HashSet<String>();
	private Set<Address> addresses = new HashSet<Address>();
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
}
