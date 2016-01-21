package okolica.view.apartments;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import okolica.view.ui.IUploadView;
import okolica.view.ui.TAbstractView;

public class TApartmentsView extends TAbstractView implements IUploadView{

	private static final long serialVersionUID = 1L;

	public TApartmentsView() {
		setSizeFull();
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		if(isTableEmpty()){
			clearView();
			addComponent(new TApartmentsEmptyView(this));
		}	
	}

	private boolean isTableEmpty(){
		return true;
	}

	@Override
	public void refreshView() {
		clearView();
		addComponent(new TApartmentsTable());
	}
	
	
	
}
