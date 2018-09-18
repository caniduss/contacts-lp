
import org.junit.Assert;
import org.junit.Test;


public class ContactServiceTest {

    private ContactService service = new ContactService();

    @Test
    public void testNameTooShort() throws ContactException {
        try {
            service.addContact("aa");
            Assert.fail("Aurait du passer dans l'exception");
        } catch (ContactException e) {

            // Ok tout s'est bien passé
        }
    }

    @Test(expected = ContactException.class)
    public void testNameTooLong() throws ContactException {
        service.addContact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
   
    @Test(expected = ContactException.class)
    public void testNameNull() throws ContactException {
        service.addContact(null);
    }
   
    @Test(expected = ContactException.class)
    public void testNameExist() throws ContactException {
        service.addContact("aaa");
        service.addContact("aaa");
    }
   
    @Test
    public void testNameValide() throws ContactException {
        service.addContact("aaa");
    }
       
   
}