package br.com.dimag.safetycar.gui.dialogs;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.model.Usuario;


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
public class LoginDialog extends Dialog {
	private Button buttonConfirmar;
	private Text textLogin;
	private Text textPassword;
	protected Usuario usuario;
	private Button buttonCancelar;
	private Label labelError;

	public LoginDialog(Shell parentShell) {
		super(parentShell);
		
	}
	
	public void open() {
		Shell parent = getParent();
		final Shell shell = new Shell(parent,SWT.DIALOG_TRIM| SWT.APPLICATION_MODAL);
		shell.setText("Login");
		shell.setLayout(new FillLayout());
		
		shell.addDisposeListener(new DisposeListener(){

			@Override
			public void widgetDisposed(DisposeEvent arg0) {
				if (usuario == null){
					exitApplication();
				}
			}
			private void exitApplication() {
				final IWorkbench workbench = PlatformUI.getWorkbench();
				if (workbench == null)
					return;
				final Display display = workbench.getDisplay();
				display.syncExec(new Runnable() {
					public void run() {
						if (!display.isDisposed())
							workbench.close();
					}
				});
			}
			
		});
		
		
		Group groupDadosPessoais = new Group(shell, SWT.NONE);
		GridLayout dadosPessoaisLayout = new GridLayout();
		dadosPessoaisLayout.numColumns = 2;
		groupDadosPessoais.setLayout(dadosPessoaisLayout);
		groupDadosPessoais.setText("Login: ");
		groupDadosPessoais.setSize(243, 215);
		{
			Label labelLogin = new Label(groupDadosPessoais, SWT.NONE);
			GridData labelNomeClienteLData = new GridData();
			labelNomeClienteLData.horizontalAlignment = GridData.FILL;
			labelLogin.setLayoutData(labelNomeClienteLData);
			labelLogin.setText("Login:");
		}
		{
			textLogin = new Text(groupDadosPessoais,  SWT.SINGLE | SWT.BORDER);
			GridData loginLData = new GridData();
			loginLData.heightHint = 13;
			loginLData.horizontalAlignment = GridData.FILL;
			loginLData.grabExcessHorizontalSpace = true;
			textLogin.setLayoutData(loginLData);
		}
		{
			Label labelSenha = new Label(groupDadosPessoais, SWT.NONE);
			GridData labelSenhaLData = new GridData();
			labelSenhaLData.horizontalAlignment = GridData.FILL;
			labelSenha.setLayoutData(labelSenhaLData);
			labelSenha.setText("Senha:");
		}
		{
			textPassword = new Text(groupDadosPessoais, SWT.SINGLE | SWT.BORDER);
			GridData senhaLData = new GridData();
			senhaLData.heightHint = 13;
			senhaLData.horizontalAlignment = GridData.FILL;
			senhaLData.grabExcessHorizontalSpace = true;
			textPassword.setLayoutData(senhaLData);
			
		    textPassword.setEchoChar('*');
		}
		
		{
			buttonConfirmar = new Button(groupDadosPessoais, SWT.PUSH | SWT.CENTER);
			buttonConfirmar.setText("Confirmar");
			buttonConfirmar.addSelectionListener(new SelectionListener(){

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					
				}

				@Override
				public void widgetSelected(SelectionEvent arg0) {
					
					usuario = Facade.getInstance().autenticacaoUsuario(textLogin.getText(),textPassword.getText());
					if (usuario == null){
						labelError.setText("Login ou senha não conferem");
					}else{
						shell.dispose();
					}
				}
				
			});
		}
		{
			buttonCancelar = new Button(groupDadosPessoais, SWT.PUSH | SWT.CENTER);
			buttonCancelar.setText("Cancelar");
			
			buttonCancelar.addSelectionListener(new SelectionListener(){

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					
				}

				@Override
				public void widgetSelected(SelectionEvent arg0) {
					
					shell.dispose();	
				}
				
			});
		}
		{
			GridData labelErrorLData = new GridData();
			labelErrorLData.grabExcessHorizontalSpace = true;
			labelErrorLData.horizontalAlignment = SWT.FILL;
			labelErrorLData.horizontalSpan = 2;
			labelError = new Label(groupDadosPessoais, SWT.NONE);
			labelError.setLayoutData(labelErrorLData);
		}
		{
			shell.setSize(200,150);
			shell.open();
			Display display = parent.getDisplay();
			while(!shell.isDisposed()){
				if (!display.readAndDispatch()){
					display.sleep();
				}
			}
		}
	}

}
