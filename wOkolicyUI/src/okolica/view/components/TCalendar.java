package okolica.view.components;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClick;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClickHandler;
import com.vaadin.ui.components.calendar.event.BasicEvent;
import com.vaadin.ui.components.calendar.event.CalendarEvent;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class TCalendar extends Calendar implements ClickListener{

	//private TCalendarPresenter presenter;
	
	private TextField eventName;
	private TextArea eventDescribtion;
	private DateField eventStartDate;
	private DateField eventEndDate;
	private Button save;
	private Button delete;
	private Window window;
	private CalendarEvent currentEvent;
	
	protected DateFormat df_date_time = new SimpleDateFormat(
            "yyyy-MM-dd");
	private static final long serialVersionUID = 1L;

	public TCalendar(){
		//presenter = new TCalendarPresenter();
		customize();
		installEventClickListener();
	}
	
	private void installEventClickListener(){
		
		setHandler(new EventClickHandler() {
			@Override
			public void eventClick(EventClick event) {
				handleClickEvent(event.getCalendarEvent());
			}
		});
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		window = new Window("NOWE WYDARZENIE");
		window.setModal(true);
		window.setResponsive(true);
		window.setContent(createAddEventWindowContent());
		window.setSizeUndefined();
		UI.getCurrent().addWindow(window);
	}
	
	private Component createAddEventWindowContent(){
		VerticalLayout content = new VerticalLayout();
		content.setSizeUndefined();
		content.setMargin(true);
		content.setSpacing(true);
		FormLayout form = new FormLayout();
		form.setSizeUndefined();
		eventName = new TextField("Nazwa:");
		eventName.setInputPrompt("Podaj nazwę wydarzenia");
		//eventName.setWidth(THelper.DEFAULT_WIDTH, Unit.PIXELS);
		eventName.setRequired(true);
		eventStartDate = new DateField("Początek:");
		//eventStartDate.setWidth(THelper.DEFAULT_WIDTH, Unit.PIXELS);
		eventStartDate.setRequired(true);
		eventStartDate.setResolution(Resolution.MINUTE);
		eventEndDate = new DateField("Koniec:");
		//eventEndDate.setWidth(THelper.DEFAULT_WIDTH, Unit.PIXELS);
		eventEndDate.setRequired(true);
		eventEndDate.setResolution(Resolution.MINUTE);
		eventDescribtion = new TextArea("Opis:");
		eventDescribtion.setInputPrompt("Napisz coś więcej...");
		//eventDescribtion.setWidth(THelper.DEFAULT_WIDTH, Unit.PIXELS);
		form.setSpacing(true);
		form.addComponents(eventName,eventStartDate,eventEndDate,eventDescribtion);
		content.addComponent(form);
		save = new Button("ZAPISZ");
		save.addStyleName(ValoTheme.BUTTON_PRIMARY);
		save.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				handleSaveEvent();
				window.close();
			}
		});
		delete = new Button("USUŃ");
		delete.addStyleName(ValoTheme.BUTTON_DANGER);
		delete.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				handleDelete();
			}
		});
		final HorizontalLayout buttonWrap = new HorizontalLayout();
		buttonWrap.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		buttonWrap.setSpacing(true);
		buttonWrap.addComponents(delete,save);
		content.addComponent(buttonWrap);
		content.setComponentAlignment(buttonWrap, Alignment.BOTTOM_CENTER);
		delete.setVisible(false);
		return content;
	}

	private void handleDelete(){
		removeEvent(currentEvent);
		window.close();
	}
	
	
	private void handleClickEvent(final CalendarEvent event){
		eventName.setValue(event.getCaption());
		eventStartDate.setValue(event.getStart());
		eventEndDate.setValue(event.getEnd());
		eventDescribtion.setValue(event.getDescription());
		currentEvent = event;
		delete.setVisible(true);
		UI.getCurrent().addWindow(window);
	}
	
	private void handleSaveEvent(){
		BasicEvent event = new BasicEvent();
		event.setCaption(eventName.getValue());
		event.setStart(eventStartDate.getValue());
		event.setEnd(eventEndDate.getValue());
		event.setDescription(eventDescribtion.getValue());
		addEvent(event);
		//presenter.runSaveEventAction();
	}
	
	private void customize(){
		setResponsive(true);
//		setWeeklyCaptionFormat("");
	}
	
	@Override
	public String getWeeklyCaptionFormat() {
		return "yyyy-MM-dd";
	}
	
	
	
}
