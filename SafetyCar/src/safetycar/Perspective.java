package safetycar;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import safetycar.views.MainView;
import safetycar.views.NavigationView;


public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		
		layout.addStandaloneView(NavigationView.ID,  false, IPageLayout.LEFT, 0.25f, editorArea);
		IFolderLayout folder = layout.createFolder("messages", IPageLayout.TOP, 0.5f, editorArea);
		
		folder.addPlaceholder(MainView.ID + ":*");
		folder.addView(MainView.ID);
		layout.getViewLayout(MainView.ID).setCloseable(false);
		
		layout.getViewLayout(NavigationView.ID).setCloseable(false);
	}
}
