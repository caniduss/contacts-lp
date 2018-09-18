import org.junit.Assert;
import org.junit.Test;

/*
import fr.lps2ima.contact.ContactException;
import fr.lps2ima.contact.dao.ContactDao;
import fr.lps2ima.contact.dao.IContactDao;
import fr.lps2ima.contact.model.Contact;
*/
public class ContactDaoTest {

    IContactDao dao = new ContactDao();
       
    @Test
    public void testNameFound() throws ContactException {
        Contact contact = new Contact();
        contact.setName("aaa");
        dao.add(contact);
       
        Contact found = dao.findByName("aaa");
        Assert.assertNotNull(found);
        Assert.assertEquals("aaa", found.getName());
    }
   
    @Test
    public void testNameNotFound() throws ContactException {       
        Contact found = dao.findByName("bbb");
        Assert.assertNull(found);
    }

}