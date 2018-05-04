package br.com.involves.filereader.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public abstract class AbstractFileReader {

	public BufferedReader reader(String fileName, String encoding) {

		try {
			File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
			InputStream inputStream = new FileInputStream(file);
			return new BufferedReader(new InputStreamReader(inputStream, encoding));
		} catch (NullPointerException | FileNotFoundException e) {
			System.out.println("O arquivo mandado não foi encontrado");
			return null;
		} catch (UnsupportedEncodingException e) {
			System.out.println("O encoding escolhido não é suportado");
			return null;
		}

	}
	
	public abstract List<Map<String, String>> process(BufferedReader br);
}
