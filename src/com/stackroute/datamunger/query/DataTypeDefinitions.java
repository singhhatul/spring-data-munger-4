package com.stackroute.datamunger.query;

import java.util.Arrays;

public class DataTypeDefinitions {

	private String[] dataType;
	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types and should override
	 * toString() method as well.
	 */
	public DataTypeDefinitions(String[] dataType) {
		this.dataType = dataType;
	}

	public String[] getDataTypes() {

		return dataType;
	}

	public void setDataTypes(String[] dataType) {
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return "DataTypeDefinitions{" +
				"dataType=" + Arrays.toString(dataType) +
				'}';
	}
}
