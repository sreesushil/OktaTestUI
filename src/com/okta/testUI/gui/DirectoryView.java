package com.okta.testUI.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.okta.testUI.util.UIResourceStyle;

public class DirectoryView extends Composite {
  
	public DirectoryView(Composite parent, int style,TreeViewer dirView) {
		super(parent, style);
		// Don't return from open() until window closes
		
		Display.getCurrent().dispose();
	}

  
  protected Control createContents(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new FillLayout());

    final TreeViewer tv = new TreeViewer(composite);
    tv.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
    tv.setContentProvider(new FileTreeContentProvider());
    tv.setLabelProvider(new FileTreeLabelProvider());
    tv.setInput("Users/nkeerthy/okta/okta-core/test/unit/src");

    return composite;
  }
}

class FileTreeContentProvider implements ITreeContentProvider {
  public Object[] getChildren(Object arg0) {
    return ((File) arg0).listFiles();
  }

  public Object getParent(Object arg0) {
    return ((File) arg0).getParentFile();
  }

  public boolean hasChildren(Object arg0) {
    Object[] obj = getChildren(arg0);
    return obj == null ? false : obj.length > 0;
  }

  public Object[] getElements(Object arg0) {
    return File.listRoots();
  }

  public void dispose() {
  }

  public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
  }
}

class FileTreeLabelProvider implements ILabelProvider {
  private List listeners;

  private Image file;

  private Image dir;

  public FileTreeLabelProvider() {
    listeners = new ArrayList();

    file = UIResourceStyle.IMAGE_OKTA_FILE;
    dir =  UIResourceStyle.IMAGE_OKTA_DIRECTORY;
  }

  public Image getImage(Object arg0) {
    return ((File) arg0).isDirectory() ? dir : file;
  }

  public String getText(Object arg0) {
    String text = ((File) arg0).getName();

    if (((File) arg0).getName().length() == 0) {
      text = ((File) arg0).getPath();
    }
    return text;
  }

  public void addListener(ILabelProviderListener arg0) {
    listeners.add(arg0);
  }

  public void dispose() {
    // Dispose the images
    if (dir != null)
      dir.dispose();
    if (file != null)
      file.dispose();
  }

  public boolean isLabelProperty(Object arg0, String arg1) {
    return false;
  }

  public void removeListener(ILabelProviderListener arg0) {
    listeners.remove(arg0);
  }
}