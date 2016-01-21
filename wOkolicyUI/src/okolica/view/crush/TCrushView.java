package okolica.view.crush;

import okolica.app.TStyles;
import okolica.view.components.TPanel;
import okolica.view.ui.TAbstractView;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


public class TCrushView extends TAbstractView {

	private static final long serialVersionUID = 1L;
	private TCrushTable table;
	private Label title;
	private TabSheet tabs;
	private Button addCrush;
	public TCrushView() {
		super();
		createTabs();
		setSizeFull();
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void createTabs(){
		tabs = new TabSheet();
		tabs.addStyleName(ValoTheme.TABSHEET_COMPACT_TABBAR);
		tabs.addTab(createCrushList(), "Lista");
		tabs.addTab(new VerticalLayout(), "Ustawienia");
		tabs.addTab(new VerticalLayout(), "Statystyki");
		addComponent(tabs);
	}

	private Component createCrushList(){
		VerticalLayout tabContent = new VerticalLayout();
		tabContent.setMargin(true);
		tabContent.setSizeFull();
		Panel panel = new Panel();
//		panel.addStyleName(ValoTheme.PANEL_BORDERLESS);
		panel.addStyleName(TStyles.PANEL_WITHOUT_BUTTONS);
		panel.setWidth("100%");
		panel.setHeight(600, Unit.PIXELS);
		VerticalLayout panelContent = new VerticalLayout();
		panelContent.setMargin(true);
		panelContent.setSizeFull();
		panel.setSizeFull();
		panel.setContent(panelContent);
		table = new TCrushTable();
		table.setSizeFull();
		table.setHeight(500,Unit.PIXELS);
		panelContent.addComponent(createToolbar());
		panelContent.setSpacing(true);
		panelContent.addComponent(table);
		tabContent.addComponent(panel);
		return tabContent;
	}
	
	private HorizontalLayout createToolbar(){
		final HorizontalLayout toolbar = new HorizontalLayout();
		toolbar.setWidth("100%");
		toolbar.setSpacing(true);
		toolbar.addComponent(createAddCrushButton());
		toolbar.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		return toolbar;
	}
	
	private Button createAddCrushButton(){
		addCrush = new Button("Dodaj");
		addCrush.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		addCrush.addStyleName(ValoTheme.BUTTON_SMALL);
		addCrush.setIcon(FontAwesome.PLUS);
		addCrush.addStyleName(TStyles.BUTTON_ADD);
		return addCrush;
	}
	
//	@Override
//	public void buttonClick(ClickEvent event) {
//		showAddCrushWindow();
//	}
//
//	private void showAddCrushWindow(){
//		final TCrushWindow window = new TCrushWindow();
//		window.setPresenter(presenter);
//		window.setSaveListener(new ClickListener() {
//			private static final long serialVersionUID = 1L;
//			@Override
//			public void buttonClick(ClickEvent event) {
//				table.add(presenter.getCrush());
//			}
//		});
//		window.show();
//	}
	
}
