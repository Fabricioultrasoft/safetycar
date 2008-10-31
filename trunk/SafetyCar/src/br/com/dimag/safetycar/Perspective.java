package br.com.dimag.safetycar;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IPlaceholderFolderLayout;

import br.com.dimag.safetycar.gui.views.MainView;
import br.com.dimag.safetycar.gui.views.NavigationView;



public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		
		layout.addStandaloneView(NavigationView.ID,  false, IPageLayout.LEFT, 0.25f, editorArea);
		layout.getViewLayout(NavigationView.ID).setCloseable(false);
		
		IFolderLayout folder = layout.createFolder("janelas", IPageLayout.TOP, 0.5f, editorArea);
		
		folder.addPlaceholder(MainView.ID + ":*");
		folder.addView(MainView.ID);
		layout.getViewLayout(MainView.ID).setCloseable(false);
		
		
		IPlaceholderFolderLayout folderLista = layout.createPlaceholderFolder("List", IPageLayout.BOTTOM, 0.5f, editorArea);
		
		//folderLista.addPlaceholder(ClienteListView.ID + ":*");
		folderLista.addPlaceholder("*List:*");
		//folderLista.addView(ClienteListView.ID);
		//layout.getViewLayout(ClienteListView.ID).setCloseable(false);
		
	}
}
