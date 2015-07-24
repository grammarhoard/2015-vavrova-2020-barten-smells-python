package ast.expression.comprehension;

import ast.expression.ExprNoCond;
import org.antlr.v4.runtime.misc.NotNull;
import ast.Visitor;

/**
 * Created by Nik on 17-06-2015
 */
public class CompIf extends CompIter {

	private final ExprNoCond expression;

	public CompIf(@NotNull Integer locInfo, CompIter nextLink, @NotNull ExprNoCond expression) {
		super(locInfo, nextLink);
		this.expression = expression;
	}

	public ExprNoCond getExpression() {
		return this.expression;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
