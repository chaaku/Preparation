import java.util.Set;
import java.util.TreeSet;

class Contact implements Comparable<Contact> 
{ 
	private String firstName; 
	private String lastName; 
	private String phoneNumber; 

Contact(String fname,String lname,String phno) 
{ 
	firstName=fname; 
	lastName=lname; 
	phoneNumber=phno; 

} 
void setFirstName() { 
	this.firstName=firstName; 
} 
void setLastName() { 
	this.lastName=lastName; 
} 

String getFirstName() { 
	return firstName; 
} 
String getLastName() { 
	return lastName; 
} 

String getPhoneNumber() { 
	return phoneNumber; 
} 

void setPhoneNumber() { 
	this.phoneNumber=phoneNumber; 
} 


@Override 
public int compareTo(Contact o) { 
	return getFirstName().compareTo(o.getFirstName()); 
} 

@Override
public String toString() {
		return "First Name :" +firstName+ " Last Name :"+lastName+" phone Number :"+phoneNumber;
	}
} 

class AddressBook { 
	static Set<Contact> contacts; 
	public AddressBook() { 
		contacts= new TreeSet<Contact>(); 
} 

public static void main(String a[]) 
{ 
	AddressBook ob=new AddressBook(); 
	contacts.add(new Contact("shashank","mani","8804567889")); 
	contacts.add(new Contact("rahul","sharma","90045067889")); 
	contacts.add(new Contact("mohan","mani","9894568089")); 
	contacts.add(new Contact("rajesh","sharma","12885607889")); 
	contacts.add(new Contact("ashutosh","mani","7834567889")); 
	contacts.add(new Contact("raja","goyal","6734567889")); 
	contacts.add(new Contact("mayank","sharma","2234467889")); 
	contacts.add(new Contact("bullu","verma","1234568809")); 
	contacts.add(new Contact("nimish","narayan","8256907834")); 
	contacts.add(new Contact("c.p","sharm","9256738890")); 
	
	contacts.forEach(System.out::println);
	System.out.println("Find Rahul : ");
	findInContact(contacts, "rahul");
	
	System.out.println("Find mani : ");
	findInContact(contacts, "mani");
	
	System.out.println("Find with phone : ");
	findInContact(contacts, "8256907834");
}

private static void findInContact(Set<Contact> contacts2, String key) {
	// TODO Auto-generated method stub
	
	contacts2.forEach((inContact)-> {
		if(inContact.getFirstName()==key ||inContact.getLastName()==key ||inContact.getPhoneNumber()==key ) {
			System.out.println(inContact);;
		}
	});
//	for(int i=0; i<contacts2.size(); i++) {
//		Contact contact = contacts2.
//		
//	}
} 



} 
