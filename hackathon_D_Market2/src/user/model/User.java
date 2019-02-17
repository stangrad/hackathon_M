	package user.model;
/**
 * Class - deal with user information and functions.
 * @author Yunting Wang
 *
 */
public class User {
//id,first_name,last_name,email,phoneNumber,creditcard,bankaccount,currentUsage,currentProduction
	private String id;
	private String first_name;
	private String last_name;
	private String email;
	private String phoneNumber;
	private String creditcard;
	private String bankaccount;
	private double currentUsage;
	private double currentProduction;
	public User() {
		id="";
		first_name="";
		last_name="";
		email="";
		phoneNumber="";
		creditcard="";
		bankaccount="";
		currentUsage=0.0;
		currentProduction=0.0;
	}
	public User(String id, String first_name, String last_name, String email, String phonNumber, 
			String creditcard, String bankaccount, double currentUsage, double currentProduction) {
		setId(id);
		setFirst_name(first_name);
		setLast_name(last_name);
		setEmail(email);
		setPhonNumber(phoneNumber);
		setBankaccount(creditcard);
		setCurrentUsage(currentUsage);
		setCurrentProduction(currentProduction);
		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonNumber() {
		return phoneNumber;
	}
	public void setPhonNumber(String phonNumber) {
		this.phoneNumber = phonNumber;
	}
	public String getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getCurrentUsage() {
		return currentUsage;
	}
	public void setCurrentUsage(double currentUsage) {
		this.currentUsage = currentUsage;
	}
	public double getCurrentProduction() {
		return currentProduction;
	}
	public void setCurrentProduction(double currentProduction) {
		this.currentProduction = currentProduction;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("User Information: %s,%s,%s,%s,%s,%s,%s,%s,%s",
						getId(), getFirst_name(),getLast_name(), getEmail(),getPhonNumber(),
						getCreditcard(),getBankaccount(),getCurrentUsage(),getCurrentProduction());
				
	}

}
