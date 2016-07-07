package me.staartvin.statz.hooks;

public enum Dependency {

	VOTIFIER("Votifier"), JOBS("Jobs"), MCMMO("mcMMO");
	
	Dependency(String internalName) {
		this.internalName = internalName;
	}

	private String internalName;
	
	public String getInternalString() {
		return this.internalName;
	}
}