package br.com.involves.filereader.interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import br.com.involves.dto.Cidade;

public abstract class AbstractFileReader {

	public BufferedReader reader(String filePath) throws FileNotFoundException {

		File file = new File(filePath.toString());
		InputStream inputStream = new FileInputStream(file);
		return new BufferedReader(new InputStreamReader(inputStream));

	}
	
	public abstract List<Cidade> process(String filePath) throws FileNotFoundException;
}
