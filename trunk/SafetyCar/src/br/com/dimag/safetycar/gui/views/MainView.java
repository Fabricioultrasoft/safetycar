package br.com.dimag.safetycar.gui.views;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import br.com.dimag.safetycar.data.transaction.HibernateUtil;


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
public class MainView extends BasicView { 

	public static final String ID = "SafetyCar.main";
	private CTabFolder cTabFolder1;
	private CTabItem cTabItem1;
	private Label label1;

	@Override
	public void createPartControl(Composite arg0) {
		{
			arg0.setSize(277, 226);
			{
				cTabFolder1 = new CTabFolder(arg0, SWT.NONE);
				{
					cTabItem1 = new CTabItem(cTabFolder1, SWT.NONE);
					cTabItem1.setText("DIMAG Safety Car");
					{
						label1 = new Label(cTabFolder1, SWT.NONE);
						cTabItem1.setControl(label1);
						label1.setText("Sistema de Oficina Automotiva");
					}
				}
				cTabFolder1.setSelection(0);
			}
		}
		// TODO Auto-generated method stub
		HibernateUtil.init();

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
