import java.io.Serializable;
public class People implements Serializable{
	private String name;
	private String address;
	private long identityNumbers;
	private long location;
	public People(String name,String address,int identityNumbers) 
	{
		this.name=name;
		this.address=address;
		this.identityNumbers=identityNumbers;
		this.location=0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getIdentityNumbers() {
		return identityNumbers;
	}
	public void setIdentityNumbers(long identityNumbers) {
		this.identityNumbers = identityNumbers;
	}

	public long getLocation() {
		return location;
	}
	public void setLocation(long l) {
		this.location = l;
	}	
}
