package okolica.view.crush;

import java.util.Date;

import okolica.app.THelper;
import okolica.enumes.ECrushPriority;
import okolica.enumes.ECrushType;
import okolica.model.TAwaria;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class TCrushWindow extends Window{

	private static final long serialVersionUID = 1L;
	
	private ComboBox crushType;
	private ComboBox priority;
	private TextArea describtion;
	private Button save;
	private ClickListener saveListener;
	
	public TCrushWindow(){
		setModal(true);
		setSizeUndefined();
	}
	
	private Component createContent(){
		VerticalLayout content = new VerticalLayout();
		content.setSizeUndefined();
		content.setMargin(true);
		content.setSpacing(true);
		FormLayout form = new FormLayout();
		form.setSizeUndefined();
		crushType = new ComboBox("Rodzaj awarii:");
		crushType.setWidth(THelper.DEFAULT_WIDTH, Unit.PIXELS);
		crushType.addItems((Object[])ECrushType.values());
		crushType.select(ECrushType.WODA);
		priority = new ComboBox("Priorytet:");
		priority.setWidth(THelper.DEFAULT_WIDTH, Unit.PIXELS);
		priority.addItems((Object[])ECrushPriority.values());
		priority.select(ECrushPriority.MEDIUM);
		describtion = new TextArea("Opis:");
		describtion.setInputPrompt("Napisz coś więcej...");
		describtion.setWidth(THelper.DEFAULT_WIDTH, Unit.PIXELS);
		form.setSpacing(true);
		form.addComponents(crushType,priority,describtion);
		content.addComponent(form);
		save = new Button("ZAPISZ");
		save.addStyleName(ValoTheme.BUTTON_PRIMARY);
		save.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				handleAddCrush();
				if(saveListener != null){
					saveListener.buttonClick(event);
				}
				UI.getCurrent().removeWindow(TCrushWindow.this);
			}
		});
		content.addComponent(save);
		content.setComponentAlignment(save, Alignment.BOTTOM_CENTER);
		return content;
	}
	
	private void handleAddCrush(){
		TAwaria crush = new TAwaria();
		crush.setAddDate(new Date());
		crush.setType((ECrushType) crushType.getValue());
		crush.setPriority((ECrushPriority) priority.getValue());
		crush.setDescribtion(describtion.getValue());
	}
	
	public void setSaveListener(ClickListener listener){
		this.saveListener = listener;
	}
	
	public void show(){
		setContent(createContent());
		UI.getCurrent().addWindow(this);
	}

	
}
