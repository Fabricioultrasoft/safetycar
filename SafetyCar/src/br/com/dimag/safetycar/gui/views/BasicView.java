package br.com.dimag.safetycar.gui.views;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

public abstract class BasicView extends ViewPart {

	public void closeView() { 
		this.getViewSite().getWorkbenchWindow().getActivePage().hideView(this);
	}

	public void openView(String id) {
		try {
			this.getViewSite().getWorkbenchWindow().getActivePage().showView(id);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public IViewPart findView(String id){
		try {
			return this.getViewSite().getWorkbenchWindow().getActivePage().findView(id);
		} catch (Exception e) {
			return null;
		}
	}
}
