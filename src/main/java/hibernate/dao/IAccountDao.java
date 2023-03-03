package hibernate.dao;

import java.util.List;

import hibernate.model.Account;

public interface IAccountDao {

	void save(Account accounts);
	void update(Account accounts);
	
	Account getById(Long id);	
	List<Account> getAll();
	
	void delete(Account account);
}
