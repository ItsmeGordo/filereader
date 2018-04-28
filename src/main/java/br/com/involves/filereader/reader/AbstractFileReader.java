package br.com.involves.filereader.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.involves.filereader.repository.CsvRepository;

public abstract class AbstractFileReader {

	public BufferedReader reader(String fileName) {

		try {
			File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
			InputStream inputStream = new FileInputStream(file);
			return new BufferedReader(new InputStreamReader(inputStream));
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo mandado não foi encontrado");
			return null;
		}

	}
	
	public abstract CsvRepository process(BufferedReader br);
}
