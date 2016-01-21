package okolica.view.contacts;

import okolica.app.THelper;
import okolica.app.TStyles;
import okolica.model.TKontakt;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public class TContactForm extends VerticalLayout implements IContactForm{

	private static final long serialVersionUID = 1L;

	private Button add;
	private Button cancel;
	
	private FormLayout form;
	private TextField name;
	private TextField surname;
	private TextField email;
	private TextField phone;
	private TextArea notes;
	private IContactSaver saveListener;
	
	public TContactForm(){
		setMargin(new MarginInfo(false, false, false, true));
		setSizeFull();
		form = new FormLayout();
		form.setSizeFull();
		form.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		addComponent(createButtons());
		createContent();
		setVisible(false);
	}

	private HorizontalLayout createButtons(){
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.setSpacing(true);
		createAddButton();
		createCancelButton();
		buttons.addComponents(add,cancel);
		return buttons;
	}
	
	public void setSaveHandler(IContactSaver handler){
		saveListener = handler;
	}
	
	private TextField createField(boolean required, String prompt){
		TextField field = new TextField();
		field.setRequired(required);
		field.setInputPrompt(prompt);
		return field;
	}
	
	private void createAddButton(){
		add = new Button("Zapisz");
		add.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		add.addStyleName(TStyles.CONTACTS_ADD_BUTTON);
		add.setIcon(FontAwesome.SAVE);
		add.addStyleName(ValoTheme.BUTTON_SMALL);
		add.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				TKontakt contact = new TKontakt();
				contact.setName(name.getValue());
				contact.setSurname(surname.getValue());
				contact.setEmail(email.getValue());
				contact.setPhone(phone.getValue());
				saveListener.saveBean(contact);
				setVisible(false);
			}
		});
	}
	
	private void createCancelButton(){
		cancel = new Button("Anuluj");
		cancel.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		cancel.addStyleName(TStyles.BUTTON_CANCEL);
		cancel.addStyleName(ValoTheme.BUTTON_SMALL);
		cancel.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				hideAndClear();
			}
		});
	}
	
	private void createContent(){
		name = createField(true, "");
		name.setWidth("100%");
		name.setCaption("Imię: ");
		surname = createField(false, "");
		surname.setWidth("100%");
		surname.setCaption("Nazwisko: ");
		notes = new TextArea();
		notes.setCaption("Notatki: ");
		notes.setWidth("100%");
		email = createField(false, "");
		email.setCaption("E-mail: ");
		email.setWidth("100%");
		phone = createField(false, "");
		phone.setCaption("Telefon: ");
		phone.setWidth("100%");
		form.addComponents(name,surname,phone,email,notes);
		addComponent(form);
		setExpandRatio(form, 1.0f);
	}
	
	@Override
	public void showNewContactForm() {
		clearFields();
		setVisible(true);
		name.focus();
	}

	@Override
	public void showInEditMode(TKontakt contact) {
		setVisible(true);
		name.setValue(contact.getName());
		surname.setValue(contact.getSurname());
		email.setValue(contact.getEmail());
		phone.setValue(contact.getPhone());
		name.focus();
	}
	
	private void clearFields(){
		name.clear();
		surname.clear();
		email.clear();
		phone.clear();
		notes.clear();
	}

	@Override
	public void hideAndClear() {
		clearFields();
		setVisible(false);
	}
	
}
