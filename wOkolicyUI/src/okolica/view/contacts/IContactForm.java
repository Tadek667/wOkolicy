package okolica.view.contacts;

import okolica.model.TKontakt;

public interface IContactForm {
	void showNewContactForm();
	void showInEditMode(TKontakt contact);
	void hideAndClear();
}
