package com.okta.testUI.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import com.okta.testUI.message.MessageManager;
import com.okta.testUI.util.UIResourceStyle;

public class MainGUI {

	protected Shell shell;
	private CompDetailView  compDetailView_;
	private CompTopView compTopView_;
	private CompStepView compStepView_;
	private CompBottomView compBottomView_;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainGUI window = new MainGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		
		Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
	    
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shell = new Shell();
		shell.setMaximized(true);
		shell.setImage(UIResourceStyle.IMAGE_TITLE_ICO);
		//shell = new Shell(SWT.CLOSE);
		/*
		 * Need to get the small icon from UI team
		 */
		//shell.setImage(UIResourceStyle.IMAGE_TITLE_ICO);
		//shell.setMinimumSize(new Point(800, 600));
		//shell.setSize(799, 579);
		shell.setText("OKTA BASIC TESTING UI");
		
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				MessageBox mb = new MessageBox(shell, SWT.ICON_QUESTION
						| SWT.YES | SWT.NO);
//				mb.setText(MessageManager.getString("MSG_EXIT_INSTALLATION_TITLE"));
//				mb.setMessage(MessageManager.getString("MSG_EXIT_INSTALLATION"));
				
				mb.setMessage("Message to display while exit");
				mb.setText("title to display while exit");
				int rt = mb.open();
				if (rt == SWT.YES) {
//					e.doit = true;
//					log.info("Exit: cancel the installation");
//					System.exit(PropertiesManager.EXIT_CANCEL);//TBD
					System.exit(0);
				} else {
					e.doit = false;
				}
			}
		});
		
		GridLayout gl_shell = new GridLayout(3, false);
		gl_shell.verticalSpacing = 0;
		gl_shell.marginWidth = 0;
		gl_shell.marginHeight = 0;
		gl_shell.horizontalSpacing = 0;
		shell.setLayout(gl_shell);
		//this.center(shell);	
		
		Composite composite_line = new Composite(shell, SWT.NONE);
		GridLayout gl_composite_line = new GridLayout(3, false);
		gl_composite_line.verticalSpacing = 0;
		gl_composite_line.horizontalSpacing = 0;
		gl_composite_line.marginWidth = 0;
		gl_composite_line.marginHeight = 0;
		composite_line.setLayout(gl_composite_line);
		composite_line.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		
		CLabel lblNewLabel_4 = new CLabel(composite_line, SWT.NONE);
		lblNewLabel_4.setBackground(UIResourceStyle.COLOR_BACKGROUND_LEFT);
		GridData gd_lblNewLabel_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_4.widthHint = UIResourceStyle.SIZE_TOP_LINE_SPACING;
		gd_lblNewLabel_4.heightHint = UIResourceStyle.SIZE_TOP_LINE_HEIGHT;
		lblNewLabel_4.setLayoutData(gd_lblNewLabel_4);
		
		CLabel lblNewLabel_3 = new CLabel(composite_line, SWT.NONE);
		lblNewLabel_3.setBackground(UIResourceStyle.COLOR_LINE_TOP);
		GridData gd_lblNewLabel_3 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_lblNewLabel_3.heightHint = UIResourceStyle.SIZE_TOP_LINE_HEIGHT;
		lblNewLabel_3.setLayoutData(gd_lblNewLabel_3);
		
		CLabel lblNewLabel_5 = new CLabel(composite_line, SWT.NONE);
		lblNewLabel_5.setBackground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
		GridData gd_lblNewLabel_5 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_5.widthHint = UIResourceStyle.SIZE_TOP_LINE_SPACING;
		gd_lblNewLabel_5.heightHint = UIResourceStyle.SIZE_TOP_LINE_HEIGHT;
		lblNewLabel_5.setLayoutData(gd_lblNewLabel_5);
		
		compStepView_ = new CompStepView(shell, SWT.NONE,this);
		GridData gd_compStepView_ = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 5);
		gd_compStepView_.widthHint = UIResourceStyle.SIZE_STEPVIEW_WIDTH;
		compStepView_.setLayoutData(gd_compStepView_);
		
		CLabel lblNewLabel = new CLabel(shell, SWT.NONE);
		lblNewLabel.setBackground(UIResourceStyle.COLOR_LINE_SEPARATED);
		GridData gd_lblNewLabel = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 5);
		gd_lblNewLabel.widthHint = 1;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		
		compTopView_ = new CompTopView(shell, SWT.NONE);
		GridData gd_compTopView_ = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_compTopView_.heightHint = UIResourceStyle.SIZE_TOPVIEW_HEIGHT;
		compTopView_.setLayoutData(gd_compTopView_);
		
		CLabel lblNewLabel_1 = new CLabel(shell, SWT.NONE);
		lblNewLabel_1.setBackground(UIResourceStyle.COLOR_LINE_SEPARATED);
		GridData gd_lblNewLabel_1 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblNewLabel_1.heightHint = 1;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		
		compDetailView_ = new CompDetailView(shell, SWT.NONE,this,compTopView_);
		compDetailView_.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		CLabel lblNewLabel_2 = new CLabel(shell, SWT.NONE);
		lblNewLabel_2.setBackground(UIResourceStyle.COLOR_LINE_SEPARATED);
		GridData gd_lblNewLabel_2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblNewLabel_2.heightHint = 1;
		lblNewLabel_2.setLayoutData(gd_lblNewLabel_2);
		
		compBottomView_ = new CompBottomView(shell, SWT.NONE);
		
		
		compBottomView_.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		

	}
	
	public void goToStep(int currentStep) {

		switch (currentStep) {
		
		case 0:
			
			compDetailView_.goToUnitTests();
			break;
		
		case 1:
			compDetailView_.goToFunctionalTest();
			break;

		case 2:
			compDetailView_.goToDailyRelease();
			break;
		
		case 3:
			compDetailView_.goToBacon();
			break;

		default:
			compTopView_.setTopLabel(MessageManager.getString("TOP_UNIT"));
			compDetailView_.goToUnitTests();
			break;
		}
	}

}
