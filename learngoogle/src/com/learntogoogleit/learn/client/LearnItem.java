package com.learntogoogleit.learn.client;

public class LearnItem {
	
	/** Short description of this item, for example, Phrase or Site Search **/
	public String name;
	
	/** The function's usage in Google/Bing, for example " " or site:. **/
	public String function;
	
	/** A textual description of the function. **/
	public String description;
	
	/** An example search that can be inserted straight into Google/Bing, such as apple site:wikipedia.org. **/
	public String example_search;
	
	/** A command that will be inserted into the search box, such as "insert phrase here" or site:url. **/
	public String insert_command;
	
	public LearnItem() {
		name = "Name";
		function = "Function";
		description = "Description";
		example_search = "Example_Search";
		insert_command = "Insert_Command";
	}
	
	/**
	 * Sets Strings describing each part of the search function.
	 * 
	 * @param item_name A short description of the function.
	 * @param item_function Usage form, such as site:
	 * @param item_description A longer description of the search function
	 * @param item_example_search An example search to be shown.
	 * @param item_insert_command Inserted into the search box.
	 */
	public void setLearnDisplay(String item_name, String item_function, String item_description, String item_example_search, String item_insert_command) {
		name = item_name;
		function = item_function;
		description = item_description;
		example_search = item_example_search;
		insert_command = item_insert_command;
	}
	

}
