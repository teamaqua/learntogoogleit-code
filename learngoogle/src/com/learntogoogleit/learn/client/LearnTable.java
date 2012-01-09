package com.learntogoogleit.learn.client;

import java.util.Vector;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class LearnTable extends LearnText {

	protected Vector<LearnItem> item_list;
	
	protected LearnManager manager;
	
	public LearnTable() {
		item_list = new Vector<LearnItem>();
	}
	
	public void addLearnItem(LearnItem item) {
		item_list.add(item);
	}
	
	public Widget getLearnWidget(LearnManager manager) {
		this.manager = manager;
		
		FlexTable table = new FlexTable();
		
		table.setText(0, 0, "Function");
		table.setText(0, 1, "Symbol");
		table.setText(0, 2, "Description");
		table.setText(0, 3, "See Example");
		table.setText(0, 4, "Insert Into Search");
		table.getRowFormatter().addStyleName(0, "tabletitle");
		
		for (int i = 0; i < item_list.size(); i++) {
			LearnItem item = item_list.get(i);
			table.setText(i + 1, 0, item.name);
			table.setHTML(i + 1, 1, "<b>" + item.function + "</b>");
			table.setHTML(i + 1, 2, item.description);
			/**
			 * Set up the buttons and stack them one on 
			 * top of another.
			 */			
			Button example_search_button = new Button("Example", new ClickHandler() {
				public void onClick(ClickEvent event) {
					//Executes an example search
					Widget source_object = (Widget)event.getSource();
					String example_search = source_object.getTitle();
					exampleSearch(example_search);
				}
			});//close new Button
			example_search_button.setTitle(item.example_search);
			
			Button insert_command_button = new Button("Insert", new ClickHandler() {
				public void onClick(ClickEvent event) {
					//Insert the command into the search box.
					Widget source_object = (Widget)event.getSource();
					String insert_command = source_object.getTitle();
					insertIntoSearch(insert_command);
				}
			});//close new Button
			insert_command_button.setTitle(item.insert_command);
			
			table.setWidget(i + 1, 3, example_search_button);
			table.setWidget(i + 1, 4, insert_command_button);
			
			if (((i + 1) % 2) == 0) {
				table.getRowFormatter().addStyleName(i + 1, "evenrow"); 
			}
			
		}//close for loop
		
		table.setStylePrimaryName("learntable");
		table.setCellSpacing(0);
		
		return table;
	}
	
	public void exampleSearch(String example) {
		example = com.google.gwt.http.client.URL.encodeQueryString(example);
		com.google.gwt.user.client.Window.open(manager.search_query_url + example, "_blank", "height=500,width=750,menubar=1,scrollbars=1,resizable=1");
	}
	
	public void insertIntoSearch(String insert) {
		if (insert.startsWith("http://")) {
			com.google.gwt.user.client.Window.open(insert, "_blank", "height=500,width=750,menubar=1,scrollbars=1,resizable=1");
		}
		else {
			String original_text = manager.search.getText();
			manager.search.setText(original_text + " " + insert + " ");
		}
	}
	
}//end file