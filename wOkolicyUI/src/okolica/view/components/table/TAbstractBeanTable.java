package okolica.view.components.table;

import okolica.app.TStyles;
import okolica.model.TEntity;

import com.vaadin.data.util.BeanItemContainer;

public abstract class TAbstractBeanTable extends TAbstractTable{

	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private BeanItemContainer container;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TAbstractBeanTable(Class<? extends TEntity> type){
		this.container = new BeanItemContainer(type);
		addDeleteColumn();
		setContainerDataSource(container);
		loadColumnSettings();
		setColumnOrder();
		addStyleName(TStyles.CONTACT_TABLE);
	}
	
	@SuppressWarnings("unchecked")
	public void add(TEntity item){
		container.addBean(item);
		refreshRowCache();
	}

}
