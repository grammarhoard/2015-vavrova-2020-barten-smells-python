package ast.expression.atom;

import ast.LocInfo;
import thesis.Py3TreeVisitor;

/**
 * Created by Nik on 12-06-2015
 */
public class Str extends Atom {

	private final String value;

	public Str(LocInfo locInfo, String value) {
		super(locInfo);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public <T> T accept(Py3TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
