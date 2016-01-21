package okolica.model;

import java.util.Date;

import okolica.enumes.ECrushPriority;
import okolica.enumes.ECrushType;

public class TAwaria extends TEntity{
	
	public static final String P_TYPE = "type";
	public static final String P_DATE = "addDate";
	public static final String P_PRIORITY = "priority";
	public static final String P_DESCRIBTION = "describtion";
	
	private ECrushType type;
	private Date addDate;
	private ECrushPriority priority;
	private String describtion;
	
	public ECrushType getType() {
		return type;
	}
	public void setType(ECrushType type) {
		this.type = type;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public ECrushPriority getPriority() {
		return priority;
	}
	public void setPriority(ECrushPriority priority) {
		this.priority = priority;
	}
	public String getDescribtion() {
		return describtion;
	}
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	
}
