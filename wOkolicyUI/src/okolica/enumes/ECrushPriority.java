package okolica.enumes;

public enum ECrushPriority {

	LOW("Niski",(short)1,"Twoja usterka zostanie zlikwidowana w terminie do 30 dni od zgłoszenia"),
	MEDIUM("Średni",(short)2,"Twoja usterka zostanie zlikwidowana w terminie do 7 dni od zgłoszenia"),
	HIGH("Wysoki", (short)3,"Twoja usterka zostanie zlikwidowana do 48 godzin od zgłoszenia");
	
	private String name;
	private Short type;
	private String desc;
	
	private ECrushPriority(String name,Short type, String desc){
		this.name = name;
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return name;
	}
}
