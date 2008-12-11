package br.com.dimag.safetycar.gui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.gui.views.NavigationView.TreeParent;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.OrdemServico;


/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class OSListView extends BasicView {

	public static final String ID = "SafetyCar.osList";
	private TableViewer viewer;
	private List<OrdemServico> listOS;
	
	public OSListView(){
		listOS = new ArrayList<OrdemServico>();
		
	}

	class ViewContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.getInput();
		}

		public void dispose() {
			
		}

		public Object[] getElements(Object parent) {
			return listOS.toArray(new OrdemServico[listOS.size()]);
		}

	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			OrdemServico os = (OrdemServico)obj;
			return os.getAutomovel().getModelo() + " - " + os.getAutomovel().getPlaca() + " - " + os.getMecanico().getNomeRazaoSocial();
		}

		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					imageKey);
		}
	}

	/**
	 * We will set up a dummy model to initialize tree heararchy. In real code,
	 * you will connect to a real model and expose its hierarchy.
	 */
	private List<OrdemServico> createModel() {
		listOS = Facade.getInstance().listOrdemServico();
		return listOS;
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER_SOLID);
		viewer.setColumnProperties(new String[]{"Nome","Endereço"});
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(createModel());
		viewer.addDoubleClickListener(new IDoubleClickListener(){

			@Override
			public void doubleClick(DoubleClickEvent event) {
				// TODO Auto-generated method stub
				StructuredSelection sl = (StructuredSelection) event.getSelection();
				closeView();
				openView(OSView.ID);
				OSView view = (OSView)findView(OSView.ID);
				view.loadOS((OrdemServico)sl.getFirstElement());
			}
			
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
//	private void pesquisar() {
//		// dados servico
//		if ( textDescricao.getText().equals("")){
//			listServicos = Facade.getInstance().listServico();
//		}else{
//			listServicos = Facade.getInstance().searchListServicoByDescricao(textDescricao.getText());
//		}
//		viewer.setInput(listServicos);
//	}
	
}
