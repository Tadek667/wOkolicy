package okolica.model;


public class TKontakt extends TEntity{

	public static final String P_NAME = "name";
	public static final String P_SURNAME = "surname";
	public static final String P_EMAIL = "email";
	public static final String P_PHONE = "phone";
	
	private String name;
	private String surname;
	private String email;
	private String phone;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
