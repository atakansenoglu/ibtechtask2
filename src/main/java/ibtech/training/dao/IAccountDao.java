package ibtech.training.dao;

import java.util.List;

import ibtech.training.model.AccountModel;

public interface IAccountDao {

	void save(AccountModel accounts);
	void update(AccountModel accounts);
	
	AccountModel getById(Long id);	
	List<AccountModel> getAll();
	
	void delete(AccountModel account);
}