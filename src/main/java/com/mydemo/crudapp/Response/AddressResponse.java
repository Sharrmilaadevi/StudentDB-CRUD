package com.mydemo.crudapp.Response;


public class AddressResponse {
	
private int idaddress;
	
	private String lane1;
	
	private String lane2;
	
	private String state;
	
	private String zip;
	
	public int getId() {
		return idaddress;
	}

	public void setId(int idaddress) {
		this.idaddress = idaddress;
	}

	public String getLane1() {
		return lane1;
	}

	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	public String getLane2() {
		return lane2;
	}

	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	

	@Override
	public String toString() {
		return "AddressResponse [id=" + idaddress + ", lane1=" + lane1 + ", lane2=" + lane2 + ", state=" + state + ", zip="
				+ zip + "]";
	}

}
