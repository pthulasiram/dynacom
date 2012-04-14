package com.dynacom.app.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dynacom.app.domain.model.Address;
import com.dynacom.app.domain.model.Contact;
import com.dynacom.app.domain.model.Signon;
import com.dynacom.app.domain.services.IContactService;
import com.dynacom.app.domain.services.ISignonService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTests {

	@Autowired
	IContactService contactService;

	@Test
	public void testServiceContact() throws Exception {
		contactService.createContact(createContact());
	}

	@Autowired
	ISignonService signonService;

	@Test
	public void testSignon() throws Exception {
		signonService.registerUser(createSignon());
	}
	
	@Test
	public void testLogon() throws Exception {
		Signon logon = new Signon();
		logon.setUserId("JOHN@GMAIL.COM");
		logon.setPassword("PASS");
		signonService.logon(logon);
	}

	private Contact createContact() {

		Contact contact = new Contact();
		contact.setCivility("MR");
		contact.setFirstName("John");
		contact.setLastName("DOE");
		contact.setMail("john@test.com");
		contact.setConfirmMail("john@test.com");

		Address address = new Address();
		address.setStreetAddress("1fst street");
		address.setZip("64203");
		address.setCountry("FRANCE");
		contact.setAddress(address);
		return contact;
	}
	
	private Signon createSignon() {
		Signon signon = new Signon();
		signon.setUserId("JOHN@GMAIL.COM");
		signon.setPassword("PASS");
		signon.getContacts().add(createContact());
		signon.setConfirmPassword("PASS");
		signon.setActive(Boolean.FALSE);
		return signon;
	}
}
