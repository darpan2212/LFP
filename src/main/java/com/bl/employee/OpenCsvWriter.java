package com.bl.employee;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.bl.employee.model.EmpModel;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCsvWriter {

	public static String CSV_FILE_PATH = "D:\\Darpan\\LFP_112\\emp_records.csv";

	public static void main(String[] args) {

		try {
			Writer writer = Files.newBufferedWriter(
					Paths.get(CSV_FILE_PATH));

			StatefulBeanToCsv<EmpModel> beanToCsv = new StatefulBeanToCsvBuilder<EmpModel>(
					writer).withQuotechar(
							CSVWriter.DEFAULT_QUOTE_CHARACTER)
							.build();

			List<EmpModel> empList = new ArrayList<>();
			
			EmpModel model = new EmpModel();

			model.EmpId = (int) (Math.random() * 900 + 100);
			model.EmpName = "Jack";
			model.Salary = 1200000;
			model.Designation = "Software Engineer";

			empList.add(model);

			model = new EmpModel();
			
			model.EmpId = (int) (Math.random() * 900 + 100);
			model.EmpName = "Mike";
			model.Salary = 1100000;
			model.Designation = "Product Manager";
			
			empList.add(model);
			
			
			
			beanToCsv.write(empList);
			System.out.println("Check the file");
			// to reflect in CSV file of written obj, writer.close() is must.
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}

	}

}