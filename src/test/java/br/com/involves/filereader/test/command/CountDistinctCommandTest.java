package br.com.involves.filereader.test.command;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.exception.InvalidCommandException;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.repository.CsvRepository;

public class CountDistinctCommandTest {

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
	public void CountDistinctCommmandIdTest() {
		executer.executeCommand("count distinct ibge_id");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandUfTest() {
	    executer.executeCommand("count distinct uf");
	    Assert.assertEquals("Total: 4", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandNomeTest() {
	    executer.executeCommand("count distinct name");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandCapitalTest() {
		executer.executeCommand("count distinct capital");
	    Assert.assertEquals("Total: 2", output.toString().trim());
	}

	@Test(expected = InvalidCommandException.class)
	public void CountDistinctCommandWithoutProperty() {
	    executer.executeCommand("count distinct");
	}

}
