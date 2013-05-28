package com.okta.testUI.gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

import com.okta.testUI.message.MessageManager;
import com.okta.testUI.util.UIResourceStyle;


public class CompStepView extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	private CLabel lblUnitTest,lblFunctionalTest,lblBacon,lblDailyRelease;
	private CLabel lblSAPLabel;
	private CLabel lblSideMargin;
	private CLabel lblTopMargin;
	private MainGUI mainGUI;
	
	private final Color[] color_oncheck = { UIResourceStyle.getColor(56, 112, 184), UIResourceStyle.getColor(63, 177, 228) };
	private final Color color_uncheck = UIResourceStyle.getColor(121, 121,121);
	
	private static final String strBlank = "  ";
	
	
	public CompStepView(Composite parent, int style,MainGUI mainScreen) {
		super(parent, SWT.NONE);
		this.mainGUI = mainScreen;
		initGUI();
	}
	
	protected void initGUI(){
		this.setBackground(UIResourceStyle.COLOR_BACKGROUND_LEFT);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);
		new Label(this, SWT.NONE);
		
		lblTopMargin = new CLabel(this, SWT.NONE);
		GridData gd_lblTopMargin = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblTopMargin.heightHint = 5;
		lblTopMargin.setLayoutData(gd_lblTopMargin);
		lblTopMargin.setVisible(false);

		lblSideMargin = new CLabel(this, SWT.NONE);
		GridData gd_lblSideMargin = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblSideMargin.widthHint = UIResourceStyle.SIZE_STEPVIEW_LOGO_SPACING_LEFT;
		lblSideMargin.setLayoutData(gd_lblSideMargin);
		lblSideMargin.setVisible(false);

		lblSAPLabel = new CLabel(this, SWT.NONE);
		GridData gd_lblSAPLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblSAPLabel.widthHint = UIResourceStyle.SIZE_STEPVIEW_WIDTH;
		gd_lblSAPLabel.heightHint= UIResourceStyle.SIZE_STEPVIEW_LOGO_HEIGHT;
		lblSAPLabel.setLayoutData(gd_lblSAPLabel);
		lblSAPLabel.setBackground(UIResourceStyle.getColor(121,121,121));
		lblSAPLabel.setImage(UIResourceStyle.IMAGE_OKTA_LOGO);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		lblUnitTest = new CLabel(this, SWT.CENTER);
		GridData gd_unitTest = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_unitTest.heightHint = UIResourceStyle.SIZE_STEPVIEW_LABEL_HEIGHT;
		lblUnitTest.setLayoutData(gd_unitTest);
		lblUnitTest.setAlignment(SWT.LEFT);
		lblUnitTest.setText(strBlank + MessageManager.getString("STEP_UNIT"));
		lblUnitTest.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));

		lblUnitTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblUnitTest.setFont(UIResourceStyle.getFont("Segoe UI", 9, SWT.BOLD));
				lblUnitTest.setForeground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
				goToStep(0);
				mainGUI.goToStep(0);
				
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				lblUnitTest.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
				lblUnitTest.setForeground(UIResourceStyle.COLOR_LINE_TOP);
			}
		});
		lblUnitTest.addMouseTrackListener(new MouseTrackAdapter() {
			
			@Override
			public void mouseEnter(MouseEvent e) {
				lblUnitTest.setText(strBlank + MessageManager.getString("STEP_UNIT"));
				lblUnitTest.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
				lblUnitTest.setForeground(UIResourceStyle.COLOR_LINE_TOP);
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				lblUnitTest.setText(strBlank + MessageManager.getString("STEP_UNIT"));
				lblUnitTest.setForeground(UIResourceStyle.getColor(204, 204, 204));
				lblUnitTest.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
			}
		});
		
		
		lblFunctionalTest = new CLabel(this, SWT.CENTER);
		GridData gd_funtionalTest = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_funtionalTest.heightHint = UIResourceStyle.SIZE_STEPVIEW_LABEL_HEIGHT;
		lblFunctionalTest.setLayoutData(gd_funtionalTest);
		lblFunctionalTest.setAlignment(SWT.LEFT);
		lblFunctionalTest.setText(strBlank + MessageManager.getString("STEP_FUNCT"));
		lblFunctionalTest.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
		
		lblFunctionalTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblFunctionalTest.setFont(UIResourceStyle.getFont("Segoe UI", 9, SWT.BOLD));
				lblFunctionalTest.setForeground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
				goToStep(1);
				mainGUI.goToStep(1);
				
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				lblFunctionalTest.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
				lblFunctionalTest.setForeground(UIResourceStyle.COLOR_LINE_TOP);
			}
		});
		lblFunctionalTest.addMouseTrackListener(new MouseTrackAdapter() {
			
			@Override
			public void mouseEnter(MouseEvent e) {
				lblFunctionalTest.setText(strBlank + MessageManager.getString("STEP_FUNCT"));
				lblFunctionalTest.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
				lblFunctionalTest.setForeground(UIResourceStyle.COLOR_LINE_TOP);
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				lblFunctionalTest.setText(strBlank + MessageManager.getString("STEP_FUNCT"));
				lblFunctionalTest.setForeground(UIResourceStyle.getColor(204, 204, 204));
				lblFunctionalTest.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
			}
		});
		
		
		lblDailyRelease = new CLabel(this, SWT.CENTER);
		GridData gd_DailyRelease = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_DailyRelease.heightHint = UIResourceStyle.SIZE_STEPVIEW_LABEL_HEIGHT;
		lblDailyRelease.setLayoutData(gd_DailyRelease);
		lblDailyRelease.setAlignment(SWT.LEFT);
		lblDailyRelease.setText(strBlank + MessageManager.getString("STEP_DAILY_RELEASE"));
		lblDailyRelease.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
		
		lblDailyRelease.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblDailyRelease.setFont(UIResourceStyle.getFont("Segoe UI", 9, SWT.BOLD));
				lblDailyRelease.setForeground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
				goToStep(2);
				mainGUI.goToStep(2);
				
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				lblDailyRelease.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
				lblDailyRelease.setForeground(UIResourceStyle.COLOR_LINE_TOP);
			}
		});
		lblDailyRelease.addMouseTrackListener(new MouseTrackAdapter() {
			
			@Override
			public void mouseEnter(MouseEvent e) {
				lblDailyRelease.setText(strBlank + MessageManager.getString("STEP_DAILY_RELEASE"));
				lblDailyRelease.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
				lblDailyRelease.setForeground(UIResourceStyle.COLOR_LINE_TOP);
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				lblDailyRelease.setText(strBlank + MessageManager.getString("STEP_DAILY_RELEASE"));
				lblDailyRelease.setForeground(UIResourceStyle.getColor(204, 204, 204));
				lblDailyRelease.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
			}
		});
		
		lblBacon = new CLabel(this, SWT.CENTER);
		GridData gd_Bacon = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_Bacon.heightHint = UIResourceStyle.SIZE_STEPVIEW_LABEL_HEIGHT;
		lblBacon.setLayoutData(gd_Bacon);
		lblBacon.setAlignment(SWT.LEFT);
		lblBacon.setText(strBlank + MessageManager.getString("STEP_BACON"));
		lblBacon.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
		
		lblBacon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblBacon.setFont(UIResourceStyle.getFont("Segoe UI", 9, SWT.BOLD));
				lblBacon.setForeground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
				goToStep(3);
				mainGUI.goToStep(3);
				
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				lblBacon.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
				lblBacon.setForeground(UIResourceStyle.COLOR_LINE_TOP);
			}
		});
		lblBacon.addMouseTrackListener(new MouseTrackAdapter() {
			
			@Override
			public void mouseEnter(MouseEvent e) {
				lblBacon.setText(strBlank + MessageManager.getString("STEP_BACON"));
				lblBacon.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
				lblBacon.setForeground(UIResourceStyle.COLOR_LINE_TOP);
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				lblBacon.setText(strBlank + MessageManager.getString("STEP_BACON"));
				lblBacon.setForeground(UIResourceStyle.getColor(204, 204, 204));
				lblBacon.setFont(UIResourceStyle.getFont("Segoe UI", 10, SWT.BOLD));
			}
		});

		

		
		this.goToStep(0);

	}
	
	public void goToStep(int step) {
		switch (step) {
		case 0:
			lblUnitTest.setBackground(color_oncheck, new int[] { 100 });
			lblFunctionalTest.setBackground(color_uncheck);
			lblDailyRelease.setBackground(color_uncheck);
			lblBacon.setBackground(color_uncheck);
			
			lblUnitTest.setForeground(UIResourceStyle.getColor(SWT.COLOR_WHITE));
			lblFunctionalTest.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblDailyRelease.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblBacon.setForeground(UIResourceStyle.getColor(204, 204, 204));
			
			break;
		
		case 1:
			lblUnitTest.setBackground(color_uncheck);
			lblFunctionalTest.setBackground(color_oncheck, new int[] { 100 });
			lblDailyRelease.setBackground(color_uncheck);
			lblBacon.setBackground(color_uncheck);
		
			lblUnitTest.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblFunctionalTest.setForeground(UIResourceStyle.getColor(SWT.COLOR_WHITE));
			lblDailyRelease.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblBacon.setForeground(UIResourceStyle.getColor(204, 204, 204));
			
			break;
		
		case 2:
			lblUnitTest.setBackground(color_uncheck);
			lblFunctionalTest.setBackground(color_uncheck);
			lblDailyRelease.setBackground(color_oncheck, new int[] { 100 });
			lblBacon.setBackground(color_uncheck);
		
			lblUnitTest.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblFunctionalTest.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblDailyRelease.setForeground(UIResourceStyle.getColor(SWT.COLOR_WHITE));
			lblBacon.setForeground(UIResourceStyle.getColor(204, 204, 204));
			
			break;
		
		case 3:
			lblUnitTest.setBackground(color_uncheck);
			lblFunctionalTest.setBackground(color_uncheck);
			lblDailyRelease.setBackground(color_uncheck);
			lblBacon.setBackground(color_oncheck, new int[] { 100 });
		
			lblUnitTest.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblFunctionalTest.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblDailyRelease.setForeground(UIResourceStyle.getColor(204, 204, 204));
			lblBacon.setForeground(UIResourceStyle.getColor(SWT.COLOR_WHITE));
			
			break;
		
		default:
			break;

		}
	}
	
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
