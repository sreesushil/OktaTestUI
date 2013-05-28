package com.okta.testUI.gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

import com.okta.testUI.message.MessageManager;

public class CompDetailView extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	private StackLayout stackLayout;
	private MainGUI mainGUI;
	private CompStepView compStepView;
	private CompTopView compTopView;
	
	private DetailUnitTest unit;
	private DetailFunctionalTest functional;
	private DetailDailyRelease dailyRel;
	private DetailBacon bacon;
	
		
	public CompDetailView(Composite parent, int style, MainGUI mainGUI, CompTopView compTopView) {
		super(parent, style);
		this.mainGUI = mainGUI;
		this.compTopView = compTopView;
		stackLayout = new StackLayout();
		this.setLayout(stackLayout);
		
		
		unit = new DetailUnitTest(this,SWT.None);
		unit.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		
		functional = new DetailFunctionalTest(this,SWT.None);
		functional.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		
		dailyRel = new DetailDailyRelease(this,SWT.None);
		dailyRel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		
		bacon = new DetailBacon(this,SWT.None);
		bacon.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,1));
		
		stackLayout.topControl = unit;
		layout();
		
		
	}
	
	public void goToUnitTests(){
		compTopView.setTopLabel(MessageManager.getString("TOP_UNIT"));
		stackLayout.topControl = unit;
		layout();
	}
	
	public void goToFunctionalTest(){
		compTopView.setTopLabel(MessageManager.getString("TOP_FUNCTIONAL"));
		stackLayout.topControl = functional;
		layout();
	}
	
	public void goToDailyRelease(){
		compTopView.setTopLabel(MessageManager.getString("TOP_DAILY"));
		stackLayout.topControl = dailyRel;
		layout();
	}
	
	public void goToBacon(){
		compTopView.setTopLabel(MessageManager.getString("TOP_BACON"));
		stackLayout.topControl = bacon;
		layout();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
