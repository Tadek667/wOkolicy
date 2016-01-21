package okolica.view.windows;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public class TDeleteConfirmationWindow extends Window{

	
	private static final long serialVersionUID = 1L;
	public final int WIDTH = 350;
	public final int HEIGHT = 150;
	
	private Button delete;
	private Button cancel;
	private String caption;
	private String message;
	private IDeleteAction handler;
	
	public TDeleteConfirmationWindow(IDeleteAction action, String caption, String msg){
		this.caption = caption;
		this.message = msg;
		this.handler = action;
		createWindow();
		setModal(true);
		setResizable(false);
		setIcon(FontAwesome.TRASH_O);
	}
	
	private void createWindow(){
		setCaption(caption);
		setWidth(WIDTH, Unit.PIXELS);
		setHeight(HEIGHT, Unit.PIXELS);
		setContent(createContent());
	}
	
	private Component createContent(){
		final VerticalLayout content = new VerticalLayout();
		content.setMargin(true);
		content.setSizeFull();
		final Label messageLabel = new Label(message);
		content.addComponent(messageLabel);
		content.setSpacing(true);
		final HorizontalLayout footer = new HorizontalLayout();
		footer.setSpacing(false);
		footer.setWidth("100%");
		footer.setMargin(false);
		footer.setHeightUndefined();
		footer.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
		delete = new Button("Usuń");
		delete.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		delete.addStyleName(ValoTheme.BUTTON_SMALL);
		cancel = new Button("Anuluj");
		cancel.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		cancel.addStyleName(ValoTheme.BUTTON_SMALL);
		delete.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				handler.handleDelete();
			}
		});
		cancel.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().removeWindow(TDeleteConfirmationWindow.this);
			}
		});
		footer.addComponent(cancel);
		footer.addComponent(delete);
		content.addComponent(footer);
		content.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
		return content;
	}
	
	public interface IDeleteAction {
		void handleDelete();
	}
	
}
