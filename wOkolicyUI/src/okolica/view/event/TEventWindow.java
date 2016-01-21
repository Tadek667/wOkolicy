package okolica.view.event;

import okolica.app.TStyles;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class TEventWindow extends Window{

	private static final long serialVersionUID = 1L;
	private TextField eventName;
	private DateField eventDate;
	private TextArea eventDesc;
	private Button cancel;
	private Button save;
	
	private final int WIDTH = 600;
	private final int HEIGHT = 400;
	private final String NEW_EVENT_CAPTION = "NOWE WYDARZENIE";
	
	public TEventWindow(){
		setModal(true);
		setClosable(false);
		setResizable(false);
		setCaption(NEW_EVENT_CAPTION);
		createContent();
		setWidth(WIDTH, Unit.PIXELS);
		setHeight(HEIGHT, Unit.PIXELS);
		addStyleName(TStyles.WINDOW);
	}
	
	
	private void initFields(){
		eventName = new TextField("Nazwa wydarzenia:");
		eventName.setWidth("100%");
		eventName.setRequired(true);
		eventDate = new DateField("Termin wydarzenia:");
		eventDate.setWidth("100%");
		eventDate.setRequired(true);
		eventDesc = new TextArea("Opis:");
		eventDesc.setWidth("100%");
		eventDesc.setInputPrompt("Poinformuj mieszkańców w kilku słowach o tym wydarzeniu...");
		save = new Button("Zapisz");
		save.addStyleName(ValoTheme.BUTTON_SMALL);
		save.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		save.addStyleName(TStyles.WINDOW_BUTTON_OK);
		cancel = new Button("Anuluj");
		cancel.addStyleName(ValoTheme.BUTTON_SMALL);
		cancel.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		cancel.addStyleName(TStyles.WINDOW_BUTTON_CANCEL);
	}
	
	private void createContent(){
		initFields();
		final FormLayout form = new FormLayout();
		form.setMargin(true);
		form.setSpacing(true);
		form.setSizeFull();
		form.addComponents(eventName,eventDate,eventDesc);
		final VerticalLayout content = new VerticalLayout();
		content.setSizeFull();
		content.setSpacing(true);
		content.setMargin(false);
		content.addComponent(form);
		final HorizontalLayout buttons = new HorizontalLayout();
		buttons.addStyleName(TStyles.WINDOW_BUTTONS);
		buttons.setWidth("100%");
		buttons.setMargin(true);
		buttons.setSpacing(true);
		buttons.setDefaultComponentAlignment(Alignment.BOTTOM_RIGHT);
		final HorizontalLayout hl = new HorizontalLayout();
		hl.setSizeUndefined();
		hl.setSpacing(true);
		hl.addComponent(cancel);
		hl.addComponent(save);
		buttons.addComponent(hl);
		content.addComponent(buttons);
		content.setExpandRatio(form, 1.0f);
		setContent(content);
	}
}
