package com.paypal;

import java.util.regex.Pattern;

public class HtmlFormatter {
	private static Pattern patternStrong = Pattern.compile("^[A-Z]+[a-zA-Z]*");
	private static Pattern patternHref = Pattern.compile("https://[a-z]+.(com|ly|org)/[a-z]*");;
	private static Pattern patternTwitterUsername = Pattern.compile("@[a-zA-z]+[a-zA-Z0-9]*");
	private static String getTag(String word) {
		String result = word;
		boolean isHref = patternHref.matcher(word).matches();
		boolean isStrong = patternStrong.matcher(word).matches();
		boolean isTwitter = patternTwitterUsername.matcher(word).matches();
		if(isStrong) 
			result = "<strong>"+word+"</strong>";
		else if(isHref)
			result = "<a href=\""+word+"\">"+word+"</a>";
		else if(isTwitter) {
			word = word.replace("@", "");
			result = "<a href=\"http://twitter.com/"+word+"\">"+word+"</a>";
		}
		return result;	
	}
	public static String doFormat(String text) {
		String html = "";
		String[] words = text.split("\\s+");
		for (String word : words) {
			html += " "+ getTag(word);
		}
		return html;
	}
}
