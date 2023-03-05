package ibtech.training.command;

import java.lang.reflect.Method;
import java.util.List;

import ibtech.training.dao.CommandDao;
import ibtech.training.model.CommandModel;
import ibtech.training.model.CustomerModel;

public class CommandExecutor {
	
	public static Method executor(String commandName) throws Exception {
		try {
			CommandDao commandDao = new CommandDao();
			CommandModel command = commandDao.getCommand(commandName);
			
			Class<?> c = Class.forName("com.ibtech.training.operations." + command.getClassName());
			Object obj = c.getDeclaredConstructor().newInstance();
			Method method;
			
			method = c.getDeclaredMethod(command.getMethodName(), List.class, CustomerModel.class);
			
			method.invoke(obj);
			System.out.println("-> Executing works fine");
			return method;

		} catch (Exception e) {
			System.out.println("-> Executing failed");
			e.printStackTrace();
			throw e;
		}		
	}

}