package persistence;

import java.util.List;

public interface BuyerDAO {
	public void create(Buyer buyer);

	public Buyer get(Integer id);

	public Buyer get(String fname);
	
	public void update(Buyer buyer);

	public void delete(Buyer buyer);

	public int numberOfUsers();

	public List<Buyer> getUsers();
}
