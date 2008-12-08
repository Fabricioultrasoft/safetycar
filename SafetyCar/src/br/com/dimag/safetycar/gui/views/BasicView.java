package br.com.dimag.safetycar.gui.views;

import org.eclipse.ui.part.ViewPart;

public abstract class BasicView extends ViewPart {

	public void closeView() { 
		this.getViewSite().getWorkbenchWindow().getActivePage().hideView(this);
	}

}
