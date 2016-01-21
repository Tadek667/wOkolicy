package okolica.view.components;

import okolica.app.THelper;
import okolica.app.TStyles;
import okolica.enumes.EViewType;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


public class TMenu extends VerticalLayout{

	
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 150;
	
	public TMenu(){
		addStyleName(TStyles.MENU);
		setWidth(WIDTH, Unit.PIXELS);
		setHeight("100%");
		setMargin(false);
		setSpacing(true);
		createLogo();
		createMenuButtons();
	}
	
	
	private void createLogo(){
		final ThemeResource resource = new ThemeResource("img/wOkolicyLOGO.png");
		Image image = new Image("",resource);
		image.addStyleName(TStyles.MENU_LOGO);
		image.setWidth(50, Unit.PIXELS);
		image.setHeight(50, Unit.PIXELS);
		final HorizontalLayout imageWrap = new HorizontalLayout();
		final Label title = new Label("w budowie ver. 1.0");
		title.addStyleName(TStyles.MENU_TITLE);
		imageWrap.addComponent(image);
		imageWrap.addComponent(title);
		imageWrap.setComponentAlignment(title, Alignment.BOTTOM_RIGHT);
		addComponent(imageWrap);
		setComponentAlignment(imageWrap, Alignment.TOP_CENTER);
	}
	
	private void createMenuButtons(){
		final VerticalLayout buttons = new VerticalLayout();
		buttons.addStyleName(TStyles.MENU_BUTTONS);
		buttons.setHeightUndefined();
		buttons.setWidth("100%");
		buttons.setSpacing(false);
		for(EViewType view : EViewType.values()){
			TMenuButton button = new TMenuButton(view);
			buttons.addComponent(button);
		}
		addComponent(buttons);
		setComponentAlignment(buttons, Alignment.TOP_CENTER);
		setExpandRatio(buttons, 1.0f);
	}
	
	public final class TMenuButton extends Button{
		
		private static final long serialVersionUID = 1L;

		public TMenuButton(final EViewType view){
			addStyleName(ValoTheme.BUTTON_BORDERLESS);
			addStyleName(TStyles.BUTTON_MENU);
			//addStyleName("icon-align-top");
			//waddStyleName("center-text");
			setIcon(view.getIcon());
			setCaption(view.getViewName());
			registerNavigator(view);
		}
		
		private void registerNavigator(final EViewType view){
			addClickListener(new ClickListener() {
				private static final long serialVersionUID = 1L;
				@Override
				public void buttonClick(ClickEvent event) {
					THelper.navigateTo(view.getViewName());
				}
			});
		}
		
	}
}
