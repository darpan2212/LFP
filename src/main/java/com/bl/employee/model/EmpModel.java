package com.bl.employee.model;

import com.opencsv.bean.CsvBindByName;

public class EmpModel {

	@CsvBindByName
	public int EmpId;

	@CsvBindByName
	public String EmpName;

	@CsvBindByName
	public double Salary;

	@CsvBindByName
	public String Designation;

	@Override
	public String toString() {
		return "EmpModel [EmpId=" + EmpId + ", EmpName="
				+ EmpName + ", Salary=" + Salary
				+ ", Designation=" + Designation + "]";
	}
}