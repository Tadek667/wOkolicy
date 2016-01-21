package okolica.app;

import okolica.db.TDatabaseManager;

import com.vaadin.ui.UI;

public class THelper {

	public final static int DEFAULT_WIDTH = 350;
	
	public static final String DATABASE = "db";
	
	public static void navigateTo(String viewName){
		UI.getCurrent().getNavigator().navigateTo(viewName);
	}
	
	public static TDatabaseManager getDatabase(){
		return (TDatabaseManager) UI.getCurrent().getSession().getAttribute(DATABASE);
	}
	
}
