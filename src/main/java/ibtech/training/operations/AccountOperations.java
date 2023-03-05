package ibtech.training.operations;

import java.util.List;

import ibtech.training.model.AccountModel;

public class AccountOperations {

	public void add(List<AccountModel> accountList, AccountModel account) {
		
		accountList.add(account);
	}
	
	public void update(List<AccountModel> accountList, AccountModel account, int index) {
		
		accountList.set(index, account);
	}
	
	public void delete(List<AccountModel> accountList, int index) {
		
		accountList.remove(index);
	}
}