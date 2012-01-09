package com.learntogoogleit.learn.client;

public class BingBuilder extends GoogleBuilder {
	
	LearnManager manager;

	public BingBuilder() {
		manager = new LearnManager("Bing", "http://www.bing.com/search?q=");
	}
	
	public void setup() {		
		/** The basics tab. **/
		
		LearnItem and = new LearnItem();
		and.name = "Include Word";
		and.function = "+";
		and.description = "Includes a specified word in your search. Bing will search the term verbatim, as given. For example, <b>+labtop</b> searches for the word <b>labtop</b>, otherwise Bing would autocorrect to <b>laptop</b>.";
		and.example_search = "+labtop";
		and.insert_command = "+insert_word_here";
		
		LearnItem or = new LearnItem();
		or.name = "One Or More Words";
		or.function = "OR";
		or.description = "Searches for one or more words. For example, searching for <b>dollar OR euro</b> returns pages with the word <b>dollar</b>, or the word <b>euro</b>, or both words.";
		or.example_search = "dollar OR euro";
		or.insert_command = "word_to_search_for OR another_word";
		
		LearnItem exclude = new LearnItem();
		exclude.name = "Exclude Word";
		exclude.function = "-";
		exclude.description = "Removes web pages containing a specific word from the search results. Example: searching for <b>banana -fruit</b> searches for web pages containing the word <b>banana</b>, but then removes all pages that also contain the word <b>fruit</b>.";
		exclude.example_search = "banana -fruit";
		exclude.insert_command = "word_to_search_for -word_not_to_search_for";
		
		LearnItem phrase = new LearnItem();
		phrase.name = "Phrase Search";
		phrase.function = "\"a phrase goes here\"";
		phrase.description = "Searches for a phrase exactly as given. Useful if searching for song lyrics or other phrase-style searches.";
		phrase.example_search = "\"in the nick of time\"";
		phrase.insert_command = "\"insert phrase to search for here\"";
		
		LearnTable basics_table = new LearnTable();
		basics_table.addLearnItem(and);
		basics_table.addLearnItem(or);
		basics_table.addLearnItem(exclude);
		basics_table.addLearnItem(phrase);
		
		LearnTab basics_tab = new LearnTab("Basics");
		basics_tab.addLearnText(basics_table);
		
		manager.addLearnTab(basics_tab);
		
		/** The search limiters tab. **/
		
		LearnItem site = new LearnItem();
		site.name = "Site Search";
		site.function = "site:";
		site.description = "Searches the given site. Useful if you want to search a site that doesn't have a search ability. For example, a search for <b>apple site:wikipedia.org</b> searches Wikipedia for the word apple.";
		site.example_search = "apple site:wikipedia.org";
		site.insert_command = "site:address";
		
		LearnItem title = new LearnItem();
		title.name = "Title Search";
		title.function = "intitle:";
		title.description = "Searches for web pages with the specified word in the title bar.";
		title.example_search = "intitle:youtube";
		title.insert_command = "intitle:word_in_title";
		
		LearnItem filetype = new LearnItem();
		filetype.name = "File Search";
		filetype.function = "filetype:";
		filetype.description = "Searches for a certain file type. Searching for <b>filetype:pdf</b> will search for PDF files, while a search for <b>dollar filetype:doc</b> will search for Microsoft Word (.doc) files relating to the word dollar.";
		filetype.example_search = "dollar filetype:pdf";
		filetype.insert_command = "filetype:file_extension";
		
		LearnTable limiter_table = new LearnTable();
		limiter_table.addLearnItem(site);
		limiter_table.addLearnItem(title);		
		limiter_table.addLearnItem(filetype);
		
		LearnText limiter_text = new LearnText("Keep in mind that no spaces are allowed between an operator and the subject; for example <b>site:google.com</b> is valid, but <b>site: google.com</b> is not valid. Also, you can combine multiple operators and search terms. For example, searching for <b>economy filetype:pdf site:google.com</b> searches for PDF files located at google.com that contain the word economy.");
		
		LearnTab limiter_tab = new LearnTab("Search Limiters");
		limiter_tab.addLearnText(limiter_table);
		limiter_tab.addLearnText(limiter_text);
		
		manager.addLearnTab(limiter_tab);
		
		LearnItem add = new LearnItem();
		add.name = "Addition";
		add.function = "+";
		add.description = "Adds two numbers. For example, searching for <b>2 + 2</b> will give an answer of 4.";
		add.example_search = "2 + 2";
		add.insert_command = "number_here + number_here";
		
		LearnItem subtract = new LearnItem();
		subtract.name = "Subtraction";
		subtract.function = "-";
		subtract.description = "Subtracts one number from another. Searching for <b>6 - 2</b> will give you 4.";
		subtract.example_search = "6 - 2";
		subtract.insert_command = "number_here - number_here";
		
		LearnItem multiply = new LearnItem();
		multiply.name = "Multiply";
		multiply.function = "*";
		multiply.description = "Multiplies two numbers. Searching for <b>5 * 2</b> will give you 10.";
		multiply.example_search = "4 * 2";
		multiply.insert_command = "one_number * two_number";
		
		LearnItem divide = new LearnItem();
		divide.name = "Division";
		divide.function = "/";
		divide.description = "Divides two numbers. Searching for <b>12 / 2</b> will give you 6.";
		divide.example_search = "12 / 2";
		divide.insert_command = "one_number / two_number";
		
		LearnItem power = new LearnItem();
		power.name = "Power";
		power.function = "^";
		power.description = "Calculates the power of a number. <b>10 ^ 2</b> shows you 100.";
		power.example_search = "10 ^ 2";
		power.insert_command = "one_number ^ two_number";
		
		LearnItem conversions = new LearnItem();
		conversions.name = "Conversions";
		conversions.function = "to";
		conversions.description = "Bing offers many conversions, such as length, temperature, weight, and so forth. Try it out yourself by searching for <b>5 inches to cm</b>, <b>90 fahrenheit to celsius</b>, or <b>20 kg to pounds</b>.";
		conversions.example_search = "10 miles to km";
		conversions.insert_command = "measure to another_measure";
		
		LearnItem pi = new LearnItem();
		pi.name = "Constants";
		pi.function = "pi";
		pi.description = "Bing can show the value of several mathematical constants. For instance, try searching for <b>pi</b> or <b>e</b>.";
		pi.example_search = "pi";
		pi.insert_command = "pi";

		LearnItem solve = new LearnItem();
		solve.name = "Equation Solving";
		solve.function = "3x - 9 = 0";
		solve.description = "Bing can solve equations for you. For example, searching Bing for <b>3x - 9 = 0</b> returns the value x = 3.";
		solve.example_search = "3x - 9 = 0";
		solve.insert_command = "3x - 9 = 0";
		
		LearnTable math_table = new LearnTable();
		math_table.addLearnItem(add);
		math_table.addLearnItem(subtract);
		math_table.addLearnItem(multiply);
		math_table.addLearnItem(divide);
		math_table.addLearnItem(power);
		math_table.addLearnItem(conversions);
		math_table.addLearnItem(pi);
		math_table.addLearnItem(solve);
		
		LearnTab math_tab = new LearnTab("Math");
		math_tab.addLearnText(math_table);
		
		manager.addLearnTab(math_tab);
		
		LearnItem life = new LearnItem();
		life.name = "Answer To Life";
		life.function = "answer to life the universe and everything";
		life.description = "The answer to life, the universe, and everything, as given in The Hitchhiker's Guide to the Galaxy.";
		life.example_search = "answer to life the universe and everything";
		life.insert_command = "answer to life the universe and everything";

		LearnTable funny_table = new LearnTable();
		funny_table.addLearnItem(life);
		
		LearnTab funny_tab = new LearnTab("Funny");
		funny_tab.addLearnText(funny_table);
		
		manager.addLearnTab(funny_tab);
		
		LearnItem define = new LearnItem();
		define.name = "Define Word";
		define.function = "define:";
		define.description = "Returns the definition of a word. For example: if you need the definition of the word <b>eclipse</b>, you can search for <b>define:eclipse</b>.";
		define.example_search = "define:eclipse";
		define.insert_command = "define:word_to_be_defined";
		
		LearnItem weather = new LearnItem();
		weather.name = "Weather";
		weather.function = "weather:";
		weather.description = "Displays weather information. To use, search for weather: and then your location; for example <b>weather:orlando</b>.";
		weather.example_search = "weather:orlando";
		weather.insert_command = "weather:your_city";
		
		LearnItem stock = new LearnItem();
		stock.name = "Stock";
		stock.function = "stock:";
		stock.description = "Displays stock information. To use, type in stock: and then the stock ticker of choice, for example <b>stock:goog</b>.";
		stock.example_search = "stock:goog";
		stock.insert_command = "stock:stock_ticker_here";
		
		LearnTable tools_table = new LearnTable();
		tools_table.addLearnItem(define);
		tools_table.addLearnItem(weather);
		tools_table.addLearnItem(stock);
		
		LearnTab tools_tab = new LearnTab("Tools");
		tools_tab.addLearnText(tools_table);
		
		manager.addLearnTab(tools_tab);
		
		LearnItem tracker = new LearnItem();
		tracker.name = "Package Tracking";
		tracker.function = "tracking number";
		tracker.description = "Displays tracking information for a FedEx/UPS/USPS package. Simply search for the package's tracking number.";
		tracker.example_search = "1Z9999W99999999999";
		tracker.insert_command = "fedex/ups/usps tracking number";
		
		LearnItem time = new LearnItem();
		time.name = "Time";
		time.function = "time";
		time.description = "Displays the time in a given city. Example: <b>time orlando</b>.";
		time.example_search = "time orlando";
		time.insert_command = "time city_name";
		
		LearnItem spelling = new LearnItem();
		spelling.name = "Spelling";
		spelling.function = "misspelled word";
		spelling.description = "Bing can correct any misspelled words. Try searching Bing using a misspelled word, such as <b>draem</b> or <b>recieve</b>.";
		spelling.example_search = "draem";
		spelling.insert_command = "misspelled word here";
		
		LearnTable reference_table = new LearnTable();
		reference_table.addLearnItem(tracker);
		reference_table.addLearnItem(time);
		reference_table.addLearnItem(spelling);
		
		LearnTab reference_tab = new LearnTab("Reference");
		reference_tab.addLearnText(reference_table);
		
		manager.addLearnTab(reference_tab);
		
		LearnItem images = new LearnItem();
		images.name = "Images";
		images.function = "image";
		images.description = "Searches the web for images. To use, search for image and then what you're looking for; for example <b>image castle</b>. Also available at <b>bing.com/images</b>.";
		images.example_search = "image winnie the pooh";
		images.insert_command = "http://www.bing.com/images";
		
		LearnItem videos = new LearnItem();
		videos.name = "Videos";
		videos.function = "video";
		videos.description = "Searches the web for videos. To use, search for video and then what you're looking for; for example <b>video tangled</b>. Also available at <b>bing.com/videos</b>.";
		videos.example_search = "video tangled";
		videos.insert_command = "http://www.bing.com/videos";
		
		LearnItem maps = new LearnItem();
		maps.name = "Maps";
		maps.function = "map";
		maps.description = "Displays a map of the given address; just type an address into Bing. Also available at <b>bing.com/maps/</b>.";
		maps.example_search = "1 Microsoft Way, Redmond, WA 98052";
		maps.insert_command = "http://www.bing.com/maps/";
		
		LearnItem news = new LearnItem();
		news.name = "News";
		news.function = "news";
		news.description = "Displays news stories on a given subject. To see news stories about Apple Computer, you could search for <b>news apple</b>. Also available at <b>bing.com/news</b>.";
		news.example_search = "news france";
		news.insert_command = "http://www.bing.com/news";
		
		LearnItem shopping = new LearnItem();
		shopping.name = "Shopping";
		shopping.function = "buy";
		shopping.description = "Displays links on where to buy a given product. For example, if you wanted to buy a TV, you could search for <b>tv shopping</b>. Also available at <b>bing.com/shopping</b>.";
		shopping.example_search = "tv buy";
		shopping.insert_command = "http://www.bing.com/shopping";
		
		LearnTable other_table = new LearnTable();
		other_table.addLearnItem(images);
		other_table.addLearnItem(videos);
		other_table.addLearnItem(maps);
		other_table.addLearnItem(news);
		other_table.addLearnItem(shopping);
		
		LearnTab other_tab = new LearnTab("Other");
		other_tab.addLearnText(other_table);
		
		manager.addLearnTab(other_tab);
		
		/**
		 * 
		LearnItem include = new LearnItem();
		include.name;
		include.function;
		include.description;
		include.example_search;
		include.insert_command;
		 * 
		 * 
		 */
		
		
		
		
		
	}
	
	public LearnManager getLearnManager() {
		setup();
		return manager;
	}
	
}
