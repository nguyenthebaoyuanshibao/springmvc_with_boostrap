package springmvc_example.model;

public class Customer {
	
	private Integer id;
	private String firsname;
	private String lastname;
	private String gender;
	private String address;
	
	public Customer() {
		super();
		
	}
	public Customer(Integer id, String firsname, String lastname, String gender, String address) {
		super();
		this.id = id;
		this.firsname = firsname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirsname() {
		return firsname;
	}
	public void setFirsname(String firsname) {
		this.firsname = firsname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
