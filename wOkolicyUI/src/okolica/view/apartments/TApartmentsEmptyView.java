package okolica.view.apartments;

import okolica.app.TStyles;
import okolica.upload.TApartmentUploader;
import okolica.view.ui.IUploadView;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class TApartmentsEmptyView extends VerticalLayout{

	private static final long serialVersionUID = 1L;

	private final String TITLE_LABEL = "Brak mieszkań do wyświetlenia";
	private final String HELP_LABEL = "Zaiportuj listę mieszkań z pliku CSV";
	
	private Upload upload;
	private IUploadView view;
	
	public TApartmentsEmptyView(IUploadView view){
		setSizeFull();
		setSpacing(false);
		this.view = view;
		createView();
	}
	
	private void createView(){
		VerticalLayout content = new VerticalLayout();
		addComponent(content);
		setComponentAlignment(content, Alignment.MIDDLE_CENTER);
		Label title = createTitleLabel();
		content.addComponent(title);
		content.setComponentAlignment(title, Alignment.MIDDLE_CENTER);
		HorizontalLayout uploadComponent = createUploadButton();
		content.addComponent(uploadComponent);
		content.setComponentAlignment(uploadComponent, Alignment.MIDDLE_CENTER);
	}
	
	private Label createTitleLabel(){
		Label title = new Label(TITLE_LABEL);
		title.setWidth(null);
		title.addStyleName(ValoTheme.LABEL_BOLD);
		title.addStyleName(ValoTheme.LABEL_H1);
		title.addStyleName(TStyles.EMPTY_VIEW_LABEL);
		return title;
	}
	
	private HorizontalLayout createUploadButton(){
		final HorizontalLayout hl = new HorizontalLayout();
		final Label help = new Label(HELP_LABEL);
		help.setWidth(null);
		hl.setSpacing(true);
		upload = new Upload();
		TApartmentUploader uploader = new TApartmentUploader();
		uploader.setUploadView(view);
		upload.setReceiver(uploader);
		upload.addSucceededListener(uploader);
		upload.setImmediate(true);
		upload.addStyleName(TStyles.UPLOAD);
		upload.setButtonCaption("Zaimportuj");
		hl.addComponents(help,upload);
		hl.setComponentAlignment(help, Alignment.MIDDLE_LEFT);
		return hl;
	}
}
