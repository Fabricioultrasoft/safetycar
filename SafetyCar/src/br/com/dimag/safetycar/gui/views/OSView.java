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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.ValidatorException;
import br.com.dimag.safetycar.gui.views.NavigationView.TreeParent;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.BaseEntity;
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

	public class Model<T extends BaseEntity>{
		private T type;
		private int comboIndex;
		
		public Model(T type, int comboIndex){
			this.type = type;
			this.comboIndex = comboIndex;
		}
		
		public T getType() {
			return type;
		}
		public void setType(T type) {
			this.type = type;
		}
		public int getComboIndex() {
			return comboIndex;
		}
		public void setComboIndex(int comboIndex) {
			this.comboIndex = comboIndex;
		}
	}

	public static final String ID = "SafetyCar.os";
	private Group groupDadosOS;
	private Button buttonConfirma;
	private Button buttonCancelar;
	private Label labelErro;
	private Label labelDefeitoReclamado;
	private Text textDefeitoReclamado;
	private CCombo cComboMecanico;
	private Label labelMecanico;
	private Label labelStatusOrdemServico;
	private CCombo cComboStatusOrdemServico;
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
	
	private List<Model<BaseEntity>> listComboAumovel = new ArrayList<Model<BaseEntity>>();
	private List<Model<BaseEntity>> listComboCliente = new ArrayList<Model<BaseEntity>>();
	private List<Model<BaseEntity>> listComboAtendente = new ArrayList<Model<BaseEntity>>();
	private List<Model<BaseEntity>> listComboMecanico = new ArrayList<Model<BaseEntity>>();
	private List<Model<BaseEntity>> listComboProdutos = new ArrayList<Model<BaseEntity>>();
	private List<Model<BaseEntity>> listComboServicos = new ArrayList<Model<BaseEntity>>();

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
					labelMecanico.setText("Mecânico");
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
					labelDefeitoReclamado = new Label(groupDadosOS, SWT.NONE);
					GridData labelDefeitoReclamadoLData = new GridData();
					labelDefeitoReclamadoLData.horizontalAlignment = GridData.FILL;
					labelDefeitoReclamado
							.setLayoutData(labelDefeitoReclamadoLData);
					labelDefeitoReclamado.setText("Defeito Reclamado:");
				}
				{
					textDefeitoReclamado = new Text(groupDadosOS, SWT.NONE);
					GridData DefeitoReclamadoLData = new GridData();
					DefeitoReclamadoLData.heightHint = 13;
					DefeitoReclamadoLData.horizontalAlignment = GridData.FILL;
					DefeitoReclamadoLData.grabExcessHorizontalSpace = true;
					textDefeitoReclamado.setLayoutData(DefeitoReclamadoLData);
				}
				{
					labelStatusOrdemServico = new Label(groupDadosOS, SWT.NONE);
					GridData labelStatusOrdemServicoLData = new GridData();
					labelStatusOrdemServicoLData.verticalAlignment = GridData.BEGINNING;
					labelStatusOrdemServicoLData.horizontalAlignment = GridData.FILL;
					labelStatusOrdemServico
							.setLayoutData(labelStatusOrdemServicoLData);
					labelStatusOrdemServico.setText("Status Ordem Servico");
				}
				{
					GridData cComboStatusOrdemServicoLData = new GridData();
					cComboStatusOrdemServicoLData.grabExcessHorizontalSpace = true;
					cComboStatusOrdemServicoLData.verticalAlignment = GridData.BEGINNING;
					cComboStatusOrdemServicoLData.horizontalAlignment = GridData.FILL;
					cComboStatusOrdemServico = new CCombo(groupDadosOS,
							SWT.NONE);
					cComboStatusOrdemServico
							.setLayoutData(cComboStatusOrdemServicoLData);
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
					groupServiico.setText("Serviço:");
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
								"Descrição", "Valor" });
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
								"Descrição", "Valor" });
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
									if (isUpdate) {
										openView(OSListView.ID);
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
			mb.setMessage("Este servico já está na lista");
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
			mb.setMessage("Este produto já está na lista");
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
		isUpdate = false;
		listServicoTableViewers = new ArrayList<Servico>();
		listProdutoTableViewers = new ArrayList<Produto>();
		HibernateUtil.getSession().beginTransaction();

		List<BaseEntity> list = new ArrayList<BaseEntity>();
		
		list.addAll(Facade.getInstance().listAutomovel());
		populateCombo(cComboAutomovel, listComboAumovel, list);
		
		list.clear();
		list.addAll(Facade.getInstance().listCliente());
		populateCombo(cComboCliente,listComboCliente ,list );
		
		list.clear();
		list.addAll( Facade.getInstance().listAtendente());
		populateCombo(cComboAtendente,listComboAtendente , list);
		
		list.clear();
		list.addAll(Facade.getInstance().listMecanico());
		populateCombo(cComboMecanico,listComboMecanico , list);
		
		list.clear();
		list.addAll(Facade.getInstance().listMecanico());
		populateCombo(cComboServicos,listComboServicos , list);

		list.clear();
		list.addAll(Facade.getInstance().listServico());
		populateCombo(cComboProdutos,listComboProdutos , list);

		/*
		 * StatusOrdemServico
		 */
		StatusOrdemServico selectedTipo = null;
		if (cComboStatusOrdemServico.getSelectionIndex() != -1) {
			String key = cComboStatusOrdemServico
					.getItem(cComboStatusOrdemServico.getSelectionIndex());
			selectedTipo = (StatusOrdemServico) cComboStatusOrdemServico
					.getData(key);
		}

		cComboStatusOrdemServico.removeAll();
		for (StatusOrdemServico tipo : OrdemServico.StatusOrdemServico.values()) {
			cComboStatusOrdemServico.setData(tipo.getDescricao(), tipo);
			cComboStatusOrdemServico.add(tipo.getDescricao());
		}
		if (selectedTipo != null) {
			cComboStatusOrdemServico.select(cComboStatusOrdemServico
					.indexOf(selectedTipo.getDescricao()));
		}
	}

	private void populateCombo(CCombo combo, List<Model<BaseEntity>> listCombo, List<BaseEntity> listNewItems) {
		int selectedId = 0;
		if (combo.getSelectionIndex() != -1) {
			selectedId = listCombo.get(combo.getSelectionIndex()).getType().getId();
		}
		listCombo.clear(); 
		combo.removeAll();
		int i = 0;
		int selectedIndex = -1;
		for (BaseEntity base : listNewItems) {
			if (base.getId() == selectedId){
				selectedIndex = i;
			}
			listCombo.add(i++, new Model<BaseEntity>(base,i));
			combo.add(base.getTextDefault(), i);
		}
		if (selectedIndex != -1) {
			cComboAutomovel.select(selectedIndex);
		}
	}
	
	

	@Override
	public void setFocus() {
		loadData();
	}

	private void performFinish() {

		try {
			if (!isUpdate) {
				ordemServico = new OrdemServico();
				fillOrdemServico();

				Facade.getInstance().cadastrarOrdemServico(ordemServico);

			} else {
				fillOrdemServico();
				Facade.getInstance().atualizarOrdemServico(ordemServico);
				openView(OSListView.ID);
			}
			HibernateUtil.flush();
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			closeView();
		} catch (DadosInsuficientesException e) {
			
			HibernateUtil.rollbackTransaction();
			labelErro.setText(e.getMessage());
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			labelErro.setText(e.getMessage());
		} finally {
			if (!isUpdate) {
				ordemServico = null;
			}
		}

	}

	private void fillOrdemServico() throws ValidatorException {
		validarTela();
		
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

		StatusOrdemServico status;
			key = cComboStatusOrdemServico.getItem(cComboStatusOrdemServico
					.getSelectionIndex());
			status = (StatusOrdemServico) cComboStatusOrdemServico.getData(key);

		ordemServico.setStatusOrdemServico(status);
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

	}

	private void validarTela() throws ValidatorException {
		String key;
		// validação de placa
		if (cComboAutomovel.getSelectionIndex() == -1) {
			throw new ValidatorException("Selecionar a Placa é obrigatório!");
		}

		// validação de Cliente
		if (cComboCliente.getSelectionIndex() == -1) {
			throw new ValidatorException("Selecionar o Cliente é obrigatório!");
		}

		// validação de Atendente
		if (cComboAtendente.getSelectionIndex() == -1) {
		
			throw new ValidatorException(
					"Selecionar o Atendente é obrigatório!");
		}

		// validação de Mecanico
		if (cComboMecanico.getSelectionIndex() == -1) {
			
			throw new ValidatorException("Selecionar o Mecanico é obrigatório!");
		}
		
		// validacao status ordem servico
		if (cComboStatusOrdemServico.getSelectionIndex() == -1) {
			throw new ValidatorException(
					"Selecionar o Status ordem servico é obrigatório!");
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
		isUpdate = true;
		this.ordemServico = os;

		cComboMecanico.select(cComboMecanico.indexOf(this.ordemServico
				.getMecanico().getNomeRazaoSocial()));
		cComboAutomovel.select(cComboAutomovel.indexOf(this.ordemServico
				.getAutomovel().getPlaca()));
		cComboCliente.select(cComboCliente.indexOf(this.ordemServico
				.getCliente().getNomeRazaoSocial()));

		cComboAtendente.select(cComboAtendente.indexOf(this.ordemServico
				.getAtendente().getNomeRazaoSocial()));

		cComboStatusOrdemServico.select(cComboStatusOrdemServico
				.indexOf(this.ordemServico.getStatusOrdemServico()
						.getDescricao()));

		listServicoTableViewers = this.ordemServico.getServicos();
		atualizarTableViewerServico();

		listProdutoTableViewers = this.ordemServico.getProdutos();
		atualizarTableViewerProduto();

	}
}
