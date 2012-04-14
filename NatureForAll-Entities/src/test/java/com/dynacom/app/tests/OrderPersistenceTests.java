package com.dynacom.app.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dynacom.app.domain.dao.GenericDAO;
import com.dynacom.app.domain.model.Address;
import com.dynacom.app.domain.model.Category;
import com.dynacom.app.domain.model.Contact;
import com.dynacom.app.domain.model.LineItem;
import com.dynacom.app.domain.model.PurchaseOrder;
import com.dynacom.app.domain.model.Product;
import com.dynacom.app.domain.model.Signon;
import com.dynacom.app.domain.services.IContactService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPersistenceTests {

	@Autowired
	GenericDAO<Contact, Long> contactDao;
	@Autowired
	GenericDAO<Address, Long> addressDao;
	@Autowired
	GenericDAO<LineItem, Long> lineItemDao;
	@Autowired
	GenericDAO<PurchaseOrder, Long> purchaseOrderDao;
	@Autowired
	GenericDAO<Product, Long> productDao;
	@Autowired
	GenericDAO<Category, Long> categoryDao;
	@Autowired
	GenericDAO<Signon, String> signonDao;
	
	@Test
	@Transactional
	public void testContact() throws Exception {
	
		Signon signon = new Signon();
		signon.setUserId("JOHN@GMAIL.COM");
		signon.setPassword("PASS");
		
		signonDao.persist(signon);
		
		Contact contact = createContact();
		
		contact.setSignon(signon);
		
		contactDao.persist(contact);
		
		
		
		contactDao.flush();
		contactDao.clear();
		
		Contact other = contactDao.find(contact.getId());
		
		other = contactDao.find(contact.getId());
		
		assertNotNull(other.getAddress());
		assertEquals(other, other.getAddress().getContact());
		assertNotNull(signon.getContacts());
	}
	
	@Test
	@Transactional
	public void testCategory()
	{
		Category food = new Category();
		food.setLabel("food");
		Category fish = new Category();
		fish.setLabel("fish");
		categoryDao.persist(fish);
		fish.setOwner(food);
		Product product = new Product();
		product.setLabel("foo");
		product.setPrice(15.95D);
		
		product.setCategory(fish);
		
		productDao.persist(product);
		categoryDao.persist(food);
		categoryDao.flush();
		categoryDao.clear();
		
		Category other = categoryDao.find(food.getId());
		
		assertNotNull(other.getOwned().iterator().next());
		assertNotNull(other.getOwned().iterator().next().getOwner());
		assertEquals(other,other.getOwned().iterator().next().getOwner());
		
		assertNotNull(other.getOwned().iterator().next().getProducts().iterator().next());
		
		Product otherPr = productDao.find(product.getId());
		
		assertNotNull(otherPr.getCategory());
		
	}

	private Contact createContact() {
		
		Contact contact = new Contact();
		contact.setCivility("MR");
		contact.setFirstName("John");
		contact.setLastName("DOE");
		contact.setMail("john@test.com");
		
		Address address = new Address();
		address.setStreetAddress("1fst street");
		address.setZip("64203");
		address.setCountry("FRANCE");
		contact.setAddress(address);
		return contact;
	}
	
	@Test
	@Transactional
	public void testPoWithProduct() throws Exception {
		Contact contact = createContact();
		contactDao.persist(contact);
		assertNotNull(contact.getId());
		PurchaseOrder order = new PurchaseOrder();
		order.setCustomer(contact);
		order.setDelivery(contact);
	
		LineItem li = new LineItem();
		
		li.setProduct("foo");
		li.setPrice(new Double(1.25));
		
		order.getLineItems().add(li);

		purchaseOrderDao.persist(order);
		
		Long id = order.getId();
		
		purchaseOrderDao.flush();
		purchaseOrderDao.clear();

		PurchaseOrder po = purchaseOrderDao.find(id);
		
		assertNotNull(po.getCustomer());
		assertNotNull(po.getDelivery());
		
		assertNotNull(po.getId());
		assertNotNull(po.getLineItems().iterator().next().getId());
		assertEquals(po.getLineItems().iterator().next().getPrice(),new Double(1.25));
		assertNotNull(po.getCustomer());
	}
	
	@Test
	@Transactional
	public void testCreateProduct() throws Exception {
		Product product = new Product();
		product.setLabel("foo");
		product.setPrice(new Double(1.25));
		productDao.persist(product);
		productDao.flush();
		assertNotNull(product.getId());
		product.setLabel("Product id#"+product.getId());
		productDao.persist(product);
		productDao.flush();
		assertEquals(product.getLabel(), "Product id#"+product.getId());
		assertEquals(product.getPrice(), new Double(1.25));
	}

	@Test
	@Transactional
	public void testSimplePo() throws Exception {
		PurchaseOrder order = new PurchaseOrder();
		LineItem li = new LineItem();
		order.getLineItems().add(li);
		purchaseOrderDao.persist(order);
		purchaseOrderDao.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		purchaseOrderDao.clear();
		PurchaseOrder other = purchaseOrderDao.find(order.getId());
		assertEquals(1, other.getLineItems().size());
	}

	@Test
	@Transactional
	public void testPoHql() throws Exception {
		PurchaseOrder order = new PurchaseOrder();
		LineItem item = new LineItem();
		item.setProduct("foo");
		order.getLineItems().add(item);
		purchaseOrderDao.persist(order);
		purchaseOrderDao.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		purchaseOrderDao.clear();
		PurchaseOrder other = (PurchaseOrder) purchaseOrderDao.getEntityManager()
				.createQuery(
						"select o from com.dynacom.app.domain.model.PurchaseOrder o join o.lineItems i where i.product=:product")
				.setParameter("product", "foo").getSingleResult();
		assertEquals(1, other.getLineItems().size());
	}

}
