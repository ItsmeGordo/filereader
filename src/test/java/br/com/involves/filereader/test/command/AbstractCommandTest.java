package br.com.involves.filereader.test.command;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.repository.CsvRepository;

public abstract class AbstractCommandTest {

	protected final ByteArrayOutputStream output = new ByteArrayOutputStream();
	CsvRepository repo;
    CommandExecuter executer;

	@Before
	public void init() {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv", "UTF-8");
		repo = csvReader.process(br);
		executer = new CommandExecuter(repo);
	    System.setOut(new PrintStream(output));

	}


}
