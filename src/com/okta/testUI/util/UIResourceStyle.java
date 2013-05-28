package com.okta.testUI.util;

import java.io.InputStream;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;


public class UIResourceStyle {

	public static final Image IMAGE_OKTA_LOGO = getImage(UIResourceStyle.class, "/com/okta/testUI/resources/OKTA.png");
	public static final Image IMAGE_TITLE_ICO = getImage(UIResourceStyle.class, "/com/okta/testUI/resources/OKTA_title1.png");
	public static final Image IMAGE_OKTA_FILE =  getImage(UIResourceStyle.class, "/com/okta/testUI/resources/file.gif");
	public static final Image IMAGE_OKTA_DIRECTORY =  getImage(UIResourceStyle.class, "/com/okta/testUI/resources/directory.gif");

	public static final Color COLOR_BACKGROUND_RIGHT = getColor(51, 51, 51);
	public static final Color COLOR_BACKGROUND_LEFT = getColor(121, 121, 121);
	public static final Color COLOR_LINE_TOP = getColor(20,160,230);
	public static final Color COLOR_LINE_SEPARATED = getColor(93, 93, 93);
	
	public static final Color[] COLOR_TREE_ONCHECK = { getColor(56, 112, 184), getColor(63, 177, 228) };
	public static final Color FONTCOLOR_WHITE = getColor(SWT.COLOR_WHITE);

	public static final Font FONT_TITLE_1 = getFont("Segoe UI", 16, SWT.BOLD);
	public static final Font FONT_TITLE_2 = getFont("Segoe UI", 13, SWT.NORMAL);
	public static final Font FONT_CONTENT_1 = getFont("Segoe UI", 12, SWT.BOLD);
	public static final Font FONT_CONTENT_2 = getFont("Segoe UI", 10, SWT.BOLD);
//	public static final Font FONT_CONTENT_3 = getFont("Segoe UI", 10, SWT.NORMAL);
	public static final Font FONT_TREE = getFont("Segoe UI", 10, SWT.BOLD);

	public static final int SIZE_DISPLAY_X = 800;
	public static final int SIZE_DISPLAY_Y = 600;
	public static final int SIZE_DISPLAY_SPACING_LEFT = 80;
	public static final int SIZE_DISPLAY_SPACING_TOP = 50;
	public static final int SIZE_TOP_LINE_SPACING = 16;
	public static final int SIZE_TOP_LINE_HEIGHT = 8;
	public static final int SIZE_VIEW_MARGIN_SPACING = 10;
	public static final int SIZE_STEPVIEW_WIDTH = 140;
	public static final int SIZE_TOPVIEW_HEIGHT = 77;
	public static final int SIZE_STEPVIEW_LOGO_SPACING_LEFT = SIZE_TOP_LINE_SPACING - 4;
	public static final int SIZE_STEPVIEW_LOGO_HEIGHT = 78;
	public static final int SIZE_STEPVIEW_LABEL_HEIGHT = 35;
	public static final int SIZE_BUTTONVIEW_BTN_WIDTH = 80;
	public static final int SIZE_OPTIONVIEW_LBL_INSTALLPATH_WIDTH = 150;
	public static final int SIZE_OPTIONVIEW_LBL_LEFT_WIDTH = 130;
	public static final int SIZE_OPTIONVIEW_LBL_RIGHT_WIDTH = 100;
	public static final int SIZE_OPTIONVIEW_TEXT_WIDTH = 100;
	public static final int SIZE_OPTIONVIEW_BTN_OPENFILE_WIDTH = 30;

	public static Color getColor(int swtColorID) {
		Display display = Display.getCurrent();
		return display.getSystemColor(swtColorID);
	}

	public static Color getColor(int r, int g, int b) {
		Display display = Display.getCurrent();
		Color color = new Color(display, new RGB(r, g, b));
		return color;
	}

	public static Font getFont(String name, int height, int style) {
		Font font = new Font(Display.getCurrent(), name, height, style);
		return font;
	}

	private static Image getImage(Class<?> clazz, String path) {
		InputStream stream = clazz.getResourceAsStream(path);
		try {
			Display display = Display.getCurrent();
			ImageData imageData = new ImageData(stream);
			if (imageData.transparentPixel > 0) {
				return new Image(display, imageData, imageData.getTransparencyMask());
			}
			return new Image(display, imageData);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		} finally {
			try {
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}