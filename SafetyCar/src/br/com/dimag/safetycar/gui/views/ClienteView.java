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
import org.eclipse.ui.part.ViewPart;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.exception.FacadeException;
import br.com.dimag.safetycar.model.Cliente;


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
	private Label labelEndereco;
	private Text textTelefone;
	private Label labelTelefone;
	private Button buttonCancelar;
	private Button buttonConfirma;
	private Text textEndereço;
	private Label labelNomeCliente;
	private Text textNomeCliente;
	private Cliente cliente;

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
			}
		}

	}

	@Override
	public void setFocus() {
		
	}

	private void performFinish() {
		cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome(textNomeCliente.getText());
		cliente.setEndereco(textEndereço.getText());
		cliente.setTelefone(textTelefone.getText());
		
		try {
			Facade.getInstance().cadastrarCliente(cliente);
			this.getViewSite().getWorkbenchWindow().getActivePage().hideView(this);
		} catch (FacadeException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
