package com.learntogoogleit.learn.client;

import java.util.Vector;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlowPanel;

public class LearnTab {

	/** This String displays the name of the tab, to be
	 * displayed on top of the tab.
	 */
	String name;
	
	/** This Vector holds all the LearnText objects (and subclasses)
	 * that comprise a tab.
	 */
	Vector<LearnText> learn_list;
	
	public LearnTab(String tab_name) {
		learn_list = new Vector<LearnText>();
		name = tab_name;
	}
	
	public LearnTab() {
		learn_list = new Vector<LearnText>();
		name = " ";
	}
	
	public String getTabName() {
		return name;
	}
	
	public void addLearnText(LearnText learn_obj) {
		learn_list.add(learn_obj);
	}
	
	public Widget getTabWidget(LearnManager manager) {
		FlowPanel hold = new FlowPanel();
	
		for (int i = 0; i < learn_list.size(); i++) {
			LearnText learn_obj = (LearnText)learn_list.get(i);
			Widget learn_widget = learn_obj.getLearnWidget(manager);
			hold.add(learn_widget);
		}
		
		return hold;
	}
	
}//end file