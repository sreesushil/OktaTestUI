package com.okta.testUI.gui;

import java.io.IOException;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.okta.testUI.util.UIResourceStyle;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;




public class DetailBacon extends Composite{
	private Text text;
	private Table table;
	
	
	public DetailBacon(Composite parent, int style) {
		super(parent, style);		
		setBackground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
		setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		setLayout(new GridLayout(1, false));
		
		CLabel lblRunCommand = new CLabel(this, SWT.NONE);
		lblRunCommand.setText("C: (Type the command)");
		lblRunCommand.setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		lblRunCommand.setBackground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
		
		text = new Text(this, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSubmit = new Button(this, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executeCommand(text.getText());
			}
		});
		btnSubmit.setText("SUBMIT");
		
		CLabel lblRecentlyExecutedCommands = new CLabel(this, SWT.NONE);
		lblRecentlyExecutedCommands.setText("Recently Executed Commands");
		lblRecentlyExecutedCommands.setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		lblRecentlyExecutedCommands.setBackground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
	}
	
	private void executeCommand(String command){
		
		System.out.println(command);
		String[] command_args = new String[]{"/usr/bin/open","-n","/Applications/Utilities/Terminal.app"};
		
		ProcessBuilder builder = new ProcessBuilder(command_args);
		builder.redirectErrorStream(true);
		
		try {
			builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
