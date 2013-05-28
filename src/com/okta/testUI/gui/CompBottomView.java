package com.okta.testUI.gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

import com.okta.testUI.message.MessageManager;
import com.okta.testUI.util.UIResourceStyle;


public class CompBottomView extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	private CLabel lblTop;
	
	public CompBottomView(Composite parent, int style) {
		super(parent, style);
		setBackground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.verticalSpacing = 0;
		setLayout(gridLayout);
		
		lblTop = new CLabel(this, SWT.NONE);
		lblTop.setFont(UIResourceStyle.FONT_TITLE_1);
		lblTop.setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		lblTop.setBackground(this.getBackground());
		lblTop.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		lblTop.setText(MessageManager.getString("DISPLAY_BOTTOM"));
		
	}

	public void setTopLabel(String top){
		lblTop.setText(top);
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
