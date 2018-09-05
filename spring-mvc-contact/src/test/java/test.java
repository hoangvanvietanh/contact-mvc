
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.green.spring.entity.Contact;

public class test {
	@Autowired
    private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public static void main(String[] args) {
		test t = new test();
		Session session = t.getSessionFactory().openSession();
		//Session session = sessionFactory.openSession();
		TypedQuery<Contact> query = session.createQuery("FORM Contact");
		List<Contact> contact = query.getResultList();
		for(Contact c: contact)
		{
			System.out.println(c.getName_contact()+c.getAddress_contact());
		}
		

	}

}
