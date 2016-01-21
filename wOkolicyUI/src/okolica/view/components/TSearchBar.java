package okolica.view.components;

import okolica.app.TStyles;

import com.vaadin.ui.ComboBox;

public class TSearchBar extends ComboBox{
	
	private final String INPUT_PROMPT = "Wyszukaj...";
	
	private static final long serialVersionUID = 1L;

	public TSearchBar(){
		addStyleName(TStyles.SEARCH_BAR);
		setInputPrompt(INPUT_PROMPT);
	}
}
