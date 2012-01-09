package com.learntogoogleit.learn.client;

import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTML;
import java.util.Vector;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;


/**
 * This class is responsible for managing the display of 
 * all objects and the configuration for Google/Bing display.
 * 
 * Builder objects are responsible for configuring the manager 
 * with the appropriate tabs.
 * 
 * @author Vinny
 *
 */
public class LearnManager {

	/** The url to the search service's search. Must be the 
	 * entire search url except for the search terms.
	 */
	public String search_query_url;
	
	/** The name of the search service help being displayed, either Google or Bing. **/
	String search_name;
	
	/** Stores LearnTab objects to be displayed. **/
	Vector<LearnTab> tab_list;
	
	/** The search box. **/
	public TextBox search;
	
	/**
	 * Constructor.
	 * 
	 * @param search_engine_name The name of the search engine. Either Bing or Google.
	 * @param url The search url of the engine.
	 */
	public LearnManager(String search_engine_name, String url) {
		search_query_url = url;
		search_name = search_engine_name;
		tab_list = new Vector<LearnTab>();
	}
	
	/**
	 * Add a LearnTab to be displayed.
	 * 
	 * @param tab A LearnTab object to be displayed.
	 */
	public void addLearnTab(LearnTab tab) {
		tab_list.add(tab);
	}	
	
	/**
	 * Executes a search for the text located in the search box.
	 */
	public void executeSearch() {
		String search_encode = com.google.gwt.http.client.URL.encodeQueryString(search.getText());
		com.google.gwt.user.client.Window.open(search_query_url + search_encode, "_blank", "height=500,width=750,menubar=1,scrollbars=1,resizable=1");
	}
	
	/**
	 * Sets up the entire display.
	 * 
	 * @return A Widget that represents the entire display.
	 */
	public Widget setupDisplay() {		
		//For now we'll just set up the basics
		String banner_html = "learn to ";
		banner_html += "<img src=\"" + search_name.toLowerCase() + "logo.png\" alt=\"" + search_name + "\" />";
		banner_html += " it";
		HTML banner = new HTML(banner_html);
		banner.setStyleName("banner");
		
		
		search = new TextBox();
		search.setMaxLength(300);
		search.setVisibleLength(75);
		search.addKeyDownHandler(new KeyDownHandler(){
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == com.google.gwt.event.dom.client.KeyCodes.KEY_ENTER) {
					executeSearch();
				}
		}});
		
		Button search_button = new Button(search_name + " Search", new ClickHandler() {
			public void onClick(ClickEvent event) {
				executeSearch();
			}
		});//close new Button
		
		FlowPanel search_panel = new FlowPanel();
		search_panel.add(banner);
		search_panel.add(search);
		search_panel.add(search_button);
		search_panel.add(new Label("select a tab below for more information"));
		search_panel.setStyleName("searchpanel");
		
		//Set up the tabs
		TabLayoutPanel tab_panel = new TabLayoutPanel(2.5, com.google.gwt.dom.client.Style.Unit.EM);
		
		for (int i = 0; i < tab_list.size(); i++) {
			LearnTab tab = (LearnTab)tab_list.get(i);
			tab_panel.add(tab.getTabWidget(this), tab.getTabName());
		}
		
		String bottom_html = "This web site is NOT AFFILIATED with Microsoft Bing or Google. Written by Vinny A.";
		Anchor github = new Anchor("Visit this project's GitHub page at https://github.com/teamaqua/learntogoogleit.", "https://github.com/teamaqua/learntogoogleit");
		String email = "Comments, questions, feedback? Email me at vinny@firmstats.com";
		
		FlowPanel bottom_panel = new FlowPanel();
		bottom_panel.add(new HTML(bottom_html));
		bottom_panel.add(github);
		bottom_panel.add(new HTML(email));
		bottom_panel.setStyleName("bottom");
		
		
		FlowPanel display = new FlowPanel();
		display.add(search_panel);
		display.add(tab_panel);
		display.add(bottom_panel);
		
		return display;
	}
	
}