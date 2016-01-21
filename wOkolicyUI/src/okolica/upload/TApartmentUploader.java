package okolica.upload;

import com.vaadin.ui.Upload.SucceededEvent;

public class TApartmentUploader extends TAbstractUploader{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void uploadSucceeded(SucceededEvent event) {
		super.uploadSucceeded(event);
		view.refreshView();
	}
	
}
