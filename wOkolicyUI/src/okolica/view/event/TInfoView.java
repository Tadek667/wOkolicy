package okolica.view.event;

import java.util.Date;

import okolica.app.TStyles;
import okolica.view.components.TPanel;
import okolica.view.ui.TAbstractView;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.PopupView.Content;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


public class TInfoView extends TAbstractView implements ClickListener{

	private static final long serialVersionUID = 1L;
	private final int SETTINGS_HEIGHT = 100;
	
	private Button prevMonth;
	private Button nextMonth;
	private Button info;
	
	public TInfoView() {
		super();
		//addComponent(createCalendarSettings());
		TPanel calendar = createCalendar();
		calendar.addListenerForAddButton(this);
		calendar.setHeight(450, Unit.PIXELS);
		//addComponent(calendar);
		HorizontalLayout footer = new HorizontalLayout();
		footer.setWidth("100%");
		footer.setHeight(30, Unit.PIXELS);
		//addComponent(footer);
//		setExpandRatio(calendar, 1.0f);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	private TPanel createCalendar(){
		Calendar calendar = new Calendar();
		calendar.setSizeUndefined();
		calendar.setStartDate(new Date());
		java.util.Calendar cal = java.util.Calendar.getInstance(); 
		cal.add(java.util.Calendar.MONTH, 1);
		calendar.setEndDate(cal.getTime());
		TPanel panel = new TPanel("", calendar);	
		return panel;
	}

	private HorizontalLayout createCalendarSettings(){
		final HorizontalLayout hl = new HorizontalLayout();
		hl.setWidth("100%");
		hl.setHeightUndefined();
		final HorizontalLayout navButtons = new HorizontalLayout();
		navButtons.setSizeUndefined();
		navButtons.setSpacing(true);
		prevMonth = new Button("poprzedni");
		prevMonth.addStyleName(TStyles.CALENDAR_NAV_BUTTON);
		prevMonth.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		prevMonth.addStyleName(ValoTheme.BUTTON_SMALL);
		prevMonth.setIcon(FontAwesome.ARROW_LEFT);
		nextMonth = new Button("następny");
		nextMonth.addStyleName(TStyles.CALENDAR_NAV_BUTTON);
		nextMonth.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		nextMonth.addStyleName(ValoTheme.BUTTON_SMALL);
		nextMonth.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
		nextMonth.setIcon(FontAwesome.ARROW_RIGHT);
		info = new Button();
		info.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		info.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
		info.setIcon(FontAwesome.INFO);
		hl.setHeight(SETTINGS_HEIGHT, Unit.PIXELS);
		navButtons.addComponent(prevMonth);
		navButtons.addComponent(nextMonth);
		hl.addComponent(navButtons);
		hl.addComponent(info);
		hl.setComponentAlignment(navButtons, Alignment.MIDDLE_LEFT);
		hl.setComponentAlignment(info, Alignment.MIDDLE_RIGHT);
		addHelpPopup();
		return hl;
	}
	
	private void addHelpPopup(){
		VerticalLayout content = new VerticalLayout();
		Label text = new Label();
		text.setValue("Przykładowy tekst pomocy dla tego widoku");
		content.addComponent(text);
		PopupView popup = new PopupView("POMOC", content);
		info.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				popup.setPopupVisible(true);
			}
		});
	}


	@Override
	public void buttonClick(ClickEvent event) {
		TEventWindow window = new TEventWindow();
		UI.getCurrent().addWindow(window);
	}
	
}
