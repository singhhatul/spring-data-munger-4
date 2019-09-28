package com.stackroute.datamunger.query;

import java.util.Arrays;

public class Header {

	private String[] header;

	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the headers and should override toString() method as well.
	 */

	public Header(String[] header) {
		this.header = header;
	}

	public String[] getHeaders() {
		return header;
	}
	public void setHeaders(String[] header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "Header{" +
				"header=" + Arrays.toString(header) +
				'}';
	}
}
