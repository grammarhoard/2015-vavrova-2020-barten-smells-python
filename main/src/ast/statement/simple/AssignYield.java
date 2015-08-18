package ast.statement.simple;

import ast.statement.flow.Yield;
import org.antlr.v4.runtime.misc.NotNull;
import ast.Visitor;

/**
 * Created by Nik on 24-06-2015
 */
public class AssignYield extends Assign {

	public final Yield yield;

	public AssignYield(@NotNull Integer locInfo, @NotNull String operator, @NotNull ExprList targets, @NotNull Yield yield) {
		super(locInfo, operator, targets);
		this.yield = yield;
	}

	public Yield getYield() {
		return this.yield;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}