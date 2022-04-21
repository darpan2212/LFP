package com.bl.employee.model;

import com.opencsv.bean.CsvBindByName;

public class SampleModel {

	@CsvBindByName
	public int Year;

	@CsvBindByName
	public String Industry_aggregation_NZSIOC;

	@CsvBindByName
	public 	String Industry_code_NZSIOC;

	@CsvBindByName
	public 	String Industry_name_NZSIOC;

	@CsvBindByName
	public 	String Units;

}