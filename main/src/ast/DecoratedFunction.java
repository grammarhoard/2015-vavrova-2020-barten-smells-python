package ast;

import ast.statement.Statement;

import java.util.List;

/**
 * Created by Nik on 15-06-2015
 */
public class DecoratedFunction extends Function {

	private final List<Decorator> decorators;

	public DecoratedFunction(LocInfo locInfo, List<Decorator> decorators, String name, List<Statement> body) {
		super(locInfo, name, body);
		this.decorators = decorators;
	}

	public List<Decorator> getDecorators() {
		return decorators;
	}
}
