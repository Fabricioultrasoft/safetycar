package br.com.dimag.safetycar.gui.views;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.gui.views.NavigationView.TreeParent;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.Funcionario;
import br.com.dimag.safetycar.model.OrdemServico;
import br.com.dimag.safetycar.model.OrdemServicoServico;
import br.com.dimag.safetycar.model.Servico;
import br.com.dimag.safetycar.model.UF;
import br.com.dimag.safetycar.model.Automovel.TipoCombustivel;
import br.com.dimag.safetycar.model.OrdemServico.ClassificacaoOrdemServico;
import br.com.dimag.safetycar.model.OrdemServico.StatusOrdemServico;
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
public class OSView extends BasicView {

	public static final String ID = "SafetyCar.os";
	private Group groupDadosOS;
	private Button buttonConfirma;
	private Button buttonCancelar;
	private Label labelErro;
	private CCombo cComboAtendente;
	private Label labelAtendente;
	private Group groupServiico;
	private TableViewer tableViewerServico;
	private CCombo cComboCliente;
	private Label labelCliente;
	private CCombo cComboPlaca;
	private Label labelPlacaVeiculo;
	private OrdemServico ordemServico;

	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(336, 231);
			{
				groupDadosOS = new Group(composite, SWT.NONE);
				GridLayout dadosPessoaisLayout = new GridLayout();
				dadosPessoaisLayout.numColumns = 2;
				groupDadosOS.setLayout(dadosPessoaisLayout);
				groupDadosOS.setText("Dados OS");
				groupDadosOS.setSize(243, 215);
				{
					labelPlacaVeiculo = new Label(groupDadosOS, SWT.NONE);
					GridData labelPlacaVeiculoLData = new GridData();
					labelPlacaVeiculoLData.verticalAlignment = GridData.BEGINNING;
					labelPlacaVeiculoLData.horizontalAlignment = GridData.FILL;
					labelPlacaVeiculo.setLayoutData(labelPlacaVeiculoLData);
					labelPlacaVeiculo.setText("Placa");
				}
				{
					GridData cComboPlacaLData = new GridData();
					cComboPlacaLData.verticalAlignment = GridData.BEGINNING;
					cComboPlacaLData.horizontalAlignment = GridData.FILL;
					cComboPlacaLData.grabExcessHorizontalSpace = true;
					cComboPlaca = new CCombo(groupDadosOS, SWT.NONE);
					cComboPlaca.setLayoutData(cComboPlacaLData);
				}
				{
					labelCliente = new Label(groupDadosOS, SWT.NONE);
					labelCliente.setText("Cliente:");
				}
				{
					GridData cComboClienteLData = new GridData();
					cComboClienteLData.verticalAlignment = GridData.BEGINNING;
					cComboClienteLData.horizontalAlignment = GridData.FILL;
					cComboClienteLData.grabExcessHorizontalSpace = true;
					cComboCliente = new CCombo(groupDadosOS, SWT.NONE);
					cComboCliente.setLayoutData(cComboClienteLData);
				}
				{
					labelAtendente = new Label(groupDadosOS, SWT.NONE);
					GridData labelAtendenteLData = new GridData();
					labelAtendenteLData.verticalAlignment = GridData.BEGINNING;
					labelAtendenteLData.horizontalAlignment = GridData.FILL;
					labelAtendenteLData.grabExcessHorizontalSpace = true;
					labelAtendente.setLayoutData(labelAtendenteLData);
					labelAtendente.setText("Atendente");
				}
				{
					GridData cComboAtendenteLData = new GridData();
					cComboAtendenteLData.verticalAlignment = GridData.BEGINNING;
					cComboAtendenteLData.horizontalAlignment = GridData.FILL;
					cComboAtendenteLData.grabExcessHorizontalSpace = true;
					cComboAtendente = new CCombo(groupDadosOS, SWT.NONE);
					cComboAtendente.setLayoutData(cComboAtendenteLData);
				}
				{
					groupServiico = new Group(groupDadosOS, SWT.NONE);
					GridLayout group1Layout = new GridLayout();
					group1Layout.makeColumnsEqualWidth = true;
					groupServiico.setLayout(group1Layout);
					GridData group1LData = new GridData();
					group1LData.verticalAlignment = GridData.BEGINNING;
					group1LData.horizontalAlignment = GridData.FILL;
					group1LData.horizontalSpan = 2;
					group1LData.grabExcessHorizontalSpace = true;
					group1LData.widthHint = 314;
					group1LData.heightHint = 64;
					groupServiico.setLayoutData(group1LData);
					groupServiico.setText("Serviço:");
					{
						GridData tableViewerServicoLData = new GridData();
						tableViewerServicoLData.verticalAlignment = GridData.FILL;
						tableViewerServicoLData.horizontalAlignment = GridData.FILL;
						tableViewerServicoLData.grabExcessHorizontalSpace = true;
						tableViewerServicoLData.grabExcessVerticalSpace = true;
						tableViewerServico = new TableViewer(groupServiico,
								SWT.NONE);
						tableViewerServico.getControl().setLayoutData(
								tableViewerServicoLData);
						tableViewerServico.setContentProvider(new ViewContentProvider());
						tableViewerServico.setLabelProvider(new ViewLabelProvider());
						tableViewerServico.setColumnProperties(new String[]{"Descrição","Valor"});
					}
				}

				{
					buttonConfirma = new Button(groupDadosOS, SWT.PUSH
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
					buttonCancelar = new Button(groupDadosOS, SWT.PUSH
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
				{
					labelErro = new Label(groupDadosOS, SWT.NONE);
					GridData labelErroLData = new GridData();
					labelErroLData.verticalAlignment = GridData.FILL;
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

		List<Automovel> listAutomovel = Facade.getInstance().listAutomovel();
		for (Automovel automovel : listAutomovel) {
			cComboPlaca.setData(automovel.getPlaca(), automovel);
			cComboPlaca.add(automovel.getPlaca());
		}

		List<Cliente> listCliente = Facade.getInstance().listCliente();
		for (Cliente cliente : listCliente) {
			cComboCliente.setData(cliente.getNomeRazaoSocial(), cliente);
			cComboCliente.add(cliente.getNomeRazaoSocial());
		}
		loadOrdemServico();
		
		List<Funcionario> listFuncionario = Facade.getInstance().listAtendente();
		for (Funcionario funcionario : listFuncionario) {
			cComboAtendente.setData(funcionario.getNomeRazaoSocial(), funcionario);
			cComboAtendente.add(funcionario.getNomeRazaoSocial());
		}
		loadOrdemServico();
	}

	@Override
	public void setFocus() {

	}

	private void performFinish() {
		ordemServico = new OrdemServico();
		List<Servico> listServico = new ArrayList<Servico>();
		Servico servico = new Servico();
		servico.setDescricao("SERVICO 1");
		servico.setValorServico(200);
		listServico.add(servico);

		servico = new Servico();
		servico.setDescricao("SERVICO 2");
		servico.setValorServico(300);
		listServico.add(servico);
		
		ordemServico.setServicos(listServico);

		String key;
		Funcionario atendente = null;
		if (cComboAtendente.getSelectionIndex() != -1){
			key = cComboAtendente.getItem(cComboAtendente.getSelectionIndex());
			atendente = (Funcionario) cComboAtendente.getData(key);
		}
		ordemServico.setAtendente(atendente);
		
		Funcionario func = new Funcionario();
		func.setMatricula(12345);
		func.setCpfCnpj("12345678901");
		func.setDataAdmissao(new Date(1223456));
		func.setNomeRazaoSocial("NOME DO FUNCIONARIO");
		func.setTipoPessoa(TipoPessoa.FISICA);
		ordemServico.setMecanico(func);

		ordemServico.setData(new Date(123476543));

		ordemServico.setDefeitoReclamado("Carro quebrado");
		ordemServico.setStatusOrdemServico(StatusOrdemServico.AUTORIZADO);
		ordemServico
				.setClassificacaoOrdemServico(ClassificacaoOrdemServico.ABERTA);

		Automovel auto = new Automovel();
		auto.setPlaca("KLZ8905");
		auto.setModelo("CELTA");
		auto.setMarca("asdasda");
		auto.setCor("asdasd");
		auto.setChassi("asdasd");
		auto.setAno("2008");
		auto.setTipoCombustivel(TipoCombustivel.GASOLINA);
		
		ordemServico.setAutomovel(auto);
		
		Cliente cli = new Cliente();
		cli.setCpfCnpj("09876543212");
		cli.setNomeRazaoSocial("NOME DO CLIENTE");
		cli.setTipoPessoa(TipoPessoa.FISICA);
		
		ordemServico.setCliente(cli);
		
		
		try {
			Facade.getInstance().cadastrarOrdemServico(ordemServico);
			closeView();
		} catch (DadosInsuficientesException e) {
			labelErro.setText(e.getMessage());
		} catch (Exception e) {
			labelErro.setText(e.getMessage());
		}

	}

	private List<Servico> createModelServico() {

		if (ordemServico.getServicos() != null) {

			List<Servico> list = new ArrayList<Servico>();

			for (Servico servico : ordemServico.getServicos()) {
				list.add(servico);
			}
			return list;
		}

		return null;
	}

	public void loadOrdemServico() {
		List<OrdemServico> list = Facade.getInstance().listOrdemServico();
		ordemServico = list.get(1);
		tableViewerServico.setInput(createModelServico());
	}

	class ViewContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.getInput();
		}

		public void dispose() {

		}

		public Object[] getElements(Object object) {
			List<Servico> list = (List<Servico>)object;
			if (list != null){
				return list.toArray(new Servico[list.size()]);
			}
			return null;
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

}
