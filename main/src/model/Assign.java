package model;

/**
 * Created by Nik on 23-10-2015
 */
public class Assign extends Instruction {

	private final String name;
	private final String value;
	private final AssignType type;

	public Assign(Integer order, String name, String value, AssignType type) {
		super(order);
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}

	public AssignType getType() {
		return this.type;
	}
}
