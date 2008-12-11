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
import br.com.dimag.safetycar.gui.views.ServicoListView;
import br.com.dimag.safetycar.gui.views.UsuarioView;
import br.com.dimag.safetycar.gui.views.UsuarioListView;

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
	private ViewBasicAction servicoListViewAction;
	private ViewBasicAction usuarioViewAction;
	private ViewBasicAction usuarioListViewAction;	
	
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
        
        clienteViewAction = new ViewBasicAction(window, "Cadastro de Clientes", ClienteView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/cadastrarclienteG.jpg"));
        register(clienteViewAction);
        
        OSViewAction = new ViewBasicAction(window, "Ordem de Serviço", OSView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/cadastrarOSG.jpg"));
        register(OSViewAction);
        
        OSListViewAction = new ViewBasicAction(window, "Lista de Ordem de Serviço",OSListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/listarOSG.jpg"));
        register(OSListViewAction);
        
        clienteListViewAction = new ViewBasicAction(window, "Lista de Clientes", ClienteListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/listarclienteG.jpg"));
        register(clienteListViewAction);
        
        automovelViewAction = new ViewBasicAction(window, "Cadastro de Automoveis", AutomovelView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/cadastrarAutomovelG.jpg"));
        register(automovelViewAction);
        
        automovelListViewAction = new ViewBasicAction(window, "Lista de Automovel", AutomovelListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/listarAutomovelG.jpg"));
        register(automovelListViewAction);
        
        produtoViewAction = new ViewBasicAction(window, "Cadastro de Produtos",ProdutoView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/cadastrarProdutoG.jpg"));
        register(produtoViewAction);

        produtoListViewAction = new ViewBasicAction(window, "Lista de Produtos",ProdutoListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/listarProdutoG.jpg"));
        register(produtoListViewAction);

        servicoViewAction = new ViewBasicAction(window, "Cadastro de Serviços",ServicoView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/cadastrarServicoG.jpg"));
        register(servicoViewAction);

        servicoListViewAction = new ViewBasicAction(window, "Lista de Serviços",ServicoListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/listarServicoG.jpg"));
        register(servicoListViewAction);
        
        usuarioViewAction = new ViewBasicAction(window, "Cadastro de Usuários",UsuarioView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/cadastrarUsuarioG.jpg"));
        register(usuarioViewAction);

        usuarioListViewAction = new ViewBasicAction(window, "Lista de Usuários",UsuarioListView.ID,br.com.dimag.safetycar.Activator.getImageDescriptor("/icons/listarUsuarioG.jpg"));
        register(usuarioListViewAction);
        
    }
    
    protected void fillMenuBar(IMenuManager menuBar) {
        MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
        MenuManager listMenu = new MenuManager("&List", IWorkbenchActionConstants.M_FILE);
        MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
        
        menuBar.add(fileMenu);
        menuBar.add(listMenu);
        
        // Add a group marker indicating where action set menus will appear.
        menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
        menuBar.add(helpMenu);
        
        // File
        fileMenu.add(newWindowAction);
        fileMenu.add(new Separator());
        fileMenu.add(clienteViewAction);
        fileMenu.add(OSViewAction);
        fileMenu.add(automovelViewAction);
        fileMenu.add(produtoViewAction);
        fileMenu.add(servicoViewAction);
        fileMenu.add(usuarioViewAction);
        fileMenu.add(new Separator());
        fileMenu.add(exitAction);
        
        // List
        listMenu.add(clienteListViewAction);
        listMenu.add(OSListViewAction);
        listMenu.add(automovelListViewAction);
        listMenu.add(produtoListViewAction);
        listMenu.add(servicoListViewAction);
        listMenu.add(usuarioListViewAction);
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
        toolbar.add(servicoListViewAction);
        toolbar.add(usuarioViewAction);
        toolbar.add(usuarioListViewAction);
        
    }

}
