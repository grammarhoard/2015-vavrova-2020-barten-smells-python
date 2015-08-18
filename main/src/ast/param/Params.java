package ast.param;

import ast.AstNode;
import org.antlr.v4.runtime.misc.NotNull;
import ast.Visitor;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nik on 23-06-2015
 */
public class Params extends AstNode {

	private final List<SimpleParam> positionalArgs;
	private final List<SimpleParam> args;
	private final List<SimpleParam> kwargs;

	public Params(@NotNull Integer locInfo) {
		this(locInfo, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
	}

	public Params(@NotNull Integer locInfo, @NotNull List<SimpleParam> positionalArgs, @NotNull List<SimpleParam> args, @NotNull List<SimpleParam> kwargs) {
		super(locInfo);
		this.positionalArgs = positionalArgs;
		this.args = args;
		this.kwargs = kwargs;
	}

	public List<SimpleParam> getPositionalArgs() {
		return this.positionalArgs;
	}

	public List<SimpleParam> getArgs() {
		return this.args;
	}

	public List<SimpleParam> getKwargs() {
		return this.kwargs;
	}

	public Boolean isEmptyExceptForSelf() {
		if (this.positionalArgs.size() == 1 && this.args.size() == 0 && this.kwargs.size() == 0) {
			SimpleParam p = this.positionalArgs.get(0);
			return p.isSelf();
		}
		return false;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}