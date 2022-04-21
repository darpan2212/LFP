package com.bl.employee.model;

import com.opencsv.bean.CsvBindByName;

public class EmployeeModel {
	@CsvBindByName
	public int EMPLOYEE_ID;
	
	@CsvBindByName
	public String FIRST_NAME;
	
	@CsvBindByName
	public String LAST_NAME;
	
	@CsvBindByName
	public String EMAIL;
	
	@CsvBindByName
	public String PHONE_NUMBER;
	
	@CsvBindByName
	public String HIRE_DATE;
	
	@CsvBindByName
	public String JOB_ID;
	
	@CsvBindByName
	public int SALARY;
	
	@CsvBindByName
	public int MANAGER_ID;
	
	@CsvBindByName
	public int DEPARTMENT_ID;

	@Override
	public String toString() {
		return "EmployeeModel [EMPLOYEE_ID=" + EMPLOYEE_ID
				+ ", FIRST_NAME=" + FIRST_NAME
				+ ", LAST_NAME=" + LAST_NAME + ", EMAIL="
				+ EMAIL + ", PHONE_NUMBER=" + PHONE_NUMBER
				+ ", HIRE_DATE=" + HIRE_DATE + ", JOB_ID="
				+ JOB_ID + ", SALARY=" + SALARY
				+ ", MANAGER_ID=" + MANAGER_ID
				+ ", DEPARTMENT_ID=" + DEPARTMENT_ID + "]";
	}
}
