package br.com.dimag.safetycar;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import br.com.dimag.safetycar.gui.dialogs.LoginDialog;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
    	   
        configurer.setInitialSize(new Point(600, 400));
        configurer.setInitialSize(new Point(600, 500));
        configurer.setShowCoolBar(true);
        configurer.setShowStatusLine(false);
    }
    @Override
    public void openIntro() {
    	// TODO Auto-generated method stub
    	super.openIntro();
    	Platform.endSplash();
    	
    	LoginDialog login = new LoginDialog(getWindowConfigurer().getWindow().getShell());
		login.open();
    }
}
