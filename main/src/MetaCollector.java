import org.python.antlr.PythonTree;
import org.python.antlr.ast.*;

import java.util.HashSet;

/**
 * Created by Nik on 08-05-2015
 */
public class MetaCollector {

	private final CollectorVisitor visitor;

	public MetaCollector(PythonTree tree) {
		this.visitor = new CollectorVisitor();
		try {
			tree.accept(visitor);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public java.util.Set<String> getClasses() {
		return this.visitor.getClasses();
	}

	public DependencyGraph getDependencyGraph() {
		return this.visitor.getDependencyGraph();
	}


	private class CollectorVisitor implements VisitorIF {

		private final java.util.Set<String> pyClasses;
		private String currentClass;
		private final DependencyGraph dependencyGraph;

		public CollectorVisitor() {
			this.pyClasses = new HashSet<>();
			this.dependencyGraph = new DependencyGraph();
		}

		public java.util.Set<String> getClasses() {
			return this.pyClasses;
		}

		public DependencyGraph getDependencyGraph() {
			return this.dependencyGraph;
		}

		@Override
		public Void visitModule(Module node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitInteractive(Interactive node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitExpression(Expression node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitSuite(Suite node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitFunctionDef(FunctionDef node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitClassDef(ClassDef node) throws Exception {
			this.currentClass = node.getInternalName();
			this.pyClasses.add(this.currentClass);

			this.visitChildren(node);

			this.currentClass = null;
			return null;
		}

		@Override
		public Void visitReturn(Return node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitDelete(Delete node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitAssign(Assign node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitAugAssign(AugAssign node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitPrint(Print node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitFor(For node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitWhile(While node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitIf(If node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitWith(With node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitRaise(Raise node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitTryExcept(TryExcept node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitTryFinally(TryFinally node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitAssert(Assert node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitImport(Import node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitImportFrom(ImportFrom node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitExec(Exec node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitGlobal(Global node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitExpr(Expr node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitPass(Pass node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitBreak(Break node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitContinue(Continue node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitBoolOp(BoolOp node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitBinOp(BinOp node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitUnaryOp(UnaryOp node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitLambda(Lambda node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitIfExp(IfExp node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitDict(Dict node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitSet(Set node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitListComp(ListComp node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitSetComp(SetComp node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitDictComp(DictComp node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitGeneratorExp(GeneratorExp node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitYield(Yield node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitCompare(Compare node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitCall(Call node) throws Exception {
			if (this.amIInClass()) {
				this.dependencyGraph.addDependency(this.currentClass, node.getText());
			}
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitRepr(Repr node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitNum(Num node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitStr(Str node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitAttribute(Attribute node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitSubscript(Subscript node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitName(Name node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitList(List node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitTuple(Tuple node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitEllipsis(Ellipsis node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitSlice(Slice node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitExtSlice(ExtSlice node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitIndex(Index node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		@Override
		public Void visitExceptHandler(ExceptHandler node) throws Exception {
			this.visitChildren(node);
			return null;
		}

		private void visitChildren(PythonTree node) throws Exception {
			if (node.getChildCount() > 0) {
				for (PythonTree t : node.getChildren()) {
					t.accept(this);
				}
			}
		}

		private boolean amIInClass() {
			return this.currentClass != null;
		}
	}
}