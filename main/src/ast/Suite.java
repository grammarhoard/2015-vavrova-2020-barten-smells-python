package ast;

import java.util.List;

import ast.statement.Statement;
import ast.statement.flow.Return;

/**
 * Created by Nik on 25-06-2015
 */
public class Suite extends AstNode {

	private final List<Statement> statements;

	public Suite( Integer locInfo,  List<Statement> statements) {
		super(locInfo);
		this.statements = statements;
	}

	public List<Statement> getStatements() {
		return this.statements;
	}

	public Boolean isAccessorBody() {
		if (this.statements.size() != 1) {
			return false;
		}
		if (this.statements.get(0) instanceof Return){
			Return r = (Return) this.statements.get(0);
			return r.hasSingleReturnValue();
		}
		return false;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
