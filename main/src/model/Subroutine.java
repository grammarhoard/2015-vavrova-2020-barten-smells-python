package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Nik on 11-07-2015
 */
public class Subroutine extends ContentContainer {
	private final Integer loc;
	private final ContentContainer parent;
	private final SubroutineType subroutineType;
	private final Boolean isAccessor;
	private final List<String> params;

	public Subroutine(String name, ContentContainer parent, Integer loc, SubroutineType subroutineType, List<String> params, Boolean isAccessor) {
		super(name);
		this.loc = loc;
		this.parent = parent;
		this.subroutineType = subroutineType;
		this.params = params;
		this.isAccessor = isAccessor;
	}

	public Integer getLoc() {
		return this.loc;
	}

	public Integer getAid() {
		//Access of Import Data: Number of data members accessed in a method directly or via accessor-methods, from which the definition-class of the method is not derived.
		//TODO: add accessors
		return this.getReferencedOutsideVariables().size();
	}

	public Integer getAld() {
		//Access of Local Data: Number of the data members accessed in the given method, which are local to the class where the method is defined.
		//TODO: add accessors?
		return this.getReferencedInsideVariables().size();
	}

	public Integer paramCount() {
		return this.params.size();
	}

	public Set<Variable> getReferencedInsideVariables() {
		Set<Variable> referencedVars = new HashSet<>();
		for (Set<Variable> vars : this.referencedVars.values()) {
			referencedVars.addAll(vars.stream()
					.filter(v -> v.definedInParentOf(this))
					.collect(Collectors.toSet()));
		}
		return referencedVars;
	}

	public Set<Variable> getReferencedOutsideVariables() {
		Set<Variable> referencedVars = new HashSet<>();
		for (Set<Variable> vars : this.referencedVars.values()) {
			referencedVars.addAll(vars.stream()
					.filter(v -> !v.definedInParentOf(this))
					.collect(Collectors.toSet()));
		}
		return referencedVars;
	}

	public Boolean isAccessor() {
		return this.isAccessor;
	}

	public SubroutineType getSubroutineType() {
		return this.subroutineType;
	}

	public Boolean hasVariableIntersection(Subroutine m) {
		return !Collections.disjoint(this.getReferencedInsideVariables(), m.getReferencedInsideVariables());
	}

	public Boolean isPrivate() {
		return this.name.startsWith("__") && !this.name.endsWith("__");
	}

	@Override
	public boolean isInParentLine(ContentContainer container) {
		if (this.equals(container)) {
			return true;
		}
		return this.parent.isInParentLine(container);
	}
}
