package ast;

import ast.expression.Expr;

/**
 * Created by Nik on 15-06-2015
 */
public class Parameter extends Py3Node {

	private final String name;
	private final Expr defValue;
	private final Expr type;

	public Parameter(LocInfo locInfo, String name) {
		this(locInfo, name, null, null);
	}

	public Parameter(LocInfo locInfo, String name, Expr defValue) {
		this(locInfo, name, defValue, null);
	}

	public Parameter(LocInfo locInfo, String name, Expr defValue, Expr type) {
		super(locInfo);
		this.name = name;
		this.defValue = defValue;
		this.type = type;
	}

	public Boolean isTyped() {
		return this.type != null;
	}

	public Boolean hasDefValue() {
		return this.defValue != null;
	}

	public String getName() {
		return name;
	}

	public Expr getType() {
		return type;
	}

	public Expr getDefValue() {
		return defValue;
	}
}
