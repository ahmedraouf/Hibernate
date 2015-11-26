package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.Buyer;
import persistence.BuyerDAO;
import persistence.BuyerDAOImp;

public class PersistenceTest {

	static BuyerDAO userDao;
	static List<Buyer> Buyers;

	@BeforeClass
	static public void init() {
		userDao = new BuyerDAOImp();
		Buyers = new ArrayList<Buyer>();
		initDB();
	}

	static public void initDB() {
		for (int i = 0; i < 100; i++) {
			Buyer u = new Buyer(i, "fname" + i,"lname" + i ,"city" + i, i ,i);
					Buyers.add(u);
			userDao.create(u);
		}
	}

	@Test
	public void testGetUserByUsername() {
		assertEquals(new Integer(11), userDao.get("fname10").getId());
	}

	@Test
	public void testGetUserByUnusedUsername() {
		assertNull(userDao.get("fname101"));
	}

	@Test
	public void testGetUserById() {
		assertEquals("fname9", userDao.get(10).getFName());
	}

	@Test
	public void testNumberOfUsers() {
		assertEquals(100, userDao.numberOfUsers());
	}

	@Test
	public void testNumberOfUsersAfterDeletion() {
		userDao.delete(Buyers.get(0));
		assertEquals(99, userDao.numberOfUsers());
	}
}
