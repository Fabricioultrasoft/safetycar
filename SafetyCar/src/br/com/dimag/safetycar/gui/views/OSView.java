package br.com.dimag.safetycar.gui.views;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.gui.views.NavigationView.TreeParent;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.Funcionario;
import br.com.dimag.safetycar.model.OrdemServico;
import br.com.dimag.safetycar.model.Produto;
import br.com.dimag.safetycar.model.Servico;
import br.com.dimag.safetycar.model.OrdemServico.ClassificacaoOrdemServico;
import br.com.dimag.safetycar.model.OrdemServico.StatusOrdemServico;

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
	private CCombo cComboMecanico;
	private Label labelMecanico;
	private Button buttonAddProduto;
	private CCombo cComboProdutos;
	private TableViewer tableViewerProduto;
	private Group groupProduto;
	private Button buttonAddServico;
	private CCombo cComboServicos;
	private CCombo cComboAtendente;
	private Label labelAtendente;
	private Group groupServiico;
	private TableViewer tableViewerServico;
	private CCombo cComboCliente;
	private Label labelCliente;
	private CCombo cComboAutomovel;
	private Label labelPlacaVeiculo;
	private OrdemServico ordemServico;

	private List<Servico> listServicoTableViewers;
	private List<Produto> listProdutoTableViewers;

	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(399, 309);
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
					cComboAutomovel = new CCombo(groupDadosOS, SWT.NONE);
					cComboAutomovel.setLayoutData(cComboPlacaLData);
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
					labelMecanico = new Label(groupDadosOS, SWT.NONE);
					GridData labelMecanicoLData = new GridData();
					labelMecanicoLData.verticalAlignment = GridData.BEGINNING;
					labelMecanicoLData.horizontalAlignment = GridData.FILL;
					labelMecanico.setLayoutData(labelMecanicoLData);
					labelMecanico.setText("Mec�nico");
				}
				{
					GridData cComboMecanicoLData = new GridData();
					cComboMecanicoLData.grabExcessHorizontalSpace = true;
					cComboMecanicoLData.verticalAlignment = GridData.BEGINNING;
					cComboMecanicoLData.horizontalAlignment = GridData.FILL;
					cComboMecanico = new CCombo(groupDadosOS, SWT.NONE);
					cComboMecanico.setLayoutData(cComboMecanicoLData);
				}
				{
					groupServiico = new Group(groupDadosOS, SWT.NONE);
					GridLayout group1Layout = new GridLayout();
					groupServiico.setLayout(group1Layout);
					GridData group1LData = new GridData();
					group1LData.verticalAlignment = GridData.FILL;
					group1LData.horizontalAlignment = GridData.FILL;
					group1LData.horizontalSpan = 2;
					group1Layout.numColumns = 2;
					group1LData.grabExcessHorizontalSpace = true;
					group1LData.grabExcessVerticalSpace = true;
					group1LData.widthHint = 314;
					group1LData.heightHint = 64;
					groupServiico.setLayoutData(group1LData);
					groupServiico.setText("Servi�o:");
					{
						GridData cComboServicosLData = new GridData();
						cComboServicosLData.grabExcessHorizontalSpace = true;
						cComboServicosLData.horizontalAlignment = SWT.FILL;
						cComboServicos = new CCombo(groupServiico, SWT.NONE);
						cComboServicos.setLayoutData(cComboServicosLData);
					}
					{
						buttonAddServico = new Button(groupServiico, SWT.PUSH
								| SWT.CENTER);
						buttonAddServico.setText("Adicionar");
						buttonAddServico
								.addSelectionListener(new SelectionListener() {

									@Override
									public void widgetDefaultSelected(
											SelectionEvent event) {
										// TODO Auto-generated method stub
									}

									@Override
									public void widgetSelected(
											SelectionEvent event) {
										adicionarServico();

									}

								});
					}
					{
						GridData tableViewerServicoLData = new GridData();
						tableViewerServicoLData.verticalAlignment = GridData.FILL;
						tableViewerServicoLData.horizontalAlignment = GridData.FILL;
						tableViewerServicoLData.horizontalSpan = 2;
						tableViewerServicoLData.grabExcessHorizontalSpace = true;
						tableViewerServicoLData.grabExcessVerticalSpace = true;
						tableViewerServico = new TableViewer(groupServiico,
								SWT.NONE);
						tableViewerServico.getControl().setLayoutData(
								tableViewerServicoLData);
						tableViewerServico
								.setContentProvider(new ViewContentProviderServico());
						tableViewerServico
								.setLabelProvider(new ViewLabelProviderServico());
						tableViewerServico.setColumnProperties(new String[] {
								"Descri��o", "Valor" });
					}
				}
				{
					groupProduto = new Group(groupDadosOS, SWT.NONE);
					groupProduto.setText("Produtos:");
					GridLayout groupProdutoLayout = new GridLayout();
					groupProdutoLayout.makeColumnsEqualWidth = false;
					groupProdutoLayout.numColumns = 2;
					GridData groupProdutoLData = new GridData();
					groupProdutoLData.grabExcessHorizontalSpace = true;
					groupProdutoLData.grabExcessVerticalSpace = true;
					groupProdutoLData.horizontalSpan = 2;
					groupProdutoLData.verticalAlignment = SWT.FILL;
					groupProdutoLData.horizontalAlignment = SWT.FILL;
					groupProduto.setLayoutData(groupProdutoLData);
					groupProduto.setLayout(groupProdutoLayout);
					{
						GridData cComboProdutosLData = new GridData();
						cComboProdutosLData.grabExcessHorizontalSpace = true;
						cComboProdutosLData.horizontalAlignment = SWT.FILL;
						cComboProdutos = new CCombo(groupProduto, SWT.NONE);
						cComboProdutos.setLayoutData(cComboProdutosLData);
					}
					{
						buttonAddProduto = new Button(groupProduto, SWT.PUSH
								| SWT.CENTER);
						buttonAddProduto.setText("Adicionar");
						buttonAddProduto
								.addSelectionListener(new SelectionListener() {

									@Override
									public void widgetDefaultSelected(
											SelectionEvent event) {
										// TODO Auto-generated method stub
									}

									@Override
									public void widgetSelected(
											SelectionEvent event) {
										adicionarProduto();
									}

								});
					}
					{
						GridData tableViewerProdutoLData = new GridData();
						tableViewerProdutoLData.grabExcessHorizontalSpace = true;
						tableViewerProdutoLData.grabExcessVerticalSpace = true;
						tableViewerProdutoLData.horizontalSpan = 2;
						tableViewerProdutoLData.verticalAlignment = SWT.FILL;
						tableViewerProdutoLData.horizontalAlignment = SWT.FILL;
						tableViewerProduto = new TableViewer(groupProduto,
								SWT.NONE);
						tableViewerProduto.getControl().setLayoutData(
								tableViewerProdutoLData);
						tableViewerProduto
								.setContentProvider(new ViewContentProviderProduto());
						tableViewerProduto
								.setLabelProvider(new ViewLabelProviderProduto());
						tableViewerProduto.setColumnProperties(new String[] {
								"Descri��o", "Valor" });
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

	private void adicionarServico() {
		String key = cComboServicos.getItem(cComboServicos.getSelectionIndex());
		Servico servico = (Servico) cComboServicos.getData(key);

		if (!listServicoTableViewers.contains(servico)) {
			listServicoTableViewers.add(servico);
			atualizarTableViewerServico();
		} else {
			MessageBox mb = new MessageBox(getViewSite().getShell());
			mb.setText("Conflito");
			mb.setMessage("Este servico j� est� na lista");
			mb.open();
		}
	}

	private void adicionarProduto() {
		String key = cComboProdutos.getItem(cComboProdutos.getSelectionIndex());
		Produto produto = (Produto) cComboProdutos.getData(key);

		if (!listProdutoTableViewers.contains(produto)) {
			listProdutoTableViewers.add(produto);
			atualizarTableViewerProduto();
		} else {
			MessageBox mb = new MessageBox(getViewSite().getShell());
			mb.setText("Conflito");
			mb.setMessage("Este produto j� est� na lista");
			mb.open();
		}
	}

	private void atualizarTableViewerProduto() {
		tableViewerProduto.setInput(listProdutoTableViewers);
	}

	private void atualizarTableViewerServico() {
		tableViewerServico.setInput(listServicoTableViewers);
	}

	public void loadOrdemServico() {
		List<OrdemServico> list = Facade.getInstance().listOrdemServico();
		ordemServico = list.get(1);
		atualizarTableViewerServico();
	}

	private void loadData() {
		listServicoTableViewers = new ArrayList<Servico>();
		listProdutoTableViewers = new ArrayList<Produto>();

		List<Automovel> listAutomovel = Facade.getInstance().listAutomovel();
		for (Automovel automovel : listAutomovel) {
			cComboAutomovel.setData(automovel.getPlaca(), automovel);
			cComboAutomovel.add(automovel.getPlaca());
		}

		List<Cliente> listCliente = Facade.getInstance().listCliente();
		for (Cliente cliente : listCliente) {
			cComboCliente.setData(cliente.getNomeRazaoSocial(), cliente);
			cComboCliente.add(cliente.getNomeRazaoSocial());
		}

		List<Servico> listServico = Facade.getInstance().listServico();
		for (Servico servico : listServico) {
			cComboServicos.setData(servico.getDescricao(), servico);
			cComboServicos.add(servico.getDescricao());
		}

		List<Produto> listProduto = Facade.getInstance().listProduto();
		for (Produto produto : listProduto) {
			cComboProdutos.setData(produto.getDescricao(), produto);
			cComboProdutos.add(produto.getDescricao());
		}

		List<Funcionario> listAtendente = Facade.getInstance()
				.listAtendente();
		for (Funcionario funcionario : listAtendente) {
			cComboAtendente.setData(funcionario.getNomeRazaoSocial(),
					funcionario);
			cComboAtendente.add(funcionario.getNomeRazaoSocial());
		}

		List<Funcionario> listMecanico = Facade.getInstance()
				.listMecanico();
		for (Funcionario funcionario : listMecanico) {
			cComboMecanico.setData(funcionario.getNomeRazaoSocial(),
					funcionario);
			cComboMecanico.add(funcionario.getNomeRazaoSocial());
		}
	}

	@Override
	public void setFocus() {

	}

	private void performFinish() {
		ordemServico = new OrdemServico();
		ordemServico.setServicos(listServicoTableViewers);
		ordemServico.setProdutos(listProdutoTableViewers);

		String key;
		Funcionario atendente = null;
		if (cComboAtendente.getSelectionIndex() != -1) {
			key = cComboAtendente.getItem(cComboAtendente.getSelectionIndex());
			atendente = (Funcionario) cComboAtendente.getData(key);
		}
		ordemServico.setAtendente(atendente);

		Funcionario mecanico = null;
		if (cComboMecanico.getSelectionIndex() != -1) {
			key = cComboMecanico.getItem(cComboMecanico.getSelectionIndex());
			mecanico = (Funcionario) cComboMecanico.getData(key);
		}
		ordemServico.setMecanico(mecanico);

		ordemServico.setData(new GregorianCalendar());

		ordemServico.setDefeitoReclamado("Carro quebrado");
		ordemServico.setStatusOrdemServico(StatusOrdemServico.AUTORIZADO);
		ordemServico
				.setClassificacaoOrdemServico(ClassificacaoOrdemServico.ABERTA);

		Automovel automovel = null;
		if (cComboAutomovel.getSelectionIndex() != -1) {
			key = cComboAutomovel.getItem(cComboAutomovel.getSelectionIndex());
			automovel = (Automovel) cComboAutomovel.getData(key);
		}
		ordemServico.setAutomovel(automovel);

		Cliente cliente = null;
		if (cComboCliente.getSelectionIndex() != -1) {
			key = cComboCliente.getItem(cComboCliente.getSelectionIndex());
			cliente = (Cliente) cComboCliente.getData(key);
		}
		ordemServico.setCliente(cliente);

		try {
			Facade.getInstance().cadastrarOrdemServico(ordemServico);
			closeView();
		} catch (DadosInsuficientesException e) {
			labelErro.setText(e.getMessage());
		} catch (Exception e) {
			labelErro.setText(e.getMessage());
		}

	}

	class ViewContentProviderServico implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.getInput();
		}

		public void dispose() {

		}

		public Object[] getElements(Object object) {
			List<Servico> list = (List<Servico>) object;
			if (list != null) {
				return list.toArray(new Servico[list.size()]);
			}
			return null;
		}

	}

	class ViewLabelProviderServico extends LabelProvider {

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

	class ViewContentProviderProduto implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.getInput();
		}

		public void dispose() {

		}

		public Object[] getElements(Object object) {
			List<Produto> list = (List<Produto>) object;
			if (list != null) {
				return list.toArray(new Produto[list.size()]);
			}
			return null;
		}

	}

	class ViewLabelProviderProduto extends LabelProvider {

		public String getText(Object obj) {
			Produto produto = (Produto) obj;
			return produto.getDescricao();
		}

		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					imageKey);
		}
	}

	public void loadOS(OrdemServico os) {
		this.ordemServico = os;
		
	}
}
