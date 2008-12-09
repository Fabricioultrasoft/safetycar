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
	// ENDEREÇO
	private Label labelEndereco;
	private Text textEndereco;

	// ENDEREÇO BAIRRO
	private Label labelEnderecoBairro;
	private Text textEnderecoBairro;
	// ENDEREÇO MUNICIPIO
	private Label labelEnderecoMunicipio;
	private Text textEnderecoMunicipio;
	// ENDEREÇO CEP
	private Label labelEnderecoCep;
	private Text textEnderecoCep;
	// CCOMBO UF
	private CCombo cComboUf;
	private Label labelUf;
	// CCOMBO TIPO ENDEREÇO
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
	
	//BOTÕES DE CONFIRMA E CANCELAR
	private Button buttonCancelar;
	private Button buttonConfirma;

	// CCOMBO TIPOPESSOA
	private CCombo cComboTipoPessoa;
	private Label labelTipoPessoa;

	// NOME - RAZÃO SOCIAL
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
			composite.setSize(484, 291);
			{
				groupDadosPessoais = new Group(composite, SWT.NONE);
				GridLayout dadosPessoaisLayout = new GridLayout();
				dadosPessoaisLayout.numColumns = 2;
				groupDadosPessoais.setLayout(dadosPessoaisLayout);
				groupDadosPessoais.setText("Dados Pessoais");
				groupDadosPessoais.setSize(243, 215);
				{
					labelTipoPessoa = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelUfLData = new GridData();
					labelUfLData.horizontalAlignment = GridData.BEGINNING;
					labelUfLData.verticalAlignment = GridData.BEGINNING;
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
					cComboUfLData.verticalAlignment = GridData.BEGINNING;
					cComboTipoPessoa.setLayoutData(cComboUfLData);
				}
				
				// NOME CLIENTE - RAZÃO SOCIAL

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

				// OK
				{
					labelTipoEndereco = new Label(groupDadosPessoais, SWT.NONE);
					labelTipoEndereco.setText("Tipo Endereço:");
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
				{
					labelEndereco = new Label(groupDadosPessoais, SWT.NONE);
					labelEndereco.setText("Endereço:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.widthHint = 149;
					EndereçoLData.heightHint = 13;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEndereco = new Text(groupDadosPessoais, SWT.NONE);
					textEndereco.setLayoutData(EndereçoLData);
				}

				// BAIRRO
				{
					labelEnderecoBairro = new Label(groupDadosPessoais,
							SWT.NONE);
					labelEnderecoBairro.setText("Bairro:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.heightHint = 13;
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEnderecoBairro = new Text(groupDadosPessoais, SWT.NONE);
					textEnderecoBairro.setLayoutData(EndereçoLData);
				}

				// MUNICIPIO
				{
					labelEnderecoMunicipio = new Label(groupDadosPessoais,
							SWT.NONE);
					labelEnderecoMunicipio.setText("Cidade:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.heightHint = 13;
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEnderecoMunicipio = new Text(groupDadosPessoais,
							SWT.NONE);
					textEnderecoMunicipio.setLayoutData(EndereçoLData);
				}

				// CEP
				{
					labelEnderecoCep = new Label(groupDadosPessoais, SWT.NONE);
					labelEnderecoCep.setText("Cep:");
				}
				{
					GridData EndereçoLData = new GridData();
					EndereçoLData.heightHint = 13;
					EndereçoLData.horizontalAlignment = GridData.FILL;
					EndereçoLData.grabExcessHorizontalSpace = true;
					textEnderecoCep = new Text(groupDadosPessoais, SWT.NONE);
					textEnderecoCep.setLayoutData(EndereçoLData);
				}
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
				// CCOMBO UF

				// CCOMBO TIPOPESSOA

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

		if (cliente != null) {
			String s = "";
			s.substring(0);
		}

		// UF
		List<UF> listUFs = Facade.getInstance().carregarUfs();
		cComboUf.removeAll();
		for (UF uf : listUFs) {
			cComboUf.setData(uf.getDescricao(), uf);
			cComboUf.add(uf.getDescricao());
		}
		// TIPO ENDEREÇO
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
			// throw new RuntimeException(e);
		}

	}

	private void fillCliente() {
		cliente.setNomeRazaoSocial(textNomeCliente.getText());
		cliente.setApelidoFantasia(textApelidoFantasia.getText());
		cliente.setCpfCnpj(textCpfCnpj.getText());

		String key;
		UF uf = null;
		if (cComboUf.getSelectionIndex() != -1) {
			key = cComboUf.getItem(cComboUf.getSelectionIndex());
			uf = (UF) cComboUf.getData(key);
		}

		// tipo Endereço
		key = cComboTipoEndereco
				.getItem(cComboTipoEndereco.getSelectionIndex());
		TipoEndereco tipo = (TipoEndereco) cComboTipoEndereco.getData(key);

		// endereço Cliente
		endereco = new Endereco();
		endereco.setLogradouro(textEndereco.getText());
		endereco.setBairro(textEnderecoBairro.getText());
		endereco.setMunicipio(textEnderecoMunicipio.getText());
		endereco.setCep(textEnderecoCep.getText());
		endereco.setTipoEndereco(tipo);
		endereco.setUf(uf);

		cliente.setEndereco(endereco);

		// tipo Pessoa
		key = cComboTipoPessoa.getItem(cComboTipoPessoa.getSelectionIndex());
		cliente.setTipoPessoa((TipoPessoa) cComboTipoPessoa.getData(key));

		cliente.setTelefone(textTelefone.getText());
	}

	public void loadCliente(Cliente cliente) {
		this.cliente = cliente;

		cComboTipoPessoa.setText(this.cliente.getTipoPessoa().getDescricao());
		textNomeCliente.setText(this.cliente.getNomeRazaoSocial());
		textApelidoFantasia.setText(this.cliente.getApelidoFantasia());
		textCpfCnpj.setText(this.cliente.getCpfCnpj());
		cComboTipoEndereco.setText(this.cliente.getEndereco().getTipoEndereco()
				.getDescricao());
		textEndereco.setText(this.cliente.getEndereco().getLogradouro());
		textEnderecoBairro.setText(this.cliente.getEndereco().getBairro());
		textEnderecoMunicipio
				.setText(this.cliente.getEndereco().getMunicipio());
		textEnderecoCep.setText(this.cliente.getEndereco().getCep());
		cComboUf.setText(this.cliente.getEndereco().getUf().getDescricao());
		textTelefone.setText(this.cliente.getTelefone());

	}
}
