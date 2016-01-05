package filehandling;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1216364319084112083L;
	private String houseNumber;
	private String streetName;
	private String cityName;
	private States stateName;
	public enum States{
		UTTARPRADESH,HARYANA,UTTARAKHAND,RAJASTHAN,GUJARAT,MAHARASHTRA;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public States getStateName() {
		return stateName;
	}
	public void setStateName(States stateName) {
		this.stateName = stateName;
	}
	
}
