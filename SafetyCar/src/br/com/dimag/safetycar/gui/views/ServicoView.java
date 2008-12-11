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
public class ServicoView extends BasicView {

	public static final String ID = "SafetyCar.servico";
	private Group groupDadosServico;

	// VALOR UNITÁRIO
	private Label labelValorServico;
	private Text textValorServico;

	// DESCRIÇÃO
	private Label labelDescricao;
	private Text textDescricao;
	
	// LABEL ERROS
	private Label labelErro;
	
	//BOTÕES DE CONFIRMA E CANCELAR
	private Button buttonCancelar;
	private Button buttonConfirma;
	

	private Servico servico;


	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(484, 418);
			{
				groupDadosServico = new Group(composite, SWT.NONE);
				GridLayout dadosServicoLayout = new GridLayout();
				dadosServicoLayout.numColumns = 2;
				groupDadosServico.setLayout(dadosServicoLayout);
				groupDadosServico.setText("Dados do Serviço");
				groupDadosServico.setSize(243, 215);
				
				// DESCRIÇÃO SERVIÇO

				{
					labelDescricao = new Label(groupDadosServico,
							SWT.NONE);
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

				// VALOR SERVIÇO
				{
					labelValorServico = new Label(groupDadosServico,
							SWT.NONE);
					labelValorServico.setText("Valor Serviço (R$):");
				}
				{
					GridData valorUnitarioProdutoLData = new GridData();
					valorUnitarioProdutoLData.heightHint = 13;
					valorUnitarioProdutoLData.horizontalAlignment = GridData.FILL;
					valorUnitarioProdutoLData.grabExcessHorizontalSpace = true;
					textValorServico = new Text(groupDadosServico, SWT.NONE);
					textValorServico.setLayoutData(valorUnitarioProdutoLData);
				}

				//view BOTÃO CONFIRMA
				{
					buttonConfirma = new Button(groupDadosServico, SWT.PUSH
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
					buttonCancelar = new Button(groupDadosServico, SWT.PUSH
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
										openView(ServicoListView.ID);
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
		// dados servico

		try {
			if (isUpdate) {
				fillServico();
				Facade.getInstance().atualizarServico(servico);
				openView(ServicoListView.ID);
				
			} else {
				servico = new Servico();
				fillServico();
						Facade.getInstance().cadastrarServico(servico);
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
				servico = null;
			}
		}

	}

	private void fillServico() throws ValidatorException {
		//SET DESCRIÇÃO
		if (textDescricao.getText() == null || textDescricao.getText().equals("")){
			throw new ValidatorException("O Campo Descrição é obrigatório!");
		}
		servico.setDescricao(textDescricao.getText());
		
		//Set VALOR Serviço
		if (textValorServico.getText() == null || textValorServico.getText().equals("")){
			throw new ValidatorException("O Valor Serviço é obrigatório! Ex: 132.59");
		}
		//Validação VALOR Serviço de digitação de valor numérico
		try{
		servico.setValorServico(Double.parseDouble(textValorServico.getText()));
		} catch (Exception e) {
			// TODO: handle exception
			throw new ValidatorException("O Valor Serviço (R$) é de Formato Numérico obrigatório!(Utilize . ) Ex: 132.59");	
		}
	}

	public void loadServico(Servico servico) {
		isUpdate=true;
		this.servico = servico;
		
		if (this.servico.getDescricao() != null){
			textDescricao.setText(this.servico.getDescricao());
		}
		//testar necessidade deste if
		if (this.servico.getValorServico()!= 0){
			textValorServico.setText(String.valueOf(this.servico.getValorServico()));
		}
	}
}
