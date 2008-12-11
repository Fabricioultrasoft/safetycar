package br.com.dimag.safetycar.gui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.model.Servico;
import br.com.dimag.safetycar.model.Usuario;

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
public class UsuarioListView extends BasicView {

	public static final String ID = "SafetyCar.usuarioList";
	private TableViewer viewer;
	private List<Usuario> listUsuarios;
	private Group groupDadosUsuario;

	// LOGIN
	private Label labelLogin;
	private Text textLogin;

	// BOT�ES DE CONFIRMA E CANCELAR
	private Button buttonPesquisar;

	public UsuarioListView() {
		listUsuarios = new ArrayList<Usuario>();

	}
	
	public enum ColumnProperty{
		LOGIN("Login",200);
		
		private String name;
		private int width;
		
		private ColumnProperty(String name,int width){
			this.name = name;
			this.width = width;
		}

		public String getName() {
			return name;
		}

		public int getWidth() {
			return width;
		}

	}

	class ViewContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.getInput();
		}

		public void dispose() {

		}

		public Object[] getElements(Object parent) {
			return listUsuarios.toArray(new Servico[listUsuarios.size()]);
		}

	}

	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			Usuario usuario = (Usuario)element;
			if (columnIndex == ColumnProperty.LOGIN.ordinal()){
				return usuario.getLogin();
			}
			return "";
		}
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite composite) {
		{
			
			composite.setSize(484, 418);
			GridLayout mainLayout = new GridLayout();
			mainLayout.numColumns = 1;
			composite.setLayout(mainLayout);
			{
				groupDadosUsuario = new Group(composite, SWT.NONE);
				GridLayout dadosUsuarioLayout = new GridLayout();
				dadosUsuarioLayout.numColumns = 2;
				
				GridData dadosServicoLData = new GridData();
				dadosServicoLData.verticalAlignment = SWT.FILL;
				dadosServicoLData.horizontalAlignment = SWT.FILL;
				groupDadosUsuario.setLayoutData(dadosServicoLData);
				
				groupDadosUsuario.setLayout(dadosUsuarioLayout);
				groupDadosUsuario.setText("Dados da Consulta Usu�rios");
				groupDadosUsuario.setSize(243, 215);

				// LOGIN

				{
					labelLogin = new Label(groupDadosUsuario, SWT.NONE);
					labelLogin.setText("Login:");
				}
				{
					textLogin = new Text(groupDadosUsuario, SWT.NONE);
					GridData loginUsuarioLData = new GridData();
					loginUsuarioLData.heightHint = 13;
					loginUsuarioLData.horizontalAlignment = GridData.FILL;
					loginUsuarioLData.grabExcessHorizontalSpace = true;
					textLogin.setLayoutData(loginUsuarioLData);
				}

				// view BOT�O CONFIRMA
				{
					buttonPesquisar = new Button(groupDadosUsuario, SWT.PUSH
							| SWT.CENTER);
					GridData buttonConfirmaLData = new GridData();
					buttonConfirmaLData.verticalAlignment = GridData.BEGINNING;
					buttonConfirmaLData.horizontalAlignment = GridData.BEGINNING;
					buttonPesquisar.setLayoutData(buttonConfirmaLData);
					buttonPesquisar.setText("Pesquisar");

					buttonPesquisar
							.addSelectionListener(new SelectionListener() {

								@Override
								public void widgetSelected(SelectionEvent event) {
									pesquisar();
								}

								@Override
								public void widgetDefaultSelected(
										SelectionEvent arg0) {
									// TODO Auto-generated method stub
								}

							});
				}

				// PRA BAIXO JA ESTAVA

				
				viewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL| SWT.BORDER_SOLID);
				viewer.getTable().setLinesVisible(true);
				viewer.getTable().setHeaderVisible(true);

				viewer.setContentProvider(new ViewContentProvider());
				GridData viewerLData = new GridData();
				viewerLData.grabExcessHorizontalSpace = true;
				viewerLData.grabExcessVerticalSpace = true;
				viewerLData.horizontalAlignment = SWT.FILL;
				viewerLData.verticalAlignment = SWT.FILL;
				viewer.getControl().setLayoutData(viewerLData);
				viewer.setLabelProvider(new ViewLabelProvider());
				
				for (ColumnProperty columnProperty : ColumnProperty.values()){
					TableColumn coluna = new TableColumn(viewer.getTable(),SWT.NONE);
					coluna.setText(columnProperty.getName());
					coluna.setWidth(columnProperty.getWidth());
				}
				
				viewer.addDoubleClickListener(new IDoubleClickListener() {

					@Override
					public void doubleClick(DoubleClickEvent event) {
						// TODO Auto-generated method stub
						StructuredSelection sl = (StructuredSelection) event
								.getSelection();
						closeView();
						openView(UsuarioView.ID);
						UsuarioView view = (UsuarioView) findView(UsuarioView.ID);
						view.loadUsuario((Usuario) sl.getFirstElement());
					}

				});
				loadData();
			}
		}
	}

	private void loadData() {
		pesquisar();
		
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private void pesquisar() {
		// dados servico
		if ( textLogin.getText().equals("")){
			listUsuarios = Facade.getInstance().listUsuario();
		}else{
			listUsuarios = Facade.getInstance().searchListUsuarioByLogin(textLogin.getText());
		}
		viewer.setInput(listUsuarios);
	}

}
