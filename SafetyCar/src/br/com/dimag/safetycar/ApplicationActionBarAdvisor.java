package br.com.dimag.safetycar;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import br.com.dimag.safetycar.gui.actions.ViewBasicAction;
import br.com.dimag.safetycar.gui.views.AutomovelListView;
import br.com.dimag.safetycar.gui.views.AutomovelView;
import br.com.dimag.safetycar.gui.views.ClienteListView;
import br.com.dimag.safetycar.gui.views.ClienteView;
import br.com.dimag.safetycar.gui.views.OSListView;
import br.com.dimag.safetycar.gui.views.OSView;
import br.com.dimag.safetycar.gui.views.ProdutoView;
import br.com.dimag.safetycar.gui.views.ProdutoListView;
import br.com.dimag.safetycar.gui.views.ServicoView;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of the
 * actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    // Actions - important to allocate these only in makeActions, and then use them
    // in the fill methods.  This ensures that the actions aren't recreated
    // when fillActionBars is called with FILL_PROXY.
    private IWorkbenchAction exitAction;
    private IWorkbenchAction aboutAction;
    private IWorkbenchAction newWindowAction;
	private ViewBasicAction clienteViewAction;
	private ViewBasicAction OSViewAction;
	private ViewBasicAction OSListViewAction;
	private ViewBasicAction clienteListViewAction;
	private ViewBasicAction automovelViewAction;
	private ViewBasicAction automovelListViewAction;
	private ViewBasicAction produtoViewAction;
	private ViewBasicAction produtoListViewAction;
	private ViewBasicAction servicoViewAction;
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }
    
    protected void makeActions(final IWorkbenchWindow window) {
        // Creates the actions and registers them.
        // Registering is needed to ensure that key bindings work.
        // The corresponding commands keybindings are defined in the plugin.xml file.
        // Registering also provides automatic disposal of the actions when
        // the window is closed.

        exitAction = ActionFactory.QUIT.create(window);
        register(exitAction);
        
        aboutAction = ActionFactory.ABOUT.create(window);
        register(aboutAction);
        
        newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
        register(newWindowAction);
        
        clienteViewAction = new ViewBasicAction(window, "Cadastro de Clientes", ClienteView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(clienteViewAction);
        
        OSViewAction = new ViewBasicAction(window, "Ordem de Serviço", OSView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(OSViewAction);
        
        clienteListViewAction = new ViewBasicAction(window, "Lista de Clientes", ClienteListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(clienteListViewAction);
        
        automovelViewAction = new ViewBasicAction(window, "Cadastro de Automoveis", AutomovelView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(automovelViewAction);
        
        automovelListViewAction = new ViewBasicAction(window, "Lista de Automovel", AutomovelListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(automovelListViewAction);
        
        OSListViewAction = new ViewBasicAction(window, "Lista de Ordem de Serviço",OSListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(OSListViewAction);
        
        produtoViewAction = new ViewBasicAction(window, "Cadastro de Produtos",ProdutoView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(produtoViewAction);

        produtoListViewAction = new ViewBasicAction(window, "Lista de Produtos",ProdutoListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(OSListViewAction);

        servicoViewAction = new ViewBasicAction(window, "Cadastro de Serviços",ServicoView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/sample2.gif"));
        register(produtoViewAction);

        
    }
    
    protected void fillMenuBar(IMenuManager menuBar) {
        MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
        MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
        
        menuBar.add(fileMenu);
        // Add a group marker indicating where action set menus will appear.
        menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
        menuBar.add(helpMenu);
        
        // File
        fileMenu.add(newWindowAction);
        fileMenu.add(new Separator());
        fileMenu.add(clienteViewAction);
        fileMenu.add(OSViewAction);
        fileMenu.add(OSListViewAction);
        fileMenu.add(clienteListViewAction);
        fileMenu.add(automovelViewAction);
        fileMenu.add(automovelListViewAction);
        fileMenu.add(produtoViewAction);
        fileMenu.add(produtoListViewAction);
        fileMenu.add(servicoViewAction);
        fileMenu.add(new Separator());
        fileMenu.add(exitAction);
        
        // Help
        helpMenu.add(aboutAction);
    }
    
    protected void fillCoolBar(ICoolBarManager coolBar) {
        IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
        coolBar.add(new ToolBarContributionItem(toolbar, "main"));   
        toolbar.add(clienteViewAction);
        toolbar.add(clienteListViewAction);
        toolbar.add(OSViewAction);
        toolbar.add(OSListViewAction);
        toolbar.add(automovelViewAction);
        toolbar.add(automovelListViewAction);
        toolbar.add(produtoViewAction);
        toolbar.add(produtoListViewAction);
        toolbar.add(servicoViewAction);
        
    }

}
