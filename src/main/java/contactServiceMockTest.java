

import java.util.Optional;

import org.easymock.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;


public class contactServiceMockTest extends EasyMockSupport{

	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDao contactDao;
	
	@Test(expected = ContactException.class)
	public void testAddContact() throws ContactException {
		// 1 - Enregistrement des comportements de mocks
		Contact contact = new Contact();
		EasyMock.expect(contactDao.findByName("LaPhraseQueJeVeux")).andReturn(contact);
		// 2 - Fin d'enregistrement
		replayAll();
		// 3 - Test
		service.addContact("LaPhraseQueJeVeux");
	}
	
	@Test(expected=ContactNotFound.class)
	public void testDelContact() throws ContactNotFound {
		// 1 - Enregistrement des comportements de mocks
		EasyMock.expect(contactDao.findByName("LaPhraseQueJeVeux")).andReturn(null);
		// 2 - Fin d'enregistrement
		replayAll();
		// 3 - Test
		service.deleteContact("LaPhraseQueJeVeux");
	}
	
	@Test
	public void testDelContactOk() throws ContactNotFound {
		// 1 - Enregistrement des comportements de mocks
		Contact contact = new Contact();
		contact.setName("Toto");
		EasyMock.expect(contactDao.findByName("LaPhraseQueJeVeux")).andReturn(contact);
		Capture<Contact> newCapture = EasyMock.newCapture();
		contactDao.remove(EasyMock.capture(newCapture));
		// 2 - Fin d'enregistrement
		replayAll();
		// 3 - Test
		service.deleteContact("LaPhraseQueJeVeux");
		
		Assert.assertEquals("Toto", newCapture.getValue().getName());
	}
	
	@Test
	public void testDelContactOkAnyObject() throws ContactNotFound {
		// 1 - Enregistrement des comportements de mocks
		Contact contact = new Contact();
		contact.setName("Toto");
		EasyMock.expect(contactDao.findByName("LaPhraseQueJeVeux")).andReturn(contact);
		contactDao.remove(EasyMock.anyObject());
		// 2 - Fin d'enregistrement
		replayAll();
		// 3 - Test
		service.deleteContact("LaPhraseQueJeVeux");
	}
}
