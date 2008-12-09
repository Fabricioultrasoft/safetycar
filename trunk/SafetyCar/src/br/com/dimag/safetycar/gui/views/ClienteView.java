package br.com.dimag.safetycar.gui.views;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.exception.FacadeException;
import br.com.dimag.safetycar.exception.ValidatorException;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.Endereco;
import br.com.dimag.safetycar.model.UF;
import br.com.dimag.safetycar.model.Endereco.TipoEndereco;
import br.com.dimag.safetycar.model.Pessoa.TipoPessoa;

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
public class ClienteView extends BasicView {

	public static final String ID = "SafetyCar.client";
	private Group groupDadosPessoais;
	// ENDERE�O
	private Label labelEndereco;
	private Text textEndereco;

	// ENDERE�O BAIRRO
	private Label labelEnderecoBairro;
	private Text textEnderecoBairro;
	// ENDERE�O MUNICIPIO
	private Label labelEnderecoMunicipio;
	private Text textEnderecoMunicipio;
	// ENDERE�O CEP
	private Label labelEnderecoCep;
	private Text textEnderecoCep;
	// CCOMBO UF
	private CCombo cComboUf;
	private Label labelUf;
	// CCOMBO TIPO ENDERE�O
	private CCombo cComboTipoEndereco;
	private Label labelTipoEndereco;
	// LABEL ERROS
	private Label labelErro;
	// CPF CNPJ
	private Label labelCpfCnpj;
	private Text textCpfCnpj;

	//TELEFONE
	private Text textTelefone;
	private Label labelTelefone;
	
	//TELEFONE COMERCIAL
	private Text textTelefoneComercial;
	private Label labelTelefoneComercial;
	
	//TELEFONE CELULAR
	private Text textTelefoneCelular;
	private Label labelTelefoneCelular;
	
	//BOT�ES DE CONFIRMA E CANCELAR
	private Button buttonCancelar;
	private Button buttonConfirma;

	// CCOMBO TIPOPESSOA
	private CCombo cComboTipoPessoa;
	private Label labelTipoPessoa;

	// NOME - RAZ�O SOCIAL
	private Label labelNomeCliente;
	private Text textNomeCliente;
	// NOME APELIDO - NOME FANTASIA
	private Label labelApelidoFantasia;
	private Text textApelidoFantasia;

