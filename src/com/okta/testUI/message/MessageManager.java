package com.okta.testUI.message;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
public class MessageManager {	private static final String BUNDLE_NAME = "com.okta.testUI.message.messages"; 	private static ResourceBundle RESOURCE_BUNDLE =ResourceBundle.getBundle(BUNDLE_NAME);	public static String getString(String key) {
		try {			return RESOURCE_BUNDLE.getString(key);		} catch (MissingResourceException e) {			return "Message not defined";		}	}
	public static String bind(String key,Object[] args){
		return MessageFormat.format(getString(key), args);
	}
}
