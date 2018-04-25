package br.com.involves.filereader;

import java.io.BufferedReader;

import org.junit.Test;

public class CSVReaderTest {

	@Test
	public void readerTest() {
		CSVReader csvReader = new CSVReader();
		try {
			BufferedReader br = csvReader.reader("/filereader/src/main/resources/cidades.csv");
			System.out.println(br.readLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
