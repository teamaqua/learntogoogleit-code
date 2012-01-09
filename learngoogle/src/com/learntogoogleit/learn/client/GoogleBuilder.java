package com.learntogoogleit.learn.client;

public class GoogleBuilder {
	
	LearnManager manager;

	public GoogleBuilder() {
		manager = new LearnManager("Google", "http://www.google.com/search?q=");
	}
	
	public void setup() {		
		/** The basics tab. **/
		
		LearnItem include = new LearnItem();
		include.name = "Exact Word";
		include.function = "\"word\"";
		include.description = "Used to search for a word exactly as typed. Google will not offer any synonyms or autocorrect your search. For example, <b>\"labtop\"</b> searches for the word <b>labtop</b>, otherwise Google would autocorrect to <b>laptop</b>.";
		include.example_search = "\"labtop\"";
		include.insert_command = "\"insert word here\"";
		
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
		
		LearnItem synonym = new LearnItem();
		synonym.name = "Synonym Word";
		synonym.function = "~";
		synonym.description = "Searches for web pages containing synonyms to a given word. For example, searching for <b>~bird</b> will also return web pages about pets.";
		synonym.example_search = "~bird";
		synonym.insert_command = "~synonym";
		
		LearnItem wildcard = new LearnItem();
		wildcard.name = "Wildcard";
		wildcard.function = "*";
		wildcard.description = "Google replaces a wildcard with common words. A search for <b>Lord of the *</b> returns pages about <b>Lord of the Rings</b> and <b>Lord of the Flies</b>.";
		wildcard.example_search = "Lord of the *";
		wildcard.insert_command = "*";
		
		LearnTable basics_table = new LearnTable();
		basics_table.addLearnItem(include);
		basics_table.addLearnItem(or);
		basics_table.addLearnItem(exclude);
		basics_table.addLearnItem(phrase);
		basics_table.addLearnItem(synonym);
		basics_table.addLearnItem(wildcard);
		
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
		
		LearnItem address = new LearnItem();
		address.name = "Address Search";
		address.function = "inurl:";
		address.description = "Searches for web pages with the specified word in the address. For example, <b>inurl:video</b> returns video.google.com and cnn.com/video.";
		address.example_search = "inurl:video";
		address.insert_command = "inurl:word_in_address";
		
		LearnItem title = new LearnItem();
		title.name = "Title Search";
		title.function = "intitle:";
		title.description = "Searches for web pages with the specified word in the title bar.";
		title.example_search = "intitle:youtube";
		title.insert_command = "intitle:word_in_title";
		
		LearnItem text = new LearnItem();
		text.name = "Text Search";
		text.function = "intext:";
		text.description = "Searches for web pages with the specified word in the text of the web page";
		text.example_search = "intext:youtube";
		text.insert_command = "intext:word_in_page_text";
		
		LearnItem filetype = new LearnItem();
		filetype.name = "File Search";
		filetype.function = "filetype:";
		filetype.description = "Searches for a certain file type. Searching for <b>filetype:pdf</b> will search for PDF files, while a search for <b>dollar filetype:doc</b> will search for Microsoft Word (.doc) files relating to the word dollar.";
		filetype.example_search = "dollar filetype:pdf";
		filetype.insert_command = "filetype:file_extension";
		
		LearnItem number_range = new LearnItem();
		number_range.name = "Number Range";
		number_range.function = "number...number";
		number_range.description = "Searches within a number range. For example, searching for <b>$200...$600 apple</b> searches for Apple products that cost between $200 and $600.";
		number_range.example_search = "$200...$600 apple";
		number_range.insert_command = "number...number";
		
		LearnTable limiter_table = new LearnTable();
		limiter_table.addLearnItem(site);
		limiter_table.addLearnItem(address);
		limiter_table.addLearnItem(title);	
		limiter_table.addLearnItem(text);		
		limiter_table.addLearnItem(filetype);
		limiter_table.addLearnItem(number_range);
		
		LearnText limiter_text = new LearnText("Keep in mind that no spaces are allowed between an operator and the subject; for example <b>site:google.com</b> is valid, but <b>site: google.com</b> is not valid. Also, you can combine multiple operators and search terms. For example, searching for <b>economy filetype:pdf site:google.com</b> searches for PDF files located at google.com that contain the word economy.");
		
		LearnTab limiter_tab = new LearnTab("Search Limiters");
		limiter_tab.addLearnText(limiter_table);
		limiter_tab.addLearnText(limiter_text);
		
		manager.addLearnTab(limiter_tab);
		
		LearnItem cache = new LearnItem();
		cache.name = "View Cached Page";
		cache.function = "cache:";
		cache.description = "View Google's cached copy of a web page. For example, searching for <b>cache:apple.com</b> shows Google's copy of Apple Computer's home page.";
		cache.example_search = "cache:apple.com";
		cache.insert_command = "cache:site_address";
		
		LearnItem related = new LearnItem();
		related.name = "Related Site";
		related.function = "related:";
		related.description = "Shows related sites. For example, <b>related:amazon.com</b> returns links to Best Buy and eBay.";
		related.example_search = "related:amazon.com";
		related.insert_command = "related:site_address";
		
		LearnItem link = new LearnItem();
		link.name = "Sites Linking To";
		link.function = "link:";
		link.description = "Shows web pages linking to the given site.";
		link.example_search = "link:";
		link.insert_command = "link:site_address";
		
		LearnItem info = new LearnItem();
		info.name = "Page Information";
		info.function = "info:";
		info.description = "Offers information about the specified web page.";
		info.example_search = "info:youtube.com";
		info.insert_command = "info:site_address";
		
		LearnText page_info_text = new LearnText("No spaces are allowed between an operator and a site address. For example, <b>site:amazon.com</b> is acceptable, while <b>site: amazon.com</b> (note the space) is not valid.");
		
		LearnTable page_info_table = new LearnTable();
		page_info_table.addLearnItem(cache);
		page_info_table.addLearnItem(related);
		page_info_table.addLearnItem(link);
		page_info_table.addLearnItem(info);
		
		LearnTab page_info_tab = new LearnTab("Page Info");
		page_info_tab.addLearnText(page_info_table);
		page_info_tab.addLearnText(page_info_text);
		
		manager.addLearnTab(page_info_tab);
		
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
		conversions.description = "Google offers many conversions, such as length, temperature, weight, and so forth. Try it out yourself by searching for <b>5 inches to cm</b>, <b>90 fahrenheit to celsius</b>, or <b>20 kg to pounds</b>.";
		conversions.example_search = "10 miles to kilometers";
		conversions.insert_command = "measure to another_measure";
		
		LearnItem pi = new LearnItem();
		pi.name = "Constants";
		pi.function = "pi";
		pi.description = "Google can show the value of several mathematical constants. For instance, try searching for <b>pi</b> or <b>e</b>.";
		pi.example_search = "pi";
		pi.insert_command = "pi";

		LearnItem graph = new LearnItem();
		graph.name = "Graphing";
		graph.function = "x + 0";
		graph.description = "Google search can also graph functions. Try typing in a function into Google search, such as <b>2x</b>, <b>x + 3</b>, or <b>x^2</b>.";
		graph.example_search = "x^2 + 2";
		graph.insert_command = "1x + 4";
		
		LearnTable math_table = new LearnTable();
		math_table.addLearnItem(add);
		math_table.addLearnItem(subtract);
		math_table.addLearnItem(multiply);
		math_table.addLearnItem(divide);
		math_table.addLearnItem(power);
		math_table.addLearnItem(conversions);
		math_table.addLearnItem(pi);
		math_table.addLearnItem(graph);
		
		LearnTab math_tab = new LearnTab("Math");
		math_tab.addLearnText(math_table);
		
		manager.addLearnTab(math_tab);
		
		LearnItem life = new LearnItem();
		life.name = "Answer To Life";
		life.function = "answer to life the universe and everything";
		life.description = "The answer to life, the universe, and everything, as given in The Hitchhiker's Guide to the Galaxy.";
		life.example_search = "answer to life the universe and everything";
		life.insert_command = "answer to life the universe and everything";
		
		LearnItem lonely = new LearnItem();
		lonely.name = "Loneliest Number";
		lonely.function = "the loneliest number";
		lonely.description = "One is the loneliest number.";
		lonely.example_search = "the loneliest number";
		lonely.insert_command = "the loneliest number";
		
		LearnItem horn = new LearnItem();
		horn.name = "Unicorn Horn";
		horn.function = "the number of horns on a unicorn";
		horn.description = "The number of horns on a unicorn.";
		horn.example_search = "the number of horns on a unicorn";
		horn.insert_command = "the number of horns on a unicorn";
		
		LearnItem tilt = new LearnItem();
		tilt.name = "Tilt Page";
		tilt.function = "tilt";
		tilt.description = "Tilts the page slightly.";
		tilt.example_search = "tilt";
		tilt.insert_command = "tilt";
		
		LearnItem heart = new LearnItem();
		heart.name = "Heart Graph";
		heart.function = "(sqrt(cos(x))*cos(200*x)+sqrt(abs(x))-0.7)*(4-x*x)^0.2042";
		heart.description = "Displays a graph that looks like a heart.";
		heart.example_search = "(sqrt(cos(x))*cos(200*x)+sqrt(abs(x))-0.7)*(4-x*x)^0.2042, from -4.5 to 4.5";
		heart.insert_command = "(sqrt(cos(x))*cos(200*x)+sqrt(abs(x))-0.7)*(4-x*x)^0.2042, from -4.5 to 4.5";
		
		LearnTable funny_table = new LearnTable();
		funny_table.addLearnItem(life);
		funny_table.addLearnItem(lonely);
		funny_table.addLearnItem(horn);
		funny_table.addLearnItem(tilt);
		funny_table.addLearnItem(heart);
		
		LearnTab funny_tab = new LearnTab("Funny");
		funny_tab.addLearnText(funny_table);
		
		LearnItem define = new LearnItem();
		define.name = "Define Word";
		define.function = "define:";
		define.description = "Returns the definition of a word. For example: if you need the definition of the word <b>eclipse</b>, you can search for <b>define:eclipse</b>.";
		define.example_search = "define:eclipse";
		define.insert_command = "define:word_to_be_defined";
		
		LearnItem movie = new LearnItem();
		movie.name = "Movie Showtimes";
		movie.function = "movie:";
		movie.description = "Displays movie showtimes. To use, search for movie: and then your location; for example <b>movie:seattle</b>.";
		movie.example_search = "movie:seattle";
		movie.insert_command = "movie:your_city";
		
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
		tools_table.addLearnItem(movie);
		tools_table.addLearnItem(weather);
		tools_table.addLearnItem(stock);
		
		LearnTab tools_tab = new LearnTab("Tools");
		tools_tab.addLearnText(tools_table);
		
		manager.addLearnTab(tools_tab);
		
		LearnItem ip = new LearnItem();
		ip.name = "IP Address";
		ip.function = "ip";
		ip.description = "Displays your IP address.";
		ip.example_search = "ip";
		ip.insert_command = "ip";
		
		LearnItem tracker = new LearnItem();
		tracker.name = "Package Tracking";
		tracker.function = "tracking number";
		tracker.description = "Displays tracking information for a FedEx/UPS/USPS package. Simply search for the package's tracking number.";
		tracker.example_search = "1Z9999W99999999999";
		tracker.insert_command = "fedex/ups/usps tracking number";
		
		LearnItem sunrise = new LearnItem();
		sunrise.name = "Sunrise/Sunset";
		sunrise.function = "sunrise sunset";
		sunrise.description = "Displays the time of a sunrise and sunset for a given city. For example, try searching for <b>sunrise seattle</b> or <b>sunset london</b>.";
		sunrise.example_search = "sunrise paris";
		sunrise.insert_command = "sunrise city_name";
		
		LearnItem time = new LearnItem();
		time.name = "Time";
		time.function = "time";
		time.description = "Displays the time in a given city. Example: <b>time orlando</b>.";
		time.example_search = "time orlando";
		time.insert_command = "time city_name";
		
		LearnItem spelling = new LearnItem();
		spelling.name = "Spelling";
		spelling.function = "misspelled word";
		spelling.description = "Google can correct any misspelled words. Try searching Google using a misspelled word, such as <b>draem</b> or <b>recieve</b>.";
		spelling.example_search = "draem";
		spelling.insert_command = "misspelled word here";
		
		LearnItem population = new LearnItem();
		population.name = "Population Data";
		population.function = "population";
		population.description = "Displays population information for a state, county, or country. Also works for unemployment rate information. Example: <b>population france</b> or <b>unemployment rate illinois</b>.";
		population.example_search = "population wisconsin";
		population.insert_command = "population state, county, or country";
		
		LearnTable reference_table = new LearnTable();
		reference_table.addLearnItem(ip);
		reference_table.addLearnItem(tracker);
		reference_table.addLearnItem(sunrise);
		reference_table.addLearnItem(time);
		reference_table.addLearnItem(spelling);
		reference_table.addLearnItem(population);
		
		LearnTab reference_tab = new LearnTab("Reference");
		reference_tab.addLearnText(reference_table);
		
		manager.addLearnTab(reference_tab);
		
		LearnItem images = new LearnItem();
		images.name = "Images";
		images.function = "image";
		images.description = "Searches the web for images. To use, search for image and then what you're looking for; for example <b>image castle</b>. Also available at <b>images.google.com</b>.";
		images.example_search = "image winnie the pooh";
		images.insert_command = "http://images.google.com";
		
		LearnItem videos = new LearnItem();
		videos.name = "Videos";
		videos.function = "video";
		videos.description = "Searches the web for videos. To use, search for video and then what you're looking for; for example <b>video tangled</b>. Also available at <b>videos.google.com</b>.";
		videos.example_search = "video tangled";
		videos.insert_command = "http://videos.google.com";
		
		LearnItem maps = new LearnItem();
		maps.name = "Maps";
		maps.function = "map";
		maps.description = "Displays a map of the given address; just type an address into Google. Also available at <b>maps.google.com</b>.";
		maps.example_search = "1600 amphitheatre parkway mountain view ca";
		maps.insert_command = "http://maps.google.com";
		
		LearnItem news = new LearnItem();
		news.name = "News";
		news.function = "news";
		news.description = "Displays news stories on a given subject. To see news stories about Apple Computer, you could search for <b>news apple</b>. Also available at <b>news.google.com</b>.";
		news.example_search = "news france";
		news.insert_command = "http://news.google.com";
		
		LearnItem shopping = new LearnItem();
		shopping.name = "Shopping";
		shopping.function = "shopping";
		shopping.description = "Displays links on where to buy a given product. For example, if you wanted to buy a TV, you could search for <b>tv shopping</b>. Also available at <b>shopping.google.com</b>.";
		shopping.example_search = "tv shopping";
		shopping.insert_command = "http://shopping.google.com";
		
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
