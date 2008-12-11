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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.gui.views.NavigationView.TreeParent;
import br.com.dimag.safetycar.model.Servico;

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
public class ServicoListView extends BasicView {

	public static final String ID = "SafetyCar.servicoList";
	private TableViewer viewer;
	private List<Servico> listServicos;
	private Group groupDadosServico;

	// DESCRIÇÃO
	private Label labelDescricao;
	private Text textDescricao;

	// INICIO DA LOUCURA

	// LABEL ERROS
	private Label labelErro;

	// BOTÕES DE CONFIRMA E CANCELAR
	private Button buttonCancelar;
	private Button buttonPesquisar;

	private Servico servico;

	public ServicoListView() {
		listServicos = new ArrayList<Servico>();

	}

	class ViewContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.getInput();
		}

		public void dispose() {

		}

		public Object[] getElements(Object parent) {
			return listServicos.toArray(new Servico[listServicos.size()]);
		}

	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			Servico servico = (Servico) obj;
			return servico.getDescricao();
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
	private List<Servico> createModel() {
		listServicos = Facade.getInstance().listServico();

		return listServicos;
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite composite) {
		{
			composite.setSize(484, 418);
			{
				groupDadosServico = new Group(composite, SWT.NONE);
				GridLayout dadosServicoLayout = new GridLayout();
				dadosServicoLayout.numColumns = 2;
				groupDadosServico.setLayout(dadosServicoLayout);
				groupDadosServico.setText("Dados da Consulta Serviço");
				groupDadosServico.setSize(243, 215);

				// DESCRIÇÃO SERVIÇO

				{
					labelDescricao = new Label(groupDadosServico, SWT.NONE);
					labelDescricao.setText("Descrição:");
				}
				{
					textDescricao = new Text(groupDadosServico, SWT.NONE);
					GridData descricaoProdutoLData = new GridData();
					descricaoProdutoLData.heightHint = 13;
					descricaoProdutoLData.horizontalAlignment = GridData.FILL;
					descricaoProdutoLData.grabExcessHorizontalSpace = true;
					textDescricao.setLayoutData(descricaoProdutoLData);
				}

				// view BOTÃO CONFIRMA
				{
					buttonPesquisar = new Button(groupDadosServico, SWT.PUSH
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
				// LABEL ERRO
				{
					labelErro = new Label(groupDadosServico, SWT.NONE);
					GridData labelErroLData = new GridData();
					labelErroLData.horizontalAlignment = GridData.FILL;
					labelErroLData.horizontalSpan = 2;
					labelErroLData.grabExcessHorizontalSpace = true;
					labelErroLData.widthHint = 319;
					labelErroLData.heightHint = 26;
					labelErro.setLayoutData(labelErroLData);
					labelErro.setText("");
				}

				// PRA BAIXO JA ESTAVA
				viewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL
						| SWT.V_SCROLL | SWT.BORDER_SOLID);
				viewer.setColumnProperties(new String[] { "Descrição",
						"Valor Serviço" });
				viewer.setContentProvider(new ViewContentProvider());
				viewer.setLabelProvider(new ViewLabelProvider());
				viewer.addDoubleClickListener(new IDoubleClickListener() {

					@Override
					public void doubleClick(DoubleClickEvent event) {
						// TODO Auto-generated method stub
						StructuredSelection sl = (StructuredSelection) event
								.getSelection();
						closeView();
						openView(ServicoView.ID);
						ServicoView view = (ServicoView) findView(ServicoView.ID);
						view.loadServico((Servico) sl.getFirstElement());
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
		if ( textDescricao.getText().equals("")){
			listServicos = Facade.getInstance().listServico();
		}else{
			listServicos = Facade.getInstance().searchListServicoByDescricao(textDescricao.getText());
		}
		viewer.setInput(listServicos);
	}

}
