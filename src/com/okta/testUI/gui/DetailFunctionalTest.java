package com.okta.testUI.gui;

import java.io.File;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;

import com.okta.testUI.util.UIResourceStyle;

import org.eclipse.swt.widgets.Tree;

public class DetailFunctionalTest extends Composite{
	
	private CompDetailView detail;
	private TreeViewer tree;
	
	public DetailFunctionalTest(Composite parent, int style) {
		super(parent, style);
		this.detail = (CompDetailView) parent;
		
		setBackground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
		setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		setLayout(new GridLayout(2, false));
		
		Composite composite = new Composite(parent, SWT.NONE);
	    composite.setLayout(new FillLayout());
	    
		tree = new TreeViewer(this, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		Tree tree_1 = tree.getTree();
		tree_1.setHeaderVisible(true);
		
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 7);
		gd_table.widthHint = 100;
		
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.verticalSpan = 7;
		
		File file = new File("/Users/nkeerthy/Desktop");
		tree.getTree().setLayoutData(gridData);
		tree.setContentProvider(new FileTree());
		tree.setLabelProvider(new FileTreeLabel());
		tree.setInput("/Users/nkeerthy/Desktop");
		//tree.setExpandedTreePaths(treePaths)
		
		
		
		CLabel lblSelectTheTest = new CLabel(this, SWT.NONE);
		lblSelectTheTest.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblSelectTheTest.setForeground(this.getForeground());
		lblSelectTheTest.setBackground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
		lblSelectTheTest.setText("Select the Test case");
		
		Button btnRunning = new Button(this, SWT.RADIO);
		btnRunning.setText("Running a single func test, compiling only tests with test DB rebuild");
		btnRunning.setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		
		Button btnRadioButton = new Button(this, SWT.RADIO);
		btnRadioButton.setText("Running a single func test, compiling only tests without test DB rebuild");
		btnRadioButton.setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		
		Button btnRunningASingle = new Button(this, SWT.RADIO);
		btnRunningASingle.setText("Running a single func test, compiling all dependencies");
		btnRunningASingle.setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		
		Button btnSingleFuncSpecDep = new Button(this, SWT.RADIO);
		btnSingleFuncSpecDep.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnSingleFuncSpecDep.setText("Running a single func test, compiling specific dependencies");
		btnSingleFuncSpecDep.setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		
		Button btnRunningAllUnit = new Button(this, SWT.RADIO);
		btnRunningAllUnit.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnRunningAllUnit.setText("Running all func tests");
		btnRunningAllUnit.setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		
		Button btnSubmit = new Button(this, SWT.NONE);
		btnSubmit.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnSubmit.setText("SUBMIT");

	}
	
}
