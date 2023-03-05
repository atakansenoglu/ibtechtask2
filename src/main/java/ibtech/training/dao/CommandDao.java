package ibtech.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ibtech.training.model.CommandModel;
import ibtech.training.util.HibernateUtil;

public class CommandDao {

    public CommandModel getCommand(String commandName) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            
            List<CommandModel> commands = entityManager.createQuery("FROM CommandModel", CommandModel.class).getResultList();
            
            transaction.commit();
            
            for (CommandModel commandItem : commands) {
                if (commandItem.getCommandName().equals(commandName)) {
                    return commandItem;
                }
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
