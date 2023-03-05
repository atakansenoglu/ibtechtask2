package ibtech.training.dao;

import ibtech.training.model.CommandModel;

public interface ICommandDao {

	CommandModel get(String commandName);
}
