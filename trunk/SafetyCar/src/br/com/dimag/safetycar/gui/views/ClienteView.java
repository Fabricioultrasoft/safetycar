package br.com.dimag.safetycar.gui.views;


import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormData;
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
import br.com.dimag.safetycar.model.UF;
import br.com.dimag.safetycar.model.Endereco.TipoEndereco;

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
	//ENDEREÇO MUNICIPIO
	private Label labelEnderecoMunicipio;
	private Text textEndereçoMunicipio;
	//ENDEREÇO CEP
	private Label labelEnderecoCep;
	private Text textEndereçoCep;
	private CCombo cComboUf;
	private CCombo cComboTipoEndereco;
	private Label labelErro;
	private Label labelTipoEndereco;
	private Label labelUf;

	private Text textTelefone;
	private Label labelTelefone;
	private Button buttonCancelar;
	private Button buttonConfirma;
	private Label labelNomeCliente;
	private Text textNomeCliente;
	private Cliente cliente;
	private Endereco endereco;
	
	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(336, 231);
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
				{
					labelTipoEndereco = new Label(groupDadosPessoais, SWT.NONE);
					labelTipoEndereco.setText("Tipo Endereço:");
					GridData labelTipoEnderecoLData = new GridData();
					labelTipoEnderecoLData.verticalAlignment = GridData.BEGINNING;
					labelTipoEnderecoLData.horizontalAlignment = GridData.BEGINNING;
					labelTipoEndereco.setLayoutData(labelTipoEnderecoLData);
				}
				{
					cComboTipoEndereco = new CCombo(groupDadosPessoais, SWT.NONE);
					GridData cComboTipoEnderecoLData = new GridData();
					cComboTipoEnderecoLData.verticalAlignment = GridData.BEGINNING;
					cComboTipoEnderecoLData.horizontalAlignment = GridData.BEGINNING;
					cComboTipoEnderecoLData.grabExcessHorizontalSpace = true;
					cComboTipoEndereco.setLayoutData(cComboTipoEnderecoLData);
					cComboTipoEndereco.setText("cCombo1");
				}
				{
					labelEnderecoResidencial = new Label(groupDadosPessoais, SWT.NONE);
					labelEnderecoResidencial.setText("Endereço Residencial:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.horizontalAlignment = GridData.BEGINNING;
					EndereçoLData.verticalAlignment = GridData.BEGINNING;
					textEndereçoResidencial = new Text(groupDadosPessoais, SWT.MULTI);
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
				
				//MUNICIPIO
				{
					labelEnderecoMunicipio = new Label(groupDadosPessoais, SWT.NONE);
					labelEnderecoMunicipio.setText("Cidade:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.heightHint = 13;
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEndereçoMunicipio = new Text(groupDadosPessoais, SWT.NONE);
					textEndereçoMunicipio.setLayoutData(EndereçoLData);
				}
				
				//CEP
				{
					labelEnderecoCep = new Label(groupDadosPessoais, SWT.NONE);
					labelEnderecoCep.setText("Cidade:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.heightHint = 13;
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEndereçoCep = new Text(groupDadosPessoais, SWT.NONE);
					textEndereçoCep.setLayoutData(EndereçoLData);
				}
				// daki pra cima Guto + Diego				
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
					labelUf = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelUfLData = new GridData();
					labelUfLData.verticalAlignment = GridData.BEGINNING;
					labelUfLData.horizontalAlignment = GridData.BEGINNING;
					labelUf.setLayoutData(labelUfLData);
					labelUf.setText("UF:");
				}
				{
					cComboUf = new CCombo(groupDadosPessoais, SWT.NONE);
					cComboUf.setText("cComboUf");
				}
				{
					buttonConfirma = new Button(groupDadosPessoais, SWT.PUSH | SWT.CENTER);
					GridData buttonConfirmaLData = new GridData();
					buttonConfirmaLData.verticalAlignment = GridData.BEGINNING;
					buttonConfirmaLData.horizontalAlignment = GridData.BEGINNING;
					buttonConfirma.setLayoutData(buttonConfirmaLData);
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
					GridData buttonCancelarLData = new GridData();
					buttonCancelarLData.verticalAlignment = GridData.BEGINNING;
					buttonCancelarLData.horizontalAlignment = GridData.BEGINNING;
					buttonCancelar.setLayoutData(buttonCancelarLData);
					buttonCancelar.setText("Cancelar");
				}
				{
					labelErro = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelErroLData = new GridData();
					labelErroLData.verticalAlignment = GridData.BEGINNING;
					labelErroLData.horizontalAlignment = GridData.BEGINNING;
					labelErroLData.horizontalSpan = 2;
					labelErroLData.heightHint = 13;
					labelErro.setLayoutData(labelErroLData);
					labelErro.setText("label Erro");
				}
			}
		}
		loadData();
	}
	
	private void loadData() {
		// TODO Auto-generated method stub
		List<UF> listUFs = Facade.getInstance().carregarUfs();
		cComboUf.removeAll();
		for(UF uf : listUFs){
			cComboUf.setData(uf.getDescricao(),uf);
			cComboUf.add(uf.getDescricao());
		}	
		cComboTipoEndereco.removeAll();
		for(TipoEndereco tipo : TipoEndereco.values()){
			cComboTipoEndereco.setData(tipo.getDescricao(),tipo);
			cComboTipoEndereco.add(tipo.getDescricao());
		}
	}

	@Override
	public void setFocus() {
		
	}

	private void performFinish() {
		//dados cliente
		cliente = new Cliente();
		
		cliente.setNomeRazaoSocial(textNomeCliente.getText());
		
		String key;
		UF uf = null;
		if (cComboUf.getSelectionIndex() != -1){
			key = cComboUf.getItem(cComboUf.getSelectionIndex());
			uf = (UF) cComboUf.getData(key);
		}
		
		//endereço Cliente Residencial
		endereco = new Endereco();
		endereco.setLogradouro(textEndereçoResidencial.getText());
		endereco.setBairro(textEndereçoBairro.getText());
		endereco.setMunicipio(textEndereçoMunicipio.getText());
		endereco.setCep(textEndereçoCep.getText());
		endereco.setUf(uf);
		
		key = cComboTipoEndereco.getItem(cComboTipoEndereco.getSelectionIndex());
		TipoEndereco tipo = (TipoEndereco) cComboTipoEndereco.getData(key);
		
		if (tipo == TipoEndereco.COMERCIAL){
			cliente.setEnderecoComercial(endereco);
		}else if (tipo == TipoEndereco.RESIDENCIAL){
			cliente.setEnderecoResidencial(endereco);
		}
		cliente.setTelefone(textTelefone.getText());
		
		try {
			Facade.getInstance().cadastrarCliente(cliente);
			this.getViewSite().getWorkbenchWindow().getActivePage().hideView(this);
		} catch (Exception e) {
			labelErro.setText(e.getMessage());
			//throw new RuntimeException(e);
		}
		
		
	}
}
