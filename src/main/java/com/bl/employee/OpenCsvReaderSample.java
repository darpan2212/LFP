package com.bl.employee;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.bl.employee.model.EmpModel;
import com.bl.employee.model.SampleModel;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class OpenCsvReaderSample {

	public static String CSV_FILE_PATH = "D:\\Darpan\\LFP_112\\sample.csv";

	public void readBeanModel() {

		try {
			Reader reader = Files.newBufferedReader(
					Paths.get(CSV_FILE_PATH));

			CSVReader csvReader = new CSVReader(reader);

			CsvToBean<SampleModel> csvToBean = new CsvToBeanBuilder<SampleModel>(
					csvReader).withType(SampleModel.class)
							.withIgnoreLeadingWhiteSpace(
									true)
							.build();

			Iterator<SampleModel> sampleItr = csvToBean
					.iterator();

			while (sampleItr.hasNext()) {
				SampleModel model = sampleItr.next();
				System.out
						.println("YEAR : " + model.Year);
				System.out.println(
						"Aggregation : " + model.Industry_aggregation_NZSIOC);
				System.out.println(
						"Code : " + model.Industry_code_NZSIOC);
				System.out.println("Name : "
						+ model.Industry_name_NZSIOC);
				System.out.println("Units : "
						+ model.Units);
				System.out.println(
						"--------------------------------");
			}
			csvReader.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		OpenCsvReaderSample csvReader = new OpenCsvReaderSample();

		csvReader.readBeanModel();

	}
}