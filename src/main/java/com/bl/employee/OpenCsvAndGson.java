package com.bl.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.bl.employee.model.EmployeeModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCsvAndGson {

	public static String CSV_PATH = "D:\\Darpan\\LFP_112\\employees.csv";
	public static String JSON_PATH = "D:\\Darpan\\LFP_112\\employees.json";

	public static void main(String[] args) {

		try {
			Reader reader = Files
					.newBufferedReader(Paths.get(CSV_PATH));

			CSVReader csvReader = new CSVReader(reader);

			CsvToBean<EmployeeModel> csvToBean = new CsvToBeanBuilder<EmployeeModel>(
					csvReader).withType(EmployeeModel.class)
							.withIgnoreLeadingWhiteSpace(
									true)
							.build();

			List<EmployeeModel> employeeData = csvToBean
					.parse();

//			employeeData.forEach(System.out::println);

			Gson gson = new GsonBuilder()
					.setPrettyPrinting().create();

			String jsonStr = gson.toJson(employeeData);

//			System.out.println(jsonStr);

			Files.write(Paths.get(JSON_PATH),
					jsonStr.getBytes());

			BufferedReader bufferReader = Files
					.newBufferedReader(
							Paths.get(JSON_PATH));

			EmployeeModel[] listOfEmp = gson.fromJson(
					bufferReader, EmployeeModel[].class);

			Arrays.asList(listOfEmp)
					.forEach(System.out::println);

			reader.close();
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}