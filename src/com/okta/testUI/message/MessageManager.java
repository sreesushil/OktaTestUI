package com.okta.testUI.message;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
public class MessageManager {
		try {
	public static String bind(String key,Object[] args){
		return MessageFormat.format(getString(key), args);
	}
}