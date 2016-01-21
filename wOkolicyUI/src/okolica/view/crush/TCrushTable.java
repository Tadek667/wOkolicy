package okolica.view.crush;

import okolica.model.TAwaria;
import okolica.view.components.table.TAbstractBeanTable;

public class TCrushTable extends TAbstractBeanTable{

	
	private static final long serialVersionUID = 1L;
	
	public TCrushTable() {
		super(TAwaria.class);
	}

	@Override
	protected void loadColumnSettings() {
		setColumnHeader(TAwaria.P_TYPE, "Rodzaj awarii");
		setColumnHeader(TAwaria.P_DATE, "Data dodania");
		setColumnHeader(TAwaria.P_PRIORITY, "Priorytet");
		setColumnHeader(TAwaria.P_DESCRIBTION, "Opis");
	}

	@Override
	protected void setColumnOrder() {
		setVisibleColumns(TAwaria.P_TYPE,TAwaria.P_DATE,
							TAwaria.P_PRIORITY,TAwaria.P_DESCRIBTION);
		
	}

}
