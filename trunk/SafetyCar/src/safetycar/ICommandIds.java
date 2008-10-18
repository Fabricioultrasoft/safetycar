package safetycar;

import safetycar.views.ClienteListView;
import safetycar.views.ClienteView;

/**
 * Interface defining the application's command IDs.
 * Key bindings can be defined for specific commands.
 * To associate an action with a command, use IAction.setActionDefinitionId(commandId).
 *
 * @see org.eclipse.jface.action.IAction#setActionDefinitionId(String)
 */
public interface ICommandIds {

    public static final String CMD_CLIENTE = ClienteView.ID;
    public static final String CMD_CLIENTE_LIST = ClienteListView.ID;
    public static final String CMD_OPEN_MESSAGE = "SafetyCar.openMessage";
    
}
