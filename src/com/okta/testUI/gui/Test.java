package com.okta.testUI.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String[] command_args = new String[]{"/bin/bash","-c","mkdir ~/Desktop/test1/"};
		String[] command_args = new String[]{"/usr/bin/open","-a","/Applications/Utilities/Terminal.app"};
		
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
