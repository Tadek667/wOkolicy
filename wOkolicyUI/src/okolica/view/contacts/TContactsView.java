package okolica.view.contacts;

import okolica.view.ui.TAbstractView;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;

public class TContactsView extends TAbstractView{

	
	private static final long serialVersionUID = 1L;
	private HorizontalSplitPanel content;
	private TContactForm form;
	
	private TContactTablePanel table;
	
	public TContactsView(){
		form = new TContactForm();
		table = new TContactTablePanel(form);
		form.setSaveHandler(table);
		createContent();
	}
	
	private void createContent(){
		content = new HorizontalSplitPanel();
		content.setSplitPosition(60f);
		content.setSizeFull();
		addComponent(content);
		content.setFirstComponent(table);
		content.setSecondComponent(form);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
