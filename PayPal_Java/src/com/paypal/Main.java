package com.paypal;

public class Main {
	public static void main(String[] args) {
		System.out.println(HtmlFormatter.doFormat("Obama visited Facebook headquarters: https://bit.org/xyz @user12 3"));
	}
}

/*
 * Input : “Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile”
 * 
 * 
 * Output : 
 * <strong>Obama</strong> visited <strong>Facebook</strong>
 * headquarters: <a href="https://bit.ly/xyz">https://bit.ly/xyz</a> <a
 * href="http://twitter.com/elversatile">elversatile</a>
 * 
 * 
 */