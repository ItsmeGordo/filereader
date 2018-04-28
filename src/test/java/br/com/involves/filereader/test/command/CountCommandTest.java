package br.com.involves.filereader.test.command;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.repository.CsvRepository;

public class CountCommandTest {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
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

	@Test
	public void CountCommmandTest() {
		executer.executeCommand("count *");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

}
