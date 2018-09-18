import java.util.ArrayList;
import java.util.List;

public class ContactDao implements IContactDao {
	
	List<Contact> contacts = new ArrayList<>();

	/* (non-Javadoc)
	 * @see iContactDao#readAll()
	 */
	@Override
	public List<Contact> readAll(){
		return contacts;
	}
	
	/* (non-Javadoc)
	 * @see iContactDao#findByName(java.lang.String)
	 */
	@Override
	public Contact findByName(String name){
		Contact contactToReturn = null;
		// Select * from contacts where name = %1 
		// prepared statement . add (%1 , name) 
		// exectuteQuery 
		for (Contact contact : contacts) {
			if(contact.getName().equalsIgnoreCase(name)){
				contactToReturn = contact;
				break;
			}
		}
		return contactToReturn;
	}
	
	/* (non-Javadoc)
	 * @see iContactDao#add(Contact)
	 */
	@Override
	public void add(Contact contact){
		contacts.add(contact);
	}

	/* (non-Javadoc)
	 * @see iContactDao#remove(Contact)
	 */
	public void remove(Contact contact){
		contacts.remove(contact);
	}
}
