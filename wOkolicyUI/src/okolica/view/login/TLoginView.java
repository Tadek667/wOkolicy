package okolica.view.login;

import java.sql.SQLException;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

import okolica.app.THelper;
import okolica.app.TStyles;
import okolica.view.main.TMainView;
import okolica.view.ui.TAbstractView;

public class TLoginView extends TAbstractView{

	public static final String VIEW_NAME = "login";
	
	private static final long serialVersionUID = 1L;
	private TextField userName;
	private PasswordField password;
	private Button loginButton;
	private Label errosMsg;
	private Button forgotPass;
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 500;
	private final int FIELD_WIDTH = 350;
	
	public TLoginView(){
		super();
		addStyleName(TStyles.LOGIN_BACKGROUND);
		VerticalLayout window = createLoginWindow();
		addComponent(window);
		setComponentAlignment(window, Alignment.MIDDLE_CENTER);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void initFields(){
		userName = new TextField();
		userName.setInputPrompt("Nazwa użytkownika");
		userName.setIcon(FontAwesome.USER);
		userName.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		userName.addStyleName(ValoTheme.TEXTFIELD_LARGE);
		//userName.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		userName.addStyleName(TStyles.LOGIN_FIELD);
		userName.setWidth("100%");
		password = new PasswordField();
		password.setWidth("100%");
		password.addStyleName(TStyles.LOGIN_FIELD);
		password.setIcon(FontAwesome.LOCK);
		//password.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		password.addStyleName(ValoTheme.TEXTAREA_LARGE);
		password.setInputPrompt("Hasło");
		errosMsg = new Label("Podany login i hasło nie zgadzają się ");
		errosMsg.addStyleName(ValoTheme.LABEL_COLORED);
		errosMsg.addStyleName(ValoTheme.LABEL_TINY);
		errosMsg.setVisible(false);
		forgotPass = new Button("Zapomniałeś hasła?");
		forgotPass.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		forgotPass.addStyleName(ValoTheme.BUTTON_TINY);
		forgotPass.addStyleName(TStyles.LOGIN_FORGOT_PASS);
		loginButton = new Button("Zaloguj");
		loginButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		loginButton.addStyleName(ValoTheme.BUTTON_LARGE);
		loginButton.setWidth(FIELD_WIDTH, Unit.PIXELS);
		loginButton.addStyleName(TStyles.LOGIN_BUTTON);
		loginButton.setWidth("100%");
		loginButton.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				THelper.getDatabase().testConnection();
				boolean isLoginSuccessful = THelper.getDatabase().getService().isLoginSuccessful(userName.getValue(), password.getValue());
				if(isLoginSuccessful){
					UI.getCurrent().setContent(new TMainView());
					clearErrorMsg();
				}else{
					displayErrorMsg();
					userName.focus();
					userName.clear();
					password.clear();
				}
			}
		});
	}
	
	private void displayErrorMsg(){
		errosMsg.setVisible(true);
	}
	
	private void clearErrorMsg(){
		errosMsg.setVisible(false);
	}
	
	private VerticalLayout createLoginWindow(){
		initFields();
		final VerticalLayout content = new VerticalLayout();
		content.setMargin(true);
		final HorizontalLayout top = new HorizontalLayout();
		top.setSizeFull();
		Label title = new Label("Witaj!");
		title.setWidth(null);
		top.addComponent(title);
		top.setComponentAlignment(title, Alignment.TOP_CENTER);
		title.addStyleName(TStyles.LOGIN_TITLE);
		final VerticalLayout vl = new VerticalLayout();
		content.setWidth(WINDOW_WIDTH, Unit.PIXELS);
		content.setHeight(WINDOW_HEIGHT,Unit.PIXELS);
		content.addStyleName(TStyles.LOGIN_WINDOW);
		vl.setMargin(false);
		vl.setSpacing(false);
//		vl.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		vl.addComponents(errosMsg,userName,password,forgotPass,loginButton);
		content.addComponent(top);
		content.addComponent(vl);
		content.setExpandRatio(top, 1.0f);
		return content;
	}

}
