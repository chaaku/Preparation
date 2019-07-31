import java.util.HashSet;

public class OverriteHashcodeAndEquals {
	
	int id, age;
	String name, Email,phoneNumber;
	
	public OverriteHashcodeAndEquals(int id, int age, String phoneNumber, String name, String Email) {
		this.id=id;
		this.age=age;
		this.phoneNumber=phoneNumber;
		this.name=name;
		this.Email=Email;
	}

		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OverriteHashcodeAndEquals other = (OverriteHashcodeAndEquals) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}


	public static void main(String[] args) {
		
	HashSet<OverriteHashcodeAndEquals> set= new HashSet<>();
	
	set.add(new OverriteHashcodeAndEquals(1,21,"8904881024","Chandan","1@gmail.com"));
	set.add(new OverriteHashcodeAndEquals(2,21,"8904881024","Chandan","1@gmail.com"));
	set.add(new OverriteHashcodeAndEquals(3,21,"8904881024","Chandan","1@gmail.com"));
	set.add(new OverriteHashcodeAndEquals(4,21,"8904881024","Chandan","1@gmail.com"));
	set.add(new OverriteHashcodeAndEquals(5,21,"8904881024","Chandan","1@gmail.com"));
	set.add(new OverriteHashcodeAndEquals(1,21,"8904881024","Chandan","1@gmail.com"));
	
	System.out.println(set.size());
		
	}

}
