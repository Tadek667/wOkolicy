package okolica.view.components.table;

import okolica.app.TStyles;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public abstract class TAbstractTable extends Table{

	private static final long serialVersionUID = 1L;
	protected final String P_DELETE = "";
	protected final String P_SELECT = " ";
	protected abstract void loadColumnSettings();
	protected abstract void setColumnOrder();
	
	public TAbstractTable(){
		addStyleName(ValoTheme.TABLE_COMPACT);
	}
	
	protected void addSelectionColumn(){
		addGeneratedColumn(P_SELECT, new ColumnGenerator() {
			private static final long serialVersionUID = 1L;
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
				CheckBox check = new CheckBox();
				check.addStyleName(ValoTheme.CHECKBOX_SMALL);
				return check;
			}
		});
		setColumnAlignment(P_SELECT, Align.CENTER);
	}
	
	protected void addDeleteColumn(){
		addGeneratedColumn(P_DELETE, new ColumnGenerator() {
			private static final long serialVersionUID = 1L;
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
				Button delete = new Button();
				delete.addStyleName(ValoTheme.BUTTON_BORDERLESS);
				delete.addClickListener(new ClickListener() {
					private static final long serialVersionUID = 1L;
					@Override
					public void buttonClick(ClickEvent event) {
						handleDeleteItem(itemId);
					}
				});
				delete.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
				delete.addStyleName(TStyles.BUTTON_ADD);
				delete.addStyleName(ValoTheme.BUTTON_SMALL);
				delete.setIcon(FontAwesome.TRASH_O);
				return delete;
			}
		});
		setColumnAlignment(P_DELETE, Align.CENTER);
	}
	
	protected void addSelectionListener(){
		addItemClickListener(new ItemClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void itemClick(ItemClickEvent event) {
				handleSelectionClick();
			}
		});
	}
	
	protected void handleDeleteItem(Object itemId){
		
	}
	
	protected void handleSelectionClick(){
		
	}
}
