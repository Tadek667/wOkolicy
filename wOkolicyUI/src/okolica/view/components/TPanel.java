package okolica.view.components;



import okolica.app.TStyles;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;


/**
 * Reprezentacja panelu z przyciskami 
 * w sekcji nazwy
 * @author Dominik
 *
 */
public class TPanel extends CssLayout{
	

	private static final long serialVersionUID = 1L;
	private String caption;
	private Component content;
	private NativeButton addItem;
	private NativeButton settings;
	
	public TPanel(String caption,Component content){
		this.caption = caption;
		this.content = content;
		init();
	}
	
	private void init(){
		addStyleName("card");
		addStyleName(TStyles.PANEL);
	    HorizontalLayout panelCaption  = createCaption();
	    addItem = createAddButton();
	    panelCaption.setMargin(true);
        panelCaption.addComponent(addItem);
        panelCaption.setComponentAlignment(addItem, Alignment.MIDDLE_LEFT);
        panelCaption.setExpandRatio(addItem, 1.0f);
        addComponent(panelCaption);
        addComponent(content);
        setWidth("100%");
	}
	
	
	
	private NativeButton createAddButton(){
		addItem = new NativeButton("UTWÓRZ");
		addItem.addStyleName(TStyles.PANEL_BUTTON);
		addItem.setIcon(FontAwesome.PLUS);
		addItem.addStyleName("small");
		return addItem;
	}
	
	
	
	private HorizontalLayout createCaption(){
		HorizontalLayout panelCaption = new HorizontalLayout();
	    panelCaption.addStyleName("v-panel-caption");
	    panelCaption.addStyleName(TStyles.PANEL_CAPTION);
	    panelCaption.setWidth("100%");
	    Label label = new Label(caption);
	    label.setWidthUndefined();
	    panelCaption.addComponent(label);
	    panelCaption.setSpacing(true);
	    return panelCaption;
	}
	
	public void addListenerForAddButton(ClickListener listener){
		addItem.addClickListener(listener);
	}

}
