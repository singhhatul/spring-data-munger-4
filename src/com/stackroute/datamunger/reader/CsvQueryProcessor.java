package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {
	String fileName;
	BufferedReader br = null;
	private DataTypeDefinitions Integer;

	/*
	 * Parameterized constructor to initialize filename. As you are trying to
	 * perform file reading, hence you need to be ready to handle the IO Exceptions.
	 */
	
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		br = new BufferedReader(new FileReader(fileName));
	}

	/*
	 * Implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 */

	@Override
	public Header getHeader() throws IOException {
		 br = new BufferedReader(new FileReader(fileName));
		String stringHeader = br.readLine();
		String[] column = stringHeader.split(",");
		Header header = new Header(column);
		return header;

	}

	/**
	 * This method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * Implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. In
	 * the previous assignment, we have tried to convert a specific field value to
	 * Integer or Double. However, in this assignment, we are going to use Regular
	 * Expression to find the appropriate data type of a field. Integers: should
	 * contain only digits without decimal point Double: should contain digits as
	 * well as decimal point Date: Dates can be written in many formats in the CSV
	 * file. However, in this assignment,we will test for the following date
	 * formats('dd/mm/yyyy',
	 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm
	 * -dd')
	 */
	
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		br = new BufferedReader(new FileReader(fileName));
		String words = br.readLine();
		words = br.readLine();
		String[] result = new String[18];
		String[] query = words.split(",");

		for (int i = 0; i < 17; i++) {
			if (query[i].matches("[0-9]+")) {
				result[i] = "java.lang.Integer";
			} else if (query[i].matches("[a-z A-Z]*")) {

				result[i] = "java.lang.String";
			} else if (query[i].matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {

				result[i] = "java.util.Date";
			} else if (query[i].matches("(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-[12]\\d{3}")) {

				result[i] = "java.util.Date";
			}
		}
		result[17] = "java.lang.Object";
		DataTypeDefinitions dataTypeDefinitions = new DataTypeDefinitions(result);
		dataTypeDefinitions.setDataTypes(result);
		dataTypeDefinitions.getDataTypes();
		return dataTypeDefinitions;
	}
	// checking for Integer

	// checking for floating point numbers

	// checking for date format dd/mm/yyyy

	// checking for date format mm/dd/yyyy

	// checking for date format dd-mon-yy

	// checking for date format dd-mon-yyyy

	// checking for date format dd-month-yy

	// checking for date format dd-month-yyyy

	// checking for date format yyyy-mm-dd

}
