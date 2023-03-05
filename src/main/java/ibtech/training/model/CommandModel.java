package ibtech.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commands")
public class CommandModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "commandName")
	private String commandName;

	@Column(name = "clas_name")
	private String className;

	@Column(name = "methodName")
	private String methodName;

	public CommandModel() {
		super();
	}

	public CommandModel(String commandName, String className, String methodName) {
		super();
		this.commandName = commandName;
		this.className = className;
		this.methodName = methodName;
	}

	public long getId() {
		return id;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommand_name(String commandName) {
		this.commandName = commandName;
	}

	public String getClassName() {
		return className;
	}

	public void setClass_name(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethod_name(String methodName) {
		this.methodName = methodName;
	}

	@Override
	public String toString() {
		return "CommandModel [id=" + id + ", commandName=" + commandName + ", className=" + className
				+ ", methodName=" + methodName + "]";
	}

}