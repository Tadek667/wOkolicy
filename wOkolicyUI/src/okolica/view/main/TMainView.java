package okolica.view.main;

import okolica.app.TNavigator;
import okolica.app.TStyles;
import okolica.view.components.TMenu;
import okolica.view.components.TSearchBar;
import okolica.view.login.TLoginView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class TMainView extends HorizontalLayout implements View{

	
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "mainView";
	private final int TOP_LAYOUT_HEIGHT = 50;
	private final int FOOTER_HEIGHT = 40;
	
	private TMenu leftMenu;
	
	public TMainView(){
		init();
		addStyleName(TStyles.BACKGROUND);
	}
	
	
	public void init() {
		setSizeFull();
		leftMenu = new TMenu();
		addComponent(leftMenu);
		VerticalLayout container = new VerticalLayout();
		container.setSizeFull();
		container.setSpacing(true);
		container.setMargin(false);
		container.addComponent(createTopBar());
		HorizontalLayout footer = createFooter();
		ComponentContainer content = new VerticalLayout();
		content.setSizeFull();
		registerNavigator(content);
		container.addComponent(content);
		addComponent(container);
		container.setExpandRatio(content, 1.0f);
		setExpandRatio(container, 1.0f);
		container.addComponent(footer);
		container.setComponentAlignment(footer, Alignment.BOTTOM_CENTER);
	}

	private void registerNavigator(ComponentContainer content){
		new TNavigator(content);
	}
	
	private HorizontalLayout createTopBar(){
		final HorizontalLayout top = new HorizontalLayout();
		top.setHeight(TOP_LAYOUT_HEIGHT, Unit.PIXELS);
		top.setWidth("100%");
		top.addStyleName(TStyles.TOP_BAR);
		final HorizontalLayout leftSide = new HorizontalLayout();
		leftSide.setHeight("100%");
		leftSide.setWidthUndefined();
		leftSide.setMargin(false);
		leftSide.setSpacing(true);
		final HorizontalLayout rightSide = new HorizontalLayout();
		rightSide.setHeight("100%");
		rightSide.setWidthUndefined();
		rightSide.setMargin(false);
		rightSide.setSpacing(true);
		rightSide.addComponent(createMessageButton());
		rightSide.addComponent(createNotificationButton());
		rightSide.addComponent(createSettingsButton());
		rightSide.addComponent(createLogOutButton());
		HorizontalLayout toggleButton = createToggleButton();
		leftSide.addComponent(toggleButton);
		leftSide.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		leftSide.addComponent(createSearchBar());
		rightSide.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
		top.addComponent(leftSide);
		top.addComponent(rightSide);
		top.setComponentAlignment(leftSide, Alignment.MIDDLE_LEFT);
		top.setComponentAlignment(rightSide, Alignment.MIDDLE_RIGHT);
		return top;
	}
	
	private HorizontalLayout createFooter(){
		final HorizontalLayout footer = new HorizontalLayout();
		final Label copyRights = new Label("Copyright® 2016 by Dominik Adamek");
		copyRights.addStyleName(ValoTheme.LABEL_SMALL);
		footer.setHeight(FOOTER_HEIGHT, Unit.PIXELS);
		footer.setWidth("100%");
		footer.addStyleName(TStyles.MENU_FOOTER);
		footer.addComponent(copyRights);
		return footer;
	}
	
	private HorizontalLayout createToggleButton(){
		final HorizontalLayout toggleButtonWrap = new HorizontalLayout();
		toggleButtonWrap.setWidthUndefined();
		toggleButtonWrap.setHeight("100%");
		final Button toggleButton = new Button();
		toggleButton.setHeight("100%");
		toggleButton.addStyleName(TStyles.TOGGLE_BUTTON);
		toggleButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		toggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		toggleButton.setIcon(FontAwesome.BARS);
		toggleButtonWrap.addComponent(toggleButton);
		return toggleButtonWrap;
	}
	
	private HorizontalLayout createSearchBar(){
		final HorizontalLayout searchBar = new HorizontalLayout();
		searchBar.setSizeUndefined();
		searchBar.setSpacing(false);
		TSearchBar bar = new TSearchBar();
		searchBar.addComponent(bar);
		final Button searchButton = new Button();
		searchButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		searchButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		searchButton.addStyleName(TStyles.SEARCH_BAR_BUTTON);
		searchButton.setIcon(FontAwesome.SEARCH);
		searchBar.addComponent(searchButton);
		return searchBar;
	}
	
	private Button createSettingsButton(){
		final Button settings = new Button();
		settings.setHeight("100%");
		settings.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		settings.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		settings.addStyleName(TStyles.TOP_BAR_BUTTON);
		settings.setIcon(FontAwesome.COGS);
		return settings;
	}
	
	private Button createMessageButton(){
		final Button message = new Button();
		message.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		message.setHeight("100%");
		message.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		message.addStyleName(TStyles.TOP_BAR_BUTTON);
		//message.addStyleName(TStyles.SEARCH_BAR_BUTTON);
		message.setIcon(FontAwesome.ENVELOPE);
		return message;
	}
	
	private Button createNotificationButton(){
		final Button notification = new Button();
		notification.setHeight("100%");
		notification.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		notification.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		notification.addStyleName(TStyles.TOP_BAR_BUTTON);
		//notification.addStyleName(TStyles.SEARCH_BAR_BUTTON);
		notification.setIcon(FontAwesome.BELL_O);
		return notification;
	}
	
	private Button createLogOutButton(){
		final Button logout = new Button("Wyloguj");
		logout.addStyleName(TStyles.LOGOUT_BUTTON);
		logout.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		logout.setWidth(100, Unit.PIXELS);
		logout.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().setContent(new TLoginView());
			}
		});
		return logout;
	}
	


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	

	

}
