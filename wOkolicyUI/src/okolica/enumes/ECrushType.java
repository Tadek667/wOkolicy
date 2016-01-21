package okolica.enumes;

public enum ECrushType {

	WODA("Woda",(short)1),
	OGRZEWANIE("Ogrzewanie",(short)2),
	SWIATLO("Światło", (short)3),
	RTVAGD("RTV i AGD", (short)4),
	ZEWNETRZNE("Usterka zewnętrzna", (short)5),
	INNA("Inna usterka", (short)6);
	
	private String name;
	private Short type;
	
	private ECrushType(String name,Short type){
		this.name = name;
		this.type = type;
	}
	
	
	
}
