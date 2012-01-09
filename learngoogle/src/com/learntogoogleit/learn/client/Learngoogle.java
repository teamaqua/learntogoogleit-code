package com.learntogoogleit.learn.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Learngoogle implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		/**
		 * Grab the value of the parameter search, see if a specific search engine is requested.
		 */
		
		String search = com.google.gwt.user.client.Window.Location.getParameter("search");
		
		GoogleBuilder builder = new GoogleBuilder();
		
		if (search == null) {
			//No search service specified. Default to Google
		}
		else if (search.startsWith("b")) {
			//Requesting the Bing search engine
			builder = new BingBuilder();
		}
		else {
			//Requesting the Google search engine
		}
		
		//Set up the LearnManager which handles everything else
		
		LearnManager manager = builder.getLearnManager();
		Widget display = manager.setupDisplay();

		RootLayoutPanel rp = RootLayoutPanel.get();
	    rp.add(display);
	    
	    //Everything has been set up. Now if no search engine was originally specified, we want to pop
	    //up a dialog asking the user what search engine help should be displayed.
	    if (search == null) {
	    	final DialogBox choose = new DialogBox(true, true);
	    	choose.setText("select a search engine to learn about");
	    	choose.setGlassEnabled(true);
	    	choose.setAnimationEnabled(true);
	    	
	    	Label intro = new Label("Need help with Google? Is Bing making you blue?");
	    	intro.setStyleName("introtext");
	    	//Label direction = new Label("select a search engine to learn about");
	    	
	    	PushButton google_button = new PushButton(new Image("/googlelogo.png"), new ClickHandler() {
				public void onClick(ClickEvent event) {
					choose.hide();
				}
			});//close new Button
	    	google_button.setTitle("Google");
	    	
	    	Image binglogo = new Image("binglogo.png");
	    	binglogo.setStylePrimaryName("binglogo");
	    	PushButton bing_button = new PushButton(binglogo, new ClickHandler() {
				public void onClick(ClickEvent event) {
					choose.hide();
					com.google.gwt.user.client.Window.Location.assign("http://www.learntogoogle.it/?search=bing");
				}
			});//close new Button
	    	bing_button.setTitle("Bing");
	    	
	    	HorizontalPanel button_hold = new HorizontalPanel();
	    	button_hold.add(google_button);
	    	button_hold.add(bing_button);
	    	
	    	Label disclaimer = new Label("This service is not affiliated with either Microsoft Bing or Google. Written by SVA.");
	    	disclaimer.setStyleName("disclaimer");
	    	
	    	FlowPanel hold = new FlowPanel();
	    	hold.add(intro);
	    	hold.add(button_hold);
	    	hold.add(disclaimer);
	    	hold.setStyleName("intro");
	    	choose.setWidget(hold);
	    	choose.center();
	    }//end if search == null
	    
	}//end entrypoint
	
}
