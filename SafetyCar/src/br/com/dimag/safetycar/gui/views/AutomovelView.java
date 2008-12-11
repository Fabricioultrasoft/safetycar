package br.com.dimag.safetycar.gui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
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
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.exception.ValidatorException;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Automovel.TipoCombustivel;

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
public class AutomovelView extends BasicView {

	public static final String ID = "SafetyCar.automovel";
	private Group groupDadosAutomoveis;
	// PLACA
	private Label labelPlaca;
	private Text textPlaca;

	// Modelo
	private Label labelModelo;
	private Text textModelo;

	// Marca
	private Label labelMarca;
	private Text textMarca;

	// COR
	private Label labelCor;
	private Text textCor;

	// ANO
	private Label labelAno;
	private Text textAno;

	// CHASSI
	private Label labelChassi;
	private Text textChassi;

	// CCOMBO TIPO COMBUSTIVEL
	private CCombo cComboTipoCombustivel;
	private Label labelTipoCombustivel;

	// LABEL ERROS
	private Label labelErro;

	// BOTÕES DE CONFIRMA E CANCELAR
	private Button buttonCancelar;
	private Button buttonConfirma;

	private Automovel automovel;

	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(484, 418);
			{
				groupDadosAutomoveis = new Group(composite, SWT.NONE);
				GridLayout dadosAutomoveisLayout = new GridLayout();
				dadosAutomoveisLayout.numColumns = 2;
				groupDadosAutomoveis.setLayout(dadosAutomoveisLayout);
				groupDadosAutomoveis.setText("Dados Automoveis");
				groupDadosAutomoveis.setSize(243, 215);

				// placa
				{
					labelPlaca = new Label(groupDadosAutomoveis, SWT.NONE);
					GridData labelPlacaLData = new GridData();
					labelPlacaLData.horizontalAlignment = GridData.FILL;
					labelPlaca.setLayoutData(labelPlacaLData);
					labelPlaca.setText("Placa:");
				}
				{
					textPlaca = new Text(groupDadosAutomoveis, SWT.NONE);
					GridData placaLData = new GridData();
					placaLData.heightHint = 13;
					placaLData.horizontalAlignment = GridData.FILL;
					placaLData.grabExcessHorizontalSpace = true;
					textPlaca.setLayoutData(placaLData);
				}

				// MODELO

				{
					labelModelo = new Label(groupDadosAutomoveis, SWT.NONE);
					GridData labelModeloLData = new GridData();
					labelModeloLData.horizontalAlignment = GridData.FILL;
					labelModelo.setLayoutData(labelModeloLData);
					labelModelo.setText("Modelo:");
				}
				{
					textModelo = new Text(groupDadosAutomoveis, SWT.NONE);
					GridData modeloLData = new GridData();
					modeloLData.heightHint = 13;
					modeloLData.horizontalAlignment = GridData.FILL;
					modeloLData.grabExcessHorizontalSpace = true;
					textModelo.setLayoutData(modeloLData);
				}
				// MARCA

				{
					labelMarca = new Label(groupDadosAutomoveis, SWT.NONE);
					GridData labelMarcaLData = new GridData();
					labelMarcaLData.horizontalAlignment = GridData.FILL;
					labelMarca.setLayoutData(labelMarcaLData);
					labelMarca.setText("Marca:");
				}
				{
					textMarca = new Text(groupDadosAutomoveis, SWT.NONE);
					GridData marcaLData = new GridData();
					marcaLData.heightHint = 13;
					marcaLData.horizontalAlignment = GridData.FILL;
					marcaLData.grabExcessHorizontalSpace = true;
					textMarca.setLayoutData(marcaLData);
				}

				// COR

				{
					labelCor = new Label(groupDadosAutomoveis, SWT.NONE);
					GridData labelCorLData = new GridData();
					labelCorLData.horizontalAlignment = GridData.FILL;
					labelCor.setLayoutData(labelCorLData);
					labelCor.setText("Cor:");
				}
				{
					textCor = new Text(groupDadosAutomoveis, SWT.NONE);
					GridData corLData = new GridData();
					corLData.heightHint = 13;
					corLData.horizontalAlignment = GridData.FILL;
					corLData.grabExcessHorizontalSpace = true;
					textCor.setLayoutData(corLData);
				}

				// ANO

				{
					labelAno = new Label(groupDadosAutomoveis, SWT.NONE);
					GridData labelAnoLData = new GridData();
					labelAnoLData.horizontalAlignment = GridData.FILL;
					labelAno.setLayoutData(labelAnoLData);
					labelAno.setText("Ano:");
				}
				{
					textAno = new Text(groupDadosAutomoveis, SWT.NONE);
					GridData anoLData = new GridData();
					anoLData.heightHint = 13;
					anoLData.horizontalAlignment = GridData.FILL;
					anoLData.grabExcessHorizontalSpace = true;
					textAno.setLayoutData(anoLData);
				}

				// CHASSI
				{
					labelChassi = new Label(groupDadosAutomoveis, SWT.NONE);
					GridData labelChassiLData = new GridData();
					labelChassiLData.horizontalAlignment = GridData.FILL;
					labelChassi.setLayoutData(labelChassiLData);
					labelChassi.setText("Chassi:");
				}
				{
					textChassi = new Text(groupDadosAutomoveis, SWT.NONE);
					GridData chassiLData = new GridData();
					chassiLData.heightHint = 13;
					chassiLData.horizontalAlignment = GridData.FILL;
					chassiLData.grabExcessHorizontalSpace = true;
					textChassi.setLayoutData(chassiLData);
				}

				// CCOMBO TIPO COMBUSTIVEL
				{
					labelTipoCombustivel = new Label(groupDadosAutomoveis,
							SWT.NONE);
					labelTipoCombustivel.setText("Tipo Combustivel:");
					GridData labelTipoCombustivelLData = new GridData();
					labelTipoCombustivelLData.horizontalAlignment = GridData.FILL;
					labelTipoCombustivel
							.setLayoutData(labelTipoCombustivelLData);
				}
				{
					cComboTipoCombustivel = new CCombo(groupDadosAutomoveis,
							SWT.NONE);
					GridData cComboTipoCombustivelLData = new GridData();
					cComboTipoCombustivelLData.horizontalAlignment = GridData.FILL;
					cComboTipoCombustivelLData.grabExcessHorizontalSpace = true;
					cComboTipoCombustivelLData.heightHint = 16;
					cComboTipoCombustivelLData.widthHint = 155;
					cComboTipoCombustivel
							.setLayoutData(cComboTipoCombustivelLData);
				}

				// view BOTÃO CONFIRMA
				{
					buttonConfirma = new Button(groupDadosAutomoveis, SWT.PUSH
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
				// view BOTÃO CANCELAR
				{
					buttonCancelar = new Button(groupDadosAutomoveis, SWT.PUSH
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
									if (automovel != null){
										openView(AutomovelListView.ID);
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
					labelErro = new Label(groupDadosAutomoveis, SWT.NONE);
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
		isUpdate = false;

		// TIPO Combustivel
		cComboTipoCombustivel.removeAll();
		for (TipoCombustivel tipo : TipoCombustivel.values()) {
			cComboTipoCombustivel.setData(tipo.getDescricao(), tipo);
			cComboTipoCombustivel.add(tipo.getDescricao());
		}

	}

	// Obrigatório
	@Override
	public void setFocus() {
		textPlaca.setFocus();
	}

	private void performFinish() {
		// dados Automovel
		try {
			if (automovel == null) {
				automovel = new Automovel();
				fillAutomovel();
				
				Facade.getInstance().cadastrarAutomovel(automovel);
				
			} else {
				fillAutomovel();
				Facade.getInstance().atualizarAutomovel(automovel);
				
				openView(AutomovelListView.ID);
			}
			closeView();
		} catch (DadosInsuficientesException e) {
			labelErro.setText(e.getMessage());
		} catch (DataException e) {
			labelErro.setText("Erro no banco");
		} catch (ValidatorException e) {
			labelErro.setText(e.getMessage());
		}finally{
			if (!isUpdate){
				automovel = null;
			}
		}
		
	}

	private void fillAutomovel() throws ValidatorException {
		// SET Placa
		if (textPlaca.getText().length() > 7 ){
			throw new ValidatorException("O Campo Placa deve ser preenchido com no máximo 7 dígitos conforme exemplo: sda1241");
		}
		if (textPlaca.getText() == null || textPlaca.getText().equals("")) {
			throw new ValidatorException("O Campo Placa é obrigatório");
		}
		
		automovel.setPlaca(textPlaca.getText());

		// SET MODELO
		if (textModelo.getText() == null || textModelo.getText().equals("")) {
			throw new ValidatorException("O Campo Modelo é obrigatório");
		}
		automovel.setModelo(textModelo.getText());

		// SET MARCA
		if (textMarca.getText() == null || textMarca.getText().equals("")) {
			throw new ValidatorException("O Campo Marca é obrigatório");
		}
		automovel.setMarca(textMarca.getText());

		// SET COR
		if (textCor.getText() == null || textCor.getText().equals("")) {
			throw new ValidatorException("O Campo Cor é obrigatório");
		}
		automovel.setCor(textCor.getText());

		// SET ANO
		if (textAno.getText().length() != 4){
			throw new ValidatorException("O Campo Ano deve ser preenchido conforme exemplo: sda2014");
		}
		automovel.setAno(textAno.getText());

		// SET CHASSI
		if (textChassi.getText() == null || textChassi.getText().equals("")) {
			throw new ValidatorException("O Chassi é obrigatório");
		}
		automovel.setChassi(textChassi.getText());

		// tipo Combustivel
		String key;
		key = cComboTipoCombustivel.getItem(cComboTipoCombustivel
				.getSelectionIndex());
		automovel.setTipoCombustivel((TipoCombustivel) cComboTipoCombustivel
				.getData(key));
	}

	public void loadAutomovel(Automovel automovel) {
		isUpdate = true;
		this.automovel = automovel;

		cComboTipoCombustivel.setText(this.automovel.getTipoCombustivel()
				.getDescricao());
		if (this.automovel.getPlaca() != null) {
			textPlaca.setText(this.automovel.getPlaca());
		}
		if (this.automovel.getModelo() != null) {
			textModelo.setText(this.automovel.getModelo());
		}
		if (this.automovel.getMarca() != null) {
			textMarca.setText(this.automovel.getMarca());
		}
		if (this.automovel.getCor() != null) {
			textCor.setText(this.automovel.getCor());
		}
		if (this.automovel.getAno() != null) {
			textAno.setText(this.automovel.getAno());
		}
		if (this.automovel.getChassi() != null) {
			textChassi.setText(this.automovel.getChassi());
		}

	}
}
