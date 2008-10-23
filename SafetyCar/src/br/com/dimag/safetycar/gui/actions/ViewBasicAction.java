package br.com.dimag.safetycar.gui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;


public class ViewBasicAction extends Action {
	
	private final IWorkbenchWindow window;
	private final String viewId;
	
	public ViewBasicAction(IWorkbenchWindow window, String label, String viewId, ImageDescriptor imageDescriptor) {
		this.window = window;
		this.viewId = viewId;
        setText(label);
        // The id is used to refer to the action in a menu or toolbar
		setId(viewId);
        // Associate the action with a pre-defined command, to allow key bindings.
		setActionDefinitionId(viewId);
		setImageDescriptor(imageDescriptor);
		
	}
	
	public void run() {
		if(window != null) {	
			try {
				window.getActivePage().showView(viewId);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error", "Error opening view:" + e.getMessage());
			}
		}
	}
}
