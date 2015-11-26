package persistence;

import java.util.List;

public interface ProductionsADO {
	public void create(Productions productions);

	public Productions get(Integer id);

	public Productions get(String proname);
	
	public void update(Productions productions);

	public void delete(Productions productions);

	public int numberOfProductions();

	public List<Productions> getProductions();
}
