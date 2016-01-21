package okolica.view.contacts;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import okolica.app.THelper;
import okolica.app.TStyles;
import okolica.model.TKontakt;
import okolica.view.components.table.TAbstractBeanTable;
import okolica.view.windows.TDeleteConfirmationWindow;
import okolica.view.windows.TDeleteConfirmationWindow.IDeleteAction;

public class TContactTable extends TAbstractBeanTable{

	private static final long serialVersionUID = 1L;

	public TContactTable() {
		super(TKontakt.class);
		addSampleData();
		setSelectable(true);
		setColumnIcon(TKontakt.P_NAME, FontAwesome.USER);
		setColumnIcon(TKontakt.P_SURNAME, FontAwesome.USER);
		setColumnIcon(TKontakt.P_EMAIL, FontAwesome.ENVELOPE_O);
		setColumnIcon(TKontakt.P_PHONE, FontAwesome.PHONE);
		addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
	}
	

	private void addSampleData(){
		TKontakt admin = new TKontakt();
		admin.setName("Dominik");
		admin.setSurname("Adamek");
		admin.setEmail("adamek.dominik@gmail.com");
		admin.setPhone("517877537");
		add(admin);
	}
	
	@Override
	protected void loadColumnSettings() {
		setColumnHeader(TKontakt.P_NAME, "Imię");
		setColumnHeader(TKontakt.P_SURNAME, "Nazwisko");
		setColumnHeader(TKontakt.P_PHONE, "Telefon");
		setColumnHeader(TKontakt.P_EMAIL, "E-mail");
	}

	@Override
	protected void setColumnOrder() {
		setVisibleColumns(TKontakt.P_NAME,TKontakt.P_SURNAME,
							TKontakt.P_PHONE,TKontakt.P_EMAIL,P_DELETE);
	}

	public class TContactTextFilter implements Filter{

		private static final long serialVersionUID = 1L;
		private String input;
		
		public TContactTextFilter(String input) {
			this.input = input;
		}
		
		@Override
		public boolean passesFilter(Object itemId, Item item)
				throws UnsupportedOperationException {
			@SuppressWarnings("unchecked")
			BeanItem<TKontakt> it = (BeanItem<TKontakt>) getItem(itemId);
			TKontakt contact = it.getBean();
			if(contact.getName().toLowerCase().contains(input.toLowerCase()) ||
					contact.getSurname().toLowerCase().contains(input.toLowerCase()) ||
					contact.getEmail().toLowerCase().contains(input.toLowerCase())){
				return true;
			}
			return false;
		}

		@Override
		public boolean appliesToProperty(Object propertyId) {
			if(propertyId.equals(TKontakt.P_NAME) ||
					propertyId.equals(TKontakt.P_SURNAME) ||
					propertyId.equals(TKontakt.P_EMAIL)) return true;
			return false;
		}
		
	}
	
	@Override
	protected void handleDeleteItem(Object itemId) {
		TDeleteConfirmationWindow window = new TDeleteConfirmationWindow(new IDeleteAction() {
			@Override
			public void handleDelete() {
				removeItem(itemId);
			}
		}, "USUŃ KONTAKT", "Czy na pewno chcesz usunąć kontakt ?" );
		UI.getCurrent().addWindow(window);
	}
	
	
}
