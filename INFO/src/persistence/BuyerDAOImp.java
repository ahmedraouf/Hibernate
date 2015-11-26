package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class  BuyerDAOImp implements BuyerDAO {
	private static SessionFactory factory;

	public BuyerDAOImp() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public void create(Buyer buyer) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(buyer);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Buyer buyer) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(buyer);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	@Override
	public void delete(Buyer buyer) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(buyer);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}	

	@Override
	public Buyer get(Integer id) {
		Session session = factory.openSession();
		Buyer buyer = (Buyer) session.createSQLQuery("SELECT * FROM Buyers where id = " + id).addEntity(Buyer.class)
				.uniqueResult();
		session.close();
		return buyer;
	}

	@Override
	public Buyer get(String fname) {
		Session session = factory.openSession();
		Buyer buyer = (Buyer) session.createSQLQuery("SELECT * FROM Buyers where fname = '" + fname + "'")
				.addEntity(Buyer.class).uniqueResult();
		session.close();
		return buyer;
	}
	
	@Override
	public int numberOfUsers() {
		Session session = factory.openSession();
		int size = session.createSQLQuery("SELECT * FROM Buyers").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Buyer> getUsers() {
		Session session = factory.openSession();
		List<Buyer> users = (List<Buyer>) session.createSQLQuery("SELECT * FROM Buyers").addEntity(Buyer.class).list();
		session.close();
		return users;
	}
}
