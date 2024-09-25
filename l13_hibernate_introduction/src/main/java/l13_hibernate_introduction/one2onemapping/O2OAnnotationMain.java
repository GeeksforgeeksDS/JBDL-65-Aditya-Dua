package l13_hibernate_introduction.one2onemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class O2OAnnotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c= new Configuration();
		
		SessionFactory sf = c.configure("hibernate-annotation-o2o.cfg.xml").buildSessionFactory();
	
	
		Session s = sf.openSession();
		Transaction t= s.beginTransaction();
		
		Transactions tx = new Transactions();
		tx.setAmount(1000);
		
		Customer customer = new Customer(1, "Aditya", "a@a.com", tx);
		tx.setCustomer(customer);
		
		
		s.save(tx);
		//s.save(customer);
		
		tx = new Transactions();
		//customer = new Customer(0, "Aditya", "a@a.com");
		//tx.setCustomer(customer);
		tx.setAmount(100);
		
		s.save(tx);
		//s.save(customer);
		
		tx = new Transactions();
		tx.setAmount(500);
		
		customer = new Customer(2, "Aditya", "a@a.com", tx);
		tx.setCustomer(customer);
		
		s.save(tx);
		customer.setId(tx.getId());
		s.save(customer);
		
		
		s.flush();
		t.commit();
		s.close();
		sf.close();
		
	}

}
