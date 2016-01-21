package okolica.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import okolica.view.ui.IUploadView;

import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

public abstract class TAbstractUploader implements Receiver,SucceededListener{

	private static final long serialVersionUID = 1L;

	protected File file;
	protected IUploadView view;
	
	public void setUploadView(IUploadView view){
		this.view = view;
	}
	
	@Override
	public void uploadSucceeded(SucceededEvent event) {
		
	}

	@Override
	public OutputStream receiveUpload(String filename, String mimeType) {
		file = new File(filename);
		try {
			return new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
