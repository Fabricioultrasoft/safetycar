package br.com.dimag.safetycar.gui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.FacadeException;
import br.com.dimag.safetycar.exception.ValidatorException;
import br.com.dimag.safetycar.model.Produto;

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
public class ProdutoView extends BasicView {

	public static final String ID = "SafetyCar.produto";
	private Group groupDadosProduto;
	// MARCA
	private Label labelMarca;
	private Text textMarca;

	// VALOR UNITÁRIO
	private Label labelValorUnitario;
	private Text textValorUnitario;
	
	// LABEL ERROS
	private Label labelErro;
	
	// MODELO
	private Label labelModelo;
	private Text textModelo;

	//BOTÕES DE CONFIRMA E CANCELAR
	private Button buttonCancelar;
	private Button buttonConfirma;

	// EAN
 	private Label labelEAN;
	private Text textEAN;
	
	// DESCRIÇÃO
	private Label labelDescricao;
	private Text textDescricao;

	private Produto produto;


	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(484, 418);
			{
				groupDadosProduto = new Group(composite, SWT.NONE);
				GridLayout dadosPessoaisLayout = new GridLayout();
				dadosPessoaisLayout.numColumns = 2;
				groupDadosProduto.setLayout(dadosPessoaisLayout);
				groupDadosProduto.setText("Dados do Produto");
				groupDadosProduto.setSize(243, 215);
				
				
				// EAN - Código de Identificação do Produto - Exemplo BarCode

				{
					labelEAN = new Label(groupDadosProduto, SWT.NONE);
					GridData labelEANLData = new GridData();
					labelEANLData.horizontalAlignment = GridData.FILL;
					labelEAN.setLayoutData(labelEANLData);
					labelEAN.setText("EAN:");
				}
				{
					textEAN = new Text(groupDadosProduto, SWT.NONE);
					GridData eanProdutoLData = new GridData();
					eanProdutoLData.heightHint = 13;
					eanProdutoLData.horizontalAlignment = GridData.FILL;
					eanProdutoLData.grabExcessHorizontalSpace = true;
					textEAN.setLayoutData(eanProdutoLData);
				}

				// DESCRIÇÃO PRODUTO

				{
					labelDescricao = new Label(groupDadosProduto,
							SWT.NONE);
					labelDescricao.setText("Descrição:");
				}
				{
					textDescricao = new Text(groupDadosProduto, SWT.NONE);
					GridData descricaoProdutoLData = new GridData();
					descricaoProdutoLData.heightHint = 13;
					descricaoProdutoLData.horizontalAlignment = GridData.FILL;
					descricaoProdutoLData.grabExcessHorizontalSpace = true;
					textDescricao.setLayoutData(descricaoProdutoLData);
				}

				// MODELO PRODUTO
				{
					labelModelo = new Label(groupDadosProduto, SWT.NONE);
					labelModelo.setText("Modelo:");
				}
				{
					textModelo = new Text(groupDadosProduto, SWT.NONE);
					GridData modeloProdutoLData = new GridData();
					modeloProdutoLData.heightHint = 13;
					modeloProdutoLData.horizontalAlignment = GridData.FILL;
					modeloProdutoLData.grabExcessHorizontalSpace = true;
					textModelo.setLayoutData(modeloProdutoLData);
				}

				
				//MARCA PRODUTO
				{
					labelMarca = new Label(groupDadosProduto, SWT.NONE);
					labelMarca.setText("Marca:");
				}
				{
					GridData marcaProdutoLData = new GridData();
					marcaProdutoLData.horizontalAlignment = GridData.FILL;
					marcaProdutoLData.widthHint = 149;
					marcaProdutoLData.heightHint = 13;
					marcaProdutoLData.grabExcessHorizontalSpace = true;
					textMarca = new Text(groupDadosProduto, SWT.NONE);
					textMarca.setLayoutData(marcaProdutoLData);
				}

				// VALOR UNITÁRIO
				{
					labelValorUnitario = new Label(groupDadosProduto,
							SWT.NONE);
					labelValorUnitario.setText("Valor Unitário (R$):");
				}
				{
					GridData valorUnitarioProdutoLData = new GridData();
					valorUnitarioProdutoLData.heightHint = 13;
					valorUnitarioProdutoLData.horizontalAlignment = GridData.FILL;
					valorUnitarioProdutoLData.grabExcessHorizontalSpace = true;
					textValorUnitario = new Text(groupDadosProduto, SWT.NONE);
					textValorUnitario.setLayoutData(valorUnitarioProdutoLData);
				}

				//view BOTÃO CONFIRMA
				{
					buttonConfirma = new Button(groupDadosProduto, SWT.PUSH
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
				//view BOTÃO CANCELAR
				{
					buttonCancelar = new Button(groupDadosProduto, SWT.PUSH
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
									if (isUpdate){ 
									openView(ProdutoListView.ID);
									}
									
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
					labelErro = new Label(groupDadosProduto, SWT.NONE);
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
		isUpdate=false;
		

	}
	
	//Obrigatório
	@Override
	public void setFocus() {

	}

	private void performFinish() {
		// dados cliente

		try {
			if (isUpdate) {
				fillProduto();
				Facade.getInstance().atualizarProduto(produto);
				openView(ProdutoListView.ID);
				
			} else {
				produto = new Produto();
				fillProduto();
						Facade.getInstance().cadastrarProduto(produto);
			}
			closeView();
		} catch (FacadeException e) {
			labelErro.setText(e.getMessage());
		} catch (ValidatorException e) {
			labelErro.setText(e.getMessage());
		} catch (DadosInsuficientesException e) {
			// TODO Auto-generated catch block
			labelErro.setText(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			labelErro.setText(e.getMessage());
		} finally{
			if (!isUpdate){
				produto = null;
			}
		}

	}

	private void fillProduto() throws ValidatorException {
		//SET EAN
		if (textEAN.getText() == null || textEAN.getText().equals("")){
			throw new ValidatorException("O Campo EAN é obrigatório!");
		}
		if (textEAN.getText().length() > 13){
			throw new ValidatorException("O Campo EAN aceita até 13 dígitos!");
		}
		produto.setEAN(textEAN.getText());
		
		//SET DESCRIÇÃO
		if (textDescricao.getText() == null || textDescricao.getText().equals("")){
			throw new ValidatorException("O Campo Descrição é obrigatório!");
		}
		produto.setDescricao(textDescricao.getText());
		
		
		//SET MODELO
		if (textModelo.getText() == null || textModelo.getText().equals("")){
			throw new ValidatorException("O Campo Modelo é obrigatório!");
		}
		produto.setModelo(textModelo.getText());
		
		//Set MARCA
		if (textMarca.getText() == null || textMarca.getText().equals("")){
			throw new ValidatorException("O Campo Marca é obrigatório!");
		}
		produto.setMarca(textMarca.getText());
		
		//Set VALOR UNITÁRIO
		if (textValorUnitario.getText() == null || textValorUnitario.getText().equals("")){
			throw new ValidatorException("O Valor Unitário é obrigatório! (Preço por unidade) Ex: 132.59");
		}
		//Validação VALOR UNITÁRIO de digitação de valor numérico
		try{
		produto.setValorUnitario(Double.parseDouble(textValorUnitario.getText()));
		} catch (Exception e) {
			// TODO: handle exception
			throw new ValidatorException("O Valor Unitário (R$) é de Formato Numérico obrigatório!(Utilize . ) Ex: 132.59");	
		}
	}

	public void loadProduto(Produto produto) {
		isUpdate=true;
		this.produto = produto;
		
		if (this.produto.getEAN() != null){
			textEAN.setText(this.produto.getEAN());
		}

		if (this.produto.getDescricao() != null){
			textDescricao.setText(this.produto.getDescricao());
		}

		if (this.produto.getModelo() != null) {
			textModelo.setText(this.produto.getModelo());
		}

		if (this.produto.getMarca() != null){
			textMarca.setText(this.produto.getMarca());
		}
		//testar necessidade deste if
		if (this.produto.getValorUnitario()!= 0){
			textValorUnitario.setText(String.valueOf(this.produto.getValorUnitario()));
		}
	}
}
