package okolica.view.settings;

import okolica.view.ui.TAbstractView;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class TSettingsView extends TAbstractView{

	public static final String NAME = "settings";
	
	private static final long serialVersionUID = 1L;
	
	private TextField login;
	private PasswordField password;
	private TextField email;
	private TextField phone;
	
	public TSettingsView(){
		FormLayout form = createForm();
		addComponent(form);
		setExpandRatio(form, 1.0f);
	}
	
	private FormLayout createForm(){
		final FormLayout form = new FormLayout();
		form.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		login = new TextField("login: ");
		login.setRequired(true);
		password = new PasswordField("hasło: ");
		password.setValue("admin");
		password.setRequired(true);
		email = new TextField("email: ");
		email.setRequired(true);
		phone = new TextField("telefon: ");
		Label section = new Label("Dane kontaktowe:");
        section.addStyleName(ValoTheme.LABEL_H4);
        section.addStyleName(ValoTheme.LABEL_COLORED);
        form.addComponents(login,password);
        form.addComponent(section);
		form.addComponents(email,phone);
		return form;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
