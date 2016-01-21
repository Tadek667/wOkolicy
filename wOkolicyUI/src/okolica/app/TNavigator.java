package okolica.app;

import okolica.enumes.EViewType;
import okolica.view.login.TLoginView;
import okolica.view.main.TMainView;
import okolica.view.settings.TSettingsView;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class TNavigator extends Navigator{

	private static final long serialVersionUID = 1L;

	public TNavigator(ComponentContainer content){
		super(UI.getCurrent(), content);
		registerViews();
		navigateTo(EViewType.EVENT.getViewName());
	}
	
	public TNavigator(SingleComponentContainer container) {
		super(UI.getCurrent(), container);
		registerViews();
	}

	private void registerViews(){
		for(EViewType view : EViewType.values()){
			if(view == EViewType.EVENT) setErrorView(view.getView());
			addView(view.getViewName(), view.getView());
		}
		//tutaj dodajemy kolejne View
		addView(TSettingsView.NAME, TSettingsView.class);
		addView(TLoginView.VIEW_NAME, TLoginView.class);
		addView(TMainView.VIEW_NAME, TMainView.class);
	}
	
	
}
