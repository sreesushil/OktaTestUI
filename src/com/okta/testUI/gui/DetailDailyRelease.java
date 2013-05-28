package com.okta.testUI.gui;

import java.io.IOException;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;

import com.okta.testUI.util.UIResourceStyle;
import org.eclipse.swt.widgets.Label;


public class DetailDailyRelease extends Composite{
	
	private Composite composite;
	private Browser browser;
	private String defaultWikiURL = "https://oktawiki.atlassian.net/wiki/display/eng/Scheduled+Release+lifecycle#ScheduledReleaselifecycle-ContinuousReview(Timeframe:Daily)";
	private String baconURL= "http://tools02d.trex.saasure.com:8080/gateway";
	private String clusterBuildURL= "http://clusterbuild.trex.saasure.com:8080/view/Integration/";
	private String releaseJobURL= "http://ci-release.trex.saasure.com:8080/job/1.0-okta.release/";
	private String AssembleJobRUL = "http://jenkins-releng.trex.saasure.com:8080/job/assemble-full-release/";
	private String S3BucketURL = "https://oktawiki.atlassian.net/wiki/display/eng/Populate+Static+Artifacts+For+Trexcloud+Deploy";
	
	public DetailDailyRelease(final Composite parent, int style) {
		super(parent, style);
		
		setBackground(UIResourceStyle.COLOR_BACKGROUND_RIGHT);
		setForeground(UIResourceStyle.FONTCOLOR_WHITE);
		setLayout(new GridLayout(2, false));
		
		
		
		Button btnAllWindows = new Button(this, SWT.NONE);
		btnAllWindows.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] command_args = new String[]{"/usr/bin/open","-a","/Applications/Google Chrome.app",defaultWikiURL,baconURL,clusterBuildURL,releaseJobURL,AssembleJobRUL,S3BucketURL};
				
				ProcessBuilder builder = new ProcessBuilder(command_args);
				builder.redirectErrorStream(true);
						
				try {
					builder.start();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnAllWindows.setText("All Windows");
		
		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 8));
		
		Rectangle rect = composite.getBounds();
		browser = new Browser(composite, SWT.NONE);
	    //browser.setBounds(0,0,rect.width,rect.height);
		browser.setBounds(0,0,1200,1024);
	    
	    browser.setUrl("https://oktawiki.atlassian.net/wiki/display/eng/Scheduled+Release+lifecycle#ScheduledReleaselifecycle-ContinuousReview(Timeframe:Daily)");
		
		Button btnWiki = new Button(this, SWT.NONE);
		btnWiki.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnWiki.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("https://oktawiki.atlassian.net/wiki/display/eng/Scheduled+Release+lifecycle#ScheduledReleaselifecycle-ContinuousReview(Timeframe:Daily)");
			}
		});
		btnWiki.setText("Wiki");
	    
		Button btnBacon = new Button(this, SWT.NONE);
		btnBacon.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnBacon.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://tools02d.trex.saasure.com:8080/gateway");
			}
		});
		btnBacon.setText("Bacon");
		
		Button btnCluster = new Button(this, SWT.NONE);
		btnCluster.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnCluster.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://clusterbuild.trex.saasure.com:8080/view/Integration/");
			}
		});
		btnCluster.setText("ClusterBuild");
		
		Button btnReleasej = new Button(this, SWT.NONE);
		btnReleasej.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnReleasej.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://ci-release.trex.saasure.com:8080/job/1.0-okta.release/");
			}
		});
		btnReleasej.setText("ReleaseJ");
		
		Button btnAssembleRJ = new Button(this, SWT.NONE);
		btnAssembleRJ.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAssembleRJ.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://jenkins-releng.trex.saasure.com:8080/job/assemble-full-release/");
			}
		});
		btnAssembleRJ.setText("AssembleRJ");
		new Label(this, SWT.NONE);
		
		Button btnS3buckt = new Button(this, SWT.NONE);
		btnS3buckt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("https://oktawiki.atlassian.net/wiki/display/eng/Populate+Static+Artifacts+For+Trexcloud+Deploy");
			}
		});
		btnS3buckt.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		btnS3buckt.setText("S3 Bucket");
		

	}
}
