package br.com.dimag.safetycar.gui.views;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

public abstract class BasicView extends ViewPart {
	
	protected static boolean isUpdate = false;

	public void closeView() { 
		this.getViewSite().getWorkbenchWindow().getActivePage().hideView(this);
	}

	public void closeView(String id) {
		IViewPart view = findView(id);
		if (view != null){
		this.getViewSite().getWorkbenchWindow().getActivePage().hideView(view);
		}	
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
