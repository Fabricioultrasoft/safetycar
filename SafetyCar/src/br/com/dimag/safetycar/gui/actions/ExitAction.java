package br.com.dimag.safetycar.gui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;

import br.com.dimag.safetycar.ICommandIds;



public class ExitAction extends Action {

    private final IWorkbenchWindow window;

    ExitAction(String text, IWorkbenchWindow window) {
        super(text);
        this.window = window;
        // The id is used to refer to the action in a menu or toolbar
        setId(ICommandIds.CMD_EXIT);
        // Associate the action with a pre-defined command, to allow key bindings.
        setActionDefinitionId(ICommandIds.CMD_EXIT);
        setImageDescriptor(br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample3.gif"));
    }

    public void run() {
        MessageDialog.openInformation(window.getShell(), "Exit", "Exit!");
    }
}