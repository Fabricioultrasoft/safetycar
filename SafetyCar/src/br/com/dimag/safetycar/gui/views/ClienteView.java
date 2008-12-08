package br.com.dimag.safetycar.gui.views;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
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
import org.eclipse.ui.part.ViewPart;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.exception.FacadeException;
import br.com.dimag.safetycar.gui.views.NavigationView.TreeParent;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.Endereco;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ClienteView extends ViewPart {

	public static final String ID = "SafetyCar.client";
	private Group groupDadosPessoais;
	//ENDEREÇO RESIDENCIAL
	private Label labelEnderecoResidencial;
	private Text textEndereçoResidencial;
	//ENDEREÇO BAIRRO
	private Label labelEnderecoBairro;
	private Text textEndereçoBairro;
	
	private ListViewer listViewerAutomovel;
	private Group groupAutomovel;
	private Text textTelefone;
	private Label labelTelefone;
	private Button buttonCancelar;
	private Button buttonConfirma;
//	private Text textEndereço;
	private Label labelNomeCliente;
	private Text textNomeCliente;
	private Cliente cliente;
	private Endereco enderecoResidencial;
	
	@Override
	public void createPartControl(Composite composite) {
		{
			composite.setSize(198, 231);
			{
				groupDadosPessoais = new Group(composite, SWT.NONE);
				GridLayout dadosPessoaisLayout = new GridLayout();
				dadosPessoaisLayout.numColumns = 2;
				groupDadosPessoais.setLayout(dadosPessoaisLayout);
				groupDadosPessoais.setText("Dados Pessoais");
				groupDadosPessoais.setSize(243, 215);
				{
					labelNomeCliente = new Label(groupDadosPessoais, SWT.NONE);
					labelNomeCliente.setText("Nome:");
				}
				{
					textNomeCliente = new Text(groupDadosPessoais, SWT.NONE);
					GridData nomeClienteLData = new GridData();
					nomeClienteLData.heightHint = 13;
					nomeClienteLData.horizontalAlignment = GridData.FILL;
					nomeClienteLData.grabExcessHorizontalSpace = true;
					textNomeCliente.setLayoutData(nomeClienteLData);
				}
/* PARTE Q MODIFICAMOS DO ENDEREÇO
				{
					labelEndereco = new Label(groupDadosPessoais, SWT.NONE);
					labelEndereco.setText("Endereço:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.heightHint = 13;
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEndereço = new Text(groupDadosPessoais, SWT.NONE);
					textEndereço.setLayoutData(EndereçoLData);
				}
*/
// daki pra baixo Guto + Diego
				//LOGRADOURO
				{
					labelEnderecoResidencial = new Label(groupDadosPessoais, SWT.NONE);
					labelEnderecoResidencial.setText("Endereço Residencial:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.heightHint = 13;
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEndereçoResidencial = new Text(groupDadosPessoais, SWT.NONE);
					textEndereçoResidencial.setLayoutData(EndereçoLData);
				}
				
				//BAIRRO
				{
					labelEnderecoBairro = new Label(groupDadosPessoais, SWT.NONE);
					labelEnderecoBairro.setText("Bairro:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.heightHint = 13;
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEndereçoBairro = new Text(groupDadosPessoais, SWT.NONE);
					textEndereçoBairro.setLayoutData(EndereçoLData);
				}
				
// daki pra baixo Guto + Diego				
				{
					labelTelefone = new Label(groupDadosPessoais, SWT.NONE);
					labelTelefone.setText("Telefone:");
				}
				{
					GridData textTelefoneLData = new GridData();
					textTelefoneLData.grabExcessHorizontalSpace = true;
					textTelefoneLData.horizontalAlignment = GridData.FILL;
					textTelefone = new Text(groupDadosPessoais, SWT.NONE);
					textTelefone.setLayoutData(textTelefoneLData);
				}
				{
					buttonConfirma = new Button(groupDadosPessoais, SWT.PUSH | SWT.CENTER);
					buttonConfirma.setText("Confirmar");
					
					buttonConfirma.addSelectionListener(new SelectionListener(){
						
						@Override
						public void widgetSelected(SelectionEvent event) {
							performFinish();
						}

						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {
							// TODO Auto-generated method stub
						}
						
					});
				}
				{
					buttonCancelar = new Button(groupDadosPessoais, SWT.PUSH | SWT.CENTER);
					buttonCancelar.setText("Cancelar");
				}
				{
					groupAutomovel = new Group(groupDadosPessoais, SWT.NONE);
					GridLayout groupAutomovelLayout = new GridLayout();
					groupAutomovelLayout.makeColumnsEqualWidth = true;
					groupAutomovel.setLayout(groupAutomovelLayout);
					GridData groupAutomovelLData = new GridData();
					groupAutomovelLData.verticalAlignment = GridData.BEGINNING;
					groupAutomovelLData.horizontalAlignment = GridData.BEGINNING;
					groupAutomovelLData.horizontalSpan = 2;
					groupAutomovelLData.grabExcessHorizontalSpace = true;
					groupAutomovelLData.grabExcessVerticalSpace = true;
					groupAutomovelLData.heightHint = 74;
					groupAutomovel.setLayoutData(groupAutomovelLData);
					groupAutomovel.setText("Automóveis");
					{
						GridData listViewerAutomovelLData = new GridData();
						listViewerAutomovelLData.verticalAlignment = GridData.BEGINNING;
						listViewerAutomovelLData.horizontalAlignment = GridData.BEGINNING;
						listViewerAutomovelLData.grabExcessVerticalSpace = true;
						listViewerAutomovelLData.grabExcessHorizontalSpace = true;
						listViewerAutomovel = new ListViewer(groupAutomovel, SWT.NONE);
						listViewerAutomovel.getControl().setLayoutData(listViewerAutomovelLData);
						listViewerAutomovel.setContentProvider(new ViewContentProvider());
						listViewerAutomovel.setLabelProvider(new ViewLabelProvider());
						listViewerAutomovel.setInput(createModelAutomovel());
					}
				}
			}
		}
	}
	
	private List<Automovel> createModelAutomovel() {
		
		return Facade.getInstance().searchListAutomovel(cliente);
	}

	class ViewContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.getInput();
		}

		public void dispose() {
			
		}

		public Object[] getElements(Object parent) {
			List<Automovel> list = (List<Automovel> )parent;
			Automovel[] array = new Automovel[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Automovel automovel = list.get(i);
				array[i] = automovel;
			}
			
			return array;
		}

	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			Automovel automovel = (Automovel)obj;
			return automovel.getPlaca();
		}

		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					imageKey);
		}
	}

	@Override
	public void setFocus() {
		
	}

	private void performFinish() {
		//dados cliente
		cliente = new Cliente();
		
		cliente.setNomeRazaoSocial(textNomeCliente.getText());
		//endereço Cliente Residencial
		enderecoResidencial = new Endereco();
		enderecoResidencial.setLogradouro(textEndereçoResidencial.getText());
		enderecoResidencial.setBairro(textEndereçoBairro.getText());
		
		cliente.setEnderecoResidencial(enderecoResidencial);
		cliente.setTelefone(textTelefone.getText());
		
		try {
			Facade.getInstance().cadastrarCliente(cliente);
			this.getViewSite().getWorkbenchWindow().getActivePage().hideView(this);
		} catch (FacadeException e) {
			throw new RuntimeException(e);
		}
		
		
	}
}
