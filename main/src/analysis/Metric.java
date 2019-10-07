package analysis;

/**
 * All data written to disk must be defined in this enum. 
 * Created by Nik on 04-11-2015
 */
public enum Metric {
	CLASS_LOC,
	CLASS_SUPERCLASSES,
	CLASS_METHODS,
	CLASS_METHODS_AND_VARS,
	CLASS_ACCESSORS,
	CLASS_LCOM,
	CLASS_METHODS_NO_PARAMS,
	CLASS_PUBLIC_FIELDS,
	CLASS_PRIVATE_FIELDS,
	CLASS_CC,
	CLASS_WMC,
	CLASS_AMW,
	CLASS_AVG_CC,
	SUBROUTINE_LOC,
	SUBROUTINE_PARAMS,
	SUBROUTINE_AID,
	SUBROUTINE_CC, 
	SUBROUTINE_AVG_CC,
	PROJECT_LOC, 
	PROJECT_CC, 
	PROJECT_GLOBAL_CC,
	PROJECT_AVG_AMW, 
	PROJECT_AVG_LOC, 
}