	private Cliente cliente;
	private Endereco endereco;

	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(484, 418);
			{
				groupDadosPessoais = new Group(composite, SWT.NONE);
				GridLayout dadosPessoaisLayout = new GridLayout();
				dadosPessoaisLayout.numColumns = 2;
				groupDadosPessoais.setLayout(dadosPessoaisLayout);
				groupDadosPessoais.setText("Dados Pessoais");
				groupDadosPessoais.setSize(243, 215);
				
				//TIPO PESSOA
				{
					labelTipoPessoa = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelUfLData = new GridData();
					labelUfLData.horizontalAlignment = GridData.FILL;
					labelTipoPessoa.setLayoutData(labelUfLData);
					labelTipoPessoa.setText("Tipo Pessoa:");
				}
				{
					cComboTipoPessoa = new CCombo(groupDadosPessoais, SWT.NONE);
					GridData cComboUfLData = new GridData();
					cComboUfLData.horizontalAlignment = GridData.FILL;
					cComboUfLData.grabExcessHorizontalSpace = true;
					cComboUfLData.widthHint = 155;
					cComboUfLData.heightHint = 16;
					cComboTipoPessoa.setLayoutData(cComboUfLData);
				}
				
				// NOME CLIENTE - RAZ�O SOCIAL

				{
					labelNomeCliente = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelNomeClienteLData = new GridData();
					labelNomeClienteLData.horizontalAlignment = GridData.FILL;
					labelNomeCliente.setLayoutData(labelNomeClienteLData);
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

				// APELIDO-NOME FANTASIA

				{
					labelApelidoFantasia = new Label(groupDadosPessoais,
							SWT.NONE);
					labelApelidoFantasia.setText("Apelido/Nome Fantasia:");
				}
				{
					textApelidoFantasia = new Text(groupDadosPessoais, SWT.NONE);
					GridData nomeClienteLData = new GridData();
					nomeClienteLData.heightHint = 13;
					nomeClienteLData.horizontalAlignment = GridData.FILL;
					nomeClienteLData.grabExcessHorizontalSpace = true;
					textApelidoFantasia.setLayoutData(nomeClienteLData);
				}

				// CPF CNPJ
				{
					labelCpfCnpj = new Label(groupDadosPessoais, SWT.NONE);
					labelCpfCnpj.setText("CPF/CNPJ:");
				}
				{
					textCpfCnpj = new Text(groupDadosPessoais, SWT.NONE);
					GridData nomeClienteLData = new GridData();
					nomeClienteLData.heightHint = 13;
					nomeClienteLData.horizontalAlignment = GridData.FILL;
					nomeClienteLData.grabExcessHorizontalSpace = true;
					textCpfCnpj.setLayoutData(nomeClienteLData);
				}

				// CCOMBO TIPO ENDERE�O
				{
					labelTipoEndereco = new Label(groupDadosPessoais, SWT.NONE);
					labelTipoEndereco.setText("Tipo Endere�o:");
					GridData labelTipoEnderecoLData = new GridData();
					labelTipoEnderecoLData.horizontalAlignment = GridData.FILL;
					labelTipoEndereco.setLayoutData(labelTipoEnderecoLData);
				}
				{
					cComboTipoEndereco = new CCombo(groupDadosPessoais,
							SWT.NONE);
					GridData cComboTipoEnderecoLData = new GridData();
					cComboTipoEnderecoLData.horizontalAlignment = GridData.FILL;
					cComboTipoEnderecoLData.grabExcessHorizontalSpace = true;
					cComboTipoEnderecoLData.heightHint = 16;
					cComboTipoEnderecoLData.widthHint = 155;
					cComboTipoEndereco.setLayoutData(cComboTipoEnderecoLData);
				}
				//LOGRADOURO
				{
					labelEndereco = new Label(groupDadosPessoais, SWT.NONE);
					labelEndereco.setText("Endere�o:");
				}
				{
					GridData Endere�oLData = new GridData();
					Endere�oLData.horizontalAlignment = GridData.FILL;
					Endere�oLData.widthHint = 149;
					Endere�oLData.heightHint = 13;
					Endere�oLData.grabExcessHorizontalSpace = true;
					textEndereco = new Text(groupDadosPessoais, SWT.NONE);
					textEndereco.setLayoutData(Endere�oLData);
				}

				// BAIRRO
				{
					labelEnderecoBairro = new Label(groupDadosPessoais,
							SWT.NONE);
					labelEnderecoBairro.setText("Bairro:");
				}
				{
					GridData Endere�oLData = new GridData();
					Endere�oLData.heightHint = 13;
					Endere�oLData.horizontalAlignment = GridData.FILL;
					Endere�oLData.grabExcessHorizontalSpace = true;
					textEnderecoBairro = new Text(groupDadosPessoais, SWT.NONE);
					textEnderecoBairro.setLayoutData(Endere�oLData);
				}

				// MUNICIPIO
				{
					labelEnderecoMunicipio = new Label(groupDadosPessoais,
							SWT.NONE);
					labelEnderecoMunicipio.setText("Cidade:");
				}
				{
					GridData Endere�oLData = new GridData();
					Endere�oLData.heightHint = 13;
					Endere�oLData.horizontalAlignment = GridData.FILL;
					Endere�oLData.grabExcessHorizontalSpace = true;
					textEnderecoMunicipio = new Text(groupDadosPessoais,
							SWT.NONE);
					textEnderecoMunicipio.setLayoutData(Endere�oLData);
				}

				// CEP
				{
					labelEnderecoCep = new Label(groupDadosPessoais, SWT.NONE);
					labelEnderecoCep.setText("Cep:");
				}
				{
					GridData Endere�oLData = new GridData();
					Endere�oLData.heightHint = 13;
					Endere�oLData.horizontalAlignment = GridData.FILL;
					Endere�oLData.grabExcessHorizontalSpace = true;
					textEnderecoCep = new Text(groupDadosPessoais, SWT.NONE);
					textEnderecoCep.setLayoutData(Endere�oLData);
				}
				
				//LABEL UF
				{
					labelUf = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelUfLData = new GridData();
					labelUfLData.horizontalAlignment = GridData.FILL;
					labelUf.setLayoutData(labelUfLData);
					labelUf.setText("UF:");
				}
				//CCOMBO UF
				{
					cComboUf = new CCombo(groupDadosPessoais, SWT.NONE);
					GridData cComboUfLData = new GridData();
					cComboUfLData.horizontalAlignment = GridData.FILL;
					cComboUfLData.grabExcessHorizontalSpace = true;
					cComboUfLData.widthHint = 155;
					cComboUfLData.heightHint = 16;
					cComboUfLData.verticalAlignment = GridData.BEGINNING;
					cComboUf.setLayoutData(cComboUfLData);
				}
				// TELEFONE
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
				
				// TELEFONE COMERCIAL
				{
					labelTelefoneComercial = new Label(groupDadosPessoais, SWT.NONE);
					labelTelefoneComercial.setText("Telefone Comercial:");
				}
				{
					GridData textTelefoneLData = new GridData();
					textTelefoneLData.grabExcessHorizontalSpace = true;
					textTelefoneLData.horizontalAlignment = GridData.FILL;
					textTelefoneComercial = new Text(groupDadosPessoais, SWT.NONE);
					textTelefoneComercial.setLayoutData(textTelefoneLData);
				}
				
				// TELEFONE CELULAR
				{
					labelTelefoneCelular = new Label(groupDadosPessoais, SWT.NONE);
					labelTelefoneCelular.setText("Telefone Celular:");
				}
				{
					GridData textTelefoneLData = new GridData();
					textTelefoneLData.grabExcessHorizontalSpace = true;
					textTelefoneLData.horizontalAlignment = GridData.FILL;
					textTelefoneCelular = new Text(groupDadosPessoais, SWT.NONE);
					textTelefoneCelular.setLayoutData(textTelefoneLData);
				}
	

				// CCOMBO TIPOPESSOA
				//view BOT�O CONFIRMA
				{
					buttonConfirma = new Button(groupDadosPessoais, SWT.PUSH
							| SWT.CENTER);
					GridData buttonConfirmaLData = new GridData();
					buttonConfirmaLData.verticalAlignment = GridData.BEGINNING;
					buttonConfirmaLData.horizontalAlignment = GridData.BEGINNING;
					buttonConfirma.setLayoutData(buttonConfirmaLData);
					buttonConfirma.setText("Confirmar");

					buttonConfirma
							.addSelectionListener(new SelectionListener() {

								@Override
								public void widgetSelected(SelectionEvent event) {
									performFinish();
								}

								@Override
								public void widgetDefaultSelected(
										SelectionEvent arg0) {
									// TODO Auto-generated method stub
								}

							});
				}
				//view BOT�O CANCELAR
				{
					buttonCancelar = new Button(groupDadosPessoais, SWT.PUSH
							| SWT.CENTER);
					GridData buttonCancelarLData = new GridData();
					buttonCancelarLData.verticalAlignment = GridData.BEGINNING;
					buttonCancelarLData.horizontalAlignment = GridData.BEGINNING;
					buttonCancelar.setLayoutData(buttonCancelarLData);
					buttonCancelar.setText("Cancelar");

					buttonCancelar
							.addSelectionListener(new SelectionListener() {

								@Override
								public void widgetSelected(SelectionEvent event) {
									closeView();
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
					labelErro = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelErroLData = new GridData();
					labelErroLData.horizontalAlignment = GridData.FILL;
					labelErroLData.horizontalSpan = 2;
					labelErroLData.grabExcessHorizontalSpace = true;
					labelErroLData.widthHint = 319;
					labelErroLData.heightHint = 26;
					labelErro.setLayoutData(labelErroLData);
					labelErro.setText("");
				}
			}
		}
		loadData();
	}

	private void loadData() {

		// UF
		List<UF> listUFs = Facade.getInstance().listUf();
		cComboUf.removeAll();
		for (UF uf : listUFs) {
			cComboUf.setData(uf.getDescricao(), uf);
			cComboUf.add(uf.getDescricao());
		}
		// TIPO ENDERE�O
		cComboTipoEndereco.removeAll();
		for (TipoEndereco tipo : TipoEndereco.values()) {
			cComboTipoEndereco.setData(tipo.getDescricao(), tipo);
			cComboTipoEndereco.add(tipo.getDescricao());
		}
		// TIPO PESSOA
		cComboTipoPessoa.removeAll();
		for (TipoPessoa tipo : TipoPessoa.values()) {
			cComboTipoPessoa.setData(tipo.getDescricao(), tipo);
			cComboTipoPessoa.add(tipo.getDescricao());
		}

	}
	
	//Obrigat�rio
	@Override
	public void setFocus() {

	}

	private void performFinish() {
		// dados cliente

		try {
			if (cliente == null) {
				cliente = new Cliente();
				fillCliente();
				Facade.getInstance().cadastrarCliente(cliente);
			} else {
				fillCliente();
				Facade.getInstance().atualizarCliente(cliente);
				openView(ClienteListView.ID);
			}
			closeView();
		} catch (FacadeException e) {
			labelErro.setText(e.getMessage());
		} catch (ValidatorException e) {
			labelErro.setText(e.getMessage());
		}

	}

	private void fillCliente() throws ValidatorException {
		//SET NOME RAZAOSOCIAL
		if (textNomeCliente.getText() == null || textNomeCliente.getText().equals("")){
			throw new ValidatorException("O Campo Nome Cliente � obrigat�rio");
		}
		cliente.setNomeRazaoSocial(textNomeCliente.getText());
		
		//SET APELIDOFANTASIA PODE SER NULO
		cliente.setApelidoFantasia(textApelidoFantasia.getText());
		cliente.setCpfCnpj(textCpfCnpj.getText());

		String key;
		UF uf = null;
		if (cComboUf.getSelectionIndex() != -1) {
			key = cComboUf.getItem(cComboUf.getSelectionIndex());
			uf = (UF) cComboUf.getData(key);
		}

		// tipo Endere�o
		key = cComboTipoEndereco
				.getItem(cComboTipoEndereco.getSelectionIndex());
		TipoEndereco tipo = (TipoEndereco) cComboTipoEndereco.getData(key);

		//Instancia endere�o e sets
		endereco = new Endereco();
		endereco.setLogradouro(textEndereco.getText());
		endereco.setBairro(textEnderecoBairro.getText());
		endereco.setMunicipio(textEnderecoMunicipio.getText());
		endereco.setCep(textEnderecoCep.getText());
		endereco.setTipoEndereco(tipo);
		endereco.setUf(uf);
		
		//set Endere�o
		cliente.setEndereco(endereco);

		// tipo Pessoa
		key = cComboTipoPessoa.getItem(cComboTipoPessoa.getSelectionIndex());
		cliente.setTipoPessoa((TipoPessoa) cComboTipoPessoa.getData(key));
		
		//TELEFONE
		cliente.setTelefone(textTelefone.getText());

		//TELEFONE COMERCIAL
		cliente.setTelefoneComercial(textTelefoneComercial.getText());
	
		//TELEFONE CELULAR
		cliente.setTelefoneCelular(textTelefoneCelular.getText());
	}

	public void loadCliente(Cliente cliente) {
		this.cliente = cliente;

		cComboTipoPessoa.setText(this.cliente.getTipoPessoa().getDescricao());
		if (this.cliente.getNomeRazaoSocial() != null){
			textNomeCliente.setText(this.cliente.getNomeRazaoSocial());
		}
		if (this.cliente.getApelidoFantasia() != null){
			textApelidoFantasia.setText(this.cliente.getApelidoFantasia());
		}
		if (this.cliente.getCpfCnpj() != null) {
			textCpfCnpj.setText(this.cliente.getCpfCnpj());
		}
			cComboTipoEndereco.setText(this.cliente.getEndereco().getTipoEndereco()
				.getDescricao());
		if (this.cliente.getEndereco().getLogradouro() != null){
			textEndereco.setText(this.cliente.getEndereco().getLogradouro());
		}
		if (this.cliente.getEndereco().getBairro() != null){
			textEnderecoBairro.setText(this.cliente.getEndereco().getBairro());
		}
		if (this.cliente.getEndereco().getMunicipio() != null){
			textEnderecoMunicipio
				.setText(this.cliente.getEndereco().getMunicipio());
		}
		if (this.cliente.getEndereco().getCep() != null){
			textEnderecoCep.setText(this.cliente.getEndereco().getCep());
		}
		cComboUf.setText(this.cliente.getEndereco().getUf().getDescricao());
		if (this.cliente.getTelefone() != null) {
			textTelefone.setText(this.cliente.getTelefone());
		}
		if (this.cliente.getTelefoneComercial() != null){
			textTelefoneComercial.setText(this.cliente.getTelefoneComercial());
		}
		if (this.cliente.getTelefoneCelular() != null){
			textTelefoneCelular.setText(this.cliente.getTelefoneCelular());
		}
	}
}
