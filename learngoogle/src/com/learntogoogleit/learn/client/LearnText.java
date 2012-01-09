package com.learntogoogleit.learn.client;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTML;

public class LearnText {

	/** This variable stores text for display. Usually this text will be an 
	 * explanatory paragraph or two regarding the search options listed.
	 */
	public String text;
	
	public LearnText(String content) {
		text = content;
	}
	
	public LearnText() {
		text = " ";
	}
	
	public Widget getLearnWidget(LearnManager manager) {
		HTML display = new HTML(text);
		display.setStylePrimaryName("learntext");
		return display;
	}
	
}
