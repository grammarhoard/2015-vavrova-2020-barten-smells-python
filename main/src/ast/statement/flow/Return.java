package ast.statement.flow;

import ast.LocInfo;
import ast.expression.Expr;

import java.util.List;

/**
 * Created by Nik on 15-06-2015
 */
public class Return extends Flow {

	private final List<Expr> values;

	public Return(LocInfo locInfo, List<Expr> values) {
		super(locInfo);
		this.values = values;
	}

	public List<Expr> getValues() {
		return values;
	}
}
