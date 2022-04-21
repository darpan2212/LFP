package com.bl.employee;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class OpenCsvReader {

	public static String CSV_FILE_PATH = "D:\\Darpan\\LFP_112\\empData.csv";

	public void readNext() {
		System.out.println("--------------op with readNext-------------");
		Path csvPath = Paths.get(CSV_FILE_PATH);
		try {
			Reader reader = Files
					.newBufferedReader(csvPath);

			CSVReader csvReader = new CSVReader(reader);

			String[] newRecords;
			try {
				while ((newRecords = csvReader
						.readNext()) != null) {
					System.out.println(
							"ID : " + newRecords[0]);
					System.out.println(
							"Name : " + newRecords[1]);
					System.out.println(
							"Salary : " + newRecords[2]);
					System.out.println("Designation : "
							+ newRecords[3]);
					System.out.println(
							"--------------------------------");
				}
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readAll() {
		System.out.println(
				"-------op with readAll------------");
		Path csvPath = Paths.get(CSV_FILE_PATH);
		try {
			Reader reader = Files
					.newBufferedReader(csvPath);

			CSVReader csvReader = new CSVReader(reader);

			try {
				List<String[]> records = csvReader
						.readAll();

				records.forEach(dataRow -> {
					System.out
							.println("ID : " + dataRow[0]);
					System.out.println(
							"Name : " + dataRow[1]);
					System.out.println(
							"Salary : " + dataRow[2]);
					System.out.println(
							"Designation : " + dataRow[3]);
					System.out.println(
							"--------------------------------");
				});
			} catch (CsvException e) {
				e.printStackTrace();
			}
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		OpenCsvReader csvReader = new OpenCsvReader();

		csvReader.readAll();

	}
}