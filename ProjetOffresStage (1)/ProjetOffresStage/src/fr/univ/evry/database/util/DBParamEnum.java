package fr.univ.evry.database.util;

public enum DBParamEnum {

	HOST("localhost"),
	DATABASE("offre_stage"),
	USER("root"),
	PASS("");
	
	private String value;
	
	DBParamEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
