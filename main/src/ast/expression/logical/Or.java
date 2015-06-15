package ast.expression.logical;

import ast.LocInfo;
import ast.expression.Expr;

import java.util.List;

/**
 * Created by Nik on 08-06-2015
 */
public class Or extends Binary {

	public Or(LocInfo locInfo, List<Expr> operands) {
		super(locInfo, operands);
	}
}
