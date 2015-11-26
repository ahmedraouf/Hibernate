package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class  ProductionsDAOImp implements ProductionsADO {
	private static SessionFactory factory;

	public ProductionsDAOImp() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public void create(Productions productions) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(productions);		
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
	public void update(Productions productions) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(productions);		
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
	public void delete(Productions productions) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(productions);
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
	public Productions get(Integer id) {
		Session session = factory.openSession();
		Productions productions = (Productions) session.createSQLQuery("SELECT * FROM productions where id = " + id).addEntity(Productions.class)
				.uniqueResult();
		session.close();
		//Productions productions;
		return productions;
	}

	@Override
	public Productions get(String proname) {
		Session session = factory.openSession();
		Productions productions = (Productions) session.createSQLQuery("SELECT * FROM Productions where fname = '" + proname + "'")
				.addEntity(Buyer.class).uniqueResult();
		session.close();
		return productions;
	}
	
	@Override
	public int numberOfProductions() {
		Session session = factory.openSession();
		int size = session.createSQLQuery("SELECT * FROM Productions").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Productions> getProductions() {
		Session session = factory.openSession();
		List<Productions> productions = (List<Productions>) session.createSQLQuery("SELECT * FROM productions").addEntity(Productions.class).list();
		session.close();
		return productions;
	}
}
