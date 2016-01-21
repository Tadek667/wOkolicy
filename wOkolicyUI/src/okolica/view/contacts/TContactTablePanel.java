package okolica.view.contacts;

import okolica.app.TStyles;
import okolica.model.TKontakt;
import okolica.view.contacts.TContactTable.TContactTextFilter;

import com.vaadin.data.Container.Filterable;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public class TContactTablePanel extends VerticalLayout implements IContactSaver{

	private final String ADD_CONTACT = "Nowy kontakt";
	
	private Button add;
	private TextField search;
	private TContactTable table;
	private IContactForm formListener;
	
	public TContactTablePanel(IContactForm listener){
		setSizeFull();
		table = new TContactTable();
		setSpacing(true);
		createContent();
		setMargin(new MarginInfo(false, true, false, false));
		this.formListener = listener;
		table.addItemClickListener(new ItemClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void itemClick(ItemClickEvent event) {
				Object selected = event.getItemId();
				@SuppressWarnings("unchecked")
				BeanItem<TKontakt> contact = (BeanItem<TKontakt>) table.getItem(selected);
				formListener.showInEditMode(contact.getBean());
			}
		});
		table.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				if(table.getValue() == null){	//deselect
					formListener.hideAndClear();
				}
			}
		});
		installSearch();
	}
	
	private void createContent(){
		final HorizontalLayout top = new HorizontalLayout();
		add = new Button(ADD_CONTACT);
		add.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		add.addStyleName(TStyles.CONTACTS_ADD_BUTTON);
		add.setIcon(FontAwesome.PLUS);
		add.addStyleName(ValoTheme.BUTTON_SMALL);
		add.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				handleAddContanct();
			}
		});
		top.addComponent(add);
		top.setSpacing(true);
		search = new TextField();
		search.setInputPrompt("Wyszukaj kontakt...");
		search.addStyleName(ValoTheme.TEXTAREA_SMALL);
		search.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		search.setIcon(FontAwesome.SEARCH);
		top.addComponent(search);
		addComponent(top);
		addComponent(table);
		table.setWidth("100%");
		setExpandRatio(table, 1.0f);
	}
	
	private void installSearch(){
		search.setTextChangeEventMode(TextChangeEventMode.EAGER);
		search.addTextChangeListener(new TextChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void textChange(TextChangeEvent event) {
				if(!event.getText().trim().isEmpty()){
					Filterable f = (Filterable) table.getContainerDataSource();
					f.removeAllContainerFilters();
					TContactTextFilter filter = table.new TContactTextFilter(event.getText());
					f.addContainerFilter(filter);
				}
			}
		});
	}
	
	private void handleAddContanct(){
		formListener.showNewContactForm();
	}

	@Override
	public void saveBean(TKontakt contact) {
		table.add(contact);
	}
	
}
