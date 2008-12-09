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
public class OSView extends BasicView {

	public static final String ID = "SafetyCar.os";
	private Group groupDadosOS;
	private Button buttonConfirma;
	private Button buttonCancelar;
	private Label labelErro;
	
	
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
					buttonConfirma = new Button(groupDadosOS, SWT.PUSH | SWT.CENTER);
					GridData buttonConfirmaLData = new GridData();
					buttonConfirmaLData.verticalAlignment = GridData.BEGINNING;
					buttonConfirmaLData.horizontalAlignment = GridData.BEGINNING;
					buttonConfirma.setLayoutData(buttonConfirmaLData);
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
					buttonCancelar = new Button(groupDadosOS, SWT.PUSH | SWT.CENTER);
					GridData buttonCancelarLData = new GridData();
					buttonCancelarLData.verticalAlignment = GridData.BEGINNING;
					buttonCancelarLData.horizontalAlignment = GridData.BEGINNING;
					buttonCancelar.setLayoutData(buttonCancelarLData);
					buttonCancelar.setText("Cancelar");
					
					buttonCancelar.addSelectionListener(new SelectionListener(){
						
						@Override
						public void widgetSelected(SelectionEvent event) {
							closeView();
						}

						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {
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
		
	}

	@Override
	public void setFocus() {
		
	}

	private void performFinish() {
		
		closeView();
		
	}
	
	public void closeView() {
		this.getViewSite().getWorkbenchWindow().getActivePage().hideView(this);
	}
}