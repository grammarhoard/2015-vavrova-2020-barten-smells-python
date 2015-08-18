package ast.statement.flow;

import ast.expression.Expr;
import ast.statement.Statement;
import org.antlr.v4.runtime.misc.NotNull;
import ast.Visitor;

/**
 * Created by Nik on 25-05-2015
 */
public class Raise extends Statement {

	private final Expr type;
	private final Expr source;

	public Raise(@NotNull Integer locInfo, Expr type, Expr source) {
		super(locInfo);
		this.type = type;
		this.source = source;
	}

	public Expr getType() {
		return this.type;
	}

	public Expr getSource() {
		return this.source;
	}

	public Boolean hasType() {
		return this.type != null;
	}

	public Boolean hasSource() {
		return this.source != null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}