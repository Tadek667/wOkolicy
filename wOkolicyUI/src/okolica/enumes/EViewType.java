package okolica.enumes;


import okolica.view.apartments.TApartmentsView;
import okolica.view.contacts.TContactsView;
import okolica.view.crush.TCrushView;
import okolica.view.documents.TDocumentsView;
import okolica.view.event.TInfoView;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum EViewType {
    EVENT("Wydarzenia", FontAwesome.CALENDAR, true,TInfoView.class),
    NEED_HELP("Awarie", FontAwesome.WARNING, true,TCrushView.class),
    CONTACTS("Kontakty", FontAwesome.GROUP, false,TContactsView.class),
    DOCUMENTS("Dokumenty", FontAwesome.FILE_TEXT, false,TDocumentsView.class),
    APARTMENTS("Mieszkania",FontAwesome.BUILDING_O,false,TApartmentsView.class);

    private final String viewName;
    private final Resource icon;
    private final Class<? extends View> view;
    private final boolean stateful;

    private EViewType(final String viewName,
            final Resource icon,
            final boolean stateful,
            final Class<? extends View> view) {
        this.viewName = viewName;
        this.view = view;
        this.icon = icon;
        this.stateful = stateful;
    }

    public boolean isStateful() {
        return stateful;
    }

    public String getViewName() {
        return viewName;
    }

   

    public Resource getIcon() {
        return icon;
    }

    public static EViewType getByViewName(final String viewName) {
        EViewType result = null;
        for (EViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

	public Class<? extends View> getView() {
		return view;
	}

}
