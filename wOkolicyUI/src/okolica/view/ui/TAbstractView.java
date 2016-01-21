package okolica.view.ui;

import okolica.app.TStyles;

import com.vaadin.navigator.View;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


public abstract class TAbstractView extends Panel implements View{

	private static final long serialVersionUID = 1L;
	private VerticalLayout content;
	
	public TAbstractView(){
		content = new VerticalLayout();
		content.setSizeFull();
		setContent(content);
		content.setMargin(new MarginInfo(false, true, true, true));
		setSizeFull();
		addStyleName(ValoTheme.PANEL_BORDERLESS);
		addStyleName(TStyles.BACKGROUND);
	}
	
	protected Panel createPanelWrap(Component content, String caption){
		Panel panel = new Panel();
		panel.setCaption(caption);
		panel.setSizeUndefined();
		content.setSizeFull();
		panel.setContent(content);
		panel.setWidth(400, Unit.PIXELS);
		return panel;
	}
	
	protected void setMargin(boolean margin){
		content.setMargin(margin);
	}
	
	
	protected void setSpacing(boolean spacing){
		content.setSpacing(spacing);
	}
	
	protected void addComponent(Component component){
		content.addComponent(component);
	}
	
	protected void setComponentAlignment(Component component, Alignment alignment){
		content.setComponentAlignment(component, alignment);
	}
	
	protected void setExpandRatio(Component component, float ratio){
		content.setExpandRatio(component, ratio);
	}
	
	protected void clearView(){
		content.removeAllComponents();
	}
}
