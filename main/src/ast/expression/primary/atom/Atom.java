package ast.expression.primary.atom;

import ast.expression.ExprNoCond;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by Nik on 10-06-2015
 */
public abstract class Atom extends ExprNoCond {

	public Atom(@NotNull Integer locInfo) {
		super(locInfo);
	}
}
