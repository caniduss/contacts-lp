

public class ContactService {
	
	IContactDao dao = new ContactDao();
	
	public void addContact(String name) throws ContactException{
		if(estValide(name)){
			Contact contact = new Contact();
			contact.setName(name);
			dao.add(contact);
			System.out.println("Le contact a été ajouté");
		}
		else{
			throw new ContactException("Impossible de créer le contact");
		}
		
	}
	
	public void deleteContact(String name) throws ContactNotFound{
		if(name == null){
			throw new IllegalArgumentException("Name can't be null");
		}
		Contact contact = dao.findByName(name);
		if(contact == null){
			throw new ContactNotFound("contact "+name+" not found");
		}
		dao.remove(contact);
	}
	
	
	
	public boolean estValide(String name)throws ContactException{
		boolean val= true;
		if(name==null ||name.length()<3 || name.length()>40){
			val=false;	
			throw new ContactException("Impossible de créer le contact, nom invalide");
		}
		if(val==true && dao.findByName(name) != null ){
			val=false;
			throw new ContactException("Impossible de créer le contact, nom déjà connu");
		}
		return val;
	}

}
