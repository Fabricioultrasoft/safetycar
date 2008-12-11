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
import br.com.dimag.safetycar.model.Usuario;
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
public class UsuarioView extends BasicView {

	public static final String ID = "SafetyCar.usuario";
	private Group groupDadosUsuario;

	// LOGIN
	private Label labelLogin;
	private Text textLogin;

	// PASSWORD
	private Label labelPassword;
	private Text textPassword;
	
	// LABEL ERROS
	private Label labelErro;
	
	//BOTÕES DE CONFIRMA E CANCELAR
	private Button buttonCancelar;
	private Button buttonConfirma;
	

	private Usuario usuario;


	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(484, 418);
			{
				groupDadosUsuario = new Group(composite, SWT.NONE);
				GridLayout dadosUsuarioLayout = new GridLayout();
				dadosUsuarioLayout.numColumns = 2;
				groupDadosUsuario.setLayout(dadosUsuarioLayout);
				groupDadosUsuario.setText("Dados do Usuário");
				groupDadosUsuario.setSize(243, 215);

				// LOGIN
				{
					labelLogin = new Label(groupDadosUsuario,
							SWT.NONE);
					labelLogin.setText("Login:");
				}
				{
					GridData loginUsuarioLData = new GridData();
					loginUsuarioLData.heightHint = 13;
					loginUsuarioLData.horizontalAlignment = GridData.FILL;
					loginUsuarioLData.grabExcessHorizontalSpace = true;
					textLogin = new Text(groupDadosUsuario, SWT.NONE);
					textLogin.setLayoutData(loginUsuarioLData);
				}
				
				
				// PASSWORD

				{
					labelPassword = new Label(groupDadosUsuario,
							SWT.NONE);
					labelPassword.setText("Password:");
				}
				{
					textPassword = new Text(groupDadosUsuario, SWT.NONE);
					GridData descricaoUsuarioLData = new GridData();
					descricaoUsuarioLData.heightHint = 13;
					descricaoUsuarioLData.horizontalAlignment = GridData.FILL;
					descricaoUsuarioLData.grabExcessHorizontalSpace = true;
					textPassword.setLayoutData(descricaoUsuarioLData);
					textPassword.setEchoChar('*');
				}

				

				//view BOTÃO CONFIRMA
				{
					buttonConfirma = new Button(groupDadosUsuario, SWT.PUSH
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
					buttonCancelar = new Button(groupDadosUsuario, SWT.PUSH
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
										openView(UsuarioListView.ID);
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
					labelErro = new Label(groupDadosUsuario, SWT.NONE);
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
				Facade.getInstance().atualizarUsuario(usuario);
				openView(UsuarioListView.ID);
				
			} else {
				usuario = new Usuario();
				fillServico();
						Facade.getInstance().cadastrarUsuario(usuario);
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
				usuario = null;
			}
		}

	}

	private void fillServico() throws ValidatorException {
		//SET PASSWORD
		if (textPassword.getText() == null || textPassword.getText().equals("")){
			throw new ValidatorException("O Campo Password é obrigatório!");
		}
		usuario.setPassword(textPassword.getText());
		
		//Set LOGIN
		if (textLogin.getText() == null || textLogin.getText().equals("")){
			throw new ValidatorException("O Campo Login é obrigatório!");
		}
		usuario.setLogin(textLogin.getText());
		
	}

	public void loadUsuario(Usuario usuario) {
		isUpdate=true;
		this.usuario = usuario;
		
		if (this.usuario.getPassword() != null){
			textPassword.setText(this.usuario.getPassword());
			// textPassword.setEchoChar('*');
		}
		
		if (this.usuario.getLogin() != null){
			textLogin.setText(this.usuario.getLogin());
		}
	}
}
